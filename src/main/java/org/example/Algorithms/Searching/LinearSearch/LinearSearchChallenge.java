package org.example.Algorithms.Searching.LinearSearch;

import java.util.*;

/**
 * ============================================================
 *        LINEAR SEARCH CHALLENGES — LeetCode Style
 * ============================================================
 */
public class LinearSearchChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Find the Index of the First Occurrence in String
    // Return index of first occurrence of needle in haystack, or -1.
    // Example: "sadbutsad","sad" → 0   "leetcode","leeto" → -1
    // =========================================================
    static int strStr(String haystack, String needle) { return -1; /* TODO */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Find Numbers with Even Number of Digits
    // Count integers in array that have even number of digits.
    // Example: [12,345,2,6,7896] → 2
    // =========================================================
    static int findNumbers(int[] nums) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Find the Difference
    // String t = string s with one extra shuffled character.
    // Find the added character.
    // Example: s="abcd", t="abcde" → 'e'
    // =========================================================
    static char findTheDifference(String s, String t) { return ' '; /* TODO */ }

    // =========================================================
    // CHALLENGE 4  [EASY]  — Single Number
    // Every element appears twice except one. Find it.
    // Example: [4,1,2,1,2] → 4
    // =========================================================
    static int singleNumber(int[] nums) { return 0; /* TODO: XOR trick */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Find Peak Element
    // A peak is larger than its neighbors. Return any peak index.
    // Example: [1,2,3,1] → 2
    // =========================================================
    static int findPeakElement(int[] nums) { return 0; /* TODO: linear O(n) */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — First Missing Positive
    // Find smallest missing positive integer.
    // Example: [3,4,-1,1]→2, [1,2,0]→3, [7,8,9,11,12]→1
    // =========================================================
    static int firstMissingPositive(int[] nums) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Find All Duplicates in Array
    // 1 ≤ nums[i] ≤ n, some appear twice, return duplicates.
    // Example: [4,3,2,7,8,2,3,1] → [2,3]
    // =========================================================
    static List<Integer> findDuplicates(int[] nums) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Missing Number
    // Array of n distinct numbers in range [0,n]. Find missing.
    // Example: [3,0,1] → 2
    // =========================================================
    static int missingNumber(int[] nums) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]  — Find All Numbers Disappeared
    // Numbers in range [1,n]. Find all that are missing.
    // Example: [4,3,2,7,8,2,3,1] → [5,6]
    // =========================================================
    static List<Integer> findDisappearedNumbers(int[] nums) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Longest Consecutive Sequence
    // Find length of longest consecutive elements sequence.
    // Example: [100,4,200,1,3,2] → 4 (sequence: [1,2,3,4])
    // =========================================================
    static int longestConsecutive(int[] nums) { return 0; /* TODO: HashSet O(n) */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", strStr("sadbutsad", "sad"),    0)  ? 1:0; fail += check("C1a", strStr("sadbutsad", "sad"),    0)  ? 0:1;
        pass += check("C1b", strStr("leetcode", "leeto"),   -1) ? 1:0; fail += check("C1b", strStr("leetcode", "leeto"),   -1) ? 0:1;
        pass += check("C1c", strStr("hello", "ll"),         2)  ? 1:0; fail += check("C1c", strStr("hello", "ll"),         2)  ? 0:1;

        pass += check("C2a", findNumbers(new int[]{12,345,2,6,7896}), 2) ? 1:0;
        fail += check("C2a", findNumbers(new int[]{12,345,2,6,7896}), 2) ? 0:1;

        pass += check("C3a", findTheDifference("abcd","abcde"), 'e') ? 1:0;
        fail += check("C3a", findTheDifference("abcd","abcde"), 'e') ? 0:1;
        pass += check("C3b", findTheDifference("","y"),         'y') ? 1:0;
        fail += check("C3b", findTheDifference("","y"),         'y') ? 0:1;

        pass += check("C4a", singleNumber(new int[]{4,1,2,1,2}),  4) ? 1:0; fail += check("C4a", singleNumber(new int[]{4,1,2,1,2}),  4) ? 0:1;
        pass += check("C4b", singleNumber(new int[]{2,2,1}),      1) ? 1:0; fail += check("C4b", singleNumber(new int[]{2,2,1}),      1) ? 0:1;

        pass += check("C5a", findPeakElement(new int[]{1,2,3,1}), 2) ? 1:0;
        fail += check("C5a", findPeakElement(new int[]{1,2,3,1}), 2) ? 0:1;

        pass += check("C6a", firstMissingPositive(new int[]{3,4,-1,1}),   2) ? 1:0; fail += check("C6a", firstMissingPositive(new int[]{3,4,-1,1}),   2) ? 0:1;
        pass += check("C6b", firstMissingPositive(new int[]{1,2,0}),      3) ? 1:0; fail += check("C6b", firstMissingPositive(new int[]{1,2,0}),      3) ? 0:1;
        pass += check("C6c", firstMissingPositive(new int[]{7,8,9,11,12}),1) ? 1:0; fail += check("C6c", firstMissingPositive(new int[]{7,8,9,11,12}),1) ? 0:1;

        List<Integer> dups = findDuplicates(new int[]{4,3,2,7,8,2,3,1});
        Collections.sort(dups);
        pass += check("C7a", dups.toString(), "[2, 3]") ? 1:0; fail += check("C7a", dups.toString(), "[2, 3]") ? 0:1;

        pass += check("C8a", missingNumber(new int[]{3,0,1}), 2) ? 1:0; fail += check("C8a", missingNumber(new int[]{3,0,1}), 2) ? 0:1;
        pass += check("C8b", missingNumber(new int[]{9,6,4,2,3,5,7,0,1}), 8) ? 1:0; fail += check("C8b", missingNumber(new int[]{9,6,4,2,3,5,7,0,1}), 8) ? 0:1;

        List<Integer> dis = findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        pass += check("C9a", dis.toString(), "[5, 6]") ? 1:0; fail += check("C9a", dis.toString(), "[5, 6]") ? 0:1;

        pass += check("C10a", longestConsecutive(new int[]{100,4,200,1,3,2}), 4) ? 1:0;
        fail += check("C10a", longestConsecutive(new int[]{100,4,200,1,3,2}), 4) ? 0:1;
        pass += check("C10b", longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}), 9) ? 1:0;
        fail += check("C10b", longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}), 9) ? 0:1;

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
