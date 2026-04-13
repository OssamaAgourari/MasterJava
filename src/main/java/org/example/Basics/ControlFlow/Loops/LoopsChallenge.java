package org.example.Basics.ControlFlow.Loops;

import java.util.*;

/**
 * ============================================================
 *          LOOPS CHALLENGES — LeetCode Style
 * ============================================================
 */
public class LoopsChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Count Odd Numbers in an Interval Range
    // Count odd numbers in [low, high].
    // Example: low=3, high=7 → 3 (3,5,7)
    // =========================================================
    static int countOdds(int low, int high) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Fizz Buzz (return list)
    // Return string list of FizzBuzz from 1 to n.
    // Example: n=5 → ["1","2","Fizz","4","Buzz"]
    // =========================================================
    static List<String> fizzBuzz(int n) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Sum of Digits Until Single Digit
    // Repeatedly sum digits until single digit. (Digital root)
    // Example: 493→16→7
    // =========================================================
    static int addDigits(int num) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 4  [EASY]  — Power of Two
    // Return true if n is a power of two.
    // Example: 1→true, 16→true, 3→false
    // =========================================================
    static boolean isPowerOfTwo(int n) { return false; /* TODO: loop or bit trick */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Number of Steps to Reduce to Zero
    // If even: divide by 2. If odd: subtract 1. Count steps.
    // Example: 14→6 (14→7→6→3→2→1→0), 8→4
    // =========================================================
    static int numberOfSteps(int num) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Happy Number
    // A happy number eventually reaches 1 by replacing n with
    // the sum of squares of its digits.
    // Example: 19→1+81=82→68→100→1 → true
    // =========================================================
    static boolean isHappy(int n) { return false; /* TODO: Floyd's cycle or HashSet */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Ugly Number II
    // An ugly number has only prime factors 2, 3, 5.
    // Return the nth ugly number.
    // Example: n=10 → 12
    // =========================================================
    static int nthUglyNumber(int n) { return 0; /* TODO: three pointers */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Count Primes
    // Count primes strictly less than n.
    // Example: n=10 → 4 (2,3,5,7)
    // =========================================================
    static int countPrimes(int n) { return 0; /* TODO: Sieve of Eratosthenes */ }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]  — Excel Sheet Column Number
    // Convert column title to number. A=1, B=2, ..., Z=26, AA=27.
    // Example: "A"→1, "AB"→28, "ZY"→701
    // =========================================================
    static int titleToNumber(String columnTitle) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Integer to Roman
    // Convert integer to Roman numeral.
    // Example: 3→"III", 58→"LVIII", 1994→"MCMXCIV"
    // =========================================================
    static String intToRoman(int num) { return ""; /* TODO: greedy with value table */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", countOdds(3, 7),   3) ? 1:0; fail += check("C1a", countOdds(3, 7),   3) ? 0:1;
        pass += check("C1b", countOdds(2, 5),   2) ? 1:0; fail += check("C1b", countOdds(2, 5),   2) ? 0:1;

        pass += check("C2a", fizzBuzz(5).toString(), "[1, 2, Fizz, 4, Buzz]") ? 1:0;
        fail += check("C2a", fizzBuzz(5).toString(), "[1, 2, Fizz, 4, Buzz]") ? 0:1;

        pass += check("C3a", addDigits(493), 7) ? 1:0; fail += check("C3a", addDigits(493), 7) ? 0:1;
        pass += check("C3b", addDigits(0),   0) ? 1:0; fail += check("C3b", addDigits(0),   0) ? 0:1;

        pass += check("C4a", isPowerOfTwo(1),  true)  ? 1:0; fail += check("C4a", isPowerOfTwo(1),  true)  ? 0:1;
        pass += check("C4b", isPowerOfTwo(16), true)  ? 1:0; fail += check("C4b", isPowerOfTwo(16), true)  ? 0:1;
        pass += check("C4c", isPowerOfTwo(3),  false) ? 1:0; fail += check("C4c", isPowerOfTwo(3),  false) ? 0:1;

        pass += check("C5a", numberOfSteps(14), 6) ? 1:0; fail += check("C5a", numberOfSteps(14), 6) ? 0:1;
        pass += check("C5b", numberOfSteps(8),  4) ? 1:0; fail += check("C5b", numberOfSteps(8),  4) ? 0:1;

        pass += check("C6a", isHappy(19), true)  ? 1:0; fail += check("C6a", isHappy(19), true)  ? 0:1;
        pass += check("C6b", isHappy(2),  false) ? 1:0; fail += check("C6b", isHappy(2),  false) ? 0:1;

        pass += check("C7a", nthUglyNumber(10), 12) ? 1:0; fail += check("C7a", nthUglyNumber(10), 12) ? 0:1;
        pass += check("C7b", nthUglyNumber(1),   1) ? 1:0; fail += check("C7b", nthUglyNumber(1),   1) ? 0:1;

        pass += check("C8a", countPrimes(10), 4) ? 1:0; fail += check("C8a", countPrimes(10), 4) ? 0:1;
        pass += check("C8b", countPrimes(0),  0) ? 1:0; fail += check("C8b", countPrimes(0),  0) ? 0:1;

        pass += check("C9a", titleToNumber("A"),  1)   ? 1:0; fail += check("C9a", titleToNumber("A"),  1)   ? 0:1;
        pass += check("C9b", titleToNumber("AB"), 28)  ? 1:0; fail += check("C9b", titleToNumber("AB"), 28)  ? 0:1;
        pass += check("C9c", titleToNumber("ZY"), 701) ? 1:0; fail += check("C9c", titleToNumber("ZY"), 701) ? 0:1;

        pass += check("C10a", intToRoman(3),    "III")     ? 1:0; fail += check("C10a", intToRoman(3),    "III")     ? 0:1;
        pass += check("C10b", intToRoman(58),   "LVIII")   ? 1:0; fail += check("C10b", intToRoman(58),   "LVIII")   ? 0:1;
        pass += check("C10c", intToRoman(1994), "MCMXCIV") ? 1:0; fail += check("C10c", intToRoman(1994), "MCMXCIV") ? 0:1;

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
