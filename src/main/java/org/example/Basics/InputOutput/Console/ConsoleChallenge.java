package org.example.Basics.InputOutput.Console;

import java.util.Scanner;

/**
 * ============================================================
 *           CONSOLE I/O CHALLENGES — LeetCode Style
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
 * Note: Challenges use new Scanner(String) to simulate keyboard
 *       input so they can be tested automatically.
 * ============================================================
 */
public class ConsoleChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]
    // =========================================================
    // Parse Integer
    //
    // Parse and return the integer from the given string.
    // Return 0 if the string is not a valid integer.
    //
    // Example:
    //   Input: "42"   → 42
    //   Input: "-7"   → -7
    //   Input: "abc"  → 0
    //   Input: "3.5"  → 0
    // =========================================================
    static int parseInteger(String s) {
        // TODO: write your solution here

        return 0;
    }

    // =========================================================
    // CHALLENGE 2  [EASY]
    // =========================================================
    // Sum of Tokens
    //
    // Given a string of space-separated integers, return their sum.
    // Use Scanner to read the tokens.
    //
    // Example:
    //   Input: "1 2 3 4 5"    → 15
    //   Input: "10 -3 7"      → 14
    //   Input: "42"           → 42
    // =========================================================
    static int sumOfTokens(String input) {
        // TODO: write your solution here

        return 0;
    }

    // =========================================================
    // CHALLENGE 3  [EASY]
    // =========================================================
    // Count Words
    //
    // Return the number of whitespace-separated words in the string.
    //
    // Example:
    //   Input: "hello world"          → 2
    //   Input: "the quick brown fox"  → 4
    //   Input: "java"                 → 1
    //   Input: ""                     → 0
    // =========================================================
    static int countWords(String input) {
        // TODO: write your solution here

        return 0;
    }

    // =========================================================
    // CHALLENGE 4  [EASY]
    // =========================================================
    // First Token
    //
    // Return the first whitespace-separated token from input.
    // Return "" if input is empty or blank.
    //
    // Example:
    //   Input: "hello world"    → "hello"
    //   Input: "42 is the answer" → "42"
    //   Input: "   "            → ""
    // =========================================================
    static String firstToken(String input) {
        // TODO: write your solution here

        return "";
    }

    // =========================================================
    // CHALLENGE 5  [EASY]
    // =========================================================
    // Line Count
    //
    // Return the number of non-empty lines in the given string.
    // Lines are separated by "\n".
    //
    // Example:
    //   Input: "line1\nline2\nline3"  → 3
    //   Input: "only one"             → 1
    //   Input: "a\n\nb"              → 2  (empty line not counted)
    // =========================================================
    static int countNonEmptyLines(String input) {
        // TODO: write your solution here

        return 0;
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]
    // =========================================================
    // Max Token
    //
    // Given a string of space-separated integers, return the largest.
    // Assume at least one integer is present.
    //
    // Example:
    //   Input: "3 1 4 1 5 9 2 6"  → 9
    //   Input: "-5 -1 -3"          → -1
    //   Input: "42"                → 42
    // =========================================================
    static int maxToken(String input) {
        // TODO: write your solution here

        return Integer.MIN_VALUE;
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]
    // =========================================================
    // CSV Parser
    //
    // Given a comma-separated string, return an array of the trimmed tokens.
    // Use Scanner with a comma delimiter.
    //
    // Example:
    //   Input: "Alice,30,Engineer"     → ["Alice", "30", "Engineer"]
    //   Input: "a, b, c"              → ["a", " b", " c"]  (no trim needed)
    //   Input: "one,two"              → ["one", "two"]
    // =========================================================
    static String[] parseCSV(String input) {
        // TODO: write your solution here

        return new String[0];
    }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]
    // =========================================================
    // Count Valid Integers
    //
    // Given a string of space-separated tokens (some may not be integers),
    // return how many tokens are valid integers.
    //
    // Example:
    //   Input: "1 hello 3 world 5"  → 3
    //   Input: "abc def"            → 0
    //   Input: "10 20 30"           → 3
    // =========================================================
    static int countValidIntegers(String input) {
        // TODO: write your solution here

        return 0;
    }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]
    // =========================================================
    // Reverse Tokens
    //
    // Given a space-separated string, return a new string with the
    // tokens in reverse order.
    //
    // Example:
    //   Input: "one two three"  → "three two one"
    //   Input: "hello world"    → "world hello"
    //   Input: "solo"           → "solo"
    // =========================================================
    static String reverseTokens(String input) {
        // TODO: write your solution here

        return "";
    }

    // =========================================================
    // CHALLENGE 10  [HARD]
    // =========================================================
    // Simple Expression Evaluator
    //
    // Given a string in the form "a op b" where op is +, -, *, or /,
    // parse both integers and apply the operation. Return the integer result.
    // For division use integer division. Assume valid input.
    //
    // Example:
    //   Input: "10 + 5"   → 15
    //   Input: "10 - 3"   → 7
    //   Input: "4 * 7"    → 28
    //   Input: "20 / 4"   → 5
    //   Input: "7 / 2"    → 3  (integer division)
    // =========================================================
    static int evaluate(String expression) {
        // TODO: write your solution here

        return 0;
    }


    // ============================================================
    //  TEST RUNNER — do not modify
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // Challenge 1
        pass += check("Challenge 1a", parseInteger("42"),    42) ? 1 : 0;
        fail += check("Challenge 1a", parseInteger("42"),    42) ? 0 : 1;
        pass += check("Challenge 1b", parseInteger("-7"),    -7) ? 1 : 0;
        fail += check("Challenge 1b", parseInteger("-7"),    -7) ? 0 : 1;
        pass += check("Challenge 1c", parseInteger("abc"),    0) ? 1 : 0;
        fail += check("Challenge 1c", parseInteger("abc"),    0) ? 0 : 1;
        pass += check("Challenge 1d", parseInteger("3.5"),    0) ? 1 : 0;
        fail += check("Challenge 1d", parseInteger("3.5"),    0) ? 0 : 1;

        // Challenge 2
        pass += check("Challenge 2a", sumOfTokens("1 2 3 4 5"), 15) ? 1 : 0;
        fail += check("Challenge 2a", sumOfTokens("1 2 3 4 5"), 15) ? 0 : 1;
        pass += check("Challenge 2b", sumOfTokens("10 -3 7"),   14) ? 1 : 0;
        fail += check("Challenge 2b", sumOfTokens("10 -3 7"),   14) ? 0 : 1;
        pass += check("Challenge 2c", sumOfTokens("42"),        42) ? 1 : 0;
        fail += check("Challenge 2c", sumOfTokens("42"),        42) ? 0 : 1;

        // Challenge 3
        pass += check("Challenge 3a", countWords("hello world"),         2) ? 1 : 0;
        fail += check("Challenge 3a", countWords("hello world"),         2) ? 0 : 1;
        pass += check("Challenge 3b", countWords("the quick brown fox"), 4) ? 1 : 0;
        fail += check("Challenge 3b", countWords("the quick brown fox"), 4) ? 0 : 1;
        pass += check("Challenge 3c", countWords("java"),                1) ? 1 : 0;
        fail += check("Challenge 3c", countWords("java"),                1) ? 0 : 1;
        pass += check("Challenge 3d", countWords(""),                    0) ? 1 : 0;
        fail += check("Challenge 3d", countWords(""),                    0) ? 0 : 1;

        // Challenge 4
        pass += check("Challenge 4a", firstToken("hello world"),       "hello") ? 1 : 0;
        fail += check("Challenge 4a", firstToken("hello world"),       "hello") ? 0 : 1;
        pass += check("Challenge 4b", firstToken("42 is the answer"),  "42")    ? 1 : 0;
        fail += check("Challenge 4b", firstToken("42 is the answer"),  "42")    ? 0 : 1;
        pass += check("Challenge 4c", firstToken("   "),               "")      ? 1 : 0;
        fail += check("Challenge 4c", firstToken("   "),               "")      ? 0 : 1;

        // Challenge 5
        pass += check("Challenge 5a", countNonEmptyLines("line1\nline2\nline3"), 3) ? 1 : 0;
        fail += check("Challenge 5a", countNonEmptyLines("line1\nline2\nline3"), 3) ? 0 : 1;
        pass += check("Challenge 5b", countNonEmptyLines("only one"),            1) ? 1 : 0;
        fail += check("Challenge 5b", countNonEmptyLines("only one"),            1) ? 0 : 1;
        pass += check("Challenge 5c", countNonEmptyLines("a\n\nb"),              2) ? 1 : 0;
        fail += check("Challenge 5c", countNonEmptyLines("a\n\nb"),              2) ? 0 : 1;

        // Challenge 6
        pass += check("Challenge 6a", maxToken("3 1 4 1 5 9 2 6"),  9)  ? 1 : 0;
        fail += check("Challenge 6a", maxToken("3 1 4 1 5 9 2 6"),  9)  ? 0 : 1;
        pass += check("Challenge 6b", maxToken("-5 -1 -3"),         -1) ? 1 : 0;
        fail += check("Challenge 6b", maxToken("-5 -1 -3"),         -1) ? 0 : 1;
        pass += check("Challenge 6c", maxToken("42"),               42) ? 1 : 0;
        fail += check("Challenge 6c", maxToken("42"),               42) ? 0 : 1;

        // Challenge 7
        pass += checkArr("Challenge 7a", parseCSV("Alice,30,Engineer"), new String[]{"Alice","30","Engineer"}) ? 1 : 0;
        fail += checkArr("Challenge 7a", parseCSV("Alice,30,Engineer"), new String[]{"Alice","30","Engineer"}) ? 0 : 1;
        pass += checkArr("Challenge 7b", parseCSV("one,two"),           new String[]{"one","two"})             ? 1 : 0;
        fail += checkArr("Challenge 7b", parseCSV("one,two"),           new String[]{"one","two"})             ? 0 : 1;

        // Challenge 8
        pass += check("Challenge 8a", countValidIntegers("1 hello 3 world 5"), 3) ? 1 : 0;
        fail += check("Challenge 8a", countValidIntegers("1 hello 3 world 5"), 3) ? 0 : 1;
        pass += check("Challenge 8b", countValidIntegers("abc def"),            0) ? 1 : 0;
        fail += check("Challenge 8b", countValidIntegers("abc def"),            0) ? 0 : 1;
        pass += check("Challenge 8c", countValidIntegers("10 20 30"),           3) ? 1 : 0;
        fail += check("Challenge 8c", countValidIntegers("10 20 30"),           3) ? 0 : 1;

        // Challenge 9
        pass += check("Challenge 9a", reverseTokens("one two three"), "three two one") ? 1 : 0;
        fail += check("Challenge 9a", reverseTokens("one two three"), "three two one") ? 0 : 1;
        pass += check("Challenge 9b", reverseTokens("hello world"),   "world hello")   ? 1 : 0;
        fail += check("Challenge 9b", reverseTokens("hello world"),   "world hello")   ? 0 : 1;
        pass += check("Challenge 9c", reverseTokens("solo"),          "solo")          ? 1 : 0;
        fail += check("Challenge 9c", reverseTokens("solo"),          "solo")          ? 0 : 1;

        // Challenge 10
        pass += check("Challenge 10a", evaluate("10 + 5"),  15) ? 1 : 0;
        fail += check("Challenge 10a", evaluate("10 + 5"),  15) ? 0 : 1;
        pass += check("Challenge 10b", evaluate("10 - 3"),   7) ? 1 : 0;
        fail += check("Challenge 10b", evaluate("10 - 3"),   7) ? 0 : 1;
        pass += check("Challenge 10c", evaluate("4 * 7"),   28) ? 1 : 0;
        fail += check("Challenge 10c", evaluate("4 * 7"),   28) ? 0 : 1;
        pass += check("Challenge 10d", evaluate("20 / 4"),   5) ? 1 : 0;
        fail += check("Challenge 10d", evaluate("20 / 4"),   5) ? 0 : 1;
        pass += check("Challenge 10e", evaluate("7 / 2"),    3) ? 1 : 0;
        fail += check("Challenge 10e", evaluate("7 / 2"),    3) ? 0 : 1;

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

    private static boolean checkArr(String name, String[] got, String[] expected) {
        boolean ok = java.util.Arrays.equals(got, expected);
        System.out.printf("%-15s %s  (expected: %s | got: %s)%n",
                name, ok ? "✔ PASS" : "✘ FAIL",
                java.util.Arrays.toString(expected),
                java.util.Arrays.toString(got));
        return ok;
    }
}
