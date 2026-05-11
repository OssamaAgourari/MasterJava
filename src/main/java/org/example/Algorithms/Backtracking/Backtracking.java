package org.example.Algorithms.Backtracking;

import java.util.*;

/**
 * ============================================================
 *              BACKTRACKING — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS BACKTRACKING?
 * ----------------------
 * A general algorithm for finding ALL (or some) solutions to
 * computational problems by incrementally building candidates
 * and abandoning ("pruning") branches that cannot lead to a
 * valid solution.
 *
 * Think of it as: DFS on a decision tree + pruning.
 *
 * TEMPLATE:
 * ----------
 *   void backtrack(state, choices) {
 *       if (isComplete(state)) {
 *           result.add(copy of state);
 *           return;
 *       }
 *       for (choice : choices) {
 *           if (!isValid(state, choice)) continue;  // PRUNE
 *           makeChoice(state, choice);               // CHOOSE
 *           backtrack(state, remaining choices);     // EXPLORE
 *           undoChoice(state, choice);               // UN-CHOOSE
 *       }
 *   }
 *
 * CLASSIC PROBLEMS:
 * ------------------
 *   Permutations, Combinations, Subsets
 *   N-Queens, Sudoku Solver
 *   Word Search, Maze Solving
 *   Palindrome Partitioning
 *   Combination Sum
 *
 * TIME: Generally O(n! * n) or O(2^n * n) — exponential
 * SPACE: O(n) recursion depth + solution storage
 *
 * KEY INSIGHT: Pruning is everything. The faster you prune
 * invalid branches, the faster the algorithm runs.
 *
 * ============================================================
 */
public class Backtracking {

    // ── 1. Subsets ───────────────────────────────────────────
    // Include/exclude each element → 2^n subsets
    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }
    static void backtrackSubsets(int[] nums, int start, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrackSubsets(nums, i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }

    // ── 2. Permutations ──────────────────────────────────────
    static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackPerms(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }
    static void backtrackPerms(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) { res.add(new ArrayList<>(curr)); return; }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            curr.add(nums[i]);
            backtrackPerms(nums, used, curr, res);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }

    // ── 3. Combination Sum ────────────────────────────────────
    // Candidates can reuse. Find all combos that sum to target.
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrackCombSum(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }
    static void backtrackCombSum(int[] cands, int start, int rem, List<Integer> curr, List<List<Integer>> res) {
        if (rem == 0) { res.add(new ArrayList<>(curr)); return; }
        for (int i = start; i < cands.length; i++) {
            if (cands[i] > rem) break; // pruning — sorted, no point continuing
            curr.add(cands[i]);
            backtrackCombSum(cands, i, rem - cands[i], curr, res); // i, not i+1 → reuse allowed
            curr.remove(curr.size() - 1);
        }
    }

    // ── 4. N-Queens ──────────────────────────────────────────
    static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrackQueens(board, 0, result);
        return result;
    }
    static void backtrackQueens(char[][] board, int row, List<List<String>> res) {
        if (row == board.length) {
            List<String> sol = new ArrayList<>();
            for (char[] r : board) sol.add(new String(r));
            res.add(sol);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (!isSafeQueen(board, row, col)) continue;
            board[row][col] = 'Q';
            backtrackQueens(board, row + 1, res);
            board[row][col] = '.';
        }
    }
    static boolean isSafeQueen(char[][] board, int row, int col) {
        int n = board.length;
        for (int i = 0; i < row; i++) if (board[i][col] == 'Q') return false;
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) if (board[i][j]=='Q') return false;
        for (int i = row-1, j = col+1; i >= 0 && j < n;  i--, j++) if (board[i][j]=='Q') return false;
        return true;
    }

    // ── 5. Sudoku Solver ─────────────────────────────────────
    static boolean solveSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') continue;
                for (char d = '1'; d <= '9'; d++) {
                    if (!isValidSudoku(board, r, c, d)) continue;
                    board[r][c] = d;
                    if (solveSudoku(board)) return true;
                    board[r][c] = '.';
                }
                return false; // no digit works — backtrack
            }
        }
        return true; // all filled
    }
    static boolean isValidSudoku(char[][] b, int row, int col, char d) {
        for (int i = 0; i < 9; i++) {
            if (b[row][i] == d) return false;
            if (b[i][col] == d) return false;
            if (b[3*(row/3)+i/3][3*(col/3)+i%3] == d) return false;
        }
        return true;
    }

    // ── 6. Word Search ───────────────────────────────────────
    static boolean wordSearch(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                if (dfsWord(board, word, r, c, 0)) return true;
        return false;
    }
    static boolean dfsWord(char[][] board, String word, int r, int c, int idx) {
        if (idx == word.length()) return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
        if (board[r][c] != word.charAt(idx)) return false;
        char tmp = board[r][c];
        board[r][c] = '#'; // mark visited
        boolean found = dfsWord(board, word, r+1, c, idx+1) ||
                        dfsWord(board, word, r-1, c, idx+1) ||
                        dfsWord(board, word, r, c+1, idx+1) ||
                        dfsWord(board, word, r, c-1, idx+1);
        board[r][c] = tmp; // restore
        return found;
    }

    // ── 7. Palindrome Partitioning ───────────────────────────
    static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrackPalin(s, 0, new ArrayList<>(), result);
        return result;
    }
    static void backtrackPalin(String s, int start, List<String> curr, List<List<String>> res) {
        if (start == s.length()) { res.add(new ArrayList<>(curr)); return; }
        for (int end = start + 1; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            if (!isPalinStr(sub)) continue;
            curr.add(sub);
            backtrackPalin(s, end, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
    static boolean isPalinStr(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }

    // ── 8. Letter Combinations (phone) ───────────────────────
    static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        backtrackPhone(digits, 0, new StringBuilder(), result);
        return result;
    }
    static void backtrackPhone(String digits, int idx, StringBuilder curr, List<String> res) {
        if (idx == digits.length()) { res.add(curr.toString()); return; }
        for (char c : KEYS[digits.charAt(idx) - '0'].toCharArray()) {
            curr.append(c);
            backtrackPhone(digits, idx + 1, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public static void main(String[] args) {

        // EXERCISE 1: Subsets
        System.out.println("Subsets [1,2,3]: " + subsets(new int[]{1,2,3}).size() + " subsets"); // 8

        // EXERCISE 2: Permutations
        System.out.println("Permutations [1,2,3]: " + permutations(new int[]{1,2,3}).size()); // 6

        // EXERCISE 3: Combination Sum
        System.out.println("CombSum [2,3,6,7] target=7: " + combinationSum(new int[]{2,3,6,7}, 7)); // [[2,2,3],[7]]

        // EXERCISE 4: N-Queens
        System.out.println("4-Queens solutions: " + solveNQueens(4).size()); // 2

        // EXERCISE 5: Word Search
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println("Word 'ABCCED': " + wordSearch(board, "ABCCED")); // true
        System.out.println("Word 'SEE':    " + wordSearch(board, "SEE"));    // true
        System.out.println("Word 'ABCB':   " + wordSearch(board, "ABCB"));   // false

        // EXERCISE 6: Palindrome Partition
        System.out.println("Palindrome parts 'aab': " + partition("aab")); // [[a,a,b],[aa,b]]

        // EXERCISE 7: Letter Combinations
        System.out.println("Phone '23': " + letterCombinations("23").size() + " combos"); // 9

        // SUMMARY
        System.out.println("\n=== Backtracking ===");
        System.out.println("Pattern: CHOOSE → EXPLORE → UN-CHOOSE");
        System.out.println("Pruning: skip invalid choices early");
        System.out.println("All problems: DFS on implicit decision tree");
    }
}
