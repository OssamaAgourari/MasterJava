package org.example.Algorithms.Backtracking;

import java.util.*;

/**
 * ============================================================
 *        BACKTRACKING CHALLENGES — LeetCode Style
 * ============================================================
 */
public class BacktrackingChallenge {

    // =========================================================
    // CHALLENGE 1  [MEDIUM]  — Subsets
    // Example: [1,2,3] → 8 subsets
    // =========================================================
    static List<List<Integer>> subsets(int[] nums) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 2  [MEDIUM]  — Permutations
    // All permutations of distinct integers.
    // Example: [1,2,3] → 6 permutations
    // =========================================================
    static List<List<Integer>> permute(int[] nums) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [MEDIUM]  — Combination Sum
    // Candidates can be reused. Sum to target.
    // Example: [2,3,6,7], target=7 → [[2,2,3],[7]]
    // =========================================================
    static List<List<Integer>> combinationSum(int[] candidates, int target) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Combination Sum II
    // Each candidate can only be used once. No duplicate combos.
    // Example: [10,1,2,7,6,1,5], target=8 → [[1,1,6],[1,2,5],[1,7],[2,6]]
    // =========================================================
    static List<List<Integer>> combinationSum2(int[] candidates, int target) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Generate Parentheses
    // Example: n=3 → 5 valid combinations
    // =========================================================
    static List<String> generateParenthesis(int n) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Word Search
    // Find if word exists in 2D board (consecutive adjacent cells).
    // Example: board=[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word="ABCCED" → true
    // =========================================================
    static boolean exist(char[][] board, String word) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Palindrome Partitioning
    // All ways to partition s so every substring is a palindrome.
    // Example: "aab" → [["a","a","b"],["aa","b"]]
    // =========================================================
    static List<List<String>> partition(String s) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Subsets II (with duplicates)
    // Input may contain duplicates. Return unique subsets.
    // Example: [1,2,2] → [[],[1],[1,2],[1,2,2],[2],[2,2]]
    // =========================================================
    static List<List<Integer>> subsetsWithDup(int[] nums) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 9  [HARD]  — N-Queens
    // Place n queens, no two attack each other.
    // Example: n=4 → 2 solutions
    // =========================================================
    static List<List<String>> solveNQueens(int n) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Sudoku Solver
    // Solve a 9x9 sudoku board in-place.
    // =========================================================
    static void solveSudoku(char[][] board) { /* TODO */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", subsets(new int[]{1,2,3}).size(),     8) ? 1:0;
        fail += check("C1a", subsets(new int[]{1,2,3}).size(),     8) ? 0:1;
        pass += check("C1b", subsets(new int[]{0}).size(),         2) ? 1:0;
        fail += check("C1b", subsets(new int[]{0}).size(),         2) ? 0:1;

        pass += check("C2a", permute(new int[]{1,2,3}).size(),     6) ? 1:0;
        fail += check("C2a", permute(new int[]{1,2,3}).size(),     6) ? 0:1;

        List<List<Integer>> cs = combinationSum(new int[]{2,3,6,7}, 7);
        pass += check("C3a", cs.size(), 2) ? 1:0;
        fail += check("C3a", cs.size(), 2) ? 0:1;

        List<List<Integer>> cs2 = combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        pass += check("C4a", cs2.size(), 4) ? 1:0;
        fail += check("C4a", cs2.size(), 4) ? 0:1;

        pass += check("C5a", generateParenthesis(3).size(), 5) ? 1:0;
        fail += check("C5a", generateParenthesis(3).size(), 5) ? 0:1;
        pass += check("C5b", generateParenthesis(1).size(), 1) ? 1:0;
        fail += check("C5b", generateParenthesis(1).size(), 1) ? 0:1;

        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        pass += check("C6a", exist(board, "ABCCED"), true)  ? 1:0;
        fail += check("C6a", exist(board, "ABCCED"), true)  ? 0:1;
        pass += check("C6b", exist(board, "ABCB"),   false) ? 1:0;
        fail += check("C6b", exist(board, "ABCB"),   false) ? 0:1;

        pass += check("C7a", partition("aab").size(),  2) ? 1:0;
        fail += check("C7a", partition("aab").size(),  2) ? 0:1;
        pass += check("C7b", partition("a").size(),    1) ? 1:0;
        fail += check("C7b", partition("a").size(),    1) ? 0:1;

        pass += check("C8a", subsetsWithDup(new int[]{1,2,2}).size(), 6) ? 1:0;
        fail += check("C8a", subsetsWithDup(new int[]{1,2,2}).size(), 6) ? 0:1;

        pass += check("C9a", solveNQueens(4).size(), 2) ? 1:0;
        fail += check("C9a", solveNQueens(4).size(), 2) ? 0:1;
        pass += check("C9b", solveNQueens(1).size(), 1) ? 1:0;
        fail += check("C9b", solveNQueens(1).size(), 1) ? 0:1;

        // Sudoku test
        char[][] sudoku = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(sudoku);
        pass += check("C10a", sudoku[0][2], '4') ? 1:0;
        fail += check("C10a", sudoku[0][2], '4') ? 0:1;

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
