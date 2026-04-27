package org.example.Algorithms.TwoPointers;

import java.util.*;

/**
 * ============================================================
 *         TWO POINTERS CHALLENGES — LeetCode Style
 * ============================================================
 */
public class TwoPointersChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Valid Palindrome
    // Alphanumeric chars only, case-insensitive.
    // Example: "A man, a plan, a canal: Panama" → true
    //          "race a car" → false
    // =========================================================
    static boolean isPalindrome(String s) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Two Sum II (sorted array)
    // Return 1-indexed positions. Exactly one solution.
    // Example: [2,7,11,15], target=9 → [1,2]
    // =========================================================
    static int[] twoSumSorted(int[] numbers, int target) { return new int[]{-1,-1}; /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Merge Sorted Array
    // Merge nums2 into nums1 in-place. nums1 has extra 0s at end.
    // Example: nums1=[1,2,3,0,0,0] m=3, nums2=[2,5,6] n=3 → [1,2,2,3,5,6]
    // =========================================================
    static void merge(int[] nums1, int m, int[] nums2, int n) { /* TODO */ }

    // =========================================================
    // CHALLENGE 4  [EASY]  — Remove Duplicates from Sorted Array
    // In-place, return new length.
    // Example: [1,1,2,3,3,4] → 4, array=[1,2,3,4,...]
    // =========================================================
    static int removeDuplicates(int[] nums) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — 3Sum
    // Find all unique triplets that sum to 0.
    // Example: [-1,0,1,2,-1,-4] → [[-1,-1,2],[-1,0,1]]
    // =========================================================
    static List<List<Integer>> threeSum(int[] nums) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Container With Most Water
    // Find two lines that hold the most water.
    // Example: [1,8,6,2,5,4,8,3,7] → 49
    // =========================================================
    static int maxArea(int[] height) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Trapping Rain Water
    // Example: [0,1,0,2,1,0,1,3,2,1,2,1] → 6
    // =========================================================
    static int trap(int[] height) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — 4Sum
    // Find all unique quadruplets that sum to target.
    // Example: [1,0,-1,0,-2,2], target=0 → [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    // =========================================================
    static List<List<Integer>> fourSum(int[] nums, int target) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]  — Longest Mountain in Array
    // A mountain: at least 3 elements, strictly increases then decreases.
    // Example: [2,1,4,7,3,2,5] → 5 (subarray [1,4,7,3,2])
    // =========================================================
    static int longestMountain(int[] arr) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Minimum Window Substring
    // Find minimum window in s containing all chars of t.
    // Example: s="ADOBECODEBANC", t="ABC" → "BANC"
    // =========================================================
    static String minWindow(String s, String t) { return ""; /* TODO: sliding window + two pointers */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", isPalindrome("A man, a plan, a canal: Panama"), true)  ? 1:0;
        fail += check("C1a", isPalindrome("A man, a plan, a canal: Panama"), true)  ? 0:1;
        pass += check("C1b", isPalindrome("race a car"), false) ? 1:0;
        fail += check("C1b", isPalindrome("race a car"), false) ? 0:1;
        pass += check("C1c", isPalindrome(" "), true) ? 1:0;
        fail += check("C1c", isPalindrome(" "), true) ? 0:1;

        pass += check("C2a", Arrays.toString(twoSumSorted(new int[]{2,7,11,15}, 9)),  "[1, 2]") ? 1:0;
        fail += check("C2a", Arrays.toString(twoSumSorted(new int[]{2,7,11,15}, 9)),  "[1, 2]") ? 0:1;
        pass += check("C2b", Arrays.toString(twoSumSorted(new int[]{2,3,4}, 6)),       "[1, 3]") ? 1:0;
        fail += check("C2b", Arrays.toString(twoSumSorted(new int[]{2,3,4}, 6)),       "[1, 3]") ? 0:1;

        int[] m1 = {1,2,3,0,0,0}; merge(m1, 3, new int[]{2,5,6}, 3);
        pass += check("C3a", Arrays.toString(m1), "[1, 2, 2, 3, 5, 6]") ? 1:0;
        fail += check("C3a", Arrays.toString(m1), "[1, 2, 2, 3, 5, 6]") ? 0:1;

        int[] rd = {1,1,2,3,3,4};
        pass += check("C4a", removeDuplicates(rd), 4) ? 1:0;
        fail += check("C4a", removeDuplicates(rd), 4) ? 0:1;

        List<List<Integer>> ts = threeSum(new int[]{-1,0,1,2,-1,-4});
        pass += check("C5a", ts.size(), 2) ? 1:0;
        fail += check("C5a", ts.size(), 2) ? 0:1;

        pass += check("C6a", maxArea(new int[]{1,8,6,2,5,4,8,3,7}), 49) ? 1:0;
        fail += check("C6a", maxArea(new int[]{1,8,6,2,5,4,8,3,7}), 49) ? 0:1;
        pass += check("C6b", maxArea(new int[]{1,1}), 1) ? 1:0;
        fail += check("C6b", maxArea(new int[]{1,1}), 1) ? 0:1;

        pass += check("C7a", trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}), 6) ? 1:0;
        fail += check("C7a", trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}), 6) ? 0:1;
        pass += check("C7b", trap(new int[]{4,2,0,3,2,5}), 9) ? 1:0;
        fail += check("C7b", trap(new int[]{4,2,0,3,2,5}), 9) ? 0:1;

        List<List<Integer>> fs = fourSum(new int[]{1,0,-1,0,-2,2}, 0);
        pass += check("C8a", fs.size(), 3) ? 1:0;
        fail += check("C8a", fs.size(), 3) ? 0:1;

        pass += check("C9a", longestMountain(new int[]{2,1,4,7,3,2,5}), 5) ? 1:0;
        fail += check("C9a", longestMountain(new int[]{2,1,4,7,3,2,5}), 5) ? 0:1;
        pass += check("C9b", longestMountain(new int[]{2,2,2}), 0) ? 1:0;
        fail += check("C9b", longestMountain(new int[]{2,2,2}), 0) ? 0:1;

        pass += check("C10a", minWindow("ADOBECODEBANC", "ABC"), "BANC") ? 1:0;
        fail += check("C10a", minWindow("ADOBECODEBANC", "ABC"), "BANC") ? 0:1;
        pass += check("C10b", minWindow("a", "a"), "a") ? 1:0;
        fail += check("C10b", minWindow("a", "a"), "a") ? 0:1;

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
