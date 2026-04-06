package org.example.DataStructures.HashMap;

import java.util.*;

/**
 * ============================================================
 *           HASH MAP CHALLENGES — LeetCode Style
 * ============================================================
 */
public class HashMapChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Two Sum
    // Example: [2,7,11,15], target=9 → [0,1]
    // =========================================================
    static int[] twoSum(int[] nums, int target) { return new int[0]; /* TODO */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Valid Anagram
    // Example: "anagram","nagaram" → true  "rat","car" → false
    // =========================================================
    static boolean isAnagram(String s, String t) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Contains Duplicate
    // Return true if any value appears at least twice.
    // Example: [1,2,3,1] → true
    // =========================================================
    static boolean containsDuplicate(int[] nums) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 4  [EASY]  — First Unique Character
    // Return index of first non-repeating character, or -1.
    // Example: "leetcode" → 0  "aabb" → -1
    // =========================================================
    static int firstUniqChar(String s) { return -1; /* TODO */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Group Anagrams
    // Group strings that are anagrams of each other.
    // Example: ["eat","tea","tan","ate","nat","bat"]
    //        → [["bat"],["nat","tan"],["ate","eat","tea"]]
    // =========================================================
    static List<List<String>> groupAnagrams(String[] strs) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Longest Consecutive Sequence
    // Return length of longest consecutive elements sequence.
    // Example: [100,4,200,1,3,2] → 4  ([1,2,3,4])
    // Must run in O(n).
    // =========================================================
    static int longestConsecutive(int[] nums) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Subarray Sum Equals K
    // Return number of subarrays with sum equal to k.
    // Example: [1,1,1], k=2 → 2
    // Hint: prefix sum + HashMap
    // =========================================================
    static int subarraySum(int[] nums, int k) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — 4Sum II
    // Count tuples (i,j,k,l) such that A[i]+B[j]+C[k]+D[l]==0.
    // Example: A=[1,2],B=[-2,-1],C=[-1,2],D=[0,2] → 2
    // =========================================================
    static int fourSumCount(int[] a, int[] b, int[] c, int[] d) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]  — Copy List with Random Pointer
    // Deep copy a linked list where each node has next and random pointer.
    // =========================================================
    static class Node {
        int val; Node next, random;
        Node(int v) { val=v; }
    }
    static Node copyRandomList(Node head) { return null; /* TODO */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Minimum Window Substring
    // Return smallest window in s containing all chars of t.
    // Example: s="ADOBECODEBANC", t="ABC" → "BANC"
    // Hint: sliding window + character frequency map
    // =========================================================
    static String minWindow(String s, String t) { return ""; /* TODO */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += checkArr("C1a", twoSum(new int[]{2,7,11,15},9), new int[]{0,1}) ? 1:0;
        fail += checkArr("C1a", twoSum(new int[]{2,7,11,15},9), new int[]{0,1}) ? 0:1;

        pass += check("C2a", isAnagram("anagram","nagaram"), true)  ? 1:0;
        fail += check("C2a", isAnagram("anagram","nagaram"), true)  ? 0:1;
        pass += check("C2b", isAnagram("rat","car"),         false) ? 1:0;
        fail += check("C2b", isAnagram("rat","car"),         false) ? 0:1;

        pass += check("C3a", containsDuplicate(new int[]{1,2,3,1}), true)  ? 1:0;
        fail += check("C3a", containsDuplicate(new int[]{1,2,3,1}), true)  ? 0:1;
        pass += check("C3b", containsDuplicate(new int[]{1,2,3,4}), false) ? 1:0;
        fail += check("C3b", containsDuplicate(new int[]{1,2,3,4}), false) ? 0:1;

        pass += check("C4a", firstUniqChar("leetcode"), 0)  ? 1:0;
        fail += check("C4a", firstUniqChar("leetcode"), 0)  ? 0:1;
        pass += check("C4b", firstUniqChar("aabb"),     -1) ? 1:0;
        fail += check("C4b", firstUniqChar("aabb"),     -1) ? 0:1;

        List<List<String>> ga = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        pass += check("C5a", ga.size(), 3) ? 1:0; fail += check("C5a", ga.size(), 3) ? 0:1;

        pass += check("C6a", longestConsecutive(new int[]{100,4,200,1,3,2}), 4) ? 1:0;
        fail += check("C6a", longestConsecutive(new int[]{100,4,200,1,3,2}), 4) ? 0:1;

        pass += check("C7a", subarraySum(new int[]{1,1,1}, 2), 2) ? 1:0;
        fail += check("C7a", subarraySum(new int[]{1,1,1}, 2), 2) ? 0:1;
        pass += check("C7b", subarraySum(new int[]{1,2,3},  3), 2) ? 1:0;
        fail += check("C7b", subarraySum(new int[]{1,2,3},  3), 2) ? 0:1;

        pass += check("C8a", fourSumCount(new int[]{1,2},new int[]{-2,-1},new int[]{-1,2},new int[]{0,2}), 2) ? 1:0;
        fail += check("C8a", fourSumCount(new int[]{1,2},new int[]{-2,-1},new int[]{-1,2},new int[]{0,2}), 2) ? 0:1;

        pass += check("C10a", minWindow("ADOBECODEBANC","ABC"), "BANC") ? 1:0;
        fail += check("C10a", minWindow("ADOBECODEBANC","ABC"), "BANC") ? 0:1;
        pass += check("C10b", minWindow("a","a"), "a") ? 1:0;
        fail += check("C10b", minWindow("a","a"), "a") ? 0:1;

        System.out.println("\n==============================");
        System.out.println("  RESULTS: " + pass + " passed, " + fail + " failed");
        System.out.println("==============================");
    }

    private static boolean check(String n, Object got, Object exp) {
        boolean ok = String.valueOf(got).equals(String.valueOf(exp));
        System.out.printf("%-6s %s  (exp:%s | got:%s)%n", n, ok?"✔":"✘", exp, got);
        return ok;
    }
    private static boolean checkArr(String n, int[] got, int[] exp) {
        boolean ok = Arrays.equals(got, exp);
        System.out.printf("%-6s %s  (exp:%s | got:%s)%n", n, ok?"✔":"✘",
                Arrays.toString(exp), Arrays.toString(got));
        return ok;
    }
}
