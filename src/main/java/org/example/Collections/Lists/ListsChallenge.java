package org.example.Collections.Lists;

import java.util.*;

/**
 * ============================================================
 *          LISTS CHALLENGES — LeetCode Style
 * ============================================================
 */
public class ListsChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Remove Duplicates from List
    // Return new list with no duplicate integers, preserving order.
    // Example: [1,2,2,3,1,4] → [1,2,3,4]
    // =========================================================
    static List<Integer> removeDuplicates(List<Integer> list) { return new ArrayList<>(); /* TODO: LinkedHashSet */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Find Second Largest
    // Return second largest unique element, or -1 if doesn't exist.
    // Example: [3,1,4,1,5,9,2,6] → 6
    // =========================================================
    static int secondLargest(List<Integer> list) { return -1; /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Rotate List Left by k
    // Example: [1,2,3,4,5], k=2 → [3,4,5,1,2]
    // =========================================================
    static List<Integer> rotateLeft(List<Integer> list, int k) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Merge Intervals (List version)
    // Merge overlapping intervals.
    // Example: [[1,3],[2,6],[8,10],[15,18]] → [[1,6],[8,10],[15,18]]
    // =========================================================
    static List<int[]> merge(List<int[]> intervals) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Spiral Order Matrix
    // Return elements of matrix in spiral order.
    // Example: [[1,2,3],[4,5,6],[7,8,9]] → [1,2,3,6,9,8,7,4,5]
    // =========================================================
    static List<Integer> spiralOrder(int[][] matrix) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Subsets
    // Return all possible subsets of a set of distinct integers.
    // Example: [1,2,3] → [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    // =========================================================
    static List<List<Integer>> subsets(int[] nums) { return new ArrayList<>(); /* TODO: backtracking */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Flatten Nested List
    // Flatten arbitrarily nested list of integers.
    // Example: [[1,[4,[6]]],[7]] → [1,4,6,7]
    // =========================================================
    @SuppressWarnings("unchecked")
    static List<Integer> flatten(Object list) {
        List<Integer> result = new ArrayList<>();
        // TODO: recursive type check
        return result;
    }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Group by Frequency
    // Group elements by their frequency, sorted by freq desc.
    // Example: [1,1,2,2,2,3] → [[2,2,2],[1,1],[3]]
    // =========================================================
    static List<List<Integer>> groupByFrequency(int[] nums) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 9  [HARD]  — LFU Cache
    // Least Frequently Used cache. On tie, remove least recently used.
    // get(key)→val or -1, put(key,val)
    // =========================================================
    static class LFUCache {
        LFUCache(int capacity) { /* TODO */ }
        int  get(int key)            { return -1; }
        void put(int key, int value) {}
    }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Sliding Window Maximum
    // For each window of size k, return the maximum element.
    // Example: [1,3,-1,-3,5,3,6,7], k=3 → [3,3,5,5,6,7]
    // =========================================================
    static int[] maxSlidingWindow(int[] nums, int k) { return new int[]{}; /* TODO: deque */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", removeDuplicates(Arrays.asList(1,2,2,3,1,4)).toString(), "[1, 2, 3, 4]") ? 1:0;
        fail += check("C1a", removeDuplicates(Arrays.asList(1,2,2,3,1,4)).toString(), "[1, 2, 3, 4]") ? 0:1;

        pass += check("C2a", secondLargest(Arrays.asList(3,1,4,1,5,9,2,6)), 6) ? 1:0;
        fail += check("C2a", secondLargest(Arrays.asList(3,1,4,1,5,9,2,6)), 6) ? 0:1;
        pass += check("C2b", secondLargest(Arrays.asList(1,1)), -1) ? 1:0;
        fail += check("C2b", secondLargest(Arrays.asList(1,1)), -1) ? 0:1;

        pass += check("C3a", rotateLeft(Arrays.asList(1,2,3,4,5), 2).toString(), "[3, 4, 5, 1, 2]") ? 1:0;
        fail += check("C3a", rotateLeft(Arrays.asList(1,2,3,4,5), 2).toString(), "[3, 4, 5, 1, 2]") ? 0:1;

        // C4: merge intervals
        List<int[]> merged = merge(Arrays.asList(new int[]{1,3}, new int[]{2,6}, new int[]{8,10}, new int[]{15,18}));
        List<String> mergedStr = new ArrayList<>();
        for (int[] iv : merged) mergedStr.add(Arrays.toString(iv));
        pass += check("C4a", mergedStr.toString(), "[[1, 6], [8, 10], [15, 18]]") ? 1:0;
        fail += check("C4a", mergedStr.toString(), "[[1, 6], [8, 10], [15, 18]]") ? 0:1;

        pass += check("C5a", spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}).toString(),
                     "[1, 2, 3, 6, 9, 8, 7, 4, 5]") ? 1:0;
        fail += check("C5a", spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}).toString(),
                     "[1, 2, 3, 6, 9, 8, 7, 4, 5]") ? 0:1;

        // C6: subsets count
        pass += check("C6a", subsets(new int[]{1,2,3}).size(), 8) ? 1:0;
        fail += check("C6a", subsets(new int[]{1,2,3}).size(), 8) ? 0:1;

        // C9: LFU
        LFUCache lfu = new LFUCache(2);
        lfu.put(1,1); lfu.put(2,2);
        pass += check("C9a", lfu.get(1), 1) ? 1:0; fail += check("C9a", lfu.get(1), 1) ? 0:1;
        lfu.put(3,3); // evict key 2 (freq 1 < key1's freq 2)
        pass += check("C9b", lfu.get(2), -1) ? 1:0; fail += check("C9b", lfu.get(2), -1) ? 0:1;
        pass += check("C9c", lfu.get(3),  3) ? 1:0; fail += check("C9c", lfu.get(3),  3) ? 0:1;

        pass += check("C10a", Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)),
                     "[3, 3, 5, 5, 6, 7]") ? 1:0;
        fail += check("C10a", Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)),
                     "[3, 3, 5, 5, 6, 7]") ? 0:1;

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
