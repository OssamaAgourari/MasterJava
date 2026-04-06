package org.example.DataStructures.LinkedList;

/**
 * ============================================================
 *        LINKED LIST TYPES — COMPARISON GUIDE
 * ============================================================
 *
 * THREE MAIN TYPES:
 * ------------------
 *   1. Singly Linked List   — each node has ONE pointer (next)
 *   2. Doubly Linked List   — each node has TWO pointers (next, prev)
 *   3. Circular Linked List — last node points back to first
 *
 * ─────────────────────────────────────────────────────────────
 *  OPERATION          | Singly | Doubly | Circular (singly)
 * ─────────────────────────────────────────────────────────────
 *  Insert at HEAD     | O(1)   | O(1)   | O(1)
 *  Insert at TAIL     | O(n)   | O(1)*  | O(1)*
 *  Delete at HEAD     | O(1)   | O(1)   | O(1)
 *  Delete at TAIL     | O(n)   | O(1)*  | O(n)
 *  Delete given node  | O(n)   | O(1)** | O(n)
 *  Search by value    | O(n)   | O(n)   | O(n)
 *  Access by index    | O(n)   | O(n)   | O(n)
 *  Backward traverse  | ✗ NO   | ✔ YES  | ✗ NO
 *  Memory per node    | 1 ptr  | 2 ptrs | 1 ptr
 * ─────────────────────────────────────────────────────────────
 *  * requires maintaining a tail pointer
 *  ** O(1) only if you already HAVE the node reference
 *
 * WHEN TO CHOOSE:
 * ----------------
 *   Singly   → simplest, less memory, forward-only traversal
 *              USE FOR: stack, simple queue, most interview problems
 *
 *   Doubly   → O(1) delete at both ends, backward traversal
 *              USE FOR: deque, LRU cache, browser history, undo/redo
 *
 *   Circular → tail.next = head, great for cycling
 *              USE FOR: round-robin, Josephus, ring buffer, playlists
 *
 * ARRAYS vs LINKED LISTS:
 * ------------------------
 *   Feature            | Array  | Linked List
 *   -------------------|--------|------------
 *   Access by index    | O(1)   | O(n)
 *   Insert at middle   | O(n)   | O(n) find + O(1) link
 *   Insert at head     | O(n)   | O(1)
 *   Cache performance  | GOOD   | POOR (scattered memory)
 *   Size flexibility   | fixed* | dynamic
 *   Memory overhead    | none   | pointer(s) per node
 *   * ArrayList resizes dynamically but doubling is amortized
 *
 * JAVA BUILT-IN EQUIVALENTS:
 * ---------------------------
 *   LinkedList<E> (java.util) → doubly linked, implements List + Deque
 *   ArrayDeque<E>             → circular array-based deque (usually faster)
 *
 * ============================================================
 */
public class LinkedListComparison {

    // ── Minimal node for demo ─────────────────────────────────
    static class SNode { int v; SNode next; SNode(int v){this.v=v;} }
    static class DNode { int v; DNode p, n; DNode(int v){this.v=v;} }

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println("  LINKED LIST COMPARISON DEMO");
        System.out.println("============================================\n");

        // ── 1. Singly — stack-style usage ─────────────────────
        System.out.println("--- Singly Linked List (stack usage) ---");
        SNode sHead = null;
        // push
        for (int v : new int[]{1,2,3,4,5}) {
            SNode n = new SNode(v); n.next = sHead; sHead = n;
        }
        System.out.print("Stack (LIFO): ");
        for (SNode c = sHead; c != null; c = c.next) System.out.print(c.v + " ");
        System.out.println();

        // ── 2. Doubly — deque-style usage ─────────────────────
        System.out.println("\n--- Doubly Linked List (deque usage) ---");
        DNode dHead = null, dTail = null;
        for (int v : new int[]{1,2,3}) {
            DNode n = new DNode(v);
            if (dTail == null) { dHead = dTail = n; }
            else { dTail.n = n; n.p = dTail; dTail = n; }
        }
        System.out.print("Forward:  ");
        for (DNode c = dHead; c != null; c = c.n) System.out.print(c.v + " ");
        System.out.print("\nBackward: ");
        for (DNode c = dTail; c != null; c = c.p) System.out.print(c.v + " ");
        System.out.println();

        // ── 3. Circular — round-robin demo ────────────────────
        System.out.println("\n--- Circular Linked List (round-robin) ---");
        SNode cHead = new SNode(1);
        SNode c2 = new SNode(2), c3 = new SNode(3);
        cHead.next = c2; c2.next = c3; c3.next = cHead; // close the circle
        SNode cur = cHead;
        System.out.print("3 full rounds: ");
        for (int i = 0; i < 9; i++) {
            System.out.print(cur.v + (i<8?" → ":"\n"));
            cur = cur.next;
        }

        // ── 4. Side-by-side complexity printout ───────────────
        System.out.println("\n══════════════════════════════════════════════════");
        System.out.printf("%-22s %-8s %-8s %-8s%n","Operation","Singly","Doubly","Circular");
        System.out.println("──────────────────────────────────────────────────");
        row("Insert HEAD",     "O(1)","O(1)","O(1)");
        row("Insert TAIL",     "O(n)","O(1)","O(1)");
        row("Delete HEAD",     "O(1)","O(1)","O(1)");
        row("Delete TAIL",     "O(n)","O(1)","O(n)");
        row("Delete node ref", "O(n)","O(1)","O(n)");
        row("Search",          "O(n)","O(n)","O(n)");
        row("Access index",    "O(n)","O(n)","O(n)");
        row("Backward",        "NO",  "YES", "NO");
        row("Extra memory",    "1ptr","2ptr","1ptr");
        System.out.println("══════════════════════════════════════════════════");

        System.out.println("\nRecommendations:");
        System.out.println("  Singly   → default choice, interviews, stack/queue");
        System.out.println("  Doubly   → LRU cache, undo/redo, browser history");
        System.out.println("  Circular → round-robin, Josephus, ring buffer");
        System.out.println("  Java     → java.util.LinkedList (doubly) or ArrayDeque");
    }

    static void row(String op, String s, String d, String c) {
        System.out.printf("%-22s %-8s %-8s %-8s%n", op, s, d, c);
    }
}
