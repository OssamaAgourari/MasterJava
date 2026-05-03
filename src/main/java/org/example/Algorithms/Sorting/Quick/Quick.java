package org.example.Algorithms.Sorting.Quick;

import java.util.Arrays;
import java.util.Random;

/**
 * ============================================================
 *              QUICK SORT — COMPLETE GUIDE
 * ============================================================
 *
 * HOW IT WORKS:
 * --------------
 * DIVIDE AND CONQUER:
 *   1. Pick a PIVOT element
 *   2. PARTITION: rearrange so elements < pivot are left,
 *                 elements > pivot are right
 *   3. Recursively sort left and right sub-arrays
 *
 *   Partition example (pivot = last element):
 *   [3, 6, 8, 10, 1, 2, 1]  pivot=1
 *   → [1, 1 | 2 | 3, 6, 8, 10]  (pivot at index 2)
 *
 * TIME COMPLEXITY:
 * -----------------
 *   Best/Average: O(n log n) — pivot splits evenly
 *   Worst:        O(n²)      — pivot is always min/max (sorted input)
 *
 * SPACE: O(log n) average — recursion stack depth
 * STABLE: NO
 *
 * PIVOT STRATEGIES:
 * ------------------
 *   Last element — simple but O(n²) on sorted input
 *   Random       — avoids worst case in practice
 *   Median of 3  — choose median of first, mid, last
 *   3-way        — handles duplicates efficiently (Dutch flag)
 *
 * WHEN TO USE:
 * -------------
 *   ✔ Best average-case performance in practice
 *   ✔ In-place (O(1) extra space excluding recursion)
 *   ✔ Cache-friendly (sequential access)
 *   ✗ Worst case O(n²) — use merge/heap if guaranteed needed
 *   ✗ Not stable — use merge sort if stability required
 *
 * ============================================================
 */
public class Quick {

    // ── Basic (last element as pivot) ────────────────────────
    static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(arr, lo, hi);
        quickSort(arr, lo, p - 1);
        quickSort(arr, p + 1, hi);
    }

    static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (arr[j] <= pivot) {
                i++;
                int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            }
        }
        int t = arr[i+1]; arr[i+1] = arr[hi]; arr[hi] = t;
        return i + 1;
    }

    // ── Randomized pivot — avoids O(n²) on sorted input ──────
    static final Random rng = new Random(42);

    static void quickSortRandom(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        // swap random element with last
        int r = lo + rng.nextInt(hi - lo + 1);
        int t = arr[r]; arr[r] = arr[hi]; arr[hi] = t;
        int p = partition(arr, lo, hi);
        quickSortRandom(arr, lo, p-1);
        quickSortRandom(arr, p+1, hi);
    }

    // ── 3-way partition (Dutch National Flag) ────────────────
    // Best for arrays with many duplicates
    static void quickSort3Way(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int pivot = arr[lo];
        int lt = lo, gt = hi, i = lo + 1;
        while (i <= gt) {
            if      (arr[i] < pivot) { int t=arr[i];arr[i]=arr[lt];arr[lt]=t; lt++; i++; }
            else if (arr[i] > pivot) { int t=arr[i];arr[i]=arr[gt];arr[gt]=t; gt--; }
            else                     i++;
        }
        // arr[lo..lt-1] < pivot, arr[lt..gt] = pivot, arr[gt+1..hi] > pivot
        quickSort3Way(arr, lo,   lt-1);
        quickSort3Way(arr, gt+1, hi);
    }

    // ── QuickSelect — Kth smallest in O(n) average ────────────
    static int quickSelect(int[] arr, int lo, int hi, int k) {
        if (lo == hi) return arr[lo];
        int r = lo + rng.nextInt(hi - lo + 1);
        int t = arr[r]; arr[r] = arr[hi]; arr[hi] = t;
        int p = partition(arr, lo, hi);
        if      (k < p) return quickSelect(arr, lo, p-1, k);
        else if (k > p) return quickSelect(arr, p+1, hi, k);
        else            return arr[p];
    }

    public static void main(String[] args) {

        // EXERCISE 1: Basic quick sort
        int[] arr = {3, 6, 8, 10, 1, 2, 1};
        System.out.println("Before: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println("After:  " + Arrays.toString(arr));

        // EXERCISE 2: Randomized quick sort
        int[] arr2 = {38, 27, 43, 3, 9, 82, 10};
        quickSortRandom(arr2, 0, arr2.length-1);
        System.out.println("Random pivot: " + Arrays.toString(arr2));

        // EXERCISE 3: 3-way (handles duplicates efficiently)
        int[] arr3 = {4, 9, 4, 4, 1, 9, 4, 4, 9, 4};
        quickSort3Way(arr3, 0, arr3.length-1);
        System.out.println("3-way: " + Arrays.toString(arr3));

        // EXERCISE 4: Step-by-step partition
        int[] step = {10, 80, 30, 90, 40, 50, 70};
        System.out.println("\nPartition demo (pivot = last = 70):");
        System.out.println("Before: " + Arrays.toString(step));
        int p = partition(step, 0, step.length-1);
        System.out.println("After:  " + Arrays.toString(step) + " (pivot at " + p + ")");

        // EXERCISE 5: QuickSelect — Kth smallest in O(n) avg
        int[] nums = {7, 10, 4, 3, 20, 15};
        int k = 3; // 3rd smallest
        int result = quickSelect(nums.clone(), 0, nums.length-1, k-1);
        System.out.println("\nKth smallest (k=3): " + result); // 7

        // EXERCISE 6: Worst case — sorted input (bad pivot = last)
        int N = 1000;
        int[] sorted   = new int[N]; for(int i=0;i<N;i++) sorted[i]=i;
        int[] reversed = new int[N]; for(int i=0;i<N;i++) reversed[i]=N-i;
        int[] random   = new int[N]; Random r = new Random(42); for(int i=0;i<N;i++) random[i]=r.nextInt(N);

        long t;
        t = System.nanoTime(); quickSort(sorted.clone(), 0, N-1);
        System.out.printf("Quick (sorted   n=%d): %.2f ms%n", N, (System.nanoTime()-t)/1e6);
        t = System.nanoTime(); quickSortRandom(sorted.clone(), 0, N-1);
        System.out.printf("Quick-rand(sorted): %.2f ms%n", (System.nanoTime()-t)/1e6);
        t = System.nanoTime(); quickSortRandom(random.clone(), 0, N-1);
        System.out.printf("Quick-rand(random): %.2f ms%n", (System.nanoTime()-t)/1e6);

        // SUMMARY
        System.out.println("\n=== Quick Sort ===");
        System.out.println("Best/Avg: O(n log n)");
        System.out.println("Worst:    O(n²) — always-bad pivot (use random!)");
        System.out.println("Space:    O(log n) stack");
        System.out.println("Stable:   NO");
        System.out.println("Use randomized pivot to avoid worst case.");
        System.out.println("Use 3-way partition for duplicate-heavy arrays.");
    }
}
