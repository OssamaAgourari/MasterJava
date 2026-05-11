package org.example.Algorithms.SlidingWindow;

import java.util.*;

/**
 * ============================================================
 *       SLIDING WINDOW CHALLENGES — LeetCode Style
 * ============================================================
 */
public class SlidingWindowChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Maximum Average Subarray I
    // Find contiguous subarray of length k with max average.
    // Example: [1,12,-5,-6,50,3], k=4 → 12.75
    // =========================================================
    static double findMaxAverage(int[] nums, int k) { return 0.0; /* TODO */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Contains Duplicate II
    // Any two nums[i]==nums[j] with |i-j| <= k?
    // Example: [1,2,3,1], k=3 → true
    // =========================================================
    static boolean containsNearbyDuplicate(int[] nums, int k) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [MEDIUM]  — Longest Substring Without Repeating Chars
    // Example: "abcabcbb" → 3
    // =========================================================
    static int lengthOfLongestSubstring(String s) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Minimum Size Subarray Sum
    // Minimum length subarray with sum >= target.
    // Example: target=7, [2,3,1,2,4,3] → 2
    // =========================================================
    static int minSubArrayLen(int target, int[] nums) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Longest Repeating Character Replacement
    // Replace at most k chars. Find longest substring with same letter.
    // Example: "ABAB", k=2 → 4
    // =========================================================
    static int characterReplacement(String s, int k) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Permutation in String
    // Does s2 contain a permutation of s1?
    // Example: s1="ab", s2="eidbaooo" → true
    // =========================================================
    static boolean checkInclusion(String s1, String s2) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Fruit Into Baskets
    // Max fruits with at most 2 types (longest subarray ≤ 2 distinct).
    // Example: [1,2,3,2,2] → 4
    // =========================================================
    static int totalFruit(int[] fruits) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Max Consecutive Ones III
    // Flip at most k zeros. Return max consecutive ones.
    // Example: [1,1,0,0,1,1,1,0,1,1], k=2 → 9
    // =========================================================
    static int longestOnes(int[] nums, int k) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Sliding Window Maximum
    // Max of each window of size k.
    // Example: [1,3,-1,-3,5,3,6,7], k=3 → [3,3,5,5,6,7]
    // =========================================================
    static int[] maxSlidingWindow(int[] nums, int k) { return new int[0]; /* TODO: monotonic deque */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Minimum Window Substring
    // Minimum window in s containing all chars of t.
    // Example: s="ADOBECODEBANC", t="ABC" → "BANC"
    // =========================================================
    static String minWindow(String s, String t) { return ""; /* TODO */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4), 12.75) ? 1:0;
        fail += check("C1a", findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4), 12.75) ? 0:1;

        pass += check("C2a", containsNearbyDuplicate(new int[]{1,2,3,1}, 3), true)  ? 1:0;
        fail += check("C2a", containsNearbyDuplicate(new int[]{1,2,3,1}, 3), true)  ? 0:1;
        pass += check("C2b", containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2), false) ? 1:0;
        fail += check("C2b", containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2), false) ? 0:1;

        pass += check("C3a", lengthOfLongestSubstring("abcabcbb"), 3) ? 1:0;
        fail += check("C3a", lengthOfLongestSubstring("abcabcbb"), 3) ? 0:1;
        pass += check("C3b", lengthOfLongestSubstring("bbbbb"), 1) ? 1:0;
        fail += check("C3b", lengthOfLongestSubstring("bbbbb"), 1) ? 0:1;
        pass += check("C3c", lengthOfLongestSubstring("pwwkew"), 3) ? 1:0;
        fail += check("C3c", lengthOfLongestSubstring("pwwkew"), 3) ? 0:1;

        pass += check("C4a", minSubArrayLen(7, new int[]{2,3,1,2,4,3}), 2) ? 1:0;
        fail += check("C4a", minSubArrayLen(7, new int[]{2,3,1,2,4,3}), 2) ? 0:1;
        pass += check("C4b", minSubArrayLen(4, new int[]{1,4,4}), 1) ? 1:0;
        fail += check("C4b", minSubArrayLen(4, new int[]{1,4,4}), 1) ? 0:1;

        pass += check("C5a", characterReplacement("ABAB", 2), 4) ? 1:0;
        fail += check("C5a", characterReplacement("ABAB", 2), 4) ? 0:1;
        pass += check("C5b", characterReplacement("AABABBA", 1), 4) ? 1:0;
        fail += check("C5b", characterReplacement("AABABBA", 1), 4) ? 0:1;

        pass += check("C6a", checkInclusion("ab", "eidbaooo"), true)  ? 1:0;
        fail += check("C6a", checkInclusion("ab", "eidbaooo"), true)  ? 0:1;
        pass += check("C6b", checkInclusion("ab", "eidboaoo"), false) ? 1:0;
        fail += check("C6b", checkInclusion("ab", "eidboaoo"), false) ? 0:1;

        pass += check("C7a", totalFruit(new int[]{1,2,3,2,2}), 4) ? 1:0;
        fail += check("C7a", totalFruit(new int[]{1,2,3,2,2}), 4) ? 0:1;

        pass += check("C8a", longestOnes(new int[]{1,1,0,0,1,1,1,0,1,1}, 2), 9) ? 1:0;
        fail += check("C8a", longestOnes(new int[]{1,1,0,0,1,1,1,0,1,1}, 2), 9) ? 0:1;

        pass += check("C9a", Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)), "[3, 3, 5, 5, 6, 7]") ? 1:0;
        fail += check("C9a", Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)), "[3, 3, 5, 5, 6, 7]") ? 0:1;

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
