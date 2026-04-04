package org.example.Basics.Operators.Logical;

/**
 * ============================================================
 *             JAVA LOGICAL OPERATORS - COMPLETE GUIDE
 * ============================================================
 *
 * WHAT ARE LOGICAL OPERATORS?
 * ----------------------------
 * Logical operators combine or invert boolean expressions.
 * They always return a boolean (true or false).
 *
 * OPERATOR TABLE:
 * ---------------
 *   Operator | Name        | Description
 *   ---------|-------------|-------------------------------------------
 *   &&       | AND         | true if BOTH operands are true
 *   ||       | OR          | true if AT LEAST ONE operand is true
 *   !        | NOT         | inverts the boolean (true → false)
 *   ^        | XOR         | true if operands are DIFFERENT (rare)
 *
 * TRUTH TABLES:
 * -------------
 *   A     | B     | A && B | A || B | !A    | A ^ B
 *   -------|-------|--------|--------|-------|------
 *   true  | true  | true   | true   | false | false
 *   true  | false | false  | true   | false | true
 *   false | true  | false  | true   | true  | true
 *   false | false | false  | false  | true  | false
 *
 * SHORT-CIRCUIT EVALUATION (CRITICAL!):
 * ---------------------------------------
 * && stops evaluating as soon as it finds a false:
 *   false && expensive()  → expensive() is NEVER called
 *
 * || stops evaluating as soon as it finds a true:
 *   true  || expensive()  → expensive() is NEVER called
 *
 * This is used for safe null checks:
 *   str != null && str.length() > 0   ← safe: if str is null, length() is never called
 *   str == null || str.isEmpty()       ← safe: if str is null, isEmpty() is never called
 *
 * NON-SHORT-CIRCUIT VARIANTS (rare):
 * ------------------------------------
 *   &   always evaluates BOTH sides (even if result is determined)
 *   |   always evaluates BOTH sides
 *   These are mainly used for bitwise operations on integers.
 *
 * OPERATOR PRECEDENCE (high to low):
 * ------------------------------------
 *   1. ! (NOT)
 *   2. && (AND)
 *   3. || (OR)
 *
 *   Use parentheses to make intent clear:
 *   a || b && c   →  a || (b && c)   (&& binds tighter)
 *
 * DE MORGAN'S LAWS:
 * ------------------
 *   !(A && B)  ==  !A || !B
 *   !(A || B)  ==  !A && !B
 *
 *   Useful for simplifying or refactoring conditions.
 *
 * TERNARY OPERATOR (related):
 * ----------------------------
 *   condition ? valueIfTrue : valueIfFalse
 *   int max = a > b ? a : b;
 *
 * ============================================================
 */
public class Logical {
    public static void main(String[] args) {

        // --------------------------------------------------------
        // EXERCISE 1: Basic && (AND)
        // --------------------------------------------------------
        boolean a = true, b = false, c = true;
        System.out.println(a && c);  // true  — both true
        System.out.println(a && b);  // false — one is false
        System.out.println(b && b);  // false

        // --------------------------------------------------------
        // EXERCISE 2: Basic || (OR)
        // --------------------------------------------------------
        System.out.println(a || b);  // true  — at least one true
        System.out.println(b || b);  // false — both false
        System.out.println(b || c);  // true

        // --------------------------------------------------------
        // EXERCISE 3: ! (NOT)
        // --------------------------------------------------------
        System.out.println(!a);      // false
        System.out.println(!b);      // true
        System.out.println(!(a && b)); // true  — !(true && false) = !false = true

        // --------------------------------------------------------
        // EXERCISE 4: XOR ^ (exclusive OR)
        // true only when operands DIFFER
        // --------------------------------------------------------
        System.out.println(a ^ b);  // true  (true != false)
        System.out.println(a ^ c);  // false (true == true)
        System.out.println(b ^ b);  // false (false == false)

        // --------------------------------------------------------
        // EXERCISE 5: Combining operators — precedence
        // --------------------------------------------------------
        System.out.println(true || false && false);   // true  — && first: true || false
        System.out.println((true || false) && false); // false — || first: true && false

        // --------------------------------------------------------
        // EXERCISE 6: Short-circuit — && stops on first false
        // --------------------------------------------------------
        int x = 0;
        boolean result = (x != 0) && (10 / x > 1);  // 10/x never evaluated (no division by zero)
        System.out.println(result);  // false — safe!

        // --------------------------------------------------------
        // EXERCISE 7: Short-circuit — || stops on first true
        // --------------------------------------------------------
        String str = null;
        boolean isEmpty = (str == null) || str.isEmpty();  // str.isEmpty() never called
        System.out.println(isEmpty);  // true — safe!

        // --------------------------------------------------------
        // EXERCISE 8: Compound boolean conditions
        // --------------------------------------------------------
        int age  = 22;
        boolean hasLicense = true;
        boolean canDrive = age >= 16 && hasLicense;
        System.out.println("Can drive: " + canDrive); // true

        int temp = 35;
        boolean isHot  = temp > 30;
        boolean isRainy = false;
        boolean stayInside = isHot || isRainy;
        System.out.println("Stay inside: " + stayInside); // true

        // --------------------------------------------------------
        // EXERCISE 9: De Morgan's Laws
        // !(A && B) == !A || !B
        // !(A || B) == !A && !B
        // --------------------------------------------------------
        boolean p = true, q = false;
        System.out.println(!(p && q));       // true
        System.out.println(!p || !q);        // true  — same result (De Morgan)
        System.out.println(!(p || q));       // false
        System.out.println(!p && !q);        // false — same result (De Morgan)

        // --------------------------------------------------------
        // EXERCISE 10: Null-safe string check (short-circuit)
        // --------------------------------------------------------
        String s1 = "hello";
        String s2 = null;
        System.out.println(s1 != null && !s1.isEmpty()); // true
        System.out.println(s2 != null && !s2.isEmpty()); // false (no NPE — short-circuits)
        System.out.println(s2 == null || s2.isEmpty());  // true  (no NPE — short-circuits)

        // --------------------------------------------------------
        // EXERCISE 11: Ternary operator
        // --------------------------------------------------------
        int score = 78;
        String grade = score >= 60 ? "Pass" : "Fail";
        System.out.println("Grade: " + grade); // Pass

        int n = -5;
        int abs = n >= 0 ? n : -n;
        System.out.println("Abs of -5: " + abs); // 5

        // --------------------------------------------------------
        // EXERCISE 12: Nested ternary (use sparingly)
        // --------------------------------------------------------
        int val = 0;
        String sign = val > 0 ? "positive" : val < 0 ? "negative" : "zero";
        System.out.println(sign); // zero

        // --------------------------------------------------------
        // EXERCISE 13: toggle a boolean
        // --------------------------------------------------------
        boolean flag = true;
        flag = !flag;
        System.out.println(flag);  // false
        flag = !flag;
        System.out.println(flag);  // true

        // --------------------------------------------------------
        // EXERCISE 14: Count how many conditions are true
        // --------------------------------------------------------
        boolean cond1 = true, cond2 = false, cond3 = true;
        int trueCount = (cond1 ? 1 : 0) + (cond2 ? 1 : 0) + (cond3 ? 1 : 0);
        System.out.println("True conditions: " + trueCount); // 2

        // --------------------------------------------------------
        // EXERCISE 15: Validate input (combining multiple checks)
        // --------------------------------------------------------
        String username = "Alice";
        String password = "securePass1";
        boolean usernameValid = username != null && username.length() >= 3;
        boolean passwordValid = password != null && password.length() >= 8;
        boolean loginOk = usernameValid && passwordValid;
        System.out.println("Login valid: " + loginOk); // true

        // --------------------------------------------------------
        // SUMMARY
        // --------------------------------------------------------
        System.out.println("\n=== Logical Operators Quick Reference ===");
        System.out.println("true  && true  = " + (true  && true));
        System.out.println("true  && false = " + (true  && false));
        System.out.println("false || true  = " + (false || true));
        System.out.println("false || false = " + (false || false));
        System.out.println("!true          = " + (!true));
        System.out.println("!false         = " + (!false));
        System.out.println("true  ^ false  = " + (true  ^ false));
        System.out.println("true  ^ true   = " + (true  ^ true));
    }
}
