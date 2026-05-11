package org.example.Algorithms.DivideAndConquer;

import java.util.*;

/**
 * ============================================================
 *           DIVIDE AND CONQUER — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS DIVIDE AND CONQUER?
 * ----------------------------
 * Split the problem into smaller sub-problems, solve them
 * independently (recursively), then combine their results.
 *
 * THREE STEPS:
 * -------------
 *   1. DIVIDE   — split problem into sub-problems
 *   2. CONQUER  — recursively solve each sub-problem
 *   3. COMBINE  — merge sub-solutions into the final answer
 *
 * KEY INSIGHT:
 *   Sub-problems must be INDEPENDENT (no overlap).
 *   If they overlap → use DP (memoization) instead.
 *
 * CLASSIC EXAMPLES:
 * ------------------
 *   Merge Sort      — split, sort halves, merge
 *   Quick Sort      — partition, sort halves
 *   Binary Search   — eliminate half at each step
 *   Strassen's Mult — matrix multiplication O(n^2.81)
 *   Closest Pair    — O(n log n) geometry
 *   FFT             — O(n log n) polynomial multiplication
 *   Max Subarray    — split, find cross-subarray
 *
 * RECURRENCE RELATIONS:
 * ----------------------
 *   Merge Sort:    T(n) = 2T(n/2) + O(n)    → O(n log n)
 *   Binary Search: T(n) = T(n/2) + O(1)     → O(log n)
 *   Power:         T(n) = T(n/2) + O(1)     → O(log n)
 *   Strassen:      T(n) = 7T(n/2) + O(n²)  → O(n^2.81)
 *
 * MASTER THEOREM: T(n) = aT(n/b) + O(n^d)
 *   If d > log_b(a): O(n^d)
 *   If d = log_b(a): O(n^d * log n)
 *   If d < log_b(a): O(n^log_b(a))
 *
 * ============================================================
 */
public class DivideAndConquer {

    // ── 1. Merge Sort ─────────────────────────────────────────
    static void mergeSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }
    static void merge(int[] arr, int lo, int mid, int hi) {
        int[] temp = Arrays.copyOfRange(arr, lo, hi + 1);
        int i = 0, j = mid - lo + 1, k = lo;
        while (i <= mid - lo && j <= hi - lo)
            arr[k++] = temp[i] <= temp[j] ? temp[i++] : temp[j++];
        while (i <= mid - lo) arr[k++] = temp[i++];
        while (j <= hi - lo)  arr[k++] = temp[j++];
    }

    // ── 2. Binary Search ──────────────────────────────────────
    static int binarySearch(int[] arr, int lo, int hi, int target) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] == target) return mid;
        return arr[mid] < target
            ? binarySearch(arr, mid + 1, hi, target)
            : binarySearch(arr, lo, mid - 1, target);
    }

    // ── 3. Fast Power: x^n in O(log n) ───────────────────────
    static double fastPower(double x, long n) {
        if (n == 0) return 1;
        if (n < 0)  return 1.0 / fastPower(x, -n);
        double half = fastPower(x, n / 2);
        return n % 2 == 0 ? half * half : x * half * half;
    }

    // ── 4. Maximum Subarray (D&C version) ────────────────────
    // O(n log n) — Kadane's is O(n), but this shows D&C pattern
    static int maxSubArray(int[] nums, int lo, int hi) {
        if (lo == hi) return nums[lo];
        int mid = lo + (hi - lo) / 2;
        int leftMax  = maxSubArray(nums, lo, mid);
        int rightMax = maxSubArray(nums, mid + 1, hi);
        int crossMax = maxCrossing(nums, lo, mid, hi);
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }
    static int maxCrossing(int[] nums, int lo, int mid, int hi) {
        int sum = 0, leftSum = Integer.MIN_VALUE;
        for (int i = mid; i >= lo; i--)  { sum += nums[i]; leftSum  = Math.max(leftSum, sum); }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid+1; i <= hi; i++) { sum += nums[i]; rightSum = Math.max(rightSum, sum); }
        return leftSum + rightSum;
    }

    // ── 5. Count Inversions (modified merge sort) ─────────────
    static long countInversions(int[] arr) {
        if (arr.length <= 1) return 0;
        int[] temp = new int[arr.length];
        return mergeCount(arr, temp, 0, arr.length - 1);
    }
    static long mergeCount(int[] arr, int[] temp, int lo, int hi) {
        if (lo >= hi) return 0;
        int mid = lo + (hi - lo) / 2;
        long count = mergeCount(arr, temp, lo, mid)
                   + mergeCount(arr, temp, mid + 1, hi);
        // merge and count cross-inversions
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else { count += (mid - i + 1); temp[k++] = arr[j++]; }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= hi)  temp[k++] = arr[j++];
        System.arraycopy(temp, lo, arr, lo, hi - lo + 1);
        return count;
    }

    // ── 6. Closest Pair of Points ─────────────────────────────
    // O(n log n)
    static double closestPair(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]); // sort by x
        return closestRec(points, 0, points.length - 1);
    }
    static double closestRec(int[][] pts, int lo, int hi) {
        if (hi - lo < 3) { // brute force for small sets
            double min = Double.MAX_VALUE;
            for (int i = lo; i <= hi; i++)
                for (int j = i + 1; j <= hi; j++)
                    min = Math.min(min, dist(pts[i], pts[j]));
            Arrays.sort(pts, lo, hi + 1, (a, b) -> a[1] - b[1]);
            return min;
        }
        int mid = lo + (hi - lo) / 2;
        int midX = pts[mid][0];
        double d = Math.min(closestRec(pts, lo, mid), closestRec(pts, mid + 1, hi));
        // merge by y (both halves already sorted by y after recursive calls)
        int[] merged = new int[(hi - lo + 1) * 2];
        // collect strip
        List<int[]> strip = new ArrayList<>();
        for (int i = lo; i <= hi; i++)
            if (Math.abs(pts[i][0] - midX) < d) strip.add(pts[i]);
        strip.sort((a, b) -> a[1] - b[1]);
        for (int i = 0; i < strip.size(); i++)
            for (int j = i + 1; j < strip.size() && strip.get(j)[1] - strip.get(i)[1] < d; j++)
                d = Math.min(d, dist(strip.get(i), strip.get(j)));
        return d;
    }
    static double dist(int[] a, int[] b) {
        double dx = a[0]-b[0], dy = a[1]-b[1];
        return Math.sqrt(dx*dx + dy*dy);
    }

    // ── 7. Matrix Multiplication (Strassen idea — simplified) ─
    // Standard: O(n³). Strassen: O(n^2.81). Demo: 2x2 case.
    static int[][] matMul(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int k = 0; k < n; k++)
                for (int j = 0; j < n; j++)
                    C[i][j] += A[i][k] * B[k][j];
        return C;
    }

    // ── 8. Quick Select ───────────────────────────────────────
    static int quickSelect(int[] arr, int lo, int hi, int k) {
        if (lo == hi) return arr[lo];
        int pivot = arr[hi], i = lo - 1;
        for (int j = lo; j < hi; j++)
            if (arr[j] <= pivot) { i++; int t=arr[i];arr[i]=arr[j];arr[j]=t; }
        int t=arr[i+1]; arr[i+1]=arr[hi]; arr[hi]=t;
        int p = i + 1;
        if      (p == k) return arr[p];
        else if (p <  k) return quickSelect(arr, p + 1, hi, k);
        else             return quickSelect(arr, lo, p - 1, k);
    }

    public static void main(String[] args) {

        // EXERCISE 1: Merge Sort
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Before merge sort: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("After  merge sort: " + Arrays.toString(arr));

        // EXERCISE 2: Binary Search
        int idx = binarySearch(arr, 0, arr.length - 1, 27);
        System.out.println("Binary search 27: index=" + idx);

        // EXERCISE 3: Fast Power
        System.out.printf("2^10 = %.0f%n", fastPower(2, 10));   // 1024
        System.out.printf("3^5  = %.0f%n", fastPower(3, 5));    // 243

        // EXERCISE 4: Max Subarray (D&C)
        int[] sub = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max subarray: " + maxSubArray(sub, 0, sub.length - 1)); // 6

        // EXERCISE 5: Count Inversions
        System.out.println("Inversions [2,4,1,3,5]: " + countInversions(new int[]{2,4,1,3,5})); // 3
        System.out.println("Inversions [5,4,3,2,1]: " + countInversions(new int[]{5,4,3,2,1})); // 10

        // EXERCISE 6: Closest Pair
        int[][] pts = {{2,3},{12,30},{40,50},{5,1},{12,10},{3,4}};
        System.out.printf("Closest pair distance: %.4f%n", closestPair(pts)); // ~1.414

        // EXERCISE 7: Quick Select (kth smallest)
        int[] nums = {7, 10, 4, 3, 20, 15};
        System.out.println("3rd smallest: " + quickSelect(nums.clone(), 0, nums.length-1, 2)); // 7

        // EXERCISE 8: Matrix multiplication
        int[][] A = {{1,2},{3,4}}, B = {{5,6},{7,8}};
        int[][] C = matMul(A, B);
        System.out.println("Matrix mul: " + Arrays.deepToString(C)); // [[19,22],[43,50]]

        // SUMMARY
        System.out.println("\n=== Divide and Conquer ===");
        System.out.println("Pattern: DIVIDE → CONQUER → COMBINE");
        System.out.println("Sub-problems must be INDEPENDENT (no overlap → else use DP)");
        System.out.println("Merge Sort:   T(n) = 2T(n/2) + O(n)  → O(n log n)");
        System.out.println("Binary Search:T(n) = T(n/2)  + O(1)  → O(log n)");
        System.out.println("Fast Power:   T(n) = T(n/2)  + O(1)  → O(log n)");
    }
}
