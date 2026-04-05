package org.example.Basics.InputOutput.Formatted;

/**
 * ============================================================
 *         FORMATTED OUTPUT CHALLENGES — LeetCode Style
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
 * Note: All challenges return a String so they can be tested
 *       automatically without capturing stdout.
 * ============================================================
 */
public class FormattedChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]
    // =========================================================
    // Format Double
    //
    // Return the double formatted to exactly 2 decimal places.
    //
    // Example:
    //   Input: 3.14159  → "3.14"
    //   Input: 1.0      → "1.00"
    //   Input: 100.999  → "101.00"  (rounded)
    // =========================================================
    static String formatDouble(double value) {
        // TODO: write your solution here

        return "";
    }

    // =========================================================
    // CHALLENGE 2  [EASY]
    // =========================================================
    // Zero Pad Integer
    //
    // Return the integer formatted with leading zeros to fill width 6.
    //
    // Example:
    //   Input: 42    → "000042"
    //   Input: 1000  → "001000"
    //   Input: 123456 → "123456"
    // =========================================================
    static String zeroPad(int n) {
        // TODO: write your solution here

        return "";
    }

    // =========================================================
    // CHALLENGE 3  [EASY]
    // =========================================================
    // Left Align String
    //
    // Return the string left-aligned in a field of width 10,
    // padded with spaces on the right.
    //
    // Example:
    //   Input: "hi"    → "hi        "  (8 trailing spaces)
    //   Input: "Java"  → "Java      "  (6 trailing spaces)
    //   Input: "toolongstr" → "toolongstr" (no truncation if >= 10)
    // =========================================================
    static String leftAlign(String s) {
        // TODO: write your solution here

        return "";
    }

    // =========================================================
    // CHALLENGE 4  [EASY]
    // =========================================================
    // Format Currency
    //
    // Return the amount formatted as a dollar amount with
    // grouping separator and 2 decimal places.
    //
    // Example:
    //   Input: 1234.5   → "$1,234.50"
    //   Input: 1000000  → "$1,000,000.00"
    //   Input: 9.99     → "$9.99"
    // =========================================================
    static String formatCurrency(double amount) {
        // TODO: write your solution here

        return "";
    }

    // =========================================================
    // CHALLENGE 5  [EASY]
    // =========================================================
    // Format Greeting
    //
    // Return a string in the format:
    //   "Hello, {name}! You are {age} years old."
    //
    // Example:
    //   Input: "Alice", 30  → "Hello, Alice! You are 30 years old."
    //   Input: "Bob",   25  → "Hello, Bob! You are 25 years old."
    // =========================================================
    static String formatGreeting(String name, int age) {
        // TODO: write your solution here

        return "";
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]
    // =========================================================
    // Format Table Row
    //
    // Return a formatted row string with three fixed-width columns:
    //   - Name: left-aligned in 15 chars
    //   - Age:  right-aligned in 5 chars
    //   - Score: right-aligned in 8 chars with 2 decimal places
    //
    // Example:
    //   Input: "Alice", 30, 95.5  → "Alice              30    95.50"
    //                                 ^15 chars        ^5    ^8.2f
    // =========================================================
    static String formatTableRow(String name, int age, double score) {
        // TODO: write your solution here

        return "";
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]
    // =========================================================
    // Format Percentage
    //
    // Given a value between 0.0 and 1.0, return it formatted as
    // a percentage with 1 decimal place, followed by "%".
    //
    // Example:
    //   Input: 0.87654  → "87.7%"
    //   Input: 0.5      → "50.0%"
    //   Input: 1.0      → "100.0%"
    // =========================================================
    static String formatPercentage(double ratio) {
        // TODO: write your solution here

        return "";
    }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]
    // =========================================================
    // Format Phone Number
    //
    // Given a 10-digit string of digits, format it as "(XXX) XXX-XXXX".
    //
    // Example:
    //   Input: "1234567890"  → "(123) 456-7890"
    //   Input: "5559876543"  → "(555) 987-6543"
    // =========================================================
    static String formatPhoneNumber(String digits) {
        // TODO: write your solution here

        return "";
    }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]
    // =========================================================
    // Format Hex Color
    //
    // Given three integers r, g, b (0-255 each), return the
    // CSS hex color string in the form "#RRGGBB" (uppercase).
    //
    // Example:
    //   Input: 255, 0, 0    → "#FF0000"
    //   Input: 0, 128, 255  → "#0080FF"
    //   Input: 0, 0, 0      → "#000000"
    // =========================================================
    static String formatHexColor(int r, int g, int b) {
        // TODO: write your solution here

        return "";
    }

    // =========================================================
    // CHALLENGE 10  [HARD]
    // =========================================================
    // Format Receipt
    //
    // Given parallel arrays of item names and prices, return a
    // formatted receipt string. Each line: item name left-aligned
    // in 20 chars, price right-aligned with 2 decimal places in
    // 8 chars. Add a separator line of 28 dashes and a TOTAL line.
    //
    // Example:
    //   names:  ["Apple", "Banana", "Cherry"]
    //   prices: [1.50, 0.75, 3.25]
    //
    //   Output (exact format):
    //   "Apple               $  1.50\n" +
    //   "Banana              $  0.75\n" +
    //   "Cherry              $  3.25\n" +
    //   "----------------------------\n" +
    //   "TOTAL               $  5.50"
    // =========================================================
    static String formatReceipt(String[] names, double[] prices) {
        // TODO: write your solution here

        return "";
    }


    // ============================================================
    //  TEST RUNNER — do not modify
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // Challenge 1
        pass += check("Challenge 1a", formatDouble(3.14159),  "3.14")   ? 1 : 0;
        fail += check("Challenge 1a", formatDouble(3.14159),  "3.14")   ? 0 : 1;
        pass += check("Challenge 1b", formatDouble(1.0),      "1.00")   ? 1 : 0;
        fail += check("Challenge 1b", formatDouble(1.0),      "1.00")   ? 0 : 1;
        pass += check("Challenge 1c", formatDouble(100.999),  "101.00") ? 1 : 0;
        fail += check("Challenge 1c", formatDouble(100.999),  "101.00") ? 0 : 1;

        // Challenge 2
        pass += check("Challenge 2a", zeroPad(42),     "000042") ? 1 : 0;
        fail += check("Challenge 2a", zeroPad(42),     "000042") ? 0 : 1;
        pass += check("Challenge 2b", zeroPad(1000),   "001000") ? 1 : 0;
        fail += check("Challenge 2b", zeroPad(1000),   "001000") ? 0 : 1;
        pass += check("Challenge 2c", zeroPad(123456), "123456") ? 1 : 0;
        fail += check("Challenge 2c", zeroPad(123456), "123456") ? 0 : 1;

        // Challenge 3
        pass += check("Challenge 3a", leftAlign("hi"),   "hi        ") ? 1 : 0;
        fail += check("Challenge 3a", leftAlign("hi"),   "hi        ") ? 0 : 1;
        pass += check("Challenge 3b", leftAlign("Java"), "Java      ") ? 1 : 0;
        fail += check("Challenge 3b", leftAlign("Java"), "Java      ") ? 0 : 1;

        // Challenge 4
        pass += check("Challenge 4a", formatCurrency(1234.5),    "$1,234.50")     ? 1 : 0;
        fail += check("Challenge 4a", formatCurrency(1234.5),    "$1,234.50")     ? 0 : 1;
        pass += check("Challenge 4b", formatCurrency(1000000),   "$1,000,000.00") ? 1 : 0;
        fail += check("Challenge 4b", formatCurrency(1000000),   "$1,000,000.00") ? 0 : 1;
        pass += check("Challenge 4c", formatCurrency(9.99),      "$9.99")         ? 1 : 0;
        fail += check("Challenge 4c", formatCurrency(9.99),      "$9.99")         ? 0 : 1;

        // Challenge 5
        pass += check("Challenge 5a", formatGreeting("Alice", 30), "Hello, Alice! You are 30 years old.") ? 1 : 0;
        fail += check("Challenge 5a", formatGreeting("Alice", 30), "Hello, Alice! You are 30 years old.") ? 0 : 1;
        pass += check("Challenge 5b", formatGreeting("Bob",   25), "Hello, Bob! You are 25 years old.")   ? 1 : 0;
        fail += check("Challenge 5b", formatGreeting("Bob",   25), "Hello, Bob! You are 25 years old.")   ? 0 : 1;

        // Challenge 6
        pass += check("Challenge 6a", formatTableRow("Alice", 30, 95.5),
                                      "Alice              30    95.50") ? 1 : 0;
        fail += check("Challenge 6a", formatTableRow("Alice", 30, 95.5),
                                      "Alice              30    95.50") ? 0 : 1;

        // Challenge 7
        pass += check("Challenge 7a", formatPercentage(0.87654), "87.7%")  ? 1 : 0;
        fail += check("Challenge 7a", formatPercentage(0.87654), "87.7%")  ? 0 : 1;
        pass += check("Challenge 7b", formatPercentage(0.5),     "50.0%")  ? 1 : 0;
        fail += check("Challenge 7b", formatPercentage(0.5),     "50.0%")  ? 0 : 1;
        pass += check("Challenge 7c", formatPercentage(1.0),     "100.0%") ? 1 : 0;
        fail += check("Challenge 7c", formatPercentage(1.0),     "100.0%") ? 0 : 1;

        // Challenge 8
        pass += check("Challenge 8a", formatPhoneNumber("1234567890"), "(123) 456-7890") ? 1 : 0;
        fail += check("Challenge 8a", formatPhoneNumber("1234567890"), "(123) 456-7890") ? 0 : 1;
        pass += check("Challenge 8b", formatPhoneNumber("5559876543"), "(555) 987-6543") ? 1 : 0;
        fail += check("Challenge 8b", formatPhoneNumber("5559876543"), "(555) 987-6543") ? 0 : 1;

        // Challenge 9
        pass += check("Challenge 9a", formatHexColor(255,   0,   0), "#FF0000") ? 1 : 0;
        fail += check("Challenge 9a", formatHexColor(255,   0,   0), "#FF0000") ? 0 : 1;
        pass += check("Challenge 9b", formatHexColor(  0, 128, 255), "#0080FF") ? 1 : 0;
        fail += check("Challenge 9b", formatHexColor(  0, 128, 255), "#0080FF") ? 0 : 1;
        pass += check("Challenge 9c", formatHexColor(  0,   0,   0), "#000000") ? 1 : 0;
        fail += check("Challenge 9c", formatHexColor(  0,   0,   0), "#000000") ? 0 : 1;

        // Challenge 10
        String expectedReceipt =
                "Apple               $  1.50\n" +
                "Banana              $  0.75\n" +
                "Cherry              $  3.25\n" +
                "----------------------------\n" +
                "TOTAL               $  5.50";
        pass += check("Challenge 10a",
                formatReceipt(new String[]{"Apple","Banana","Cherry"}, new double[]{1.50, 0.75, 3.25}),
                expectedReceipt) ? 1 : 0;
        fail += check("Challenge 10a",
                formatReceipt(new String[]{"Apple","Banana","Cherry"}, new double[]{1.50, 0.75, 3.25}),
                expectedReceipt) ? 0 : 1;

        System.out.println("\n==============================");
        System.out.println("  RESULTS: " + pass + " passed, " + fail + " failed");
        System.out.println("==============================");
    }

    // ---- helper ----
    private static boolean check(String name, Object got, Object expected) {
        boolean ok = String.valueOf(got).equals(String.valueOf(expected));
        System.out.printf("%-15s %s  (expected: %s | got: %s)%n",
                name, ok ? "✔ PASS" : "✘ FAIL", expected, got);
        return ok;
    }
}
