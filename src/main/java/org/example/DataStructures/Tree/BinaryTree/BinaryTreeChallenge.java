package org.example.DataStructures.Tree.BinaryTree;

import java.util.*;

/**
 * ============================================================
 *         BINARY TREE CHALLENGES — LeetCode Style
 * ============================================================
 */
public class BinaryTreeChallenge {

    static class Node {
        int val; Node left, right;
        Node(int val) { this.val = val; }
        Node(int v, Node l, Node r) { val=v; left=l; right=r; }
    }

    static Node n(int v) { return new Node(v); }
    static Node n(int v, Node l, Node r) { return new Node(v,l,r); }

    // =========================================================
    // CHALLENGE 1  [EASY]  — Maximum Depth
    // Example: [3,9,20,null,null,15,7] → 3
    // =========================================================
    static int maxDepth(Node root) {
        // TODO
        return 0;
    }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Invert Binary Tree
    // Mirror every left/right pair.
    // Example:    4          4
    //            / \   →    / \
    //           2   7      7   2
    //          /\ /\      /\ /\
    //         1 3 6 9    9 6 3 1
    // =========================================================
    static Node invertTree(Node root) {
        // TODO
        return null;
    }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Symmetric Tree
    // Return true if tree is a mirror of itself.
    // =========================================================
    static boolean isSymmetric(Node root) {
        // TODO
        return false;
    }

    // =========================================================
    // CHALLENGE 4  [EASY]  — Path Sum
    // Return true if there is a root-to-leaf path summing to targetSum.
    // Example: root=[5,4,8,11,null,13,4,7,2,null,null,null,1], target=22 → true
    // =========================================================
    static boolean hasPathSum(Node root, int targetSum) {
        // TODO
        return false;
    }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Level Order Traversal
    // Return list of levels.
    // Example: [3,9,20,null,null,15,7] → [[3],[9,20],[15,7]]
    // =========================================================
    static List<List<Integer>> levelOrder(Node root) {
        // TODO
        return new ArrayList<>();
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Binary Tree Diameter
    // Longest path between any two nodes (may not pass through root).
    // Example: [1,2,3,4,5] → 3
    // =========================================================
    static int diameterOfBinaryTree(Node root) {
        // TODO
        return 0;
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Lowest Common Ancestor
    // Given two nodes p and q, find their LCA.
    // Example: root=[3,5,1,6,2,0,8], p=5, q=1 → 3
    //          p=5, q=4 → 5
    // =========================================================
    static Node lowestCommonAncestor(Node root, Node p, Node q) {
        // TODO
        return null;
    }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Binary Tree Right Side View
    // Return values visible from the right side.
    // Example: [1,2,3,null,5,null,4] → [1,3,4]
    // =========================================================
    static List<Integer> rightSideView(Node root) {
        // TODO
        return new ArrayList<>();
    }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Binary Tree Maximum Path Sum
    // Path can start/end at any node.
    // Example: [-10,9,20,null,null,15,7] → 42
    // =========================================================
    static int maxPathSum(Node root) {
        // TODO
        return 0;
    }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Serialize and Deserialize Binary Tree
    // Design encode/decode functions (pre-order with nulls).
    // =========================================================
    static String serialize(Node root) {
        // TODO
        return "";
    }

    static Node deserialize(String data) {
        // TODO
        return null;
    }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // C1 maxDepth
        pass += check("C1a", maxDepth(n(3,n(9),n(20,n(15),n(7)))), 3) ? 1:0;
        fail += check("C1a", maxDepth(n(3,n(9),n(20,n(15),n(7)))), 3) ? 0:1;

        // C2 invertTree
        Node inv = invertTree(n(4, n(2,n(1),n(3)), n(7,n(6),n(9))));
        List<Integer> invIn = new ArrayList<>();
        inorder(inv, invIn);
        pass += check("C2a", invIn.toString(), "[9, 7, 6, 4, 3, 2, 1]") ? 1:0;
        fail += check("C2a", invIn.toString(), "[9, 7, 6, 4, 3, 2, 1]") ? 0:1;

        // C3 isSymmetric
        Node sym = n(1, n(2,n(3),n(4)), n(2,n(4),n(3)));
        pass += check("C3a", isSymmetric(sym), true)  ? 1:0; fail += check("C3a", isSymmetric(sym), true)  ? 0:1;
        Node asym = n(1, n(2,null,n(3)), n(2,null,n(3)));
        pass += check("C3b", isSymmetric(asym), false) ? 1:0; fail += check("C3b", isSymmetric(asym), false) ? 0:1;

        // C4 hasPathSum
        Node ps = n(5, n(4,n(11,n(7),n(2)),null), n(8,n(13),n(4,null,n(1))));
        pass += check("C4a", hasPathSum(ps, 22), true)  ? 1:0; fail += check("C4a", hasPathSum(ps, 22), true)  ? 0:1;
        pass += check("C4b", hasPathSum(ps, 99), false) ? 1:0; fail += check("C4b", hasPathSum(ps, 99), false) ? 0:1;

        // C5 levelOrder
        List<List<Integer>> lo = levelOrder(n(3, n(9), n(20,n(15),n(7))));
        pass += check("C5a", lo.toString(), "[[3], [9, 20], [15, 7]]") ? 1:0;
        fail += check("C5a", lo.toString(), "[[3], [9, 20], [15, 7]]") ? 0:1;

        // C6 diameter
        pass += check("C6a", diameterOfBinaryTree(n(1,n(2,n(4),n(5)),n(3))), 3) ? 1:0;
        fail += check("C6a", diameterOfBinaryTree(n(1,n(2,n(4),n(5)),n(3))), 3) ? 0:1;

        // C7 LCA
        Node lcaRoot = n(3, n(5,n(6),n(2,n(7),n(4))), n(1,n(0),n(8)));
        Node p = lcaRoot.left, q = lcaRoot.right;
        pass += check("C7a", lowestCommonAncestor(lcaRoot,p,q).val, 3) ? 1:0;
        fail += check("C7a", lowestCommonAncestor(lcaRoot,p,q).val, 3) ? 0:1;
        Node q4 = lcaRoot.left.right.right;
        pass += check("C7b", lowestCommonAncestor(lcaRoot,p,q4).val, 5) ? 1:0;
        fail += check("C7b", lowestCommonAncestor(lcaRoot,p,q4).val, 5) ? 0:1;

        // C8 rightSideView
        pass += check("C8a", rightSideView(n(1,n(2,null,n(5)),n(3,null,n(4)))).toString(), "[1, 3, 4]") ? 1:0;
        fail += check("C8a", rightSideView(n(1,n(2,null,n(5)),n(3,null,n(4)))).toString(), "[1, 3, 4]") ? 0:1;

        // C9 maxPathSum
        pass += check("C9a", maxPathSum(n(-10,n(9),n(20,n(15),n(7)))), 42) ? 1:0;
        fail += check("C9a", maxPathSum(n(-10,n(9),n(20,n(15),n(7)))), 42) ? 0:1;

        // C10 serialize/deserialize
        Node orig = n(1,n(2),n(3,null,n(4)));
        String s = serialize(orig);
        List<Integer> origIn = new ArrayList<>(), deserIn = new ArrayList<>();
        inorder(orig, origIn); inorder(deserialize(s), deserIn);
        pass += check("C10a", deserIn.toString(), origIn.toString()) ? 1:0;
        fail += check("C10a", deserIn.toString(), origIn.toString()) ? 0:1;

        System.out.println("\n==============================");
        System.out.println("  RESULTS: " + pass + " passed, " + fail + " failed");
        System.out.println("==============================");
    }

    static void inorder(Node n, List<Integer> r) {
        if (n==null) return; inorder(n.left,r); r.add(n.val); inorder(n.right,r);
    }
    private static boolean check(String n, Object got, Object exp) {
        boolean ok = String.valueOf(got).equals(String.valueOf(exp));
        System.out.printf("%-6s %s  (exp:%s | got:%s)%n", n, ok?"✔":"✘", exp, got);
        return ok;
    }
}
