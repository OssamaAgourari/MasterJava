package org.example.Algorithms.Sorting.Insertion;

import java.util.*;

/**
 * ============================================================
 *       INSERTION SORT CHALLENGES — LeetCode Style
 * ============================================================
 */
public class InsertionChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Insertion Sort List (Linked List)
    // Sort linked list using insertion sort.
    // Example: 4→2→1→3 → 1→2→3→4
    // =========================================================
    static ListNode insertionSortList(ListNode head) { return null; /* TODO */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Sort Array Using Insertion Sort
    // Example: [5,2,4,6,1,3] → [1,2,3,4,5,6]
    // =========================================================
    static int[] sortArray(int[] nums) { return nums; /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Check if Array is Sorted and Rotated
    // Was array originally sorted and then rotated?
    // Example: [3,4,5,1,2]→true, [2,1,3,4]→false
    // =========================================================
    static boolean check(int[] nums) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Count Inversions
    // Number of pairs (i,j) i<j but nums[i]>nums[j].
    // Example: [2,4,1,3,5] → 3
    // =========================================================
    static int countInversions(int[] nums) { return 0; /* TODO: O(n²) with insertion sort */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Maximum Gap
    // After sorting, find maximum difference between successive elements.
    // Example: [3,6,9,1] → 3
    // =========================================================
    static int maximumGap(int[] nums) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Sort Nearly Sorted Array
    // Each element is at most k positions from its sorted position.
    // Example: [6,5,3,2,8,10,9], k=3 → [2,3,5,6,8,9,10]
    // Hint: insertion sort with window of size k+1 works in O(nk)
    // =========================================================
    static int[] sortNearlySorted(int[] nums, int k) { return nums; /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Search Insert Position
    // Find where target should be inserted in sorted array.
    // Example: [1,3,5,6], target=5→2, target=2→1, target=7→4
    // =========================================================
    static int searchInsert(int[] nums, int target) { return 0; /* TODO: binary search */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Insert Into a Sorted Circular Linked List
    // Insert val into a sorted circular list. Return any node.
    // =========================================================
    static ListNode insertIntoSortedCircular(ListNode head, int insertVal) { return null; /* TODO */ }

    // =========================================================
    // CHALLENGE 9  [HARD]  — H-Index
    // Find h: h papers with at least h citations.
    // Example: [3,0,6,1,5] → 3
    // =========================================================
    static int hIndex(int[] citations) { return 0; /* TODO: sort then count */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Minimum Number of Operations to Sort
    // Min operations to sort a 0-indexed array where one operation
    // moves an element to any position.
    // Example: [5,1,3] → 2
    // =========================================================
    static int minOperations(int[] nums) { return 0; /* TODO: LIS-based */ }

    static class ListNode {
        int val; ListNode next;
        ListNode(int v) { val = v; }
    }

    static ListNode makeList(int... vals) {
        ListNode dummy = new ListNode(0), cur = dummy;
        for (int v : vals) { cur.next = new ListNode(v); cur = cur.next; }
        return dummy.next;
    }
    static String listToStr(ListNode h) {
        StringBuilder sb = new StringBuilder("[");
        while (h != null) { sb.append(h.val); if(h.next!=null)sb.append(","); h=h.next; }
        return sb.append("]").toString();
    }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", listToStr(insertionSortList(makeList(4,2,1,3))), "[1,2,3,4]") ? 1:0;
        fail += check("C1a", listToStr(insertionSortList(makeList(4,2,1,3))), "[1,2,3,4]") ? 0:1;
        pass += check("C1b", listToStr(insertionSortList(makeList(-1,5,3,4,0))), "[-1,0,3,4,5]") ? 1:0;
        fail += check("C1b", listToStr(insertionSortList(makeList(-1,5,3,4,0))), "[-1,0,3,4,5]") ? 0:1;

        pass += check("C2a", Arrays.toString(sortArray(new int[]{5,2,4,6,1,3})), "[1, 2, 3, 4, 5, 6]") ? 1:0;
        fail += check("C2a", Arrays.toString(sortArray(new int[]{5,2,4,6,1,3})), "[1, 2, 3, 4, 5, 6]") ? 0:1;

        pass += check("C3a", check(new int[]{3,4,5,1,2}), true)  ? 1:0; fail += check("C3a", check(new int[]{3,4,5,1,2}), true)  ? 0:1;
        pass += check("C3b", check(new int[]{2,1,3,4}),   false) ? 1:0; fail += check("C3b", check(new int[]{2,1,3,4}),   false) ? 0:1;

        pass += check("C4a", countInversions(new int[]{2,4,1,3,5}), 3) ? 1:0;
        fail += check("C4a", countInversions(new int[]{2,4,1,3,5}), 3) ? 0:1;

        pass += check("C5a", maximumGap(new int[]{3,6,9,1}),   3) ? 1:0; fail += check("C5a", maximumGap(new int[]{3,6,9,1}),   3) ? 0:1;
        pass += check("C5b", maximumGap(new int[]{10}),        0) ? 1:0; fail += check("C5b", maximumGap(new int[]{10}),        0) ? 0:1;

        pass += check("C7a", searchInsert(new int[]{1,3,5,6}, 5), 2) ? 1:0; fail += check("C7a", searchInsert(new int[]{1,3,5,6}, 5), 2) ? 0:1;
        pass += check("C7b", searchInsert(new int[]{1,3,5,6}, 2), 1) ? 1:0; fail += check("C7b", searchInsert(new int[]{1,3,5,6}, 2), 1) ? 0:1;
        pass += check("C7c", searchInsert(new int[]{1,3,5,6}, 7), 4) ? 1:0; fail += check("C7c", searchInsert(new int[]{1,3,5,6}, 7), 4) ? 0:1;

        pass += check("C9a", hIndex(new int[]{3,0,6,1,5}), 3) ? 1:0; fail += check("C9a", hIndex(new int[]{3,0,6,1,5}), 3) ? 0:1;
        pass += check("C9b", hIndex(new int[]{1,3,1}),     1) ? 1:0; fail += check("C9b", hIndex(new int[]{1,3,1}),     1) ? 0:1;

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
