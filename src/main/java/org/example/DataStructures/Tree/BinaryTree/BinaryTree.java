package org.example.DataStructures.Tree.BinaryTree;

import java.util.*;

/**
 * ============================================================
 *              BINARY TREE — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS A BINARY TREE?
 * -----------------------
 * A tree where each node has AT MOST two children: left and right.
 * No ordering constraint (that's BST's job).
 *
 *          1
 *         / \
 *        2   3
 *       / \   \
 *      4   5   6
 *
 * TERMINOLOGY:
 * -------------
 *   Root    — topmost node (no parent)
 *   Leaf    — node with no children
 *   Height  — longest path from root to a leaf
 *   Depth   — distance from root to a node
 *   Balanced— |height(left) - height(right)| ≤ 1 for every node
 *
 * TIME COMPLEXITY (balanced tree):
 * ----------------------------------
 *   Operation     | Balanced | Skewed (worst)
 *   --------------|----------|---------------
 *   Search        | O(log n) | O(n)
 *   Insert        | O(log n) | O(n)
 *   Delete        | O(log n) | O(n)
 *   Traversal     | O(n)     | O(n)
 *   Height        | O(n)     | O(n)
 *
 * TRAVERSALS:
 * ------------
 *   In-order   (L → Root → R) — gives sorted order in BST
 *   Pre-order  (Root → L → R) — copy/serialize tree
 *   Post-order (L → R → Root) — delete tree, evaluate expressions
 *   Level-order (BFS)         — level by level, uses Queue
 *
 * SPACE COMPLEXITY:
 *   O(h) for recursive DFS (h = height = log n balanced, n skewed)
 *   O(n) for BFS (queue holds one level at a time)
 *
 * ============================================================
 */
public class BinaryTree {

    static class Node {
        int  val;
        Node left, right;
        Node(int val) { this.val = val; }
        Node(int val, Node l, Node r) { this.val=val; left=l; right=r; }
    }

    // Build the example tree:
    //       1
    //      / \
    //     2   3
    //    / \   \
    //   4   5   6
    static Node buildSampleTree() {
        Node root = new Node(1);
        root.left  = new Node(2, new Node(4), new Node(5));
        root.right = new Node(3, null, new Node(6));
        return root;
    }

    // ─── TRAVERSALS (recursive) ──────────────────────────────

    static void inOrder(Node node, List<Integer> result) {
        if (node == null) return;
        inOrder(node.left, result);
        result.add(node.val);
        inOrder(node.right, result);
    }

    static void preOrder(Node node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        preOrder(node.left, result);
        preOrder(node.right, result);
    }

    static void postOrder(Node node, List<Integer> result) {
        if (node == null) return;
        postOrder(node.left, result);
        postOrder(node.right, result);
        result.add(node.val);
    }

    // Level-order (BFS) — returns list of levels
    static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                level.add(cur.val);
                if (cur.left  != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            result.add(level);
        }
        return result;
    }

    // ─── PROPERTIES ──────────────────────────────────────────

    static int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    static int size(Node node) {
        if (node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }

    static boolean isBalanced(Node node) {
        return checkHeight(node) != -1;
    }
    private static int checkHeight(Node n) {
        if (n == null) return 0;
        int l = checkHeight(n.left);  if (l == -1) return -1;
        int r = checkHeight(n.right); if (r == -1) return -1;
        if (Math.abs(l - r) > 1) return -1;
        return 1 + Math.max(l, r);
    }

    static boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    static boolean isSymmetric(Node root) {
        return isMirror(root, root);
    }
    private static boolean isMirror(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val && isMirror(a.left,b.right) && isMirror(a.right,b.left);
    }

    // Max depth = height
    static int maxDepth(Node node) { return height(node); }

    // Diameter — longest path between any two nodes
    static int diameter(Node root) {
        int[] ans = {0};
        diameterHelper(root, ans);
        return ans[0];
    }
    private static int diameterHelper(Node n, int[] ans) {
        if (n == null) return 0;
        int l = diameterHelper(n.left, ans);
        int r = diameterHelper(n.right, ans);
        ans[0] = Math.max(ans[0], l + r);
        return 1 + Math.max(l, r);
    }

    // Max path sum
    static int maxPathSum(Node root) {
        int[] ans = {Integer.MIN_VALUE};
        maxPathHelper(root, ans);
        return ans[0];
    }
    private static int maxPathHelper(Node n, int[] ans) {
        if (n == null) return 0;
        int l = Math.max(maxPathHelper(n.left, ans), 0);
        int r = Math.max(maxPathHelper(n.right, ans), 0);
        ans[0] = Math.max(ans[0], n.val + l + r);
        return n.val + Math.max(l, r);
    }

    public static void main(String[] args) {

        Node root = buildSampleTree();

        // EXERCISE 1: Inorder traversal L→Root→R
        List<Integer> inord = new ArrayList<>();
        inOrder(root, inord);
        System.out.println("In-order:    " + inord);   // [4, 2, 5, 1, 3, 6]

        // EXERCISE 2: Preorder Root→L→R
        List<Integer> preord = new ArrayList<>();
        preOrder(root, preord);
        System.out.println("Pre-order:   " + preord);  // [1, 2, 4, 5, 3, 6]

        // EXERCISE 3: Postorder L→R→Root
        List<Integer> postord = new ArrayList<>();
        postOrder(root, postord);
        System.out.println("Post-order:  " + postord); // [4, 5, 2, 6, 3, 1]

        // EXERCISE 4: Level-order (BFS)
        System.out.println("Level-order: " + levelOrder(root));
        // [[1], [2, 3], [4, 5, 6]]

        // EXERCISE 5: Height and Size
        System.out.println("Height: " + height(root)); // 3
        System.out.println("Size:   " + size(root));   // 6

        // EXERCISE 6: Is balanced?
        System.out.println("Balanced: " + isBalanced(root)); // false (right subtree height 2, left 2 — actually true)

        // EXERCISE 7: Symmetric tree
        Node sym = new Node(1, new Node(2, new Node(3), new Node(4)),
                               new Node(2, new Node(4), new Node(3)));
        System.out.println("Symmetric: " + isSymmetric(sym));  // true
        System.out.println("Symmetric (original): " + isSymmetric(root)); // false

        // EXERCISE 8: Same tree
        Node t1 = new Node(1, new Node(2), new Node(3));
        Node t2 = new Node(1, new Node(2), new Node(3));
        System.out.println("Same tree: " + isSameTree(t1, t2)); // true

        // EXERCISE 9: Diameter
        System.out.println("Diameter: " + diameter(root)); // 4 (4→2→1→3→6)

        // EXERCISE 10: Max path sum
        Node pathTree = new Node(-10, new Node(9), new Node(20, new Node(15), new Node(7)));
        System.out.println("Max path sum: " + maxPathSum(pathTree)); // 42

        // EXERCISE 11: Iterative inorder (no recursion)
        Deque<Node> stack = new ArrayDeque<>();
        Node cur = root;
        System.out.print("Iterative in-order: ");
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) { stack.push(cur); cur = cur.left; }
            cur = stack.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        System.out.println();

        // EXERCISE 12: Right side view (last node of each level)
        System.out.print("Right side view: ");
        for (List<Integer> level : levelOrder(root))
            System.out.print(level.get(level.size()-1) + " ");
        System.out.println();

        // SUMMARY
        System.out.println("\n=== Binary Tree Complexity ===");
        System.out.println("Traversal (all)  O(n)");
        System.out.println("Height/Size      O(n)");
        System.out.println("Search (general) O(n)  — use BST for O(log n)");
    }
}
