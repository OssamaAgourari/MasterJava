package org.example.DataStructures.Queue;

import java.util.*;

/**
 * ============================================================
 *            QUEUE CHALLENGES — LeetCode Style
 * ============================================================
 */
public class QueueChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Implement Stack Using Two Queues
    // push(x), pop(), top(), empty()
    // =========================================================
    static class MyStack {
        // TODO: use two Queue<Integer>

        void push(int x) { /* TODO */ }
        int  pop()       { /* TODO */ return -1; }
        int  top()       { /* TODO */ return -1; }
        boolean empty()  { /* TODO */ return true; }
    }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Number of Recent Calls
    // RecentCounter.ping(t): add new request at time t,
    // return count of requests in [t-3000, t].
    // =========================================================
    static class RecentCounter {
        // TODO: use a Queue

        int ping(int t) {
            // TODO
            return 0;
        }
    }

    // =========================================================
    // CHALLENGE 3  [MEDIUM]  — Sliding Window Maximum
    // Return max of each window of size k.
    // Example: [1,3,-1,-3,5,3,6,7], k=3 → [3,3,5,5,6,7]
    // Hint: monotonic deque — O(n)
    // =========================================================
    static int[] maxSlidingWindow(int[] nums, int k) {
        // TODO
        return new int[0];
    }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Task Scheduler
    // Given tasks char array and cooldown n, return minimum
    // intervals to execute all tasks (can insert idles).
    // Example: tasks=['A','A','A','B','B','B'], n=2 → 8
    // =========================================================
    static int leastInterval(char[] tasks, int n) {
        // TODO
        return 0;
    }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Design Circular Queue
    // enQueue(val), deQueue(), Front(), Rear(), isEmpty(), isFull()
    // =========================================================
    static class MyCircularQueue {
        // TODO

        MyCircularQueue(int k) { /* TODO */ }
        boolean enQueue(int val) { /* TODO */ return false; }
        boolean deQueue()        { /* TODO */ return false; }
        int     Front()          { /* TODO */ return -1; }
        int     Rear()           { /* TODO */ return -1; }
        boolean isEmpty()        { /* TODO */ return true; }
        boolean isFull()         { /* TODO */ return false; }
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Walls and Gates (BFS multi-source)
    // Fill each empty room (-1 == INF) with distance to nearest gate (0).
    // Walls = -2, Gates = 0, Rooms = Integer.MAX_VALUE
    // =========================================================
    static final int INF = Integer.MAX_VALUE;
    static void wallsAndGates(int[][] rooms) {
        // TODO: multi-source BFS from all gates simultaneously
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Rotting Oranges
    // Grid: 0=empty, 1=fresh, 2=rotten. Each minute rotten spreads.
    // Return min minutes until no fresh remains, or -1 if impossible.
    // Example: [[2,1,1],[1,1,0],[0,1,1]] → 4
    // =========================================================
    static int orangesRotting(int[][] grid) {
        // TODO: multi-source BFS
        return 0;
    }

    // =========================================================
    // CHALLENGE 8  [HARD]  — Find Median from Data Stream
    // MedianFinder: addNum(int), findMedian() → double
    // Hint: two heaps — max-heap for lower half, min-heap for upper
    // =========================================================
    static class MedianFinder {
        // TODO: declare two PriorityQueues

        void addNum(int num) { /* TODO */ }

        double findMedian() {
            // TODO
            return 0.0;
        }
    }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Jump Game VI
    // You start at index 0 in array nums. You can jump at most k
    // steps forward. Your score = sum of all visited elements.
    // Return max score. O(n) with monotonic deque.
    // Example: nums=[-1,-2,0,-1,-3], k=4 → 0  → [0,-2,0] = -2?
    //          nums=[1,-1,-2,4,-7,3], k=2 → 7  → [1,4,3]
    // =========================================================
    static int maxResult(int[] nums, int k) {
        // TODO
        return 0;
    }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Course Schedule (BFS / Topological Sort)
    // numCourses, prerequisites pairs. Return true if can finish all.
    // Hint: Kahn's algorithm with in-degree queue
    // Example: n=2, [[1,0]] → true   (take 0 then 1)
    //          n=2, [[1,0],[0,1]] → false (cycle)
    // =========================================================
    static boolean canFinish(int numCourses, int[][] prerequisites) {
        // TODO
        return false;
    }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // C1 MyStack
        MyStack ms = new MyStack();
        ms.push(1); ms.push(2); ms.push(3);
        pass += check("C1a", ms.top(),  3) ? 1:0; fail += check("C1a", ms.top(),  3) ? 0:1;
        pass += check("C1b", ms.pop(),  3) ? 1:0; fail += check("C1b", ms.pop(),  3) ? 0:1;
        pass += check("C1c", ms.top(),  2) ? 1:0; fail += check("C1c", ms.top(),  2) ? 0:1;

        // C2 RecentCounter
        RecentCounter rc = new RecentCounter();
        pass += check("C2a", rc.ping(1),    1) ? 1:0; fail += check("C2a", rc.ping(1),    1) ? 0:1;
        pass += check("C2b", rc.ping(100),  2) ? 1:0; fail += check("C2b", rc.ping(100),  2) ? 0:1;
        pass += check("C2c", rc.ping(3001), 3) ? 1:0; fail += check("C2c", rc.ping(3001), 3) ? 0:1;
        pass += check("C2d", rc.ping(3002), 3) ? 1:0; fail += check("C2d", rc.ping(3002), 3) ? 0:1;

        // C3 sliding window max
        pass += checkArr("C3a", maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3),
                new int[]{3,3,5,5,6,7}) ? 1:0;
        fail += checkArr("C3a", maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3),
                new int[]{3,3,5,5,6,7}) ? 0:1;

        // C4 task scheduler
        pass += check("C4a", leastInterval(new char[]{'A','A','A','B','B','B'}, 2), 8) ? 1:0;
        fail += check("C4a", leastInterval(new char[]{'A','A','A','B','B','B'}, 2), 8) ? 0:1;

        // C5 circular queue
        MyCircularQueue cq = new MyCircularQueue(3);
        pass += check("C5a", cq.enQueue(1), true)  ? 1:0; fail += check("C5a", cq.enQueue(1), true)  ? 0:1;
        cq.enQueue(2); cq.enQueue(3);
        pass += check("C5b", cq.isFull(),   true)  ? 1:0; fail += check("C5b", cq.isFull(),   true)  ? 0:1;
        pass += check("C5c", cq.Rear(),     3)     ? 1:0; fail += check("C5c", cq.Rear(),     3)     ? 0:1;
        cq.deQueue();
        pass += check("C5d", cq.enQueue(4), true)  ? 1:0; fail += check("C5d", cq.enQueue(4), true)  ? 0:1;
        pass += check("C5e", cq.Rear(),     4)     ? 1:0; fail += check("C5e", cq.Rear(),     4)     ? 0:1;

        // C7 rotting oranges
        pass += check("C7a", orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}), 4) ? 1:0;
        fail += check("C7a", orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}), 4) ? 0:1;
        pass += check("C7b", orangesRotting(new int[][]{{0,2}}), 0) ? 1:0;
        fail += check("C7b", orangesRotting(new int[][]{{0,2}}), 0) ? 0:1;

        // C8 median finder
        MedianFinder mf = new MedianFinder();
        mf.addNum(1); mf.addNum(2);
        pass += check("C8a", mf.findMedian(), 1.5) ? 1:0; fail += check("C8a", mf.findMedian(), 1.5) ? 0:1;
        mf.addNum(3);
        pass += check("C8b", mf.findMedian(), 2.0) ? 1:0; fail += check("C8b", mf.findMedian(), 2.0) ? 0:1;

        // C9 jump game VI
        pass += check("C9a", maxResult(new int[]{1,-1,-2,4,-7,3}, 2), 7) ? 1:0;
        fail += check("C9a", maxResult(new int[]{1,-1,-2,4,-7,3}, 2), 7) ? 0:1;

        // C10 course schedule
        pass += check("C10a", canFinish(2, new int[][]{{1,0}}),         true)  ? 1:0;
        fail += check("C10a", canFinish(2, new int[][]{{1,0}}),         true)  ? 0:1;
        pass += check("C10b", canFinish(2, new int[][]{{1,0},{0,1}}),   false) ? 1:0;
        fail += check("C10b", canFinish(2, new int[][]{{1,0},{0,1}}),   false) ? 0:1;

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
        boolean ok = java.util.Arrays.equals(got, exp);
        System.out.printf("%-6s %s  (exp:%s | got:%s)%n", n, ok?"✔":"✘",
                java.util.Arrays.toString(exp), java.util.Arrays.toString(got));
        return ok;
    }
}
