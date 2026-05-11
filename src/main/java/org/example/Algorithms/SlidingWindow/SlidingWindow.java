package org.example.Algorithms.SlidingWindow;

import java.util.*;

/**
 * ============================================================
 *              SLIDING WINDOW — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS SLIDING WINDOW?
 * ------------------------
 * A technique using a window (contiguous subarray/substring)
 * that slides over the data, expanding/shrinking from either
 * end. Reduces O(n²) brute-force to O(n).
 *
 * PATTERNS:
 * ----------
 *   1. FIXED SIZE WINDOW
 *      Window size k stays constant. Slide one step at a time.
 *      Use: max sum of size-k subarray, average, count
 *
 *   2. VARIABLE SIZE (expand/shrink)
 *      Right pointer expands; left shrinks when condition violated.
 *      Use: longest substring without repeating, min window substring
 *
 *   3. COUNTING / FREQUENCY MAP
 *      Track char/element counts inside window with a HashMap.
 *      Use: anagram in string, permutation, min window
 *
 * TEMPLATE (variable window):
 * ----------------------------
 *   int left = 0;
 *   for (int right = 0; right < n; right++) {
 *       // expand: add arr[right] to window
 *       while (window is invalid) {
 *           // shrink: remove arr[left] from window
 *           left++;
 *       }
 *       // update answer
 *   }
 *
 * TIME:  O(n) — each element enters and leaves window at most once
 * SPACE: O(k) or O(alphabet) for frequency map
 *
 * ============================================================
 */
public class SlidingWindow {

    public static void main(String[] args) {

        // ── EXERCISE 1: Max sum of subarray of size k (fixed) ──
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int windowSum = 0, maxSum = 0;
        for (int i = 0; i < k; i++) windowSum += arr[i];
        maxSum = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        System.out.println("Max sum (k=3): " + maxSum); // 9

        // ── EXERCISE 2: Minimum size subarray sum ≥ target ─────
        int[] a2 = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int left = 0, sum = 0, minLen = Integer.MAX_VALUE;
        for (int right = 0; right < a2.length; right++) {
            sum += a2[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= a2[left++];
            }
        }
        System.out.println("Min subarray len sum>=7: " + minLen); // 2

        // ── EXERCISE 3: Longest substring without repeating chars
        String s = "abcabcbb";
        int lo = 0, maxLen = 0;
        Set<Character> seen = new HashSet<>();
        for (int r = 0; r < s.length(); r++) {
            while (seen.contains(s.charAt(r))) seen.remove(s.charAt(lo++));
            seen.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - lo + 1);
        }
        System.out.println("Longest no-repeat: " + maxLen); // 3

        // ── EXERCISE 4: Longest substring with at most K distinct chars
        String s4 = "eceba";
        int kDistinct = 2;
        Map<Character, Integer> freq = new HashMap<>();
        lo = 0; maxLen = 0;
        for (int r = 0; r < s4.length(); r++) {
            freq.merge(s4.charAt(r), 1, Integer::sum);
            while (freq.size() > kDistinct) {
                char c = s4.charAt(lo++);
                freq.merge(c, -1, Integer::sum);
                if (freq.get(c) == 0) freq.remove(c);
            }
            maxLen = Math.max(maxLen, r - lo + 1);
        }
        System.out.println("Longest k-distinct (k=2): " + maxLen); // 3

        // ── EXERCISE 5: Find all anagrams of p in s ─────────────
        String s5 = "cbaebabacd", p = "abc";
        int[] pCount = new int[26], wCount = new int[26];
        List<Integer> result = new ArrayList<>();
        for (char c : p.toCharArray()) pCount[c - 'a']++;
        for (int r = 0; r < s5.length(); r++) {
            wCount[s5.charAt(r) - 'a']++;
            if (r >= p.length()) wCount[s5.charAt(r - p.length()) - 'a']--;
            if (Arrays.equals(pCount, wCount)) result.add(r - p.length() + 1);
        }
        System.out.println("Anagram positions: " + result); // [0, 6]

        // ── EXERCISE 6: Max consecutive ones with at most k flips
        int[] bin = {1, 1, 0, 0, 1, 1, 1, 0, 1, 1};
        int kFlips = 2, zeros = 0;
        lo = 0; maxLen = 0;
        for (int r = 0; r < bin.length; r++) {
            if (bin[r] == 0) zeros++;
            while (zeros > kFlips) { if (bin[lo++] == 0) zeros--; }
            maxLen = Math.max(maxLen, r - lo + 1);
        }
        System.out.println("Max ones with 2 flips: " + maxLen); // 9

        // ── EXERCISE 7: Minimum window substring ────────────────
        String s7 = "ADOBECODEBANC", t = "ABC";
        int[] need = new int[128], have = new int[128];
        for (char c : t.toCharArray()) need[c]++;
        int formed = 0, required = (int) t.chars().distinct().count();
        lo = 0; int minStart = 0; minLen = Integer.MAX_VALUE;
        for (int r = 0; r < s7.length(); r++) {
            char rc = s7.charAt(r);
            have[rc]++;
            if (need[rc] > 0 && have[rc] == need[rc]) formed++;
            while (formed == required) {
                if (r - lo + 1 < minLen) { minLen = r - lo + 1; minStart = lo; }
                char lc = s7.charAt(lo++);
                have[lc]--;
                if (need[lc] > 0 && have[lc] < need[lc]) formed--;
            }
        }
        System.out.println("Min window: " + (minLen == Integer.MAX_VALUE ? "" : s7.substring(minStart, minStart + minLen))); // BANC

        // ── EXERCISE 8: Sliding window maximum (deque) ──────────
        int[] a8 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k8 = 3;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] maxW = new int[a8.length - k8 + 1];
        for (int i = 0; i < a8.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k8 + 1) deque.pollFirst();
            while (!deque.isEmpty() && a8[deque.peekLast()] < a8[i]) deque.pollLast();
            deque.addLast(i);
            if (i >= k8 - 1) maxW[i - k8 + 1] = a8[deque.peekFirst()];
        }
        System.out.println("Window max: " + Arrays.toString(maxW)); // [3,3,5,5,6,7]

        // ── EXERCISE 9: Longest subarray with ones after deleting one element
        int[] a9 = {1, 1, 0, 1};
        zeros = 0; lo = 0; maxLen = 0;
        for (int r = 0; r < a9.length; r++) {
            if (a9[r] == 0) zeros++;
            while (zeros > 1) { if (a9[lo++] == 0) zeros--; }
            maxLen = Math.max(maxLen, r - lo); // -1 for the deleted element
        }
        System.out.println("Longest after delete: " + maxLen); // 3

        // ── EXERCISE 10: Subarray product less than k ───────────
        int[] a10 = {10, 5, 2, 6};
        int kProd = 100;
        int prod = 1, count = 0;
        lo = 0;
        for (int r = 0; r < a10.length; r++) {
            prod *= a10[r];
            while (prod >= kProd && lo <= r) prod /= a10[lo++];
            count += r - lo + 1;
        }
        System.out.println("Subarrays product < 100: " + count); // 8

        // SUMMARY
        System.out.println("\n=== Sliding Window ===");
        System.out.println("Fixed:    slide k-size window, add right, remove left");
        System.out.println("Variable: expand right, shrink left when invalid");
        System.out.println("Freq map: use int[128] or HashMap for char counts");
        System.out.println("Time: O(n) — each element added/removed at most once");
    }
}
