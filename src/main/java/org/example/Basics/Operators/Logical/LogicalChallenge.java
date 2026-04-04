package org.example.Basics.Operators.Logical;

/**
 * ============================================================
 *           LOGICAL OPERATORS CHALLENGES — LeetCode Style
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
public class LogicalChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]
    // =========================================================
    // Both Positive
    //
    // Return true if both a and b are positive (> 0).
    //
    // Example:
    //   Input: 3, 5   → true
    //   Input: -1, 5  → false
    //   Input: 0, 5   → false
    // =========================================================
    static boolean bothPositive(int a, int b) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 2  [EASY]
    // =========================================================
    // At Least One Negative
    //
    // Return true if at least one of a or b is negative (< 0).
    //
    // Example:
    //   Input: -1, 5  → true
    //   Input: 3, -7  → true
    //   Input: 3, 5   → false
    //   Input: 0, -2  → true
    // =========================================================
    static boolean atLeastOneNegative(int a, int b) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 3  [EASY]
    // =========================================================
    // Is Valid Triangle
    //
    // Three sides form a valid triangle if each side is less than
    // the sum of the other two (and all sides > 0).
    //
    // Example:
    //   Input: 3, 4, 5  → true
    //   Input: 1, 1, 3  → false
    //   Input: 5, 5, 5  → true
    // =========================================================
    static boolean isValidTriangle(int a, int b, int c) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 4  [EASY]
    // =========================================================
    // Is Non-Empty String
    //
    // Return true if s is not null AND not empty (length > 0)
    // AND not blank (not only whitespace).
    //
    // Example:
    //   Input: "hello"   → true
    //   Input: ""        → false
    //   Input: "  "      → false
    //   Input: null      → false
    // =========================================================
    static boolean isNonBlank(String s) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 5  [EASY]
    // =========================================================
    // Exactly One True
    //
    // Return true if exactly one of a, b, c is true.
    // (XOR-like but for three values)
    //
    // Example:
    //   Input: true, false, false  → true
    //   Input: true, true, false   → false
    //   Input: false, false, false → false
    // =========================================================
    static boolean exactlyOneTrue(boolean a, boolean b, boolean c) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]
    // =========================================================
    // Is Divisible By Both
    //
    // Return true if n is divisible by both 3 and 5.
    //
    // Example:
    //   Input: 15 → true
    //   Input: 9  → false
    //   Input: 30 → true
    //   Input: 10 → false
    // =========================================================
    static boolean divisibleBy3And5(int n) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]
    // =========================================================
    // Can Vote
    //
    // A person can vote if they are at least 18 years old
    // AND they are a citizen (isCitizen = true).
    //
    // Example:
    //   Input: 20, true   → true
    //   Input: 17, true   → false
    //   Input: 25, false  → false
    // =========================================================
    static boolean canVote(int age, boolean isCitizen) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]
    // =========================================================
    // Is Palindrome String
    //
    // Return true if s reads the same forwards and backwards.
    // Ignore case. Handle null by returning false.
    //
    // Example:
    //   Input: "racecar"  → true
    //   Input: "Racecar"  → true
    //   Input: "hello"    → false
    //   Input: null       → false
    // =========================================================
    static boolean isPalindrome(String s) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]
    // =========================================================
    // Password Validator
    //
    // A password is valid if ALL of these are true:
    //   - length >= 8
    //   - contains at least one digit
    //   - contains at least one uppercase letter
    //   - contains at least one lowercase letter
    //
    // Example:
    //   Input: "Secure1!"  → true
    //   Input: "password"  → false  (no digit, no uppercase)
    //   Input: "SHORT1A"   → false  (too short, no lowercase)
    // =========================================================
    static boolean isValidPassword(String password) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 10  [HARD]
    // =========================================================
    // All Same Sign
    //
    // Return true if all integers in the array have the same sign
    // (all positive, all negative, or all zero counts as all same).
    // An empty array returns true.
    //
    // Example:
    //   Input: [1, 2, 3]    → true  (all positive)
    //   Input: [-1, -2, -3] → true  (all negative)
    //   Input: [1, -1, 2]   → false
    //   Input: []           → true
    // =========================================================
    static boolean allSameSign(int[] nums) {
        // TODO: write your solution here

        return false;
    }


    // ============================================================
    //  TEST RUNNER — do not modify
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // Challenge 1
        pass += check("Challenge 1a", bothPositive(3, 5),   true)  ? 1 : 0;
        fail += check("Challenge 1a", bothPositive(3, 5),   true)  ? 0 : 1;
        pass += check("Challenge 1b", bothPositive(-1, 5),  false) ? 1 : 0;
        fail += check("Challenge 1b", bothPositive(-1, 5),  false) ? 0 : 1;
        pass += check("Challenge 1c", bothPositive(0, 5),   false) ? 1 : 0;
        fail += check("Challenge 1c", bothPositive(0, 5),   false) ? 0 : 1;

        // Challenge 2
        pass += check("Challenge 2a", atLeastOneNegative(-1, 5),  true)  ? 1 : 0;
        fail += check("Challenge 2a", atLeastOneNegative(-1, 5),  true)  ? 0 : 1;
        pass += check("Challenge 2b", atLeastOneNegative(3, -7),  true)  ? 1 : 0;
        fail += check("Challenge 2b", atLeastOneNegative(3, -7),  true)  ? 0 : 1;
        pass += check("Challenge 2c", atLeastOneNegative(3, 5),   false) ? 1 : 0;
        fail += check("Challenge 2c", atLeastOneNegative(3, 5),   false) ? 0 : 1;

        // Challenge 3
        pass += check("Challenge 3a", isValidTriangle(3, 4, 5), true)  ? 1 : 0;
        fail += check("Challenge 3a", isValidTriangle(3, 4, 5), true)  ? 0 : 1;
        pass += check("Challenge 3b", isValidTriangle(1, 1, 3), false) ? 1 : 0;
        fail += check("Challenge 3b", isValidTriangle(1, 1, 3), false) ? 0 : 1;
        pass += check("Challenge 3c", isValidTriangle(5, 5, 5), true)  ? 1 : 0;
        fail += check("Challenge 3c", isValidTriangle(5, 5, 5), true)  ? 0 : 1;

        // Challenge 4
        pass += check("Challenge 4a", isNonBlank("hello"), true)  ? 1 : 0;
        fail += check("Challenge 4a", isNonBlank("hello"), true)  ? 0 : 1;
        pass += check("Challenge 4b", isNonBlank(""),      false) ? 1 : 0;
        fail += check("Challenge 4b", isNonBlank(""),      false) ? 0 : 1;
        pass += check("Challenge 4c", isNonBlank("  "),    false) ? 1 : 0;
        fail += check("Challenge 4c", isNonBlank("  "),    false) ? 0 : 1;
        pass += check("Challenge 4d", isNonBlank(null),    false) ? 1 : 0;
        fail += check("Challenge 4d", isNonBlank(null),    false) ? 0 : 1;

        // Challenge 5
        pass += check("Challenge 5a", exactlyOneTrue(true,  false, false), true)  ? 1 : 0;
        fail += check("Challenge 5a", exactlyOneTrue(true,  false, false), true)  ? 0 : 1;
        pass += check("Challenge 5b", exactlyOneTrue(true,  true,  false), false) ? 1 : 0;
        fail += check("Challenge 5b", exactlyOneTrue(true,  true,  false), false) ? 0 : 1;
        pass += check("Challenge 5c", exactlyOneTrue(false, false, false), false) ? 1 : 0;
        fail += check("Challenge 5c", exactlyOneTrue(false, false, false), false) ? 0 : 1;

        // Challenge 6
        pass += check("Challenge 6a", divisibleBy3And5(15), true)  ? 1 : 0;
        fail += check("Challenge 6a", divisibleBy3And5(15), true)  ? 0 : 1;
        pass += check("Challenge 6b", divisibleBy3And5(9),  false) ? 1 : 0;
        fail += check("Challenge 6b", divisibleBy3And5(9),  false) ? 0 : 1;
        pass += check("Challenge 6c", divisibleBy3And5(30), true)  ? 1 : 0;
        fail += check("Challenge 6c", divisibleBy3And5(30), true)  ? 0 : 1;
        pass += check("Challenge 6d", divisibleBy3And5(10), false) ? 1 : 0;
        fail += check("Challenge 6d", divisibleBy3And5(10), false) ? 0 : 1;

        // Challenge 7
        pass += check("Challenge 7a", canVote(20, true),  true)  ? 1 : 0;
        fail += check("Challenge 7a", canVote(20, true),  true)  ? 0 : 1;
        pass += check("Challenge 7b", canVote(17, true),  false) ? 1 : 0;
        fail += check("Challenge 7b", canVote(17, true),  false) ? 0 : 1;
        pass += check("Challenge 7c", canVote(25, false), false) ? 1 : 0;
        fail += check("Challenge 7c", canVote(25, false), false) ? 0 : 1;

        // Challenge 8
        pass += check("Challenge 8a", isPalindrome("racecar"), true)  ? 1 : 0;
        fail += check("Challenge 8a", isPalindrome("racecar"), true)  ? 0 : 1;
        pass += check("Challenge 8b", isPalindrome("Racecar"), true)  ? 1 : 0;
        fail += check("Challenge 8b", isPalindrome("Racecar"), true)  ? 0 : 1;
        pass += check("Challenge 8c", isPalindrome("hello"),   false) ? 1 : 0;
        fail += check("Challenge 8c", isPalindrome("hello"),   false) ? 0 : 1;
        pass += check("Challenge 8d", isPalindrome(null),      false) ? 1 : 0;
        fail += check("Challenge 8d", isPalindrome(null),      false) ? 0 : 1;

        // Challenge 9
        pass += check("Challenge 9a", isValidPassword("Secure1!"), true)  ? 1 : 0;
        fail += check("Challenge 9a", isValidPassword("Secure1!"), true)  ? 0 : 1;
        pass += check("Challenge 9b", isValidPassword("password"), false) ? 1 : 0;
        fail += check("Challenge 9b", isValidPassword("password"), false) ? 0 : 1;
        pass += check("Challenge 9c", isValidPassword("SHORT1A"),  false) ? 1 : 0;
        fail += check("Challenge 9c", isValidPassword("SHORT1A"),  false) ? 0 : 1;

        // Challenge 10
        pass += check("Challenge 10a", allSameSign(new int[]{1,2,3}),    true)  ? 1 : 0;
        fail += check("Challenge 10a", allSameSign(new int[]{1,2,3}),    true)  ? 0 : 1;
        pass += check("Challenge 10b", allSameSign(new int[]{-1,-2,-3}), true)  ? 1 : 0;
        fail += check("Challenge 10b", allSameSign(new int[]{-1,-2,-3}), true)  ? 0 : 1;
        pass += check("Challenge 10c", allSameSign(new int[]{1,-1,2}),   false) ? 1 : 0;
        fail += check("Challenge 10c", allSameSign(new int[]{1,-1,2}),   false) ? 0 : 1;
        pass += check("Challenge 10d", allSameSign(new int[]{}),         true)  ? 1 : 0;
        fail += check("Challenge 10d", allSameSign(new int[]{}),         true)  ? 0 : 1;

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
