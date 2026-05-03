package org.example.Collections.Queues;

import java.util.*;

/**
 * ============================================================
 *           JAVA QUEUES — COMPLETE GUIDE
 * ============================================================
 *
 * Queue: FIFO (First In, First Out) data structure.
 *
 * MAIN IMPLEMENTATIONS:
 * ┌──────────────────┬───────────────────────────────────────────────┐
 * │  LinkedList      │ Queue + Deque — general purpose               │
 * │  ArrayDeque      │ Resizable array — fast, no null allowed       │
 * │  PriorityQueue   │ Min-heap — O(log n) add/remove, O(1) peek     │
 * │  BlockingQueue   │ Thread-safe (LinkedBlockingQueue, etc.)       │
 * └──────────────────┴───────────────────────────────────────────────┘
 *
 * QUEUE vs DEQUE:
 * ---------------
 *   Queue  → add/offer (tail), remove/poll (head), peek/element (head)
 *   Deque  → addFirst/addLast, removeFirst/removeLast, peekFirst/peekLast
 *
 * THROWS vs RETURNS:
 * ------------------
 *   Method      Throws exception   Returns special value
 *   Insert:     add()              offer()
 *   Remove:     remove()           poll()
 *   Examine:    element()          peek()
 *
 * PRIORITY QUEUE:
 * ---------------
 *   Natural order: min-heap (smallest first)
 *   Custom order:  PriorityQueue<>(Comparator.reverseOrder()) → max-heap
 *   Useful for: Dijkstra, top-K, scheduling, Huffman
 *
 * ============================================================
 */
public class Queues {

    // ── 1. Queue basics (FIFO) ────────────────────────────────
    static void queueBasics() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Alice");
        queue.offer("Bob");
        queue.offer("Carol");

        System.out.println("Queue: " + queue);
        System.out.println("peek: " + queue.peek());   // Alice (no remove)
        System.out.println("poll: " + queue.poll());   // Alice (removes)
        System.out.println("Queue: " + queue);          // [Bob, Carol]
        System.out.println("size: " + queue.size());    // 2
    }

    // ── 2. Deque as Stack and Queue ───────────────────────────
    static void dequeDemo() {
        Deque<Integer> deque = new ArrayDeque<>();

        // As Stack (LIFO)
        deque.push(1); // addFirst
        deque.push(2);
        deque.push(3);
        System.out.println("Stack (push 1,2,3): " + deque); // [3,2,1]
        System.out.println("pop: " + deque.pop()); // 3

        // As Queue (FIFO)
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(1);
        q.offerLast(2);
        q.offerLast(3);
        System.out.println("Queue: " + q);
        System.out.println("pollFirst: " + q.pollFirst()); // 1
    }

    // ── 3. PriorityQueue (min-heap) ───────────────────────────
    static void minHeapDemo() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(5); pq.offer(1); pq.offer(3); pq.offer(2); pq.offer(4);

        System.out.print("Poll min order: ");
        while (!pq.isEmpty()) System.out.print(pq.poll() + " "); // 1 2 3 4 5
        System.out.println();
    }

    // ── 4. Max-heap with custom Comparator ────────────────────
    static void maxHeapDemo() {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        maxPQ.offer(5); maxPQ.offer(1); maxPQ.offer(3);

        System.out.print("Poll max order: ");
        while (!maxPQ.isEmpty()) System.out.print(maxPQ.poll() + " "); // 5 3 1
        System.out.println();
    }

    // ── 5. Top-K elements ────────────────────────────────────
    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.merge(n, 1, Integer::sum);

        // Min-heap of size k — maintain k largest frequencies
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.offer(new int[]{e.getKey(), e.getValue()});
            if (pq.size() > k) pq.poll(); // remove smallest freq
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) result[i] = pq.poll()[0];
        return result;
    }

    // ── 6. BFS with Queue ─────────────────────────────────────
    static int shortestPath(int[][] grid, int[] start, int[] end) {
        int m = grid.length, n = grid[0].length;
        if (grid[start[0]][start[1]] == 1) return -1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == end[0] && cur[1] == end[1]) return cur[2];
            for (int[] d : dirs) {
                int nr = cur[0]+d[0], nc = cur[1]+d[1];
                if (nr>=0 && nr<m && nc>=0 && nc<n && !visited[nr][nc] && grid[nr][nc]==0) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, cur[2]+1});
                }
            }
        }
        return -1;
    }

    // ── 7. Monotonic Queue — sliding window max ───────────────
    static int[] slidingWindowMax(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // store indices

        for (int i = 0; i < n; i++) {
            // Remove elements outside window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k)
                deque.pollFirst();
            // Remove smaller elements (maintain decreasing order)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.offerLast(i);
            if (i >= k - 1) result[i - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }

    // ── 8. PriorityQueue with custom object ───────────────────
    static class Task {
        String name;
        int priority;
        Task(String name, int priority) { this.name=name; this.priority=priority; }
    }

    static void taskScheduler() {
        PriorityQueue<Task> scheduler = new PriorityQueue<>(
            (a, b) -> b.priority - a.priority // higher priority first
        );
        scheduler.offer(new Task("Low task", 1));
        scheduler.offer(new Task("Critical", 10));
        scheduler.offer(new Task("Normal", 5));

        System.out.println("Task execution order:");
        while (!scheduler.isEmpty()) {
            Task t = scheduler.poll();
            System.out.println("  [" + t.priority + "] " + t.name);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Queue Basics ===");
        queueBasics();

        System.out.println("\n=== Deque Demo ===");
        dequeDemo();

        System.out.println("\n=== Min Heap ===");
        minHeapDemo();

        System.out.println("\n=== Max Heap ===");
        maxHeapDemo();

        System.out.println("\n=== Top-K Frequent ===");
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3}, 2))); // [2,1] or [1,2]

        System.out.println("\n=== BFS Shortest Path ===");
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(shortestPath(grid, new int[]{0,0}, new int[]{2,2})); // 4

        System.out.println("\n=== Sliding Window Max ===");
        System.out.println(Arrays.toString(slidingWindowMax(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        // [3,3,5,5,6,7]

        System.out.println("\n=== Task Scheduler ===");
        taskScheduler();

        System.out.println("\n=== Queue Summary ===");
        System.out.println("LinkedList  → Queue/Deque, null allowed, slower than ArrayDeque");
        System.out.println("ArrayDeque  → faster stack/queue, no null");
        System.out.println("PriorityQueue → heap, not FIFO, O(log n) add/remove");
        System.out.println("Use ArrayDeque as default stack/queue");
    }
}
