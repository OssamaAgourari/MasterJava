package org.example.Algorithms.Sorting.Merge;

import java.util.Arrays;

/**
 * ============================================================
 *              MERGE SORT — COMPLETE GUIDE
 * ============================================================
 *
 * HOW IT WORKS:
 * --------------
 * DIVIDE AND CONQUER:
 *   1. Divide array into two halves (recursively until size = 1)
 *   2. Conquer: recursively sort each half
 *   3. Combine: merge the two sorted halves
 *
 *   [38,27,43,3,9,82,10]
 *   → [38,27,43,3]   [9,82,10]
 *   → [38,27][43,3]  [9,82][10]
 *   → [38][27][43][3] [9][82][10]
 *   ← [27,38][3,43]  [9,82][10]
 *   ← [3,27,38,43]   [9,10,82]
 *   ← [3,9,10,27,38,43,82]
 *
 * TIME COMPLEXITY:
 * -----------------
 *   Best/Average/Worst: O(n log n) — always!
 *   Recurrence: T(n) = 2T(n/2) + O(n)
 *
 * SPACE: O(n) — needs auxiliary array for merging
 * STABLE: YES — equal elements stay in original order
 *
 * WHEN TO USE:
 * -------------
 *   ✔ Stable sort is required
 *   ✔ Sorting linked lists (no random access needed)
 *   ✔ External sorting (data too large for memory)
 *   ✔ Guaranteed O(n log n) is needed
 *   ✗ Memory is limited (use heap sort instead)
 *
 * ============================================================
 */
public class Merge {

    // ── Standard recursive merge sort ────────────────────────
    static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;  // avoids overflow
        mergeSort(arr, left,  mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        // Create temp arrays
        int[] L = Arrays.copyOfRange(arr, left, mid+1);
        int[] R = Arrays.copyOfRange(arr, mid+1, right+1);

        int i = 0, j = 0, k = left;
        while (i < L.length && j < R.length) {
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++]; // <= makes it stable
        }
        while (i < L.length) arr[k++] = L[i++];
        while (j < R.length) arr[k++] = R[j++];
    }

    // ── Bottom-up merge sort (iterative, no recursion) ────────
    static void mergeSortBottomUp(int[] arr) {
        int n = arr.length;
        for (int size = 1; size < n; size *= 2) {
            for (int left = 0; left < n - size; left += 2 * size) {
                int mid   = left + size - 1;
                int right = Math.min(left + 2*size - 1, n-1);
                merge(arr, left, mid, right);
            }
        }
    }

    // ── Count inversions using merge sort ─────────────────────
    // Inversion: pair (i,j) where i < j but arr[i] > arr[j]
    static long countInversions(int[] arr) {
        return mergeSortCount(arr, 0, arr.length - 1);
    }
    static long mergeSortCount(int[] arr, int l, int r) {
        if (l >= r) return 0;
        int mid = (l+r)/2;
        long count = mergeSortCount(arr,l,mid) + mergeSortCount(arr,mid+1,r);
        count += mergeCount(arr, l, mid, r);
        return count;
    }
    static long mergeCount(int[] arr, int l, int mid, int r) {
        int[] L = Arrays.copyOfRange(arr,l,mid+1);
        int[] R = Arrays.copyOfRange(arr,mid+1,r+1);
        long inversions = 0;
        int i=0,j=0,k=l;
        while (i<L.length && j<R.length) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else { arr[k++] = R[j++]; inversions += L.length - i; }
        }
        while (i<L.length) arr[k++]=L[i++];
        while (j<R.length) arr[k++]=R[j++];
        return inversions;
    }

    public static void main(String[] args) {

        // EXERCISE 1: Basic merge sort
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Before: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length-1);
        System.out.println("After:  " + Arrays.toString(arr));

        // EXERCISE 2: Step-by-step visualization
        System.out.println("\nStep-by-step:");
        int[] step = {5, 2, 8, 1, 9, 3};
        mergeSortVerbose(step, 0, step.length-1, 0);
        System.out.println("Final: " + Arrays.toString(step));

        // EXERCISE 3: Bottom-up (iterative)
        int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        mergeSortBottomUp(arr2);
        System.out.println("Bottom-up: " + Arrays.toString(arr2));

        // EXERCISE 4: Count inversions
        int[] inv = {8, 4, 2, 1};
        System.out.println("Inversions in [8,4,2,1]: " + countInversions(inv)); // 6

        int[] inv2 = {1, 3, 2, 3, 1};
        System.out.println("Inversions in [1,3,2,3,1]: " + countInversions(inv2)); // 4

        // EXERCISE 5: Merge two sorted arrays
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 8};
        int[] merged = mergeTwoSortedArrays(a, b);
        System.out.println("Merged: " + Arrays.toString(merged));

        // EXERCISE 6: Performance on large input
        int N = 100_000;
        int[] big = new java.util.Random(42).ints(N).toArray();
        long t = System.nanoTime();
        mergeSort(big, 0, big.length-1);
        System.out.printf("Merge sort n=%,d: %.2f ms%n", N, (System.nanoTime()-t)/1e6);

        // SUMMARY
        System.out.println("\n=== Merge Sort ===");
        System.out.println("Best/Avg/Worst: O(n log n) — guaranteed");
        System.out.println("Space:          O(n)        — extra array");
        System.out.println("Stable:         YES");
        System.out.println("Best for:       linked lists, external sorting, stable sort");
    }

    static int[] mergeTwoSortedArrays(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i=0,j=0,k=0;
        while (i<a.length&&j<b.length) result[k++]=a[i]<=b[j]?a[i++]:b[j++];
        while (i<a.length) result[k++]=a[i++];
        while (j<b.length) result[k++]=b[j++];
        return result;
    }

    static void mergeSortVerbose(int[] arr, int l, int r, int depth) {
        if (l >= r) return;
        int mid = (l+r)/2;
        mergeSortVerbose(arr, l, mid,   depth+1);
        mergeSortVerbose(arr, mid+1, r, depth+1);
        merge(arr, l, mid, r);
        System.out.println("  ".repeat(depth) + "merge ["+l+".."+r+"]: " + Arrays.toString(Arrays.copyOfRange(arr,l,r+1)));
    }
}
