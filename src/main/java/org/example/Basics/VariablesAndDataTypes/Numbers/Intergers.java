package org.example.Basics.VariablesAndDataTypes.Numbers;

/**
 * ============================================================
 *                  JAVA INTEGERS - COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS AN INTEGER?
 * -------------------
 * - An integer is a whole number (no decimal point).
 * - Java has TWO forms:
 *     1. Primitive: int, byte, short, long
 *     2. Wrapper Object: Integer (java.lang.Integer)
 * - Primitives are faster and stored on the stack.
 * - Wrapper objects are needed for collections (List, Map, etc.)
 *   and provide utility methods.
 *
 * INTEGER TYPES & RANGES:
 * -----------------------
 *   Type    | Size   | Min Value             | Max Value
 *   --------|--------|-----------------------|----------------------
 *   byte    | 8-bit  | -128                  | 127
 *   short   | 16-bit | -32,768               | 32,767
 *   int     | 32-bit | -2,147,483,648        | 2,147,483,647
 *   long    | 64-bit | -9,223,372,036,854... | 9,223,372,036,854...
 *
 * DECLARATION:
 * ------------
 *   int a = 10;
 *   long b = 10L;              // L suffix required for long literals
 *   int hex = 0xFF;            // hexadecimal (255)
 *   int bin = 0b1010;          // binary (10)
 *   int oct = 017;             // octal (15)
 *   int big = 1_000_000;       // underscores for readability (Java 7+)
 *   Integer obj = 42;          // autoboxing: int → Integer
 *   int prim = obj;            // unboxing: Integer → int
 *
 * AUTOBOXING & UNBOXING:
 * ----------------------
 * - Java automatically converts between int and Integer.
 * - Integer cache: values -128 to 127 are cached.
 *   Integer a = 127; Integer b = 127; → a == b is TRUE (cached)
 *   Integer a = 128; Integer b = 128; → a == b is FALSE (new objects)
 *   Always use .equals() to compare Integer objects.
 *
 * ARITHMETIC OPERATORS:
 * ---------------------
 *   +   addition
 *   -   subtraction
 *   *   multiplication
 *   /   division (integer division — truncates decimal)
 *   %   modulo (remainder)
 *   ++  increment (prefix: ++x, postfix: x++)
 *   --  decrement (prefix: --x, postfix: x--)
 *
 * BITWISE OPERATORS:
 * ------------------
 *   &   AND        (5 & 3 = 1)
 *   |   OR         (5 | 3 = 7)
 *   ^   XOR        (5 ^ 3 = 6)
 *   ~   NOT        (~5 = -6)
 *   <<  left shift  (1 << 3 = 8)
 *   >>  right shift (8 >> 1 = 4)
 *   >>> unsigned right shift
 *
 * ============================================================
 *              Integer WRAPPER CLASS METHODS
 * ============================================================
 *
 * CONSTANTS:
 *   Integer.MAX_VALUE          → 2,147,483,647
 *   Integer.MIN_VALUE          → -2,147,483,648
 *   Integer.SIZE               → 32 (bits)
 *   Integer.BYTES              → 4 (bytes)
 *
 * PARSING & CONVERSION:
 *   Integer.parseInt(str)      → String to int
 *   Integer.parseInt(str, radix) → parse in given base (e.g. base 16)
 *   Integer.valueOf(str)       → String to Integer object
 *   Integer.valueOf(int)       → int to Integer object
 *   Integer.toString(n)        → int to String
 *   Integer.toString(n, radix) → int to String in given base
 *   Integer.toBinaryString(n)  → int to binary String
 *   Integer.toHexString(n)     → int to hex String
 *   Integer.toOctalString(n)   → int to octal String
 *
 * MATH UTILITIES:
 *   Integer.max(a, b)          → larger of two ints
 *   Integer.min(a, b)          → smaller of two ints
 *   Integer.sum(a, b)          → sum of two ints
 *   Integer.compare(a, b)      → compares two ints (-1, 0, 1)
 *   Integer.reverse(n)         → reverses bits
 *   Integer.bitCount(n)        → number of 1-bits
 *   Integer.highestOneBit(n)   → highest power of 2 ≤ n
 *   Integer.numberOfLeadingZeros(n)
 *   Integer.numberOfTrailingZeros(n)
 *   Integer.signum(n)          → -1, 0, or 1
 *
 * Math CLASS (java.lang.Math):
 *   Math.abs(n)                → absolute value
 *   Math.pow(base, exp)        → power (returns double)
 *   Math.sqrt(n)               → square root (returns double)
 *   Math.max(a, b)             → max of two numbers
 *   Math.min(a, b)             → min of two numbers
 *   Math.floor(d)              → round down
 *   Math.ceil(d)               → round up
 *   Math.round(d)              → round to nearest
 *   Math.random()              → random double [0.0, 1.0)
 *
 * ============================================================
 *        int vs Integer vs long vs BigInteger
 * ============================================================
 *
 *  Type         | Use when
 *  -------------|--------------------------------------------------
 *  int          | default choice for whole numbers
 *  long         | numbers beyond ±2.1 billion (add L suffix)
 *  Integer      | need null, collections, or wrapper methods
 *  BigInteger   | arbitrarily large numbers (java.math.BigInteger)
 *
 * ============================================================
 */
public class Intergers {
    public static void main(String[] args) {

        // --------------------------------------------------------
        // EXERCISE 1: Integer types and ranges
        // --------------------------------------------------------
        byte b = 127;
        short s = 32_000;
        int i = 2_147_483_647;
        long l = 9_223_372_036_854_775_807L;
        System.out.println("byte max:  " + b);
        System.out.println("short:     " + s);
        System.out.println("int max:   " + i);
        System.out.println("long max:  " + l);

        // --------------------------------------------------------
        // EXERCISE 2: Integer constants
        // --------------------------------------------------------
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE); // 2147483647
        System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE); // -2147483648
        System.out.println("Integer.SIZE:      " + Integer.SIZE);      // 32
        System.out.println("Integer.BYTES:     " + Integer.BYTES);     // 4

        // --------------------------------------------------------
        // EXERCISE 3: Arithmetic operators
        // --------------------------------------------------------
        int a = 17, c = 5;
        System.out.println(a + c);  // 22
        System.out.println(a - c);  // 12
        System.out.println(a * c);  // 85
        System.out.println(a / c);  // 3  (integer division, truncates)
        System.out.println(a % c);  // 2  (remainder)

        // --------------------------------------------------------
        // EXERCISE 4: Integer division gotcha
        // Dividing two ints always gives an int — cast to get decimal.
        // --------------------------------------------------------
        int x = 7, y = 2;
        System.out.println(x / y);              // 3  (not 3.5!)
        System.out.println((double) x / y);     // 3.5

        // --------------------------------------------------------
        // EXERCISE 5: Overflow
        // Going beyond MAX_VALUE wraps around (no exception).
        // --------------------------------------------------------
        int max = Integer.MAX_VALUE;
        System.out.println(max);         //  2147483647
        System.out.println(max + 1);     // -2147483648 (overflow!)
        long safe = (long) max + 1;
        System.out.println(safe);        //  2147483648 (safe with long)

        // --------------------------------------------------------
        // EXERCISE 6: Increment and decrement
        // --------------------------------------------------------
        int n = 10;
        System.out.println(n++); // 10 (prints then increments)
        System.out.println(n);   // 11
        System.out.println(++n); // 12 (increments then prints)
        System.out.println(n--); // 12 (prints then decrements)
        System.out.println(n);   // 11

        // --------------------------------------------------------
        // EXERCISE 7: Different number literals
        // --------------------------------------------------------
        int decimal = 255;
        int hex     = 0xFF;
        int binary  = 0b11111111;
        int octal   = 0377;
        System.out.println(decimal); // 255
        System.out.println(hex);     // 255
        System.out.println(binary);  // 255
        System.out.println(octal);   // 255

        // --------------------------------------------------------
        // EXERCISE 8: parseInt() — String to int
        // --------------------------------------------------------
        int parsed = Integer.parseInt("42");
        int fromHex = Integer.parseInt("FF", 16);  // parse hex string
        int fromBin = Integer.parseInt("1010", 2); // parse binary string
        System.out.println(parsed);   // 42
        System.out.println(fromHex);  // 255
        System.out.println(fromBin);  // 10

        // --------------------------------------------------------
        // EXERCISE 9: Integer to String conversions
        // --------------------------------------------------------
        System.out.println(Integer.toString(255));        // "255"
        System.out.println(Integer.toBinaryString(255));  // "11111111"
        System.out.println(Integer.toHexString(255));     // "ff"
        System.out.println(Integer.toOctalString(255));   // "377"
        System.out.println(String.valueOf(255));           // "255"

        // --------------------------------------------------------
        // EXERCISE 10: Integer.max(), min(), sum(), compare()
        // --------------------------------------------------------
        System.out.println(Integer.max(10, 20));      // 20
        System.out.println(Integer.min(10, 20));      // 10
        System.out.println(Integer.sum(10, 20));      // 30
        System.out.println(Integer.compare(10, 20));  // -1
        System.out.println(Integer.compare(20, 20));  //  0
        System.out.println(Integer.compare(30, 20));  //  1

        // --------------------------------------------------------
        // EXERCISE 11: Math utility methods
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
        // EXERCISE 12: Random int in a range
        // Formula: (int)(Math.random() * (max - min + 1)) + min
        // --------------------------------------------------------
        int min = 1, max2 = 100;
        int random = (int) (Math.random() * (max2 - min + 1)) + min;
        System.out.println("Random (1-100): " + random);

        // --------------------------------------------------------
        // EXERCISE 13: Autoboxing and Unboxing
        // --------------------------------------------------------
        Integer boxed = 50;          // autoboxing: int → Integer
        int unboxed = boxed;         // unboxing: Integer → int
        System.out.println(boxed);   // 50
        System.out.println(unboxed); // 50

        // --------------------------------------------------------
        // EXERCISE 14: Integer cache gotcha (== vs equals)
        // --------------------------------------------------------
        Integer p = 127;
        Integer q = 127;
        Integer r = 128;
        Integer t = 128;
        System.out.println(p == q);       // true  (cached: -128 to 127)
        System.out.println(r == t);       // false (outside cache range)
        System.out.println(r.equals(t));  // true  (always use equals!)

        // --------------------------------------------------------
        // EXERCISE 15: Bitwise operators
        // --------------------------------------------------------
        int ba = 5;  // 0101
        int bc = 3;  // 0011
        System.out.println(ba & bc);  // 1  (0001) AND
        System.out.println(ba | bc);  // 7  (0111) OR
        System.out.println(ba ^ bc);  // 6  (0110) XOR
        System.out.println(~ba);      // -6       NOT
        System.out.println(1 << 3);   // 8  (left shift = multiply by 2^3)
        System.out.println(8 >> 1);   // 4  (right shift = divide by 2)

        // --------------------------------------------------------
        // EXERCISE 16: Integer.bitCount() — count 1-bits
        // --------------------------------------------------------
        System.out.println(Integer.bitCount(255));  // 8  (11111111)
        System.out.println(Integer.bitCount(10));   // 2  (1010)

        // --------------------------------------------------------
        // EXERCISE 17: Integer.signum()
        // Returns -1 for negative, 0 for zero, 1 for positive.
        // --------------------------------------------------------
        System.out.println(Integer.signum(-99)); // -1
        System.out.println(Integer.signum(0));   //  0
        System.out.println(Integer.signum(42));  //  1

        // --------------------------------------------------------
        // EXERCISE 18: Sum of 1 to N (Gauss formula)
        // --------------------------------------------------------
        int N = 100;
        int sum = N * (N + 1) / 2;
        System.out.println("Sum 1 to " + N + " = " + sum); // 5050

        // --------------------------------------------------------
        // EXERCISE 19: Check even/odd using modulo
        // --------------------------------------------------------
        for (int k = 1; k <= 6; k++) {
            System.out.println(k + " is " + (k % 2 == 0 ? "even" : "odd"));
        }

        // --------------------------------------------------------
        // EXERCISE 20: FizzBuzz (classic interview exercise)
        // --------------------------------------------------------
        for (int k = 1; k <= 20; k++) {
            if (k % 15 == 0)      System.out.print("FizzBuzz ");
            else if (k % 3 == 0)  System.out.print("Fizz ");
            else if (k % 5 == 0)  System.out.print("Buzz ");
            else                  System.out.print(k + " ");
        }
        System.out.println();

        // --------------------------------------------------------
        // EXERCISE 21: Factorial using long
        // --------------------------------------------------------
        long factorial = 1;
        for (int k = 1; k <= 20; k++) {
            factorial *= k;
        }
        System.out.println("20! = " + factorial); // 2432902008176640000

        // --------------------------------------------------------
        // EXERCISE 22: Power without Math.pow (bit shift trick)
        // 2^n = 1 << n (works for powers of 2)
        // --------------------------------------------------------
        for (int k = 0; k <= 10; k++) {
            System.out.println("2^" + k + " = " + (1 << k));
        }

        // --------------------------------------------------------
        // EXERCISE 23: Swap two integers without a temp variable
        // --------------------------------------------------------
        int u = 5, v = 9;
        System.out.println("Before: u=" + u + ", v=" + v);
        u = u ^ v;
        v = u ^ v;
        u = u ^ v;
        System.out.println("After:  u=" + u + ", v=" + v); // u=9, v=5

        // --------------------------------------------------------
        // EXERCISE 24: Find max digit in a number
        // --------------------------------------------------------
        int number = 938271;
        int maxDigit = 0;
        int temp = Math.abs(number);
        while (temp > 0) {
            int digit = temp % 10;
            if (digit > maxDigit) maxDigit = digit;
            temp /= 10;
        }
        System.out.println("Max digit in " + number + ": " + maxDigit); // 9

        // --------------------------------------------------------
        // EXERCISE 25: Check if a number is a power of 2
        // A power of 2 has exactly one 1-bit.
        // --------------------------------------------------------
        int[] nums = {1, 2, 3, 4, 16, 18, 32};
        for (int num : nums) {
            boolean isPow2 = num > 0 && (num & (num - 1)) == 0;
            System.out.println(num + " is power of 2: " + isPow2);
        }

        // --------------------------------------------------------
        // SUMMARY
        // --------------------------------------------------------
        System.out.println("\n=== Integer Quick Reference ===");
        int demo = -42;
        System.out.println("Value:      " + demo);
        System.out.println("Abs:        " + Math.abs(demo));
        System.out.println("Binary:     " + Integer.toBinaryString(Math.abs(demo)));
        System.out.println("Hex:        " + Integer.toHexString(Math.abs(demo)));
        System.out.println("Bit count:  " + Integer.bitCount(Math.abs(demo)));
        System.out.println("Signum:     " + Integer.signum(demo));
        System.out.println("Max w/ 100: " + Integer.max(demo, 100));
    }
}