package org.example.DataStructures.Tree.BinarySearchTree;

import java.util.*;

/**
 * ============================================================
 *          BST CHALLENGES — LeetCode Style
 * ============================================================
 */
public class BinarySearchTreeChallenge {

    static class Node {
        int val; Node left, right;
        Node(int v) { val=v; }
        Node(int v, Node l, Node r) { val=v; left=l; right=r; }
    }
    static Node n(int v) { return new Node(v); }
    static Node n(int v, Node l, Node r) { return new Node(v,l,r); }

    // =========================================================
    // CHALLENGE 1  [EASY]  — Search in BST
    // Return the subtree rooted at the node with value val, or null.
    // =========================================================
    static Node searchBST(Node root, int val) {
        // TODO
        return null;
    }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Insert into BST
    // Return the root of the modified tree.
    // =========================================================
    static Node insertIntoBST(Node root, int val) {
        // TODO
        return null;
    }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Validate BST
    // Return true if the tree is a valid BST.
    // =========================================================
    static boolean isValidBST(Node root) {
        // TODO
        return false;
    }

    // =========================================================
    // CHALLENGE 4  [EASY]  — Range Sum of BST
    // Return sum of values of nodes with val in [low, high].
    // Example: root=[10,5,15,3,7,null,18], low=7, high=15 → 32
    // =========================================================
    static int rangeSumBST(Node root, int low, int high) {
        // TODO
        return 0;
    }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Kth Smallest Element in BST
    // In-order traversal gives sorted order — stop at kth element.
    // Example: root=[3,1,4,null,2], k=1 → 1
    // =========================================================
    static int kthSmallest(Node root, int k) {
        // TODO
        return -1;
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Lowest Common Ancestor of BST
    // Use BST property: if both < root → go left, both > root → go right.
    // Example: root=[6,2,8,0,4,7,9], p=2, q=8 → 6
    //          p=2, q=4 → 2
    // =========================================================
    static Node lcaOfBST(Node root, Node p, Node q) {
        // TODO
        return null;
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Convert Sorted Array to BST
    // Build a HEIGHT-BALANCED BST from a sorted array.
    // Example: [-10,-3,0,5,9] → balanced BST (one valid answer: root=0)
    // =========================================================
    static Node sortedArrayToBST(int[] nums) {
        // TODO
        return null;
    }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Delete Node in BST
    // Return the root after deleting key.
    // =========================================================
    static Node deleteNode(Node root, int key) {
        // TODO
        return null;
    }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]  — Two Sum in BST
    // Return true if any two nodes sum to k.
    // Hint: in-order traversal → sorted list → two pointers
    // Example: root=[5,3,6,2,4,null,7], k=9 → true
    // =========================================================
    static boolean findTarget(Node root, int k) {
        // TODO
        return false;
    }

    // =========================================================
    // CHALLENGE 10  [HARD]  — BST to Greater Sum Tree
    // Replace each node's value with the sum of all greater values + itself.
    // Example: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
    //   → [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
    // Hint: reverse in-order traversal (R→Root→L), accumulate sum
    // =========================================================
    static Node bstToGst(Node root) {
        // TODO
        return null;
    }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // C1
        Node bst1 = n(4, n(2,n(1),n(3)), n(7));
        pass += check("C1a", searchBST(bst1,2) != null ? searchBST(bst1,2).val : -1, 2) ? 1:0;
        fail += check("C1a", searchBST(bst1,2) != null ? searchBST(bst1,2).val : -1, 2) ? 0:1;
        pass += check("C1b", searchBST(bst1,5), null) ? 1:0;
        fail += check("C1b", searchBST(bst1,5), null) ? 0:1;

        // C2
        Node bst2 = n(4, n(2,n(1),n(3)), n(7));
        Node ins = insertIntoBST(bst2, 5);
        pass += check("C2a", inOrder(ins).toString(), "[1, 2, 3, 4, 5, 7]") ? 1:0;
        fail += check("C2a", inOrder(ins).toString(), "[1, 2, 3, 4, 5, 7]") ? 0:1;

        // C3
        pass += check("C3a", isValidBST(n(2,n(1),n(3))),                                true)  ? 1:0;
        fail += check("C3a", isValidBST(n(2,n(1),n(3))),                                true)  ? 0:1;
        pass += check("C3b", isValidBST(n(5,n(1),n(4,n(3),n(6)))),                      false) ? 1:0;
        fail += check("C3b", isValidBST(n(5,n(1),n(4,n(3),n(6)))),                      false) ? 0:1;

        // C4
        Node bst4 = n(10, n(5,n(3),n(7)), n(15,null,n(18)));
        pass += check("C4a", rangeSumBST(bst4, 7, 15), 32) ? 1:0;
        fail += check("C4a", rangeSumBST(bst4, 7, 15), 32) ? 0:1;

        // C5
        Node bst5 = n(3, n(1,null,n(2)), n(4));
        pass += check("C5a", kthSmallest(bst5, 1), 1) ? 1:0; fail += check("C5a", kthSmallest(bst5,1), 1) ? 0:1;
        pass += check("C5b", kthSmallest(bst5, 3), 3) ? 1:0; fail += check("C5b", kthSmallest(bst5,3), 3) ? 0:1;

        // C6
        Node lca = n(6, n(2,n(0),n(4,n(3),n(5))), n(8,n(7),n(9)));
        pass += check("C6a", lcaOfBST(lca,lca.left,lca.right).val, 6) ? 1:0;
        fail += check("C6a", lcaOfBST(lca,lca.left,lca.right).val, 6) ? 0:1;
        pass += check("C6b", lcaOfBST(lca,lca.left,lca.left.right).val, 2) ? 1:0;
        fail += check("C6b", lcaOfBST(lca,lca.left,lca.left.right).val, 2) ? 0:1;

        // C7
        Node balanced = sortedArrayToBST(new int[]{-10,-3,0,5,9});
        pass += check("C7a", isValidBST(balanced), true) ? 1:0;
        fail += check("C7a", isValidBST(balanced), true) ? 0:1;

        // C8
        Node del = n(5, n(3,n(2),n(4)), n(6,null,n(7)));
        Node after = deleteNode(del, 3);
        pass += check("C8a", !inOrder(after).contains(3), true) ? 1:0;
        fail += check("C8a", !inOrder(after).contains(3), true) ? 0:1;

        // C9
        Node ft = n(5, n(3,n(2),n(4)), n(6,null,n(7)));
        pass += check("C9a", findTarget(ft, 9),  true)  ? 1:0; fail += check("C9a", findTarget(ft,9), true)  ? 0:1;
        pass += check("C9b", findTarget(ft, 28), false) ? 1:0; fail += check("C9b", findTarget(ft,28),false) ? 0:1;

        System.out.println("\n==============================");
        System.out.println("  RESULTS: " + pass + " passed, " + fail + " failed");
        System.out.println("==============================");
    }

    static List<Integer> inOrder(Node root) {
        List<Integer> r = new ArrayList<>();
        Deque<Node> st = new ArrayDeque<>();
        Node cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) { st.push(cur); cur = cur.left; }
            cur = st.pop(); r.add(cur.val); cur = cur.right;
        }
        return r;
    }
    private static boolean check(String n, Object got, Object exp) {
        boolean ok = String.valueOf(got).equals(String.valueOf(exp));
        System.out.printf("%-6s %s  (exp:%s | got:%s)%n", n, ok?"✔":"✘", exp, got);
        return ok;
    }
}
