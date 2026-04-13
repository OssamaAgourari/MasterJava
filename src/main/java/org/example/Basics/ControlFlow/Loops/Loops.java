package org.example.Basics.ControlFlow.Loops;

import java.util.Arrays;

/**
 * ============================================================
 *              JAVA LOOPS — COMPLETE GUIDE
 * ============================================================
 *
 * LOOP TYPES:
 * -----------
 *   for           — known iteration count, index available
 *   while         — condition-controlled, check BEFORE body
 *   do-while      — body runs AT LEAST ONCE, check AFTER body
 *   for-each      — iterate over array/Iterable, no index
 *
 * CONTROL STATEMENTS:
 * -------------------
 *   break         — exit the nearest enclosing loop
 *   continue      — skip to next iteration
 *   break LABEL   — exit outer labeled loop
 *   continue LABEL— continue outer labeled loop
 *
 * COMMON PATTERNS:
 * ----------------
 *   Counting        : for (int i = 0; i < n; i++)
 *   Reverse         : for (int i = n-1; i >= 0; i--)
 *   Step 2          : for (int i = 0; i < n; i += 2)
 *   Until condition : while (!done) { ... }
 *   Menu loop       : do { show(); choice=read(); } while (choice != 0)
 *   Nested loops    : O(n²) — matrix, multiplication table
 *
 * ============================================================
 */
public class Loops {

    // ── 1. Basic for loop ─────────────────────────────────────
    static int sumRange(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) sum += i;
        return sum;
    }

    // ── 2. Reverse loop ───────────────────────────────────────
    static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            sb.append(s.charAt(i));
        return sb.toString();
    }

    // ── 3. While loop — binary digits ────────────────────────
    static String toBinary(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, n % 2);
            n /= 2;
        }
        return sb.toString();
    }

    // ── 4. Do-while — number guessing simulation ──────────────
    static int countDigits(int n) {
        int count = 0;
        n = Math.abs(n);
        do {
            count++;
            n /= 10;
        } while (n > 0);
        return count;
    }

    // ── 5. For-each ───────────────────────────────────────────
    static int sumArray(int[] arr) {
        int sum = 0;
        for (int x : arr) sum += x;
        return sum;
    }

    // ── 6. Nested loops — multiplication table ────────────────
    static int[][] multiplicationTable(int n) {
        int[][] table = new int[n][n];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                table[i-1][j-1] = i * j;
        return table;
    }

    // ── 7. Break and continue ─────────────────────────────────
    static int firstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) return i; // early exit via return (or break)
        }
        return -1;
    }
    static int sumPositives(int[] arr) {
        int sum = 0;
        for (int x : arr) {
            if (x <= 0) continue; // skip non-positives
            sum += x;
        }
        return sum;
    }

    // ── 8. Labeled break — nested loop exit ──────────────────
    static int[] findInMatrix(int[][] matrix, int target) {
        outer:
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // ── 9. While loop — collatz conjecture ───────────────────
    static int collatzSteps(int n) {
        int steps = 0;
        while (n != 1) {
            if (n % 2 == 0) n /= 2;
            else             n = 3 * n + 1;
            steps++;
        }
        return steps;
    }

    // ── 10. Infinite loop with break ─────────────────────────
    static int[] fibonacci(int count) {
        int[] fib = new int[count];
        int a = 0, b = 1;
        for (int i = 0; i < count; i++) {
            fib[i] = a;
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        return fib;
    }

    // ── 11. For loop over String chars ────────────────────────
    static boolean isPalindrome(String s) {
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) return false;
            lo++; hi--;
        }
        return true;
    }

    // ── 12. Sieve of Eratosthenes — prime numbers ─────────────
    static boolean[] sievePrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i)
                    isPrime[j] = false;
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        // 1. Sum range
        System.out.println("Sum 1..10: " + sumRange(1, 10)); // 55

        // 2. Reverse string
        System.out.println("Reverse 'hello': " + reverseString("hello")); // olleh

        // 3. To binary
        System.out.println("42 in binary: " + toBinary(42)); // 101010

        // 4. Count digits
        System.out.println("Digits in 12345: " + countDigits(12345)); // 5

        // 5. Sum array
        System.out.println("Sum [1..5]: " + sumArray(new int[]{1,2,3,4,5})); // 15

        // 6. Multiplication table 3x3
        int[][] table = multiplicationTable(3);
        System.out.println("3x3 table: " + Arrays.deepToString(table));
        // [[1,2,3],[2,4,6],[3,6,9]]

        // 7. Break / continue
        System.out.println("First negative index: " + firstNegative(new int[]{3,1,-2,4,-5})); // 2
        System.out.println("Sum positives: " + sumPositives(new int[]{1,-2,3,-4,5})); // 9

        // 8. Find in matrix
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Find 5 in matrix: " + Arrays.toString(findInMatrix(mat, 5))); // [1,1]

        // 9. Collatz
        System.out.println("Collatz(6) steps: " + collatzSteps(6)); // 8

        // 10. Fibonacci
        System.out.println("Fibonacci(8): " + Arrays.toString(fibonacci(8)));
        // [0,1,1,2,3,5,8,13]

        // 11. Palindrome
        System.out.println("'racecar' palindrome: " + isPalindrome("racecar")); // true
        System.out.println("'hello' palindrome:   " + isPalindrome("hello"));   // false

        // 12. Sieve primes up to 20
        boolean[] sieve = sievePrimes(20);
        System.out.print("Primes up to 20: ");
        for (int i = 2; i <= 20; i++) if (sieve[i]) System.out.print(i + " ");
        System.out.println();

        System.out.println("\n=== Loop Quick Reference ===");
        System.out.println("for       → count-based, index available");
        System.out.println("while     → condition first, may not execute");
        System.out.println("do-while  → body first, always runs once");
        System.out.println("for-each  → clean iteration, no index needed");
        System.out.println("break     → exit loop");
        System.out.println("continue  → skip iteration");
    }
}
