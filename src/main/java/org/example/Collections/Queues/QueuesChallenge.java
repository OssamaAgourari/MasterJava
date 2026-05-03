package org.example.Collections.Queues;

import java.util.*;

/**
 * ============================================================
 *          QUEUES CHALLENGES — LeetCode Style
 * ============================================================
 */
public class QueuesChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Implement Stack Using Queues
    // push, pop, top, empty — using only Queue operations.
    // =========================================================
    static class MyStack {
        /* TODO: two queues or rotate one queue */
        MyStack() {}
        void push(int x) {}
        int  pop()  { return 0; }
        int  top()  { return 0; }
        boolean empty() { return true; }
    }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Implement Queue Using Stacks
    // push, pop, peek, empty — using only Stack operations.
    // =========================================================
    static class MyQueue {
        /* TODO: two stacks */
        MyQueue() {}
        void push(int x) {}
        int  pop()  { return 0; }
        int  peek() { return 0; }
        boolean empty() { return true; }
    }

    // =========================================================
    // CHALLENGE 3  [MEDIUM]  — Number of Recent Calls
    // RecentCounter.ping(t): return # calls in [t-3000, t].
    // =========================================================
    static class RecentCounter {
        /* TODO: Queue/deque */
        RecentCounter() {}
        int ping(int t) { return 0; }
    }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Task Scheduler
    // Given tasks and cooldown n, find min time to finish all.
    // Example: ["A","A","A","B","B","B"], n=2 → 8
    // =========================================================
    static int leastInterval(char[] tasks, int n) { return 0; /* TODO: greedy + PQ */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Find K Pairs with Smallest Sums
    // Two sorted arrays. Find k pairs with smallest sums.
    // Example: [1,7,11],[2,4,6],k=3 → [[1,2],[1,4],[1,6]]
    // =========================================================
    static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        return new ArrayList<>(); /* TODO: min heap */
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Kth Largest Element in a Stream
    // Design a class that finds kth largest in a stream.
    // =========================================================
    static class KthLargest {
        /* TODO: min heap of size k */
        KthLargest(int k, int[] nums) {}
        int add(int val) { return 0; }
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Reorganize String
    // Rearrange so no two adjacent chars are same. "" if impossible.
    // Example: "aab" → "aba"
    // =========================================================
    static String reorganizeString(String s) { return ""; /* TODO: max heap */ }

    // =========================================================
    // CHALLENGE 8  [HARD]  — Merge K Sorted Lists
    // Merge k sorted linked lists. Return merged sorted list.
    // =========================================================
    static class ListNode {
        int val; ListNode next;
        ListNode(int val) { this.val = val; }
    }

    static ListNode mergeKLists(ListNode[] lists) { return null; /* TODO: min heap */ }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Find Median from Data Stream
    // addNum(int), findMedian() — two heaps.
    // =========================================================
    static class MedianFinder {
        /* TODO: max heap (left) + min heap (right) */
        MedianFinder() {}
        void addNum(int num) {}
        double findMedian() { return 0.0; }
    }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Sliding Window Maximum
    // For each window of size k, return maximum. O(n).
    // Example: [1,3,-1,-3,5,3,6,7], k=3 → [3,3,5,5,6,7]
    // =========================================================
    static int[] maxSlidingWindow(int[] nums, int k) { return new int[]{}; /* TODO: monotonic deque */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // C1: Stack using queues
        MyStack st = new MyStack();
        st.push(1); st.push(2);
        pass += check("C1a", st.top(),  2) ? 1:0; fail += check("C1a", st.top(),  2) ? 0:1;
        pass += check("C1b", st.pop(),  2) ? 1:0; fail += check("C1b", st.pop(),  2) ? 0:1;
        pass += check("C1c", st.empty(), false) ? 1:0; fail += check("C1c", st.empty(), false) ? 0:1;

        // C2: Queue using stacks
        MyQueue mq = new MyQueue();
        mq.push(1); mq.push(2);
        pass += check("C2a", mq.peek(), 1) ? 1:0; fail += check("C2a", mq.peek(), 1) ? 0:1;
        pass += check("C2b", mq.pop(),  1) ? 1:0; fail += check("C2b", mq.pop(),  1) ? 0:1;
        pass += check("C2c", mq.empty(), false) ? 1:0; fail += check("C2c", mq.empty(), false) ? 0:1;

        // C3: Recent calls
        RecentCounter rc = new RecentCounter();
        pass += check("C3a", rc.ping(1),    1) ? 1:0; fail += check("C3a", rc.ping(1),    1) ? 0:1;
        pass += check("C3b", rc.ping(100),  2) ? 1:0; fail += check("C3b", rc.ping(100),  2) ? 0:1;
        pass += check("C3c", rc.ping(3001), 3) ? 1:0; fail += check("C3c", rc.ping(3001), 3) ? 0:1;
        pass += check("C3d", rc.ping(3002), 3) ? 1:0; fail += check("C3d", rc.ping(3002), 3) ? 0:1;

        // C4: Task scheduler
        pass += check("C4a", leastInterval(new char[]{'A','A','A','B','B','B'}, 2), 8) ? 1:0;
        fail += check("C4a", leastInterval(new char[]{'A','A','A','B','B','B'}, 2), 8) ? 0:1;

        // C6: KthLargest
        KthLargest kth = new KthLargest(3, new int[]{4,5,8,2});
        pass += check("C6a", kth.add(3),  4) ? 1:0; fail += check("C6a", kth.add(3),  4) ? 0:1;
        pass += check("C6b", kth.add(5),  5) ? 1:0; fail += check("C6b", kth.add(5),  5) ? 0:1;
        pass += check("C6c", kth.add(10), 5) ? 1:0; fail += check("C6c", kth.add(10), 5) ? 0:1;

        // C7: Reorganize string
        pass += check("C7a", reorganizeString("aab"), "aba") ? 1:0;
        fail += check("C7a", reorganizeString("aab"), "aba") ? 0:1;
        pass += check("C7b", reorganizeString("aaab"), "") ? 1:0;
        fail += check("C7b", reorganizeString("aaab"), "") ? 0:1;

        // C9: Median
        MedianFinder mf = new MedianFinder();
        mf.addNum(1); mf.addNum(2);
        pass += check("C9a", mf.findMedian(), 1.5) ? 1:0; fail += check("C9a", mf.findMedian(), 1.5) ? 0:1;
        mf.addNum(3);
        pass += check("C9b", mf.findMedian(), 2.0) ? 1:0; fail += check("C9b", mf.findMedian(), 2.0) ? 0:1;

        // C10: Sliding window max
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
