package org.example.DataStructures.Tree.BinarySearchTree;

import java.util.*;

/**
 * ============================================================
 *           BINARY SEARCH TREE (BST) — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS A BST?
 * ---------------
 * A binary tree with a KEY PROPERTY:
 *   left.val < node.val < right.val  (for every node)
 *
 * This ordering enables O(log n) search, insert, delete
 * on average (balanced trees).
 *
 *       8
 *      / \
 *     3   10
 *    / \    \
 *   1   6   14
 *      / \  /
 *     4   7 13
 *
 * TIME COMPLEXITY:
 * -----------------
 *   Operation | Avg (balanced) | Worst (skewed)
 *   ----------|----------------|---------------
 *   Search    | O(log n)       | O(n)
 *   Insert    | O(log n)       | O(n)
 *   Delete    | O(log n)       | O(n)
 *   Min/Max   | O(log n)       | O(n)
 *   Successor | O(log n)       | O(n)
 *   In-order  | O(n)           | O(n)
 *
 * SPACE: O(n) for the tree, O(h) for recursion stack
 *
 * KEY PROPERTY: IN-ORDER TRAVERSAL OF BST = SORTED ORDER
 *
 * DELETE CASES:
 * --------------
 *   1. Node is a leaf        → simply remove it
 *   2. Node has 1 child      → replace node with that child
 *   3. Node has 2 children   → replace with in-order SUCCESSOR
 *      (smallest in right subtree), then delete successor
 *
 * SELF-BALANCING BSTs (advanced):
 * ---------------------------------
 *   AVL Tree    — rotations keep height O(log n) strictly
 *   Red-Black   — looser balance, used in Java TreeMap/TreeSet
 *   B-Tree      — generalization, used in databases/filesystems
 *
 * JAVA BUILT-IN:
 *   TreeMap<K,V>  — sorted map, backed by Red-Black BST
 *   TreeSet<E>    — sorted set, backed by Red-Black BST
 *   Both: O(log n) get, put, remove, first, last, floor, ceiling
 *
 * ============================================================
 */
public class BinarySearchTree {

    static class Node {
        int val; Node left, right;
        Node(int val) { this.val = val; }
    }

    static class BST {
        Node root;

        // ── INSERT — O(log n) avg ──────────────────────────
        void insert(int val) { root = insertRec(root, val); }
        private Node insertRec(Node node, int val) {
            if (node == null) return new Node(val);
            if (val < node.val) node.left  = insertRec(node.left,  val);
            else if (val > node.val) node.right = insertRec(node.right, val);
            // if equal: ignore duplicates (or handle as needed)
            return node;
        }

        // ── SEARCH — O(log n) avg ─────────────────────────
        boolean search(int val) { return searchRec(root, val); }
        private boolean searchRec(Node node, int val) {
            if (node == null) return false;
            if (val == node.val) return true;
            return val < node.val ? searchRec(node.left, val) : searchRec(node.right, val);
        }

        // ── DELETE — O(log n) avg ─────────────────────────
        void delete(int val) { root = deleteRec(root, val); }
        private Node deleteRec(Node node, int val) {
            if (node == null) return null;
            if (val < node.val) { node.left  = deleteRec(node.left,  val); return node; }
            if (val > node.val) { node.right = deleteRec(node.right, val); return node; }
            // found
            if (node.left  == null) return node.right;  // case 1/2
            if (node.right == null) return node.left;   // case 2
            // case 3: two children → find in-order successor (min of right)
            Node successor = findMin(node.right);
            node.val   = successor.val;
            node.right = deleteRec(node.right, successor.val);
            return node;
        }

        // ── MIN / MAX ─────────────────────────────────────
        Node findMin(Node node) {
            while (node.left != null) node = node.left;
            return node;
        }
        Node findMax(Node node) {
            while (node.right != null) node = node.right;
            return node;
        }
        int min() { return findMin(root).val; }
        int max() { return findMax(root).val; }

        // ── IN-ORDER = SORTED ─────────────────────────────
        List<Integer> inOrder() {
            List<Integer> r = new ArrayList<>();
            inOrderRec(root, r);
            return r;
        }
        private void inOrderRec(Node n, List<Integer> r) {
            if (n == null) return;
            inOrderRec(n.left, r); r.add(n.val); inOrderRec(n.right, r);
        }

        // ── HEIGHT ────────────────────────────────────────
        int height() { return heightRec(root); }
        private int heightRec(Node n) {
            if (n == null) return 0;
            return 1 + Math.max(heightRec(n.left), heightRec(n.right));
        }

        // ── IS VALID BST ──────────────────────────────────
        boolean isValidBST() { return validateRec(root, Long.MIN_VALUE, Long.MAX_VALUE); }
        private boolean validateRec(Node n, long min, long max) {
            if (n == null) return true;
            if (n.val <= min || n.val >= max) return false;
            return validateRec(n.left, min, n.val) && validateRec(n.right, n.val, max);
        }

        // ── FLOOR & CEILING ───────────────────────────────
        // Floor: largest value ≤ target
        Integer floor(int target) {
            Node result = floorRec(root, target);
            return result == null ? null : result.val;
        }
        private Node floorRec(Node n, int t) {
            if (n == null) return null;
            if (n.val == t) return n;
            if (n.val > t) return floorRec(n.left, t);
            Node right = floorRec(n.right, t);
            return right != null ? right : n;
        }

        // Ceiling: smallest value ≥ target
        Integer ceiling(int target) {
            Node result = ceilRec(root, target);
            return result == null ? null : result.val;
        }
        private Node ceilRec(Node n, int t) {
            if (n == null) return null;
            if (n.val == t) return n;
            if (n.val < t) return ceilRec(n.right, t);
            Node left = ceilRec(n.left, t);
            return left != null ? left : n;
        }

        // Kth smallest (in-order)
        int kthSmallest(int k) {
            int[] count = {0, 0};
            kthHelper(root, k, count);
            return count[1];
        }
        private void kthHelper(Node n, int k, int[] res) {
            if (n == null || res[0] >= k) return;
            kthHelper(n.left, k, res);
            if (++res[0] == k) { res[1] = n.val; return; }
            kthHelper(n.right, k, res);
        }
    }

    public static void main(String[] args) {

        BST bst = new BST();

        // EXERCISE 1: Insert
        for (int v : new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13}) bst.insert(v);
        System.out.println("In-order (sorted): " + bst.inOrder());
        // [1, 3, 4, 6, 7, 8, 10, 13, 14]

        // EXERCISE 2: Search O(log n)
        System.out.println("search(6):  " + bst.search(6));  // true
        System.out.println("search(5):  " + bst.search(5));  // false

        // EXERCISE 3: Min and Max
        System.out.println("min: " + bst.min()); // 1
        System.out.println("max: " + bst.max()); // 14

        // EXERCISE 4: Height
        System.out.println("height: " + bst.height()); // 4

        // EXERCISE 5: Delete leaf
        bst.delete(7);
        System.out.println("After delete(7): " + bst.inOrder());
        // [1, 3, 4, 6, 8, 10, 13, 14]

        // EXERCISE 6: Delete node with 1 child
        bst.delete(14);
        System.out.println("After delete(14): " + bst.inOrder());
        // [1, 3, 4, 6, 8, 10, 13]

        // EXERCISE 7: Delete node with 2 children
        bst.delete(3);
        System.out.println("After delete(3): " + bst.inOrder());
        // [1, 4, 6, 8, 10, 13]

        // EXERCISE 8: isValidBST
        System.out.println("isValidBST: " + bst.isValidBST()); // true

        // EXERCISE 9: Floor and Ceiling
        System.out.println("floor(5):   " + bst.floor(5));   // 4
        System.out.println("floor(6):   " + bst.floor(6));   // 6
        System.out.println("ceiling(5): " + bst.ceiling(5)); // 6
        System.out.println("ceiling(6): " + bst.ceiling(6)); // 6

        // EXERCISE 10: Kth smallest
        System.out.println("2nd smallest: " + bst.kthSmallest(2)); // 4
        System.out.println("4th smallest: " + bst.kthSmallest(4)); // 8

        // EXERCISE 11: Java TreeMap (Red-Black BST internally)
        java.util.TreeMap<Integer,String> map = new java.util.TreeMap<>();
        map.put(5,"e"); map.put(2,"b"); map.put(8,"h"); map.put(1,"a");
        System.out.println("TreeMap (sorted): " + map.keySet());  // [1, 2, 5, 8]
        System.out.println("floorKey(3):   " + map.floorKey(3)); // 2
        System.out.println("ceilingKey(3): " + map.ceilingKey(3)); // 5
        System.out.println("firstKey: " + map.firstKey()); // 1
        System.out.println("lastKey:  " + map.lastKey());  // 8

        // SUMMARY
        System.out.println("\n=== BST Complexity ===");
        System.out.println("All ops  O(log n) avg, O(n) worst (use balanced BST)");
        System.out.println("In-order → sorted sequence");
        System.out.println("Java: TreeMap/TreeSet use Red-Black BST");
    }
}
