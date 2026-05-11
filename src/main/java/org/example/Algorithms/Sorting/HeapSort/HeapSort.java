package org.example.Algorithms.Sorting.HeapSort;

import java.util.Arrays;

/**
 * ============================================================
 *               HEAP SORT — COMPLETE GUIDE
 * ============================================================
 *
 * HOW IT WORKS:
 * --------------
 * Uses a MAX-HEAP to sort in ascending order.
 *
 * PHASE 1 — BUILD MAX HEAP:  O(n)
 *   Convert array into a max-heap using heapify
 *   Start from last non-leaf node: (n/2 - 1) down to 0
 *
 * PHASE 2 — EXTRACT MAX REPEATEDLY:  O(n log n)
 *   Swap root (max) with last element
 *   Reduce heap size by 1
 *   Heapify root to restore max-heap property
 *   Repeat until heap size = 1
 *
 * Result: array sorted in ascending order.
 *
 * Example:
 *   [4,10,3,5,1]
 *   Build heap: [10,5,3,4,1]
 *   Extract 10 → [5,4,3,1,10] → sorted portion: [10]
 *   Extract 5  → [4,1,3,5,10] → sorted portion: [5,10]
 *   Extract 4  → [3,1,4,5,10] → sorted portion: [4,5,10]
 *   Extract 3  → [1,3,4,5,10] → sorted portion: [3,4,5,10]
 *   Done: [1,3,4,5,10]
 *
 * TIME COMPLEXITY:
 * -----------------
 *   Best:    O(n log n)
 *   Average: O(n log n)
 *   Worst:   O(n log n)  ← guaranteed, unlike QuickSort
 *
 * SPACE: O(1) — in-place, no extra array needed
 * STABLE: NO — swaps can change relative order of equal elements
 *
 * COMPARISON:
 *   vs QuickSort:   Heap guaranteed O(n log n), Quick is O(n²) worst
 *                   Quick is faster in practice (cache-friendly)
 *   vs MergeSort:   Both O(n log n), Merge is stable, Heap uses O(1) space
 *   Best of both:   IntroSort (used by Java Arrays.sort for primitives)
 *                   = QuickSort + HeapSort + InsertionSort hybrid
 *
 * ============================================================
 */
public class HeapSort {

    // ── Core: heapify down ────────────────────────────────────
    // Maintain max-heap property at index i, heap size = n
    static void heapifyDown(int[] arr, int n, int i) {
        int largest = i;
        int left    = 2 * i + 1;
        int right   = 2 * i + 2;

        if (left  < n && arr[left]  > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int swap = arr[i]; arr[i] = arr[largest]; arr[largest] = swap;
            heapifyDown(arr, n, largest); // fix the subtree that was swapped into
        }
    }

    // ── Phase 1: Build Max Heap ───────────────────────────────
    static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        // Start from last non-leaf node: (n/2 - 1)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(arr, n, i);
        }
    }

    // ── Main: Heap Sort ───────────────────────────────────────
    static void heapSort(int[] arr) {
        int n = arr.length;

        // Phase 1: Build max heap
        buildMaxHeap(arr);

        // Phase 2: Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root (max) to end
            int swap = arr[0]; arr[0] = arr[i]; arr[i] = swap;
            // Heapify the reduced heap
            heapifyDown(arr, i, 0);
        }
    }

    // ── Verbose Heap Sort ─────────────────────────────────────
    static void heapSortVerbose(int[] arr) {
        int n = arr.length;
        System.out.println("Input:      " + Arrays.toString(arr));

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--) heapifyDown(arr, n, i);
        System.out.println("Max heap:   " + Arrays.toString(arr));

        // Extract
        for (int i = n - 1; i > 0; i--) {
            int swap = arr[0]; arr[0] = arr[i]; arr[i] = swap;
            heapifyDown(arr, i, 0);
            System.out.println("Extracted " + arr[i] + ": " + Arrays.toString(arr));
        }
    }

    // ── Min Heap Sort (descending) ────────────────────────────
    static void heapifyMin(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1, right = 2 * i + 2;
        if (left  < n && arr[left]  < arr[smallest]) smallest = left;
        if (right < n && arr[right] < arr[smallest]) smallest = right;
        if (smallest != i) {
            int swap = arr[i]; arr[i] = arr[smallest]; arr[smallest] = swap;
            heapifyMin(arr, n, smallest);
        }
    }

    static void heapSortDesc(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapifyMin(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int swap = arr[0]; arr[0] = arr[i]; arr[i] = swap;
            heapifyMin(arr, i, 0);
        }
    }

    // ── K Largest Elements using Heap Sort ───────────────────
    static int[] kLargest(int[] arr, int k) {
        int[] a = arr.clone();
        heapSort(a);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) result[i] = a[a.length - 1 - i];
        return result;
    }

    // ── Verify Max-Heap Property ──────────────────────────────
    static boolean isMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int left = 2 * i + 1, right = 2 * i + 2;
            if (left < n  && arr[i] < arr[left])  return false;
            if (right < n && arr[i] < arr[right]) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        // EXERCISE 1: Basic heap sort
        int[] arr = {4, 10, 3, 5, 1};
        System.out.println("Before: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("After:  " + Arrays.toString(arr)); // [1,3,4,5,10]

        // EXERCISE 2: Verbose mode
        System.out.println();
        heapSortVerbose(new int[]{12, 11, 13, 5, 6, 7});

        // EXERCISE 3: Descending
        int[] desc = {5, 2, 8, 1, 9};
        heapSortDesc(desc);
        System.out.println("\nDescending: " + Arrays.toString(desc)); // [9,8,5,2,1]

        // EXERCISE 4: Build max heap and verify
        int[] heap = {3, 9, 2, 1, 4, 5};
        buildMaxHeap(heap);
        System.out.println("Max heap: " + Arrays.toString(heap));
        System.out.println("Is max heap: " + isMaxHeap(heap)); // true

        // EXERCISE 5: K largest
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println("2 largest: " + Arrays.toString(kLargest(nums, 2))); // [6,5]

        // EXERCISE 6: Already sorted
        int[] sorted = {1, 2, 3, 4, 5};
        long t1 = System.nanoTime();
        heapSort(sorted.clone());
        System.out.printf("\nSorted input: %.3f ms%n", (System.nanoTime()-t1)/1e6);

        // EXERCISE 7: Reverse sorted
        int[] reversed = {5, 4, 3, 2, 1};
        heapSort(reversed);
        System.out.println("Reversed after sort: " + Arrays.toString(reversed));

        // EXERCISE 8: All same
        int[] same = {7, 7, 7, 7};
        heapSort(same);
        System.out.println("All same: " + Arrays.toString(same)); // [7,7,7,7]

        // EXERCISE 9: Large array performance
        int N = 100_000;
        int[] big = new int[N];
        java.util.Random rng = new java.util.Random(42);
        for (int i = 0; i < N; i++) big[i] = rng.nextInt(N);
        long t2 = System.nanoTime();
        heapSort(big);
        System.out.printf("Heap sort n=%d: %.2f ms%n", N, (System.nanoTime()-t2)/1e6);

        // EXERCISE 10: Compare with Arrays.sort
        int[] big2 = new int[N];
        for (int i = 0; i < N; i++) big2[i] = rng.nextInt(N);
        long t3 = System.nanoTime();
        java.util.Arrays.sort(big2);
        System.out.printf("Arrays.sort n=%d: %.2f ms (uses IntroSort)%n", N, (System.nanoTime()-t3)/1e6);

        // SUMMARY
        System.out.println("\n=== Heap Sort ===");
        System.out.println("Time:   O(n log n) — guaranteed best/avg/worst");
        System.out.println("Space:  O(1) — in-place");
        System.out.println("Stable: NO");
        System.out.println("Phase 1 build heap: O(n)");
        System.out.println("Phase 2 extract:    O(n log n)");
        System.out.println("Java Arrays.sort uses IntroSort: Quick + Heap + Insertion hybrid");
    }
}
