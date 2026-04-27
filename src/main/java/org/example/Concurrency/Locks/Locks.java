package org.example.Concurrency.Locks;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/**
 * ============================================================
 *          JAVA LOCKS — COMPLETE GUIDE
 * ============================================================
 *
 * java.util.concurrent.locks provides more flexible locking
 * than the built-in synchronized keyword.
 *
 * KEY INTERFACES & CLASSES:
 * -------------------------
 *   Lock              → ReentrantLock
 *   ReadWriteLock     → ReentrantReadWriteLock
 *   StampedLock       → Optimistic reading (Java 8+)
 *   Condition         → replacement for wait/notify
 *
 * REENTRANTLOCK vs SYNCHRONIZED:
 * --------------------------------
 *   synchronized    → simpler, auto-release on exit/exception
 *   ReentrantLock   → tryLock, lockInterruptibly, fairness, Condition
 *
 * ALWAYS USE try-finally:
 *   lock.lock();
 *   try { ... } finally { lock.unlock(); }
 *
 * READWRITELOCK:
 * --------------
 *   Multiple concurrent readers OR one writer (exclusive)
 *   Better than exclusive lock when reads >> writes
 *
 * ============================================================
 */
public class Locks {

    // ── 1. ReentrantLock basics ───────────────────────────────
    static class SafeCounter {
        private int count = 0;
        private final ReentrantLock lock = new ReentrantLock();

        void increment() {
            lock.lock();
            try { count++; } finally { lock.unlock(); } // ALWAYS in finally
        }

        int getCount() {
            lock.lock();
            try { return count; } finally { lock.unlock(); }
        }
    }

    // ── 2. tryLock — non-blocking attempt ─────────────────────
    static class Resource {
        private final ReentrantLock lock = new ReentrantLock();

        boolean tryAcquire(long timeout, TimeUnit unit) {
            try {
                if (lock.tryLock(timeout, unit)) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock");
                    return true;
                }
                System.out.println(Thread.currentThread().getName() + " could not acquire lock");
                return false;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }

        void release() {
            if (lock.isHeldByCurrentThread()) {
                System.out.println(Thread.currentThread().getName() + " released lock");
                lock.unlock();
            }
        }
    }

    // ── 3. Condition — replacement for wait/notify ───────────
    static class BoundedBuffer {
        private final int[] buffer;
        private int head, tail, count;
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition notFull  = lock.newCondition();
        private final Condition notEmpty = lock.newCondition();

        BoundedBuffer(int capacity) { buffer = new int[capacity]; }

        void put(int item) throws InterruptedException {
            lock.lock();
            try {
                while (count == buffer.length) notFull.await();  // wait for space
                buffer[tail] = item;
                tail = (tail + 1) % buffer.length;
                count++;
                notEmpty.signal(); // signal consumer
            } finally { lock.unlock(); }
        }

        int take() throws InterruptedException {
            lock.lock();
            try {
                while (count == 0) notEmpty.await(); // wait for item
                int item = buffer[head];
                head = (head + 1) % buffer.length;
                count--;
                notFull.signal(); // signal producer
                return item;
            } finally { lock.unlock(); }
        }
    }

    // ── 4. ReadWriteLock — concurrent reads ───────────────────
    static class SharedData {
        private String value = "initial";
        private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
        private final Lock readLock  = rwLock.readLock();
        private final Lock writeLock = rwLock.writeLock();

        String read() {
            readLock.lock(); // multiple threads can read simultaneously
            try {
                System.out.println(Thread.currentThread().getName() + " reads: " + value);
                return value;
            } finally { readLock.unlock(); }
        }

        void write(String newValue) {
            writeLock.lock(); // exclusive write
            try {
                System.out.println(Thread.currentThread().getName() + " writes: " + newValue);
                value = newValue;
                Thread.sleep(50); // simulate work
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            finally { writeLock.unlock(); }
        }
    }

    // ── 5. StampedLock — optimistic reading ───────────────────
    static class OptimisticPoint {
        private double x, y;
        private final StampedLock sl = new StampedLock();

        void move(double dx, double dy) {
            long stamp = sl.writeLock();
            try { x += dx; y += dy; } finally { sl.unlockWrite(stamp); }
        }

        double distanceFromOrigin() {
            long stamp = sl.tryOptimisticRead(); // no lock, just stamp
            double curX = x, curY = y;
            if (!sl.validate(stamp)) { // check if write happened
                stamp = sl.readLock(); // fallback to real read lock
                try { curX = x; curY = y; } finally { sl.unlockRead(stamp); }
            }
            return Math.sqrt(curX*curX + curY*curY);
        }
    }

    // ── 6. Semaphore — limit concurrent access ────────────────
    static class ConnectionPool {
        private final Semaphore semaphore;
        private final String[] connections;
        private final boolean[] available;

        ConnectionPool(int size) {
            semaphore = new Semaphore(size, true); // fair
            connections = new String[size];
            available   = new boolean[size];
            for (int i = 0; i < size; i++) {
                connections[i] = "Connection-" + i;
                available[i] = true;
            }
        }

        String acquire() throws InterruptedException {
            semaphore.acquire();
            return getAvailable();
        }

        synchronized private String getAvailable() {
            for (int i = 0; i < available.length; i++) {
                if (available[i]) { available[i] = false; return connections[i]; }
            }
            return null;
        }

        synchronized void release(String conn) {
            for (int i = 0; i < connections.length; i++) {
                if (connections[i].equals(conn)) { available[i] = true; semaphore.release(); return; }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // 1. ReentrantLock counter
        System.out.println("=== ReentrantLock Counter ===");
        SafeCounter counter = new SafeCounter();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> { for (int j = 0; j < 1000; j++) counter.increment(); });
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        System.out.println("Count (expected 5000): " + counter.getCount());

        // 2. tryLock
        System.out.println("\n=== tryLock ===");
        Resource resource = new Resource();
        Thread t1 = new Thread(() -> {
            if (resource.tryAcquire(100, TimeUnit.MILLISECONDS)) {
                try { Thread.sleep(200); } catch (InterruptedException e) {}
                resource.release();
            }
        }, "T1");
        Thread t2 = new Thread(() -> resource.tryAcquire(50, TimeUnit.MILLISECONDS), "T2");
        t1.start(); Thread.sleep(10); t2.start();
        t1.join(); t2.join();

        // 3. Bounded buffer
        System.out.println("\n=== Bounded Buffer with Condition ===");
        BoundedBuffer buf = new BoundedBuffer(3);
        Thread producer = new Thread(() -> {
            try { for (int i=1;i<=5;i++) { buf.put(i); System.out.println("Put: "+i); Thread.sleep(30); } }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        Thread consumer = new Thread(() -> {
            try { for (int i=0;i<5;i++) { Thread.sleep(60); System.out.println("Got: "+buf.take()); } }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        producer.start(); consumer.start();
        producer.join(); consumer.join();

        // 4. ReadWriteLock
        System.out.println("\n=== ReadWriteLock ===");
        SharedData data = new SharedData();
        Thread writer = new Thread(() -> { data.write("updated"); }, "Writer");
        Thread reader1 = new Thread(() -> { data.read(); }, "Reader1");
        Thread reader2 = new Thread(() -> { data.read(); }, "Reader2");
        reader1.start(); reader2.start(); writer.start();
        reader1.join(); reader2.join(); writer.join();

        // 5. StampedLock
        System.out.println("\n=== StampedLock ===");
        OptimisticPoint point = new OptimisticPoint();
        point.move(3, 4);
        System.out.printf("Distance: %.1f%n", point.distanceFromOrigin()); // 5.0

        // 6. Semaphore (connection pool)
        System.out.println("\n=== Semaphore Connection Pool ===");
        ConnectionPool pool = new ConnectionPool(2); // only 2 connections
        Thread[] clients = new Thread[4];
        for (int i = 0; i < 4; i++) {
            final int id = i;
            clients[i] = new Thread(() -> {
                try {
                    String conn = pool.acquire();
                    System.out.println("Client " + id + " got: " + conn);
                    Thread.sleep(50);
                    pool.release(conn);
                    System.out.println("Client " + id + " released: " + conn);
                } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            });
            clients[i].start();
        }
        for (Thread c : clients) c.join();

        System.out.println("\n=== Locks Summary ===");
        System.out.println("ReentrantLock → more features than synchronized");
        System.out.println("tryLock()     → non-blocking, timeout support");
        System.out.println("Condition     → fine-grained wait/signal");
        System.out.println("ReadWriteLock → concurrent reads, exclusive writes");
        System.out.println("StampedLock   → optimistic reads, best performance");
        System.out.println("Semaphore     → limit concurrent access (N permits)");
        System.out.println("ALWAYS unlock in finally block");
    }
}
