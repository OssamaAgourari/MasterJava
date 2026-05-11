package org.example.Algorithms.Recursion;

import java.util.*;

/**
 * ============================================================
 *               RECURSION — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS RECURSION?
 * -------------------
 * A function that calls itself with a smaller sub-problem,
 * until it reaches a BASE CASE that stops the recursion.
 *
 * ANATOMY OF EVERY RECURSIVE FUNCTION:
 * --------------------------------------
 *   1. BASE CASE  — condition to stop (no more calls)
 *   2. RECURSIVE CASE — call with smaller input
 *   3. COMBINE — use result of sub-call to build answer
 *
 * TYPES:
 * -------
 *   Linear      — one recursive call per frame (factorial, power)
 *   Binary      — two calls per frame (fibonacci, tree traversal)
 *   Tail        — call is last statement (can be optimized by JVM)
 *   Mutual      — f() calls g(), g() calls f()
 *   Indirect    — f() → g() → h() → f()
 *
 * CALL STACK (stack frames):
 * ---------------------------
 *   Each recursive call adds a frame to the call stack.
 *   Too many frames → StackOverflowError
 *   Max depth ≈ 10000 in Java (depends on frame size)
 *
 * TIME / SPACE:
 * --------------
 *   Fibonacci (naive):   O(2^n) time, O(n) space
 *   Fibonacci (memo):    O(n)   time, O(n) space
 *   Merge sort:          O(n log n) time, O(n) space
 *   Binary search:       O(log n) time, O(log n) space
 *
 * GOLDEN RULES:
 * --------------
 *   ✔ Always define base case(s) first
 *   ✔ Each call must get closer to base case
 *   ✔ Trust the recursive call — assume it works
 *   ✔ If n→n-1 is O(n), add memoization for O(1) repeats
 *
 * ============================================================
 */
public class Recursion {

    // ── 1. Factorial ─────────────────────────────────────────
    // n! = n * (n-1)!       base: 0! = 1
    // Time O(n), Space O(n)
    static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // ── 2. Fibonacci — naive O(2^n) ──────────────────────────
    static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    // ── 3. Fibonacci — memoized O(n) ─────────────────────────
    static int fibMemo(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        return memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
    }

    // ── 4. Power (fast exponentiation) ───────────────────────
    // a^n = a^(n/2) * a^(n/2) [if even], a * a^(n-1) [if odd]
    // Time O(log n)
    static double power(double base, int exp) {
        if (exp == 0) return 1;
        if (exp < 0)  return 1.0 / power(base, -exp);
        double half = power(base, exp / 2);
        return exp % 2 == 0 ? half * half : base * half * half;
    }

    // ── 5. Sum of digits ──────────────────────────────────────
    static int sumDigits(int n) {
        if (n < 10) return n;
        return n % 10 + sumDigits(n / 10);
    }

    // ── 6. Reverse a string ───────────────────────────────────
    static String reverse(String s) {
        if (s.length() <= 1) return s;
        return reverse(s.substring(1)) + s.charAt(0);
    }

    // ── 7. Check palindrome ───────────────────────────────────
    static boolean isPalindrome(String s, int lo, int hi) {
        if (lo >= hi) return true;
        return s.charAt(lo) == s.charAt(hi) && isPalindrome(s, lo + 1, hi - 1);
    }

    // ── 8. Binary search (recursive) ─────────────────────────
    static int binarySearch(int[] arr, int lo, int hi, int target) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if      (arr[mid] == target) return mid;
        else if (arr[mid] <  target) return binarySearch(arr, mid + 1, hi, target);
        else                         return binarySearch(arr, lo, mid - 1, target);
    }

    // ── 9. Tower of Hanoi ────────────────────────────────────
    // Move n disks from A → C using B as auxiliary
    // Minimum moves: 2^n - 1
    static void hanoi(int n, char from, char to, char aux) {
        if (n == 1) { System.out.println("Move disk 1 from " + from + " to " + to); return; }
        hanoi(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        hanoi(n - 1, aux, to, from);
    }

    // ── 10. Generate all subsets (power set) ─────────────────
    // 2^n subsets
    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }
    static void generateSubsets(int[] nums, int idx, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = idx; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsets(nums, i + 1, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }

    // ── 11. Generate all permutations ────────────────────────
    static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePerms(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }
    static void generatePerms(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> res) {
        if (current.size() == nums.length) { res.add(new ArrayList<>(current)); return; }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            current.add(nums[i]);
            generatePerms(nums, current, used, res);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    // ── 12. Flood fill (recursive DFS on 2D grid) ────────────
    static int[][] floodFill(int[][] image, int row, int col, int color) {
        if (image[row][col] == color) return image;
        fill(image, row, col, image[row][col], color);
        return image;
    }
    static void fill(int[][] img, int r, int c, int orig, int newColor) {
        if (r < 0 || r >= img.length || c < 0 || c >= img[0].length) return;
        if (img[r][c] != orig) return;
        img[r][c] = newColor;
        fill(img, r+1, c, orig, newColor);
        fill(img, r-1, c, orig, newColor);
        fill(img, r, c+1, orig, newColor);
        fill(img, r, c-1, orig, newColor);
    }

    // ── 13. Flatten nested list ───────────────────────────────
    static List<Integer> flatten(List<Object> nested) {
        List<Integer> result = new ArrayList<>();
        for (Object item : nested) {
            if (item instanceof Integer) result.add((Integer) item);
            else result.addAll(flatten((List<Object>) item));
        }
        return result;
    }

    // ── 14. Count ways to climb stairs (1 or 2 steps) ────────
    static int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // ── 15. GCD (Euclid's algorithm) ─────────────────────────
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {

        System.out.println("=== Recursion Exercises ===\n");

        // EXERCISE 1
        System.out.println("Factorial(5) = " + factorial(5));   // 120
        System.out.println("Factorial(10)= " + factorial(10));  // 3628800

        // EXERCISE 2 & 3
        System.out.println("Fib(10) naive= " + fib(10));        // 55
        int[] memo = new int[50];
        System.out.println("Fib(40) memo = " + fibMemo(40, memo)); // 102334155

        // EXERCISE 4
        System.out.printf("2^10 = %.0f%n", power(2, 10));        // 1024
        System.out.printf("2^-3 = %.4f%n", power(2, -3));        // 0.1250

        // EXERCISE 5
        System.out.println("Sum digits(1234) = " + sumDigits(1234)); // 10

        // EXERCISE 6
        System.out.println("Reverse 'hello' = " + reverse("hello")); // olleh

        // EXERCISE 7
        System.out.println("isPalindrome 'racecar' = " + isPalindrome("racecar", 0, 6)); // true
        System.out.println("isPalindrome 'hello'   = " + isPalindrome("hello", 0, 4));   // false

        // EXERCISE 8
        int[] arr = {1, 3, 5, 7, 9, 11};
        System.out.println("BinarySearch(7) = " + binarySearch(arr, 0, arr.length - 1, 7)); // 3

        // EXERCISE 9
        System.out.println("\n--- Tower of Hanoi (3 disks) ---");
        hanoi(3, 'A', 'C', 'B');  // 7 moves

        // EXERCISE 10
        int[] sub = {1, 2, 3};
        System.out.println("\nSubsets of [1,2,3]: " + subsets(sub).size() + " subsets"); // 8

        // EXERCISE 11
        int[] perms = {1, 2, 3};
        System.out.println("Permutations of [1,2,3]: " + permutations(perms).size() + " perms"); // 6

        // EXERCISE 12
        int[][] img = {{1,1,1},{1,1,0},{1,0,1}};
        floodFill(img, 1, 1, 2);
        System.out.println("Flood fill: " + Arrays.deepToString(img));

        // EXERCISE 14
        System.out.println("Climb stairs(5) = " + climbStairs(5)); // 8

        // EXERCISE 15
        System.out.println("GCD(48,18) = " + gcd(48, 18)); // 6

        // SUMMARY
        System.out.println("\n=== Recursion Summary ===");
        System.out.println("Always define BASE CASE first");
        System.out.println("Trust recursive calls — assume they work");
        System.out.println("Memoize overlapping sub-problems → DP");
        System.out.println("Recursion = implicit stack; iteration = explicit stack");
    }
}
