package org.example.Basics.Arrays;

import java.util.*;

/**
 * ============================================================
 *          ARRAYS CHALLENGES — LeetCode Style
 * ============================================================
 */
public class ArraysChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Two Sum
    // Return indices of two numbers that add up to target.
    // Example: [2,7,11,15], target=9 → [0,1]
    // =========================================================
    static int[] twoSum(int[] nums, int target) { return new int[]{}; /* TODO: HashMap O(n) */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Best Time to Buy and Sell Stock
    // Find max profit from one buy-sell. Return 0 if no profit.
    // Example: [7,1,5,3,6,4] → 5
    // =========================================================
    static int maxProfit(int[] prices) { return 0; /* TODO: track min price */ }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Contains Duplicate
    // Return true if any value appears at least twice.
    // Example: [1,2,3,1] → true
    // =========================================================
    static boolean containsDuplicate(int[] nums) { return false; /* TODO: HashSet */ }

    // =========================================================
    // CHALLENGE 4  [EASY]  — Move Zeroes
    // Move all 0s to end while maintaining relative order.
    // Example: [0,1,0,3,12] → [1,3,12,0,0]
    // =========================================================
    static void moveZeroes(int[] nums) { /* TODO: two pointers */ }

    // =========================================================
    // CHALLENGE 5  [EASY]  — Max Consecutive Ones
    // Find maximum number of consecutive 1s.
    // Example: [1,1,0,1,1,1] → 3
    // =========================================================
    static int findMaxConsecutiveOnes(int[] nums) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Product of Array Except Self
    // Return array where output[i] is product of all except nums[i].
    // No division, O(n), O(1) extra space.
    // Example: [1,2,3,4] → [24,12,8,6]
    // =========================================================
    static int[] productExceptSelf(int[] nums) { return new int[]{}; /* TODO: prefix/suffix products */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Maximum Subarray
    // Find contiguous subarray with largest sum.
    // Example: [-2,1,-3,4,-1,2,1,-5,4] → 6
    // =========================================================
    static int maxSubArray(int[] nums) { return 0; /* TODO: Kadane's O(n) */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Find the Duplicate Number
    // Array of n+1 integers in range [1,n]. Find the duplicate.
    // No extra space allowed.
    // Example: [1,3,4,2,2] → 2
    // =========================================================
    static int findDuplicate(int[] nums) { return 0; /* TODO: Floyd's cycle or binary search */ }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]  — 3Sum
    // Find all unique triplets that sum to zero.
    // Example: [-1,0,1,2,-1,-4] → [[-1,-1,2],[-1,0,1]]
    // =========================================================
    static List<List<Integer>> threeSum(int[] nums) { return new ArrayList<>(); /* TODO: sort + two pointers */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Trapping Rain Water
    // How much water can be trapped between the bars?
    // Example: [0,1,0,2,1,0,1,3,2,1,2,1] → 6
    // =========================================================
    static int trap(int[] height) { return 0; /* TODO: two pointers or prefix max */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", java.util.Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)), "[0, 1]") ? 1:0;
        fail += check("C1a", java.util.Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)), "[0, 1]") ? 0:1;
        pass += check("C1b", java.util.Arrays.toString(twoSum(new int[]{3,2,4}, 6)), "[1, 2]") ? 1:0;
        fail += check("C1b", java.util.Arrays.toString(twoSum(new int[]{3,2,4}, 6)), "[1, 2]") ? 0:1;

        pass += check("C2a", maxProfit(new int[]{7,1,5,3,6,4}), 5) ? 1:0;
        fail += check("C2a", maxProfit(new int[]{7,1,5,3,6,4}), 5) ? 0:1;
        pass += check("C2b", maxProfit(new int[]{7,6,4,3,1}),   0) ? 1:0;
        fail += check("C2b", maxProfit(new int[]{7,6,4,3,1}),   0) ? 0:1;

        pass += check("C3a", containsDuplicate(new int[]{1,2,3,1}), true)  ? 1:0;
        fail += check("C3a", containsDuplicate(new int[]{1,2,3,1}), true)  ? 0:1;
        pass += check("C3b", containsDuplicate(new int[]{1,2,3,4}), false) ? 1:0;
        fail += check("C3b", containsDuplicate(new int[]{1,2,3,4}), false) ? 0:1;

        int[] mz = {0,1,0,3,12};
        moveZeroes(mz);
        pass += check("C4a", java.util.Arrays.toString(mz), "[1, 3, 12, 0, 0]") ? 1:0;
        fail += check("C4a", java.util.Arrays.toString(mz), "[1, 3, 12, 0, 0]") ? 0:1;

        pass += check("C5a", findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}), 3) ? 1:0;
        fail += check("C5a", findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}), 3) ? 0:1;

        pass += check("C6a", java.util.Arrays.toString(productExceptSelf(new int[]{1,2,3,4})), "[24, 12, 8, 6]") ? 1:0;
        fail += check("C6a", java.util.Arrays.toString(productExceptSelf(new int[]{1,2,3,4})), "[24, 12, 8, 6]") ? 0:1;

        pass += check("C7a", maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}), 6) ? 1:0;
        fail += check("C7a", maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}), 6) ? 0:1;
        pass += check("C7b", maxSubArray(new int[]{1}), 1) ? 1:0;
        fail += check("C7b", maxSubArray(new int[]{1}), 1) ? 0:1;

        pass += check("C8a", findDuplicate(new int[]{1,3,4,2,2}), 2) ? 1:0;
        fail += check("C8a", findDuplicate(new int[]{1,3,4,2,2}), 2) ? 0:1;
        pass += check("C8b", findDuplicate(new int[]{3,1,3,4,2}), 3) ? 1:0;
        fail += check("C8b", findDuplicate(new int[]{3,1,3,4,2}), 3) ? 0:1;

        List<List<Integer>> ts = threeSum(new int[]{-1,0,1,2,-1,-4});
        Collections.sort(ts, (a,b) -> a.toString().compareTo(b.toString()));
        pass += check("C9a", ts.toString(), "[[-1, -1, 2], [-1, 0, 1]]") ? 1:0;
        fail += check("C9a", ts.toString(), "[[-1, -1, 2], [-1, 0, 1]]") ? 0:1;

        pass += check("C10a", trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}), 6) ? 1:0;
        fail += check("C10a", trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}), 6) ? 0:1;
        pass += check("C10b", trap(new int[]{4,2,0,3,2,5}),              9) ? 1:0;
        fail += check("C10b", trap(new int[]{4,2,0,3,2,5}),              9) ? 0:1;

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
