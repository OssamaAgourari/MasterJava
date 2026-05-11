package org.example.Basics.ControlFlow.SwitchStatements;

/**
 * ============================================================
 *        JAVA SWITCH STATEMENTS — COMPLETE GUIDE
 * ============================================================
 *
 * SWITCH VARIANTS:
 * ----------------
 *   1. Classic switch statement  — Java 1.0+
 *   2. Switch with return        — inside a method
 *   3. Switch expression         — Java 14+, returns a value
 *   4. Pattern matching switch   — Java 21+ (preview earlier)
 *
 * SUPPORTED TYPES:
 * ----------------
 *   byte, short, char, int      — always supported
 *   String                       — Java 7+
 *   enum                         — Java 5+
 *   Long, Float, Double          — NOT supported
 *
 * FALL-THROUGH:
 * -------------
 *   Without break, execution FALLS THROUGH to next case.
 *   Can be intentional (grouping cases) or a bug.
 *   Switch expression syntax (->) has NO fall-through.
 *
 * SWITCH vs IF-ELSE:
 * ------------------
 *   switch → compiled to tableswitch/lookupswitch bytecode (O(1) for dense ranges)
 *   if-else → linear O(n) evaluation
 *   switch is faster for many discrete cases
 *
 * ============================================================
 */
public class SwitchStatements {

    // ── 1. Classic switch — day name ─────────────────────────
    static String dayName(int day) {
        String name;
        switch (day) {
            case 1: name = "Monday";    break;
            case 2: name = "Tuesday";   break;
            case 3: name = "Wednesday"; break;
            case 4: name = "Thursday";  break;
            case 5: name = "Friday";    break;
            case 6: name = "Saturday";  break;
            case 7: name = "Sunday";    break;
            default: name = "Invalid";
        }
        return name;
    }

    // ── 2. Fall-through: group cases ─────────────────────────
    static String quarter(int month) {
        switch (month) {
            case 1: case 2: case 3:  return "Q1";
            case 4: case 5: case 6:  return "Q2";
            case 7: case 8: case 9:  return "Q3";
            case 10: case 11: case 12: return "Q4";
            default: return "Invalid";
        }
    }

    // ── 3. Switch on String ───────────────────────────────────
    static String direction(String dir) {
        switch (dir.toUpperCase()) {
            case "N": case "NORTH": return "Going North";
            case "S": case "SOUTH": return "Going South";
            case "E": case "EAST":  return "Going East";
            case "W": case "WEST":  return "Going West";
            default: return "Unknown direction";
        }
    }

    // ── 4. Switch expression (Java 14+) — arrow syntax ────────
    static int daysInMonth(int month, int year) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11            -> 30;
            case 2 -> (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? 29 : 28;
            default -> throw new IllegalArgumentException("Invalid month: " + month);
        };
    }

    // ── 5. Switch expression with yield ──────────────────────
    // yield is needed when using blocks (multi-statement) in switch expr
    static String classify(double bmi) {
        int category = bmi < 18.5 ? 0 : bmi < 25 ? 1 : bmi < 30 ? 2 : 3;
        return switch (category) {
            case 0 -> "Underweight";
            case 1 -> "Normal";
            case 2 -> {
                String msg = "Overweight";
                yield msg + " (watch diet)";
            }
            default -> "Obese";
        };
    }

    // ── 6. Enum in switch ─────────────────────────────────────
    enum Planet { MERCURY, VENUS, EARTH, MARS }

    static String describe(Planet p) {
        return switch (p) {
            case MERCURY -> "Closest to Sun";
            case VENUS   -> "Hottest planet";
            case EARTH   -> "Our home";
            case MARS    -> "The Red Planet";
        };
    }

    // ── 7. Calculator with switch ─────────────────────────────
    static double calculate(double a, char op, double b) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> b != 0 ? a / b : Double.NaN;
            default  -> throw new IllegalArgumentException("Unknown op: " + op);
        };
    }

    // ── 8. Nested switch ──────────────────────────────────────
    static String transport(String day, String weather) {
        switch (day) {
            case "Saturday": case "Sunday":
                switch (weather) {
                    case "sunny": return "bike";
                    case "rainy": return "car";
                    default:      return "walk";
                }
            default:
                return "public transport";
        }
    }

    // ── 9. Switch returning enum ──────────────────────────────
    enum Season { SPRING, SUMMER, AUTUMN, WINTER }

    static Season getSeason(int month) {
        return switch (month) {
            case 3,  4,  5  -> Season.SPRING;
            case 6,  7,  8  -> Season.SUMMER;
            case 9,  10, 11 -> Season.AUTUMN;
            case 12, 1,  2  -> Season.WINTER;
            default -> throw new IllegalArgumentException("Invalid month");
        };
    }

    // ── 10. Intentional fall-through (accumulate) ─────────────
    static String cumulativePermissions(int level) {
        // Level 3 gets all permissions cumulatively
        StringBuilder perms = new StringBuilder();
        switch (level) {
            case 3: perms.append("ADMIN ");  // fall through
            case 2: perms.append("WRITE ");  // fall through
            case 1: perms.append("READ");
                    break;
            default: perms.append("NONE");
        }
        return perms.toString().trim();
    }

    public static void main(String[] args) {
        // 1. Day names
        for (int i = 1; i <= 7; i++)
            System.out.print(dayName(i) + " ");
        System.out.println();

        // 2. Quarter
        System.out.println("Month 5 → " + quarter(5));  // Q2
        System.out.println("Month 11 → " + quarter(11)); // Q4

        // 3. Direction
        System.out.println(direction("N"));     // Going North
        System.out.println(direction("WEST"));  // Going West

        // 4. Days in month
        System.out.println("Feb 2024: " + daysInMonth(2, 2024)); // 29
        System.out.println("Feb 2023: " + daysInMonth(2, 2023)); // 28

        // 5. BMI classify
        System.out.println("BMI 17.5: " + classify(17.5)); // Underweight
        System.out.println("BMI 27.0: " + classify(27.0)); // Overweight (watch diet)

        // 6. Planet
        System.out.println(describe(Planet.EARTH)); // Our home

        // 7. Calculator
        System.out.println("5 + 3 = " + calculate(5, '+', 3));  // 8.0
        System.out.println("10 / 2 = " + calculate(10, '/', 2)); // 5.0

        // 8. Transport
        System.out.println("Saturday sunny: " + transport("Saturday", "sunny")); // bike
        System.out.println("Monday sunny:   " + transport("Monday", "sunny"));   // public transport

        // 9. Season
        System.out.println("Month 7: " + getSeason(7));  // SUMMER
        System.out.println("Month 12: " + getSeason(12)); // WINTER

        // 10. Cumulative permissions
        System.out.println("Level 1: " + cumulativePermissions(1)); // READ
        System.out.println("Level 2: " + cumulativePermissions(2)); // WRITE READ
        System.out.println("Level 3: " + cumulativePermissions(3)); // ADMIN WRITE READ

        System.out.println("\n=== Switch Quick Reference ===");
        System.out.println("Classic:    switch(x) { case v: ... break; }");
        System.out.println("Expression: switch(x) { case v -> result; }");
        System.out.println("Fall-through: NO break → next case executes");
        System.out.println("yield: return value from block in switch expr");
        System.out.println("Types: int, char, String, enum — NOT long/double");
    }
}
