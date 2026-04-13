package org.example.DataStructures.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 *              ARRAYS — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS AN ARRAY?
 * ------------------
 * A fixed-size, contiguous block of memory holding elements of
 * the same type. Indexed from 0. Fastest random access structure.
 *
 * TIME COMPLEXITY:
 * -----------------
 *   Operation          | Average | Worst  | Notes
 *   -------------------|---------|--------|----------------------
 *   Access  arr[i]     | O(1)    | O(1)   | direct index math
 *   Search  (linear)   | O(n)    | O(n)   | unsorted array
 *   Search  (binary)   | O(logn) | O(logn)| sorted array only
 *   Insert  (at end)   | O(1)*   | O(n)   | *if space available
 *   Insert  (at i)     | O(n)    | O(n)   | shift right needed
 *   Delete  (at i)     | O(n)    | O(n)   | shift left needed
 *   Sort               | O(nlogn)| O(n²)  | depends on algorithm
 *
 * SPACE COMPLEXITY: O(n) total, O(1) auxiliary for operations
 *
 * DECLARATION SYNTAX:
 * --------------------
 *   int[]    arr = new int[5];          // default: all zeros
 *   int[]    arr = {1, 2, 3, 4, 5};    // inline initializer
 *   int[][]  matrix = new int[3][4];   // 2D array (3 rows, 4 cols)
 *   int[][]  matrix = {{1,2},{3,4}};   // 2D inline
 *
 * KEY PROPERTIES:
 * ----------------
 *   arr.length     → number of elements (field, not method)
 *   arr[0]         → first element
 *   arr[arr.length-1] → last element
 *   Arrays are objects — passed by reference
 *   Arrays.sort()  → in-place sort, O(n log n)
 *   Arrays.sort() changs the original array (yes / no ) : the answer is no
 * WHEN TO USE ARRAYS:
 * --------------------
 *   ✔ Need O(1) access by index
 *   ✔ Fixed size known at creation
 *   ✔ Cache-friendly iteration (contiguous memory)
 *   ✗ Frequent inserts/deletes in the middle → use LinkedList
 *   ✗ Unknown size → use ArrayList
 *
 * COMMON PATTERNS:
 * -----------------
 *   Two Pointers   — left/right converge to solve in O(n)
 *   Sliding Window — fixed/variable window for subarray problems
 *   Prefix Sum     — precompute cumulative sums for range queries
 *   Kadane's Algo  — max subarray sum in O(n)
 *   Dutch Flag     — 3-way partition in O(n)
 *
 * ============================================================
 */
public class Arrays {

    // ============================================================
    // MANUAL INSERT — shifts elements right, returns new array
    // ============================================================
    static int[] insertAt(int[] arr, int index, int value) {
        int[] result = new int[arr.length + 1];
        for (int i = 0; i < index; i++)       result[i] = arr[i];
        result[index] = value;
        for (int i = index; i < arr.length; i++) result[i + 1] = arr[i];
        return result;
    }

    // ============================================================
    // MANUAL DELETE — shifts elements left, returns new array
    // ============================================================
    static int[] deleteAt(int[] arr, int index) {
        int[] result = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) result[j++] = arr[i];
        }
        return result;
    }

    // ============================================================
    // LINEAR SEARCH — O(n)
    // ============================================================
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target) return i;
        return -1;
    }

    // ============================================================
    // BINARY SEARCH — O(log n), array must be sorted
    // ============================================================
    static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;  // avoid overflow
            if      (arr[mid] == target) return mid;
            else if (arr[mid] <  target) lo = mid + 1;
            else                         hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        // --------------------------------------------------------
        // EXERCISE 1: Declaration and initialization
        // --------------------------------------------------------
        int[] a = new int[5];               // [0, 0, 0, 0, 0]
        int[] b = {10, 20, 30, 40, 50};     // inline
        int[] c = java.util.Arrays.copyOf(b, b.length); // copy
        System.out.println("Length: " + b.length);
        System.out.println("b[0]=" + b[0] + ", b[4]=" + b[b.length-1]);

        // --------------------------------------------------------
        // EXERCISE 2: Access O(1) — direct index
        // --------------------------------------------------------
        System.out.println("Access b[2] = " + b[2]);  // 30 — O(1)
        b[2] = 99;
        System.out.println("After set b[2]=99: " + b[2]);

        // --------------------------------------------------------
        // EXERCISE 3: Linear search O(n)
        // --------------------------------------------------------
        int idx = linearSearch(b, 40);
        System.out.println("Linear search 40: index=" + idx);  // 3
        System.out.println("Linear search 77: index=" + linearSearch(b, 77)); // -1

        // --------------------------------------------------------
        // EXERCISE 4: Binary search O(log n) — sorted array
        // --------------------------------------------------------
        int[] sorted = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        System.out.println("Binary search 23: index=" + binarySearch(sorted, 23)); // 5
        System.out.println("Binary search 50: index=" + binarySearch(sorted, 50)); // -1
        // Java built-in:
        System.out.println("Arrays.binarySearch: " + java.util.Arrays.binarySearch(sorted, 72)); // 8

        // --------------------------------------------------------
        // EXERCISE 5: Insert at position O(n)
        // --------------------------------------------------------
        int[] original = {1, 2, 3, 4, 5};
        int[] inserted = insertAt(original, 2, 99);
        System.out.println("After insertAt(2, 99): " + java.util.Arrays.toString(inserted));
        // [1, 2, 99, 3, 4, 5]

        // --------------------------------------------------------
        // EXERCISE 6: Delete at position O(n)
        // --------------------------------------------------------
        int[] deleted = deleteAt(original, 2);
        System.out.println("After deleteAt(2): " + java.util.Arrays.toString(deleted));
        // [1, 2, 4, 5]

        // --------------------------------------------------------
        // EXERCISE 7: Sorting — Arrays.sort O(n log n)
        // --------------------------------------------------------
        int[] unsorted = {5, 2, 8, 1, 9, 3};
        java.util.Arrays.sort(unsorted);
        System.out.println("Sorted: " + java.util.Arrays.toString(unsorted));
        // [1, 2, 3, 5, 8, 9]

        // Sort a range: sort only indices [1, 4)
        int[] partial = {5, 3, 1, 4, 2, 9};
        java.util.Arrays.sort(partial, 1, 4);
        System.out.println("Partial sort [1,4): " + java.util.Arrays.toString(partial));
        // [5, 1, 3, 4, 2, 9]

        // --------------------------------------------------------
        // EXERCISE 8: Two Pointers — reverse in-place O(n)
        // --------------------------------------------------------
        int[] arr = {1, 2, 3, 4, 5};
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = tmp;
        }
        System.out.println("Reversed: " + java.util.Arrays.toString(arr));
        // [5, 4, 3, 2, 1]

        // --------------------------------------------------------
        // EXERCISE 9: Prefix Sum — range sum queries O(1) after O(n) build
        // --------------------------------------------------------
        int[] data = {3, 1, 4, 1, 5, 9, 2, 6};
        int[] prefix = new int[data.length + 1];  // prefix[i] = sum of data[0..i-1]
        for (int i = 0; i < data.length; i++)
            prefix[i + 1] = prefix[i] + data[i];
        // Sum of data[2..5] = prefix[6] - prefix[2]
        System.out.println("Prefix sum [2..5]: " + (prefix[6] - prefix[2])); // 19

        // --------------------------------------------------------
        // EXERCISE 10: Kadane's Algorithm — max subarray sum O(n)
        // --------------------------------------------------------
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = nums[0], current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            maxSum  = Math.max(maxSum, current);
        }
        System.out.println("Max subarray sum: " + maxSum); // 6

        // --------------------------------------------------------
        // EXERCISE 11: Sliding Window — max sum of k consecutive O(n)
        // --------------------------------------------------------
        int[] w = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int windowSum = 0;
        for (int i = 0; i < k; i++) windowSum += w[i];
        int maxWindow = windowSum;
        for (int i = k; i < w.length; i++) {
            windowSum += w[i] - w[i - k];
            maxWindow = Math.max(maxWindow, windowSum);
        }
        System.out.println("Max window sum (k=3): " + maxWindow); // 9

        // --------------------------------------------------------
        // EXERCISE 12: 2D Arrays (matrix)
        // --------------------------------------------------------
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Rows=" + matrix.length + ", Cols=" + matrix[0].length);
        // Traverse row-by-row (cache-friendly)
        for (int[] row : matrix) {
            System.out.println(java.util.Arrays.toString(row));
        }

        // --------------------------------------------------------
        // EXERCISE 13: Array rotation by k (using reversal trick)
        // --------------------------------------------------------
        int[] rot = {1, 2, 3, 4, 5, 6, 7};
        int rotK = 3;
        rotK %= rot.length;
        reverse(rot, 0, rot.length - 1);
        reverse(rot, 0, rotK - 1);
        reverse(rot, rotK, rot.length - 1);
        System.out.println("Rotated by 3: " + java.util.Arrays.toString(rot));
        // [5, 6, 7, 1, 2, 3, 4]

        // --------------------------------------------------------
        // EXERCISE 14: Dutch National Flag — 3-way partition O(n)
        // Sort array of 0s, 1s, 2s in one pass
        // --------------------------------------------------------
        int[] flags = {2, 0, 2, 1, 1, 0};
        int lo = 0, mid = 0, hi2 = flags.length - 1;
        while (mid <= hi2) {
            if      (flags[mid] == 0) swap(flags, lo++, mid++);
            else if (flags[mid] == 1) mid++;
            else                      swap(flags, mid, hi2--);
        }
        System.out.println("Dutch flag: " + java.util.Arrays.toString(flags));
        // [0, 0, 1, 1, 2, 2]

        // --------------------------------------------------------
        // EXERCISE 15: Dynamic array — ArrayList vs int[]
        // --------------------------------------------------------
        List<Integer> dynamic = new ArrayList<>();
        dynamic.add(10);
        dynamic.add(20);
        dynamic.add(30);
        dynamic.add(1, 15);          // insert at index 1 → O(n)
        dynamic.remove(Integer.valueOf(20)); // remove by value → O(n)
        System.out.println("ArrayList: " + dynamic); // [10, 15, 30]

        // --------------------------------------------------------
        // SUMMARY — time complexity
        // --------------------------------------------------------
        System.out.println("\n=== Array Time Complexity ===");
        System.out.println("Access   arr[i]     O(1)");
        System.out.println("Search   linear     O(n)");
        System.out.println("Search   binary     O(log n)  [sorted]");
        System.out.println("Insert   at end     O(1)");
        System.out.println("Insert   at i       O(n)      [shift]");
        System.out.println("Delete   at i       O(n)      [shift]");
        System.out.println("Sort                O(n log n)");
    }

    private static void reverse(int[] arr, int i, int j) {
        while (i < j) { int t = arr[i]; arr[i++] = arr[j]; arr[j--] = t; }
    }
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }
}
