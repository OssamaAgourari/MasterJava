package org.example.Basics.VariablesAndDataTypes.Characters;

/**
 * ============================================================
 *               JAVA char TYPE - COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS A char?
 * ---------------
 * - char is a PRIMITIVE type that stores a single character.
 * - Size: 16-bit unsigned integer (0 to 65,535).
 * - Internally stores the Unicode code point of the character.
 * - Defined by single quotes: 'A', '5', '@', '\n'
 * - The wrapper class is Character (java.lang.Character).
 *
 * DECLARATION:
 * ------------
 *   char c1 = 'A';           // character literal
 *   char c2 = 65;            // numeric value (also 'A' — Unicode 65)
 *   char c3 = '\u0041';      // Unicode escape (also 'A')
 *   char c4 = '\n';          // escape sequence (newline)
 *   Character obj = 'A';     // autoboxing: char → Character
 *
 * CHAR IS A NUMBER:
 * -----------------
 * - char can be used in arithmetic — it behaves like an int.
 *   'A' + 1 = 66 → which is 'B'
 *   'a' - 'A' = 32 (difference between lowercase and uppercase)
 *   (char)('a' + 3) = 'd'
 * - You must cast back to char after arithmetic: (char)('A' + 1)
 *
 * ESCAPE SEQUENCES:
 * -----------------
 *   '\n'   → newline
 *   '\t'   → tab
 *   '\r'   → carriage return
 *   '\\'   → backslash
 *   '\''   → single quote
 *   '\"'   → double quote
 *   '\0'   → null character
 *   'uXXXX' → Unicode character (4 hex digits)
 *
 * UNICODE RANGES:
 * ---------------
 *   'A' - 'Z'  → 65  - 90
 *   'a' - 'z'  → 97  - 122
 *   '0' - '9'  → 48  - 57
 *
 * ============================================================
 *           Character WRAPPER CLASS METHODS
 * ============================================================
 *
 * CHECKING TYPE:
 *   Character.isLetter(c)        → true if letter (a-z, A-Z)
 *   Character.isDigit(c)         → true if digit (0-9)
 *   Character.isLetterOrDigit(c) → true if letter or digit
 *   Character.isWhitespace(c)    → true if space, tab, newline
 *   Character.isUpperCase(c)     → true if uppercase letter
 *   Character.isLowerCase(c)     → true if lowercase letter
 *   Character.isAlphabetic(c)    → true if alphabetic (broader than isLetter)
 *
 * CONVERSION:
 *   Character.toUpperCase(c)     → convert to uppercase
 *   Character.toLowerCase(c)     → convert to lowercase
 *   Character.getNumericValue(c) → digit character to int ('9' → 9)
 *   Character.toString(c)        → char to String
 *   (int) c                      → char to its Unicode code point
 *   (char) n                     → int to char
 *
 * OTHER:
 *   Character.compare(c1, c2)    → compares two chars
 *   Character.MAX_VALUE          → '\uFFFF' (65535)
 *   Character.MIN_VALUE          → '\u0000' (0)
 *
 * ============================================================
 *               char vs String
 * ============================================================
 *
 *  Feature      | char          | String
 *  -------------|---------------|-----------------------------
 *  Quote style  | Single: 'A'   | Double: "Hello"
 *  Length       | Always 1      | 0 or more characters
 *  Type         | Primitive     | Object
 *  Mutable      | N/A           | No (immutable)
 *  Empty value  | '\0'          | "" or null
 *
 * ============================================================
 */
public class Chars {
    public static void main(String[] args) {

        // --------------------------------------------------------
        // EXERCISE 1: Basic char declaration
        // --------------------------------------------------------
        char c1 = 'A';
        char c2 = 65;           // same as 'A' (Unicode value)
        char c3 = '\u0041';     // same as 'A' (Unicode escape)
        System.out.println(c1); // A
        System.out.println(c2); // A
        System.out.println(c3); // A

        // --------------------------------------------------------
        // EXERCISE 2: char is a numeric type
        // --------------------------------------------------------
        char letter = 'A';
        int code = letter;                    // char → int (widening, automatic)
        char next = (char)(letter + 1);       // must cast back to char
        System.out.println("Code of 'A': " + code);   // 65
        System.out.println("Next letter: " + next);   // B

        // --------------------------------------------------------
        // EXERCISE 3: Char arithmetic — print the alphabet
        // --------------------------------------------------------
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(c);
        }
        System.out.println(); // abcdefghijklmnopqrstuvwxyz

        // --------------------------------------------------------
        // EXERCISE 4: Difference between uppercase and lowercase
        // --------------------------------------------------------
        System.out.println((int)'a' - (int)'A');  // 32 (constant difference)
        char upper = 'G';
        char lower = (char)(upper + 32);          // manual lowercase
        System.out.println(lower);                // g

        // --------------------------------------------------------
        // EXERCISE 5: Escape sequences
        // --------------------------------------------------------
        System.out.println("Tab:\tEnd");
        System.out.println("Newline:\nEnd");
        System.out.println("Quote: \'single\' and \"double\"");
        System.out.println("Backslash: \\");

        // --------------------------------------------------------
        // EXERCISE 6: Character.isLetter(), isDigit(), isWhitespace()
        // --------------------------------------------------------
        char[] samples = {'A', '5', ' ', '!', 'z', '\t'};
        for (char ch : samples) {
            System.out.printf("'%s' → letter:%b  digit:%b  whitespace:%b%n",
                ch == '\t' ? "\\t" : String.valueOf(ch),
                Character.isLetter(ch),
                Character.isDigit(ch),
                Character.isWhitespace(ch));
        }

        // --------------------------------------------------------
        // EXERCISE 7: Character.isUpperCase() and isLowerCase()
        // --------------------------------------------------------
        System.out.println(Character.isUpperCase('A')); // true
        System.out.println(Character.isLowerCase('a')); // true
        System.out.println(Character.isUpperCase('5')); // false

        // --------------------------------------------------------
        // EXERCISE 8: toUpperCase() and toLowerCase()
        // --------------------------------------------------------
        System.out.println(Character.toUpperCase('b')); // B
        System.out.println(Character.toLowerCase('Z')); // z
        System.out.println(Character.toUpperCase('5')); // 5 (unchanged)

        // --------------------------------------------------------
        // EXERCISE 9: getNumericValue() — char digit to int
        // --------------------------------------------------------
        char digit = '7';
        int value = Character.getNumericValue(digit);
        System.out.println(value);           // 7
        System.out.println((int)'7' - '0');  // 7 (alternative approach)

        // --------------------------------------------------------
        // EXERCISE 10: char to String and back
        // --------------------------------------------------------
        char ch = 'J';
        String str = Character.toString(ch);  // "J"
        String str2 = String.valueOf(ch);     // "J"
        char back = str.charAt(0);            // back to char
        System.out.println(str);   // J
        System.out.println(back);  // J

        // --------------------------------------------------------
        // EXERCISE 11: Unicode characters
        // --------------------------------------------------------
        char heart   = '\u2764'; // ❤
        char star    = '\u2605'; // ★
        char smiley  = '\u263A'; // ☺
        System.out.println(heart + " " + star + " " + smiley);

        // --------------------------------------------------------
        // EXERCISE 12: Count specific chars in a String
        // --------------------------------------------------------
        String sentence = "Hello, how are you doing?";
        int vowels = 0;
        for (char c : sentence.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) vowels++;
        }
        System.out.println("Vowels in sentence: " + vowels); // 9

        // --------------------------------------------------------
        // EXERCISE 13: Check if char is a vowel
        // --------------------------------------------------------
        char test = 'E';
        boolean isVowel = "aeiouAEIOU".indexOf(test) != -1;
        System.out.println(test + " is vowel: " + isVowel); // true

        // --------------------------------------------------------
        // EXERCISE 14: ROT13 cipher (shift each letter by 13)
        // --------------------------------------------------------
        String input = "Hello World";
        StringBuilder rot13 = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base + 13) % 26 + base);
            }
            rot13.append(c);
        }
        System.out.println("ROT13: " + rot13); // Uryyb Jbeyq

        // --------------------------------------------------------
        // EXERCISE 15: Caesar cipher (shift by N)
        // --------------------------------------------------------
        String plain = "JAVA";
        int shift = 3;
        StringBuilder cipher = new StringBuilder();
        for (char c : plain.toCharArray()) {
            char shifted = (char)(((c - 'A' + shift) % 26) + 'A');
            cipher.append(shifted);
        }
        System.out.println("Caesar +3: " + cipher); // MDYD

        // --------------------------------------------------------
        // EXERCISE 16: Count uppercase, lowercase, digits, others
        // --------------------------------------------------------
        String mixed = "Hello World 123!";
        int upper2 = 0, lower2 = 0, digits = 0, others = 0;
        for (char c : mixed.toCharArray()) {
            if      (Character.isUpperCase(c)) upper2++;
            else if (Character.isLowerCase(c)) lower2++;
            else if (Character.isDigit(c))     digits++;
            else                               others++;
        }
        System.out.println("Upper: " + upper2 + " Lower: " + lower2 +
                           " Digits: " + digits + " Others: " + others);

        // --------------------------------------------------------
        // EXERCISE 17: Character.MIN_VALUE and MAX_VALUE
        // --------------------------------------------------------
        System.out.println("MIN_VALUE: " + (int) Character.MIN_VALUE); // 0
        System.out.println("MAX_VALUE: " + (int) Character.MAX_VALUE); // 65535

        // --------------------------------------------------------
        // SUMMARY
        // --------------------------------------------------------
        System.out.println("\n=== Char Quick Reference ===");
        char demo = 'm';
        System.out.println("Value:      " + demo);
        System.out.println("As int:     " + (int) demo);
        System.out.println("Upper:      " + Character.toUpperCase(demo));
        System.out.println("isLetter:   " + Character.isLetter(demo));
        System.out.println("isDigit:    " + Character.isDigit(demo));
        System.out.println("isLower:    " + Character.isLowerCase(demo));
    }
}
