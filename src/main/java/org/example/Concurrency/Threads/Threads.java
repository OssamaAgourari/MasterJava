package org.example.Concurrency.Threads;

import java.util.concurrent.*;

/**
 * ============================================================
 *          JAVA THREADS — COMPLETE GUIDE
 * ============================================================
 *
 * THREAD: A unit of execution. JVM starts with main thread.
 *
 * CREATING THREADS:
 * -----------------
 *   1. Extend Thread class
 *   2. Implement Runnable (preferred — allows extending other class)
 *   3. Implement Callable (returns result, throws checked exceptions)
 *   4. Lambda (Java 8+)
 *
 * THREAD LIFECYCLE:
 * -----------------
 *   NEW → RUNNABLE → RUNNING → (BLOCKED/WAITING/TIMED_WAITING) → TERMINATED
 *
 * KEY METHODS:
 * ------------
 *   start()         → starts a new thread (calls run() in new thread)
 *   run()           → entry point (DON'T call directly — call start())
 *   sleep(ms)       → pause current thread (static)
 *   join()          → wait for thread to finish
 *   interrupt()     → signal thread to stop
 *   isAlive()       → check if running
 *   setDaemon(true) → daemon thread (JVM exits when only daemons left)
 *
 * THREAD SAFETY PROBLEM:
 * ----------------------
 *   Race condition: two threads access shared data without coordination.
 *   Solution: synchronization (volatile, synchronized, locks, atomic)
 *
 * ============================================================
 */
public class Threads {

    // ── 1. Extending Thread ───────────────────────────────────
    static class CounterThread extends Thread {
        private final String name;
        private final int count;

        CounterThread(String name, int count) {
            super(name);
            this.name = name;
            this.count = count;
        }

        @Override
        public void run() {
            for (int i = 1; i <= count; i++) {
                System.out.println(name + ": " + i);
                try { Thread.sleep(10); } catch (InterruptedException e) { Thread.currentThread().interrupt(); return; }
            }
        }
    }

    // ── 2. Implementing Runnable ──────────────────────────────
    static Runnable makeTask(String name, int count) {
        return () -> {
            for (int i = 1; i <= count; i++) {
                System.out.println(Thread.currentThread().getName() + " [" + name + "]: " + i);
            }
        };
    }

    // ── 3. Race condition (DANGEROUS — demo only) ─────────────
    static class UnsafeCounter {
        int count = 0;
        void increment() { count++; } // NOT thread-safe: read-modify-write
    }

    // ── 4. Thread join ────────────────────────────────────────
    static void joinDemo() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("T1 starting heavy work...");
            try { Thread.sleep(100); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            System.out.println("T1 done");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("T2 doing quick work");
        });

        t1.start();
        t2.start();

        t1.join(); // wait for t1
        t2.join(); // wait for t2

        System.out.println("Both threads finished");
    }

    // ── 5. Daemon thread ─────────────────────────────────────
    static void daemonDemo() throws InterruptedException {
        Thread daemon = new Thread(() -> {
            System.out.println("Daemon: started");
            try {
                while (true) {
                    Thread.sleep(50);
                    System.out.println("Daemon: tick");
                }
            } catch (InterruptedException e) {
                System.out.println("Daemon: interrupted");
            }
        });
        daemon.setDaemon(true); // won't prevent JVM shutdown
        daemon.start();
        Thread.sleep(120);
        System.out.println("Main: done — JVM will exit, killing daemon");
    }

    // ── 6. Interrupt a thread ────────────────────────────────
    static void interruptDemo() throws InterruptedException {
        Thread worker = new Thread(() -> {
            try {
                System.out.println("Worker: starting long task");
                Thread.sleep(5000); // simulate long work
                System.out.println("Worker: done");
            } catch (InterruptedException e) {
                System.out.println("Worker: interrupted, cleaning up");
                Thread.currentThread().interrupt(); // restore interrupt flag
            }
        });

        worker.start();
        Thread.sleep(100);
        worker.interrupt(); // signal to stop
        worker.join();
        System.out.println("Worker ended: " + worker.getState());
    }

    // ── 7. Thread.currentThread() info ───────────────────────
    static void threadInfo() {
        Thread t = Thread.currentThread();
        System.out.println("Name:     " + t.getName());
        System.out.println("ID:       " + t.getId());
        System.out.println("Priority: " + t.getPriority());
        System.out.println("Daemon:   " + t.isDaemon());
        System.out.println("State:    " + t.getState());
        System.out.println("Active threads: " + Thread.activeCount());
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Thread Info ===");
        threadInfo();

        System.out.println("\n=== Extending Thread ===");
        CounterThread ct = new CounterThread("Counter", 3);
        ct.start();
        ct.join();

        System.out.println("\n=== Runnable Lambda ===");
        Thread t = new Thread(makeTask("Task", 3), "WorkerThread");
        t.start();
        t.join();

        System.out.println("\n=== Race Condition Demo ===");
        UnsafeCounter counter = new UnsafeCounter();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) counter.increment();
            });
            threads[i].start();
        }
        for (Thread thread : threads) thread.join();
        System.out.println("Expected: 10000, Got: " + counter.count + " (may differ due to race condition)");

        System.out.println("\n=== Thread Join ===");
        joinDemo();

        System.out.println("\n=== Interrupt ===");
        interruptDemo();

        System.out.println("\n=== Thread Summary ===");
        System.out.println("start()     → starts new thread (don't call run() directly)");
        System.out.println("join()      → wait for thread to complete");
        System.out.println("sleep(ms)   → pause current thread");
        System.out.println("interrupt() → signal thread to stop");
        System.out.println("isDaemon()  → true = doesn't prevent JVM shutdown");
        System.out.println("Race cond.  → use synchronized/volatile/Atomic/locks");
    }
}
