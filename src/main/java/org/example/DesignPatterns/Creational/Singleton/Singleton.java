package org.example.DesignPatterns.Creational.Singleton;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

/**
 * ============================================================
 *        SINGLETON PATTERN — COMPLETE GUIDE
 * ============================================================
 *
 * INTENT: Ensure a class has only ONE instance and provide
 * a global access point to it.
 *
 * USE CASES:
 * ----------
 *   - Configuration manager
 *   - Logger
 *   - Thread pool / connection pool
 *   - Cache
 *
 * IMPLEMENTATION VARIANTS:
 * -------------------------
 *   1. Eager          — created at class load (thread-safe, simple)
 *   2. Lazy           — created on first use (NOT thread-safe)
 *   3. Synchronized   — thread-safe but slow
 *   4. Double-checked — thread-safe and fast (volatile required!)
 *   5. Enum           — Best! Thread-safe, serialization-safe
 *   6. Holder class   — Lazy + thread-safe via class loading
 *
 * PITFALLS:
 * ---------
 *   - Hard to unit test (global state)
 *   - Can cause issues in multi-classloader environments
 *   - Serialization breaks Singleton unless readResolve() defined
 *   - Reflection can break it unless guarded in constructor
 *
 * ============================================================
 */
public class Singleton {

    // ── 1. Eager initialization (simplest, thread-safe) ───────
    static class EagerSingleton {
        private static final EagerSingleton INSTANCE = new EagerSingleton(); // created at load

        private EagerSingleton() {
            System.out.println("EagerSingleton created");
        }

        static EagerSingleton getInstance() { return INSTANCE; }

        void doWork() { System.out.println("EagerSingleton: doing work"); }
    }

    // ── 2. Lazy (NOT thread-safe) ─────────────────────────────
    static class LazySingleton {
        private static LazySingleton instance;

        private LazySingleton() {}

        // NOT thread-safe: two threads can both see instance==null and both create
        static LazySingleton getInstance() {
            if (instance == null) {
                instance = new LazySingleton(); // potential race condition
            }
            return instance;
        }
    }

    // ── 3. Synchronized method (thread-safe, slow) ────────────
    static class SynchronizedSingleton {
        private static SynchronizedSingleton instance;

        private SynchronizedSingleton() {}

        // Every call acquires lock — unnecessary overhead after init
        static synchronized SynchronizedSingleton getInstance() {
            if (instance == null) instance = new SynchronizedSingleton();
            return instance;
        }
    }

    // ── 4. Double-Checked Locking (recommended for classes) ───
    static class DCLSingleton {
        private static volatile DCLSingleton instance; // volatile is critical!

        private DCLSingleton() {
            // Guard against reflection attacks
            if (instance != null) throw new RuntimeException("Use getInstance()");
        }

        static DCLSingleton getInstance() {
            if (instance == null) {                  // first check (no lock)
                synchronized (DCLSingleton.class) {
                    if (instance == null) {          // second check (with lock)
                        instance = new DCLSingleton();
                    }
                }
            }
            return instance;
        }
    }

    // ── 5. ENUM Singleton (BEST for most cases) ───────────────
    // Thread-safe, serialization-safe, reflection-safe
    enum EnumSingleton {
        INSTANCE;

        private int counter = 0;

        void increment() { counter++; }
        int getCounter() { return counter; }

        void doWork() { System.out.println("EnumSingleton: count=" + counter); }
    }

    // ── 6. Initialization-On-Demand Holder ────────────────────
    // Lazy + thread-safe via class loading guarantee (no synchronization)
    static class HolderSingleton {
        private HolderSingleton() {}

        private static class Holder {
            static final HolderSingleton INSTANCE = new HolderSingleton();
        }

        static HolderSingleton getInstance() { return Holder.INSTANCE; }

        String info() { return "HolderSingleton@" + Integer.toHexString(hashCode()); }
    }

    // ── 7. Registry (multiple named singletons) ───────────────
    static class SingletonRegistry {
        private static final java.util.Map<String, Object> registry = new java.util.concurrent.ConcurrentHashMap<>();

        @SuppressWarnings("unchecked")
        static <T> T get(String name, java.util.function.Supplier<T> factory) {
            return (T) registry.computeIfAbsent(name, k -> factory.get());
        }
    }

    public static void main(String[] args) throws Exception {
        // 1. Eager
        EagerSingleton e1 = EagerSingleton.getInstance();
        EagerSingleton e2 = EagerSingleton.getInstance();
        System.out.println("Eager same instance: " + (e1 == e2)); // true

        // 2. DCL (for classes)
        DCLSingleton d1 = DCLSingleton.getInstance();
        DCLSingleton d2 = DCLSingleton.getInstance();
        System.out.println("DCL same instance: " + (d1 == d2)); // true

        // Thread safety test
        ExecutorService exec = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(10);
        AtomicInteger uniqueCount = new AtomicInteger(0);
        java.util.Set<Integer> seen = java.util.Collections.synchronizedSet(new java.util.HashSet<>());

        for (int i = 0; i < 10; i++) {
            exec.submit(() -> {
                HolderSingleton s = HolderSingleton.getInstance();
                seen.add(System.identityHashCode(s));
                latch.countDown();
            });
        }
        latch.await();
        exec.shutdown();
        System.out.println("Unique HolderSingleton instances: " + seen.size()); // should be 1

        // 3. Enum singleton
        EnumSingleton.INSTANCE.increment();
        EnumSingleton.INSTANCE.increment();
        EnumSingleton.INSTANCE.doWork(); // count=2

        // 4. Registry
        String db = SingletonRegistry.get("database", () -> "MyDatabase");
        String db2 = SingletonRegistry.get("database", () -> "AnotherDB");
        System.out.println("Same from registry: " + db.equals(db2)); // true (first wins)

        System.out.println("\n=== Singleton Comparison ===");
        System.out.println("Eager:       simple, created at load — use if always needed");
        System.out.println("DCL:         lazy + thread-safe — use for expensive init");
        System.out.println("Enum:        BEST — lazy, thread-safe, serializable");
        System.out.println("Holder:      elegant lazy + thread-safe, no synchronization");
        System.out.println("Avoid:       Lazy (not thread-safe), Synchronized (slow)");
    }
}
