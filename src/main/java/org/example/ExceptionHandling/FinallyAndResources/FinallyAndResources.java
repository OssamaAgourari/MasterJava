package org.example.ExceptionHandling.FinallyAndResources;

import java.io.*;
import java.util.*;

/**
 * ============================================================
 *     FINALLY & TRY-WITH-RESOURCES — COMPLETE GUIDE
 * ============================================================
 *
 * FINALLY:
 * --------
 *   - Runs ALWAYS: normal, exception, or return
 *   - Use for cleanup (close connections, release locks)
 *   - If finally throws, suppresses original exception (bad!)
 *   - return in finally overrides return in try (avoid!)
 *
 * TRY-WITH-RESOURCES (Java 7+):
 * ------------------------------
 *   - Auto-closes any AutoCloseable at end of try block
 *   - Close happens even on exception
 *   - Multiple resources: closed in reverse order
 *   - Suppressed exceptions stored in primary exception
 *   - PREFERRED over finally for resource cleanup
 *
 * AutoCloseable vs Closeable:
 * ---------------------------
 *   AutoCloseable → close() throws Exception
 *   Closeable     → close() throws IOException (extends AutoCloseable)
 *   Both work with try-with-resources
 *
 * ============================================================
 */
public class FinallyAndResources {

    // ── 1. Finally always runs ────────────────────────────────
    static String demonstrateFinally(boolean throwException) {
        StringBuilder log = new StringBuilder();
        try {
            log.append("try ");
            if (throwException) throw new RuntimeException("test error");
            log.append("no-exception ");
            return log + "return-from-try";
        } catch (RuntimeException e) {
            log.append("catch ");
            return log + "return-from-catch";
        } finally {
            log.append("finally ");
            System.out.println("Log so far: " + log);
            // NOTE: return here would override try/catch return — avoid!
        }
    }

    // ── 2. Custom AutoCloseable resource ─────────────────────
    static class DatabaseConnection implements AutoCloseable {
        private final String url;
        private boolean open;

        DatabaseConnection(String url) {
            this.url = url;
            this.open = true;
            System.out.println("  Opened connection to: " + url);
        }

        void query(String sql) {
            if (!open) throw new IllegalStateException("Connection is closed");
            System.out.println("  Executing: " + sql);
        }

        @Override
        public void close() {
            if (open) {
                open = false;
                System.out.println("  Closed connection to: " + url);
            }
        }

        boolean isOpen() { return open; }
    }

    // ── 3. Multiple resources — closed in reverse order ───────
    static class Transaction implements AutoCloseable {
        private final String name;
        Transaction(String name) {
            this.name = name;
            System.out.println("  Begin: " + name);
        }
        void commit() { System.out.println("  Commit: " + name); }
        @Override
        public void close() { System.out.println("  Close TX: " + name); }
    }

    // ── 4. Suppressed exceptions ──────────────────────────────
    static class BrokenResource implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw new Exception("Close failed!"); // suppressed if body throws too
        }
    }

    static void suppressedDemo() {
        try (BrokenResource r = new BrokenResource()) {
            throw new RuntimeException("Primary exception");
        } catch (Exception e) {
            System.out.println("Primary: " + e.getMessage());
            // Suppressed exceptions from close()
            for (Throwable sup : e.getSuppressed())
                System.out.println("Suppressed: " + sup.getMessage());
        }
    }

    // ── 5. Nested try-with-resources ──────────────────────────
    static String processData(String source, String destination) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new StringReader(source));
             BufferedWriter writer = new BufferedWriter(new StringWriter())) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line.toUpperCase()).append("\n");
            }
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
        return result.toString().trim();
    }

    // ── 6. Finally vs try-with-resources comparison ───────────
    static void oldStyleWithFinally(String url) {
        DatabaseConnection conn = null;
        try {
            conn = new DatabaseConnection(url);
            conn.query("SELECT 1");
        } finally {
            if (conn != null) conn.close(); // manual cleanup
        }
    }

    static void newStyleWithTWR(String url) {
        try (DatabaseConnection conn = new DatabaseConnection(url)) {
            conn.query("SELECT 1");
        } // auto-closed
    }

    // ── 7. Exception in finally ───────────────────────────────
    static void dangerousFinally() {
        try {
            System.out.println("  try: doing work");
            throw new RuntimeException("original");
        } finally {
            System.out.println("  finally: runs");
            // DON'T: throw new RuntimeException("from finally");
            // This would suppress the original exception!
        }
    }

    public static void main(String[] args) {
        // 1. Finally always runs
        System.out.println("=== Finally Always Runs ===");
        System.out.println("Result (no exception): " + demonstrateFinally(false));
        System.out.println("Result (with exception): " + demonstrateFinally(true));

        // 2. Try-with-resources
        System.out.println("\n=== Try-with-Resources ===");
        try (DatabaseConnection conn = new DatabaseConnection("jdbc:h2:mem:test")) {
            conn.query("SELECT * FROM users");
            conn.query("INSERT INTO log VALUES(1)");
        }
        // conn.close() called automatically here

        // 3. Multiple resources (closed in reverse)
        System.out.println("\n=== Multiple Resources (reverse close) ===");
        try (DatabaseConnection db = new DatabaseConnection("db://main");
             Transaction tx = new Transaction("TX-001")) {
            db.query("UPDATE balance SET amount=100");
            tx.commit();
        }
        // TX-001 closed first, then db connection

        // 4. Suppressed exceptions
        System.out.println("\n=== Suppressed Exceptions ===");
        suppressedDemo();

        // 5. Process data
        System.out.println("\n=== Process Data ===");
        String result = processData("hello world\nhow are you", "output");
        System.out.println("Processed:\n" + result);

        // 6. Comparison
        System.out.println("\n=== Old Style (finally) ===");
        oldStyleWithFinally("old://db");
        System.out.println("\n=== New Style (TWR) ===");
        newStyleWithTWR("new://db");

        // 7. Exception in finally
        System.out.println("\n=== Exception in Finally ===");
        try { dangerousFinally(); }
        catch (RuntimeException e) { System.out.println("Caught: " + e.getMessage()); }

        System.out.println("\n=== Best Practices ===");
        System.out.println("1. Use try-with-resources over finally for AutoCloseable");
        System.out.println("2. Never return from finally (overrides try/catch return)");
        System.out.println("3. Don't throw from finally (suppresses original exception)");
        System.out.println("4. Multiple resources: opened left-to-right, closed right-to-left");
        System.out.println("5. Suppressed exceptions accessible via e.getSuppressed()");
    }
}
