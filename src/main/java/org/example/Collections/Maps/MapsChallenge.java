package org.example.Collections.Maps;

import java.util.*;

/**
 * ============================================================
 *          MAPS CHALLENGES — LeetCode Style
 * ============================================================
 */
public class MapsChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Two Sum (HashMap approach)
    // Return indices that sum to target.
    // Example: [2,7,11,15], target=9 → [0,1]
    // =========================================================
    static int[] twoSum(int[] nums, int target) { return new int[]{}; /* TODO: HashMap O(n) */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Valid Anagram
    // Return true if t is anagram of s.
    // Example: "anagram","nagaram" → true
    // =========================================================
    static boolean isAnagram(String s, String t) { return false; /* TODO: freq map */ }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Word Pattern
    // Pattern "abba", s="dog cat cat dog" → true
    // =========================================================
    static boolean wordPattern(String pattern, String s) { return false; /* TODO: two maps */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Group Anagrams
    // Group strings by anagram sets.
    // Example: ["eat","tea","tan","ate","nat","bat"] → 3 groups
    // =========================================================
    static List<List<String>> groupAnagrams(String[] strs) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Top K Frequent Elements
    // Return k most frequent elements.
    // Example: [1,1,1,2,2,3], k=2 → [1,2]
    // =========================================================
    static int[] topKFrequent(int[] nums, int k) { return new int[]{}; /* TODO: bucket sort */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Subarray Sum Equals K
    // Count number of subarrays with sum = k.
    // Example: [1,1,1], k=2 → 2
    // =========================================================
    static int subarraySum(int[] nums, int k) { return 0; /* TODO: prefix sum + HashMap */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Longest Consecutive Sequence
    // Find length of longest consecutive sequence.
    // Example: [100,4,200,1,3,2] → 4
    // =========================================================
    static int longestConsecutive(int[] nums) { return 0; /* TODO: HashSet */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — 4Sum II
    // Count tuples (i,j,k,l) where A[i]+B[j]+C[k]+D[l]=0.
    // Example: A=[1,2],B=[-2,-1],C=[-1,2],D=[0,2] → 2
    // =========================================================
    static int fourSumCount(int[] A, int[] B, int[] C, int[] D) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Minimum Window Substring
    // Find minimum window in s containing all chars of t.
    // Example: "ADOBECODEBANC","ABC" → "BANC"
    // =========================================================
    static String minWindow(String s, String t) { return ""; /* TODO: sliding window */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — All O'one Data Structure
    // Supports inc(key), dec(key), getMaxKey(), getMinKey() in O(1).
    // =========================================================
    static class AllOne {
        /* TODO: doubly-linked list + hashmap */
        AllOne() {}
        void inc(String key) {}
        void dec(String key) {}
        String getMaxKey() { return ""; }
        String getMinKey() { return ""; }
    }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)), "[0, 1]") ? 1:0;
        fail += check("C1a", Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)), "[0, 1]") ? 0:1;

        pass += check("C2a", isAnagram("anagram","nagaram"), true)  ? 1:0;
        fail += check("C2a", isAnagram("anagram","nagaram"), true)  ? 0:1;
        pass += check("C2b", isAnagram("rat","car"),         false) ? 1:0;
        fail += check("C2b", isAnagram("rat","car"),         false) ? 0:1;

        pass += check("C3a", wordPattern("abba","dog cat cat dog"),   true)  ? 1:0;
        fail += check("C3a", wordPattern("abba","dog cat cat dog"),   true)  ? 0:1;
        pass += check("C3b", wordPattern("abba","dog cat cat fish"), false) ? 1:0;
        fail += check("C3b", wordPattern("abba","dog cat cat fish"), false) ? 0:1;

        List<List<String>> ga = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        pass += check("C4a", ga.size(), 3) ? 1:0; fail += check("C4a", ga.size(), 3) ? 0:1;

        int[] tkf = topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        Arrays.sort(tkf);
        pass += check("C5a", Arrays.toString(tkf), "[1, 2]") ? 1:0;
        fail += check("C5a", Arrays.toString(tkf), "[1, 2]") ? 0:1;

        pass += check("C6a", subarraySum(new int[]{1,1,1}, 2), 2) ? 1:0;
        fail += check("C6a", subarraySum(new int[]{1,1,1}, 2), 2) ? 0:1;
        pass += check("C6b", subarraySum(new int[]{1,2,3}, 3), 2) ? 1:0;
        fail += check("C6b", subarraySum(new int[]{1,2,3}, 3), 2) ? 0:1;

        pass += check("C7a", longestConsecutive(new int[]{100,4,200,1,3,2}), 4) ? 1:0;
        fail += check("C7a", longestConsecutive(new int[]{100,4,200,1,3,2}), 4) ? 0:1;

        pass += check("C8a", fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2}), 2) ? 1:0;
        fail += check("C8a", fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2}), 2) ? 0:1;

        pass += check("C9a", minWindow("ADOBECODEBANC","ABC"), "BANC") ? 1:0;
        fail += check("C9a", minWindow("ADOBECODEBANC","ABC"), "BANC") ? 0:1;

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
