package org.example.Algorithms.DynamicProgramming;

import java.util.*;

/**
 * ============================================================
 *      DYNAMIC PROGRAMMING CHALLENGES — LeetCode Style
 * ============================================================
 */
public class DynamicProgrammingChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Climbing Stairs
    // n stairs, 1 or 2 steps. How many distinct ways?
    // Example: 2→2, 3→3, 5→8
    // =========================================================
    static int climbStairs(int n) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — House Robber
    // Max money, no two adjacent houses.
    // Example: [1,2,3,1]→4, [2,7,9,3,1]→12
    // =========================================================
    static int rob(int[] nums) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Maximum Subarray (Kadane's)
    // Example: [-2,1,-3,4,-1,2,1,-5,4] → 6
    // =========================================================
    static int maxSubArray(int[] nums) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Coin Change
    // Min coins to make amount. Return -1 if impossible.
    // Example: coins=[1,2,5], amount=11 → 3
    // =========================================================
    static int coinChange(int[] coins, int amount) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Longest Increasing Subsequence
    // Example: [10,9,2,5,3,7,101,18] → 4
    // =========================================================
    static int lengthOfLIS(int[] nums) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Unique Paths
    // Robot in m×n grid, moves right or down. Count paths.
    // Example: m=3, n=7 → 28
    // =========================================================
    static int uniquePaths(int m, int n) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Word Break
    // Can s be segmented into words from wordDict?
    // Example: "leetcode", ["leet","code"] → true
    // =========================================================
    static boolean wordBreak(String s, List<String> wordDict) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Partition Equal Subset Sum
    // Split array into two equal-sum subsets.
    // Example: [1,5,11,5]→true, [1,2,3,5]→false
    // =========================================================
    static boolean canPartition(int[] nums) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Edit Distance
    // Min operations (insert/delete/replace) to transform word1→word2.
    // Example: "horse"→"ros" = 3
    // =========================================================
    static int minDistance(String word1, String word2) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Longest Common Subsequence
    // Example: "abcde","ace" → 3
    // =========================================================
    static int longestCommonSubsequence(String text1, String text2) { return 0; /* TODO */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", climbStairs(2), 2) ? 1:0; fail += check("C1a", climbStairs(2), 2) ? 0:1;
        pass += check("C1b", climbStairs(3), 3) ? 1:0; fail += check("C1b", climbStairs(3), 3) ? 0:1;
        pass += check("C1c", climbStairs(5), 8) ? 1:0; fail += check("C1c", climbStairs(5), 8) ? 0:1;

        pass += check("C2a", rob(new int[]{1,2,3,1}),   4) ? 1:0; fail += check("C2a", rob(new int[]{1,2,3,1}),   4) ? 0:1;
        pass += check("C2b", rob(new int[]{2,7,9,3,1}), 12)? 1:0; fail += check("C2b", rob(new int[]{2,7,9,3,1}), 12)? 0:1;

        pass += check("C3a", maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}), 6) ? 1:0;
        fail += check("C3a", maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}), 6) ? 0:1;
        pass += check("C3b", maxSubArray(new int[]{1}), 1) ? 1:0;
        fail += check("C3b", maxSubArray(new int[]{1}), 1) ? 0:1;

        pass += check("C4a", coinChange(new int[]{1,2,5}, 11), 3)  ? 1:0; fail += check("C4a", coinChange(new int[]{1,2,5}, 11), 3)  ? 0:1;
        pass += check("C4b", coinChange(new int[]{2}, 3),      -1) ? 1:0; fail += check("C4b", coinChange(new int[]{2}, 3),      -1) ? 0:1;

        pass += check("C5a", lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}), 4) ? 1:0;
        fail += check("C5a", lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}), 4) ? 0:1;
        pass += check("C5b", lengthOfLIS(new int[]{0,1,0,3,2,3}),         4) ? 1:0;
        fail += check("C5b", lengthOfLIS(new int[]{0,1,0,3,2,3}),         4) ? 0:1;

        pass += check("C6a", uniquePaths(3, 7), 28) ? 1:0; fail += check("C6a", uniquePaths(3, 7), 28) ? 0:1;
        pass += check("C6b", uniquePaths(3, 2), 3)  ? 1:0; fail += check("C6b", uniquePaths(3, 2), 3)  ? 0:1;

        pass += check("C7a", wordBreak("leetcode",  Arrays.asList("leet","code")),      true)  ? 1:0;
        fail += check("C7a", wordBreak("leetcode",  Arrays.asList("leet","code")),      true)  ? 0:1;
        pass += check("C7b", wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")), false) ? 1:0;
        fail += check("C7b", wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")), false) ? 0:1;

        pass += check("C8a", canPartition(new int[]{1,5,11,5}), true)  ? 1:0;
        fail += check("C8a", canPartition(new int[]{1,5,11,5}), true)  ? 0:1;
        pass += check("C8b", canPartition(new int[]{1,2,3,5}),  false) ? 1:0;
        fail += check("C8b", canPartition(new int[]{1,2,3,5}),  false) ? 0:1;

        pass += check("C9a", minDistance("horse","ros"),        3) ? 1:0; fail += check("C9a", minDistance("horse","ros"),        3) ? 0:1;
        pass += check("C9b", minDistance("intention","execution"), 5) ? 1:0; fail += check("C9b", minDistance("intention","execution"), 5) ? 0:1;

        pass += check("C10a", longestCommonSubsequence("abcde","ace"),  3) ? 1:0; fail += check("C10a", longestCommonSubsequence("abcde","ace"),  3) ? 0:1;
        pass += check("C10b", longestCommonSubsequence("abc","abc"),    3) ? 1:0; fail += check("C10b", longestCommonSubsequence("abc","abc"),    3) ? 0:1;
        pass += check("C10c", longestCommonSubsequence("abc","def"),    0) ? 1:0; fail += check("C10c", longestCommonSubsequence("abc","def"),    0) ? 0:1;

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
