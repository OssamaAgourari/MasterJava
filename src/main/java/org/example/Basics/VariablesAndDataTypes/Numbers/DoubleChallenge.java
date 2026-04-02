package org.example.Basics.VariablesAndDataTypes.Numbers;

/**
 * ============================================================
 *             DOUBLE CHALLENGES  — LeetCode Style
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
 *
 * Note: doubles are compared with a small tolerance (1e-9)
 *       because of floating-point precision.
 * ============================================================
 */
public class DoubleChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]
    // =========================================================
    // Celsius to Fahrenheit
    //
    // Convert a Celsius temperature to Fahrenheit.
    // Formula: F = C × 9/5 + 32
    //
    // Example:
    //   Input: 0.0    → 32.0
    //   Input: 100.0  → 212.0
    //   Input: -40.0  → -40.0
    // =========================================================
    static double celsiusToFahrenheit(double celsius) {
        // TODO: write your solution here

        return 0;
    }

    // =========================================================
    // CHALLENGE 2  [EASY]
    // =========================================================
    // Circle Area
    //
    // Return the area of a circle with the given radius.
    // Formula: A = π × r²
    // Use Math.PI for π.
    //
    // Example:
    //   Input: 1.0  → 3.141592653589793
    //   Input: 5.0  → 78.53981633974483
    //   Input: 0.0  → 0.0
    // =========================================================
    static double circleArea(double radius) {
        // TODO: write your solution here

        return 0;
    }

    // =========================================================
    // CHALLENGE 3  [EASY]
    // =========================================================
    // Hypotenuse
    //
    // Given legs a and b of a right triangle, return the hypotenuse.
    // Formula: c = √(a² + b²)
    //
    // Example:
    //   Input: 3.0, 4.0   → 5.0
    //   Input: 5.0, 12.0  → 13.0
    //   Input: 1.0, 1.0   → 1.4142135623730951
    // =========================================================
    static double hypotenuse(double a, double b) {
        // TODO: write your solution here

        return 0;
    }

    // =========================================================
    // CHALLENGE 4  [EASY]
    // =========================================================
    // Round to N Decimal Places
    //
    // Round the given number to n decimal places.
    // Hint: multiply by 10^n, round, divide back.
    //
    // Example:
    //   Input: 3.14159, 2  → 3.14
    //   Input: 2.5555,  3  → 2.556
    //   Input: 1.0,     4  → 1.0
    // =========================================================
    static double roundToN(double value, int n) {
        // TODO: write your solution here

        return 0;
    }

    // =========================================================
    // CHALLENGE 5  [EASY]
    // =========================================================
    // Is Whole Number?
    //
    // Return true if the double value has no fractional part.
    //
    // Example:
    //   Input: 5.0   → true
    //   Input: 5.5   → false
    //   Input: -3.0  → true
    //   Input: 0.1   → false
    // =========================================================
    static boolean isWholeNumber(double d) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]
    // =========================================================
    // Compound Interest
    //
    // Calculate the final amount after compound interest.
    // Formula: A = P × (1 + r/n)^(n×t)
    //   P = principal, r = annual rate (e.g. 0.05 for 5%),
    //   n = times compounded per year, t = years
    //
    // Example:
    //   Input: 1000.0, 0.05, 12, 1  → 1051.161897881733
    //   Input: 500.0,  0.10, 4,  2  → 610.1733775787478
    // =========================================================
    static double compoundInterest(double principal, double rate, int n, int t) {
        // TODO: write your solution here

        return 0;
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]
    // =========================================================
    // Square Root (without Math.sqrt)
    //
    // Implement square root using the Babylonian (Newton's) method.
    // Stop iterating when the result is accurate to 1e-9.
    // Algorithm:
    //   guess = n / 2
    //   loop: guess = (guess + n / guess) / 2
    //         until |guess² - n| < 1e-9
    //
    // Example:
    //   Input: 4.0   → 2.0
    //   Input: 2.0   → 1.4142135623730951
    //   Input: 9.0   → 3.0
    // =========================================================
    static double mySqrt(double n) {
        // TODO: write your solution here

        return 0;
    }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]
    // =========================================================
    // Average of Array
    //
    // Return the average (mean) of the given array.
    // Return 0.0 if the array is empty.
    //
    // Example:
    //   Input: [1.0, 2.0, 3.0, 4.0, 5.0]  → 3.0
    //   Input: [10.0, 20.0]                → 15.0
    //   Input: []                          → 0.0
    // =========================================================
    static double average(double[] nums) {
        // TODO: write your solution here

        return 0;
    }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]
    // =========================================================
    // BMI Calculator
    //
    // Calculate BMI and return the category:
    //   BMI = weight(kg) / height(m)²
    //   < 18.5             → "Underweight"
    //   18.5 ≤ BMI < 25.0  → "Normal"
    //   25.0 ≤ BMI < 30.0  → "Overweight"
    //   ≥ 30.0             → "Obese"
    //
    // Example:
    //   Input: 50.0,  1.70  → "Underweight"
    //   Input: 70.0,  1.75  → "Normal"
    //   Input: 85.0,  1.75  → "Overweight"
    //   Input: 100.0, 1.70  → "Obese"
    // =========================================================
    static String bmiCategory(double weight, double height) {
        // TODO: write your solution here

        return "";
    }

    // =========================================================
    // CHALLENGE 10  [HARD]
    // =========================================================
    // Standard Deviation
    //
    // Return the population standard deviation of the array.
    // Formula:
    //   mean = sum / n
    //   variance = sum of (x - mean)² / n
    //   stddev = sqrt(variance)
    //
    // Example:
    //   Input: [2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0]  → 2.0
    //   Input: [1.0, 1.0, 1.0]                             → 0.0
    //   Input: [1.0, 3.0]                                  → 1.0
    // =========================================================
    static double standardDeviation(double[] nums) {
        // TODO: write your solution here

        return 0;
    }


    // ============================================================
    //  TEST RUNNER — do not modify
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // Challenge 1
        pass += checkD("Challenge 1a", celsiusToFahrenheit(0.0),    32.0)   ? 1 : 0;
        fail += checkD("Challenge 1a", celsiusToFahrenheit(0.0),    32.0)   ? 0 : 1;
        pass += checkD("Challenge 1b", celsiusToFahrenheit(100.0),  212.0)  ? 1 : 0;
        fail += checkD("Challenge 1b", celsiusToFahrenheit(100.0),  212.0)  ? 0 : 1;
        pass += checkD("Challenge 1c", celsiusToFahrenheit(-40.0),  -40.0)  ? 1 : 0;
        fail += checkD("Challenge 1c", celsiusToFahrenheit(-40.0),  -40.0)  ? 0 : 1;

        // Challenge 2
        pass += checkD("Challenge 2a", circleArea(1.0), Math.PI)              ? 1 : 0;
        fail += checkD("Challenge 2a", circleArea(1.0), Math.PI)              ? 0 : 1;
        pass += checkD("Challenge 2b", circleArea(5.0), Math.PI * 25)         ? 1 : 0;
        fail += checkD("Challenge 2b", circleArea(5.0), Math.PI * 25)         ? 0 : 1;
        pass += checkD("Challenge 2c", circleArea(0.0), 0.0)                  ? 1 : 0;
        fail += checkD("Challenge 2c", circleArea(0.0), 0.0)                  ? 0 : 1;

        // Challenge 3
        pass += checkD("Challenge 3a", hypotenuse(3.0, 4.0),  5.0)    ? 1 : 0;
        fail += checkD("Challenge 3a", hypotenuse(3.0, 4.0),  5.0)    ? 0 : 1;
        pass += checkD("Challenge 3b", hypotenuse(5.0, 12.0), 13.0)   ? 1 : 0;
        fail += checkD("Challenge 3b", hypotenuse(5.0, 12.0), 13.0)   ? 0 : 1;

        // Challenge 4
        pass += checkD("Challenge 4a", roundToN(3.14159, 2), 3.14)  ? 1 : 0;
        fail += checkD("Challenge 4a", roundToN(3.14159, 2), 3.14)  ? 0 : 1;
        pass += checkD("Challenge 4b", roundToN(2.5555, 3),  2.556) ? 1 : 0;
        fail += checkD("Challenge 4b", roundToN(2.5555, 3),  2.556) ? 0 : 1;

        // Challenge 5
        pass += check("Challenge 5a", isWholeNumber(5.0),   true)  ? 1 : 0;
        fail += check("Challenge 5a", isWholeNumber(5.0),   true)  ? 0 : 1;
        pass += check("Challenge 5b", isWholeNumber(5.5),   false) ? 1 : 0;
        fail += check("Challenge 5b", isWholeNumber(5.5),   false) ? 0 : 1;
        pass += check("Challenge 5c", isWholeNumber(-3.0),  true)  ? 1 : 0;
        fail += check("Challenge 5c", isWholeNumber(-3.0),  true)  ? 0 : 1;

        // Challenge 6
        pass += checkD("Challenge 6a", compoundInterest(1000.0, 0.05, 12, 1), 1051.161897881733)   ? 1 : 0;
        fail += checkD("Challenge 6a", compoundInterest(1000.0, 0.05, 12, 1), 1051.161897881733)   ? 0 : 1;
        pass += checkD("Challenge 6b", compoundInterest(500.0,  0.10, 4,  2), 610.1733775787478)   ? 1 : 0;
        fail += checkD("Challenge 6b", compoundInterest(500.0,  0.10, 4,  2), 610.1733775787478)   ? 0 : 1;

        // Challenge 7
        pass += checkD("Challenge 7a", mySqrt(4.0), 2.0)                     ? 1 : 0;
        fail += checkD("Challenge 7a", mySqrt(4.0), 2.0)                     ? 0 : 1;
        pass += checkD("Challenge 7b", mySqrt(2.0), Math.sqrt(2.0))          ? 1 : 0;
        fail += checkD("Challenge 7b", mySqrt(2.0), Math.sqrt(2.0))          ? 0 : 1;
        pass += checkD("Challenge 7c", mySqrt(9.0), 3.0)                     ? 1 : 0;
        fail += checkD("Challenge 7c", mySqrt(9.0), 3.0)                     ? 0 : 1;

        // Challenge 8
        pass += checkD("Challenge 8a", average(new double[]{1,2,3,4,5}), 3.0)  ? 1 : 0;
        fail += checkD("Challenge 8a", average(new double[]{1,2,3,4,5}), 3.0)  ? 0 : 1;
        pass += checkD("Challenge 8b", average(new double[]{10,20}),     15.0) ? 1 : 0;
        fail += checkD("Challenge 8b", average(new double[]{10,20}),     15.0) ? 0 : 1;
        pass += checkD("Challenge 8c", average(new double[]{}),          0.0)  ? 1 : 0;
        fail += checkD("Challenge 8c", average(new double[]{}),          0.0)  ? 0 : 1;

        // Challenge 9
        pass += check("Challenge 9a", bmiCategory(50.0,  1.70), "Underweight") ? 1 : 0;
        fail += check("Challenge 9a", bmiCategory(50.0,  1.70), "Underweight") ? 0 : 1;
        pass += check("Challenge 9b", bmiCategory(70.0,  1.75), "Normal")      ? 1 : 0;
        fail += check("Challenge 9b", bmiCategory(70.0,  1.75), "Normal")      ? 0 : 1;
        pass += check("Challenge 9c", bmiCategory(85.0,  1.75), "Overweight")  ? 1 : 0;
        fail += check("Challenge 9c", bmiCategory(85.0,  1.75), "Overweight")  ? 0 : 1;
        pass += check("Challenge 9d", bmiCategory(100.0, 1.70), "Obese")       ? 1 : 0;
        fail += check("Challenge 9d", bmiCategory(100.0, 1.70), "Obese")       ? 0 : 1;

        // Challenge 10
        pass += checkD("Challenge 10a", standardDeviation(new double[]{2,4,4,4,5,5,7,9}), 2.0) ? 1 : 0;
        fail += checkD("Challenge 10a", standardDeviation(new double[]{2,4,4,4,5,5,7,9}), 2.0) ? 0 : 1;
        pass += checkD("Challenge 10b", standardDeviation(new double[]{1,1,1}),            0.0) ? 1 : 0;
        fail += checkD("Challenge 10b", standardDeviation(new double[]{1,1,1}),            0.0) ? 0 : 1;
        pass += checkD("Challenge 10c", standardDeviation(new double[]{1,3}),              1.0) ? 1 : 0;
        fail += checkD("Challenge 10c", standardDeviation(new double[]{1,3}),              1.0) ? 0 : 1;

        System.out.println("\n==============================");
        System.out.println("  RESULTS: " + pass + " passed, " + fail + " failed");
        System.out.println("==============================");
    }

    // ---- helpers ----
    private static boolean checkD(String name, double got, double expected) {
        boolean ok = Math.abs(got - expected) < 1e-6;
        System.out.printf("%-15s %s  (expected: %.6f | got: %.6f)%n",
                name, ok ? "✔ PASS" : "✘ FAIL", expected, got);
        return ok;
    }
    private static boolean check(String name, Object got, Object expected) {
        boolean ok = String.valueOf(got).equals(String.valueOf(expected));
        System.out.printf("%-15s %s  (expected: %s | got: %s)%n",
                name, ok ? "✔ PASS" : "✘ FAIL", expected, got);
        return ok;
    }
}
