package org.example.Basics.Operators.Arithmetic;

/**
 * ============================================================
 *           ARITHMETIC OPERATORS CHALLENGES — LeetCode Style
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
public class ArithmeticChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]
    // =========================================================
    // Sum of Digits
    //
    // Return the sum of all digits of n.
    // Treat negative numbers as their absolute value.
    //
    // Example:
    //   Input: 123   → 6  (1+2+3)
    //   Input: -456  → 15 (4+5+6)
    //   Input: 0     → 0
    // =========================================================
    static int sumOfDigits(int n) {
        // TODO: write your solution here

        return -1;
    }

    // =========================================================
    // CHALLENGE 2  [EASY]
    // =========================================================
    // Count Digits
    //
    // Return the number of digits in n (ignore sign).
    //
    // Example:
    //   Input: 0     → 1
    //   Input: 123   → 3
    //   Input: -9876 → 4
    // =========================================================
    static int countDigits(int n) {
        // TODO: write your solution here

        return -1;
    }

    // =========================================================
    // CHALLENGE 3  [EASY]
    // =========================================================
    // Power Without Math.pow
    //
    // Return base raised to the power exp using only * and loops.
    // Assume exp >= 0 and the result fits in a long.
    //
    // Example:
    //   Input: 2, 10 → 1024
    //   Input: 3, 3  → 27
    //   Input: 5, 0  → 1
    // =========================================================
    static long power(int base, int exp) {
        // TODO: write your solution here

        return -1;
    }

    // =========================================================
    // CHALLENGE 4  [EASY]
    // =========================================================
    // Average of Array
    //
    // Return the average of all elements in the array as a double.
    // The array is guaranteed to be non-empty.
    //
    // Example:
    //   Input: [2, 4, 6]       → 4.0
    //   Input: [1, 2, 3, 4, 5] → 3.0
    //   Input: [7]             → 7.0
    // =========================================================
    static double average(int[] nums) {
        // TODO: write your solution here

        return -1;
    }

    // =========================================================
    // CHALLENGE 5  [EASY]
    // =========================================================
    // Celsius to Fahrenheit
    //
    // Convert Celsius to Fahrenheit.
    // Formula: F = C * 9/5 + 32
    //
    // Example:
    //   Input: 0   → 32.0
    //   Input: 100 → 212.0
    //   Input: -40 → -40.0
    // =========================================================
    static double celsiusToFahrenheit(double celsius) {
        // TODO: write your solution here

        return -999;
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]
    // =========================================================
    // Reverse an Integer
    //
    // Reverse the digits of n.
    // If the reversed number overflows int range, return 0.
    //
    // Example:
    //   Input: 123    → 321
    //   Input: -456   → -654
    //   Input: 120    → 21  (leading zeros dropped)
    //   Input: 1534236469 → 0 (overflow)
    // =========================================================
    static int reverseInt(int n) {
        // TODO: write your solution here

        return 0;
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]
    // =========================================================
    // Max Digit
    //
    // Return the largest digit in n (ignore sign).
    //
    // Example:
    //   Input: 938271 → 9
    //   Input: 1234   → 4
    //   Input: 5      → 5
    // =========================================================
    static int maxDigit(int n) {
        // TODO: write your solution here

        return -1;
    }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]
    // =========================================================
    // Factorial
    //
    // Return n! (n factorial). Use long to handle large values.
    // 0! = 1 by definition.
    //
    // Example:
    //   Input: 0  → 1
    //   Input: 5  → 120
    //   Input: 10 → 3628800
    // =========================================================
    static long factorial(int n) {
        // TODO: write your solution here

        return -1;
    }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]
    // =========================================================
    // GCD (Greatest Common Divisor)
    //
    // Return the greatest common divisor of a and b.
    // Both values are positive.
    // Hint: use the Euclidean algorithm — gcd(a, b) = gcd(b, a % b)
    //
    // Example:
    //   Input: 12, 8   → 4
    //   Input: 100, 75 → 25
    //   Input: 7, 3    → 1
    // =========================================================
    static int gcd(int a, int b) {
        // TODO: write your solution here

        return -1;
    }

    // =========================================================
    // CHALLENGE 10  [HARD]
    // =========================================================
    // Integer Square Root
    //
    // Return the integer square root of n (floor of sqrt(n)).
    // Do NOT use Math.sqrt().
    //
    // Example:
    //   Input: 4  → 2
    //   Input: 8  → 2  (floor(2.82...) = 2)
    //   Input: 9  → 3
    //   Input: 1  → 1
    //   Input: 0  → 0
    // =========================================================
    static int intSqrt(int n) {
        // TODO: write your solution here

        return -1;
    }


    // ============================================================
    //  TEST RUNNER — do not modify
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // Challenge 1
        pass += check("Challenge 1a", sumOfDigits(123),  6)  ? 1 : 0;
        fail += check("Challenge 1a", sumOfDigits(123),  6)  ? 0 : 1;
        pass += check("Challenge 1b", sumOfDigits(-456), 15) ? 1 : 0;
        fail += check("Challenge 1b", sumOfDigits(-456), 15) ? 0 : 1;
        pass += check("Challenge 1c", sumOfDigits(0),    0)  ? 1 : 0;
        fail += check("Challenge 1c", sumOfDigits(0),    0)  ? 0 : 1;

        // Challenge 2
        pass += check("Challenge 2a", countDigits(0),     1) ? 1 : 0;
        fail += check("Challenge 2a", countDigits(0),     1) ? 0 : 1;
        pass += check("Challenge 2b", countDigits(123),   3) ? 1 : 0;
        fail += check("Challenge 2b", countDigits(123),   3) ? 0 : 1;
        pass += check("Challenge 2c", countDigits(-9876), 4) ? 1 : 0;
        fail += check("Challenge 2c", countDigits(-9876), 4) ? 0 : 1;

        // Challenge 3
        pass += check("Challenge 3a", power(2, 10), 1024L) ? 1 : 0;
        fail += check("Challenge 3a", power(2, 10), 1024L) ? 0 : 1;
        pass += check("Challenge 3b", power(3, 3),  27L)   ? 1 : 0;
        fail += check("Challenge 3b", power(3, 3),  27L)   ? 0 : 1;
        pass += check("Challenge 3c", power(5, 0),  1L)    ? 1 : 0;
        fail += check("Challenge 3c", power(5, 0),  1L)    ? 0 : 1;

        // Challenge 4
        pass += check("Challenge 4a", average(new int[]{2,4,6}),       4.0) ? 1 : 0;
        fail += check("Challenge 4a", average(new int[]{2,4,6}),       4.0) ? 0 : 1;
        pass += check("Challenge 4b", average(new int[]{1,2,3,4,5}),   3.0) ? 1 : 0;
        fail += check("Challenge 4b", average(new int[]{1,2,3,4,5}),   3.0) ? 0 : 1;
        pass += check("Challenge 4c", average(new int[]{7}),           7.0) ? 1 : 0;
        fail += check("Challenge 4c", average(new int[]{7}),           7.0) ? 0 : 1;

        // Challenge 5
        pass += check("Challenge 5a", celsiusToFahrenheit(0),    32.0)  ? 1 : 0;
        fail += check("Challenge 5a", celsiusToFahrenheit(0),    32.0)  ? 0 : 1;
        pass += check("Challenge 5b", celsiusToFahrenheit(100),  212.0) ? 1 : 0;
        fail += check("Challenge 5b", celsiusToFahrenheit(100),  212.0) ? 0 : 1;
        pass += check("Challenge 5c", celsiusToFahrenheit(-40),  -40.0) ? 1 : 0;
        fail += check("Challenge 5c", celsiusToFahrenheit(-40),  -40.0) ? 0 : 1;

        // Challenge 6
        pass += check("Challenge 6a", reverseInt(123),  321)  ? 1 : 0;
        fail += check("Challenge 6a", reverseInt(123),  321)  ? 0 : 1;
        pass += check("Challenge 6b", reverseInt(-456), -654) ? 1 : 0;
        fail += check("Challenge 6b", reverseInt(-456), -654) ? 0 : 1;
        pass += check("Challenge 6c", reverseInt(120),  21)   ? 1 : 0;
        fail += check("Challenge 6c", reverseInt(120),  21)   ? 0 : 1;

        // Challenge 7
        pass += check("Challenge 7a", maxDigit(938271), 9) ? 1 : 0;
        fail += check("Challenge 7a", maxDigit(938271), 9) ? 0 : 1;
        pass += check("Challenge 7b", maxDigit(1234),   4) ? 1 : 0;
        fail += check("Challenge 7b", maxDigit(1234),   4) ? 0 : 1;
        pass += check("Challenge 7c", maxDigit(5),      5) ? 1 : 0;
        fail += check("Challenge 7c", maxDigit(5),      5) ? 0 : 1;

        // Challenge 8
        pass += check("Challenge 8a", factorial(0),  1L)       ? 1 : 0;
        fail += check("Challenge 8a", factorial(0),  1L)       ? 0 : 1;
        pass += check("Challenge 8b", factorial(5),  120L)     ? 1 : 0;
        fail += check("Challenge 8b", factorial(5),  120L)     ? 0 : 1;
        pass += check("Challenge 8c", factorial(10), 3628800L) ? 1 : 0;
        fail += check("Challenge 8c", factorial(10), 3628800L) ? 0 : 1;

        // Challenge 9
        pass += check("Challenge 9a", gcd(12, 8),   4)  ? 1 : 0;
        fail += check("Challenge 9a", gcd(12, 8),   4)  ? 0 : 1;
        pass += check("Challenge 9b", gcd(100, 75), 25) ? 1 : 0;
        fail += check("Challenge 9b", gcd(100, 75), 25) ? 0 : 1;
        pass += check("Challenge 9c", gcd(7, 3),    1)  ? 1 : 0;
        fail += check("Challenge 9c", gcd(7, 3),    1)  ? 0 : 1;

        // Challenge 10
        pass += check("Challenge 10a", intSqrt(4), 2) ? 1 : 0;
        fail += check("Challenge 10a", intSqrt(4), 2) ? 0 : 1;
        pass += check("Challenge 10b", intSqrt(8), 2) ? 1 : 0;
        fail += check("Challenge 10b", intSqrt(8), 2) ? 0 : 1;
        pass += check("Challenge 10c", intSqrt(9), 3) ? 1 : 0;
        fail += check("Challenge 10c", intSqrt(9), 3) ? 0 : 1;
        pass += check("Challenge 10d", intSqrt(0), 0) ? 1 : 0;
        fail += check("Challenge 10d", intSqrt(0), 0) ? 0 : 1;

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
