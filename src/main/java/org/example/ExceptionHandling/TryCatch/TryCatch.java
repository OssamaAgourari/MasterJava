package org.example.ExceptionHandling.TryCatch;

import java.io.*;
import java.util.*;

/**
 * ============================================================
 *       JAVA EXCEPTION HANDLING — COMPLETE GUIDE
 * ============================================================
 *
 * EXCEPTION HIERARCHY:
 * --------------------
 *   Throwable
 *   ├── Error        → JVM errors (StackOverflow, OutOfMemory) — don't catch
 *   └── Exception
 *       ├── RuntimeException  → UNCHECKED — not required to declare/catch
 *       │   ├── NullPointerException
 *       │   ├── ArrayIndexOutOfBoundsException
 *       │   ├── ClassCastException
 *       │   ├── ArithmeticException
 *       │   └── IllegalArgumentException
 *       └── Checked exceptions  → MUST declare (throws) or catch
 *           ├── IOException
 *           ├── FileNotFoundException
 *           └── SQLException
 *
 * TRY-CATCH-FINALLY SYNTAX:
 * -------------------------
 *   try {
 *     // risky code
 *   } catch (SpecificException e) {
 *     // handle specific
 *   } catch (Exception e) {
 *     // catch-all (more general last)
 *   } finally {
 *     // always runs (even if exception or return)
 *   }
 *
 * TRY-WITH-RESOURCES (Java 7+):
 * ------------------------------
 *   try (Resource r = new Resource()) {
 *     // use r
 *   } // auto-closes r.close(), even on exception
 *
 * MULTI-CATCH (Java 7+):
 * ----------------------
 *   catch (IOException | SQLException e) { ... }
 *
 * ============================================================
 */
public class TryCatch {

    // ── 1. Basic try-catch ────────────────────────────────────
    static int safeDivide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero: " + e.getMessage());
            return 0;
        }
    }

    // ── 2. Multiple catch blocks ──────────────────────────────
    static void multiCatch(String[] arr, int idx) {
        try {
            String s = arr[idx];
            int len = s.length(); // might throw NPE if s is null
            System.out.println("Length: " + len);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index " + idx + " out of bounds");
        } catch (NullPointerException e) {
            System.out.println("Element at " + idx + " is null");
        } catch (Exception e) {
            System.out.println("Unexpected: " + e.getClass().getSimpleName());
        }
    }

    // ── 3. Finally block ─────────────────────────────────────
    static String readWithFinally(String filename) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new StringReader("mock file content"));
            return reader.readLine();
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        } finally {
            if (reader != null) {
                try { reader.close(); } catch (IOException ignored) {}
            }
            System.out.println("finally block always runs");
        }
    }

    // ── 4. Try-with-resources ─────────────────────────────────
    static String tryWithResources(String content) {
        try (BufferedReader reader = new BufferedReader(new StringReader(content))) {
            return reader.readLine();
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
        // reader.close() called automatically
    }

    // ── 5. Multi-catch (Java 7+) ─────────────────────────────
    static int parseAndGet(String[] arr, String indexStr) {
        try {
            int idx = Integer.parseInt(indexStr);
            return arr[idx].length();
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Multi-catch: " + e.getClass().getSimpleName());
            return -1;
        }
    }

    // ── 6. Throwing exceptions ────────────────────────────────
    static int sqrt(int n) {
        if (n < 0) throw new IllegalArgumentException("Cannot take sqrt of negative: " + n);
        return (int) Math.sqrt(n);
    }

    // ── 7. Re-throwing exceptions ─────────────────────────────
    static void processFile(String path) throws IOException {
        try {
            // simulate file operation
            if (path.equals("bad.txt"))
                throw new IOException("File not found: " + path);
            System.out.println("Processing: " + path);
        } catch (IOException e) {
            System.out.println("Logging error: " + e.getMessage());
            throw e; // re-throw for caller to handle
        }
    }

    // ── 8. Exception chaining ─────────────────────────────────
    static void connectToDatabase(String url) {
        try {
            if (url == null) throw new NullPointerException("URL is null");
        } catch (NullPointerException e) {
            // Wrap in more informative exception
            throw new RuntimeException("Database connection failed", e);
        }
    }

    // ── 9. Checked vs unchecked ───────────────────────────────
    static String checkedExample(String filename) throws FileNotFoundException {
        // FileNotFoundException is checked — must declare in throws clause
        if (!filename.endsWith(".txt"))
            throw new FileNotFoundException("Not a text file: " + filename);
        return "content of " + filename;
    }

    // ── 10. Stack unwinding demo ──────────────────────────────
    static void methodC() {
        throw new RuntimeException("Error in C");
    }
    static void methodB() {
        methodC();
    }
    static void methodA() {
        try {
            methodB();
        } catch (RuntimeException e) {
            System.out.println("Caught in A: " + e.getMessage());
            // e.printStackTrace() would show the stack trace
        }
    }

    public static void main(String[] args) {
        // 1. Safe divide
        System.out.println("10/2 = " + safeDivide(10, 2)); // 5
        System.out.println("10/0 = " + safeDivide(10, 0)); // caught, returns 0

        // 2. Multiple catch
        String[] arr = {"hello", null, "world"};
        multiCatch(arr, 1);  // NullPointerException
        multiCatch(arr, 10); // ArrayIndexOutOfBoundsException

        // 3. Finally
        System.out.println("\nWith finally: " + readWithFinally("any.txt"));

        // 4. Try-with-resources
        System.out.println("Try-with-resources: " + tryWithResources("first line\nsecond line"));

        // 5. Multi-catch
        System.out.println("parseAndGet: " + parseAndGet(arr, "abc")); // NumberFormatException
        System.out.println("parseAndGet: " + parseAndGet(arr, "99"));  // AIOOBE

        // 6. Throwing
        System.out.println("sqrt(16) = " + sqrt(16)); // 4
        try { sqrt(-1); } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }

        // 7. Re-throwing
        try { processFile("bad.txt"); } catch (IOException e) { System.out.println("Caller caught: " + e.getMessage()); }
        try { processFile("good.txt"); } catch (IOException e) { /* won't throw */ }

        // 8. Exception chaining
        try { connectToDatabase(null); }
        catch (RuntimeException e) {
            System.out.println("Chained: " + e.getMessage() + " | Cause: " + e.getCause().getMessage());
        }

        // 9. Checked
        try { System.out.println(checkedExample("data.txt")); }
        catch (FileNotFoundException e) { System.out.println(e.getMessage()); }

        // 10. Stack unwinding
        methodA();

        System.out.println("\n=== Exception Quick Reference ===");
        System.out.println("Checked     → must catch or declare throws");
        System.out.println("Unchecked   → RuntimeException subclasses, optional");
        System.out.println("finally     → always runs (cleanup)");
        System.out.println("try-with-resources → auto close (implements AutoCloseable)");
        System.out.println("throw       → throw exception");
        System.out.println("throws      → declare method may throw");
    }
}
