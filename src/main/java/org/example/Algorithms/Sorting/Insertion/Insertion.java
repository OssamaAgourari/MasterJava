package org.example.Algorithms.Sorting.Insertion;

import java.util.Arrays;

/**
 * ============================================================
 *              INSERTION SORT — COMPLETE GUIDE
 * ============================================================
 *
 * HOW IT WORKS:
 * --------------
 * Build the sorted array one element at a time by INSERTING
 * each new element into its correct position among those
 * already sorted (like sorting playing cards in your hand).
 *
 *   For each element at index i (starting from 1):
 *     - Save element as key
 *     - Shift all larger elements one position right
 *     - Insert key in the gap
 *
 * Example:
 *   [5, 2, 4, 6, 1, 3]
 *   [2, 5, 4, 6, 1, 3]  key=2, shifted 5
 *   [2, 4, 5, 6, 1, 3]  key=4, shifted 5
 *   [2, 4, 5, 6, 1, 3]  key=6, no shift
 *   [1, 2, 4, 5, 6, 3]  key=1, shifted 2,4,5,6
 *   [1, 2, 3, 4, 5, 6]  key=3, shifted 4,5,6
 *
 * TIME COMPLEXITY:
 * -----------------
 *   Best:    O(n)   — already sorted (no shifts needed)
 *   Average: O(n²)
 *   Worst:   O(n²)  — reverse sorted
 *
 * SPACE: O(1) — in-place
 * STABLE: YES — equal elements maintain relative order
 * ADAPTIVE: YES — O(n) for nearly sorted input
 *
 * WHEN TO USE:
 * -------------
 *   ✔ Small arrays (n < 20, faster than quicksort in practice)
 *   ✔ Nearly sorted data — O(n + k) where k = # inversions
 *   ✔ Online sorting — sort as elements arrive one by one
 *   ✔ Used as base case in hybrid sorts (Tim Sort, Intro Sort)
 *   ✗ Avoid for large random arrays — O(n²)
 *
 * COMPARISON:
 *   vs Bubble:    Insertion is faster — fewer comparisons/swaps
 *   vs Selection: Insertion is adaptive, Selection is not
 *   vs Merge:     Merge is O(n log n) but Insertion beats it for small n
 *
 * ============================================================
 */
public class Insertion {

    // ── Basic Insertion Sort ─────────────────────────────────
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // ── Verbose version — shows each insertion ───────────────
    static void insertionSortVerbose(int[] arr) {
        System.out.println("Insertion Sort — step by step:");
        System.out.println("Start: " + Arrays.toString(arr));
        int shifts = 0;
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) { arr[j + 1] = arr[j]; j--; shifts++; }
            arr[j + 1] = key;
            System.out.printf("Insert %d at pos %d → %s%n", key, j+1, Arrays.toString(arr));
        }
        System.out.println("Total shifts: " + shifts);
    }

    // ── Descending insertion sort ────────────────────────────
    static void insertionSortDesc(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) { arr[j + 1] = arr[j]; j--; }
            arr[j + 1] = key;
        }
    }

    // ── Insertion sort on strings ────────────────────────────
    static void insertionSortStrings(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) { arr[j + 1] = arr[j]; j--; }
            arr[j + 1] = key;
        }
    }

    // ── Binary Insertion Sort — fewer comparisons O(n log n) ─
    // Still O(n²) shifts, but O(n log n) comparisons
    static void binaryInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            // binary search for insertion position in arr[0..i-1]
            int lo = 0, hi = i;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr[mid] > key) hi = mid;
                else lo = mid + 1;
            }
            // shift elements right to make room
            int j = i;
            while (j > lo) { arr[j] = arr[j - 1]; j--; }
            arr[lo] = key;
        }
    }

    // ── Count inversions (= number of shifts in insertion sort) ─
    static int countInversions(int[] arr) {
        int count = 0;
        int[] a = arr.clone();
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) { a[j + 1] = a[j]; j--; count++; }
            a[j + 1] = key;
        }
        return count;
    }

    public static void main(String[] args) {

        // EXERCISE 1: Basic sort
        int[] arr = {5, 2, 4, 6, 1, 3};
        System.out.println("Before: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After:  " + Arrays.toString(arr)); // [1,2,3,4,5,6]

        // EXERCISE 2: Verbose visualization
        System.out.println();
        insertionSortVerbose(new int[]{29, 10, 14, 37, 13});

        // EXERCISE 3: Nearly sorted (best case behavior)
        int[] nearly = {1, 2, 4, 3, 5}; // one inversion
        int inv1 = countInversions(nearly);
        System.out.printf("%nNearly sorted — inversions: %d (O(n + %d))%n", inv1, inv1);

        // EXERCISE 4: Reverse sorted (worst case)
        int[] reversed = {5, 4, 3, 2, 1};
        int inv2 = countInversions(reversed);
        System.out.printf("Reversed — inversions: %d (worst case O(n²))%n", inv2); // 10

        // EXERCISE 5: Descending
        int[] desc = {1, 5, 2, 8, 3};
        insertionSortDesc(desc);
        System.out.println("\nDescending: " + Arrays.toString(desc)); // [8,5,3,2,1]

        // EXERCISE 6: String sorting
        String[] names = {"banana", "apple", "cherry", "date"};
        insertionSortStrings(names);
        System.out.println("Strings: " + Arrays.toString(names)); // [apple,banana,cherry,date]

        // EXERCISE 7: Binary insertion sort
        int[] arr2 = {5, 2, 4, 6, 1, 3};
        binaryInsertionSort(arr2);
        System.out.println("Binary insertion: " + Arrays.toString(arr2)); // [1,2,3,4,5,6]

        // EXERCISE 8: Single element
        int[] single = {99};
        insertionSort(single);
        System.out.println("Single: " + Arrays.toString(single)); // [99]

        // EXERCISE 9: All equal
        int[] equal = {3, 3, 3, 3};
        System.out.println("Inversions all-equal: " + countInversions(equal)); // 0

        // EXERCISE 10: Online sort simulation — insert one by one
        System.out.println("\nOnline sort (insert each element live):");
        int[] stream = {7, 2, 9, 4};
        int[] online = new int[stream.length];
        int size = 0;
        for (int val : stream) {
            online[size++] = val;
            // insertion sort just the newly added element
            int key = online[size - 1], j = size - 2;
            while (j >= 0 && online[j] > key) { online[j + 1] = online[j]; j--; }
            online[j + 1] = key;
            System.out.println("  After inserting " + val + ": " + Arrays.toString(Arrays.copyOf(online, size)));
        }

        // SUMMARY
        System.out.println("\n=== Insertion Sort ===");
        System.out.println("Time:     O(n) best, O(n²) avg/worst");
        System.out.println("Space:    O(1)");
        System.out.println("Stable:   YES");
        System.out.println("Adaptive: YES — best for nearly sorted data");
        System.out.println("Online:   YES — sort stream as elements arrive");
        System.out.println("Used in:  Tim Sort (base case for small subarrays)");
    }
}
