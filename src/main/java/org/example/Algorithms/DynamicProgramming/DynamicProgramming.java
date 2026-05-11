package org.example.Algorithms.DynamicProgramming;

import java.util.*;

/**
 * ============================================================
 *          DYNAMIC PROGRAMMING — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS DP?
 * ------------
 * An optimization technique that solves problems by breaking
 * them into overlapping sub-problems, solving each ONCE,
 * and storing results (memoization / tabulation).
 *
 * TWO CONDITIONS FOR DP:
 * -----------------------
 *   1. OPTIMAL SUBSTRUCTURE:
 *      Optimal solution contains optimal sub-solutions.
 *   2. OVERLAPPING SUB-PROBLEMS:
 *      Same sub-problems are solved multiple times.
 *      (If sub-problems don't overlap → use Divide & Conquer)
 *
 * TWO APPROACHES:
 * ----------------
 *   TOP-DOWN (Memoization):
 *     Recursive + cache results in HashMap/array
 *     Natural — write recursion, add memo
 *
 *   BOTTOM-UP (Tabulation):
 *     Iterative, fill table from base case up
 *     Better space (no stack), often faster in practice
 *
 * DP PATTERNS:
 * -------------
 *   1D DP:  Fibonacci, Climbing Stairs, House Robber
 *   2D DP:  Grid paths, Edit Distance, LCS
 *   Knapsack: 0/1, Unbounded, Subset Sum
 *   String DP: LCS, LIS, Edit Distance, Palindrome
 *   Interval DP: Matrix Chain, Burst Balloons
 *   Tree DP: Max path sum, Diameter
 *
 * TIME/SPACE:
 * ------------
 *   Usually O(n) or O(n²) time, O(n) or O(n²) space
 *   Space can often be optimized: O(n²) → O(n)
 *
 * ============================================================
 */
public class DynamicProgramming {

    // ── 1. Fibonacci — bottom-up O(n) time, O(1) space ───────
    static long fibonacci(int n) {
        if (n <= 1) return n;
        long prev2 = 0, prev1 = 1;
        for (int i = 2; i <= n; i++) { long curr = prev1 + prev2; prev2 = prev1; prev1 = curr; }
        return prev1;
    }

    // ── 2. Climbing Stairs ────────────────────────────────────
    // Same as Fibonacci. O(n) time, O(1) space
    static int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) { int c = a + b; a = b; b = c; }
        return b;
    }

    // ── 3. House Robber ───────────────────────────────────────
    // Max money, no two adjacent houses. O(n) time, O(1) space
    static int houseRobber(int[] nums) {
        int prev2 = 0, prev1 = 0;
        for (int num : nums) { int curr = Math.max(prev1, prev2 + num); prev2 = prev1; prev1 = curr; }
        return prev1;
    }

    // ── 4. 0/1 Knapsack ──────────────────────────────────────
    // dp[i][w] = max value using items[0..i] with capacity w
    // Time O(n*W), Space O(n*W) → optimizable to O(W)
    static int knapsack(int[] weights, int[] values, int W) {
        int n = weights.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                dp[i][w] = dp[i-1][w];
                if (weights[i-1] <= w)
                    dp[i][w] = Math.max(dp[i][w], dp[i-1][w-weights[i-1]] + values[i-1]);
            }
        }
        return dp[n][W];
    }

    // ── 5. Longest Common Subsequence ────────────────────────
    // dp[i][j] = LCS of text1[0..i-1] and text2[0..j-1]
    // Time O(m*n), Space O(m*n)
    static int lcs(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }

    // ── 6. Longest Increasing Subsequence ────────────────────
    // O(n²) DP version
    static int lis(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++)
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // ── 7. Edit Distance (Levenshtein) ────────────────────────
    // Min insert/delete/replace ops to transform word1→word2
    // O(m*n) time and space
    static int editDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
            }
        }
        return dp[m][n];
    }

    // ── 8. Coin Change ────────────────────────────────────────
    // Min coins to make amount. dp[i] = min coins for amount i.
    // O(amount * n) time, O(amount) space
    static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // "infinity"
        dp[0] = 0;
        for (int i = 1; i <= amount; i++)
            for (int coin : coins)
                if (coin <= i) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // ── 9. Unique Paths (grid) ────────────────────────────────
    // Robot moves right or down in m×n grid.
    // dp[i][j] = paths to reach (i,j)
    // O(m*n) time, O(n) space (row-by-row)
    static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[j] += dp[j - 1];
        return dp[n - 1];
    }

    // ── 10. Longest Palindromic Substring ────────────────────
    // Expand around center: O(n²) time, O(1) space
    static String longestPalindrome(String s) {
        int start = 0, maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            // odd length
            int lo = i, hi = i;
            while (lo > 0 && hi < s.length()-1 && s.charAt(lo-1) == s.charAt(hi+1)) { lo--; hi++; }
            if (hi - lo + 1 > maxLen) { maxLen = hi - lo + 1; start = lo; }
            // even length
            lo = i; hi = i + 1;
            while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) { lo--; hi++; }
            if (hi - lo - 1 > maxLen) { maxLen = hi - lo - 1; start = lo + 1; }
        }
        return s.substring(start, start + maxLen);
    }

    // ── 11. Maximum Subarray (Kadane's) ──────────────────────
    // O(n) time, O(1) space
    static int maxSubArray(int[] nums) {
        int maxSum = nums[0], curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            maxSum = Math.max(maxSum, curr);
        }
        return maxSum;
    }

    // ── 12. Word Break ────────────────────────────────────────
    // Can s be segmented into words from wordDict?
    static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++)
            for (int j = 0; j < i; j++)
                if (dp[j] && dict.contains(s.substring(j, i))) { dp[i] = true; break; }
        return dp[s.length()];
    }

    // ── 13. Partition Equal Subset Sum ────────────────────────
    // Can array be split into two equal-sum subsets?
    static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums)
            for (int j = target; j >= num; j--)
                dp[j] |= dp[j - num];
        return dp[target];
    }

    public static void main(String[] args) {

        // EXERCISE 1: Fibonacci
        System.out.println("Fib(10) = " + fibonacci(10)); // 55
        System.out.println("Fib(40) = " + fibonacci(40)); // 102334155

        // EXERCISE 2: Climbing stairs
        System.out.println("Stairs(5) = " + climbStairs(5)); // 8

        // EXERCISE 3: House Robber
        System.out.println("Rob [1,2,3,1] = " + houseRobber(new int[]{1,2,3,1}));       // 4
        System.out.println("Rob [2,7,9,3,1] = " + houseRobber(new int[]{2,7,9,3,1}));   // 12

        // EXERCISE 4: Knapsack
        System.out.println("Knapsack = " + knapsack(new int[]{2,3,4,5}, new int[]{3,4,5,6}, 5)); // 7

        // EXERCISE 5: LCS
        System.out.println("LCS('abcde','ace') = " + lcs("abcde","ace"));    // 3
        System.out.println("LCS('abc','abc')   = " + lcs("abc","abc"));      // 3
        System.out.println("LCS('abc','def')   = " + lcs("abc","def"));      // 0

        // EXERCISE 6: LIS
        System.out.println("LIS [10,9,2,5,3,7,101,18] = " + lis(new int[]{10,9,2,5,3,7,101,18})); // 4

        // EXERCISE 7: Edit Distance
        System.out.println("Edit('horse','ros') = " + editDistance("horse","ros")); // 3
        System.out.println("Edit('intention','execution') = " + editDistance("intention","execution")); // 5

        // EXERCISE 8: Coin Change
        System.out.println("Coins([1,2,5],11) = " + coinChange(new int[]{1,2,5}, 11));   // 3
        System.out.println("Coins([2],3)      = " + coinChange(new int[]{2}, 3));         // -1

        // EXERCISE 9: Unique Paths
        System.out.println("UniquePaths(3,7) = " + uniquePaths(3,7));   // 28
        System.out.println("UniquePaths(3,2) = " + uniquePaths(3,2));   // 3

        // EXERCISE 10: Longest Palindrome
        System.out.println("LongestPalin 'babad' = " + longestPalindrome("babad")); // bab or aba
        System.out.println("LongestPalin 'cbbd'  = " + longestPalindrome("cbbd"));  // bb

        // EXERCISE 11: Max Subarray
        System.out.println("MaxSubarray [-2,1,-3,4,-1,2,1,-5,4] = " + maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})); // 6

        // EXERCISE 12: Word Break
        System.out.println("WordBreak 'leetcode' = " + wordBreak("leetcode", Arrays.asList("leet","code"))); // true

        // EXERCISE 13: Partition
        System.out.println("Partition [1,5,11,5] = " + canPartition(new int[]{1,5,11,5})); // true
        System.out.println("Partition [1,2,3,5]  = " + canPartition(new int[]{1,2,3,5}));  // false

        // SUMMARY
        System.out.println("\n=== Dynamic Programming ===");
        System.out.println("Memoization (top-down): recursion + cache");
        System.out.println("Tabulation (bottom-up): fill table iteratively");
        System.out.println("Key: identify state + transition + base case");
        System.out.println("Optimize: often reduce 2D DP to 1D with rolling array");
    }
}
