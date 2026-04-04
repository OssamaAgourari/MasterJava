package org.example.Basics.Operators.Arithmetic;

/**
 * ============================================================
 *              JAVA ARITHMETIC OPERATORS - COMPLETE GUIDE
 * ============================================================
 *
 * WHAT ARE ARITHMETIC OPERATORS?
 * --------------------------------
 * Arithmetic operators perform basic math on numeric values.
 *
 * OPERATOR TABLE:
 * ---------------
 *   Operator | Name           | Example   | Result
 *   ---------|----------------|-----------|-------
 *   +        | Addition       | 5 + 3     | 8
 *   -        | Subtraction    | 5 - 3     | 2
 *   *        | Multiplication | 5 * 3     | 15
 *   /        | Division       | 5 / 2     | 2  (integer division!)
 *   %        | Modulo         | 5 % 2     | 1  (remainder)
 *   ++       | Increment      | x++ / ++x | x + 1
 *   --       | Decrement      | x-- / --x | x - 1
 *
 * IMPORTANT NOTES:
 * ----------------
 * 1. Integer division truncates the decimal part: 7 / 2 = 3 (not 3.5)
 *    Cast to double for decimal result: (double) 7 / 2 = 3.5
 *
 * 2. Modulo works with negatives:  -7 % 3 = -1  (result has sign of dividend)
 *
 * 3. Prefix vs Postfix:
 *    int x = 5;
 *    System.out.println(x++); // prints 5, then x becomes 6
 *    System.out.println(++x); // x becomes 7, then prints 7
 *
 * 4. Type promotion: mixing int and double promotes to double.
 *    int a = 5; double b = 2.0; → a / b = 2.5  (double result)
 *
 * 5. Overflow: int arithmetic wraps around silently.
 *    Integer.MAX_VALUE + 1 → Integer.MIN_VALUE (no exception!)
 *    Use long or Math.addExact() to detect overflow.
 *
 * COMPOUND ASSIGNMENT:
 * --------------------
 *   x += 5   →  x = x + 5
 *   x -= 5   →  x = x - 5
 *   x *= 5   →  x = x * 5
 *   x /= 5   →  x = x / 5
 *   x %= 5   →  x = x % 5
 *
 * OPERATOR PRECEDENCE (high to low):
 * ------------------------------------
 *   1. () parentheses
 *   2. ++ --  (prefix)
 *   3. * / %
 *   4. + -
 *   5. ++ --  (postfix)
 *
 * USEFUL Math CLASS METHODS:
 * ---------------------------
 *   Math.abs(x)          → absolute value
 *   Math.pow(base, exp)  → exponentiation (returns double)
 *   Math.sqrt(x)         → square root (returns double)
 *   Math.floor(x)        → round down
 *   Math.ceil(x)         → round up
 *   Math.round(x)        → round to nearest
 *   Math.max(a, b)       → larger value
 *   Math.min(a, b)       → smaller value
 *   Math.addExact(a, b)  → throws ArithmeticException on overflow
 *
 * ============================================================
 */
public class Arithmetic {
    public static void main(String[] args) {

        // --------------------------------------------------------
        // EXERCISE 1: Basic arithmetic
        // --------------------------------------------------------
        int a = 17, b = 5;
        System.out.println(a + b);  // 22
        System.out.println(a - b);  // 12
        System.out.println(a * b);  // 85
        System.out.println(a / b);  // 3  (integer division)
        System.out.println(a % b);  // 2  (remainder)

        // --------------------------------------------------------
        // EXERCISE 2: Integer division vs floating-point division
        // --------------------------------------------------------
        int x = 7, y = 2;
        System.out.println(x / y);             // 3  (truncated)
        System.out.println((double) x / y);    // 3.5
        System.out.println(x / (double) y);    // 3.5
        System.out.println((double)(x / y));   // 3.0 (division happens first!)

        // --------------------------------------------------------
        // EXERCISE 3: Modulo — remainder and useful patterns
        // --------------------------------------------------------
        System.out.println(10 % 3);   // 1
        System.out.println(-10 % 3);  // -1 (sign follows dividend)
        System.out.println(10 % -3);  // 1
        // Common use: check even/odd
        for (int i = 1; i <= 6; i++) {
            System.out.println(i + " → " + (i % 2 == 0 ? "even" : "odd"));
        }

        // --------------------------------------------------------
        // EXERCISE 4: Prefix vs postfix increment/decrement
        // --------------------------------------------------------
        int n = 10;
        System.out.println(n++);  // 10 — prints first, then increments
        System.out.println(n);    // 11
        System.out.println(++n);  // 12 — increments first, then prints
        System.out.println(n--);  // 12 — prints first, then decrements
        System.out.println(n);    // 11

        // --------------------------------------------------------
        // EXERCISE 5: Compound assignment operators
        // --------------------------------------------------------
        int c = 20;
        c += 5;   System.out.println(c); // 25
        c -= 3;   System.out.println(c); // 22
        c *= 2;   System.out.println(c); // 44
        c /= 4;   System.out.println(c); // 11
        c %= 3;   System.out.println(c); // 2

        // --------------------------------------------------------
        // EXERCISE 6: Operator precedence
        // --------------------------------------------------------
        System.out.println(2 + 3 * 4);      // 14  (* before +)
        System.out.println((2 + 3) * 4);    // 20  (parentheses first)
        System.out.println(10 - 2 + 3);     // 11  (left to right)
        System.out.println(10 - (2 + 3));   // 5

        // --------------------------------------------------------
        // EXERCISE 7: Type promotion
        // --------------------------------------------------------
        int  i   = 5;
        double d = 2.0;
        System.out.println(i + d);   // 7.0  (int promoted to double)
        System.out.println(i / d);   // 2.5
        byte  byt = 10;
        short sho = 20;
        // byte + short → int (both promoted)
        int result = byt + sho;
        System.out.println(result);  // 30

        // --------------------------------------------------------
        // EXERCISE 8: Overflow
        // --------------------------------------------------------
        int max = Integer.MAX_VALUE;
        System.out.println(max);         //  2147483647
        System.out.println(max + 1);     // -2147483648  (wraps around!)
        long safe = (long) max + 1;
        System.out.println(safe);        //  2147483648  (safe)

        // --------------------------------------------------------
        // EXERCISE 9: Math utility methods
        // --------------------------------------------------------
        System.out.println(Math.abs(-42));          // 42
        System.out.println(Math.pow(2, 10));        // 1024.0
        System.out.println(Math.sqrt(144));         // 12.0
        System.out.println(Math.max(99, 7));        // 99
        System.out.println(Math.min(99, 7));        // 7
        System.out.println((int) Math.floor(3.9));  // 3
        System.out.println((int) Math.ceil(3.1));   // 4
        System.out.println(Math.round(3.5));        // 4

        // --------------------------------------------------------
        // EXERCISE 10: Gauss formula — sum of 1 to N
        // --------------------------------------------------------
        int N = 100;
        int sum = N * (N + 1) / 2;
        System.out.println("Sum 1 to " + N + " = " + sum); // 5050

        // --------------------------------------------------------
        // EXERCISE 11: Swap using arithmetic (no temp variable)
        // --------------------------------------------------------
        int p = 5, q = 9;
        System.out.println("Before: p=" + p + ", q=" + q);
        p = p + q;
        q = p - q;
        p = p - q;
        System.out.println("After:  p=" + p + ", q=" + q); // p=9, q=5

        // --------------------------------------------------------
        // EXERCISE 12: Extract digits from a number
        // --------------------------------------------------------
        int number = 9382;
        System.out.println("Number: " + number);
        while (number > 0) {
            System.out.print(number % 10 + " ");  // last digit each time
            number /= 10;
        }
        System.out.println();  // 2 8 3 9 (reversed)

        // --------------------------------------------------------
        // EXERCISE 13: Random number in range [min, max]
        // Formula: (int)(Math.random() * (max - min + 1)) + min
        // --------------------------------------------------------
        int min = 1, max2 = 6;
        int dice = (int) (Math.random() * (max2 - min + 1)) + min;
        System.out.println("Dice roll: " + dice);  // 1 to 6

        // --------------------------------------------------------
        // EXERCISE 14: FizzBuzz (uses both % and +)
        // --------------------------------------------------------
        for (int k = 1; k <= 20; k++) {
            if      (k % 15 == 0) System.out.print("FizzBuzz ");
            else if (k % 3  == 0) System.out.print("Fizz ");
            else if (k % 5  == 0) System.out.print("Buzz ");
            else                  System.out.print(k + " ");
        }
        System.out.println();

        // --------------------------------------------------------
        // EXERCISE 15: Compute average with integer vs double division
        // --------------------------------------------------------
        int[] scores = {80, 90, 70, 85, 95};
        int total = 0;
        for (int s : scores) total += s;
        System.out.println("Average (int div):    " + total / scores.length);         // 84
        System.out.println("Average (double div): " + (double) total / scores.length); // 84.0

        // --------------------------------------------------------
        // SUMMARY
        // --------------------------------------------------------
        System.out.println("\n=== Arithmetic Quick Reference ===");
        int demo = 17;
        System.out.println("17 + 5  = " + (demo + 5));
        System.out.println("17 - 5  = " + (demo - 5));
        System.out.println("17 * 5  = " + (demo * 5));
        System.out.println("17 / 5  = " + (demo / 5) + "  (int division)");
        System.out.println("17 % 5  = " + (demo % 5) + "  (remainder)");
        System.out.println("17.0/5  = " + (demo / 5.0) + " (double division)");
    }
}
