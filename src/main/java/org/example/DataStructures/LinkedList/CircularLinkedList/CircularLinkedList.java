package org.example.DataStructures.LinkedList.CircularLinkedList;

/**
 * ============================================================
 *         CIRCULAR LINKED LIST — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS A CIRCULAR LINKED LIST?
 * ---------------------------------
 * A linked list where the LAST node points back to the FIRST
 * node (instead of null), forming a circle.
 *
 * Singly Circular:
 *   [1|→] → [2|→] → [3|→] → [4|→] ↩ (back to 1)
 *
 * Doubly Circular:
 *   ↩ [1|↔] ↔ [2|↔] ↔ [3|↔] ↩ (head.prev = tail, tail.next = head)
 *
 * TIME COMPLEXITY (singly circular):
 * ------------------------------------
 *   Operation          | Time
 *   -------------------|--------
 *   Insert at head     | O(1)  (update tail.next)
 *   Insert at tail     | O(1)  (maintain tail pointer)
 *   Delete at head     | O(1)
 *   Delete at tail     | O(n)  (must find node before tail)
 *   Search             | O(n)
 *
 * WHEN TO USE:
 * -------------
 *   ✔ Round-robin scheduling (process queues)
 *   ✔ Circular buffers / ring buffers
 *   ✔ Games with circular turns (next player after last = first)
 *   ✔ Music playlist repeat mode
 *
 * KEY TRICK: Keep a pointer to TAIL (not head).
 *   From tail you reach head in O(1): tail.next = head
 *   Insert at BOTH ends becomes O(1).
 *
 * ============================================================
 */
public class CircularLinkedList {

    static class Node {
        int  val;
        Node next;
        Node(int val) { this.val = val; }
    }

    static class CLL {
        Node tail;  // tail.next = head
        int  size;

        Node head() { return tail == null ? null : tail.next; }

        // Add to TAIL — O(1)
        void addLast(int val) {
            Node node = new Node(val);
            if (tail == null) {
                tail = node;
                tail.next = tail;   // points to itself
            } else {
                node.next = tail.next;  // new.next = head
                tail.next = node;       // old tail → new node
                tail = node;            // tail moves forward
            }
            size++;
        }

        // Add to HEAD — O(1) using tail pointer
        void addFirst(int val) {
            Node node = new Node(val);
            if (tail == null) {
                tail = node;
                tail.next = tail;
            } else {
                node.next = tail.next;  // new.next = current head
                tail.next = node;       // tail.next (head ptr) = new
            }
            size++;
        }

        // Remove HEAD — O(1)
        int removeFirst() {
            if (tail == null) throw new RuntimeException("Empty");
            Node head = tail.next;
            int val = head.val;
            if (tail == head) tail = null;  // only one node
            else tail.next = head.next;
            size--;
            return val;
        }

        // Search — O(n)
        boolean contains(int val) {
            if (tail == null) return false;
            Node cur = tail.next;  // start at head
            do {
                if (cur.val == val) return true;
                cur = cur.next;
            } while (cur != tail.next);  // stop when back at head
            return false;
        }

        // Traverse — O(n)
        @Override public String toString() {
            if (tail == null) return "[]";
            StringBuilder sb = new StringBuilder("[");
            Node cur = tail.next;  // head
            do {
                sb.append(cur.val);
                if (cur.next != tail.next) sb.append(" → ");
                cur = cur.next;
            } while (cur != tail.next);
            return sb.append(" → (head)]").toString();
        }

        // Josephus problem helper: remove every kth node
        int josephus(int k) {
            if (tail == null) throw new RuntimeException("Empty");
            Node cur = tail;
            while (size > 1) {
                // advance k-1 steps
                for (int i = 0; i < k - 1; i++) cur = cur.next;
                // remove cur.next
                cur.next = cur.next.next;
                if (cur.next == cur) { tail = cur; break; }
                size--;
            }
            return tail.next.val;
        }
    }

    public static void main(String[] args) {

        // EXERCISE 1: Build circular list
        CLL cll = new CLL();
        cll.addLast(1); cll.addLast(2); cll.addLast(3); cll.addLast(4);
        System.out.println("Initial:      " + cll);
        System.out.println("tail=" + cll.tail.val + ", head=" + cll.head().val);

        // EXERCISE 2: addFirst — O(1)
        cll.addFirst(0);
        System.out.println("addFirst(0):  " + cll);

        // EXERCISE 3: addLast — O(1)
        cll.addLast(5);
        System.out.println("addLast(5):   " + cll);

        // EXERCISE 4: removeFirst — O(1)
        System.out.println("removeFirst: " + cll.removeFirst()); // 0
        System.out.println("After: " + cll);

        // EXERCISE 5: Search — O(n)
        System.out.println("contains(3): " + cll.contains(3));  // true
        System.out.println("contains(9): " + cll.contains(9));  // false

        // EXERCISE 6: Size
        System.out.println("Size: " + cll.size);

        // EXERCISE 7: Full traversal demo
        System.out.println("Traversal (one full loop from head):");
        Node cur = cll.head();
        int steps = cll.size;
        for (int i = 0; i < steps; i++) {
            System.out.print(cur.val + (i < steps - 1 ? " → " : "\n"));
            cur = cur.next;
        }

        // EXERCISE 8: Josephus Problem
        // n=6 people in circle, every 2nd is eliminated. Who survives?
        CLL josephus = new CLL();
        for (int i = 1; i <= 6; i++) josephus.addLast(i);
        System.out.println("Josephus(k=2, n=6) survivor: " + josephus.josephus(2)); // 5

        // EXERCISE 9: Round-robin simulation
        CLL tasks = new CLL();
        tasks.addLast(100); tasks.addLast(200); tasks.addLast(300);
        System.out.println("Round-robin (3 rounds):");
        Node t = tasks.head();
        for (int round = 0; round < 9; round++) {
            System.out.println("  Processing task: " + t.val);
            t = t.next;
        }

        // SUMMARY
        System.out.println("\n=== Circular Linked List ===");
        System.out.println("tail.next = head  → O(1) access to both ends");
        System.out.println("No null at end     → need loop termination condition");
        System.out.println("Use cases: round-robin, Josephus, ring buffer");
    }
}
