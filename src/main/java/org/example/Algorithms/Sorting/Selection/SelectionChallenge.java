package org.example.Algorithms.Sorting.Selection;

import java.util.*;

/**
 * ============================================================
 *       SELECTION SORT CHALLENGES — LeetCode Style
 * ============================================================
 */
public class SelectionChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Find Minimum
    // Return minimum element (core of selection sort).
    // Example: [3,1,4,1,5,9,2,6] → 1
    // =========================================================
    static int findMin(int[] nums) { return Integer.MAX_VALUE; /* TODO */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Find K-th Minimum
    // Return the k-th smallest element (1-indexed).
    // Example: [3,1,4,1,5,9,2,6], k=3 → 3
    // =========================================================
    static int kthMin(int[] nums, int k) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Sort Array
    // Sort using selection sort algorithm.
    // Example: [64,25,12,22,11] → [11,12,22,25,64]
    // =========================================================
    static int[] sortArray(int[] nums) { return nums; /* TODO */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Kth Largest Element
    // Return kth largest using selection-based approach.
    // Example: [3,2,1,5,6,4], k=2 → 5
    // =========================================================
    static int findKthLargest(int[] nums, int k) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Sort Array by Parity II
    // Place even at even indices, odd at odd indices.
    // Example: [4,2,5,7] → [4,5,2,7] or similar
    // =========================================================
    static int[] sortArrayByParityII(int[] nums) { return nums; /* TODO */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Minimum Number of Swaps
    // Min swaps to sort array (using cycle detection concept).
    // Example: [4,3,2,1] → 2 (swap 4↔1, swap 3↔2)
    // Hint: each cycle of length k needs k-1 swaps.
    // =========================================================
    static int minimumSwaps(int[] nums) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Third Maximum
    // Find 3rd distinct maximum. If not found, return max.
    // Example: [3,2,1]→1, [1,2]→2, [2,2,3,1]→1
    // =========================================================
    static int thirdMax(int[] nums) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Sort Colors (Dutch National Flag)
    // Sort 0s, 1s, 2s in-place. O(n), one pass.
    // Example: [2,0,2,1,1,0] → [0,0,1,1,2,2]
    // =========================================================
    static void sortColors(int[] nums) { /* TODO */ }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Median of Unsorted Array
    // Return median using selection-based approach.
    // Example: [3,1,4,1,5,9,2,6] → 3.5 (even: avg of two middles)
    // =========================================================
    static double findMedian(int[] nums) { return 0.0; /* TODO */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — K Closest Points to Origin
    // Return k points closest to origin (0,0).
    // Example: [[1,3],[-2,2]], k=1 → [[-2,2]]
    // =========================================================
    static int[][] kClosest(int[][] points, int k) { return new int[0][]; /* TODO */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", findMin(new int[]{3,1,4,1,5,9,2,6}), 1) ? 1:0;
        fail += check("C1a", findMin(new int[]{3,1,4,1,5,9,2,6}), 1) ? 0:1;

        pass += check("C2a", kthMin(new int[]{3,1,4,1,5,9,2,6}, 3), 3) ? 1:0;
        fail += check("C2a", kthMin(new int[]{3,1,4,1,5,9,2,6}, 3), 3) ? 0:1;

        pass += check("C3a", Arrays.toString(sortArray(new int[]{64,25,12,22,11})), "[11, 12, 22, 25, 64]") ? 1:0;
        fail += check("C3a", Arrays.toString(sortArray(new int[]{64,25,12,22,11})), "[11, 12, 22, 25, 64]") ? 0:1;

        pass += check("C4a", findKthLargest(new int[]{3,2,1,5,6,4}, 2), 5) ? 1:0;
        fail += check("C4a", findKthLargest(new int[]{3,2,1,5,6,4}, 2), 5) ? 0:1;

        int[] p2 = sortArrayByParityII(new int[]{4,2,5,7});
        boolean valid = true;
        for (int i = 0; i < p2.length; i++) if (p2[i] % 2 != i % 2) { valid = false; break; }
        pass += check("C5a", valid, true) ? 1:0; fail += check("C5a", valid, true) ? 0:1;

        pass += check("C6a", minimumSwaps(new int[]{4,3,2,1}), 2) ? 1:0;
        fail += check("C6a", minimumSwaps(new int[]{4,3,2,1}), 2) ? 0:1;

        pass += check("C7a", thirdMax(new int[]{3,2,1}),     1) ? 1:0; fail += check("C7a", thirdMax(new int[]{3,2,1}),     1) ? 0:1;
        pass += check("C7b", thirdMax(new int[]{1,2}),       2) ? 1:0; fail += check("C7b", thirdMax(new int[]{1,2}),       2) ? 0:1;
        pass += check("C7c", thirdMax(new int[]{2,2,3,1}),   1) ? 1:0; fail += check("C7c", thirdMax(new int[]{2,2,3,1}),   1) ? 0:1;

        int[] sc = {2,0,2,1,1,0}; sortColors(sc);
        pass += check("C8a", Arrays.toString(sc), "[0, 0, 1, 1, 2, 2]") ? 1:0;
        fail += check("C8a", Arrays.toString(sc), "[0, 0, 1, 1, 2, 2]") ? 0:1;

        pass += check("C10a", kClosest(new int[][]{{1,3},{-2,2}}, 1).length, 1) ? 1:0;
        fail += check("C10a", kClosest(new int[][]{{1,3},{-2,2}}, 1).length, 1) ? 0:1;

        System.out.println("\n==============================");
        System.out.println("  RESULTS: " + pass + " passed, " + fail + " failed");
        System.out.println("==============================");
    }

    private static boolean check(String n, Object got, Object exp) {
        boolean ok = String.valueOf(got).equals(String.valueOf(exp));
        System.out.printf("%-6s %s  (exp:%s | got:%s)%n", n, ok?"✔":"✘", exp, got);
        return ok;
    }
}
