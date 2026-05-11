package org.example.Algorithms.Recursion;

import java.util.*;

/**
 * ============================================================
 *         RECURSION CHALLENGES — LeetCode Style
 * ============================================================
 */
public class RecursionChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Power of Two
    // Is n a power of 2? n > 0.
    // Example: 1→true, 16→true, 3→false
    // =========================================================
    static boolean isPowerOfTwo(int n) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Climbing Stairs
    // n stairs, climb 1 or 2 steps. How many distinct ways?
    // Example: 2→2, 3→3, 5→8
    // =========================================================
    static int climbStairs(int n) { return 0; /* TODO: fib-like */ }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Reverse String
    // Reverse char array in-place using recursion.
    // Example: ['h','e','l','l','o'] → ['o','l','l','e','h']
    // =========================================================
    static void reverseString(char[] s) { /* TODO */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Pow(x, n)
    // Implement x^n. n can be negative.
    // Example: 2.00000^10 → 1024.0, 2^-2 → 0.25
    // =========================================================
    static double myPow(double x, int n) { return 0.0; /* TODO: O(log n) */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Generate Parentheses
    // All combinations of n pairs of valid parentheses.
    // Example: n=3 → ["((()))","(()())","(())()","()(())","()()()"]
    // =========================================================
    static List<String> generateParenthesis(int n) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Subsets
    // All possible subsets (power set). No duplicates.
    // Example: [1,2,3] → [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    // =========================================================
    static List<List<Integer>> subsets(int[] nums) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Permutations
    // All unique permutations of distinct integers.
    // Example: [1,2,3] → [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    // =========================================================
    static List<List<Integer>> permute(int[] nums) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Letter Combinations of a Phone Number
    // Example: "23" → ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    // =========================================================
    static List<String> letterCombinations(String digits) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 9  [HARD]  — N-Queens
    // Place n queens on n×n board so no two attack each other.
    // Return all distinct solutions. n=4 → 2 solutions.
    // =========================================================
    static List<List<String>> solveNQueens(int n) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Decode Ways
    // Decode string of digits into letters (A=1..Z=26).
    // Example: "226" → 3 ("BZ","VF","BBF")
    // =========================================================
    static int numDecodings(String s) { return 0; /* TODO */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", isPowerOfTwo(1),   true)  ? 1:0; fail += check("C1a", isPowerOfTwo(1),   true)  ? 0:1;
        pass += check("C1b", isPowerOfTwo(16),  true)  ? 1:0; fail += check("C1b", isPowerOfTwo(16),  true)  ? 0:1;
        pass += check("C1c", isPowerOfTwo(3),   false) ? 1:0; fail += check("C1c", isPowerOfTwo(3),   false) ? 0:1;

        pass += check("C2a", climbStairs(2), 2) ? 1:0; fail += check("C2a", climbStairs(2), 2) ? 0:1;
        pass += check("C2b", climbStairs(3), 3) ? 1:0; fail += check("C2b", climbStairs(3), 3) ? 0:1;
        pass += check("C2c", climbStairs(5), 8) ? 1:0; fail += check("C2c", climbStairs(5), 8) ? 0:1;

        char[] rev = {'h','e','l','l','o'}; reverseString(rev);
        pass += check("C3a", new String(rev), "olleh") ? 1:0; fail += check("C3a", new String(rev), "olleh") ? 0:1;

        pass += check("C4a", myPow(2.0, 10),  1024.0) ? 1:0; fail += check("C4a", myPow(2.0, 10),  1024.0) ? 0:1;
        pass += check("C4b", myPow(2.0, -2),  0.25)   ? 1:0; fail += check("C4b", myPow(2.0, -2),  0.25)   ? 0:1;

        pass += check("C5a", generateParenthesis(3).size(), 5) ? 1:0; fail += check("C5a", generateParenthesis(3).size(), 5) ? 0:1;
        pass += check("C5b", generateParenthesis(1).size(), 1) ? 1:0; fail += check("C5b", generateParenthesis(1).size(), 1) ? 0:1;

        pass += check("C6a", subsets(new int[]{1,2,3}).size(), 8) ? 1:0; fail += check("C6a", subsets(new int[]{1,2,3}).size(), 8) ? 0:1;

        pass += check("C7a", permute(new int[]{1,2,3}).size(), 6) ? 1:0; fail += check("C7a", permute(new int[]{1,2,3}).size(), 6) ? 0:1;

        pass += check("C8a", letterCombinations("23").size(), 9) ? 1:0; fail += check("C8a", letterCombinations("23").size(), 9) ? 0:1;
        pass += check("C8b", letterCombinations("").size(), 0)   ? 1:0; fail += check("C8b", letterCombinations("").size(), 0)   ? 0:1;

        pass += check("C9a", solveNQueens(4).size(), 2) ? 1:0; fail += check("C9a", solveNQueens(4).size(), 2) ? 0:1;
        pass += check("C9b", solveNQueens(1).size(), 1) ? 1:0; fail += check("C9b", solveNQueens(1).size(), 1) ? 0:1;

        pass += check("C10a", numDecodings("226"),  3) ? 1:0; fail += check("C10a", numDecodings("226"),  3) ? 0:1;
        pass += check("C10b", numDecodings("12"),   2) ? 1:0; fail += check("C10b", numDecodings("12"),   2) ? 0:1;
        pass += check("C10c", numDecodings("0"),    0) ? 1:0; fail += check("C10c", numDecodings("0"),    0) ? 0:1;

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
