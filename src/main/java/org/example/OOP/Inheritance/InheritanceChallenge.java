package org.example.OOP.Inheritance;

import java.util.*;

/**
 * ============================================================
 *       INHERITANCE CHALLENGES — LeetCode Style
 * ============================================================
 */
public class InheritanceChallenge {

    // =========================================================
    // Node class used in several challenges
    // =========================================================
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode l, TreeNode r) { this.val=val; left=l; right=r; }
    }

    // =========================================================
    // CHALLENGE 1  [EASY]  — Invert Binary Tree
    // Mirror the tree.
    // =========================================================
    static TreeNode invertTree(TreeNode root) { return null; /* TODO */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Maximum Depth of Binary Tree
    // Return the maximum depth.
    // Example: [3,9,20,null,null,15,7] → 3
    // =========================================================
    static int maxDepth(TreeNode root) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Symmetric Tree
    // Is the tree a mirror of itself?
    // =========================================================
    static boolean isSymmetric(TreeNode root) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Validate Binary Search Tree
    // Return true if it's a valid BST.
    // =========================================================
    static boolean isValidBST(TreeNode root) { return false; /* TODO: min/max bounds */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Lowest Common Ancestor of BST
    // Find the LCA of two nodes in a BST.
    // =========================================================
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null; /* TODO */
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Construct Binary Tree from Preorder/Inorder
    // =========================================================
    static TreeNode buildTree(int[] preorder, int[] inorder) { return null; /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Flatten Binary Tree to Linked List
    // Flatten in-place to a right-skewed tree.
    // =========================================================
    static void flatten(TreeNode root) { /* TODO */ }

    // =========================================================
    // CHALLENGE 8  [HARD]  — Binary Tree Maximum Path Sum
    // Max path sum (path can start and end at any node).
    // Example: [-10,9,20,null,null,15,7] → 42 (15+20+7)
    // =========================================================
    static int maxPathSum(TreeNode root) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Serialize and Deserialize Binary Tree
    // =========================================================
    static String serialize(TreeNode root) { return ""; /* TODO: BFS */ }
    static TreeNode deserialize(String data) { return null; /* TODO */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Count Complete Tree Nodes
    // Count nodes in a complete binary tree in less than O(n).
    // =========================================================
    static int countNodes(TreeNode root) { return 0; /* TODO: O(log²n) */ }

    // Helpers
    static TreeNode build(Integer... vals) {
        if (vals.length == 0 || vals[0] == null) return null;
        TreeNode root = new TreeNode(vals[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for (int i = 1; i < vals.length; i += 2) {
            TreeNode n = q.poll();
            if (i < vals.length && vals[i] != null) { n.left = new TreeNode(vals[i]); q.offer(n.left); }
            if (i+1 < vals.length && vals[i+1] != null) { n.right = new TreeNode(vals[i+1]); q.offer(n.right); }
        }
        return root;
    }

    static String levelOrder(TreeNode root) {
        if (root == null) return "[]";
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            res.add(n.val);
            if (n.left != null) q.offer(n.left);
            if (n.right != null) q.offer(n.right);
        }
        return res.toString();
    }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // C1: Invert
        pass += check("C1a", levelOrder(invertTree(build(4,2,7,1,3,6,9))), "[4, 7, 2, 9, 6, 3, 1]") ? 1:0;
        fail += check("C1a", levelOrder(invertTree(build(4,2,7,1,3,6,9))), "[4, 7, 2, 9, 6, 3, 1]") ? 0:1;

        // C2: Max depth
        pass += check("C2a", maxDepth(build(3,9,20,null,null,15,7)), 3) ? 1:0;
        fail += check("C2a", maxDepth(build(3,9,20,null,null,15,7)), 3) ? 0:1;

        // C3: Symmetric
        pass += check("C3a", isSymmetric(build(1,2,2,3,4,4,3)), true)  ? 1:0;
        fail += check("C3a", isSymmetric(build(1,2,2,3,4,4,3)), true)  ? 0:1;
        pass += check("C3b", isSymmetric(build(1,2,2,null,3,null,3)), false) ? 1:0;
        fail += check("C3b", isSymmetric(build(1,2,2,null,3,null,3)), false) ? 0:1;

        // C4: Valid BST
        pass += check("C4a", isValidBST(build(2,1,3)), true)    ? 1:0;
        fail += check("C4a", isValidBST(build(2,1,3)), true)    ? 0:1;
        pass += check("C4b", isValidBST(build(5,1,4,null,null,3,6)), false) ? 1:0;
        fail += check("C4b", isValidBST(build(5,1,4,null,null,3,6)), false) ? 0:1;

        // C8: Max path sum
        pass += check("C8a", maxPathSum(build(-10,9,20,null,null,15,7)), 42) ? 1:0;
        fail += check("C8a", maxPathSum(build(-10,9,20,null,null,15,7)), 42) ? 0:1;

        // C10: Count nodes
        pass += check("C10a", countNodes(build(1,2,3,4,5,6)), 6) ? 1:0;
        fail += check("C10a", countNodes(build(1,2,3,4,5,6)), 6) ? 0:1;

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
