package org.example.DataStructures.LinkedList.SinglyLinkedList;

/**
 * ============================================================
 *           SINGLY LINKED LIST — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS A SINGLY LINKED LIST?
 * ------------------------------
 * A sequence of nodes where each node holds a value and a pointer
 * to the NEXT node. The last node points to null.
 *
 *   head → [1|→] → [2|→] → [3|→] → [4|null]
 *
 * TIME COMPLEXITY:
 * -----------------
 *   Operation          | Time   | Notes
 *   -------------------|--------|----------------------------
 *   Access by index    | O(n)   | must traverse from head
 *   Search by value    | O(n)   | linear scan
 *   Insert at head     | O(1)   | just update head pointer
 *   Insert at tail     | O(n)   | traverse to end (O(1) with tail ptr)
 *   Insert at index    | O(n)   | traverse to position
 *   Delete at head     | O(1)   | update head pointer
 *   Delete by value    | O(n)   | find node first
 *   Delete at index    | O(n)   | traverse to position
 *
 * SPACE COMPLEXITY: O(n) — one node per element
 *
 * WHEN TO USE:
 * -------------
 *   ✔ Frequent inserts/deletes at the HEAD
 *   ✔ Unknown or dynamic size
 *   ✔ Implementing stacks/queues
 *   ✗ Need random access by index → use Array
 *   ✗ Need backward traversal     → use Doubly Linked List
 *
 * ============================================================
 */
public class SinglyLinkedList {

    // ─── Node ───────────────────────────────────────────────
    static class Node {
        int  val;
        Node next;
        Node(int val) { this.val = val; }
    }

    // ─── Linked List ────────────────────────────────────────
    static class LinkedList {
        Node head;
        int  size;

        // Add to HEAD — O(1)
        void addFirst(int val) {
            Node node = new Node(val);
            node.next = head;
            head = node;
            size++;
        }

        // Add to TAIL — O(n)
        void addLast(int val) {
            Node node = new Node(val);
            if (head == null) { head = node; size++; return; }
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = node;
            size++;
        }

        // Add at INDEX — O(n)
        void addAt(int index, int val) {
            if (index < 0 || index > size) throw new IndexOutOfBoundsException();
            if (index == 0) { addFirst(val); return; }
            Node cur = head;
            for (int i = 0; i < index - 1; i++) cur = cur.next;
            Node node = new Node(val);
            node.next = cur.next;
            cur.next  = node;
            size++;
        }

        // Remove HEAD — O(1)
        int removeFirst() {
            if (head == null) throw new RuntimeException("Empty list");
            int val = head.val;
            head = head.next;
            size--;
            return val;
        }

        // Remove TAIL — O(n)
        int removeLast() {
            if (head == null) throw new RuntimeException("Empty list");
            if (head.next == null) { int v = head.val; head = null; size--; return v; }
            Node cur = head;
            while (cur.next.next != null) cur = cur.next;
            int val = cur.next.val;
            cur.next = null;
            size--;
            return val;
        }

        // Remove by VALUE — O(n)
        boolean removeValue(int val) {
            if (head == null) return false;
            if (head.val == val) { head = head.next; size--; return true; }
            Node cur = head;
            while (cur.next != null) {
                if (cur.next.val == val) { cur.next = cur.next.next; size--; return true; }
                cur = cur.next;
            }
            return false;
        }

        // Search — O(n)
        int indexOf(int val) {
            Node cur = head; int i = 0;
            while (cur != null) {
                if (cur.val == val) return i;
                cur = cur.next; i++;
            }
            return -1;
        }

        // Get by index — O(n)
        int get(int index) {
            Node cur = head;
            for (int i = 0; i < index; i++) cur = cur.next;
            return cur.val;
        }

        // Reverse in-place — O(n)
        void reverse() {
            Node prev = null, cur = head;
            while (cur != null) {
                Node next = cur.next;
                cur.next = prev;
                prev = cur;
                cur  = next;
            }
            head = prev;
        }

        // Find middle (slow/fast pointers) — O(n)
        Node findMiddle() {
            Node slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        // Detect cycle (Floyd's algorithm) — O(n)
        boolean hasCycle() {
            Node slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) return true;
            }
            return false;
        }

        @Override public String toString() {
            StringBuilder sb = new StringBuilder("[");
            Node cur = head;
            while (cur != null) {
                sb.append(cur.val);
                if (cur.next != null) sb.append(" → ");
                cur = cur.next;
            }
            return sb.append("]").toString();
        }
    }

    public static void main(String[] args) {

        // EXERCISE 1: Build list by adding to tail
        LinkedList list = new LinkedList();
        list.addLast(1); list.addLast(2); list.addLast(3); list.addLast(4);
        System.out.println("Initial:       " + list);  // [1 → 2 → 3 → 4]

        // EXERCISE 2: Add to head — O(1)
        list.addFirst(0);
        System.out.println("addFirst(0):   " + list);  // [0 → 1 → 2 → 3 → 4]

        // EXERCISE 3: Insert at index — O(n)
        list.addAt(3, 99);
        System.out.println("addAt(3,99):   " + list);  // [0 → 1 → 2 → 99 → 3 → 4]

        // EXERCISE 4: Remove head — O(1)
        System.out.println("removeFirst(): " + list.removeFirst());
        System.out.println("After:         " + list);  // [1 → 2 → 99 → 3 → 4]

        // EXERCISE 5: Remove tail — O(n)
        System.out.println("removeLast():  " + list.removeLast());
        System.out.println("After:         " + list);  // [1 → 2 → 99 → 3]

        // EXERCISE 6: Remove by value — O(n)
        list.removeValue(99);
        System.out.println("removeVal(99): " + list);  // [1 → 2 → 3]

        // EXERCISE 7: Search — O(n)
        System.out.println("indexOf(2): " + list.indexOf(2)); // 1
        System.out.println("indexOf(9): " + list.indexOf(9)); // -1

        // EXERCISE 8: Size
        System.out.println("Size: " + list.size); // 3

        // EXERCISE 9: Find middle (slow/fast pointer)
        LinkedList list2 = new LinkedList();
        for (int i = 1; i <= 5; i++) list2.addLast(i);
        System.out.println("List:   " + list2);
        System.out.println("Middle: " + list2.findMiddle().val); // 3

        // EXERCISE 10: Reverse — O(n)
        list2.reverse();
        System.out.println("Reversed: " + list2); // [5 → 4 → 3 → 2 → 1]

        // EXERCISE 11: Detect cycle
        LinkedList noCycle = new LinkedList();
        for (int i = 1; i <= 4; i++) noCycle.addLast(i);
        System.out.println("Has cycle: " + noCycle.hasCycle()); // false
        // Create cycle manually: tail → head
        Node tail = noCycle.head;
        while (tail.next != null) tail = tail.next;
        tail.next = noCycle.head;  // create cycle
        System.out.println("Has cycle: " + noCycle.hasCycle()); // true

        // EXERCISE 12: Merge two sorted lists
        LinkedList la = new LinkedList();
        la.addLast(1); la.addLast(3); la.addLast(5);
        LinkedList lb = new LinkedList();
        lb.addLast(2); lb.addLast(4); lb.addLast(6);
        Node merged = mergeSorted(la.head, lb.head);
        System.out.print("Merged sorted: ");
        printNodes(merged); // 1 2 3 4 5 6

        // EXERCISE 13: Nth node from end (two pointer)
        LinkedList list3 = new LinkedList();
        for (int i = 1; i <= 5; i++) list3.addLast(i);
        System.out.println("2nd from end: " + nthFromEnd(list3.head, 2).val); // 4

        // SUMMARY
        System.out.println("\n=== Singly Linked List Complexity ===");
        System.out.println("Insert head  O(1)");
        System.out.println("Insert tail  O(n) [O(1) with tail ptr]");
        System.out.println("Delete head  O(1)");
        System.out.println("Delete tail  O(n)");
        System.out.println("Search       O(n)");
        System.out.println("Access [i]   O(n)");
    }

    static Node mergeSorted(Node a, Node b) {
        Node dummy = new Node(0), cur = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) { cur.next = a; a = a.next; }
            else                { cur.next = b; b = b.next; }
            cur = cur.next;
        }
        cur.next = (a != null) ? a : b;
        return dummy.next;
    }

    static Node nthFromEnd(Node head, int n) {
        Node fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        while (fast != null) { fast = fast.next; slow = slow.next; }
        return slow;
    }

    static void printNodes(Node head) {
        while (head != null) { System.out.print(head.val + (head.next != null ? " → " : "\n")); head = head.next; }
    }
}
