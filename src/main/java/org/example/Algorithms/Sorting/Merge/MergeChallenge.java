package org.example.Algorithms.Sorting.Merge;

import java.util.*;

/**
 * ============================================================
 *        MERGE SORT CHALLENGES — LeetCode Style
 * ============================================================
 */
public class MergeChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Merge Two Sorted Arrays
    // Merge two sorted arrays into one sorted array.
    // Example: [1,3,5], [2,4,6] → [1,2,3,4,5,6]
    // =========================================================
    static int[] mergeSorted(int[] a, int[] b) { return new int[0]; /* TODO */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Merge Sorted Array (in-place)
    // Merge nums2 into nums1 (has m+n space). m,n = valid lengths.
    // Example: [1,2,3,0,0,0] m=3, [2,5,6] n=3 → [1,2,2,3,5,6]
    // =========================================================
    static void merge(int[] nums1, int m, int[] nums2, int n) { /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [MEDIUM]  — Sort List (Linked List)
    // Sort linked list using O(n log n) time, O(1) space.
    // Example: 4→2→1→3 → 1→2→3→4
    // =========================================================
    static ListNode sortList(ListNode head) { return null; /* TODO: merge sort on linked list */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Count of Range Sum
    // Count range sums that lie in [lower, upper].
    // Example: [-2,5,-1], lower=-2, upper=2 → 3
    // =========================================================
    static int countRangeSum(int[] nums, int lower, int upper) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Merge Intervals
    // Merge all overlapping intervals.
    // Example: [[1,3],[2,6],[8,10],[15,18]] → [[1,6],[8,10],[15,18]]
    // =========================================================
    static int[][] mergeIntervals(int[][] intervals) { return new int[0][]; /* TODO */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Sort Characters By Frequency
    // Sort in decreasing order of frequency.
    // Example: "tree" → "eert" or "eetr"
    // =========================================================
    static String frequencySort(String s) { return ""; /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Kth Largest Element
    // Return kth largest without full sort. O(n log n).
    // Example: [3,2,1,5,6,4], k=2 → 5
    // =========================================================
    static int findKthLargest(int[] nums, int k) { return 0; /* TODO: sort and index */ }

    // =========================================================
    // CHALLENGE 8  [HARD]  — Count of Smaller Numbers After Self
    // For each element, count how many smaller elements are to its right.
    // Example: [5,2,6,1] → [2,1,1,0]
    // =========================================================
    static List<Integer> countSmaller(int[] nums) { return new ArrayList<>(); /* TODO: merge sort */ }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Reverse Pairs
    // Count pairs (i,j) where i<j and nums[i] > 2*nums[j].
    // Example: [1,3,2,3,1] → 2
    // =========================================================
    static int reversePairs(int[] nums) { return 0; /* TODO: modified merge sort */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Merge K Sorted Lists
    // Merge k sorted linked lists into one sorted list.
    // Example: [[1,4,5],[1,3,4],[2,6]] → [1,1,2,3,4,4,5,6]
    // =========================================================
    static ListNode mergeKLists(ListNode[] lists) { return null; /* TODO: divide & conquer */ }

    // Helper Node class
    static class ListNode {
        int val; ListNode next;
        ListNode(int v) { val = v; }
        ListNode(int v, ListNode n) { val = v; next = n; }
    }

    static ListNode makeList(int... vals) {
        ListNode dummy = new ListNode(0), cur = dummy;
        for (int v : vals) { cur.next = new ListNode(v); cur = cur.next; }
        return dummy.next;
    }
    static String listToStr(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) { sb.append(head.val); if(head.next!=null)sb.append(","); head=head.next; }
        return sb.append("]").toString();
    }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", Arrays.toString(mergeSorted(new int[]{1,3,5}, new int[]{2,4,6})), "[1, 2, 3, 4, 5, 6]") ? 1:0;
        fail += check("C1a", Arrays.toString(mergeSorted(new int[]{1,3,5}, new int[]{2,4,6})), "[1, 2, 3, 4, 5, 6]") ? 0:1;

        int[] m1 = {1,2,3,0,0,0}; merge(m1, 3, new int[]{2,5,6}, 3);
        pass += check("C2a", Arrays.toString(m1), "[1, 2, 2, 3, 5, 6]") ? 1:0;
        fail += check("C2a", Arrays.toString(m1), "[1, 2, 2, 3, 5, 6]") ? 0:1;

        pass += check("C3a", listToStr(sortList(makeList(4,2,1,3))), "[1,2,3,4]") ? 1:0;
        fail += check("C3a", listToStr(sortList(makeList(4,2,1,3))), "[1,2,3,4]") ? 0:1;

        pass += check("C5a", Arrays.deepToString(mergeIntervals(new int[][]{{1,3},{2,6},{8,10},{15,18}})),
                "[[1, 6], [8, 10], [15, 18]]") ? 1:0;
        fail += check("C5a", Arrays.deepToString(mergeIntervals(new int[][]{{1,3},{2,6},{8,10},{15,18}})),
                "[[1, 6], [8, 10], [15, 18]]") ? 0:1;

        pass += check("C7a", findKthLargest(new int[]{3,2,1,5,6,4}, 2), 5) ? 1:0;
        fail += check("C7a", findKthLargest(new int[]{3,2,1,5,6,4}, 2), 5) ? 0:1;

        pass += check("C8a", countSmaller(new int[]{5,2,6,1}).toString(), "[2, 1, 1, 0]") ? 1:0;
        fail += check("C8a", countSmaller(new int[]{5,2,6,1}).toString(), "[2, 1, 1, 0]") ? 0:1;

        pass += check("C9a", reversePairs(new int[]{1,3,2,3,1}), 2) ? 1:0;
        fail += check("C9a", reversePairs(new int[]{1,3,2,3,1}), 2) ? 0:1;

        ListNode[] kLists = {makeList(1,4,5), makeList(1,3,4), makeList(2,6)};
        pass += check("C10a", listToStr(mergeKLists(kLists)), "[1,1,2,3,4,4,5,6]") ? 1:0;
        fail += check("C10a", listToStr(mergeKLists(kLists)), "[1,1,2,3,4,4,5,6]") ? 0:1;

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
