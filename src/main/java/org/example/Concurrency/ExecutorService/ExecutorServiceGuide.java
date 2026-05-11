package org.example.Concurrency.ExecutorService;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * ============================================================
 *        JAVA EXECUTOR SERVICE — COMPLETE GUIDE
 * ============================================================
 *
 * ExecutorService: High-level thread management API.
 * Separates task SUBMISSION from thread MANAGEMENT.
 *
 * FACTORY METHODS (Executors.*):
 * --------------------------------
 *   newFixedThreadPool(n)        → n threads reused
 *   newCachedThreadPool()        → grows/shrinks as needed
 *   newSingleThreadExecutor()    → single thread, sequential
 *   newScheduledThreadPool(n)    → scheduled/periodic tasks
 *   newVirtualThreadPerTaskExecutor() → Java 21, lightweight
 *
 * SUBMITTING TASKS:
 * -----------------
 *   execute(Runnable)  → fire-and-forget (no result)
 *   submit(Callable)   → returns Future<T>
 *   invokeAll(list)    → wait for all, returns List<Future>
 *   invokeAny(list)    → return first completed result
 *
 * FUTURE<T>:
 * ----------
 *   get()             → block and get result (throws ExecutionException)
 *   get(timeout, unit)→ block with timeout
 *   isDone()          → check without blocking
 *   cancel(true)      → attempt to cancel
 *
 * SHUTDOWN:
 * ---------
 *   shutdown()        → stop accepting, wait for running to finish
 *   shutdownNow()     → interrupt running tasks
 *   awaitTermination()→ wait up to timeout
 *
 * ============================================================
 */
public class ExecutorServiceGuide {

    // ── 1. Fixed thread pool ──────────────────────────────────
    static void fixedPoolDemo() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 6; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " on " + Thread.currentThread().getName());
                try { Thread.sleep(50); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("All tasks done");
    }

    // ── 2. Future — get result from thread ────────────────────
    static void futureDemo() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> fib = () -> {
            Thread.sleep(100);
            int a = 0, b = 1;
            for (int i = 0; i < 10; i++) { int c = a+b; a=b; b=c; }
            return a;
        };

        Future<Integer> future = executor.submit(fib);
        System.out.println("Submitted, doing other work...");
        // ... other work here ...
        System.out.println("fib(10) = " + future.get()); // blocks until done

        executor.shutdown();
    }

    // ── 3. invokeAll — wait for all tasks ─────────────────────
    static void invokeAllDemo() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            final int n = i;
            tasks.add(() -> {
                Thread.sleep((long)(Math.random() * 200));
                return "Result-" + n;
            });
        }

        List<Future<String>> futures = executor.invokeAll(tasks); // waits for all

        System.out.println("All results:");
        for (Future<String> f : futures)
            System.out.println("  " + f.get()); // already done

        executor.shutdown();
    }

    // ── 4. invokeAny — get first completed ────────────────────
    static void invokeAnyDemo() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = Arrays.asList(
            () -> { Thread.sleep(300); return "Slow task"; },
            () -> { Thread.sleep(100); return "Fast task"; },
            () -> { Thread.sleep(200); return "Medium task"; }
        );

        String result = executor.invokeAny(tasks); // returns first completed
        System.out.println("First completed: " + result); // "Fast task"

        executor.shutdown();
    }

    // ── 5. ScheduledExecutorService ──────────────────────────
    static void scheduledDemo() throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // One-time delay
        scheduler.schedule(
            () -> System.out.println("Delayed task ran after 200ms"),
            200, TimeUnit.MILLISECONDS
        );

        // Periodic
        ScheduledFuture<?> periodic = scheduler.scheduleAtFixedRate(
            () -> System.out.println("Periodic: " + System.currentTimeMillis()),
            0, 100, TimeUnit.MILLISECONDS
        );

        Thread.sleep(350);
        periodic.cancel(false); // stop periodic
        scheduler.shutdown();
        scheduler.awaitTermination(1, TimeUnit.SECONDS);
    }

    // ── 6. CompletionService — process as completed ───────────
    static void completionServiceDemo() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletionService<Integer> cs = new ExecutorCompletionService<>(executor);

        int[] workloads = {300, 100, 200, 50, 150};
        for (int ms : workloads) {
            final int delay = ms;
            cs.submit(() -> { Thread.sleep(delay); return delay; });
        }

        System.out.println("Processing results as they complete:");
        for (int i = 0; i < workloads.length; i++) {
            Future<Integer> f = cs.take(); // blocks for next completed
            System.out.println("  Completed: " + f.get() + "ms task");
        }

        executor.shutdown();
    }

    // ── 7. Proper shutdown pattern ────────────────────────────
    static void shutdownGracefully(ExecutorService executor) {
        executor.shutdown(); // stop accepting new tasks
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow(); // interrupt running tasks
                if (!executor.awaitTermination(5, TimeUnit.SECONDS))
                    System.err.println("Executor did not terminate");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("=== Fixed Thread Pool ===");
        fixedPoolDemo();

        System.out.println("\n=== Future ===");
        futureDemo();

        System.out.println("\n=== invokeAll ===");
        invokeAllDemo();

        System.out.println("\n=== invokeAny ===");
        invokeAnyDemo();

        System.out.println("\n=== Scheduled ===");
        scheduledDemo();

        System.out.println("\n=== CompletionService ===");
        completionServiceDemo();

        System.out.println("\n=== ExecutorService Summary ===");
        System.out.println("execute(Runnable)  → fire and forget");
        System.out.println("submit(Callable)   → get Future result");
        System.out.println("invokeAll()        → wait for all");
        System.out.println("invokeAny()        → first completed");
        System.out.println("ALWAYS shutdown()  → release thread resources");
        System.out.println("Use try-with-resources pattern (Java 19+ ExecutorService is AutoCloseable)");
    }
}
