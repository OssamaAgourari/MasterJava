package org.example.Algorithms.Searching.LinearSearch;

import java.util.*;

/**
 * ============================================================
 *              LINEAR SEARCH — COMPLETE GUIDE
 * ============================================================
 *
 * HOW IT WORKS:
 * --------------
 * Scan each element one by one until the target is found
 * or the entire structure is exhausted.
 *
 * TIME COMPLEXITY:
 * -----------------
 *   Best:    O(1)  — target is at first position
 *   Average: O(n)
 *   Worst:   O(n)  — target not present or at last position
 *
 * SPACE: O(1) — no extra space needed
 *
 * REQUIREMENT: NONE — works on unsorted, sorted, any structure
 *
 * WHEN TO USE:
 * -------------
 *   ✔ Unsorted arrays/lists (binary search requires sorted)
 *   ✔ Small arrays (overhead of sorting not worth it)
 *   ✔ Searching linked lists (no random access)
 *   ✔ Finding all occurrences
 *   ✔ Searching 2D arrays without sorted property
 *   ✗ Large sorted arrays — use binary search O(log n) instead
 *
 * VARIANTS:
 * ----------
 *   1. Find first occurrence
 *   2. Find last occurrence
 *   3. Find all occurrences
 *   4. Sentinel linear search (slightly faster)
 *   5. Search in 2D array
 *   6. Search with custom comparator
 *
 * ============================================================
 */
public class LinearSearch {

    // ── 1. Basic: find first occurrence ──────────────────────
    static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target) return i;
        return -1;
    }

    // ── 2. Find last occurrence ───────────────────────────────
    static int searchLast(int[] arr, int target) {
        int result = -1;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target) result = i;
        return result;
    }

    // ── 3. Find all occurrences ───────────────────────────────
    static List<Integer> searchAll(int[] arr, int target) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target) indices.add(i);
        return indices;
    }

    // ── 4. Sentinel linear search (avoids boundary check) ────
    // Put target at end as sentinel → only need one comparison per loop
    static int sentinelSearch(int[] arr, int target) {
        int n = arr.length;
        int last = arr[n - 1];
        arr[n - 1] = target; // set sentinel
        int i = 0;
        while (arr[i] != target) i++;
        arr[n - 1] = last; // restore
        if (i < n - 1 || arr[n - 1] == target) return i;
        return -1;
    }

    // ── 5. Count occurrences ──────────────────────────────────
    static int countOccurrences(int[] arr, int target) {
        int count = 0;
        for (int x : arr) if (x == target) count++;
        return count;
    }

    // ── 6. Search in 2D array ─────────────────────────────────
    static int[] searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (matrix[i][j] == target) return new int[]{i, j};
        return new int[]{-1, -1};
    }

    // ── 7. Search in string array ─────────────────────────────
    static int searchString(String[] arr, String target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i].equals(target)) return i;
        return -1;
    }

    // ── 8. Find max element ───────────────────────────────────
    static int findMax(int[] arr) {
        int max = arr[0];
        for (int x : arr) if (x > max) max = x;
        return max;
    }

    // ── 9. Find min element ───────────────────────────────────
    static int findMin(int[] arr) {
        int min = arr[0];
        for (int x : arr) if (x < min) min = x;
        return min;
    }

    // ── 10. Linear search with condition (lambda) ────────────
    static <T> int searchIf(T[] arr, java.util.function.Predicate<T> condition) {
        for (int i = 0; i < arr.length; i++)
            if (condition.test(arr[i])) return i;
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {64, 34, 25, 12, 22, 11, 90, 25};

        // EXERCISE 1: First occurrence
        System.out.println("Search 25 (first): " + search(arr, 25));       // 2
        System.out.println("Search 99 (not found): " + search(arr, 99));   // -1

        // EXERCISE 2: Last occurrence
        System.out.println("Search 25 (last): " + searchLast(arr, 25));    // 7

        // EXERCISE 3: All occurrences
        System.out.println("Search 25 (all): " + searchAll(arr, 25));      // [2, 7]

        // EXERCISE 4: Sentinel search
        int[] arr2 = {64, 34, 25, 12, 22, 11, 90, 25};
        System.out.println("Sentinel search 22: " + sentinelSearch(arr2, 22));  // 4
        System.out.println("Sentinel search 99: " + sentinelSearch(arr2, 99));  // -1

        // EXERCISE 5: Count occurrences
        System.out.println("Count of 25: " + countOccurrences(arr, 25));   // 2
        System.out.println("Count of 99: " + countOccurrences(arr, 99));   // 0

        // EXERCISE 6: 2D search
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Matrix search 5: " + Arrays.toString(searchMatrix(matrix, 5)));   // [1,1]
        System.out.println("Matrix search 10: " + Arrays.toString(searchMatrix(matrix, 10))); // [-1,-1]

        // EXERCISE 7: String search
        String[] names = {"Alice", "Bob", "Charlie", "David"};
        System.out.println("Search 'Charlie': " + searchString(names, "Charlie")); // 2
        System.out.println("Search 'Eve': " + searchString(names, "Eve"));         // -1

        // EXERCISE 8: Find max/min
        System.out.println("Max: " + findMax(arr)); // 90
        System.out.println("Min: " + findMin(arr)); // 11

        // EXERCISE 9: Search with predicate
        Integer[] nums = {-3, 1, -7, 4, 2};
        int idx = searchIf(nums, x -> x > 3);
        System.out.println("First element > 3 at index: " + idx); // 3

        // EXERCISE 10: Performance comparison
        int N = 1_000_000;
        int[] big = new int[N];
        java.util.Random rng = new java.util.Random(42);
        for (int i = 0; i < N; i++) big[i] = rng.nextInt(N);
        int target = big[N / 2]; // guaranteed to find

        long t1 = System.nanoTime();
        search(big, target);
        System.out.printf("%nLinear search n=%d: %.2f ms%n", N, (System.nanoTime()-t1)/1e6);

        Arrays.sort(big); // sort for binary search comparison
        long t2 = System.nanoTime();
        Arrays.binarySearch(big, target);
        System.out.printf("Binary search n=%d: %.2f ms%n", N, (System.nanoTime()-t2)/1e6);

        // SUMMARY
        System.out.println("\n=== Linear Search ===");
        System.out.println("Time:        O(n) — scans each element");
        System.out.println("Space:       O(1)");
        System.out.println("Requirement: NONE — works on any sequence");
        System.out.println("Advantage:   Simple, works unsorted, finds all occurrences");
        System.out.println("Disadvantage: Slow for large sorted arrays (use binary search)");
    }
}
