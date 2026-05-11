package org.example.Concurrency.AtomicClasses;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

/**
 * ============================================================
 *        JAVA ATOMIC CLASSES — COMPLETE GUIDE
 * ============================================================
 *
 * Atomic classes provide thread-safe operations on single variables
 * WITHOUT synchronization overhead. Based on CAS (Compare-And-Swap).
 *
 * MAIN CLASSES (java.util.concurrent.atomic):
 * ─────────────────────────────────────────────
 *   AtomicInteger, AtomicLong, AtomicBoolean, AtomicReference<V>
 *   AtomicIntegerArray, AtomicLongArray, AtomicReferenceArray
 *   AtomicStampedReference  → reference + stamp (version counter)
 *   AtomicMarkableReference → reference + boolean mark
 *   LongAdder, LongAccumulator → high-contention counters (Java 8+)
 *
 * KEY OPERATIONS:
 * ---------------
 *   get()                    → read current value
 *   set(v)                   → write value
 *   getAndSet(v)             → atomic swap
 *   getAndIncrement()        → i++ atomic
 *   getAndDecrement()        → i-- atomic
 *   incrementAndGet()        → ++i atomic
 *   addAndGet(delta)         → add and return new value
 *   compareAndSet(exp, upd)  → CAS: update if current == expected
 *   updateAndGet(fn)         → apply function atomically (Java 8+)
 *
 * CAS: Compare-And-Swap
 * ----------------------
 *   Non-blocking: tries to update, retries if value changed.
 *   volatile + CPU-level atomic instruction (lock cmpxchg on x86)
 *
 * WHEN TO USE:
 * ------------
 *   AtomicInteger  → simple counter, flag
 *   LongAdder      → high-contention counter (better than AtomicLong under contention)
 *   AtomicReference → immutable object swap
 *
 * ============================================================
 */
public class AtomicClasses {

    // ── 1. AtomicInteger basics ───────────────────────────────
    static void atomicIntegerDemo() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);

        // Thread-safe increment
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) counter.incrementAndGet();
            });
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        System.out.println("Expected 10000, Got: " + counter.get()); // always 10000

        // Various operations
        AtomicInteger n = new AtomicInteger(5);
        System.out.println("get:           " + n.get());              // 5
        System.out.println("getAndIncrement: " + n.getAndIncrement()); // 5 (then 6)
        System.out.println("incrementAndGet: " + n.incrementAndGet()); // 7
        System.out.println("addAndGet(3):  " + n.addAndGet(3));       // 10
        System.out.println("getAndSet(0):  " + n.getAndSet(0));       // 10 (then 0)
    }

    // ── 2. compareAndSet (CAS) ────────────────────────────────
    static void casDemo() {
        AtomicInteger val = new AtomicInteger(10);

        boolean success1 = val.compareAndSet(10, 20); // expected=10, actual=10 → OK
        boolean success2 = val.compareAndSet(10, 30); // expected=10, actual=20 → FAIL

        System.out.println("CAS(10,20) success: " + success1 + " → " + val.get()); // true, 20
        System.out.println("CAS(10,30) success: " + success2 + " → " + val.get()); // false, 20
    }

    // ── 3. AtomicReference — swap immutable objects ───────────
    record Config(String host, int port) {}

    static void atomicReferenceDemo() {
        AtomicReference<Config> configRef = new AtomicReference<>(new Config("localhost", 8080));

        System.out.println("Initial: " + configRef.get());

        // Thread-safe config update
        Config oldConfig = configRef.get();
        Config newConfig = new Config("remote.host", 9090);
        boolean updated = configRef.compareAndSet(oldConfig, newConfig);
        System.out.println("Updated: " + updated + " → " + configRef.get());

        // Update with compute (Java 8+)
        configRef.updateAndGet(c -> new Config(c.host(), c.port() + 1));
        System.out.println("Port bumped: " + configRef.get());
    }

    // ── 4. LongAdder — better for high contention ─────────────
    static void longAdderDemo() throws InterruptedException {
        LongAdder adder = new LongAdder();
        AtomicLong atomicLong = new AtomicLong(0);

        ExecutorService exec = Executors.newFixedThreadPool(8);
        CountDownLatch latch = new CountDownLatch(8);

        for (int i = 0; i < 8; i++) {
            exec.submit(() -> {
                for (int j = 0; j < 100_000; j++) {
                    adder.increment();
                    atomicLong.incrementAndGet();
                }
                latch.countDown();
            });
        }

        latch.await();
        exec.shutdown();

        System.out.println("LongAdder:   " + adder.sum());       // 800000
        System.out.println("AtomicLong:  " + atomicLong.get());  // 800000
        System.out.println("LongAdder is faster under high contention");
    }

    // ── 5. AtomicBoolean — flag ───────────────────────────────
    static void atomicBooleanDemo() throws InterruptedException {
        AtomicBoolean initialized = new AtomicBoolean(false);

        // Only one thread initializes
        Runnable init = () -> {
            if (initialized.compareAndSet(false, true)) {
                System.out.println(Thread.currentThread().getName() + ": INITIALIZED");
            } else {
                System.out.println(Thread.currentThread().getName() + ": already initialized");
            }
        };

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(init, "Thread-" + i);
            threads[i].start();
        }
        for (Thread t : threads) t.join();
    }

    // ── 6. AtomicIntegerArray ─────────────────────────────────
    static void atomicArrayDemo() throws InterruptedException {
        int[] buckets = {0, 0, 0, 0, 0};
        AtomicIntegerArray atomicBuckets = new AtomicIntegerArray(buckets.length);

        Thread[] threads = new Thread[10];
        for (int t = 0; t < threads.length; t++) {
            threads[t] = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    int idx = (int)(Math.random() * atomicBuckets.length());
                    atomicBuckets.incrementAndGet(idx);
                }
            });
            threads[t].start();
        }
        for (Thread t : threads) t.join();

        int total = 0;
        System.out.print("Buckets: ");
        for (int i = 0; i < atomicBuckets.length(); i++) {
            System.out.print(atomicBuckets.get(i) + " ");
            total += atomicBuckets.get(i);
        }
        System.out.println("| Total: " + total); // should be 10000
    }

    public static void main(String[] args) throws Exception {
        System.out.println("=== AtomicInteger ===");
        atomicIntegerDemo();

        System.out.println("\n=== CAS Demo ===");
        casDemo();

        System.out.println("\n=== AtomicReference ===");
        atomicReferenceDemo();

        System.out.println("\n=== LongAdder vs AtomicLong ===");
        longAdderDemo();

        System.out.println("\n=== AtomicBoolean (once-only init) ===");
        atomicBooleanDemo();

        System.out.println("\n=== AtomicIntegerArray ===");
        atomicArrayDemo();

        System.out.println("\n=== Atomic Classes Summary ===");
        System.out.println("AtomicInteger/Long   → counter, flag, lightweight");
        System.out.println("AtomicReference<T>   → immutable object swap");
        System.out.println("CAS: compareAndSet(expected, update) → atomic update");
        System.out.println("LongAdder            → high-contention summing (faster)");
        System.out.println("No synchronized needed — non-blocking thread safety");
    }
}
