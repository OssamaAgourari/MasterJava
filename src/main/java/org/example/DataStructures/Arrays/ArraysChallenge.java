package org.example.DataStructures.Arrays;

/**
 * ============================================================
 *              ARRAYS CHALLENGES — LeetCode Style
 * ============================================================
 */
public class ArraysChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Find Max Element
    // Return the largest value in the array.
    // Example: [3,1,4,1,5,9] → 9
    // =========================================================
    static int findMax(int[] arr) {
        // TODO
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Reverse Array
    // Return a new array with elements in reverse order.
    // Example: [1,2,3,4,5] → [5,4,3,2,1]
    // =========================================================
    static int[] reverse(int[] arr) {
        // TODO
        return new int[0];
    }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Missing Number
    // Given array of n distinct numbers in range [0,n], return
    // the one number that is missing.
    // Example: [3,0,1] → 2
    // Hint: expected sum = n*(n+1)/2
    // =========================================================
    static int missingNumber(int[] nums) {
        // TODO
        return -1;
    }

    // =========================================================
    // CHALLENGE 4  [EASY]  — Move Zeros
    // Move all 0s to the end while maintaining relative order
    // of non-zero elements. Modify in-place.
    // Example: [0,1,0,3,12] → [1,3,12,0,0]
    // =========================================================
    static void moveZeros(int[] nums) {
        // TODO
    }

    // =========================================================
    // CHALLENGE 5  [EASY]  — Remove Duplicates (sorted)
    // Given a sorted array, remove duplicates in-place.
    // Return the new length. Elements beyond new length don't matter.
    // Example: [1,1,2,3,3] → length=3, array=[1,2,3,...]
    // =========================================================
    static int removeDuplicates(int[] nums) {
        // TODO
        return 0;
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Rotate Array
    // Rotate array to the right by k steps in-place.
    // Example: [1,2,3,4,5,6,7], k=3 → [5,6,7,1,2,3,4]
    // Hint: reverse trick in O(n) time, O(1) space
    // =========================================================
    static void rotate(int[] nums, int k) {
        int l = nums.length;
        for (int i = 0; i < k; i++) {
            int last = nums[l-1];
            for (int j = l-1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = last;
        }
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Two Sum
    // Given an array and a target, return indices of two numbers
    // that add up to target. Exactly one solution exists.
    // Example: [2,7,11,15], target=9 → [0,1]
    // Hint: use a HashMap for O(n) solution
    // =========================================================
    static int[] twoSum(int[] nums, int target) {
        // TODO
        return new int[0];
    }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Maximum Subarray (Kadane's)
    // Return the sum of the contiguous subarray with largest sum.
    // Example: [-2,1,-3,4,-1,2,1,-5,4] → 6  (subarray [4,-1,2,1])
    // =========================================================
    static int maxSubArray(int[] nums) {
        // TODO
        return Integer.MIN_VALUE;
    }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]  — Merge Sorted Arrays
    // Merge two sorted arrays into one sorted array.
    // Example: [1,3,5], [2,4,6] → [1,2,3,4,5,6]
    // =========================================================
    static int[] mergeSorted(int[] a, int[] b) {
        // TODO
        return new int[0];
    }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Product Except Self
    // Return array where output[i] = product of all elements
    // except nums[i]. No division. O(n) time, O(1) extra space.
    // Example: [1,2,3,4] → [24,12,8,6]
    // =========================================================
    static int[] productExceptSelf(int[] nums) {
        // TODO
        return new int[0];
    }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", findMax(new int[]{3,1,4,1,5,9}), 9)          ? 1:0; fail += check("C1a", findMax(new int[]{3,1,4,1,5,9}), 9)          ? 0:1;
        pass += check("C1b", findMax(new int[]{-3,-1,-4}),    -1)         ? 1:0; fail += check("C1b", findMax(new int[]{-3,-1,-4}),    -1)         ? 0:1;

        pass += checkArr("C2a", reverse(new int[]{1,2,3,4,5}), new int[]{5,4,3,2,1}) ? 1:0;
        fail += checkArr("C2a", reverse(new int[]{1,2,3,4,5}), new int[]{5,4,3,2,1}) ? 0:1;

        pass += check("C3a", missingNumber(new int[]{3,0,1}), 2) ? 1:0; fail += check("C3a", missingNumber(new int[]{3,0,1}), 2) ? 0:1;
        pass += check("C3b", missingNumber(new int[]{0,1}),   2) ? 1:0; fail += check("C3b", missingNumber(new int[]{0,1}),   2) ? 0:1;

        int[] mz = {0,1,0,3,12};
        moveZeros(mz);
        pass += checkArr("C4a", mz, new int[]{1,3,12,0,0}) ? 1:0; fail += checkArr("C4a", mz, new int[]{1,3,12,0,0}) ? 0:1;

        int[] rd = {1,1,2,3,3};
        int rdLen = removeDuplicates(rd);
        pass += check("C5a", rdLen, 3) ? 1:0; fail += check("C5a", rdLen, 3) ? 0:1;

        int[] rot = {1,2,3,4,5,6,7};
        rotate(rot, 3);
        pass += checkArr("C6a", rot, new int[]{5,6,7,1,2,3,4}) ? 1:0; fail += checkArr("C6a", rot, new int[]{5,6,7,1,2,3,4}) ? 0:1;

        pass += checkArr("C7a", twoSum(new int[]{2,7,11,15}, 9),  new int[]{0,1}) ? 1:0;
        fail += checkArr("C7a", twoSum(new int[]{2,7,11,15}, 9),  new int[]{0,1}) ? 0:1;
        pass += checkArr("C7b", twoSum(new int[]{3,2,4},     6),  new int[]{1,2}) ? 1:0;
        fail += checkArr("C7b", twoSum(new int[]{3,2,4},     6),  new int[]{1,2}) ? 0:1;

        pass += check("C8a", maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}), 6)  ? 1:0; fail += check("C8a", maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}), 6)  ? 0:1;
        pass += check("C8b", maxSubArray(new int[]{1}),                      1)  ? 1:0; fail += check("C8b", maxSubArray(new int[]{1}),                      1)  ? 0:1;

        pass += checkArr("C9a", mergeSorted(new int[]{1,3,5}, new int[]{2,4,6}), new int[]{1,2,3,4,5,6}) ? 1:0;
        fail += checkArr("C9a", mergeSorted(new int[]{1,3,5}, new int[]{2,4,6}), new int[]{1,2,3,4,5,6}) ? 0:1;

        pass += checkArr("C10a", productExceptSelf(new int[]{1,2,3,4}), new int[]{24,12,8,6}) ? 1:0;
        fail += checkArr("C10a", productExceptSelf(new int[]{1,2,3,4}), new int[]{24,12,8,6}) ? 0:1;

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
        boolean ok = java.util.Arrays.equals(got, exp);
        System.out.printf("%-6s %s  (exp:%s | got:%s)%n", n, ok?"✔":"✘",
                java.util.Arrays.toString(exp), java.util.Arrays.toString(got));
        return ok;
    }
}
