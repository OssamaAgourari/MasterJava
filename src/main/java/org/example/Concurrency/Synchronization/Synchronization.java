package org.example.Concurrency.Synchronization;

import java.util.*;
import java.util.concurrent.*;

/**
 * ============================================================
 *       JAVA SYNCHRONIZATION — COMPLETE GUIDE
 * ============================================================
 *
 * SYNCHRONIZATION: Coordinating access to shared resources.
 *
 * KEYWORDS:
 * ---------
 *   synchronized → mutual exclusion on a monitor (intrinsic lock)
 *   volatile     → visibility guarantee (no caching in CPU registers)
 *
 * synchronized METHOD:
 *   - Acquires lock on 'this' (instance method) or Class (static)
 *   - Only one thread can execute any synchronized method of the object
 *
 * synchronized BLOCK:
 *   - More granular — lock only specific section
 *   - Can lock on any object
 *
 * VOLATILE:
 * ---------
 *   - Ensures all reads/writes go to main memory (not CPU cache)
 *   - Does NOT make compound operations atomic (count++ is 3 ops!)
 *   - Use for simple flags (boolean stop = false)
 *
 * wait/notify:
 * ------------
 *   Must be called from synchronized block on same monitor
 *   wait()   → release lock, wait until notified
 *   notify() → wake one waiting thread
 *   notifyAll() → wake all waiting threads
 *
 * ============================================================
 */
public class Synchronization {

    // ── 1. Synchronized method ────────────────────────────────
    static class SafeCounter {
        private int count = 0;

        synchronized void increment()  { count++; }
        synchronized void decrement()  { count--; }
        synchronized int getCount()    { return count; }

        // Alternatively, using synchronized block (finer grained):
        void addSafe(int n) {
            synchronized (this) {
                count += n;
            }
        }
    }

    // ── 2. Static synchronized ────────────────────────────────
    static class StaticCounter {
        private static int sharedCount = 0;

        static synchronized void increment() { sharedCount++; }
        static synchronized int  getCount()  { return sharedCount; }
    }

    // ── 3. Synchronized block with separate lock ──────────────
    static class BankAccount {
        private final Object lock = new Object(); // dedicated lock object
        private double balance;

        BankAccount(double initial) { this.balance = initial; }

        void deposit(double amount) {
            synchronized (lock) {
                balance += amount;
                System.out.println(Thread.currentThread().getName() +
                    " deposited " + amount + " → " + balance);
            }
        }

        boolean withdraw(double amount) {
            synchronized (lock) {
                if (balance < amount) return false;
                balance -= amount;
                return true;
            }
        }

        double getBalance() {
            synchronized (lock) { return balance; }
        }
    }

    // ── 4. Volatile flag ─────────────────────────────────────
    static class StoppableTask implements Runnable {
        private volatile boolean running = true; // volatile ensures visibility

        @Override
        public void run() {
            int i = 0;
            while (running) {
                i++;
            }
            System.out.println("Task stopped after " + i + " iterations");
        }

        void stop() { running = false; }
    }

    // ── 5. Producer-Consumer with wait/notify ─────────────────
    static class Buffer {
        private final Queue<Integer> queue = new LinkedList<>();
        private final int capacity;

        Buffer(int capacity) { this.capacity = capacity; }

        synchronized void produce(int item) throws InterruptedException {
            while (queue.size() == capacity) {
                System.out.println("Buffer full, producer waiting...");
                wait();
            }
            queue.offer(item);
            System.out.println("Produced: " + item);
            notifyAll(); // wake waiting consumers
        }

        synchronized int consume() throws InterruptedException {
            while (queue.isEmpty()) {
                System.out.println("Buffer empty, consumer waiting...");
                wait();
            }
            int item = queue.poll();
            System.out.println("Consumed: " + item);
            notifyAll(); // wake waiting producers
            return item;
        }
    }

    // ── 6. Double-checked locking for singleton ───────────────
    static class Singleton {
        private static volatile Singleton instance; // volatile is critical here!

        private Singleton() {}

        static Singleton getInstance() {
            if (instance == null) { // first check (no lock)
                synchronized (Singleton.class) {
                    if (instance == null) { // second check (with lock)
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 1. Safe counter
        System.out.println("=== Synchronized Counter ===");
        SafeCounter counter = new SafeCounter();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) counter.increment();
            });
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        System.out.println("Expected 10000, Got: " + counter.getCount()); // 10000 guaranteed

        // 2. Bank account
        System.out.println("\n=== Bank Account ===");
        BankAccount account = new BankAccount(1000);
        Thread deposit1 = new Thread(() -> account.deposit(200), "Alice");
        Thread deposit2 = new Thread(() -> account.deposit(300), "Bob");
        Thread withdraw = new Thread(() -> {
            boolean ok = account.withdraw(400);
            System.out.println("Withdraw 400: " + ok);
        }, "Carol");

        deposit1.start(); deposit2.start(); withdraw.start();
        deposit1.join();  deposit2.join();  withdraw.join();
        System.out.println("Final balance: " + account.getBalance());

        // 3. Volatile stop
        System.out.println("\n=== Volatile Stop Flag ===");
        StoppableTask task = new StoppableTask();
        Thread taskThread = new Thread(task);
        taskThread.start();
        Thread.sleep(10);
        task.stop(); // sets volatile flag
        taskThread.join();

        // 4. Producer-Consumer
        System.out.println("\n=== Producer-Consumer ===");
        Buffer buffer = new Buffer(3);
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) { buffer.produce(i); Thread.sleep(20); }
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) { Thread.sleep(40); buffer.consume(); }
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        producer.start(); consumer.start();
        producer.join();  consumer.join();

        // 5. Singleton
        System.out.println("\n=== Singleton ===");
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("Same instance: " + (s1 == s2)); // true

        System.out.println("\n=== Synchronization Summary ===");
        System.out.println("synchronized method   → locks 'this' or class");
        System.out.println("synchronized block    → locks specified object");
        System.out.println("volatile              → visibility, not atomicity");
        System.out.println("wait/notify           → must be in synchronized block");
        System.out.println("Prefer java.util.concurrent over wait/notify");
    }
}
