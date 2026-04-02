package org.example.Basics.VariablesAndDataTypes.Booleans;

/**
 * ============================================================
 *            BOOLEAN CHALLENGES  — LeetCode Style
 * ============================================================
 * Difficulty scale:
 *   [EASY]    — straightforward, one concept
 *   [MEDIUM]  — requires combining multiple ideas
 *   [HARD]    — tricky logic or optimization needed
 *
 * How to use:
 *   1. Read the problem and examples carefully.
 *   2. Write your solution inside the method body.
 *   3. Run main() — all tests print PASS or FAIL automatically.
 * ============================================================
 */
public class BooleanChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]
    // =========================================================
    // Is Even?
    //
    // Return true if n is even, false if odd.
    //
    // Example:
    //   Input: 4   → true
    //   Input: 7   → false
    //   Input: 0   → true
    //   Input: -3  → false
    // =========================================================
    static boolean isEven(int n) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 2  [EASY]
    // =========================================================
    // Is in Range?
    //
    // Return true if value is within [min, max] (inclusive).
    //
    // Example:
    //   Input: 5, 1, 10  → true
    //   Input: 0, 1, 10  → false
    //   Input: 10, 1, 10 → true
    // =========================================================
    static boolean isInRange(int value, int min, int max) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 3  [EASY]
    // =========================================================
    // Is Leap Year?
    //
    // Return true if the year is a leap year.
    // Rules:
    //   - Divisible by 4 AND
    //   - NOT divisible by 100, UNLESS also divisible by 400
    //
    // Example:
    //   Input: 2000 → true   (divisible by 400)
    //   Input: 1900 → false  (divisible by 100 but not 400)
    //   Input: 2024 → true   (divisible by 4, not by 100)
    //   Input: 2023 → false
    // =========================================================
    static boolean isLeapYear(int year) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 4  [EASY]
    // =========================================================
    // Can Vote?
    //
    // A person can vote if they are 18 or older AND have a valid ID.
    // Return true if both conditions are met.
    //
    // Example:
    //   Input: 20, true   → true
    //   Input: 17, true   → false
    //   Input: 20, false  → false
    //   Input: 17, false  → false
    // =========================================================
    static boolean canVote(int age, boolean hasId) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 5  [EASY]
    // =========================================================
    // Is Valid Password?
    //
    // A password is valid if it meets ALL of these:
    //   - At least 8 characters long
    //   - Contains at least one uppercase letter
    //   - Contains at least one digit
    //
    // Example:
    //   Input: "Secure1!"   → true
    //   Input: "secure1!"   → false  (no uppercase)
    //   Input: "SECURE!"    → false  (no digit)
    //   Input: "Sec1"       → false  (too short)
    // =========================================================
    static boolean isValidPassword(String password) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]
    // =========================================================
    // Is Valid Triangle?
    //
    // Return true if three sides can form a valid triangle.
    // Rule: the sum of any two sides must be greater than the third.
    //
    // Example:
    //   Input: 3, 4, 5   → true
    //   Input: 1, 2, 3   → false  (1+2 is not > 3)
    //   Input: 5, 5, 5   → true
    //   Input: 0, 1, 1   → false
    // =========================================================
    static boolean isValidTriangle(int a, int b, int c) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]
    // =========================================================
    // All Unique?
    //
    // Return true if all integers in the array are unique (no duplicates).
    //
    // Example:
    //   Input: [1, 2, 3, 4]   → true
    //   Input: [1, 2, 2, 4]   → false
    //   Input: []              → true
    //   Input: [5]             → true
    // =========================================================
    static boolean allUnique(int[] nums) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]
    // =========================================================
    // Is Sorted?
    //
    // Return true if the array is sorted in non-decreasing order.
    //
    // Example:
    //   Input: [1, 2, 3, 4]   → true
    //   Input: [1, 2, 2, 4]   → true  (equal is allowed)
    //   Input: [1, 3, 2, 4]   → false
    //   Input: []              → true
    // =========================================================
    static boolean isSorted(int[] nums) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]
    // =========================================================
    // Is Majority?
    //
    // Return true if more than half the elements in the array
    // equal the given target value.
    //
    // Example:
    //   Input: [3, 3, 1, 2, 3], 3  → true   (3 appears 3/5 times)
    //   Input: [1, 2, 3, 4, 5], 3  → false  (3 appears only 1/5 times)
    //   Input: [1, 1], 1           → true
    // =========================================================
    static boolean isMajority(int[] nums, int target) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 10  [HARD]
    // =========================================================
    // Lights Out Puzzle
    //
    // You have n lights, all initially OFF (false).
    // In round i (1 to n), you toggle every light whose position
    // is divisible by i.
    // After all rounds, return true if the light at position k is ON.
    //
    // Insight: a light ends up ON only if it has an ODD number of divisors,
    //          which only happens for PERFECT SQUARES.
    //
    // Example:
    //   Input: n=10, k=1  → true   (1 is a perfect square)
    //   Input: n=10, k=4  → true   (4 is a perfect square)
    //   Input: n=10, k=3  → false  (3 is not a perfect square)
    //   Input: n=10, k=6  → false
    // =========================================================
    static boolean isLightOn(int n, int k) {
        // TODO: write your solution here

        return false;
    }


    // ============================================================
    //  TEST RUNNER — do not modify
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // Challenge 1
        pass += check("Challenge 1a", isEven(4),   true)  ? 1 : 0;
        fail += check("Challenge 1a", isEven(4),   true)  ? 0 : 1;
        pass += check("Challenge 1b", isEven(7),   false) ? 1 : 0;
        fail += check("Challenge 1b", isEven(7),   false) ? 0 : 1;
        pass += check("Challenge 1c", isEven(0),   true)  ? 1 : 0;
        fail += check("Challenge 1c", isEven(0),   true)  ? 0 : 1;
        pass += check("Challenge 1d", isEven(-3),  false) ? 1 : 0;
        fail += check("Challenge 1d", isEven(-3),  false) ? 0 : 1;

        // Challenge 2
        pass += check("Challenge 2a", isInRange(5, 1, 10),  true)  ? 1 : 0;
        fail += check("Challenge 2a", isInRange(5, 1, 10),  true)  ? 0 : 1;
        pass += check("Challenge 2b", isInRange(0, 1, 10),  false) ? 1 : 0;
        fail += check("Challenge 2b", isInRange(0, 1, 10),  false) ? 0 : 1;
        pass += check("Challenge 2c", isInRange(10, 1, 10), true)  ? 1 : 0;
        fail += check("Challenge 2c", isInRange(10, 1, 10), true)  ? 0 : 1;

        // Challenge 3
        pass += check("Challenge 3a", isLeapYear(2000), true)  ? 1 : 0;
        fail += check("Challenge 3a", isLeapYear(2000), true)  ? 0 : 1;
        pass += check("Challenge 3b", isLeapYear(1900), false) ? 1 : 0;
        fail += check("Challenge 3b", isLeapYear(1900), false) ? 0 : 1;
        pass += check("Challenge 3c", isLeapYear(2024), true)  ? 1 : 0;
        fail += check("Challenge 3c", isLeapYear(2024), true)  ? 0 : 1;
        pass += check("Challenge 3d", isLeapYear(2023), false) ? 1 : 0;
        fail += check("Challenge 3d", isLeapYear(2023), false) ? 0 : 1;

        // Challenge 4
        pass += check("Challenge 4a", canVote(20, true),  true)  ? 1 : 0;
        fail += check("Challenge 4a", canVote(20, true),  true)  ? 0 : 1;
        pass += check("Challenge 4b", canVote(17, true),  false) ? 1 : 0;
        fail += check("Challenge 4b", canVote(17, true),  false) ? 0 : 1;
        pass += check("Challenge 4c", canVote(20, false), false) ? 1 : 0;
        fail += check("Challenge 4c", canVote(20, false), false) ? 0 : 1;

        // Challenge 5
        pass += check("Challenge 5a", isValidPassword("Secure1!"), true)  ? 1 : 0;
        fail += check("Challenge 5a", isValidPassword("Secure1!"), true)  ? 0 : 1;
        pass += check("Challenge 5b", isValidPassword("secure1!"), false) ? 1 : 0;
        fail += check("Challenge 5b", isValidPassword("secure1!"), false) ? 0 : 1;
        pass += check("Challenge 5c", isValidPassword("SECURE!"),  false) ? 1 : 0;
        fail += check("Challenge 5c", isValidPassword("SECURE!"),  false) ? 0 : 1;
        pass += check("Challenge 5d", isValidPassword("Sec1"),     false) ? 1 : 0;
        fail += check("Challenge 5d", isValidPassword("Sec1"),     false) ? 0 : 1;

        // Challenge 6
        pass += check("Challenge 6a", isValidTriangle(3, 4, 5), true)  ? 1 : 0;
        fail += check("Challenge 6a", isValidTriangle(3, 4, 5), true)  ? 0 : 1;
        pass += check("Challenge 6b", isValidTriangle(1, 2, 3), false) ? 1 : 0;
        fail += check("Challenge 6b", isValidTriangle(1, 2, 3), false) ? 0 : 1;
        pass += check("Challenge 6c", isValidTriangle(5, 5, 5), true)  ? 1 : 0;
        fail += check("Challenge 6c", isValidTriangle(5, 5, 5), true)  ? 0 : 1;
        pass += check("Challenge 6d", isValidTriangle(0, 1, 1), false) ? 1 : 0;
        fail += check("Challenge 6d", isValidTriangle(0, 1, 1), false) ? 0 : 1;

        // Challenge 7
        pass += check("Challenge 7a", allUnique(new int[]{1,2,3,4}), true)  ? 1 : 0;
        fail += check("Challenge 7a", allUnique(new int[]{1,2,3,4}), true)  ? 0 : 1;
        pass += check("Challenge 7b", allUnique(new int[]{1,2,2,4}), false) ? 1 : 0;
        fail += check("Challenge 7b", allUnique(new int[]{1,2,2,4}), false) ? 0 : 1;
        pass += check("Challenge 7c", allUnique(new int[]{}),        true)  ? 1 : 0;
        fail += check("Challenge 7c", allUnique(new int[]{}),        true)  ? 0 : 1;

        // Challenge 8
        pass += check("Challenge 8a", isSorted(new int[]{1,2,3,4}), true)  ? 1 : 0;
        fail += check("Challenge 8a", isSorted(new int[]{1,2,3,4}), true)  ? 0 : 1;
        pass += check("Challenge 8b", isSorted(new int[]{1,2,2,4}), true)  ? 1 : 0;
        fail += check("Challenge 8b", isSorted(new int[]{1,2,2,4}), true)  ? 0 : 1;
        pass += check("Challenge 8c", isSorted(new int[]{1,3,2,4}), false) ? 1 : 0;
        fail += check("Challenge 8c", isSorted(new int[]{1,3,2,4}), false) ? 0 : 1;
        pass += check("Challenge 8d", isSorted(new int[]{}),        true)  ? 1 : 0;
        fail += check("Challenge 8d", isSorted(new int[]{}),        true)  ? 0 : 1;

        // Challenge 9
        pass += check("Challenge 9a", isMajority(new int[]{3,3,1,2,3}, 3), true)  ? 1 : 0;
        fail += check("Challenge 9a", isMajority(new int[]{3,3,1,2,3}, 3), true)  ? 0 : 1;
        pass += check("Challenge 9b", isMajority(new int[]{1,2,3,4,5}, 3), false) ? 1 : 0;
        fail += check("Challenge 9b", isMajority(new int[]{1,2,3,4,5}, 3), false) ? 0 : 1;
        pass += check("Challenge 9c", isMajority(new int[]{1,1}, 1),       true)  ? 1 : 0;
        fail += check("Challenge 9c", isMajority(new int[]{1,1}, 1),       true)  ? 0 : 1;

        // Challenge 10
        pass += check("Challenge 10a", isLightOn(10, 1), true)  ? 1 : 0;
        fail += check("Challenge 10a", isLightOn(10, 1), true)  ? 0 : 1;
        pass += check("Challenge 10b", isLightOn(10, 4), true)  ? 1 : 0;
        fail += check("Challenge 10b", isLightOn(10, 4), true)  ? 0 : 1;
        pass += check("Challenge 10c", isLightOn(10, 3), false) ? 1 : 0;
        fail += check("Challenge 10c", isLightOn(10, 3), false) ? 0 : 1;
        pass += check("Challenge 10d", isLightOn(10, 6), false) ? 1 : 0;
        fail += check("Challenge 10d", isLightOn(10, 6), false) ? 0 : 1;

        System.out.println("\n==============================");
        System.out.println("  RESULTS: " + pass + " passed, " + fail + " failed");
        System.out.println("==============================");
    }

    // ---- helpers ----
    private static boolean check(String name, Object got, Object expected) {
        boolean ok = String.valueOf(got).equals(String.valueOf(expected));
        System.out.printf("%-15s %s  (expected: %s | got: %s)%n",
                name, ok ? "✔ PASS" : "✘ FAIL", expected, got);
        return ok;
    }
}
