package org.example.Basics.Arrays;

/**
 * ============================================================
 *              JAVA ARRAYS — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS AN ARRAY?
 * -----------------
 * A fixed-size, ordered collection of elements of the SAME type.
 * Stored in contiguous memory — O(1) random access by index.
 *
 * DECLARATION & INITIALIZATION:
 * ------------------------------
 *   int[] arr = new int[5];           // default zeros
 *   int[] arr = {1, 2, 3, 4, 5};      // inline init
 *   int[] arr = new int[]{1,2,3};     // anonymous array
 *   String[] words = new String[3];   // reference types, null by default
 *
 * COMPLEXITY:
 * -----------
 *   Access  : O(1) — direct index
 *   Search  : O(n) — linear scan (unsorted) / O(log n) binary (sorted)
 *   Insert  : O(n) — shift elements right (fixed size = can't truly insert)
 *   Delete  : O(n) — shift elements left
 *   Append  : N/A  — fixed size (use ArrayList for dynamic)
 *
 * KEY PROPERTIES:
 * ---------------
 *   - arr.length   → size (NOT a method, it's a field)
 *   - 0-indexed    → valid indices [0 .. length-1]
 *   - Default vals → 0 (int), 0.0 (double), false (boolean), null (Object)
 *   - Multidimensional: int[][] matrix = new int[rows][cols]
 *
 * COMMON UTILITIES (java.util.Arrays):
 * -------------------------------------
 *   Arrays.sort(arr)              → O(n log n) dual-pivot quicksort
 *   Arrays.binarySearch(arr, key) → O(log n) — array must be sorted
 *   Arrays.fill(arr, val)         → fill all elements
 *   Arrays.copyOf(arr, newLen)    → copy with new length
 *   Arrays.copyOfRange(arr, f, t) → copy subarray [f, t)
 *   Arrays.equals(a, b)           → element-wise equality
 *   Arrays.toString(arr)          → "[1, 2, 3]"
 *   Arrays.deepToString(arr2D)    → for 2D arrays
 *
 * ============================================================
 */
public class Arrays {

    // ── 1. Basic array creation and access ───────────────────
    static void basics() {
        int[] nums = {10, 20, 30, 40, 50};
        System.out.println("Length: " + nums.length);        // 5
        System.out.println("First:  " + nums[0]);            // 10
        System.out.println("Last:   " + nums[nums.length-1]);// 50

        // Iterate with for-each
        System.out.print("All: ");
        for (int n : nums) System.out.print(n + " ");
        System.out.println();
    }

    // ── 2. Linear search O(n) ────────────────────────────────
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target) return i;
        return -1;
    }

    // ── 3. Reverse an array in-place O(n) ────────────────────
    static void reverse(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int tmp = arr[lo]; arr[lo] = arr[hi]; arr[hi] = tmp;
            lo++; hi--;
        }
    }

    // ── 4. Find max and min O(n) ─────────────────────────────
    static int[] minMax(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int x : arr) {
            if (x < min) min = x;
            if (x > max) max = x;
        }
        return new int[]{min, max};
    }

    // ── 5. Rotate array right by k positions O(n) ────────────
    // [1,2,3,4,5], k=2 → [4,5,1,2,3]
    static void rotateRight(int[] arr, int k) {
        int n = arr.length;
        k %= n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }
    static void reverse(int[] arr, int lo, int hi) {
        while (lo < hi) { int t=arr[lo];arr[lo]=arr[hi];arr[hi]=t; lo++;hi--; }
    }

    // ── 6. Remove duplicates from sorted array O(n) ──────────
    // Returns new length; modifies arr in-place
    static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;
        int k = 1;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] != arr[i-1]) arr[k++] = arr[i];
        return k;
    }

    // ── 7. Merge two sorted arrays O(m+n) ────────────────────
    static int[] mergeSorted(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length)
            res[k++] = a[i] <= b[j] ? a[i++] : b[j++];
        while (i < a.length) res[k++] = a[i++];
        while (j < b.length) res[k++] = b[j++];
        return res;
    }

    // ── 8. Prefix sum array — range sum O(1) after O(n) build ─
    static int[] prefixSum(int[] arr) {
        int[] prefix = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++)
            prefix[i+1] = prefix[i] + arr[i];
        return prefix;
    }
    // Range sum [l, r] inclusive using prefix
    static int rangeSum(int[] prefix, int l, int r) {
        return prefix[r+1] - prefix[l];
    }

    // ── 9. Two-dimensional arrays ─────────────────────────────
    static void matrixDemo() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        // Print row by row
        for (int[] row : matrix) System.out.println(java.util.Arrays.toString(row));

        // Transpose
        int n = matrix.length;
        int[][] transposed = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                transposed[j][i] = matrix[i][j];
        System.out.println("Transposed: " + java.util.Arrays.deepToString(transposed));
    }

    // ── 10. Kadane's Algorithm — max subarray O(n) ───────────
    static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    // ── 11. Dutch National Flag — 3-way partition O(n) ───────
    // Sort array with only 0s, 1s, 2s in one pass
    static void sortColors(int[] nums) {
        int lo = 0, mid = 0, hi = nums.length - 1;
        while (mid <= hi) {
            if      (nums[mid] == 0) { int t=nums[lo];nums[lo]=nums[mid];nums[mid]=t; lo++;mid++; }
            else if (nums[mid] == 1) { mid++; }
            else                     { int t=nums[mid];nums[mid]=nums[hi];nums[hi]=t; hi--; }
        }
    }

    // ── 12. Binary Search on sorted array O(log n) ───────────
    static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (arr[mid] == target) return mid;
            else if (arr[mid] <  target) lo = mid + 1;
            else                         hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        // 1. Basics
        basics();

        // 2. Linear search
        int[] nums = {5, 3, 8, 1, 9, 2};
        System.out.println("Search 9: index=" + linearSearch(nums, 9)); // 4

        // 3. Reverse
        int[] rev = {1, 2, 3, 4, 5};
        reverse(rev);
        System.out.println("Reversed: " + java.util.Arrays.toString(rev)); // [5,4,3,2,1]

        // 4. Min/Max
        int[] mm = minMax(nums);
        System.out.println("Min=" + mm[0] + " Max=" + mm[1]); // Min=1 Max=9

        // 5. Rotate right by 2
        int[] rot = {1, 2, 3, 4, 5};
        rotateRight(rot, 2);
        System.out.println("Rotated right 2: " + java.util.Arrays.toString(rot)); // [4,5,1,2,3]

        // 6. Remove duplicates
        int[] sorted = {1, 1, 2, 2, 3, 4, 4, 5};
        int len = removeDuplicates(sorted);
        System.out.println("After dedupe length=" + len); // 5

        // 7. Merge sorted
        int[] merged = mergeSorted(new int[]{1,3,5}, new int[]{2,4,6});
        System.out.println("Merged: " + java.util.Arrays.toString(merged)); // [1,2,3,4,5,6]

        // 8. Prefix sum
        int[] ps = prefixSum(new int[]{1, 2, 3, 4, 5});
        System.out.println("Range sum [1,3] = " + rangeSum(ps, 1, 3)); // 9 (2+3+4)

        // 9. Matrix
        matrixDemo();

        // 10. Kadane's max subarray
        System.out.println("Max subarray: " + maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})); // 6

        // 11. Sort colors
        int[] colors = {2,0,2,1,1,0};
        sortColors(colors);
        System.out.println("Sort colors: " + java.util.Arrays.toString(colors)); // [0,0,1,1,2,2]

        // 12. Binary search
        int[] bs = {1, 3, 5, 7, 9, 11};
        System.out.println("Binary search 7: " + binarySearch(bs, 7)); // 3

        // Arrays utility methods
        System.out.println("\n--- Arrays Utility ---");
        int[] utilArr = {5, 2, 8, 1, 9};
        java.util.Arrays.sort(utilArr);
        System.out.println("Sorted: " + java.util.Arrays.toString(utilArr));
        System.out.println("BinarySearch 8: " + java.util.Arrays.binarySearch(utilArr, 8));
        int[] copy = java.util.Arrays.copyOf(utilArr, 3);
        System.out.println("CopyOf(3): " + java.util.Arrays.toString(copy));
        int[] filled = new int[4];
        java.util.Arrays.fill(filled, 7);
        System.out.println("Filled with 7: " + java.util.Arrays.toString(filled));

        // Complexity summary
        System.out.println("\n=== Array Complexity ===");
        System.out.println("Access:  O(1)");
        System.out.println("Search:  O(n) unsorted / O(log n) sorted");
        System.out.println("Insert:  O(n) — must shift");
        System.out.println("Delete:  O(n) — must shift");
        System.out.println("Sort:    O(n log n)");
    }
}
