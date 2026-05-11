package org.example.Basics.ControlFlow.Conditionals;

/**
 * ============================================================
 *       CONDITIONALS CHALLENGES — LeetCode Style
 * ============================================================
 */
public class ConditionalsChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — FizzBuzz
    // For multiples of 3 → "Fizz", 5 → "Buzz", both → "FizzBuzz", else number.
    // Example: n=3→"Fizz", n=5→"Buzz", n=15→"FizzBuzz", n=7→"7"
    // =========================================================
    static String fizzBuzz(int n) { return ""; /* TODO */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Palindrome Number
    // Return true if number reads the same forwards and backwards.
    // Example: 121→true, -121→false, 10→false
    // =========================================================
    static boolean isPalindrome(int x) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Sign of the Product of an Array
    // Return 1 if product is positive, -1 if negative, 0 if zero.
    // Example: [-1,-2,-3,4,3,2,1]→1, [1,5,0,2,-3]→0
    // =========================================================
    static int arraySign(int[] nums) { return 0; /* TODO: count negatives */ }

    // =========================================================
    // CHALLENGE 4  [EASY]  — Check if Number Is a Sum of Powers of Three
    // Return true if n can be written as sum of distinct powers of 3.
    // Example: 12→true (3+9), 91→true, 21→false
    // =========================================================
    static boolean checkPowersOfThree(int n) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 5  [EASY]  — Can Place Flowers
    // Flowerbed has 0s and 1s. Can we place n flowers without adjacent flowers?
    // Example: [1,0,0,0,1], n=1 → true
    // =========================================================
    static boolean canPlaceFlowers(int[] flowerbed, int n) { return false; /* TODO: greedy */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Compare Version Numbers
    // Compare version strings "1.01" vs "1.001". Return -1,0,1.
    // Example: "1.01","1.001"→0, "1.0","1.0.0"→0, "0.1","1.1"→-1
    // =========================================================
    static int compareVersion(String version1, String version2) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Largest Number At Least Twice of Others
    // If max is >= 2*every other element, return its index; else -1.
    // Example: [3,6,1,0]→1, [1,2,3,4]→-1
    // =========================================================
    static int dominantIndex(int[] nums) { return -1; /* TODO */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Score After Flipping Matrix
    // In a binary matrix, maximize sum by toggling rows/columns.
    // Return the max sum after toggle operations.
    // Example: [[0,0,1,1],[1,0,1,0],[1,1,0,0]] → 39
    // =========================================================
    static int matrixScore(int[][] grid) { return 0; /* TODO: greedy */ }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]  — Largest Divisible Subset
    // Find largest subset so every pair (a,b) satisfies a%b==0 or b%a==0.
    // Example: [1,2,3]→[1,2] or [1,3], [1,2,4,8]→[1,2,4,8]
    // =========================================================
    static java.util.List<Integer> largestDivisibleSubset(int[] nums) { return new java.util.ArrayList<>(); /* TODO: DP */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Jump Game III
    // From index i, can jump to i+arr[i] or i-arr[i]. Can we reach value 0?
    // Example: [4,2,3,0,3,1,2], start=5 → true
    // =========================================================
    static boolean canReach(int[] arr, int start) { return false; /* TODO: BFS/DFS */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", fizzBuzz(3),  "Fizz")    ? 1:0; fail += check("C1a", fizzBuzz(3),  "Fizz")    ? 0:1;
        pass += check("C1b", fizzBuzz(5),  "Buzz")    ? 1:0; fail += check("C1b", fizzBuzz(5),  "Buzz")    ? 0:1;
        pass += check("C1c", fizzBuzz(15), "FizzBuzz") ? 1:0; fail += check("C1c", fizzBuzz(15), "FizzBuzz") ? 0:1;
        pass += check("C1d", fizzBuzz(7),  "7")       ? 1:0; fail += check("C1d", fizzBuzz(7),  "7")       ? 0:1;

        pass += check("C2a", isPalindrome(121),  true)  ? 1:0; fail += check("C2a", isPalindrome(121),  true)  ? 0:1;
        pass += check("C2b", isPalindrome(-121), false) ? 1:0; fail += check("C2b", isPalindrome(-121), false) ? 0:1;
        pass += check("C2c", isPalindrome(10),   false) ? 1:0; fail += check("C2c", isPalindrome(10),   false) ? 0:1;

        pass += check("C3a", arraySign(new int[]{-1,-2,-3, 4,3,2,1}),  1) ? 1:0; fail += check("C3a", arraySign(new int[]{-1,-2,-3, 4,3,2,1}),  1) ? 0:1;
        pass += check("C3b", arraySign(new int[]{1,5,0,2,-3}),          0) ? 1:0; fail += check("C3b", arraySign(new int[]{1,5,0,2,-3}),          0) ? 0:1;

        pass += check("C4a", checkPowersOfThree(12),  true)  ? 1:0; fail += check("C4a", checkPowersOfThree(12),  true)  ? 0:1;
        pass += check("C4b", checkPowersOfThree(21),  false) ? 1:0; fail += check("C4b", checkPowersOfThree(21),  false) ? 0:1;
        pass += check("C4c", checkPowersOfThree(91),  true)  ? 1:0; fail += check("C4c", checkPowersOfThree(91),  true)  ? 0:1;

        pass += check("C5a", canPlaceFlowers(new int[]{1,0,0,0,1}, 1), true)  ? 1:0; fail += check("C5a", canPlaceFlowers(new int[]{1,0,0,0,1}, 1), true)  ? 0:1;
        pass += check("C5b", canPlaceFlowers(new int[]{1,0,0,0,1}, 2), false) ? 1:0; fail += check("C5b", canPlaceFlowers(new int[]{1,0,0,0,1}, 2), false) ? 0:1;

        pass += check("C6a", compareVersion("1.01","1.001"),  0)  ? 1:0; fail += check("C6a", compareVersion("1.01","1.001"),  0)  ? 0:1;
        pass += check("C6b", compareVersion("0.1","1.1"),    -1)  ? 1:0; fail += check("C6b", compareVersion("0.1","1.1"),    -1)  ? 0:1;
        pass += check("C6c", compareVersion("1.0.1","1"),     1)  ? 1:0; fail += check("C6c", compareVersion("1.0.1","1"),     1)  ? 0:1;

        pass += check("C7a", dominantIndex(new int[]{3,6,1,0}),  1)  ? 1:0; fail += check("C7a", dominantIndex(new int[]{3,6,1,0}),  1)  ? 0:1;
        pass += check("C7b", dominantIndex(new int[]{1,2,3,4}), -1)  ? 1:0; fail += check("C7b", dominantIndex(new int[]{1,2,3,4}), -1)  ? 0:1;

        pass += check("C10a", canReach(new int[]{4,2,3,0,3,1,2}, 5), true)  ? 1:0; fail += check("C10a", canReach(new int[]{4,2,3,0,3,1,2}, 5), true)  ? 0:1;
        pass += check("C10b", canReach(new int[]{3,0,2,1,2}, 2),     false) ? 1:0; fail += check("C10b", canReach(new int[]{3,0,2,1,2}, 2),     false) ? 0:1;

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
