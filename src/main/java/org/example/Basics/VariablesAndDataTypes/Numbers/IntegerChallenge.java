package org.example.Basics.VariablesAndDataTypes.Numbers;

/**
 * ============================================================
 *             INTEGER CHALLENGES  — LeetCode Style
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
public class IntegerChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]
    // =========================================================
    // FizzBuzz
    //
    // Given an integer n, return a string:
    //   "FizzBuzz" if divisible by both 3 and 5
    //   "Fizz"     if divisible by 3 only
    //   "Buzz"     if divisible by 5 only
    //   the number as a string otherwise
    //
    // Example:
    //   Input: 15  → "FizzBuzz"
    //   Input: 9   → "Fizz"
    //   Input: 10  → "Buzz"
    //   Input: 7   → "7"
    // =========================================================
    static String fizzBuzz(int n) {
        // TODO: write your solution here

        return "";
    }

    // =========================================================
    // CHALLENGE 2  [EASY]
    // =========================================================
    // Sum of Digits
    //
    // Return the sum of all digits of the number.
    // The input can be negative — treat it as positive.
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
    // CHALLENGE 3  [EASY]
    // =========================================================
    // Is Prime?
    //
    // Return true if n is a prime number, false otherwise.
    // A prime has exactly two divisors: 1 and itself.
    // Numbers ≤ 1 are not prime.
    //
    // Example:
    //   Input: 2   → true
    //   Input: 7   → true
    //   Input: 9   → false  (9 = 3 × 3)
    //   Input: 1   → false
    // =========================================================
    static boolean isPrime(int n) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 4  [EASY]
    // =========================================================
    // Reverse an Integer
    //
    // Reverse the digits of an integer.
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
    // CHALLENGE 5  [EASY]
    // =========================================================
    // Factorial
    //
    // Return n! (n factorial).
    // 0! = 1 by definition.
    // Use long to handle large values.
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
    // CHALLENGE 6  [MEDIUM]
    // =========================================================
    // Fibonacci Number
    //
    // Return the n-th Fibonacci number (0-indexed).
    //   F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2)
    //
    // Example:
    //   Input: 0  → 0
    //   Input: 1  → 1
    //   Input: 6  → 8  (0,1,1,2,3,5,8)
    //   Input: 10 → 55
    // =========================================================
    static long fibonacci(int n) {
        // TODO: write your solution here

        return -1;
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]
    // =========================================================
    // Count Set Bits (Hamming Weight)
    //
    // Return the number of '1' bits in the binary representation of n.
    // Do NOT use Integer.bitCount().
    //
    // Example:
    //   Input: 11  → 3  (binary: 1011)
    //   Input: 128 → 1  (binary: 10000000)
    //   Input: 255 → 8  (binary: 11111111)
    // =========================================================
    static int countSetBits(int n) {
        // TODO: write your solution here

        return -1;
    }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]
    // =========================================================
    // Power of Two
    //
    // Return true if n is a power of 2.
    // A power of 2 is: 1, 2, 4, 8, 16, 32, ...
    // n can be 0 or negative — those return false.
    //
    // Example:
    //   Input: 1   → true
    //   Input: 16  → true
    //   Input: 18  → false
    //   Input: 0   → false
    // =========================================================
    static boolean isPowerOfTwo(int n) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]
    // =========================================================
    // GCD (Greatest Common Divisor)
    //
    // Return the greatest common divisor of a and b.
    // Both values are positive.
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
    // Count Primes
    //
    // Return the number of prime numbers strictly less than n.
    // Implement the Sieve of Eratosthenes for efficiency.
    //
    // Example:
    //   Input: 10  → 4  (primes: 2, 3, 5, 7)
    //   Input: 1   → 0
    //   Input: 20  → 8  (2,3,5,7,11,13,17,19)
    // =========================================================
    static int countPrimes(int n) {
        // TODO: write your solution here

        return -1;
    }


    // ============================================================
    //  TEST RUNNER — do not modify
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // Challenge 1
        pass += check("Challenge 1a", fizzBuzz(15), "FizzBuzz") ? 1 : 0;
        fail += check("Challenge 1a", fizzBuzz(15), "FizzBuzz") ? 0 : 1;
        pass += check("Challenge 1b", fizzBuzz(9),  "Fizz")     ? 1 : 0;
        fail += check("Challenge 1b", fizzBuzz(9),  "Fizz")     ? 0 : 1;
        pass += check("Challenge 1c", fizzBuzz(10), "Buzz")     ? 1 : 0;
        fail += check("Challenge 1c", fizzBuzz(10), "Buzz")     ? 0 : 1;
        pass += check("Challenge 1d", fizzBuzz(7),  "7")        ? 1 : 0;
        fail += check("Challenge 1d", fizzBuzz(7),  "7")        ? 0 : 1;

        // Challenge 2
        pass += check("Challenge 2a", sumOfDigits(123),  6)  ? 1 : 0;
        fail += check("Challenge 2a", sumOfDigits(123),  6)  ? 0 : 1;
        pass += check("Challenge 2b", sumOfDigits(-456), 15) ? 1 : 0;
        fail += check("Challenge 2b", sumOfDigits(-456), 15) ? 0 : 1;
        pass += check("Challenge 2c", sumOfDigits(0),    0)  ? 1 : 0;
        fail += check("Challenge 2c", sumOfDigits(0),    0)  ? 0 : 1;

        // Challenge 3
        pass += check("Challenge 3a", isPrime(2),  true)  ? 1 : 0;
        fail += check("Challenge 3a", isPrime(2),  true)  ? 0 : 1;
        pass += check("Challenge 3b", isPrime(7),  true)  ? 1 : 0;
        fail += check("Challenge 3b", isPrime(7),  true)  ? 0 : 1;
        pass += check("Challenge 3c", isPrime(9),  false) ? 1 : 0;
        fail += check("Challenge 3c", isPrime(9),  false) ? 0 : 1;
        pass += check("Challenge 3d", isPrime(1),  false) ? 1 : 0;
        fail += check("Challenge 3d", isPrime(1),  false) ? 0 : 1;

        // Challenge 4
        pass += check("Challenge 4a", reverseInt(123),  321)  ? 1 : 0;
        fail += check("Challenge 4a", reverseInt(123),  321)  ? 0 : 1;
        pass += check("Challenge 4b", reverseInt(-456), -654) ? 1 : 0;
        fail += check("Challenge 4b", reverseInt(-456), -654) ? 0 : 1;
        pass += check("Challenge 4c", reverseInt(120),  21)   ? 1 : 0;
        fail += check("Challenge 4c", reverseInt(120),  21)   ? 0 : 1;

        // Challenge 5
        pass += check("Challenge 5a", factorial(0),  1L)       ? 1 : 0;
        fail += check("Challenge 5a", factorial(0),  1L)       ? 0 : 1;
        pass += check("Challenge 5b", factorial(5),  120L)     ? 1 : 0;
        fail += check("Challenge 5b", factorial(5),  120L)     ? 0 : 1;
        pass += check("Challenge 5c", factorial(10), 3628800L) ? 1 : 0;
        fail += check("Challenge 5c", factorial(10), 3628800L) ? 0 : 1;

        // Challenge 6
        pass += check("Challenge 6a", fibonacci(0),  0L)  ? 1 : 0;
        fail += check("Challenge 6a", fibonacci(0),  0L)  ? 0 : 1;
        pass += check("Challenge 6b", fibonacci(6),  8L)  ? 1 : 0;
        fail += check("Challenge 6b", fibonacci(6),  8L)  ? 0 : 1;
        pass += check("Challenge 6c", fibonacci(10), 55L) ? 1 : 0;
        fail += check("Challenge 6c", fibonacci(10), 55L) ? 0 : 1;

        // Challenge 7
        pass += check("Challenge 7a", countSetBits(11),  3) ? 1 : 0;
        fail += check("Challenge 7a", countSetBits(11),  3) ? 0 : 1;
        pass += check("Challenge 7b", countSetBits(128), 1) ? 1 : 0;
        fail += check("Challenge 7b", countSetBits(128), 1) ? 0 : 1;
        pass += check("Challenge 7c", countSetBits(255), 8) ? 1 : 0;
        fail += check("Challenge 7c", countSetBits(255), 8) ? 0 : 1;

        // Challenge 8
        pass += check("Challenge 8a", isPowerOfTwo(1),  true)  ? 1 : 0;
        fail += check("Challenge 8a", isPowerOfTwo(1),  true)  ? 0 : 1;
        pass += check("Challenge 8b", isPowerOfTwo(16), true)  ? 1 : 0;
        fail += check("Challenge 8b", isPowerOfTwo(16), true)  ? 0 : 1;
        pass += check("Challenge 8c", isPowerOfTwo(18), false) ? 1 : 0;
        fail += check("Challenge 8c", isPowerOfTwo(18), false) ? 0 : 1;
        pass += check("Challenge 8d", isPowerOfTwo(0),  false) ? 1 : 0;
        fail += check("Challenge 8d", isPowerOfTwo(0),  false) ? 0 : 1;

        // Challenge 9
        pass += check("Challenge 9a", gcd(12, 8),    4)  ? 1 : 0;
        fail += check("Challenge 9a", gcd(12, 8),    4)  ? 0 : 1;
        pass += check("Challenge 9b", gcd(100, 75),  25) ? 1 : 0;
        fail += check("Challenge 9b", gcd(100, 75),  25) ? 0 : 1;
        pass += check("Challenge 9c", gcd(7, 3),     1)  ? 1 : 0;
        fail += check("Challenge 9c", gcd(7, 3),     1)  ? 0 : 1;

        // Challenge 10
        pass += check("Challenge 10a", countPrimes(10), 4) ? 1 : 0;
        fail += check("Challenge 10a", countPrimes(10), 4) ? 0 : 1;
        pass += check("Challenge 10b", countPrimes(1),  0) ? 1 : 0;
        fail += check("Challenge 10b", countPrimes(1),  0) ? 0 : 1;
        pass += check("Challenge 10c", countPrimes(20), 8) ? 1 : 0;
        fail += check("Challenge 10c", countPrimes(20), 8) ? 0 : 1;

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
