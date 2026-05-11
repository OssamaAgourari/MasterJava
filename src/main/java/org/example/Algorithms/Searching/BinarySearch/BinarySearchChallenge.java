package org.example.Algorithms.Searching.BinarySearch;

/**
 * ============================================================
 *          BINARY SEARCH CHALLENGES — LeetCode Style
 * ============================================================
 */
public class BinarySearchChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Binary Search
    // Example: [-1,0,3,5,9,12], target=9 → 4
    // =========================================================
    static int search(int[] nums, int target) { return -1; /* TODO */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — First Bad Version
    // isBadVersion(n) is given. Find first bad version.
    // =========================================================
    static int isBadVersion_threshold = 4; // simulate: bad if version >= threshold
    static boolean isBadVersion(int v) { return v >= isBadVersion_threshold; }
    static int firstBadVersion(int n) { return -1; /* TODO: binary search on bool function */ }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Count Occurrences in Sorted Array
    // Example: [1,2,2,2,3], target=2 → 3
    // =========================================================
    static int countOccurrences(int[] nums, int target) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Search in Rotated Sorted Array
    // Example: [4,5,6,7,0,1,2], target=0 → 4
    //          [4,5,6,7,0,1,2], target=3 → -1
    // =========================================================
    static int searchRotated(int[] nums, int target) { return -1; /* TODO */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Find Minimum in Rotated Sorted Array
    // Example: [3,4,5,1,2] → 1
    //          [4,5,6,7,0,1,2] → 0
    // =========================================================
    static int findMin(int[] nums) { return Integer.MAX_VALUE; /* TODO */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Search a 2D Matrix
    // Each row sorted, first integer > last integer of prev row.
    // Example: [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target=3 → true
    // =========================================================
    static boolean searchMatrix(int[][] matrix, int target) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Koko Eating Bananas
    // Koko eats at speed k bananas/hour. n hours total.
    // Return minimum k such that she can eat all bananas.
    // Example: piles=[3,6,7,11], h=8 → 4
    // =========================================================
    static int minEatingSpeed(int[] piles, int h) { return 0; /* TODO: binary search on answer */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Capacity to Ship Packages
    // Ship packages within D days. Return min weight capacity.
    // Example: weights=[1,2,3,4,5,6,7,8,9,10], days=5 → 15
    // =========================================================
    static int shipWithinDays(int[] weights, int days) { return 0; /* TODO: binary search on capacity */ }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Find in Mountain Array
    // Mountain array: increases then decreases. Find target.
    // Return smallest index of target, or -1.
    // Example: mountainArr=[1,2,3,4,5,3,1], target=3 → 2
    // =========================================================
    static int findInMountainArray(int target, int[] mountainArr) { return -1; /* TODO */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Split Array Largest Sum
    // Split nums into m subarrays. Minimize the largest subarray sum.
    // Example: [7,2,5,10,8], m=2 → 18
    // Hint: binary search on the answer [max element, total sum]
    // =========================================================
    static int splitArray(int[] nums, int m) { return 0; /* TODO */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", search(new int[]{-1,0,3,5,9,12}, 9),  4)  ? 1:0;
        fail += check("C1a", search(new int[]{-1,0,3,5,9,12}, 9),  4)  ? 0:1;
        pass += check("C1b", search(new int[]{-1,0,3,5,9,12}, 2),  -1) ? 1:0;
        fail += check("C1b", search(new int[]{-1,0,3,5,9,12}, 2),  -1) ? 0:1;

        isBadVersion_threshold = 4;
        pass += check("C2a", firstBadVersion(5), 4) ? 1:0; fail += check("C2a", firstBadVersion(5), 4) ? 0:1;
        isBadVersion_threshold = 1;
        pass += check("C2b", firstBadVersion(1), 1) ? 1:0; fail += check("C2b", firstBadVersion(1), 1) ? 0:1;

        pass += check("C3a", countOccurrences(new int[]{1,2,2,2,3}, 2), 3) ? 1:0;
        fail += check("C3a", countOccurrences(new int[]{1,2,2,2,3}, 2), 3) ? 0:1;

        pass += check("C4a", searchRotated(new int[]{4,5,6,7,0,1,2}, 0), 4)  ? 1:0;
        fail += check("C4a", searchRotated(new int[]{4,5,6,7,0,1,2}, 0), 4)  ? 0:1;
        pass += check("C4b", searchRotated(new int[]{4,5,6,7,0,1,2}, 3), -1) ? 1:0;
        fail += check("C4b", searchRotated(new int[]{4,5,6,7,0,1,2}, 3), -1) ? 0:1;

        pass += check("C5a", findMin(new int[]{3,4,5,1,2}),     1) ? 1:0;
        fail += check("C5a", findMin(new int[]{3,4,5,1,2}),     1) ? 0:1;
        pass += check("C5b", findMin(new int[]{4,5,6,7,0,1,2}), 0) ? 1:0;
        fail += check("C5b", findMin(new int[]{4,5,6,7,0,1,2}), 0) ? 0:1;

        pass += check("C6a", searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3),  true)  ? 1:0;
        fail += check("C6a", searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3),  true)  ? 0:1;
        pass += check("C6b", searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13), false) ? 1:0;
        fail += check("C6b", searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13), false) ? 0:1;

        pass += check("C7a", minEatingSpeed(new int[]{3,6,7,11}, 8), 4) ? 1:0;
        fail += check("C7a", minEatingSpeed(new int[]{3,6,7,11}, 8), 4) ? 0:1;

        pass += check("C8a", shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5), 15) ? 1:0;
        fail += check("C8a", shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5), 15) ? 0:1;

        pass += check("C10a", splitArray(new int[]{7,2,5,10,8}, 2), 18) ? 1:0;
        fail += check("C10a", splitArray(new int[]{7,2,5,10,8}, 2), 18) ? 0:1;

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
