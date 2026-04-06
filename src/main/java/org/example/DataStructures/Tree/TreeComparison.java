package org.example.DataStructures.Tree;

/**
 * ============================================================
 *           TREE TYPES — COMPARISON GUIDE
 * ============================================================
 *
 * BINARY TREE vs BST vs BALANCED BST:
 * ─────────────────────────────────────────────────────────────
 *  Property          | Binary Tree | BST      | Balanced BST
 * ─────────────────────────────────────────────────────────────
 *  Ordering          | none        | L<N<R    | L<N<R
 *  Search            | O(n)        | O(log n) avg, O(n) worst | O(log n)
 *  Insert            | O(n)        | O(log n) avg, O(n) worst | O(log n)
 *  Delete            | O(n)        | O(log n) avg, O(n) worst | O(log n)
 *  Min/Max           | O(n)        | O(log n) avg             | O(log n)
 *  In-order sorted?  | NO          | YES      | YES
 *  Auto-balance?     | NO          | NO       | YES (rotations)
 * ─────────────────────────────────────────────────────────────
 *
 * TREE TYPES OVERVIEW:
 * ─────────────────────────────────────────────────────────────
 *  Type              | Children | Key property     | Use case
 * ─────────────────────────────────────────────────────────────
 *  Binary Tree       | ≤ 2      | none             | general hierarchies
 *  BST               | ≤ 2      | ordered          | sorted data, search
 *  AVL Tree          | ≤ 2      | |h(L)-h(R)|≤1   | strict balance
 *  Red-Black Tree    | ≤ 2      | color invariants | Java TreeMap/TreeSet
 *  Heap              | ≤ 2      | parent≤children  | priority queue
 *  Trie (Prefix)     | ≤ 26     | char at each edge| string search
 *  B-Tree            | many     | sorted, fat node | databases/FS
 *  N-ary Tree        | any      | none             | org charts, DOM
 * ─────────────────────────────────────────────────────────────
 *
 * TRAVERSALS COMPARISON:
 * ────────────────────────────────────────────────────────────
 *  Traversal    | Order           | Use case
 * ─────────────────────────────────────────────────────────────
 *  In-order     | L → Root → R   | Sorted output from BST
 *  Pre-order    | Root → L → R   | Serialize/copy tree
 *  Post-order   | L → R → Root   | Delete tree, eval expressions
 *  Level-order  | BFS by level   | Shortest path, level operations
 * ─────────────────────────────────────────────────────────────
 *
 * WHEN TO CHOOSE:
 * ----------------
 *   Binary Tree  → parse trees, expression trees, no ordering needed
 *   BST          → when you need sorted data + fast lookup (O log n avg)
 *   TreeMap/Set  → Java's balanced BST, production use
 *   Heap         → priority queue, top-K problems
 *   Trie         → prefix search, autocomplete, word dictionary
 *
 * ============================================================
 */
public class TreeComparison {

    static class Node { int v; Node l, r; Node(int v){this.v=v;} Node(int v,Node l,Node r){this.v=v;this.l=l;this.r=r;} }

    public static void main(String[] args) {

        System.out.println("============================================================");
        System.out.println("  TREE TYPES — COMPARISON DEMO");
        System.out.println("============================================================\n");

        // ── 1. Binary Tree — no ordering ────────────────────
        System.out.println("--- Binary Tree (no ordering) ---");
        Node bt = new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3));
        System.out.print("Pre-order: ");   preOrder(bt);   System.out.println();
        System.out.print("In-order:  ");   inOrder(bt);    System.out.println();
        System.out.print("Post-order:");   postOrder(bt);  System.out.println();

        // ── 2. BST — ordered ────────────────────────────────
        System.out.println("\n--- BST (L < Node < R) ---");
        Node bst = null;
        for (int v : new int[]{5,3,7,1,4,6,8}) bst = insert(bst, v);
        System.out.print("In-order (sorted): "); inOrder(bst); System.out.println();
        System.out.println("search(4): " + search(bst,4)); // true
        System.out.println("search(9): " + search(bst,9)); // false
        System.out.println("min: " + min(bst) + ", max: " + max(bst));

        // ── 3. Java TreeMap — balanced BST ──────────────────
        System.out.println("\n--- Java TreeMap (Red-Black BST) ---");
        java.util.TreeMap<Integer,String> tm = new java.util.TreeMap<>();
        for (int[] pair : new int[][]{{5,0},{3,0},{7,0},{1,0}}) tm.put(pair[0], "v"+pair[0]);
        System.out.println("Keys sorted:  " + tm.keySet());
        System.out.println("floorKey(4):  " + tm.floorKey(4));   // 3
        System.out.println("ceilingKey(4):" + tm.ceilingKey(4)); // 5
        System.out.println("firstKey:     " + tm.firstKey());    // 1
        System.out.println("lastKey:      " + tm.lastKey());     // 7

        // ── 4. PriorityQueue — heap (tree in array) ─────────
        System.out.println("\n--- PriorityQueue (min-heap) ---");
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();
        for (int v : new int[]{5,1,3,2,4}) pq.offer(v);
        System.out.print("Poll order (ascending): ");
        while (!pq.isEmpty()) System.out.print(pq.poll() + " ");
        System.out.println();

        // ── 5. Complexity table ──────────────────────────────
        System.out.println("\n═══════════════════════════════════════════════════════");
        System.out.printf("%-16s %-14s %-14s %-14s%n","Operation","BinaryTree","BST(avg)","TreeMap(bal)");
        System.out.println("───────────────────────────────────────────────────────");
        row("Search",        "O(n)",    "O(log n)","O(log n)");
        row("Insert",        "O(n)",    "O(log n)","O(log n)");
        row("Delete",        "O(n)",    "O(log n)","O(log n)");
        row("Min/Max",       "O(n)",    "O(log n)","O(log n)");
        row("Sorted order",  "No",      "In-order","keySet()");
        row("Worst case",    "O(n)",    "O(n)",    "O(log n)");
        System.out.println("═══════════════════════════════════════════════════════");

        System.out.println("\nRecommendations:");
        System.out.println("  BST interview → implement manually for practice");
        System.out.println("  Production    → Java TreeMap/TreeSet (balanced)");
        System.out.println("  Priority ops  → PriorityQueue (heap)");
        System.out.println("  String search → Trie");
    }

    static void preOrder(Node n) { if(n==null)return; System.out.print(n.v+" "); preOrder(n.l); preOrder(n.r); }
    static void inOrder(Node n)  { if(n==null)return; inOrder(n.l); System.out.print(n.v+" "); inOrder(n.r); }
    static void postOrder(Node n){ if(n==null)return; postOrder(n.l); postOrder(n.r); System.out.print(n.v+" "); }
    static Node insert(Node n, int v) { if(n==null)return new Node(v); if(v<n.v)n.l=insert(n.l,v); else if(v>n.v)n.r=insert(n.r,v); return n; }
    static boolean search(Node n, int v) { if(n==null)return false; if(v==n.v)return true; return v<n.v?search(n.l,v):search(n.r,v); }
    static int min(Node n) { while(n.l!=null)n=n.l; return n.v; }
    static int max(Node n) { while(n.r!=null)n=n.r; return n.v; }
    static void row(String op, String bt, String bst, String tm) {
        System.out.printf("%-16s %-14s %-14s %-14s%n", op, bt, bst, tm);
    }
}
