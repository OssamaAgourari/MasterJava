package org.example.Algorithms.Sorting.Selection;

import java.util.Arrays;

/**
 * ============================================================
 *              SELECTION SORT — COMPLETE GUIDE
 * ============================================================
 *
 * HOW IT WORKS:
 * --------------
 * Repeatedly find the MINIMUM element from the unsorted portion
 * and place it at the beginning.
 *
 *   Pass 1: Find min in [0..n-1], swap with index 0
 *   Pass 2: Find min in [1..n-1], swap with index 1
 *   ...
 *   Pass n-1: Find min in [n-2..n-1], swap with index n-2
 *
 * Example:
 *   [64, 25, 12, 22, 11]
 *   → [11, 25, 12, 22, 64]  (11 swapped with 64)
 *   → [11, 12, 25, 22, 64]  (12 swapped with 25)
 *   → [11, 12, 22, 25, 64]  (22 swapped with 25)
 *   → [11, 12, 22, 25, 64]  (already in place)
 *
 * TIME COMPLEXITY:
 * -----------------
 *   Best:    O(n²) — ALWAYS makes n*(n-1)/2 comparisons
 *   Average: O(n²)
 *   Worst:   O(n²)
 *
 * SWAPS: O(n) — at most n-1 swaps (advantage over Bubble!)
 *
 * SPACE: O(1) — in-place
 * STABLE: NO (swaps can move equal elements)
 *
 * WHEN TO USE:
 * -------------
 *   ✔ When memory writes are costly (minimizes swaps: O(n))
 *   ✔ Small arrays (simple implementation)
 *   ✗ Never use for large arrays — O(n²) always
 *   ✗ Not adaptive — doesn't benefit from sorted input
 *
 * COMPARISON WITH BUBBLE SORT:
 *   Both O(n²), but Selection makes fewer SWAPS
 *   Bubble: O(n²) swaps worst case
 *   Selection: O(n) swaps always
 *
 * ============================================================
 */
public class Selection {

    // ── Basic Selection Sort ─────────────────────────────────
    static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            // swap arr[i] with arr[minIdx]
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // ── Selection Sort with step visualization ───────────────
    static void selectionSortVerbose(int[] arr) {
        int n = arr.length;
        int swaps = 0;
        System.out.println("Selection Sort — step by step:");
        System.out.println("Start: " + Arrays.toString(arr));
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[minIdx]) minIdx = j;
            if (minIdx != i) {
                int temp = arr[minIdx]; arr[minIdx] = arr[i]; arr[i] = temp;
                swaps++;
                System.out.printf("Pass %d: swap idx %d↔%d → %s%n", i+1, i, minIdx, Arrays.toString(arr));
            } else {
                System.out.printf("Pass %d: already in place → %s%n", i+1, Arrays.toString(arr));
            }
        }
        System.out.println("Done. Total swaps: " + swaps);
    }

    // ── Selection Sort — descending ──────────────────────────
    static void selectionSortDesc(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] > arr[maxIdx]) maxIdx = j;
            int temp = arr[maxIdx]; arr[maxIdx] = arr[i]; arr[i] = temp;
        }
    }

    // ── Selection Sort on strings ────────────────────────────
    static void selectionSortStrings(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j].compareTo(arr[minIdx]) < 0) minIdx = j;
            String temp = arr[minIdx]; arr[minIdx] = arr[i]; arr[i] = temp;
        }
    }

    // ── Count comparisons and swaps ───────────────────────────
    static int[] countOps(int[] arr) {
        int n = arr.length, comparisons = 0, swaps = 0;
        int[] a = arr.clone();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) { comparisons++; if (a[j] < a[minIdx]) minIdx = j; }
            if (minIdx != i) { int t = a[minIdx]; a[minIdx] = a[i]; a[i] = t; swaps++; }
        }
        return new int[]{comparisons, swaps};
    }

    public static void main(String[] args) {

        // EXERCISE 1: Basic sort
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Before: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("After:  " + Arrays.toString(arr)); // [11,12,22,25,64]

        // EXERCISE 2: Step-by-step visualization
        System.out.println();
        selectionSortVerbose(new int[]{29, 10, 14, 37, 13});

        // EXERCISE 3: Descending sort
        int[] desc = {5, 3, 8, 1, 9, 2};
        selectionSortDesc(desc);
        System.out.println("\nDescending: " + Arrays.toString(desc)); // [9,8,5,3,2,1]

        // EXERCISE 4: Already sorted (still O(n²) comparisons)
        int[] sorted = {1, 2, 3, 4, 5};
        int[] ops1 = countOps(sorted);
        System.out.printf("%nSorted input — comparisons: %d, swaps: %d%n", ops1[0], ops1[1]);

        // EXERCISE 5: Reverse sorted (max swaps)
        int[] reversed = {5, 4, 3, 2, 1};
        int[] ops2 = countOps(reversed);
        System.out.printf("Reversed input — comparisons: %d, swaps: %d%n", ops2[0], ops2[1]);

        // EXERCISE 6: String sorting
        String[] names = {"banana", "apple", "cherry", "date"};
        selectionSortStrings(names);
        System.out.println("\nStrings sorted: " + Arrays.toString(names)); // [apple,banana,cherry,date]

        // EXERCISE 7: Single element (no-op)
        int[] single = {42};
        selectionSort(single);
        System.out.println("Single: " + Arrays.toString(single)); // [42]

        // EXERCISE 8: Two elements
        int[] two = {9, 1};
        selectionSort(two);
        System.out.println("Two: " + Arrays.toString(two)); // [1,9]

        // EXERCISE 9: All duplicates (no swaps needed)
        int[] dups = {5, 5, 5, 5};
        int[] ops3 = countOps(dups);
        System.out.printf("All duplicates — comparisons: %d, swaps: %d%n", ops3[0], ops3[1]);

        // EXERCISE 10: Performance comparison with n=100
        int N = 100;
        int[] random = new int[N];
        java.util.Random rng = new java.util.Random(42);
        for (int i = 0; i < N; i++) random[i] = rng.nextInt(N);
        int[] ops4 = countOps(random);
        System.out.printf("n=%d random — comparisons: %d, swaps: %d (selection always ≤ n swaps)%n",
                N, ops4[0], ops4[1]);

        // SUMMARY
        System.out.println("\n=== Selection Sort ===");
        System.out.println("Time:   O(n²) — always, no early exit");
        System.out.println("Swaps:  O(n)  — at most n-1 swaps (best feature!)");
        System.out.println("Space:  O(1)");
        System.out.println("Stable: NO");
        System.out.println("Use when: write cost > read cost (e.g., flash memory)");
    }
}
