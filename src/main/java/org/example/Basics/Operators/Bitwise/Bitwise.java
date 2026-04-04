package org.example.Basics.Operators.Bitwise;

/**
 * ============================================================
 *             JAVA BITWISE OPERATORS - COMPLETE GUIDE
 * ============================================================
 *
 * WHAT ARE BITWISE OPERATORS?
 * ----------------------------
 * Bitwise operators work directly on the binary (bit-level)
 * representation of integers. They are extremely fast and are
 * used in low-level programming, performance optimizations, and
 * algorithm problems.
 *
 * OPERATOR TABLE:
 * ---------------
 *   Operator | Name              | Example (5=0101, 3=0011)
 *   ---------|-------------------|-------------------------
 *   &        | AND               | 5 & 3  = 1  (0001)
 *   |        | OR                | 5 | 3  = 7  (0111)
 *   ^        | XOR               | 5 ^ 3  = 6  (0110)
 *   ~        | NOT (complement)  | ~5     = -6
 *   <<       | Left shift        | 1 << 3 = 8  (multiply by 2^3)
 *   >>       | Right shift       | 8 >> 1 = 4  (divide by 2)
 *   >>>      | Unsigned right shift | -1 >>> 28 = 15
 *
 * BITWISE TRUTH TABLE (per bit):
 * --------------------------------
 *   A | B | A & B | A | B | A ^ B | ~A
 *   --|---|-------|-------|-------|----
 *   0 | 0 |   0   |   0   |   0   |  1
 *   0 | 1 |   0   |   1   |   1   |  1
 *   1 | 0 |   0   |   1   |   1   |  0
 *   1 | 1 |   1   |   1   |   0   |  0
 *
 * UNDERSTANDING ~ (NOT / COMPLEMENT):
 * -------------------------------------
 * ~n = -(n + 1)   because Java uses two's complement.
 *   ~0  = -1
 *   ~5  = -6
 *   ~-1 =  0
 *
 * SHIFT OPERATORS:
 * ----------------
 * << (left shift):  n << k  =  n * 2^k   (fills with 0s from right)
 * >> (right shift): n >> k  =  n / 2^k   (fills with sign bit from left)
 * >>> (unsigned):   n >>> k fills with 0s from left regardless of sign
 *   1 << 4 = 16
 *   -1 >> 1 = -1  (sign bit preserved)
 *   -1 >>> 1 = 2147483647  (fills with 0, not sign bit)
 *
 * COMPOUND ASSIGNMENT:
 * ---------------------
 *   x &= mask   →  x = x & mask
 *   x |= flag   →  x = x | flag
 *   x ^= val    →  x = x ^ val
 *   x <<= n     →  x = x << n
 *   x >>= n     →  x = x >> n
 *
 * COMMON BIT TRICKS:
 * -------------------
 *   Check if even:       (n & 1) == 0
 *   Check if odd:        (n & 1) == 1
 *   Check bit k:         (n >> k) & 1
 *   Set bit k:           n | (1 << k)
 *   Clear bit k:         n & ~(1 << k)
 *   Toggle bit k:        n ^ (1 << k)
 *   Check power of 2:    n > 0 && (n & (n-1)) == 0
 *   Swap without temp:   a ^= b; b ^= a; a ^= b;
 *   Multiply by 2:       n << 1
 *   Divide by 2:         n >> 1
 *   Get lowest set bit:  n & (-n)
 *   Clear lowest bit:    n & (n - 1)
 *
 * ============================================================
 */
public class Bitwise {
    public static void main(String[] args) {

        // --------------------------------------------------------
        // EXERCISE 1: AND, OR, XOR, NOT
        // --------------------------------------------------------
        int a = 5;  // 0101
        int b = 3;  // 0011
        System.out.println("5 & 3  = " + (a & b));  // 1  (0001)
        System.out.println("5 | 3  = " + (a | b));  // 7  (0111)
        System.out.println("5 ^ 3  = " + (a ^ b));  // 6  (0110)
        System.out.println("~5     = " + (~a));      // -6

        // --------------------------------------------------------
        // EXERCISE 2: Visualize bits
        // --------------------------------------------------------
        System.out.println("5 in binary:  " + Integer.toBinaryString(5));  // 101
        System.out.println("3 in binary:  " + Integer.toBinaryString(3));  // 11
        System.out.println("5&3 in binary:" + Integer.toBinaryString(5 & 3)); // 1
        System.out.println("5|3 in binary:" + Integer.toBinaryString(5 | 3)); // 111
        System.out.println("5^3 in binary:" + Integer.toBinaryString(5 ^ 3)); // 110

        // --------------------------------------------------------
        // EXERCISE 3: Left shift << (multiply by 2^k)
        // --------------------------------------------------------
        System.out.println(1 << 0);   // 1    (2^0)
        System.out.println(1 << 1);   // 2    (2^1)
        System.out.println(1 << 3);   // 8    (2^3)
        System.out.println(1 << 10);  // 1024 (2^10)
        System.out.println(3 << 2);   // 12   (3 * 4)

        // --------------------------------------------------------
        // EXERCISE 4: Right shift >> (divide by 2^k)
        // --------------------------------------------------------
        System.out.println(8 >> 1);    // 4    (8 / 2)
        System.out.println(16 >> 2);   // 4    (16 / 4)
        System.out.println(-8 >> 1);   // -4   (sign preserved)
        System.out.println(-8 >>> 1);  // 2147483644 (unsigned, fills 0)

        // --------------------------------------------------------
        // EXERCISE 5: Check even or odd with &
        // --------------------------------------------------------
        for (int i = 0; i <= 6; i++) {
            String parity = (i & 1) == 0 ? "even" : "odd";
            System.out.println(i + " is " + parity);
        }

        // --------------------------------------------------------
        // EXERCISE 6: Check a specific bit (bit k of n)
        // getBit(n, k) = (n >> k) & 1
        // --------------------------------------------------------
        int n = 0b1011;  // binary: 1011 (decimal 11)
        System.out.println("n = " + n + " (binary: " + Integer.toBinaryString(n) + ")");
        for (int k = 0; k < 4; k++) {
            int bit = (n >> k) & 1;
            System.out.println("Bit " + k + ": " + bit);
        }
        // Bit 0: 1, Bit 1: 1, Bit 2: 0, Bit 3: 1

        // --------------------------------------------------------
        // EXERCISE 7: Set, clear, toggle a bit
        // --------------------------------------------------------
        int num = 0b1010;  // 10
        System.out.println("Original: " + Integer.toBinaryString(num));  // 1010

        int set = num | (1 << 0);      // set bit 0 → 1011
        System.out.println("Set   bit 0: " + Integer.toBinaryString(set));

        int clear = num & ~(1 << 1);   // clear bit 1 → 1000
        System.out.println("Clear bit 1: " + Integer.toBinaryString(clear));

        int toggle = num ^ (1 << 3);   // toggle bit 3 → 0010
        System.out.println("Toggle bit 3: " + Integer.toBinaryString(toggle));

        // --------------------------------------------------------
        // EXERCISE 8: Check if number is power of 2
        // n & (n-1) == 0 for powers of 2 (they have exactly one 1-bit)
        // --------------------------------------------------------
        int[] nums = {1, 2, 3, 4, 16, 18, 32, 64};
        for (int x : nums) {
            boolean isPow2 = x > 0 && (x & (x - 1)) == 0;
            System.out.println(x + " is power of 2: " + isPow2);
        }

        // --------------------------------------------------------
        // EXERCISE 9: Count set bits (Hamming weight)
        // --------------------------------------------------------
        int val = 0b10110110;  // 182
        int count = 0;
        int temp = val;
        while (temp != 0) {
            count += temp & 1;
            temp >>= 1;
        }
        System.out.println("Bit count of " + val + ": " + count);  // 5
        System.out.println("Using Integer.bitCount: " + Integer.bitCount(val)); // 5

        // --------------------------------------------------------
        // EXERCISE 10: Swap without a temp variable (XOR swap)
        // --------------------------------------------------------
        int x = 5, y = 9;
        System.out.println("Before: x=" + x + ", y=" + y);
        x ^= y;
        y ^= x;
        x ^= y;
        System.out.println("After:  x=" + x + ", y=" + y); // x=9, y=5

        // --------------------------------------------------------
        // EXERCISE 11: Find unique number (XOR of all — pairs cancel)
        // --------------------------------------------------------
        int[] arr = {4, 1, 2, 1, 2};
        int unique = 0;
        for (int v : arr) unique ^= v;
        System.out.println("Unique: " + unique); // 4

        // --------------------------------------------------------
        // EXERCISE 12: Get the lowest set bit
        // n & (-n) isolates the rightmost 1-bit
        // --------------------------------------------------------
        int m = 0b1100;  // 12
        System.out.println("Lowest set bit of " + m + ": " + (m & (-m))); // 4 (0100)

        // --------------------------------------------------------
        // EXERCISE 13: Clear the lowest set bit
        // n & (n-1) removes the rightmost 1-bit
        // --------------------------------------------------------
        int z = 12;  // 1100
        System.out.println("Before clear lowest bit: " + Integer.toBinaryString(z));  // 1100
        z = z & (z - 1);
        System.out.println("After  clear lowest bit: " + Integer.toBinaryString(z));  // 1000

        // --------------------------------------------------------
        // EXERCISE 14: Bitmask — represent a set of flags
        // --------------------------------------------------------
        final int READ    = 1 << 0;  // 001
        final int WRITE   = 1 << 1;  // 010
        final int EXECUTE = 1 << 2;  // 100

        int permissions = READ | WRITE;  // 011

        System.out.println("Has READ:    " + ((permissions & READ)    != 0)); // true
        System.out.println("Has WRITE:   " + ((permissions & WRITE)   != 0)); // true
        System.out.println("Has EXECUTE: " + ((permissions & EXECUTE) != 0)); // false

        permissions |= EXECUTE;  // grant EXECUTE
        System.out.println("After grant EXECUTE: " + Integer.toBinaryString(permissions)); // 111

        permissions &= ~WRITE;   // revoke WRITE
        System.out.println("After revoke WRITE:  " + Integer.toBinaryString(permissions)); // 101

        // --------------------------------------------------------
        // EXERCISE 15: Integer.bitCount() and Integer.reverse()
        // --------------------------------------------------------
        System.out.println(Integer.bitCount(255));   // 8  (11111111)
        System.out.println(Integer.bitCount(10));    // 2  (1010)
        System.out.println(Integer.highestOneBit(100)); // 64 (highest power of 2 ≤ 100)
        System.out.println(Integer.numberOfLeadingZeros(1));  // 31
        System.out.println(Integer.numberOfTrailingZeros(8)); // 3  (8 = 1000)

        // --------------------------------------------------------
        // SUMMARY
        // --------------------------------------------------------
        System.out.println("\n=== Bitwise Quick Reference ===");
        System.out.println("5 & 3  = " + (5 & 3)  + "  AND");
        System.out.println("5 | 3  = " + (5 | 3)  + "  OR");
        System.out.println("5 ^ 3  = " + (5 ^ 3)  + "  XOR");
        System.out.println("~5     = " + (~5)      + " NOT");
        System.out.println("1 << 3 = " + (1 << 3) + "  LEFT SHIFT");
        System.out.println("8 >> 1 = " + (8 >> 1) + "  RIGHT SHIFT");
    }
}
