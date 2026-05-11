package org.example.Collections.Sets;

import java.util.*;

/**
 * ============================================================
 *          SETS CHALLENGES — LeetCode Style
 * ============================================================
 */
public class SetsChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Contains Duplicate
    // Return true if any value appears at least twice.
    // Example: [1,2,3,1] → true
    // =========================================================
    static boolean containsDuplicate(int[] nums) { return false; /* TODO: HashSet */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Intersection of Two Arrays
    // Return array of intersection (unique elements).
    // Example: [1,2,2,1],[2,2] → [2]
    // =========================================================
    static int[] intersection(int[] nums1, int[] nums2) { return new int[]{}; /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Happy Number
    // A number is happy if sum of squares of digits eventually reaches 1.
    // Example: 19→true, 2→false
    // =========================================================
    static boolean isHappy(int n) { return false; /* TODO: HashSet for cycle detection */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Longest Consecutive Sequence
    // Find length of longest consecutive sequence. O(n).
    // Example: [100,4,200,1,3,2] → 4
    // =========================================================
    static int longestConsecutive(int[] nums) { return 0; /* TODO: HashSet */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Set Matrix Zeroes
    // If element is 0, set its row and column to 0. In-place O(1) space.
    // =========================================================
    static void setZeroes(int[][] matrix) { /* TODO: first row/col as markers */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Find Duplicate File in System
    // Given paths, find all groups of duplicate files (same content).
    // Example: ["root/a 1.txt(abcd)","root/c 3.txt(abcd)"] → [[root/a/1.txt,root/c/3.txt]]
    // =========================================================
    static List<List<String>> findDuplicate(String[] paths) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Most Common Word
    // Find most frequent word in paragraph not in banned list.
    // Example: "Bob hit a ball, the hit BALL flew far after it was hit", banned=["hit"] → "ball"
    // =========================================================
    static String mostCommonWord(String paragraph, String[] banned) { return ""; /* TODO */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Design Add and Search Words
    // addWord(word), search(pattern) — '.' matches any char.
    // =========================================================
    static class WordDictionary {
        /* TODO: Trie with DFS for '.' wildcard */
        WordDictionary() {}
        void addWord(String word) {}
        boolean search(String word) { return false; }
    }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Word Search II
    // Find all words from list in the grid.
    // =========================================================
    static List<String> findWords(char[][] board, String[] words) { return new ArrayList<>(); /* TODO: Trie + DFS */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Number of Atoms
    // Parse chemical formula and return element counts.
    // Example: "H2O" → "H2O", "Mg(OH)2" → "H2MgO2"
    // =========================================================
    static String countOfAtoms(String formula) { return ""; /* TODO: stack + TreeMap */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", containsDuplicate(new int[]{1,2,3,1}), true)  ? 1:0;
        fail += check("C1a", containsDuplicate(new int[]{1,2,3,1}), true)  ? 0:1;
        pass += check("C1b", containsDuplicate(new int[]{1,2,3,4}), false) ? 1:0;
        fail += check("C1b", containsDuplicate(new int[]{1,2,3,4}), false) ? 0:1;

        int[] inter = intersection(new int[]{1,2,2,1}, new int[]{2,2});
        pass += check("C2a", Arrays.toString(inter), "[2]") ? 1:0;
        fail += check("C2a", Arrays.toString(inter), "[2]") ? 0:1;

        pass += check("C3a", isHappy(19), true)  ? 1:0; fail += check("C3a", isHappy(19), true)  ? 0:1;
        pass += check("C3b", isHappy(2),  false) ? 1:0; fail += check("C3b", isHappy(2),  false) ? 0:1;

        pass += check("C4a", longestConsecutive(new int[]{100,4,200,1,3,2}), 4) ? 1:0;
        fail += check("C4a", longestConsecutive(new int[]{100,4,200,1,3,2}), 4) ? 0:1;

        // C5: setZeroes
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        pass += check("C5a", Arrays.deepToString(matrix), "[[1, 0, 1], [0, 0, 0], [1, 0, 1]]") ? 1:0;
        fail += check("C5a", Arrays.deepToString(matrix), "[[1, 0, 1], [0, 0, 0], [1, 0, 1]]") ? 0:1;

        // C7: most common word
        pass += check("C7a", mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit",
                                             new String[]{"hit"}), "ball") ? 1:0;
        fail += check("C7a", mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit",
                                             new String[]{"hit"}), "ball") ? 0:1;

        // C8: word dictionary
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad"); wd.addWord("dad"); wd.addWord("mad");
        pass += check("C8a", wd.search("pad"), false) ? 1:0; fail += check("C8a", wd.search("pad"), false) ? 0:1;
        pass += check("C8b", wd.search("bad"), true)  ? 1:0; fail += check("C8b", wd.search("bad"), true)  ? 0:1;
        pass += check("C8c", wd.search(".ad"), true)  ? 1:0; fail += check("C8c", wd.search(".ad"), true)  ? 0:1;
        pass += check("C8d", wd.search("b.."), true)  ? 1:0; fail += check("C8d", wd.search("b.."), true)  ? 0:1;

        pass += check("C10a", countOfAtoms("H2O"),     "H2O")     ? 1:0; fail += check("C10a", countOfAtoms("H2O"),     "H2O")     ? 0:1;
        pass += check("C10b", countOfAtoms("Mg(OH)2"), "H2MgO2")  ? 1:0; fail += check("C10b", countOfAtoms("Mg(OH)2"), "H2MgO2")  ? 0:1;

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
