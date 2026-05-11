package org.example.Algorithms.Sorting.HeapSort;

import java.util.*;

/**
 * ============================================================
 *         HEAP SORT CHALLENGES — LeetCode Style
 * ============================================================
 */
public class HeapSortChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Kth Largest Element in Array
    // Return kth largest element.
    // Example: [3,2,1,5,6,4], k=2 → 5
    // =========================================================
    static int findKthLargest(int[] nums, int k) { return 0; /* TODO: min-heap of size k */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Last Stone Weight
    // Repeatedly smash two heaviest stones.
    // Example: [2,7,4,1,8,1] → 1
    // =========================================================
    static int lastStoneWeight(int[] stones) { return 0; /* TODO: max-heap */ }

    // =========================================================
    // CHALLENGE 3  [MEDIUM]  — K Closest Points to Origin
    // Return k closest points to (0,0).
    // Example: [[1,3],[-2,2]], k=1 → [[-2,2]]
    // =========================================================
    static int[][] kClosest(int[][] points, int k) { return new int[0][]; /* TODO: heap */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Sort Characters By Frequency
    // Sort in decreasing order of frequency.
    // Example: "tree" → "eert" or "eetr"
    // =========================================================
    static String frequencySort(String s) { return ""; /* TODO */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Top K Frequent Elements
    // Return k most frequent elements.
    // Example: [1,1,1,2,2,3], k=2 → [1,2]
    // =========================================================
    static int[] topKFrequent(int[] nums, int k) { return new int[0]; /* TODO */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Find K Pairs with Smallest Sums
    // pairs from nums1[i]+nums2[j], find k smallest pairs.
    // Example: nums1=[1,7,11], nums2=[2,4,6], k=3 → [[1,2],[1,4],[1,6]]
    // =========================================================
    static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Task Scheduler
    // Min intervals with cooldown n between same tasks.
    // Example: ['A','A','A','B','B','B'], n=2 → 8
    // =========================================================
    static int leastInterval(char[] tasks, int n) { return 0; /* TODO: greedy or heap */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Reorganize String
    // Rearrange so no two adjacent characters are the same.
    // Return "" if not possible.
    // Example: "aab" → "aba"
    // =========================================================
    static String reorganizeString(String s) { return ""; /* TODO: max-heap by frequency */ }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Merge K Sorted Lists
    // Merge k sorted linked lists into one.
    // Example: [[1,4,5],[1,3,4],[2,6]] → [1,1,2,3,4,4,5,6]
    // =========================================================
    static ListNode mergeKLists(ListNode[] lists) { return null; /* TODO: min-heap */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Find Median from Data Stream
    // Support addNum and findMedian operations.
    // Example: add 1,2,3 → median=2.0
    // =========================================================
    static class MedianFinder {
        /* TODO: two heaps — max-heap for lower half, min-heap for upper half */
        MedianFinder() {}
        void addNum(int num) {}
        double findMedian() { return 0.0; }
    }

    static class ListNode {
        int val; ListNode next;
        ListNode(int v) { val = v; }
    }
    static ListNode makeList(int... v) {
        ListNode d=new ListNode(0),c=d; for(int x:v){c.next=new ListNode(x);c=c.next;} return d.next;
    }
    static String listStr(ListNode h) {
        StringBuilder sb=new StringBuilder("["); while(h!=null){sb.append(h.val);if(h.next!=null)sb.append(",");h=h.next;} return sb.append("]").toString();
    }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", findKthLargest(new int[]{3,2,1,5,6,4}, 2), 5) ? 1:0;
        fail += check("C1a", findKthLargest(new int[]{3,2,1,5,6,4}, 2), 5) ? 0:1;
        pass += check("C1b", findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4), 4) ? 1:0;
        fail += check("C1b", findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4), 4) ? 0:1;

        pass += check("C2a", lastStoneWeight(new int[]{2,7,4,1,8,1}), 1) ? 1:0;
        fail += check("C2a", lastStoneWeight(new int[]{2,7,4,1,8,1}), 1) ? 0:1;

        pass += check("C3a", kClosest(new int[][]{{1,3},{-2,2}}, 1).length, 1) ? 1:0;
        fail += check("C3a", kClosest(new int[][]{{1,3},{-2,2}}, 1).length, 1) ? 0:1;

        pass += check("C5a", Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3},2)), "[1, 2]") ? 1:0;
        fail += check("C5a", Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3},2)), "[1, 2]") ? 0:1;

        pass += check("C7a", leastInterval(new char[]{'A','A','A','B','B','B'}, 2), 8) ? 1:0;
        fail += check("C7a", leastInterval(new char[]{'A','A','A','B','B','B'}, 2), 8) ? 0:1;

        pass += check("C8a", reorganizeString("aab"), "aba") ? 1:0;
        fail += check("C8a", reorganizeString("aab"), "aba") ? 0:1;
        pass += check("C8b", reorganizeString("aaab"), "") ? 1:0;
        fail += check("C8b", reorganizeString("aaab"), "") ? 0:1;

        ListNode[] kl = {makeList(1,4,5), makeList(1,3,4), makeList(2,6)};
        pass += check("C9a", listStr(mergeKLists(kl)), "[1,1,2,3,4,4,5,6]") ? 1:0;
        fail += check("C9a", listStr(mergeKLists(kl)), "[1,1,2,3,4,4,5,6]") ? 0:1;

        MedianFinder mf = new MedianFinder();
        mf.addNum(1); mf.addNum(2); mf.addNum(3);
        pass += check("C10a", mf.findMedian(), 2.0) ? 1:0;
        fail += check("C10a", mf.findMedian(), 2.0) ? 0:1;
        mf.addNum(4);
        pass += check("C10b", mf.findMedian(), 2.5) ? 1:0;
        fail += check("C10b", mf.findMedian(), 2.5) ? 0:1;

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
