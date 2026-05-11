package org.example.Algorithms.Sorting.Bubble;

import java.util.Arrays;

/**
 * ============================================================
 *              BUBBLE SORT — COMPLETE GUIDE
 * ============================================================
 *
 * HOW IT WORKS:
 * --------------
 * Repeatedly compare ADJACENT elements and swap them if they're
 * in the wrong order. After each pass, the LARGEST unsorted
 * element "bubbles up" to its correct position at the end.
 *
 * EXAMPLE (ascending):
 *   Pass 1: [5,3,1,4,2] → [3,1,4,2,5]  (5 is at end)
 *   Pass 2: [3,1,4,2,5] → [1,3,2,4,5]  (4 is at end)
 *   Pass 3: [1,3,2,4,5] → [1,2,3,4,5]
 *
 * TIME COMPLEXITY:
 * -----------------
 *   Best  : O(n)   — already sorted (with early exit flag)
 *   Average: O(n²) — random data
 *   Worst : O(n²)  — reverse sorted
 *
 * SPACE: O(1) — in-place, no extra memory
 * STABLE: YES — equal elements never swap
 *
 * WHEN TO USE:
 * -------------
 *   ✔ Educational purposes (simplest to understand)
 *   ✔ Nearly sorted data (with early exit)
 *   ✗ Never use in production (O(n²) average)
 *
 * OPTIMIZATION:
 * --------------
 *   Add a 'swapped' flag — if no swaps in a pass, array is sorted.
 *   This makes best case O(n) instead of O(n²).
 *
 * ============================================================
 */
public class Bubble {

    // Basic bubble sort — O(n²)
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j]   = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Optimized with early exit — best case O(n)
    static void bubbleSortOptimized(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp  = arr[j];
                    arr[j]    = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped   = true;
                }
            }
            if (!swapped) break; // already sorted — exit early
        }
    }

    // Count swaps (useful to understand bubble sort behavior)
    static int countSwaps(int[] arr) {
        int swaps = 0;
        int n = arr.length;
        int[] copy = arr.clone();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (copy[j] > copy[j + 1]) {
                    int t = copy[j]; copy[j] = copy[j+1]; copy[j+1] = t;
                    swaps++;
                }
            }
        }
        return swaps;
    }

    public static void main(String[] args) {

        // EXERCISE 1: Basic sort
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Before: " + Arrays.toString(arr1));
        bubbleSort(arr1);
        System.out.println("After:  " + Arrays.toString(arr1));
        // [11, 12, 22, 25, 34, 64, 90]

        // EXERCISE 2: Optimized — best case O(n) for sorted input
        int[] sorted = {1, 2, 3, 4, 5};
        System.out.println("\nSorted input: " + Arrays.toString(sorted));
        bubbleSortOptimized(sorted);
        System.out.println("After opt:    " + Arrays.toString(sorted));

        // EXERCISE 3: Step-by-step visualization
        int[] step = {5, 3, 1, 4, 2};
        System.out.println("\nStep-by-step for " + Arrays.toString(step) + ":");
        int n = step.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (step[j] > step[j + 1]) {
                    int t = step[j]; step[j] = step[j+1]; step[j+1] = t;
                    swapped = true;
                }
            }
            System.out.println("  Pass " + (i+1) + ": " + Arrays.toString(step));
            if (!swapped) { System.out.println("  (early exit)"); break; }
        }

        // EXERCISE 4: Count swaps
        int[] arr2 = {4, 3, 2, 1};
        System.out.println("\nSwaps for [4,3,2,1]: " + countSwaps(arr2)); // 6

        // EXERCISE 5: Descending sort (reverse comparison)
        int[] desc = {5, 2, 8, 1, 9};
        for (int i = 0; i < desc.length - 1; i++) {
            for (int j = 0; j < desc.length - i - 1; j++) {
                if (desc[j] < desc[j+1]) { // reverse order
                    int t = desc[j]; desc[j] = desc[j+1]; desc[j+1] = t;
                }
            }
        }
        System.out.println("Descending: " + Arrays.toString(desc)); // [9,8,5,2,1]

        // SUMMARY
        System.out.println("\n=== Bubble Sort ===");
        System.out.println("Best:    O(n)  — already sorted (with flag)");
        System.out.println("Average: O(n²)");
        System.out.println("Worst:   O(n²) — reverse sorted");
        System.out.println("Space:   O(1)  in-place");
        System.out.println("Stable:  YES");
    }
}
