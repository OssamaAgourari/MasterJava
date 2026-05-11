package org.example.Algorithms.Sorting.Bubble;

import java.util.*;

/**
 * ============================================================
 *       BUBBLE SORT CHALLENGES — LeetCode Style
 * ============================================================
 */
public class BubbleChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Sort Colors (Dutch National Flag)
    // Sort array of 0s, 1s, 2s in one pass.
    // Example: [2,0,2,1,1,0] → [0,0,1,1,2,2]
    // =========================================================
    static void sortColors(int[] nums) { /* TODO */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Check if Array is Sorted
    // Return true if array is non-decreasing.
    // Example: [1,2,2,3]→true, [3,1,2]→false
    // =========================================================
    static boolean isSorted(int[] nums) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Find Minimum in Array
    // Return the minimum element.
    // Example: [3,1,4,1,5] → 1
    // =========================================================
    static int findMin(int[] nums) { return Integer.MAX_VALUE; /* TODO */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Sort Array by Parity
    // All even numbers before all odd numbers.
    // Example: [3,1,2,4] → [2,4,1,3] or similar
    // =========================================================
    static int[] sortArrayByParity(int[] nums) { return nums; /* TODO */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Count Inversions
    // Number of pairs (i,j) where i<j but nums[i]>nums[j].
    // Example: [2,4,1,3,5] → 3
    // =========================================================
    static int countInversions(int[] nums) { return 0; /* TODO: O(n²) with bubble sort logic */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Minimum Swaps to Sort
    // How many adjacent swaps to sort array?
    // Example: [4,3,2,1] → 6
    // =========================================================
    static int minSwapsToSort(int[] nums) { return 0; /* TODO: count bubble sort swaps */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Largest Number
    // Arrange numbers to form largest number.
    // Example: [3,30,34,5,9] → "9534330"
    // =========================================================
    static String largestNumber(int[] nums) { return ""; /* TODO: custom sort */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Sort Array by Absolute Value
    // Sort in-place by absolute value ascending.
    // Example: [-3,1,-2,4] → [1,-2,-3,4]
    // =========================================================
    static int[] sortByAbsValue(int[] nums) { return nums; /* TODO */ }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Sort a Nearly Sorted Array
    // Every element is at most k positions away from sorted.
    // Example: [6,5,3,2,8,10,9], k=3 → [2,3,5,6,8,9,10]
    // =========================================================
    static int[] sortNearlySorted(int[] nums, int k) { return nums; /* TODO: use min-heap or k+1 window */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Minimum Cost to Sort
    // Min cost to sort array. Cost = sum of elements moved.
    // Example: [1,5,3] → 3 (move 3 to position 1 costs 3)
    // =========================================================
    static int minCostToSort(int[] nums) { return 0; /* TODO */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        int[] sc = {2,0,2,1,1,0}; sortColors(sc);
        pass += check("C1a", Arrays.toString(sc), "[0, 0, 1, 1, 2, 2]") ? 1:0;
        fail += check("C1a", Arrays.toString(sc), "[0, 0, 1, 1, 2, 2]") ? 0:1;

        pass += check("C2a", isSorted(new int[]{1,2,2,3}), true)  ? 1:0; fail += check("C2a", isSorted(new int[]{1,2,2,3}), true)  ? 0:1;
        pass += check("C2b", isSorted(new int[]{3,1,2}),   false) ? 1:0; fail += check("C2b", isSorted(new int[]{3,1,2}),   false) ? 0:1;

        pass += check("C3a", findMin(new int[]{3,1,4,1,5}), 1) ? 1:0; fail += check("C3a", findMin(new int[]{3,1,4,1,5}), 1) ? 0:1;

        int[] parity = sortArrayByParity(new int[]{3,1,2,4});
        boolean evenFirst = true; boolean seenOdd = false;
        for (int v : parity) { if(v%2!=0)seenOdd=true; if(v%2==0&&seenOdd){evenFirst=false;break;} }
        pass += check("C4a", evenFirst, true) ? 1:0; fail += check("C4a", evenFirst, true) ? 0:1;

        pass += check("C5a", countInversions(new int[]{2,4,1,3,5}), 3) ? 1:0;
        fail += check("C5a", countInversions(new int[]{2,4,1,3,5}), 3) ? 0:1;

        pass += check("C6a", minSwapsToSort(new int[]{4,3,2,1}), 6) ? 1:0;
        fail += check("C6a", minSwapsToSort(new int[]{4,3,2,1}), 6) ? 0:1;

        pass += check("C7a", largestNumber(new int[]{3,30,34,5,9}), "9534330") ? 1:0;
        fail += check("C7a", largestNumber(new int[]{3,30,34,5,9}), "9534330") ? 0:1;
        pass += check("C7b", largestNumber(new int[]{10,2}), "210") ? 1:0;
        fail += check("C7b", largestNumber(new int[]{10,2}), "210") ? 0:1;

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
