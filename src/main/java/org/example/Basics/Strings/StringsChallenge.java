package org.example.Basics.Strings;

import java.util.*;

/**
 * ============================================================
 *          STRINGS CHALLENGES — LeetCode Style
 * ============================================================
 */
public class StringsChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Valid Anagram
    // Return true if t is an anagram of s.
    // Example: s="anagram",t="nagaram"→true, s="rat",t="car"→false
    // =========================================================
    static boolean isAnagram(String s, String t) { return false; /* TODO: freq array */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Reverse Words in a String III
    // Reverse each word in a sentence, keep word order.
    // Example: "Let's take LeetCode contest" → "s'teL ekat edoCteeL tsetno c"
    // =========================================================
    static String reverseWords(String s) { return ""; /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Longest Common Prefix
    // Find longest common prefix among array of strings.
    // Example: ["flower","flow","flight"] → "fl"
    // =========================================================
    static String longestCommonPrefix(String[] strs) { return ""; /* TODO */ }

    // =========================================================
    // CHALLENGE 4  [EASY]  — Count and Say
    // nth term: describe previous term (run-length encoding).
    // 1→"1", 2→"11", 3→"21", 4→"1211", 5→"111221"
    // =========================================================
    static String countAndSay(int n) { return ""; /* TODO */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Longest Palindromic Substring
    // Find the longest palindromic substring.
    // Example: "babad"→"bab" or "aba", "cbbd"→"bb"
    // =========================================================
    static String longestPalindrome(String s) { return ""; /* TODO: expand around center */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Group Anagrams
    // Group strings that are anagrams of each other.
    // Example: ["eat","tea","tan","ate","nat","bat"] →
    //          [["eat","tea","ate"],["tan","nat"],["bat"]]
    // =========================================================
    static List<List<String>> groupAnagrams(String[] strs) { return new ArrayList<>(); /* TODO: sort as key */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Longest Substring Without Repeating
    // Find length of longest substring without repeating chars.
    // Example: "abcabcbb"→3, "bbbbb"→1, "pwwkew"→3
    // =========================================================
    static int lengthOfLongestSubstring(String s) { return 0; /* TODO: sliding window */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — String to Integer (atoi)
    // Parse an integer from string. Handle whitespace, sign, overflow.
    // Example: "42"→42, "  -42"→-42, "4193 with words"→4193
    // =========================================================
    static int myAtoi(String s) { return 0; /* TODO: state machine */ }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]  — Zigzag Conversion
    // Write string in zigzag on numRows rows then read row by row.
    // Example: "PAYPALISHIRING", numRows=3 → "PAHNAPLSIIGYIR"
    // =========================================================
    static String convert(String s, int numRows) { return ""; /* TODO: simulate */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Minimum Window Substring
    // Find minimum window in s containing all chars of t.
    // Example: s="ADOBECODEBANC", t="ABC" → "BANC"
    // =========================================================
    static String minWindow(String s, String t) { return ""; /* TODO: sliding window */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", isAnagram("anagram","nagaram"), true)  ? 1:0;
        fail += check("C1a", isAnagram("anagram","nagaram"), true)  ? 0:1;
        pass += check("C1b", isAnagram("rat","car"),         false) ? 1:0;
        fail += check("C1b", isAnagram("rat","car"),         false) ? 0:1;

        pass += check("C2a", reverseWords("Let's take LeetCode contest"), "s'teL ekat edoCteeL tsetno c") ? 1:0;
        fail += check("C2a", reverseWords("Let's take LeetCode contest"), "s'teL ekat edoCteeL tsetno c") ? 0:1;

        pass += check("C3a", longestCommonPrefix(new String[]{"flower","flow","flight"}), "fl") ? 1:0;
        fail += check("C3a", longestCommonPrefix(new String[]{"flower","flow","flight"}), "fl") ? 0:1;
        pass += check("C3b", longestCommonPrefix(new String[]{"dog","racecar","car"}), "") ? 1:0;
        fail += check("C3b", longestCommonPrefix(new String[]{"dog","racecar","car"}), "") ? 0:1;

        pass += check("C4a", countAndSay(1), "1")     ? 1:0; fail += check("C4a", countAndSay(1), "1")     ? 0:1;
        pass += check("C4b", countAndSay(4), "1211")  ? 1:0; fail += check("C4b", countAndSay(4), "1211")  ? 0:1;

        // C5: palindrome — accept either valid answer
        String lp = longestPalindrome("babad");
        pass += check("C5a", lp.equals("bab") || lp.equals("aba"), true) ? 1:0;
        fail += check("C5a", lp.equals("bab") || lp.equals("aba"), true) ? 0:1;
        pass += check("C5b", longestPalindrome("cbbd"), "bb") ? 1:0;
        fail += check("C5b", longestPalindrome("cbbd"), "bb") ? 0:1;

        // C6: group anagrams
        List<List<String>> ga = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        pass += check("C6a", ga.size(), 3) ? 1:0;
        fail += check("C6a", ga.size(), 3) ? 0:1;

        pass += check("C7a", lengthOfLongestSubstring("abcabcbb"), 3) ? 1:0;
        fail += check("C7a", lengthOfLongestSubstring("abcabcbb"), 3) ? 0:1;
        pass += check("C7b", lengthOfLongestSubstring("bbbbb"),    1) ? 1:0;
        fail += check("C7b", lengthOfLongestSubstring("bbbbb"),    1) ? 0:1;
        pass += check("C7c", lengthOfLongestSubstring("pwwkew"),   3) ? 1:0;
        fail += check("C7c", lengthOfLongestSubstring("pwwkew"),   3) ? 0:1;

        pass += check("C8a", myAtoi("42"),              42)  ? 1:0; fail += check("C8a", myAtoi("42"),              42)  ? 0:1;
        pass += check("C8b", myAtoi("  -42"),          -42)  ? 1:0; fail += check("C8b", myAtoi("  -42"),          -42)  ? 0:1;
        pass += check("C8c", myAtoi("4193 with words"), 4193) ? 1:0; fail += check("C8c", myAtoi("4193 with words"), 4193) ? 0:1;

        pass += check("C9a", convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR") ? 1:0;
        fail += check("C9a", convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR") ? 0:1;
        pass += check("C9b", convert("PAYPALISHIRING", 4), "PINALSIGYAHRPI") ? 1:0;
        fail += check("C9b", convert("PAYPALISHIRING", 4), "PINALSIGYAHRPI") ? 0:1;

        pass += check("C10a", minWindow("ADOBECODEBANC","ABC"), "BANC") ? 1:0;
        fail += check("C10a", minWindow("ADOBECODEBANC","ABC"), "BANC") ? 0:1;
        pass += check("C10b", minWindow("a","a"), "a")                  ? 1:0;
        fail += check("C10b", minWindow("a","a"), "a")                  ? 0:1;

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
