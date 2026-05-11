package org.example.Basics.ControlFlow.Conditionals;

/**
 * ============================================================
 *          JAVA CONDITIONALS — COMPLETE GUIDE
 * ============================================================
 *
 * TYPES OF CONDITIONALS:
 * ----------------------
 *   if                  — single branch
 *   if-else             — two branches
 *   if-else if-else     — multi-branch
 *   switch (classic)    — discrete value matching
 *   switch expression   — Java 14+, returns value
 *   ternary ?:          — inline two-branch expression
 *
 * KEY RULES:
 * ----------
 *   - Condition must be boolean (not int like C)
 *   - Braces {} optional for single-line, but ALWAYS recommended
 *   - switch can use: int, char, String, enum (NOT float/long)
 *   - Fall-through in switch: without break, execution continues
 *   - Short-circuit: && stops at first false, || stops at first true
 *
 * TERNARY: condition ? valueIfTrue : valueIfFalse
 * ================================================
 */
public class Conditionals {

    // ── 1. Basic if-else ─────────────────────────────────────
    static String classify(int n) {
        if      (n > 0) return "positive";
        else if (n < 0) return "negative";
        else            return "zero";
    }

    // ── 2. Nested if ──────────────────────────────────────────
    static String grade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // ── 3. Ternary operator ───────────────────────────────────
    static int abs(int n) {
        return n >= 0 ? n : -n;
    }
    static int max(int a, int b) {
        return a > b ? a : b;
    }

    // ── 4. Classic switch (with fall-through demo) ────────────
    static String dayType(int day) {
        String type;
        switch (day) {
            case 1: case 7:
                type = "weekend"; break;
            case 2: case 3: case 4: case 5: case 6:
                type = "weekday"; break;
            default:
                type = "invalid";
        }
        return type;
    }

    // ── 5. Switch on String ───────────────────────────────────
    static int monthDays(String month) {
        switch (month.toLowerCase()) {
            case "january": case "march": case "may": case "july":
            case "august":  case "october": case "december":
                return 31;
            case "april": case "june": case "september": case "november":
                return 30;
            case "february":
                return 28; // simplified (ignoring leap year)
            default:
                return -1;
        }
    }

    // ── 6. Switch expression (Java 14+) ──────────────────────
    static String seasonOf(int month) {
        return switch (month) {
            case 12, 1, 2  -> "Winter";
            case 3,  4, 5  -> "Spring";
            case 6,  7, 8  -> "Summer";
            case 9,  10,11 -> "Autumn";
            default        -> "Unknown";
        };
    }

    // ── 7. Short-circuit evaluation ──────────────────────────
    static boolean safeCheck(int[] arr, int idx, int value) {
        // Without short-circuit, arr[idx] would throw if idx is invalid
        return idx >= 0 && idx < arr.length && arr[idx] == value;
    }

    // ── 8. Nested ternary (use sparingly) ─────────────────────
    static String fizzbuzz(int n) {
        return (n % 15 == 0) ? "FizzBuzz"
             : (n % 3  == 0) ? "Fizz"
             : (n % 5  == 0) ? "Buzz"
             : String.valueOf(n);
    }

    // ── 9. Boolean expressions ───────────────────────────────
    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // ── 10. Fall-through demonstration ───────────────────────
    static String trafficLight(String color) {
        StringBuilder action = new StringBuilder();
        switch (color) {
            case "red":
                action.append("STOP");
                break;
            case "yellow":
                action.append("SLOW DOWN");
                break;
            case "green":
                action.append("GO");
                break;
            default:
                action.append("UNKNOWN");
        }
        return action.toString();
    }

    public static void main(String[] args) {
        // 1. classify
        System.out.println(classify(5));   // positive
        System.out.println(classify(-3));  // negative
        System.out.println(classify(0));   // zero

        // 2. grades
        System.out.println(grade(95));  // A
        System.out.println(grade(82));  // B
        System.out.println(grade(45));  // F

        // 3. ternary
        System.out.println("abs(-7)=" + abs(-7));   // 7
        System.out.println("max(3,8)=" + max(3,8)); // 8

        // 4. day type
        System.out.println(dayType(1)); // weekend
        System.out.println(dayType(3)); // weekday

        // 5. month days
        System.out.println("January days: " + monthDays("January")); // 31
        System.out.println("April days:   " + monthDays("April"));   // 30

        // 6. switch expression
        System.out.println(seasonOf(7));  // Summer
        System.out.println(seasonOf(12)); // Winter

        // 7. short-circuit
        int[] arr = {10, 20, 30};
        System.out.println(safeCheck(arr, 5, 10)); // false (no AIOOBE)
        System.out.println(safeCheck(arr, 1, 20)); // true

        // 8. fizzbuzz
        for (int i = 1; i <= 15; i++) System.out.print(fizzbuzz(i) + " ");
        System.out.println();

        // 9. leap year
        System.out.println("2024 leap: " + isLeapYear(2024)); // true
        System.out.println("1900 leap: " + isLeapYear(1900)); // false
        System.out.println("2000 leap: " + isLeapYear(2000)); // true

        // 10. traffic light
        System.out.println(trafficLight("red"));    // STOP
        System.out.println(trafficLight("green"));  // GO

        System.out.println("\n=== Conditional Quick Reference ===");
        System.out.println("if/else   → general branching");
        System.out.println("switch    → discrete matching (int, String, enum)");
        System.out.println("ternary   → inline expression, avoid nesting");
        System.out.println("&&  ||    → short-circuit (right side may not evaluate)");
        System.out.println("&   |     → NO short-circuit (both sides always evaluate)");
    }
}
