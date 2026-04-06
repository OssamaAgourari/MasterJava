package org.example.DataStructures.LinkedList.DoublyLinkedList;

/**
 * ============================================================
 *           DOUBLY LINKED LIST — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS A DOUBLY LINKED LIST?
 * ------------------------------
 * Each node has a value + pointer to NEXT + pointer to PREV.
 * Can be traversed in BOTH directions.
 *
 *   null ← [1|→] ↔ [2|→] ↔ [3|→] ↔ [4|null]
 *   head ↑                          ↑ tail
 *
 * TIME COMPLEXITY:
 * -----------------
 *   Operation          | Time   | vs Singly
 *   -------------------|--------|----------------------------
 *   Access by index    | O(n)   | same (can go from tail if closer)
 *   Search by value    | O(n)   | same
 *   Insert at head     | O(1)   | same
 *   Insert at tail     | O(1)   | BETTER (has tail pointer)
 *   Insert at index    | O(n)   | same
 *   Delete at head     | O(1)   | same
 *   Delete at tail     | O(1)   | BETTER (has tail pointer)
 *   Delete given node  | O(1)   | BETTER (no need to find prev)
 *   Delete by value    | O(n)   | same (find first)
 *
 * SPACE: O(n) — extra prev pointer per node vs singly
 *
 * WHEN TO USE DOUBLY over SINGLY:
 * ---------------------------------
 *   ✔ Need O(1) insert/delete at BOTH ends
 *   ✔ Need to traverse backwards
 *   ✔ Implementing Deque, LRU Cache
 *   ✗ Memory is tight (extra prev pointer)
 *
 * ============================================================
 */
public class DoublyLinkedList {

    static class Node {
        int  val;
        Node prev, next;
        Node(int val) { this.val = val; }
    }

    static class DLL {
        Node head, tail;
        int  size;

        // Add to HEAD — O(1)
        void addFirst(int val) {
            Node node = new Node(val);
            if (head == null) { head = tail = node; }
            else {
                node.next = head;
                head.prev = node;
                head = node;
            }
            size++;
        }

        // Add to TAIL — O(1)  ← advantage over singly!
        void addLast(int val) {
            Node node = new Node(val);
            if (tail == null) { head = tail = node; }
            else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            size++;
        }

        // Remove HEAD — O(1)
        int removeFirst() {
            if (head == null) throw new RuntimeException("Empty");
            int val = head.val;
            if (head == tail) { head = tail = null; }
            else { head = head.next; head.prev = null; }
            size--;
            return val;
        }

        // Remove TAIL — O(1)  ← advantage over singly!
        int removeLast() {
            if (tail == null) throw new RuntimeException("Empty");
            int val = tail.val;
            if (head == tail) { head = tail = null; }
            else { tail = tail.prev; tail.next = null; }
            size--;
            return val;
        }

        // Remove a specific NODE — O(1) given the node
        void removeNode(Node node) {
            if (node.prev != null) node.prev.next = node.next;
            else head = node.next;
            if (node.next != null) node.next.prev = node.prev;
            else tail = node.prev;
            size--;
        }

        // Search — O(n)
        Node find(int val) {
            Node cur = head;
            while (cur != null) {
                if (cur.val == val) return cur;
                cur = cur.next;
            }
            return null;
        }

        // Traverse forward
        String toStringForward() {
            StringBuilder sb = new StringBuilder("[");
            Node cur = head;
            while (cur != null) { sb.append(cur.val); if (cur.next != null) sb.append(" ↔ "); cur = cur.next; }
            return sb.append("]").toString();
        }

        // Traverse backward
        String toStringBackward() {
            StringBuilder sb = new StringBuilder("[");
            Node cur = tail;
            while (cur != null) { sb.append(cur.val); if (cur.prev != null) sb.append(" ↔ "); cur = cur.prev; }
            return sb.append("]").toString();
        }
    }

    public static void main(String[] args) {

        DLL dll = new DLL();

        // EXERCISE 1: Build list
        dll.addLast(1); dll.addLast(2); dll.addLast(3); dll.addLast(4);
        System.out.println("Initial (fwd): " + dll.toStringForward());
        System.out.println("Initial (bwd): " + dll.toStringBackward());

        // EXERCISE 2: addFirst and addLast — both O(1)
        dll.addFirst(0);
        dll.addLast(5);
        System.out.println("After addFirst(0)+addLast(5): " + dll.toStringForward());

        // EXERCISE 3: removeFirst O(1)
        System.out.println("removeFirst: " + dll.removeFirst()); // 0
        System.out.println("After: " + dll.toStringForward());

        // EXERCISE 4: removeLast O(1) — advantage over singly
        System.out.println("removeLast: " + dll.removeLast());   // 5
        System.out.println("After: " + dll.toStringForward());

        // EXERCISE 5: Remove specific node O(1) — advantage over singly
        Node node2 = dll.find(2);
        if (node2 != null) dll.removeNode(node2);
        System.out.println("After removeNode(2): " + dll.toStringForward());

        // EXERCISE 6: Bidirectional traversal
        DLL dll2 = new DLL();
        for (int i = 1; i <= 5; i++) dll2.addLast(i);
        System.out.println("Forward:  " + dll2.toStringForward());
        System.out.println("Backward: " + dll2.toStringBackward());

        // EXERCISE 7: LRU Cache concept (move-to-front)
        DLL lru = new DLL();
        lru.addLast(1); lru.addLast(2); lru.addLast(3);
        System.out.println("LRU before access(2): " + lru.toStringForward());
        // "access" node 2: remove it, add to head
        Node accessed = lru.find(2);
        if (accessed != null) {
            lru.removeNode(accessed);
            lru.addFirst(2);
        }
        System.out.println("LRU after access(2):  " + lru.toStringForward());

        // EXERCISE 8: Insert after a node
        DLL dll3 = new DLL();
        dll3.addLast(1); dll3.addLast(3); dll3.addLast(4);
        // Insert 2 after node with value 1
        Node n1 = dll3.find(1);
        if (n1 != null) {
            Node newNode = new Node(2);
            newNode.next = n1.next;
            newNode.prev = n1;
            if (n1.next != null) n1.next.prev = newNode;
            else dll3.tail = newNode;
            n1.next = newNode;
            dll3.size++;
        }
        System.out.println("After insert 2 after 1: " + dll3.toStringForward());

        // SUMMARY
        System.out.println("\n=== Doubly Linked List vs Singly ===");
        System.out.println("Insert/Delete TAIL: O(1) vs O(n)");
        System.out.println("Delete given node:  O(1) vs O(n)");
        System.out.println("Backward traverse:  YES  vs NO");
        System.out.println("Memory per node:    2 ptrs vs 1 ptr");
    }
}
