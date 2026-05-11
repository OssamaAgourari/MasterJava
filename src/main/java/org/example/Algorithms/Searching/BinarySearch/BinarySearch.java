package org.example.Algorithms.Searching.BinarySearch;

/**
 * ============================================================
 *              BINARY SEARCH — COMPLETE GUIDE
 * ============================================================
 *
 * HOW IT WORKS:
 * --------------
 * Works on SORTED arrays. Repeatedly halve the search space:
 *   1. Find mid = (lo + hi) / 2
 *   2. If target == arr[mid] → found!
 *   3. If target < arr[mid]  → search left half
 *   4. If target > arr[mid]  → search right half
 *   5. Repeat until lo > hi  → not found
 *
 * TIME COMPLEXITY:
 * -----------------
 *   Best:    O(1)      — target is at midpoint
 *   Average: O(log n)
 *   Worst:   O(log n)
 *
 * SPACE: O(1) iterative, O(log n) recursive
 *
 * REQUIREMENT: Array MUST be sorted
 *
 * COMMON VARIANTS:
 * -----------------
 *   1. Find exact element
 *   2. Find leftmost (first) occurrence
 *   3. Find rightmost (last) occurrence
 *   4. Find insertion position (lower bound)
 *   5. Find first element ≥ target (lower bound)
 *   6. Find first element > target (upper bound)
 *   7. Search in rotated sorted array
 *   8. Search in 2D sorted matrix
 *
 * TEMPLATE (memorize this):
 * --------------------------
 *   int lo = 0, hi = n - 1;
 *   while (lo <= hi) {
 *       int mid = lo + (hi - lo) / 2;  // avoids overflow!
 *       if      (arr[mid] == target) return mid;
 *       else if (arr[mid] <  target) lo = mid + 1;
 *       else                         hi = mid - 1;
 *   }
 *   return -1;
 *
 * ============================================================
 */
public class BinarySearch {

    // ── 1. Standard binary search ─────────────────────────────
    static int search(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;  // (lo+hi)/2 can overflow!
            if      (arr[mid] == target) return mid;
            else if (arr[mid] <  target) lo = mid + 1;
            else                         hi = mid - 1;
        }
        return -1;
    }

    // ── 2. Leftmost (first) occurrence ────────────────────────
    static int searchFirst(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1, result = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (arr[mid] == target) { result = mid; hi = mid - 1; } // keep going left
            else if (arr[mid] <  target) lo = mid + 1;
            else                         hi = mid - 1;
        }
        return result;
    }

    // ── 3. Rightmost (last) occurrence ────────────────────────
    static int searchLast(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1, result = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (arr[mid] == target) { result = mid; lo = mid + 1; } // keep going right
            else if (arr[mid] <  target) lo = mid + 1;
            else                         hi = mid - 1;
        }
        return result;
    }

    // ── 4. Lower bound: first index where arr[i] >= target ────
    static int lowerBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) lo = mid + 1;
            else                   hi = mid;
        }
        return lo; // insertion point
    }

    // ── 5. Upper bound: first index where arr[i] > target ─────
    static int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= target) lo = mid + 1;
            else                    hi = mid;
        }
        return lo;
    }

    // ── 6. Count occurrences ──────────────────────────────────
    static int countOccurrences(int[] arr, int target) {
        return upperBound(arr, target) - lowerBound(arr, target);
    }

    // ── 7. Search in rotated sorted array ─────────────────────
    // [4,5,6,7,0,1,2] rotated — still O(log n)
    static int searchRotated(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) return mid;
            if (arr[lo] <= arr[mid]) { // left half is sorted
                if (arr[lo] <= target && target < arr[mid]) hi = mid - 1;
                else                                        lo = mid + 1;
            } else {                   // right half is sorted
                if (arr[mid] < target && target <= arr[hi]) lo = mid + 1;
                else                                        hi = mid - 1;
            }
        }
        return -1;
    }

    // ── 8. Search in 2D sorted matrix ─────────────────────────
    // Each row sorted, row[i][last] < row[i+1][0]
    static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int val = matrix[mid/n][mid%n];
            if      (val == target) return true;
            else if (val <  target) lo = mid + 1;
            else                    hi = mid - 1;
        }
        return false;
    }

    // ── 9. Find peak element ──────────────────────────────────
    static int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid+1]) hi = mid;
            else                         lo = mid + 1;
        }
        return lo;
    }

    // ── 10. Sqrt (integer square root) ───────────────────────
    static int mySqrt(int x) {
        if (x == 0) return 0;
        int lo = 1, hi = x / 2 + 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if ((long)mid * mid <= x) lo = mid;
            else                      hi = mid - 1;
        }
        return lo;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        // EXERCISE 1: Standard search
        System.out.println("Search 7:  index=" + search(arr, 7));  // 3
        System.out.println("Search 8:  index=" + search(arr, 8));  // -1

        // EXERCISE 2: First/Last occurrence
        int[] dup = {1, 2, 2, 2, 3, 4, 4, 5};
        System.out.println("First 2: " + searchFirst(dup, 2)); // 1
        System.out.println("Last  2: " + searchLast(dup,  2)); // 3
        System.out.println("First 4: " + searchFirst(dup, 4)); // 5
        System.out.println("Last  4: " + searchLast(dup,  4)); // 6

        // EXERCISE 3: Count occurrences
        System.out.println("Count of 2: " + countOccurrences(dup, 2)); // 3
        System.out.println("Count of 4: " + countOccurrences(dup, 4)); // 2

        // EXERCISE 4: Lower/Upper bound
        int[] lb = {1, 3, 3, 3, 5, 7};
        System.out.println("lowerBound(3): " + lowerBound(lb, 3)); // 1
        System.out.println("upperBound(3): " + upperBound(lb, 3)); // 4

        // EXERCISE 5: Rotated array
        int[] rotated = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Rotated search 0: " + searchRotated(rotated, 0)); // 4
        System.out.println("Rotated search 6: " + searchRotated(rotated, 6)); // 2
        System.out.println("Rotated search 3: " + searchRotated(rotated, 3)); // -1

        // EXERCISE 6: 2D matrix
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println("Matrix search 3:  " + searchMatrix(matrix, 3));  // true
        System.out.println("Matrix search 13: " + searchMatrix(matrix, 13)); // false

        // EXERCISE 7: Peak element
        int[] peak = {1, 2, 3, 1};
        System.out.println("Peak index: " + findPeakElement(peak)); // 2

        // EXERCISE 8: Integer sqrt
        System.out.println("sqrt(8):  " + mySqrt(8));   // 2
        System.out.println("sqrt(9):  " + mySqrt(9));   // 3
        System.out.println("sqrt(16): " + mySqrt(16));  // 4

        // EXERCISE 9: Java's built-in binary search
        System.out.println("Arrays.binarySearch: " + java.util.Arrays.binarySearch(arr, 11)); // 5

        // SUMMARY
        System.out.println("\n=== Binary Search ===");
        System.out.println("Best:    O(1)");
        System.out.println("Avg/Worst: O(log n)");
        System.out.println("Requires: SORTED array");
        System.out.println("Overflow-safe mid: lo + (hi - lo) / 2");
    }
}
