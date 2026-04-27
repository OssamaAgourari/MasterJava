package org.example.Algorithms.TwoPointers;

import java.util.*;

/**
 * ============================================================
 *             TWO POINTERS — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS TWO POINTERS?
 * ----------------------
 * A technique where two variables (pointers) traverse a data
 * structure simultaneously — usually from opposite ends or at
 * different speeds — to solve problems in O(n) instead of O(n²).
 *
 * PATTERNS:
 * ----------
 *   1. OPPOSITE ENDS (converging)
 *      lo = 0, hi = n-1; move inward
 *      Use: Two Sum (sorted), reverse, palindrome, container with water
 *
 *   2. SAME DIRECTION (fast/slow)
 *      slow and fast both start at 0
 *      Use: remove duplicates, cycle detection, Kth from end
 *
 *   3. MULTIPLE ARRAYS
 *      One pointer per array, advance the smaller one
 *      Use: merge sorted arrays, intersection
 *
 * TIME COMPLEXITY: O(n) — each element visited at most once
 * SPACE:           O(1) — no extra space (in-place)
 *
 * WHEN TO USE:
 * -------------
 *   ✔ Array/string is sorted (converging pointers)
 *   ✔ Finding pairs/triplets that satisfy a condition
 *   ✔ In-place modification (remove, compress)
 *   ✔ Palindrome checks
 *   ✔ Cycle detection (linked list)
 *
 * ============================================================
 */
public class TwoPointers {

    public static void main(String[] args) {

        // EXERCISE 1: Two Sum in sorted array — O(n)
        int[] sorted = {2, 7, 11, 15};
        int target = 9;
        int lo = 0, hi = sorted.length - 1;
        while (lo < hi) {
            int sum = sorted[lo] + sorted[hi];
            if      (sum == target) { System.out.println("Two Sum: [" + lo + "," + hi + "]"); break; }
            else if (sum <  target) lo++;
            else                    hi--;
        }

        // EXERCISE 2: Reverse array in-place
        int[] arr = {1, 2, 3, 4, 5};
        lo = 0; hi = arr.length - 1;
        while (lo < hi) { int t=arr[lo];arr[lo++]=arr[hi];arr[hi--]=t; }
        System.out.println("Reversed: " + Arrays.toString(arr)); // [5,4,3,2,1]

        // EXERCISE 3: Check palindrome string
        String s = "racecar";
        lo = 0; hi = s.length() - 1;
        boolean isPalin = true;
        while (lo < hi) { if (s.charAt(lo++)!=s.charAt(hi--)) { isPalin=false; break; } }
        System.out.println("Palindrome 'racecar': " + isPalin); // true

        // EXERCISE 4: Remove duplicates from sorted array (slow/fast)
        int[] dup = {1, 1, 2, 3, 3, 4};
        int slow = 0;
        for (int fast = 1; fast < dup.length; fast++) {
            if (dup[fast] != dup[slow]) dup[++slow] = dup[fast];
        }
        System.out.println("Remove dups length: " + (slow+1)); // 4 → [1,2,3,4]

        // EXERCISE 5: Three Sum — find all triplets summing to 0
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue; // skip duplicates
            lo = i+1; hi = nums.length-1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if      (sum == 0) { triplets.add(Arrays.asList(nums[i],nums[lo],nums[hi])); lo++; hi--; while(lo<hi&&nums[lo]==nums[lo-1])lo++; while(lo<hi&&nums[hi]==nums[hi+1])hi--; }
                else if (sum < 0)  lo++;
                else               hi--;
            }
        }
        System.out.println("Three Sum: " + triplets); // [[-1,-1,2],[-1,0,1]]

        // EXERCISE 6: Container with most water
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        lo = 0; hi = heights.length - 1;
        int maxWater = 0;
        while (lo < hi) {
            maxWater = Math.max(maxWater, (hi-lo) * Math.min(heights[lo], heights[hi]));
            if (heights[lo] < heights[hi]) lo++;
            else hi--;
        }
        System.out.println("Max water: " + maxWater); // 49

        // EXERCISE 7: Move zeros to end (slow/fast)
        int[] zeros = {0, 1, 0, 3, 12};
        slow = 0;
        for (int fast = 0; fast < zeros.length; fast++) {
            if (zeros[fast] != 0) zeros[slow++] = zeros[fast];
        }
        while (slow < zeros.length) zeros[slow++] = 0;
        System.out.println("Move zeros: " + Arrays.toString(zeros)); // [1,3,12,0,0]

        // EXERCISE 8: Merge two sorted arrays
        int[] a = {1, 3, 5, 7}, b = {2, 4, 6, 8};
        int[] merged = new int[a.length + b.length];
        int i=0, j=0, k=0;
        while (i<a.length && j<b.length) merged[k++] = a[i]<=b[j] ? a[i++] : b[j++];
        while (i<a.length) merged[k++]=a[i++];
        while (j<b.length) merged[k++]=b[j++];
        System.out.println("Merged: " + Arrays.toString(merged));

        // EXERCISE 9: Trap rainwater (two pointers)
        int[] h = {0,1,0,2,1,0,1,3,2,1,2,1};
        int left=0, right=h.length-1, lmax=0, rmax=0, water=0;
        while (left <= right) {
            if (h[left] <= h[right]) { lmax=Math.max(lmax,h[left]); water+=lmax-h[left]; left++; }
            else                      { rmax=Math.max(rmax,h[right]); water+=rmax-h[right]; right--; }
        }
        System.out.println("Trap rain water: " + water); // 6

        // EXERCISE 10: Longest subarray with sum ≤ k (sliding window variant)
        int[] sub = {1, 2, 3, 4, 5};
        int targetK = 7, sum = 0, maxLen = 0;
        lo = 0;
        for (int r = 0; r < sub.length; r++) {
            sum += sub[r];
            while (sum > targetK) sum -= sub[lo++];
            maxLen = Math.max(maxLen, r - lo + 1);
        }
        System.out.println("Max subarray len with sum ≤ 7: " + maxLen); // 3

        // SUMMARY
        System.out.println("\n=== Two Pointers ===");
        System.out.println("Opposite ends:   lo=0, hi=n-1, converge inward");
        System.out.println("Same direction:  slow + fast from index 0");
        System.out.println("Multiple arrays: one pointer per array");
        System.out.println("Time: O(n), Space: O(1)");
    }
}
