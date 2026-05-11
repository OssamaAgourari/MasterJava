package org.example.Concurrency.CompletableFuture;

import java.util.*;
import java.util.concurrent.*;

/**
 * ============================================================
 *       JAVA COMPLETABLEFUTURE — COMPLETE GUIDE
 * ============================================================
 *
 * CompletableFuture: Non-blocking async computation with chaining.
 * Think of it as a promise/async-await in Java.
 *
 * CREATING:
 * ---------
 *   CompletableFuture.supplyAsync(Supplier)   → async with result
 *   CompletableFuture.runAsync(Runnable)       → async, no result
 *   CompletableFuture.completedFuture(value)  → already done
 *
 * CHAINING:
 * ---------
 *   thenApply(fn)     → transform result (like Stream.map)
 *   thenAccept(fn)    → consume result, return void
 *   thenRun(fn)       → run after, ignore result
 *   thenCompose(fn)   → chain another CF (flat map)
 *   thenCombine(cf,fn)→ combine two CFs
 *
 * ERROR HANDLING:
 * ---------------
 *   exceptionally(fn) → handle exception, return fallback
 *   handle(fn)        → handle both result and exception
 *   whenComplete(fn)  → observe result/exception, no transform
 *
 * COMPOSING MULTIPLE:
 * -------------------
 *   allOf(cfs)  → completes when ALL complete
 *   anyOf(cfs)  → completes when ANY completes
 *
 * ASYNC VARIANTS: thenApplyAsync, thenAcceptAsync — run on separate thread
 *
 * ============================================================
 */
public class CompletableFutureGuide {

    // ── 1. Basic async computation ────────────────────────────
    static void basicAsync() throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Computing on: " + Thread.currentThread().getName());
            try { Thread.sleep(100); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            return "Hello, Async!";
        });

        System.out.println("Doing other work while async runs...");
        String result = future.get(); // blocks until done
        System.out.println("Result: " + result);
    }

    // ── 2. Chaining with thenApply ────────────────────────────
    static void chainingDemo() throws Exception {
        CompletableFuture<Integer> future = CompletableFuture
            .supplyAsync(() -> "hello world")       // String
            .thenApply(s -> s.split(" "))            // String[]
            .thenApply(arr -> arr.length)            // Integer
            .thenApply(n -> n * 10);                 // Integer

        System.out.println("Chain result: " + future.get()); // 20
    }

    // ── 3. thenCompose — flat map ─────────────────────────────
    static CompletableFuture<String> fetchUser(int id) {
        return CompletableFuture.supplyAsync(() -> "User" + id);
    }

    static CompletableFuture<String> fetchOrders(String user) {
        return CompletableFuture.supplyAsync(() -> user + "'s orders: [o1, o2, o3]");
    }

    static void composeDemo() throws Exception {
        CompletableFuture<String> result = fetchUser(42)
            .thenCompose(user -> fetchOrders(user)); // not thenApply (would give CF<CF<String>>)
        System.out.println("Composed: " + result.get());
    }

    // ── 4. thenCombine — combine two CFs ─────────────────────
    static void combineDemo() throws Exception {
        CompletableFuture<Integer> price = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(100); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            return 100;
        });

        CompletableFuture<Integer> discount = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(150); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            return 20;
        });

        CompletableFuture<Integer> finalPrice = price.thenCombine(discount, (p, d) -> p - d);
        System.out.println("Final price: " + finalPrice.get()); // 80
    }

    // ── 5. Error handling ─────────────────────────────────────
    static void errorHandlingDemo() throws Exception {
        CompletableFuture<String> risky = CompletableFuture.supplyAsync(() -> {
            if (Math.random() > 0.5) throw new RuntimeException("Random failure");
            return "Success";
        });

        // exceptionally: provide fallback on error
        CompletableFuture<String> safe = risky.exceptionally(ex -> {
            System.out.println("Handling error: " + ex.getMessage());
            return "Fallback value";
        });

        System.out.println("Result: " + safe.get());

        // handle: access both result and exception
        CompletableFuture<String> handled = CompletableFuture
            .<String>supplyAsync(() -> { throw new RuntimeException("Oops"); })
            .handle((result, ex) -> ex != null ? "Error: " + ex.getMessage() : result);
        System.out.println("Handled: " + handled.get());
    }

    // ── 6. allOf — wait for all ───────────────────────────────
    static void allOfDemo() throws Exception {
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            final int n = i;
            futures.add(CompletableFuture.supplyAsync(() -> {
                try { Thread.sleep((long)(Math.random() * 200)); }
                catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                return n * n;
            }));
        }

        CompletableFuture<Void> allDone = CompletableFuture.allOf(
            futures.toArray(new CompletableFuture[0])
        );

        allDone.thenRun(() -> {
            List<Integer> results = futures.stream()
                .map(CompletableFuture::join) // join doesn't throw checked
                .collect(java.util.stream.Collectors.toList());
            System.out.println("All results: " + results);
        }).get(); // wait for everything
    }

    // ── 7. anyOf — first completed ────────────────────────────
    static void anyOfDemo() throws Exception {
        CompletableFuture<Object> anyDone = CompletableFuture.anyOf(
            CompletableFuture.supplyAsync(() -> { try{Thread.sleep(300);}catch(InterruptedException e){} return "slow"; }),
            CompletableFuture.supplyAsync(() -> { try{Thread.sleep(100);}catch(InterruptedException e){} return "fast"; }),
            CompletableFuture.supplyAsync(() -> { try{Thread.sleep(200);}catch(InterruptedException e){} return "medium"; })
        );
        System.out.println("First done: " + anyDone.get()); // "fast"
    }

    // ── 8. timeout and cancel ─────────────────────────────────
    static void timeoutDemo() throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            return "result";
        }).orTimeout(200, TimeUnit.MILLISECONDS) // Java 9+
          .exceptionally(ex -> "Timed out: " + ex.getCause().getMessage());

        System.out.println("Timeout result: " + future.get());
    }

    public static void main(String[] args) throws Exception {
        System.out.println("=== Basic Async ===");
        basicAsync();

        System.out.println("\n=== Chaining ===");
        chainingDemo();

        System.out.println("\n=== Compose ===");
        composeDemo();

        System.out.println("\n=== Combine ===");
        combineDemo();

        System.out.println("\n=== Error Handling ===");
        errorHandlingDemo();

        System.out.println("\n=== allOf ===");
        allOfDemo();

        System.out.println("\n=== anyOf ===");
        anyOfDemo();

        System.out.println("\n=== Timeout ===");
        timeoutDemo();

        System.out.println("\n=== CompletableFuture Summary ===");
        System.out.println("supplyAsync → async with result");
        System.out.println("thenApply   → transform (like map)");
        System.out.println("thenCompose → flat map (avoid CF<CF<T>>)");
        System.out.println("thenCombine → combine two CFs");
        System.out.println("exceptionally → error fallback");
        System.out.println("handle      → access result or error");
        System.out.println("allOf/anyOf → await multiple");
        System.out.println("join()      → get() without checked exception");
    }
}
