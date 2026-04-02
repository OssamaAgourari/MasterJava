package org.example.Basics.VariablesAndDataTypes.Booleans;

/**
 * ============================================================
 *             JAVA boolean TYPE - COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS A boolean?
 * ------------------
 * - A boolean holds only TWO possible values: true or false.
 * - It is the result of any comparison or logical expression.
 * - Size: not precisely defined by the JVM spec (typically 1 bit of data,
 *   but stored as 1 byte in practice).
 * - The wrapper class is Boolean (java.lang.Boolean).
 *
 * DECLARATION:
 * ------------
 *   boolean flag = true;
 *   boolean isReady = false;
 *   Boolean obj = true;           // autoboxing: boolean → Boolean
 *
 * WHERE BOOLEANS COME FROM:
 * -------------------------
 * - Comparison operators  →  a == b, a != b, a > b, a < b, a >= b, a <= b
 * - Logical operators     →  result of &&, ||, !
 * - Method return values  →  str.isEmpty(), list.contains(x), ...
 * - Direct assignment     →  boolean b = true;
 *
 * LOGICAL OPERATORS:
 * ------------------
 *   &&   AND  — true if BOTH sides are true
 *   ||   OR   — true if AT LEAST ONE side is true
 *   !    NOT  — inverts the value
 *   ^    XOR  — true if sides are DIFFERENT
 *
 * SHORT-CIRCUIT EVALUATION:
 * -------------------------
 * - &&  stops evaluating if the LEFT side is false (no need to check right)
 * - ||  stops evaluating if the LEFT side is true  (no need to check right)
 * - This prevents NullPointerException:
 *   if (str != null && str.isEmpty()) { ... }   ← safe
 *
 * BITWISE LOGICAL (non-short-circuit):
 * -------------------------------------
 *   &   evaluates BOTH sides always (bitwise AND)
 *   |   evaluates BOTH sides always (bitwise OR)
 *
 * TRUTH TABLE:
 * ------------
 *   A     | B     | A&&B  | A||B  | !A   | A^B
 *   -------|-------|-------|-------|------|-----
 *   true  | true  | true  | true  | false| false
 *   true  | false | false | true  | false| true
 *   false | true  | false | true  | true | true
 *   false | false | false | false | true | false
 *
 * ============================================================
 *           Boolean WRAPPER CLASS METHODS
 * ============================================================
 *
 * CONSTANTS:
 *   Boolean.TRUE           → Boolean object true
 *   Boolean.FALSE          → Boolean object false
 *
 * METHODS:
 *   Boolean.parseBoolean(str)  → "true" → true, anything else → false
 *   Boolean.valueOf(bool)      → boolean → Boolean object
 *   Boolean.toString(bool)     → boolean → "true" or "false"
 *   Boolean.compare(a, b)      → compares two booleans (false < true)
 *   Boolean.logicalAnd(a, b)   → same as a && b
 *   Boolean.logicalOr(a, b)    → same as a || b
 *   Boolean.logicalXor(a, b)   → same as a ^ b
 *   .compareTo(other)          → instance method comparison
 *   .equals(other)             → content comparison
 *
 * ============================================================
 *          boolean in control flow
 * ============================================================
 *
 *   if (condition) { ... }
 *   while (condition) { ... }
 *   for (int i = 0; condition; i++) { ... }
 *   result = condition ? valueIfTrue : valueIfFalse;   // ternary
 *
 * ============================================================
 */
public class Booleans {
    public static void main(String[] args) {

        // --------------------------------------------------------
        // EXERCISE 1: Basic declaration
        // --------------------------------------------------------
        boolean isJavaFun  = true;
        boolean isHard     = false;
        System.out.println("Java is fun:  " + isJavaFun);  // true
        System.out.println("Java is hard: " + isHard);     // false

        // --------------------------------------------------------
        // EXERCISE 2: Booleans from comparisons
        // --------------------------------------------------------
        int a = 10, b = 20;
        System.out.println(a == b);   // false
        System.out.println(a != b);   // true
        System.out.println(a < b);    // true
        System.out.println(a > b);    // false
        System.out.println(a <= 10);  // true
        System.out.println(a >= b);   // false

        // --------------------------------------------------------
        // EXERCISE 3: Logical AND (&&)
        // true only if BOTH are true
        // --------------------------------------------------------
        boolean x = true, y = false;
        System.out.println(x && x);   // true
        System.out.println(x && y);   // false
        System.out.println(y && y);   // false

        // --------------------------------------------------------
        // EXERCISE 4: Logical OR (||)
        // true if AT LEAST ONE is true
        // --------------------------------------------------------
        System.out.println(x || y);   // true
        System.out.println(y || y);   // false
        System.out.println(x || x);   // true

        // --------------------------------------------------------
        // EXERCISE 5: Logical NOT (!)
        // --------------------------------------------------------
        System.out.println(!true);    // false
        System.out.println(!false);   // true
        System.out.println(!x);       // false

        // --------------------------------------------------------
        // EXERCISE 6: XOR (^) — true when values are DIFFERENT
        // --------------------------------------------------------
        System.out.println(true  ^ true);   // false
        System.out.println(true  ^ false);  // true
        System.out.println(false ^ false);  // false

        // --------------------------------------------------------
        // EXERCISE 7: Short-circuit evaluation
        // --------------------------------------------------------
        String str = null;
        // Safe: str != null is false, so str.isEmpty() is never called
        if (str != null && str.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println("null or non-empty — no NullPointerException!"); // this runs
        }

        // --------------------------------------------------------
        // EXERCISE 8: Ternary operator ? :
        // Compact if-else that returns a value.
        // --------------------------------------------------------
        int age = 20;
        String status = age >= 18 ? "adult" : "minor";
        System.out.println(status); // adult

        int score = 75;
        String grade = score >= 90 ? "A" :
                       score >= 80 ? "B" :
                       score >= 70 ? "C" :
                       score >= 60 ? "D" : "F";
        System.out.println("Grade: " + grade); // C

        // --------------------------------------------------------
        // EXERCISE 9: Boolean.parseBoolean()
        // "true" (case-insensitive) → true, everything else → false
        // --------------------------------------------------------
        System.out.println(Boolean.parseBoolean("true"));   // true
        System.out.println(Boolean.parseBoolean("TRUE"));   // true
        System.out.println(Boolean.parseBoolean("yes"));    // false (not "true")
        System.out.println(Boolean.parseBoolean("1"));      // false (not "true")
        System.out.println(Boolean.parseBoolean("false"));  // false

        // --------------------------------------------------------
        // EXERCISE 10: Boolean.compare()
        // false (0) < true (1) → negative if a < b, 0 if equal, positive if a > b
        // --------------------------------------------------------
        System.out.println(Boolean.compare(true,  true));   //  0
        System.out.println(Boolean.compare(false, true));   // -1
        System.out.println(Boolean.compare(true,  false));  //  1

        // --------------------------------------------------------
        // EXERCISE 11: Boolean.logicalAnd, logicalOr, logicalXor
        // --------------------------------------------------------
        System.out.println(Boolean.logicalAnd(true,  false)); // false
        System.out.println(Boolean.logicalOr (false, true));  // true
        System.out.println(Boolean.logicalXor(true,  true));  // false

        // --------------------------------------------------------
        // EXERCISE 12: Boolean in a loop
        // --------------------------------------------------------
        boolean keepGoing = true;
        int count = 0;
        while (keepGoing) {
            count++;
            if (count >= 5) keepGoing = false;
        }
        System.out.println("Loop ran " + count + " times"); // 5

        // --------------------------------------------------------
        // EXERCISE 13: Toggle a boolean
        // --------------------------------------------------------
        boolean isOn = false;
        System.out.println("isOn: " + isOn); // false
        isOn = !isOn;
        System.out.println("isOn: " + isOn); // true
        isOn = !isOn;
        System.out.println("isOn: " + isOn); // false

        // --------------------------------------------------------
        // EXERCISE 14: Combining conditions
        // --------------------------------------------------------
        int num = 15;
        boolean divisibleBy3 = num % 3 == 0;
        boolean divisibleBy5 = num % 5 == 0;
        boolean divisibleBy15 = divisibleBy3 && divisibleBy5;
        System.out.println(num + " divisible by 3:  " + divisibleBy3);  // true
        System.out.println(num + " divisible by 5:  " + divisibleBy5);  // true
        System.out.println(num + " divisible by 15: " + divisibleBy15); // true

        // --------------------------------------------------------
        // EXERCISE 15: Boolean from String methods
        // --------------------------------------------------------
        String email = "user@example.com";
        boolean isValid = email.contains("@") && email.endsWith(".com");
        System.out.println("Email valid: " + isValid); // true

        String password = "Abc123!";
        boolean hasUpper  = !password.equals(password.toLowerCase());
        boolean hasDigit  = password.chars().anyMatch(Character::isDigit);
        boolean longEnough = password.length() >= 6;
        boolean strongPwd = hasUpper && hasDigit && longEnough;
        System.out.println("Strong password: " + strongPwd); // true

        // --------------------------------------------------------
        // EXERCISE 16: autoboxing and equals
        // --------------------------------------------------------
        Boolean b1 = true;
        Boolean b2 = Boolean.valueOf("true");
        System.out.println(b1 == b2);       // true (Boolean caches TRUE/FALSE)
        System.out.println(b1.equals(b2));  // true

        // --------------------------------------------------------
        // SUMMARY
        // --------------------------------------------------------
        System.out.println("\n=== Boolean Quick Reference ===");
        boolean demo = true;
        System.out.println("Value:       " + demo);
        System.out.println("NOT:         " + !demo);
        System.out.println("AND false:   " + (demo && false));
        System.out.println("OR false:    " + (demo || false));
        System.out.println("XOR true:    " + (demo ^ true));
        System.out.println("toString:    " + Boolean.toString(demo));
        System.out.println("compare(T,F):" + Boolean.compare(true, false));
    }
}
