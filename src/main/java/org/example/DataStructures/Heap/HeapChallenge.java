package org.example.DataStructures.Heap;

import java.util.*;

/**
 * ============================================================
 *            HEAP CHALLENGES — LeetCode Style
 * ============================================================
 */
public class HeapChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Kth Largest Element in Array
    // Example: [3,2,1,5,6,4], k=2 → 5
    // Hint: maintain a min-heap of size k
    // =========================================================
    static int findKthLargest(int[] nums, int k) {
        // TODO
        return -1;
    }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Last Stone Weight
    // Smash the two heaviest stones. If equal, both destroyed.
    // Else heavier survives with (y-x) weight. Return last stone or 0.
    // Example: [2,7,4,1,8,1] → 1
    // =========================================================
    static int lastStoneWeight(int[] stones) {
        // TODO
        return 0;
    }

    // =========================================================
    // CHALLENGE 3  [EASY]  — K Closest Points to Origin
    // Return k points closest to (0,0) by Euclidean distance.
    // Example: [[1,3],[-2,2]], k=1 → [[-2,2]]
    // =========================================================
    static int[][] kClosest(int[][] points, int k) {
        // TODO
        return new int[0][];
    }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Top K Frequent Elements
    // Return k most frequent elements.
    // Example: [1,1,1,2,2,3], k=2 → [1,2]
    // =========================================================
    static int[] topKFrequent(int[] nums, int k) {
        // TODO
        return new int[0];
    }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Kth Smallest Element in Sorted Matrix
    // Matrix rows and columns are sorted. Find kth smallest.
    // Example: matrix=[[1,5,9],[10,11,13],[12,13,15]], k=8 → 13
    // =========================================================
    static int kthSmallest(int[][] matrix, int k) {
        // TODO
        return -1;
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Merge K Sorted Lists
    // Example: [[1,4,5],[1,3,4],[2,6]] → [1,1,2,3,4,4,5,6]
    // =========================================================
    static class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v,ListNode n){val=v;next=n;} }

    static ListNode mergeKLists(ListNode[] lists) {
        // TODO
        return null;
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Find Median from Data Stream
    // addNum(int), findMedian() → double
    // =========================================================
    static class MedianFinder {
        // TODO: two heaps

        void addNum(int num) { /* TODO */ }
        double findMedian()  { /* TODO */ return 0.0; }
    }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Task Scheduler
    // Same as Queue challenge — tasks with cooldown n.
    // Example: ['A','A','A','B','B','B'], n=2 → 8
    // =========================================================
    static int leastInterval(char[] tasks, int n) {
        // TODO
        return 0;
    }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Smallest Range Covering Elements
    // from K lists. Find range [a,b] such that at least one
    // element from each list falls in [a,b], minimise b-a.
    // Example: [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]] → [20,24]
    // =========================================================
    static int[] smallestRange(List<List<Integer>> nums) {
        // TODO
        return new int[]{0,0};
    }

    // =========================================================
    // CHALLENGE 10  [HARD]  — IPO (Maximise Capital)
    // Given k projects with (profits[], capital[]), start with
    // w capital. Pick at most k projects to max final capital.
    // =========================================================
    static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // TODO
        return 0;
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

        int[][] kc = kClosest(new int[][]{{1,3},{-2,2}}, 1);
        pass += check("C3a", kc.length==1 && kc[0][0]==-2 && kc[0][1]==2, true) ? 1:0;
        fail += check("C3a", kc.length==1 && kc[0][0]==-2 && kc[0][1]==2, true) ? 0:1;

        int[] tf = topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        Arrays.sort(tf);
        pass += check("C4a", Arrays.toString(tf), "[1, 2]") ? 1:0;
        fail += check("C4a", Arrays.toString(tf), "[1, 2]") ? 0:1;

        pass += check("C5a", kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8), 13) ? 1:0;
        fail += check("C5a", kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8), 13) ? 0:1;

        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        ListNode merged = mergeKLists(new ListNode[]{l1,l2,l3});
        pass += check("C6a", listStr(merged), "[1,1,2,3,4,4,5,6]") ? 1:0;
        fail += check("C6a", listStr(merged), "[1,1,2,3,4,4,5,6]") ? 0:1;

        MedianFinder mf = new MedianFinder();
        mf.addNum(1); mf.addNum(2);
        pass += check("C7a", mf.findMedian(), 1.5) ? 1:0; fail += check("C7a", mf.findMedian(), 1.5) ? 0:1;
        mf.addNum(3);
        pass += check("C7b", mf.findMedian(), 2.0) ? 1:0; fail += check("C7b", mf.findMedian(), 2.0) ? 0:1;

        pass += check("C8a", leastInterval(new char[]{'A','A','A','B','B','B'}, 2), 8) ? 1:0;
        fail += check("C8a", leastInterval(new char[]{'A','A','A','B','B','B'}, 2), 8) ? 0:1;

        pass += check("C10a", findMaximizedCapital(2, 0, new int[]{1,2,3}, new int[]{0,1,1}), 3) ? 1:0;
        fail += check("C10a", findMaximizedCapital(2, 0, new int[]{1,2,3}, new int[]{0,1,1}), 3) ? 0:1;

        System.out.println("\n==============================");
        System.out.println("  RESULTS: " + pass + " passed, " + fail + " failed");
        System.out.println("==============================");
    }

    static String listStr(ListNode h) {
        StringBuilder sb = new StringBuilder("[");
        while (h!=null){sb.append(h.val);if(h.next!=null)sb.append(",");h=h.next;}
        return sb.append("]").toString();
    }
    private static boolean check(String n, Object got, Object exp) {
        boolean ok = String.valueOf(got).equals(String.valueOf(exp));
        System.out.printf("%-6s %s  (exp:%s | got:%s)%n", n, ok?"✔":"✘", exp, got);
        return ok;
    }
}
