package org.example.Basics.ControlFlow.SwitchStatements;

/**
 * ============================================================
 *     SWITCH STATEMENTS CHALLENGES — LeetCode Style
 * ============================================================
 */
public class SwitchStatementsChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Day of the Week
    // Given a date (day, month, year), return name of the day.
    // Use Zeller's or Tomohiko Sakamoto algorithm.
    // Example: day=31, month=8, year=2019 → "Saturday"
    // =========================================================
    static String dayOfTheWeek(int day, int month, int year) { return ""; /* TODO */ }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Strong Password Checker II
    // Password is strong if: ≥8 chars, contains uppercase, lowercase,
    // digit, special char, no two adjacent same chars.
    // Example: "IloveLe3tcode!" → true, "Me+You--IsMyDream" → false
    // =========================================================
    static boolean strongPasswordCheckerII(String password) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Number of Rectangles That Can Form The Largest Square
    // Each rectangle [li, wi]. Count those able to form largest possible square.
    // Example: [[5,8],[3,9],[5,12],[16,5]] → 3 (maxLen=5)
    // =========================================================
    static int countGoodRectangles(int[][] rectangles) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Roman to Integer
    // Convert Roman numeral to integer.
    // Example: "III"→3, "LVIII"→58, "MCMXCIV"→1994
    // =========================================================
    static int romanToInt(String s) { return 0; /* TODO: switch on chars */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Day of the Year
    // Return the day number (1-365/366) for given date string "YYYY-MM-DD".
    // Example: "2019-01-09"→9, "2019-02-10"→41
    // =========================================================
    static int dayOfYear(String date) { return 0; /* TODO: sum days in prior months */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Next Greater Element III
    // Find the smallest integer greater than n using same digits.
    // Return -1 if not possible or overflows int range.
    // Example: 12→21, 21→-1
    // =========================================================
    static int nextGreaterElement(int n) { return -1; /* TODO: next permutation */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Score of a String
    // Score = sum of absolute differences of adjacent ASCII values.
    // Example: "hello"→13 (|h-e|+|e-l|+|l-l|+|l-o|=3+7+0+3)
    // =========================================================
    static int scoreOfString(String s) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Calculate Amount Paid in Taxes
    // Brackets = [[upper, percent], ...], sorted by upper.
    // Example: brackets=[[3,50],[7,10],[12,25]], income=10 → 2.65
    // =========================================================
    static double calculateTax(int[][] brackets, int income) { return 0.0; /* TODO */ }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]  — Check if Grid Satisfies Conditions
    // Grid satisfies: same column values equal, adjacent column values differ.
    // Example: [[1,0,2],[1,0,2]] → true
    // =========================================================
    static boolean satisfiesConditions(int[][] grid) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Minimum Cost to Convert String I
    // Convert source to target using character mappings with costs.
    // Example: source="abcd",target="acbe",original=['a','b','c','c','e','d'],
    //          changed=['b','c','b','e','b','e'],cost=[2,5,5,1,2,20] → 28
    // =========================================================
    static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        return -1; /* TODO: Floyd-Warshall on 26 chars */
    }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", dayOfTheWeek(31, 8, 2019), "Saturday") ? 1:0;
        fail += check("C1a", dayOfTheWeek(31, 8, 2019), "Saturday") ? 0:1;
        pass += check("C1b", dayOfTheWeek(18, 7, 1999), "Sunday") ? 1:0;
        fail += check("C1b", dayOfTheWeek(18, 7, 1999), "Sunday") ? 0:1;

        pass += check("C2a", strongPasswordCheckerII("IloveLe3tcode!"), true)     ? 1:0;
        fail += check("C2a", strongPasswordCheckerII("IloveLe3tcode!"), true)     ? 0:1;
        pass += check("C2b", strongPasswordCheckerII("Me+You--IsMyDream"), false) ? 1:0;
        fail += check("C2b", strongPasswordCheckerII("Me+You--IsMyDream"), false) ? 0:1;

        pass += check("C3a", countGoodRectangles(new int[][]{{5,8},{3,9},{5,12},{16,5}}), 3) ? 1:0;
        fail += check("C3a", countGoodRectangles(new int[][]{{5,8},{3,9},{5,12},{16,5}}), 3) ? 0:1;

        pass += check("C4a", romanToInt("III"),     3)    ? 1:0; fail += check("C4a", romanToInt("III"),     3)    ? 0:1;
        pass += check("C4b", romanToInt("LVIII"),   58)   ? 1:0; fail += check("C4b", romanToInt("LVIII"),   58)   ? 0:1;
        pass += check("C4c", romanToInt("MCMXCIV"), 1994) ? 1:0; fail += check("C4c", romanToInt("MCMXCIV"), 1994) ? 0:1;

        pass += check("C5a", dayOfYear("2019-01-09"),  9)  ? 1:0; fail += check("C5a", dayOfYear("2019-01-09"),  9)  ? 0:1;
        pass += check("C5b", dayOfYear("2019-02-10"), 41)  ? 1:0; fail += check("C5b", dayOfYear("2019-02-10"), 41)  ? 0:1;
        pass += check("C5c", dayOfYear("2003-03-01"), 60)  ? 1:0; fail += check("C5c", dayOfYear("2003-03-01"), 60)  ? 0:1;

        pass += check("C6a", nextGreaterElement(12), 21) ? 1:0; fail += check("C6a", nextGreaterElement(12), 21) ? 0:1;
        pass += check("C6b", nextGreaterElement(21), -1) ? 1:0; fail += check("C6b", nextGreaterElement(21), -1) ? 0:1;

        pass += check("C7a", scoreOfString("hello"), 13) ? 1:0; fail += check("C7a", scoreOfString("hello"), 13) ? 0:1;
        pass += check("C7b", scoreOfString("zaz"),   50) ? 1:0; fail += check("C7b", scoreOfString("zaz"),   50) ? 0:1;

        pass += check("C8a", String.format("%.2f", calculateTax(new int[][]{{3,50},{7,10},{12,25}}, 10)), "2.65") ? 1:0;
        fail += check("C8a", String.format("%.2f", calculateTax(new int[][]{{3,50},{7,10},{12,25}}, 10)), "2.65") ? 0:1;

        pass += check("C9a", satisfiesConditions(new int[][]{{1,0,2},{1,0,2}}), true)  ? 1:0;
        fail += check("C9a", satisfiesConditions(new int[][]{{1,0,2},{1,0,2}}), true)  ? 0:1;
        pass += check("C9b", satisfiesConditions(new int[][]{{1,1,1},{0,0,0}}), false) ? 1:0;
        fail += check("C9b", satisfiesConditions(new int[][]{{1,1,1},{0,0,0}}), false) ? 0:1;

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
