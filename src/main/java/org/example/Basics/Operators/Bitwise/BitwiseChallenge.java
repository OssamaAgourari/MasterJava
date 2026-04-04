package org.example.Basics.Operators.Bitwise;

/**
 * ============================================================
 *            BITWISE OPERATORS CHALLENGES — LeetCode Style
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
 * ============================================================
 */
public class BitwiseChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]
    // =========================================================
    // Is Even
    //
    // Return true if n is even using bitwise AND (not modulo).
    //
    // Example:
    //   Input: 4   → true
    //   Input: 7   → false
    //   Input: 0   → true
    //   Input: -2  → true
    // =========================================================
    static boolean isEven(int n) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 2  [EASY]
    // =========================================================
    // Get Bit
    //
    // Return the value (0 or 1) of bit k in n.
    // k is 0-indexed from the right (least significant bit).
    //
    // Example:
    //   Input: n=5 (0101), k=0  → 1
    //   Input: n=5 (0101), k=1  → 0
    //   Input: n=5 (0101), k=2  → 1
    // =========================================================
    static int getBit(int n, int k) {
        // TODO: write your solution here

        return -1;
    }

    // =========================================================
    // CHALLENGE 3  [EASY]
    // =========================================================
    // Is Power of Two
    //
    // Return true if n is a power of 2.
    // Use the n & (n-1) trick. Do NOT use Math or loops.
    //
    // Example:
    //   Input: 1   → true
    //   Input: 16  → true
    //   Input: 18  → false
    //   Input: 0   → false
    //   Input: -4  → false
    // =========================================================
    static boolean isPowerOfTwo(int n) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 4  [EASY]
    // =========================================================
    // Count Set Bits (Hamming Weight)
    //
    // Return the number of 1-bits in the binary representation of n.
    // Do NOT use Integer.bitCount().
    //
    // Example:
    //   Input: 11  → 3  (binary: 1011)
    //   Input: 128 → 1  (binary: 10000000)
    //   Input: 255 → 8  (binary: 11111111)
    // =========================================================
    static int countSetBits(int n) {
        // TODO: write your solution here

        return -1;
    }

    // =========================================================
    // CHALLENGE 5  [EASY]
    // =========================================================
    // Single Number
    //
    // Every element in the array appears exactly twice EXCEPT
    // one. Find and return that single element.
    // Use XOR — pairs cancel out (x ^ x = 0).
    //
    // Example:
    //   Input: [4, 1, 2, 1, 2]  → 4
    //   Input: [2, 2, 1]        → 1
    //   Input: [1]              → 1
    // =========================================================
    static int singleNumber(int[] nums) {
        // TODO: write your solution here

        return -1;
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]
    // =========================================================
    // Set Bit
    //
    // Return n with bit k set to 1.
    //
    // Example:
    //   Input: n=5 (0101), k=1  → 7  (0111)
    //   Input: n=8 (1000), k=0  → 9  (1001)
    // =========================================================
    static int setBit(int n, int k) {
        // TODO: write your solution here

        return -1;
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]
    // =========================================================
    // Clear Bit
    //
    // Return n with bit k set to 0.
    //
    // Example:
    //   Input: n=7 (0111), k=1  → 5  (0101)
    //   Input: n=9 (1001), k=0  → 8  (1000)
    // =========================================================
    static int clearBit(int n, int k) {
        // TODO: write your solution here

        return -1;
    }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]
    // =========================================================
    // Toggle Bit
    //
    // Return n with bit k flipped (0 → 1, 1 → 0).
    //
    // Example:
    //   Input: n=5 (0101), k=1  → 7  (0111)
    //   Input: n=7 (0111), k=1  → 5  (0101)
    // =========================================================
    static int toggleBit(int n, int k) {
        // TODO: write your solution here

        return -1;
    }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]
    // =========================================================
    // Multiply by Power of 2
    //
    // Return n * 2^k using left shift. Do NOT use Math.pow or *.
    //
    // Example:
    //   Input: 3, 2  → 12   (3 * 4)
    //   Input: 1, 4  → 16   (1 * 16)
    //   Input: 5, 0  → 5    (5 * 1)
    // =========================================================
    static int multiplyByPow2(int n, int k) {
        // TODO: write your solution here

        return -1;
    }

    // =========================================================
    // CHALLENGE 10  [HARD]
    // =========================================================
    // Reverse Bits
    //
    // Reverse ALL 32 bits of a 32-bit integer.
    //
    // Example:
    //   Input:  43261596  (binary: 00000010100101000001111010011100)
    //   Output: 964176192 (binary: 00111001011110000010100101000000)
    //
    //   Input:  0  → 0
    //   Input: -1  → -1  (all 1s reversed is still all 1s)
    // =========================================================
    static int reverseBits(int n) {
        // TODO: write your solution here

        return 0;
    }


    // ============================================================
    //  TEST RUNNER — do not modify
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // Challenge 1
        pass += check("Challenge 1a", isEven(4),   true)  ? 1 : 0;
        fail += check("Challenge 1a", isEven(4),   true)  ? 0 : 1;
        pass += check("Challenge 1b", isEven(7),   false) ? 1 : 0;
        fail += check("Challenge 1b", isEven(7),   false) ? 0 : 1;
        pass += check("Challenge 1c", isEven(0),   true)  ? 1 : 0;
        fail += check("Challenge 1c", isEven(0),   true)  ? 0 : 1;
        pass += check("Challenge 1d", isEven(-2),  true)  ? 1 : 0;
        fail += check("Challenge 1d", isEven(-2),  true)  ? 0 : 1;

        // Challenge 2
        pass += check("Challenge 2a", getBit(5, 0), 1) ? 1 : 0;
        fail += check("Challenge 2a", getBit(5, 0), 1) ? 0 : 1;
        pass += check("Challenge 2b", getBit(5, 1), 0) ? 1 : 0;
        fail += check("Challenge 2b", getBit(5, 1), 0) ? 0 : 1;
        pass += check("Challenge 2c", getBit(5, 2), 1) ? 1 : 0;
        fail += check("Challenge 2c", getBit(5, 2), 1) ? 0 : 1;

        // Challenge 3
        pass += check("Challenge 3a", isPowerOfTwo(1),  true)  ? 1 : 0;
        fail += check("Challenge 3a", isPowerOfTwo(1),  true)  ? 0 : 1;
        pass += check("Challenge 3b", isPowerOfTwo(16), true)  ? 1 : 0;
        fail += check("Challenge 3b", isPowerOfTwo(16), true)  ? 0 : 1;
        pass += check("Challenge 3c", isPowerOfTwo(18), false) ? 1 : 0;
        fail += check("Challenge 3c", isPowerOfTwo(18), false) ? 0 : 1;
        pass += check("Challenge 3d", isPowerOfTwo(0),  false) ? 1 : 0;
        fail += check("Challenge 3d", isPowerOfTwo(0),  false) ? 0 : 1;

        // Challenge 4
        pass += check("Challenge 4a", countSetBits(11),  3) ? 1 : 0;
        fail += check("Challenge 4a", countSetBits(11),  3) ? 0 : 1;
        pass += check("Challenge 4b", countSetBits(128), 1) ? 1 : 0;
        fail += check("Challenge 4b", countSetBits(128), 1) ? 0 : 1;
        pass += check("Challenge 4c", countSetBits(255), 8) ? 1 : 0;
        fail += check("Challenge 4c", countSetBits(255), 8) ? 0 : 1;

        // Challenge 5
        pass += check("Challenge 5a", singleNumber(new int[]{4,1,2,1,2}), 4) ? 1 : 0;
        fail += check("Challenge 5a", singleNumber(new int[]{4,1,2,1,2}), 4) ? 0 : 1;
        pass += check("Challenge 5b", singleNumber(new int[]{2,2,1}),     1) ? 1 : 0;
        fail += check("Challenge 5b", singleNumber(new int[]{2,2,1}),     1) ? 0 : 1;
        pass += check("Challenge 5c", singleNumber(new int[]{1}),         1) ? 1 : 0;
        fail += check("Challenge 5c", singleNumber(new int[]{1}),         1) ? 0 : 1;

        // Challenge 6
        pass += check("Challenge 6a", setBit(5, 1), 7) ? 1 : 0;
        fail += check("Challenge 6a", setBit(5, 1), 7) ? 0 : 1;
        pass += check("Challenge 6b", setBit(8, 0), 9) ? 1 : 0;
        fail += check("Challenge 6b", setBit(8, 0), 9) ? 0 : 1;

        // Challenge 7
        pass += check("Challenge 7a", clearBit(7, 1), 5) ? 1 : 0;
        fail += check("Challenge 7a", clearBit(7, 1), 5) ? 0 : 1;
        pass += check("Challenge 7b", clearBit(9, 0), 8) ? 1 : 0;
        fail += check("Challenge 7b", clearBit(9, 0), 8) ? 0 : 1;

        // Challenge 8
        pass += check("Challenge 8a", toggleBit(5, 1), 7) ? 1 : 0;
        fail += check("Challenge 8a", toggleBit(5, 1), 7) ? 0 : 1;
        pass += check("Challenge 8b", toggleBit(7, 1), 5) ? 1 : 0;
        fail += check("Challenge 8b", toggleBit(7, 1), 5) ? 0 : 1;

        // Challenge 9
        pass += check("Challenge 9a", multiplyByPow2(3, 2), 12) ? 1 : 0;
        fail += check("Challenge 9a", multiplyByPow2(3, 2), 12) ? 0 : 1;
        pass += check("Challenge 9b", multiplyByPow2(1, 4), 16) ? 1 : 0;
        fail += check("Challenge 9b", multiplyByPow2(1, 4), 16) ? 0 : 1;
        pass += check("Challenge 9c", multiplyByPow2(5, 0), 5)  ? 1 : 0;
        fail += check("Challenge 9c", multiplyByPow2(5, 0), 5)  ? 0 : 1;

        // Challenge 10
        pass += check("Challenge 10a", reverseBits(43261596),  964176192) ? 1 : 0;
        fail += check("Challenge 10a", reverseBits(43261596),  964176192) ? 0 : 1;
        pass += check("Challenge 10b", reverseBits(0),         0)         ? 1 : 0;
        fail += check("Challenge 10b", reverseBits(0),         0)         ? 0 : 1;
        pass += check("Challenge 10c", reverseBits(-1),        -1)        ? 1 : 0;
        fail += check("Challenge 10c", reverseBits(-1),        -1)        ? 0 : 1;

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
}
