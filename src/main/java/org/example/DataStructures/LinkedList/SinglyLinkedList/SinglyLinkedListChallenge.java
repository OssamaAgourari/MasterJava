package org.example.DataStructures.LinkedList.SinglyLinkedList;

/**
 * ============================================================
 *       SINGLY LINKED LIST CHALLENGES — LeetCode Style
 * ============================================================
 */
public class SinglyLinkedListChallenge {

    static class Node {
        int val; Node next;
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    // helper: build list from array
    static Node build(int... vals) {
        Node dummy = new Node(0), cur = dummy;
        for (int v : vals) { cur.next = new Node(v); cur = cur.next; }
        return dummy.next;
    }
    // helper: list to string
    static String str(Node head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) { sb.append(head.val); if (head.next != null) sb.append(","); head = head.next; }
        return sb.append("]").toString();
    }

    // =========================================================
    // CHALLENGE 1  [EASY]  — Reverse Linked List
    // Example: 1→2→3→4→5 → 5→4→3→2→1
    // =========================================================
    static Node reverseList(Node head) {
        // TODO
        return null;
    }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Find Middle Node
    // For even length, return the second middle.
    // Example: 1→2→3→4→5 → node(3)
    //          1→2→3→4   → node(3)
    // =========================================================
    static Node middleNode(Node head) {
        // TODO
        return null;
    }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Merge Two Sorted Lists
    // Example: 1→2→4, 1→3→4 → 1→1→2→3→4→4
    // =========================================================
    static Node mergeTwoLists(Node l1, Node l2) {
        // TODO
        return null;
    }

    // =========================================================
    // CHALLENGE 4  [EASY]  — Remove Duplicates from Sorted List
    // Example: 1→1→2→3→3 → 1→2→3
    // =========================================================
    static Node deleteDuplicates(Node head) {
        // TODO
        return null;
    }

    // =========================================================
    // CHALLENGE 5  [EASY]  — Linked List Cycle Detection
    // Return true if the list has a cycle.
    // Hint: Floyd's slow/fast pointers
    // =========================================================
    static boolean hasCycle(Node head) {
        // TODO
        return false;
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Remove Nth Node From End
    // Example: 1→2→3→4→5, n=2 → 1→2→3→5
    // =========================================================
    static Node removeNthFromEnd(Node head, int n) {
        // TODO
        return null;
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Palindrome Linked List
    // Return true if the list is a palindrome.
    // Example: 1→2→2→1 → true
    //          1→2→3   → false
    // =========================================================
    static boolean isPalindrome(Node head) {
        // TODO
        return false;
    }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Add Two Numbers
    // Two non-empty lists represent non-negative integers in
    // reverse order. Return their sum as a list.
    // Example: (2→4→3) + (5→6→4) = 342 + 465 = 807 → 7→0→8
    // =========================================================
    static Node addTwoNumbers(Node l1, Node l2) {
        // TODO
        return null;
    }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]  — Reorder List
    // Given L0→L1→…→Ln, reorder to L0→Ln→L1→Ln-1→L2→Ln-2→…
    // Example: 1→2→3→4   → 1→4→2→3
    //          1→2→3→4→5 → 1→5→2→4→3
    // =========================================================
    static Node reorderList(Node head) {
        // TODO
        return null;
    }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Reverse Nodes in k-Group
    // Reverse the nodes in groups of k at a time.
    // Example: 1→2→3→4→5, k=2 → 2→1→4→3→5
    //          1→2→3→4→5, k=3 → 3→2→1→4→5
    // =========================================================
    static Node reverseKGroup(Node head, int k) {
        // TODO
        return null;
    }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // C1
        pass += check("C1a", str(reverseList(build(1,2,3,4,5))), "[5,4,3,2,1]") ? 1:0;
        fail += check("C1a", str(reverseList(build(1,2,3,4,5))), "[5,4,3,2,1]") ? 0:1;

        // C2
        pass += check("C2a", middleNode(build(1,2,3,4,5)) != null ? middleNode(build(1,2,3,4,5)).val : -1, 3) ? 1:0;
        fail += check("C2a", middleNode(build(1,2,3,4,5)) != null ? middleNode(build(1,2,3,4,5)).val : -1, 3) ? 0:1;
        pass += check("C2b", middleNode(build(1,2,3,4))   != null ? middleNode(build(1,2,3,4)).val   : -1, 3) ? 1:0;
        fail += check("C2b", middleNode(build(1,2,3,4))   != null ? middleNode(build(1,2,3,4)).val   : -1, 3) ? 0:1;

        // C3
        pass += check("C3a", str(mergeTwoLists(build(1,2,4), build(1,3,4))), "[1,1,2,3,4,4]") ? 1:0;
        fail += check("C3a", str(mergeTwoLists(build(1,2,4), build(1,3,4))), "[1,1,2,3,4,4]") ? 0:1;

        // C4
        pass += check("C4a", str(deleteDuplicates(build(1,1,2,3,3))), "[1,2,3]") ? 1:0;
        fail += check("C4a", str(deleteDuplicates(build(1,1,2,3,3))), "[1,2,3]") ? 0:1;

        // C5 — no cycle
        pass += check("C5a", hasCycle(build(1,2,3)), false) ? 1:0;
        fail += check("C5a", hasCycle(build(1,2,3)), false) ? 0:1;

        // C6
        pass += check("C6a", str(removeNthFromEnd(build(1,2,3,4,5), 2)), "[1,2,3,5]") ? 1:0;
        fail += check("C6a", str(removeNthFromEnd(build(1,2,3,4,5), 2)), "[1,2,3,5]") ? 0:1;

        // C7
        pass += check("C7a", isPalindrome(build(1,2,2,1)), true)  ? 1:0; fail += check("C7a", isPalindrome(build(1,2,2,1)), true)  ? 0:1;
        pass += check("C7b", isPalindrome(build(1,2,3)),   false) ? 1:0; fail += check("C7b", isPalindrome(build(1,2,3)),   false) ? 0:1;

        // C8
        pass += check("C8a", str(addTwoNumbers(build(2,4,3), build(5,6,4))), "[7,0,8]") ? 1:0;
        fail += check("C8a", str(addTwoNumbers(build(2,4,3), build(5,6,4))), "[7,0,8]") ? 0:1;

        // C9
        pass += check("C9a", str(reorderList(build(1,2,3,4))),   "[1,4,2,3]")   ? 1:0;
        fail += check("C9a", str(reorderList(build(1,2,3,4))),   "[1,4,2,3]")   ? 0:1;
        pass += check("C9b", str(reorderList(build(1,2,3,4,5))), "[1,5,2,4,3]") ? 1:0;
        fail += check("C9b", str(reorderList(build(1,2,3,4,5))), "[1,5,2,4,3]") ? 0:1;

        // C10
        pass += check("C10a", str(reverseKGroup(build(1,2,3,4,5), 2)), "[2,1,4,3,5]") ? 1:0;
        fail += check("C10a", str(reverseKGroup(build(1,2,3,4,5), 2)), "[2,1,4,3,5]") ? 0:1;
        pass += check("C10b", str(reverseKGroup(build(1,2,3,4,5), 3)), "[3,2,1,4,5]") ? 1:0;
        fail += check("C10b", str(reverseKGroup(build(1,2,3,4,5), 3)), "[3,2,1,4,5]") ? 0:1;

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
