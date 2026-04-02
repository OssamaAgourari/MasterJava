package org.example.Basics.VariablesAndDataTypes.Characters;

/**
 * ============================================================
 *              CHAR CHALLENGES  — LeetCode Style
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
public class CharChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]
    // =========================================================
    // Is Vowel?
    //
    // Return true if the given character is a vowel (a,e,i,o,u).
    // Case insensitive.
    //
    // Example:
    //   Input: 'a'  → true
    //   Input: 'E'  → true
    //   Input: 'b'  → false
    //   Input: '5'  → false
    // =========================================================
    static boolean isVowel(char c) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 2  [EASY]
    // =========================================================
    // Toggle Case
    //
    // If the char is uppercase, return its lowercase version.
    // If the char is lowercase, return its uppercase version.
    // If it's neither, return it unchanged.
    //
    // Example:
    //   Input: 'A'  → 'a'
    //   Input: 'z'  → 'Z'
    //   Input: '5'  → '5'
    // =========================================================
    static char toggleCase(char c) {
        // TODO: write your solution here

        return c;
    }

    // =========================================================
    // CHALLENGE 3  [EASY]
    // =========================================================
    // Char to Digit
    //
    // Given a digit character ('0'–'9'), return its integer value.
    // Return -1 if the char is not a digit.
    //
    // Example:
    //   Input: '7'  → 7
    //   Input: '0'  → 0
    //   Input: 'a'  → -1
    // =========================================================
    static int charToDigit(char c) {
        // TODO: write your solution here

        return -2;
    }

    // =========================================================
    // CHALLENGE 4  [EASY]
    // =========================================================
    // Shift Letter by N
    //
    // Shift a letter forward by n positions in the alphabet (wrap around).
    // Only letters are shifted; other characters are returned unchanged.
    // Preserve the original case.
    //
    // Example:
    //   Input: 'a', 3  → 'd'
    //   Input: 'x', 5  → 'c'  (wraps around)
    //   Input: 'Z', 1  → 'A'  (wraps around uppercase)
    //   Input: '5', 3  → '5'  (non-letter unchanged)
    // =========================================================
    static char shiftLetter(char c, int n) {
        // TODO: write your solution here

        return c;
    }

    // =========================================================
    // CHALLENGE 5  [EASY]
    // =========================================================
    // Most Frequent Character
    //
    // Return the character that appears most often in the string.
    // If there is a tie, return the one that appears first.
    // Ignore spaces.
    //
    // Example:
    //   Input: "hello"          → 'l'
    //   Input: "banana"         → 'a'
    //   Input: "aabb"           → 'a'
    // =========================================================
    static char mostFrequentChar(String s) {
        // TODO: write your solution here

        return ' ';
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]
    // =========================================================
    // Remove Duplicate Characters
    //
    // Return the string with all duplicate characters removed,
    // keeping only the first occurrence of each.
    //
    // Example:
    //   Input: "programming"  → "progamin"
    //   Input: "aabbcc"       → "abc"
    //   Input: "abcd"         → "abcd"
    // =========================================================
    static String removeDuplicateChars(String s) {
        // TODO: write your solution here

        return "";
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]
    // =========================================================
    // Caesar Cipher Decode
    //
    // Decode a Caesar cipher by shifting each letter BACK by the given key.
    // Only letters are shifted. Preserve case. Non-letters unchanged.
    //
    // Example:
    //   Input: "MDYD", 3  → "JAVA"
    //   Input: "khoor", 3 → "hello"
    //   Input: "Hello!", 5 → "Czggj!"
    // =========================================================
    static String caesarDecode(String s, int key) {
        // TODO: write your solution here

        return "";
    }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]
    // =========================================================
    // Count Each Type
    //
    // Given a string, return an int[] of length 4:
    //   [0] = count of uppercase letters
    //   [1] = count of lowercase letters
    //   [2] = count of digits
    //   [3] = count of other characters (spaces, punctuation, etc.)
    //
    // Example:
    //   Input: "Hello World 123!"
    //   Output: [2, 8, 3, 3]
    //   (H,W uppercase | e,l,l,o,o,r,l,d lowercase | 1,2,3 digits | space,space,! other)
    // =========================================================
    static int[] countCharTypes(String s) {
        // TODO: write your solution here

        return new int[]{0, 0, 0, 0};
    }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]
    // =========================================================
    // Pangram Check
    //
    // A pangram is a sentence that contains every letter of the
    // alphabet at least once.
    // Return true if the string is a pangram. Case insensitive.
    //
    // Example:
    //   Input: "The quick brown fox jumps over the lazy dog" → true
    //   Input: "Hello World"                                 → false
    // =========================================================
    static boolean isPangram(String s) {
        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 10  [HARD]
    // =========================================================
    // Longest Palindromic Substring
    //
    // Return the longest substring of s that is a palindrome.
    // If there are ties, return the first one found.
    //
    // Example:
    //   Input: "babad"     → "bab"  (or "aba")
    //   Input: "cbbd"      → "bb"
    //   Input: "racecar"   → "racecar"
    //   Input: "a"         → "a"
    // =========================================================
    static String longestPalindrome(String s) {
        // TODO: write your solution here

        return "";
    }


    // ============================================================
    //  TEST RUNNER — do not modify
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // Challenge 1
        pass += check("Challenge 1a", isVowel('a'), true)  ? 1 : 0;
        fail += check("Challenge 1a", isVowel('a'), true)  ? 0 : 1;
        pass += check("Challenge 1b", isVowel('E'), true)  ? 1 : 0;
        fail += check("Challenge 1b", isVowel('E'), true)  ? 0 : 1;
        pass += check("Challenge 1c", isVowel('b'), false) ? 1 : 0;
        fail += check("Challenge 1c", isVowel('b'), false) ? 0 : 1;
        pass += check("Challenge 1d", isVowel('5'), false) ? 1 : 0;
        fail += check("Challenge 1d", isVowel('5'), false) ? 0 : 1;

        // Challenge 2
        pass += check("Challenge 2a", toggleCase('A'), 'a') ? 1 : 0;
        fail += check("Challenge 2a", toggleCase('A'), 'a') ? 0 : 1;
        pass += check("Challenge 2b", toggleCase('z'), 'Z') ? 1 : 0;
        fail += check("Challenge 2b", toggleCase('z'), 'Z') ? 0 : 1;
        pass += check("Challenge 2c", toggleCase('5'), '5') ? 1 : 0;
        fail += check("Challenge 2c", toggleCase('5'), '5') ? 0 : 1;

        // Challenge 3
        pass += check("Challenge 3a", charToDigit('7'),  7)  ? 1 : 0;
        fail += check("Challenge 3a", charToDigit('7'),  7)  ? 0 : 1;
        pass += check("Challenge 3b", charToDigit('0'),  0)  ? 1 : 0;
        fail += check("Challenge 3b", charToDigit('0'),  0)  ? 0 : 1;
        pass += check("Challenge 3c", charToDigit('a'), -1)  ? 1 : 0;
        fail += check("Challenge 3c", charToDigit('a'), -1)  ? 0 : 1;

        // Challenge 4
        pass += check("Challenge 4a", shiftLetter('a', 3), 'd') ? 1 : 0;
        fail += check("Challenge 4a", shiftLetter('a', 3), 'd') ? 0 : 1;
        pass += check("Challenge 4b", shiftLetter('x', 5), 'c') ? 1 : 0;
        fail += check("Challenge 4b", shiftLetter('x', 5), 'c') ? 0 : 1;
        pass += check("Challenge 4c", shiftLetter('Z', 1), 'A') ? 1 : 0;
        fail += check("Challenge 4c", shiftLetter('Z', 1), 'A') ? 0 : 1;
        pass += check("Challenge 4d", shiftLetter('5', 3), '5') ? 1 : 0;
        fail += check("Challenge 4d", shiftLetter('5', 3), '5') ? 0 : 1;

        // Challenge 5
        pass += check("Challenge 5a", mostFrequentChar("hello"),  'l') ? 1 : 0;
        fail += check("Challenge 5a", mostFrequentChar("hello"),  'l') ? 0 : 1;
        pass += check("Challenge 5b", mostFrequentChar("banana"), 'a') ? 1 : 0;
        fail += check("Challenge 5b", mostFrequentChar("banana"), 'a') ? 0 : 1;

        // Challenge 6
        pass += check("Challenge 6a", removeDuplicateChars("aabbcc"),       "abc")     ? 1 : 0;
        fail += check("Challenge 6a", removeDuplicateChars("aabbcc"),       "abc")     ? 0 : 1;
        pass += check("Challenge 6b", removeDuplicateChars("programming"),  "progamin") ? 1 : 0;
        fail += check("Challenge 6b", removeDuplicateChars("programming"),  "progamin") ? 0 : 1;

        // Challenge 7
        pass += check("Challenge 7a", caesarDecode("MDYD",  3), "JAVA")   ? 1 : 0;
        fail += check("Challenge 7a", caesarDecode("MDYD",  3), "JAVA")   ? 0 : 1;
        pass += check("Challenge 7b", caesarDecode("khoor", 3), "hello")  ? 1 : 0;
        fail += check("Challenge 7b", caesarDecode("khoor", 3), "hello")  ? 0 : 1;

        // Challenge 8
        int[] res = countCharTypes("Hello World 123!");
        pass += check("Challenge 8a", res[0], 2) ? 1 : 0;
        fail += check("Challenge 8a", res[0], 2) ? 0 : 1;
        pass += check("Challenge 8b", res[1], 8) ? 1 : 0;
        fail += check("Challenge 8b", res[1], 8) ? 0 : 1;
        pass += check("Challenge 8c", res[2], 3) ? 1 : 0;
        fail += check("Challenge 8c", res[2], 3) ? 0 : 1;
        pass += check("Challenge 8d", res[3], 3) ? 1 : 0;
        fail += check("Challenge 8d", res[3], 3) ? 0 : 1;

        // Challenge 9
        pass += check("Challenge 9a", isPangram("The quick brown fox jumps over the lazy dog"), true)  ? 1 : 0;
        fail += check("Challenge 9a", isPangram("The quick brown fox jumps over the lazy dog"), true)  ? 0 : 1;
        pass += check("Challenge 9b", isPangram("Hello World"), false) ? 1 : 0;
        fail += check("Challenge 9b", isPangram("Hello World"), false) ? 0 : 1;

        // Challenge 10
        pass += check("Challenge 10a", longestPalindrome("cbbd"),    "bb")      ? 1 : 0;
        fail += check("Challenge 10a", longestPalindrome("cbbd"),    "bb")      ? 0 : 1;
        pass += check("Challenge 10b", longestPalindrome("racecar"), "racecar") ? 1 : 0;
        fail += check("Challenge 10b", longestPalindrome("racecar"), "racecar") ? 0 : 1;
        pass += check("Challenge 10c", longestPalindrome("a"),       "a")       ? 1 : 0;
        fail += check("Challenge 10c", longestPalindrome("a"),       "a")       ? 0 : 1;

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
