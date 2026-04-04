package org.example.Basics.Operators.Comparison;

/**
 * ============================================================
 *          COMPARISON OPERATORS CHALLENGES — LeetCode Style
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
public class ComparisonChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]
    // =========================================================
    // Max of Two
    //
    // Return the larger of two integers.
    // Do NOT use Math.max().
    //
    // Example:
    //   Input: 3, 7  → 7
    //   Input: 9, 4  → 9
    //   Input: 5, 5  → 5
    // =========================================================
    static int maxOfTwo(int a, int b) {
        // TODO: write your solution here

        return -1;
    }

    // =========================================================
    // CHALLENGE 2  [EASY]
    // =========================================================
    // Is In Range
    //
    // Return true if x is between min (inclusive) and max (inclusive).
    //
    // Example:
    //   Input: 5, 1, 10  → true
    //   Input: 0, 1, 10  → false
    //   Input: 10, 1, 10 → true
    // =========================================================
    static boolean isInRange(int x, int min, int max) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 3  [EASY]
    // =========================================================
    // Is Leap Year
    //
    // Return true if the given year is a leap year.
    // Leap year rules:
    //   - Divisible by 4 AND not by 100, OR divisible by 400.
    //
    // Example:
    //   Input: 2024 → true
    //   Input: 1900 → false
    //   Input: 2000 → true
    //   Input: 2023 → false
    // =========================================================
    static boolean isLeapYear(int year) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 4  [EASY]
    // =========================================================
    // Grade Letter
    //
    // Return the letter grade for a score:
    //   score >= 90 → "A"
    //   score >= 80 → "B"
    //   score >= 70 → "C"
    //   score >= 60 → "D"
    //   otherwise   → "F"
    //
    // Example:
    //   Input: 95 → "A"
    //   Input: 83 → "B"
    //   Input: 55 → "F"
    // =========================================================
    static String gradeLetter(int score) {
        // TODO: write your solution here

        return "";
    }

    // =========================================================
    // CHALLENGE 5  [EASY]
    // =========================================================
    // Are Strings Equal (ignore case)
    //
    // Return true if s1 and s2 have the same content, ignoring case.
    // Handle null: if either is null, return false.
    //
    // Example:
    //   Input: "Hello", "hello"  → true
    //   Input: "Java", "python"  → false
    //   Input: null, "hi"        → false
    // =========================================================
    static boolean areEqualIgnoreCase(String s1, String s2) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]
    // =========================================================
    // Max of Three
    //
    // Return the largest of three integers.
    //
    // Example:
    //   Input: 3, 7, 5  → 7
    //   Input: 9, 9, 4  → 9
    //   Input: 1, 2, 3  → 3
    // =========================================================
    static int maxOfThree(int a, int b, int c) {
        // TODO: write your solution here

        return -1;
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]
    // =========================================================
    // Compare Doubles with Epsilon
    //
    // Return true if a and b are equal within a tolerance of 1e-9.
    // Use Math.abs(a - b) < epsilon instead of ==.
    //
    // Example:
    //   Input: 0.1 + 0.2, 0.3  → true
    //   Input: 1.0, 1.001       → false
    // =========================================================
    static boolean approxEqual(double a, double b) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]
    // =========================================================
    // Classify Number
    //
    // Return:
    //   "positive" if n > 0
    //   "negative" if n < 0
    //   "zero"     if n == 0
    //
    // Example:
    //   Input:  5 → "positive"
    //   Input: -3 → "negative"
    //   Input:  0 → "zero"
    // =========================================================
    static String classify(int n) {
        // TODO: write your solution here

        return "";
    }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]
    // =========================================================
    // Clamp
    //
    // Return value clamped to [min, max]:
    //   - if value < min → return min
    //   - if value > max → return max
    //   - otherwise → return value
    //
    // Example:
    //   Input: 5,  1, 10 → 5
    //   Input: -3, 0, 100 → 0
    //   Input: 150, 0, 100 → 100
    // =========================================================
    static int clamp(int value, int min, int max) {
        // TODO: write your solution here

        return -1;
    }

    // =========================================================
    // CHALLENGE 10  [HARD]
    // =========================================================
    // Binary Search
    //
    // Given a sorted array and a target, return the index of target.
    // Return -1 if not found.
    // Use comparison operators to implement binary search.
    //
    // Example:
    //   Input: [1,3,5,7,9], 7  → 3
    //   Input: [2,4,6,8,10], 5 → -1
    //   Input: [1], 1          → 0
    // =========================================================
    static int binarySearch(int[] arr, int target) {
        // TODO: write your solution here

        return -1;
    }


    // ============================================================
    //  TEST RUNNER — do not modify
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // Challenge 1
        pass += check("Challenge 1a", maxOfTwo(3, 7), 7) ? 1 : 0;
        fail += check("Challenge 1a", maxOfTwo(3, 7), 7) ? 0 : 1;
        pass += check("Challenge 1b", maxOfTwo(9, 4), 9) ? 1 : 0;
        fail += check("Challenge 1b", maxOfTwo(9, 4), 9) ? 0 : 1;
        pass += check("Challenge 1c", maxOfTwo(5, 5), 5) ? 1 : 0;
        fail += check("Challenge 1c", maxOfTwo(5, 5), 5) ? 0 : 1;

        // Challenge 2
        pass += check("Challenge 2a", isInRange(5,  1, 10), true)  ? 1 : 0;
        fail += check("Challenge 2a", isInRange(5,  1, 10), true)  ? 0 : 1;
        pass += check("Challenge 2b", isInRange(0,  1, 10), false) ? 1 : 0;
        fail += check("Challenge 2b", isInRange(0,  1, 10), false) ? 0 : 1;
        pass += check("Challenge 2c", isInRange(10, 1, 10), true)  ? 1 : 0;
        fail += check("Challenge 2c", isInRange(10, 1, 10), true)  ? 0 : 1;

        // Challenge 3
        pass += check("Challenge 3a", isLeapYear(2024), true)  ? 1 : 0;
        fail += check("Challenge 3a", isLeapYear(2024), true)  ? 0 : 1;
        pass += check("Challenge 3b", isLeapYear(1900), false) ? 1 : 0;
        fail += check("Challenge 3b", isLeapYear(1900), false) ? 0 : 1;
        pass += check("Challenge 3c", isLeapYear(2000), true)  ? 1 : 0;
        fail += check("Challenge 3c", isLeapYear(2000), true)  ? 0 : 1;
        pass += check("Challenge 3d", isLeapYear(2023), false) ? 1 : 0;
        fail += check("Challenge 3d", isLeapYear(2023), false) ? 0 : 1;

        // Challenge 4
        pass += check("Challenge 4a", gradeLetter(95), "A") ? 1 : 0;
        fail += check("Challenge 4a", gradeLetter(95), "A") ? 0 : 1;
        pass += check("Challenge 4b", gradeLetter(83), "B") ? 1 : 0;
        fail += check("Challenge 4b", gradeLetter(83), "B") ? 0 : 1;
        pass += check("Challenge 4c", gradeLetter(55), "F") ? 1 : 0;
        fail += check("Challenge 4c", gradeLetter(55), "F") ? 0 : 1;

        // Challenge 5
        pass += check("Challenge 5a", areEqualIgnoreCase("Hello", "hello"), true)  ? 1 : 0;
        fail += check("Challenge 5a", areEqualIgnoreCase("Hello", "hello"), true)  ? 0 : 1;
        pass += check("Challenge 5b", areEqualIgnoreCase("Java", "python"), false) ? 1 : 0;
        fail += check("Challenge 5b", areEqualIgnoreCase("Java", "python"), false) ? 0 : 1;
        pass += check("Challenge 5c", areEqualIgnoreCase(null, "hi"),       false) ? 1 : 0;
        fail += check("Challenge 5c", areEqualIgnoreCase(null, "hi"),       false) ? 0 : 1;

        // Challenge 6
        pass += check("Challenge 6a", maxOfThree(3, 7, 5), 7) ? 1 : 0;
        fail += check("Challenge 6a", maxOfThree(3, 7, 5), 7) ? 0 : 1;
        pass += check("Challenge 6b", maxOfThree(9, 9, 4), 9) ? 1 : 0;
        fail += check("Challenge 6b", maxOfThree(9, 9, 4), 9) ? 0 : 1;
        pass += check("Challenge 6c", maxOfThree(1, 2, 3), 3) ? 1 : 0;
        fail += check("Challenge 6c", maxOfThree(1, 2, 3), 3) ? 0 : 1;

        // Challenge 7
        pass += check("Challenge 7a", approxEqual(0.1 + 0.2, 0.3),  true)  ? 1 : 0;
        fail += check("Challenge 7a", approxEqual(0.1 + 0.2, 0.3),  true)  ? 0 : 1;
        pass += check("Challenge 7b", approxEqual(1.0, 1.001),       false) ? 1 : 0;
        fail += check("Challenge 7b", approxEqual(1.0, 1.001),       false) ? 0 : 1;

        // Challenge 8
        pass += check("Challenge 8a", classify(5),  "positive") ? 1 : 0;
        fail += check("Challenge 8a", classify(5),  "positive") ? 0 : 1;
        pass += check("Challenge 8b", classify(-3), "negative") ? 1 : 0;
        fail += check("Challenge 8b", classify(-3), "negative") ? 0 : 1;
        pass += check("Challenge 8c", classify(0),  "zero")     ? 1 : 0;
        fail += check("Challenge 8c", classify(0),  "zero")     ? 0 : 1;

        // Challenge 9
        pass += check("Challenge 9a", clamp(5,   1,  10), 5)   ? 1 : 0;
        fail += check("Challenge 9a", clamp(5,   1,  10), 5)   ? 0 : 1;
        pass += check("Challenge 9b", clamp(-3,  0,  100), 0)  ? 1 : 0;
        fail += check("Challenge 9b", clamp(-3,  0,  100), 0)  ? 0 : 1;
        pass += check("Challenge 9c", clamp(150, 0,  100), 100) ? 1 : 0;
        fail += check("Challenge 9c", clamp(150, 0,  100), 100) ? 0 : 1;

        // Challenge 10
        pass += check("Challenge 10a", binarySearch(new int[]{1,3,5,7,9}, 7),  3)  ? 1 : 0;
        fail += check("Challenge 10a", binarySearch(new int[]{1,3,5,7,9}, 7),  3)  ? 0 : 1;
        pass += check("Challenge 10b", binarySearch(new int[]{2,4,6,8,10}, 5), -1) ? 1 : 0;
        fail += check("Challenge 10b", binarySearch(new int[]{2,4,6,8,10}, 5), -1) ? 0 : 1;
        pass += check("Challenge 10c", binarySearch(new int[]{1}, 1),           0) ? 1 : 0;
        fail += check("Challenge 10c", binarySearch(new int[]{1}, 1),           0) ? 0 : 1;

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
