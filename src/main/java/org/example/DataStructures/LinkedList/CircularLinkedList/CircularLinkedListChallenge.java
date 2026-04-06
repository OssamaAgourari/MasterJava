package org.example.DataStructures.LinkedList.CircularLinkedList;

/**
 * ============================================================
 *    CIRCULAR LINKED LIST CHALLENGES — LeetCode Style
 * ============================================================
 */
public class CircularLinkedListChallenge {

    // Helper Node class
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    // =========================================================
    // CHALLENGE 1  [EASY]  — Detect Cycle (Floyd's Algorithm)
    // Return true if linked list has a cycle.
    // =========================================================
    static boolean hasCycle(Node head) { return false; /* TODO: slow/fast pointers */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Circular Queue Implementation
    // Implement a circular queue with fixed capacity.
    // =========================================================
    static class MyCircularQueue {
        /* TODO: use array with front/rear pointers */
        MyCircularQueue(int k) {}
        boolean enQueue(int value) { return false; }
        boolean deQueue() { return false; }
        int Front() { return -1; }
        int Rear() { return -1; }
        boolean isEmpty() { return true; }
        boolean isFull() { return false; }
    }

    // =========================================================
    // CHALLENGE 3  [MEDIUM]  — Find Start of Cycle
    // If linked list has a cycle, return node where cycle begins.
    // Return null if no cycle.
    // =========================================================
    static Node detectCycle(Node head) { return null; /* TODO: Floyd's extended */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Circular Buffer / Design
    // Design a circular buffer (deque) that supports:
    // insertFront, insertLast, deleteFront, deleteLast, getFront, getRear
    // =========================================================
    static class MyCircularDeque {
        /* TODO */
        MyCircularDeque(int k) {}
        boolean insertFront(int value) { return false; }
        boolean insertLast(int value)  { return false; }
        boolean deleteFront()          { return false; }
        boolean deleteLast()           { return false; }
        int getFront() { return -1; }
        int getRear()  { return -1; }
        boolean isEmpty() { return true; }
        boolean isFull()  { return false; }
    }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Josephus Problem
    // n people in a circle. Every k-th person is eliminated.
    // Find the position of the last remaining person (0-indexed).
    // Example: n=7, k=3 → 3
    // =========================================================
    static int josephus(int n, int k) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Insert into Sorted Circular Linked List
    // Insert a value into a sorted circular linked list.
    // Return any node of the list after insertion.
    // Example: list=[3,4,1], insertVal=2 → [3,4,1,2] (sorted circular)
    // =========================================================
    static Node insert(Node head, int insertVal) { return null; /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Split Circular Linked List in Half
    // Split a circular linked list into two equal halves.
    // If odd number, first half gets extra node.
    // Example: 1→2→3→4→(back to 1) → [1→2→(back to 1)] and [3→4→(back to 3)]
    // =========================================================
    static Node[] splitCircular(Node head) { return new Node[]{null, null}; /* TODO: slow/fast pointers */ }

    // =========================================================
    // CHALLENGE 8  [HARD]  — Round Robin Scheduling Simulation
    // Simulate CPU round-robin scheduling. Given processes with
    // burst times and a quantum, return finish order.
    // Example: processes=[5,3,7], quantum=2 → [1,0,2] (order of completion)
    // =========================================================
    static int[] roundRobin(int[] burstTimes, int quantum) { return new int[0]; /* TODO */ }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Rotate Circular Linked List
    // Rotate the list by k positions to the right.
    // Example: 1→2→3→4→5→(1), k=2 → 4→5→1→2→3→(4)
    // =========================================================
    static Node rotateRight(Node head, int k) { return null; /* TODO */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Flatten a Circular Multilevel List
    // Each node has a child pointer to another circular list.
    // Flatten so all nodes appear in a single circular list.
    // =========================================================
    static Node flattenCircular(Node head) { return null; /* TODO */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // C1: Cycle detection
        Node cycleList = new Node(1);
        cycleList.next = new Node(2);
        cycleList.next.next = new Node(3);
        cycleList.next.next.next = cycleList.next; // cycle back to node 2
        pass += check("C1a", hasCycle(cycleList), true)  ? 1:0;
        fail += check("C1a", hasCycle(cycleList), true)  ? 0:1;

        Node noCycle = new Node(1, new Node(2, new Node(3, null)));
        pass += check("C1b", hasCycle(noCycle), false) ? 1:0;
        fail += check("C1b", hasCycle(noCycle), false) ? 0:1;

        // C2: Circular Queue
        MyCircularQueue cq = new MyCircularQueue(3);
        pass += check("C2a", cq.enQueue(1), true)  ? 1:0; fail += check("C2a", cq.enQueue(1), true)  ? 0:1;
        pass += check("C2b", cq.enQueue(2), true)  ? 1:0; fail += check("C2b", cq.enQueue(2), true)  ? 0:1;
        pass += check("C2c", cq.enQueue(3), true)  ? 1:0; fail += check("C2c", cq.enQueue(3), true)  ? 0:1;
        pass += check("C2d", cq.enQueue(4), false) ? 1:0; fail += check("C2d", cq.enQueue(4), false) ? 0:1;
        pass += check("C2e", cq.Rear(),     3)     ? 1:0; fail += check("C2e", cq.Rear(),     3)     ? 0:1;
        pass += check("C2f", cq.isFull(),   true)  ? 1:0; fail += check("C2f", cq.isFull(),   true)  ? 0:1;
        pass += check("C2g", cq.deQueue(),  true)  ? 1:0; fail += check("C2g", cq.deQueue(),  true)  ? 0:1;
        pass += check("C2h", cq.enQueue(4), true)  ? 1:0; fail += check("C2h", cq.enQueue(4), true)  ? 0:1;
        pass += check("C2i", cq.Rear(),     4)     ? 1:0; fail += check("C2i", cq.Rear(),     4)     ? 0:1;

        // C5: Josephus
        pass += check("C5a", josephus(7, 3), 3) ? 1:0; fail += check("C5a", josephus(7, 3), 3) ? 0:1;
        pass += check("C5b", josephus(1, 1), 0) ? 1:0; fail += check("C5b", josephus(1, 1), 0) ? 0:1;

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
