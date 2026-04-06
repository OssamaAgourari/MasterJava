package org.example.DataStructures.Queue;

/**
 * ============================================================
 *                  QUEUE — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS A QUEUE?
 * -----------------
 * A FIFO (First In, First Out) structure. Elements are enqueued
 * at the REAR and dequeued from the FRONT.
 *
 *   enqueue(1) enqueue(2) enqueue(3)
 *   front → [1, 2, 3] ← rear
 *   dequeue() → 1  (not 3!)
 *
 * QUEUE VARIANTS:
 * ----------------
 *   Simple Queue    — FIFO, enqueue at rear, dequeue at front
 *   Circular Queue  — uses array circularly, avoids wasted space
 *   Deque           — double-ended: add/remove from BOTH ends
 *   Priority Queue  — dequeue by priority (min or max), not arrival
 *
 * TIME COMPLEXITY:
 * -----------------
 *   Operation      | Queue  | Deque  | PriorityQueue
 *   ---------------|--------|--------|---------------
 *   enqueue/offer  | O(1)   | O(1)   | O(log n)
 *   dequeue/poll   | O(1)   | O(1)   | O(log n)
 *   peek           | O(1)   | O(1)   | O(1)
 *   search         | O(n)   | O(n)   | O(n)
 *
 * JAVA BUILT-INS:
 * ----------------
 *   Queue<E>         → interface
 *   LinkedList<E>    → implements Queue (linked-list-based)
 *   ArrayDeque<E>    → implements Deque, faster than LinkedList
 *   PriorityQueue<E> → min-heap by default
 *
 *   Queue<Integer> q = new ArrayDeque<>();
 *   q.offer(x)  → enqueue (returns false if full, never throws)
 *   q.poll()    → dequeue (returns null if empty, never throws)
 *   q.peek()    → front   (returns null if empty)
 *   q.add(x)    → enqueue (throws if full)
 *   q.remove()  → dequeue (throws if empty)
 *
 * WHEN TO USE:
 * -------------
 *   ✔ BFS (Breadth-First Search) — level-order traversal
 *   ✔ Task scheduling / job queues
 *   ✔ Print queue, CPU scheduling
 *   ✔ Sliding window maximum (monotonic deque)
 *   ✔ Stream processing (fixed-size window)
 *
 * ============================================================
 */
public class Queue {

    // ─── Circular Array Queue ─────────────────────────────────
    static class CircularQueue {
        private int[] data;
        private int   front, rear, size, capacity;

        CircularQueue(int capacity) {
            this.capacity = capacity;
            data = new int[capacity];
        }

        void enqueue(int val) {
            if (isFull()) throw new RuntimeException("Queue full");
            data[rear] = val;
            rear = (rear + 1) % capacity;
            size++;
        }

        int dequeue() {
            if (isEmpty()) throw new RuntimeException("Queue empty");
            int val = data[front];
            front = (front + 1) % capacity;
            size--;
            return val;
        }

        int peek()      { if (isEmpty()) throw new RuntimeException(); return data[front]; }
        boolean isEmpty() { return size == 0; }
        boolean isFull()  { return size == capacity; }
        int     size()    { return size; }

        @Override public String toString() {
            if (isEmpty()) return "[]";
            StringBuilder sb = new StringBuilder("front→[");
            for (int i = 0; i < size; i++)
                sb.append(data[(front+i)%capacity]).append(i<size-1?", ":"");
            return sb.append("]←rear").toString();
        }
    }

    // ─── Linked-list Queue ────────────────────────────────────
    static class Node { int val; Node next; Node(int v){val=v;} }

    static class LinkedQueue {
        Node front, rear; int size;

        void enqueue(int val) {
            Node n = new Node(val);
            if (rear != null) rear.next = n;
            rear = n;
            if (front == null) front = n;
            size++;
        }

        int dequeue() {
            if (front == null) throw new RuntimeException("Empty");
            int val = front.val;
            front = front.next;
            if (front == null) rear = null;
            size--;
            return val;
        }

        int peek() { if (front==null) throw new RuntimeException(); return front.val; }
        boolean isEmpty() { return front == null; }
    }

    public static void main(String[] args) {

        // EXERCISE 1: Basic Queue operations
        CircularQueue q = new CircularQueue(5);
        q.enqueue(10); q.enqueue(20); q.enqueue(30);
        System.out.println("Queue:    " + q);
        System.out.println("peek():   " + q.peek());    // 10
        System.out.println("dequeue:" + q.dequeue());   // 10
        System.out.println("After:    " + q);
        System.out.println("size:     " + q.size());    // 2

        // EXERCISE 2: Circular wrapping
        CircularQueue circ = new CircularQueue(4);
        circ.enqueue(1); circ.enqueue(2); circ.enqueue(3); circ.enqueue(4);
        System.out.println("Full: " + circ.isFull()); // true
        circ.dequeue(); circ.dequeue();
        circ.enqueue(5); circ.enqueue(6); // wraps around
        System.out.println("After wrap: " + circ);

        // EXERCISE 3: BFS using Queue — level-order tree traversal
        System.out.println("\nBFS Level Order (manual tree):");
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        int[][] tree = {{1,2,3},{2,4,5},{3,-1,6}}; // not real tree, just demo
        System.out.println("Using ArrayDeque for BFS:");
        java.util.Queue<Integer> bfsQ = new java.util.ArrayDeque<>();
        bfsQ.offer(1); bfsQ.offer(2); bfsQ.offer(3);
        while (!bfsQ.isEmpty()) System.out.print(bfsQ.poll() + " ");
        System.out.println();

        // EXERCISE 4: PriorityQueue — min-heap
        java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();
        minHeap.offer(5); minHeap.offer(1); minHeap.offer(3); minHeap.offer(2);
        System.out.print("PriorityQueue (min): ");
        while (!minHeap.isEmpty()) System.out.print(minHeap.poll() + " ");
        System.out.println();

        // EXERCISE 5: PriorityQueue — max-heap
        java.util.PriorityQueue<Integer> maxHeap =
                new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
        maxHeap.offer(5); maxHeap.offer(1); maxHeap.offer(3); maxHeap.offer(2);
        System.out.print("PriorityQueue (max): ");
        while (!maxHeap.isEmpty()) System.out.print(maxHeap.poll() + " ");
        System.out.println();

        // EXERCISE 6: Deque — both ends
        java.util.Deque<Integer> deque = new java.util.ArrayDeque<>();
        deque.addFirst(2); deque.addFirst(1);  // [1, 2]
        deque.addLast(3);  deque.addLast(4);   // [1, 2, 3, 4]
        System.out.println("Deque: " + deque);
        System.out.println("peekFirst: " + deque.peekFirst()); // 1
        System.out.println("peekLast:  " + deque.peekLast());  // 4
        deque.pollFirst(); deque.pollLast();
        System.out.println("After remove both ends: " + deque); // [2, 3]

        // EXERCISE 7: Queue using two stacks (classic interview question)
        QueueWithTwoStacks qs = new QueueWithTwoStacks();
        qs.enqueue(1); qs.enqueue(2); qs.enqueue(3);
        System.out.println("Queue-via-stacks peek: " + qs.peek());    // 1
        System.out.println("Queue-via-stacks deq:  " + qs.dequeue()); // 1
        System.out.println("Queue-via-stacks deq:  " + qs.dequeue()); // 2

        // EXERCISE 8: Sliding window maximum using Deque
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] maxWindow = slidingWindowMax(arr, k);
        System.out.println("Sliding window max k=3: " + java.util.Arrays.toString(maxWindow));
        // [3, 3, 5, 5, 6, 7]

        // SUMMARY
        System.out.println("\n=== Queue Time Complexity ===");
        System.out.println("enqueue/offer  O(1)");
        System.out.println("dequeue/poll   O(1)");
        System.out.println("peek           O(1)");
        System.out.println("PriorityQueue enqueue/dequeue  O(log n)");
    }

    static class QueueWithTwoStacks {
        java.util.Deque<Integer> in = new java.util.ArrayDeque<>();
        java.util.Deque<Integer> out = new java.util.ArrayDeque<>();
        void enqueue(int v) { in.push(v); }
        int dequeue() { if (out.isEmpty()) while (!in.isEmpty()) out.push(in.pop()); return out.pop(); }
        int peek()    { if (out.isEmpty()) while (!in.isEmpty()) out.push(in.pop()); return out.peek(); }
    }

    static int[] slidingWindowMax(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        java.util.Deque<Integer> dq = new java.util.ArrayDeque<>(); // stores indices
        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
            dq.offerLast(i);
            if (i >= k - 1) result[i - k + 1] = nums[dq.peekFirst()];
        }
        return result;
    }
}
