package org.example.DataStructures.LinkedList.DoublyLinkedList;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================
 *      DOUBLY LINKED LIST CHALLENGES — LeetCode Style
 * ============================================================
 */
public class DoublyLinkedListChallenge {

    static class Node {
        int val; Node prev, next;
        Node(int val) { this.val = val; }
    }

    static Node build(int... vals) {
        Node dummy = new Node(0); Node cur = dummy;
        for (int v : vals) { cur.next = new Node(v); cur.next.prev = cur; cur = cur.next; }
        dummy.next.prev = null;
        return dummy.next;
    }
    static String fwd(Node head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) { sb.append(head.val); if (head.next != null) sb.append(","); head = head.next; }
        return sb.append("]").toString();
    }
    static String bwd(Node tail) {
        StringBuilder sb = new StringBuilder("[");
        while (tail != null) { sb.append(tail.val); if (tail.prev != null) sb.append(","); tail = tail.prev; }
        return sb.append("]").toString();
    }
    static Node tail(Node head) { while (head != null && head.next != null) head = head.next; return head; }

    // =========================================================
    // CHALLENGE 1  [EASY]  — Reverse a Doubly Linked List
    // Example: 1↔2↔3↔4 → 4↔3↔2↔1 (swap all prev/next pointers)
    // =========================================================
    static Node reverseDLL(Node head) {
        // TODO
        return null;
    }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Remove All Occurrences of Value
    // Example: 1↔2↔3↔2↔4, val=2 → 1↔3↔4
    // =========================================================
    static Node removeAll(Node head, int val) {
        // TODO
        return null;
    }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Find Length
    // Return the number of nodes.
    // =========================================================
    static int length(Node head) {
        // TODO
        return 0;
    }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Sort Doubly Linked List
    // Sort in ascending order (insertion sort is fine for DLL).
    // Example: 4↔2↔1↔3 → 1↔2↔3↔4
    // =========================================================
    static Node sortDLL(Node head) {
        // TODO
        return null;
    }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — LRU Cache
    // Implement an LRU (Least Recently Used) cache with capacity.
    //   get(key)         → return value if exists, else -1.
    //                      Mark key as recently used.
    //   put(key, value)  → insert/update. If capacity exceeded,
    //                      evict the LEAST recently used key.
    //
    // Both operations must be O(1).
    // Use a HashMap + Doubly Linked List.
    //
    // Example:
    //   capacity=2
    //   put(1,1), put(2,2)
    //   get(1)  → 1
    //   put(3,3) → evicts key 2
    //   get(2)  → -1
    // =========================================================
    static class LRUCache {
        // TODO: declare fields

        LRUCache(int capacity) {
            // TODO
        }

        int get(int key) {
            // TODO
            return -1;
        }

        void put(int key, int value) {
            // TODO
        }
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Pairs with Given Sum (sorted DLL)
    // Given a SORTED doubly linked list and a target sum,
    // return count of pairs (a, b) where a + b == target.
    // Use two-pointer (head and tail).
    // Example: 1↔2↔4↔5↔6↔8↔9, target=7 → 2  (pairs: (1,6),(2,5))
    // =========================================================
    static int countPairsWithSum(Node head, int target) {
        // TODO
        return 0;
    }

    // =========================================================
    // CHALLENGE 7  [HARD]  — Flatten Multilevel DLL
    // Some nodes have a "child" pointer pointing to a separate DLL.
    // Flatten so all nodes appear in a single-level DLL.
    // The child list is inserted AFTER the node that contains it.
    // =========================================================
    static class MultiNode {
        int val; MultiNode prev, next, child;
        MultiNode(int v) { val = v; }
    }

    static MultiNode flatten(MultiNode head) {
        // TODO
        return null;
    }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // C1 reverse
        Node r = reverseDLL(build(1,2,3,4));
        pass += check("C1a", fwd(r),  "[4,3,2,1]") ? 1:0; fail += check("C1a", fwd(r),  "[4,3,2,1]") ? 0:1;
        pass += check("C1b", bwd(tail(r)), "[1,2,3,4]") ? 1:0; fail += check("C1b", bwd(tail(r)), "[1,2,3,4]") ? 0:1;

        // C2 removeAll
        pass += check("C2a", fwd(removeAll(build(1,2,3,2,4), 2)), "[1,3,4]") ? 1:0;
        fail += check("C2a", fwd(removeAll(build(1,2,3,2,4), 2)), "[1,3,4]") ? 0:1;

        // C3 length
        pass += check("C3a", length(build(1,2,3,4,5)), 5) ? 1:0;
        fail += check("C3a", length(build(1,2,3,4,5)), 5) ? 0:1;

        // C4 sort
        pass += check("C4a", fwd(sortDLL(build(4,2,1,3))), "[1,2,3,4]") ? 1:0;
        fail += check("C4a", fwd(sortDLL(build(4,2,1,3))), "[1,2,3,4]") ? 0:1;

        // C5 LRU Cache
        LRUCache lru = new LRUCache(2);
        lru.put(1,1); lru.put(2,2);
        pass += check("C5a", lru.get(1), 1)  ? 1:0; fail += check("C5a", lru.get(1), 1)  ? 0:1;
        lru.put(3,3);
        pass += check("C5b", lru.get(2), -1) ? 1:0; fail += check("C5b", lru.get(2), -1) ? 0:1;
        pass += check("C5c", lru.get(3), 3)  ? 1:0; fail += check("C5c", lru.get(3), 3)  ? 0:1;

        // C6 pairs with sum
        pass += check("C6a", countPairsWithSum(build(1,2,4,5,6,8,9), 7), 2) ? 1:0;
        fail += check("C6a", countPairsWithSum(build(1,2,4,5,6,8,9), 7), 2) ? 0:1;

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
