package org.example.Algorithms.Sorting.Quick;

import java.util.*;

/**
 * ============================================================
 *         QUICK SORT / PARTITION CHALLENGES — LeetCode Style
 * ============================================================
 */
public class QuickChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Sort Colors (Dutch National Flag)
    // Given array with 0s, 1s, 2s, sort in-place in one pass.
    // Example: [2,0,2,1,1,0] → [0,0,1,1,2,2]
    // =========================================================
    static void sortColors(int[] nums) { /* TODO: 3-way partition */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Move Negatives to Left
    // Partition so all negatives are before positives.
    // (Order within each group doesn't matter.)
    // Example: [-3,1,-2,4,-1,5] → all negatives left
    // =========================================================
    static int[] moveNegatives(int[] nums) { /* TODO */ return nums; }

    // =========================================================
    // CHALLENGE 3  [MEDIUM]  — Kth Largest Element (QuickSelect)
    // Return kth largest without fully sorting.
    // Example: [3,2,1,5,6,4], k=2 → 5
    // =========================================================
    static int findKthLargest(int[] nums, int k) { return -1; /* TODO: QuickSelect O(n) avg */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Sort Array by Parity
    // All even numbers first, then all odd. Any order within groups.
    // Example: [3,1,2,4] → [2,4,3,1] or [4,2,1,3] etc.
    // =========================================================
    static int[] sortArrayByParity(int[] nums) { return nums; /* TODO: partition */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Wiggle Sort II
    // Reorder nums such that nums[0] < nums[1] > nums[2] < nums[3]...
    // Example: [1,5,1,1,6,4] → [1,6,1,5,1,4]
    // =========================================================
    static void wiggleSort(int[] nums) { /* TODO */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Partition Array According to Given Pivot
    // Reorder so: elements < pivot | pivot(s) | elements > pivot
    // Relative order of non-pivot elements must be preserved.
    // Example: [9,12,5,10,14,3,10], pivot=10 → [9,5,3,10,10,12,14]
    // =========================================================
    static int[] pivotArray(int[] nums, int pivot) { return nums; /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Minimum Difference Between Largest and Smallest
    // Sort the array, then find min(arr[n-1] - arr[0]) after removing
    // exactly 3 elements (can be from either end).
    // Example: [6,6,0,1,1,4,6] → 2
    // =========================================================
    static int minDifference(int[] nums) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 8  [HARD]  — Find K Closest Elements
    // Given sorted array, return k closest elements to x.
    // Return in sorted order.
    // Example: arr=[1,2,3,4,5], k=4, x=3 → [1,2,3,4]
    // =========================================================
    static List<Integer> findClosestElements(int[] arr, int k, int x) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Top K Frequent Elements (using partition)
    // Return k most frequent elements using QuickSelect on frequency.
    // Example: [1,1,1,2,2,3], k=2 → [1,2]
    // =========================================================
    static int[] topKFrequent(int[] nums, int k) { return new int[0]; /* TODO */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Median of Two Sorted Arrays
    // Find median of two sorted arrays in O(log(m+n)).
    // Example: [1,3], [2] → 2.0    [1,2], [3,4] → 2.5
    // =========================================================
    static double findMedianSortedArrays(int[] nums1, int[] nums2) { return 0.0; /* TODO */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        int[] sc = {2,0,2,1,1,0}; sortColors(sc);
        pass += checkArr("C1a", sc, new int[]{0,0,1,1,2,2}) ? 1:0; fail += checkArr("C1a", sc, new int[]{0,0,1,1,2,2}) ? 0:1;

        int[] mn = moveNegatives(new int[]{-3,1,-2,4,-1,5});
        int negCount = 0; for(int v:mn) if(v<0) negCount++;
        pass += check("C2a", negCount, 3) ? 1:0; fail += check("C2a", negCount, 3) ? 0:1;
        boolean allNegFirst = true;
        boolean seenPos = false;
        for (int v : mn) { if(v>0)seenPos=true; if(v<0&&seenPos){allNegFirst=false;break;} }
        pass += check("C2b", allNegFirst, true) ? 1:0; fail += check("C2b", allNegFirst, true) ? 0:1;

        pass += check("C3a", findKthLargest(new int[]{3,2,1,5,6,4}, 2), 5) ? 1:0;
        fail += check("C3a", findKthLargest(new int[]{3,2,1,5,6,4}, 2), 5) ? 0:1;
        pass += check("C3b", findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4), 4) ? 1:0;
        fail += check("C3b", findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4), 4) ? 0:1;

        int[] parity = sortArrayByParity(new int[]{3,1,2,4});
        boolean evenFirst = true;
        boolean seenOdd = false;
        for (int v : parity) { if(v%2!=0)seenOdd=true; if(v%2==0&&seenOdd){evenFirst=false;break;} }
        pass += check("C4a", evenFirst, true) ? 1:0; fail += check("C4a", evenFirst, true) ? 0:1;

        pass += check("C7a", minDifference(new int[]{6,6,0,1,1,4,6}), 2) ? 1:0;
        fail += check("C7a", minDifference(new int[]{6,6,0,1,1,4,6}), 2) ? 0:1;

        pass += check("C8a", findClosestElements(new int[]{1,2,3,4,5}, 4, 3).toString(), "[1, 2, 3, 4]") ? 1:0;
        fail += check("C8a", findClosestElements(new int[]{1,2,3,4,5}, 4, 3).toString(), "[1, 2, 3, 4]") ? 0:1;

        int[] tkf = topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        Arrays.sort(tkf);
        pass += check("C9a", Arrays.toString(tkf), "[1, 2]") ? 1:0;
        fail += check("C9a", Arrays.toString(tkf), "[1, 2]") ? 0:1;

        pass += check("C10a", findMedianSortedArrays(new int[]{1,3}, new int[]{2}),     2.0) ? 1:0;
        fail += check("C10a", findMedianSortedArrays(new int[]{1,3}, new int[]{2}),     2.0) ? 0:1;
        pass += check("C10b", findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}),   2.5) ? 1:0;
        fail += check("C10b", findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}),   2.5) ? 0:1;

        System.out.println("\n==============================");
        System.out.println("  RESULTS: " + pass + " passed, " + fail + " failed");
        System.out.println("==============================");
    }

    private static boolean check(String n, Object got, Object exp) {
        boolean ok = String.valueOf(got).equals(String.valueOf(exp));
        System.out.printf("%-6s %s  (exp:%s | got:%s)%n", n, ok?"✔":"✘", exp, got);
        return ok;
    }
    private static boolean checkArr(String n, int[] got, int[] exp) {
        boolean ok = Arrays.equals(got, exp);
        System.out.printf("%-6s %s  (exp:%s | got:%s)%n", n, ok?"✔":"✘",
                Arrays.toString(exp), Arrays.toString(got));
        return ok;
    }
}
