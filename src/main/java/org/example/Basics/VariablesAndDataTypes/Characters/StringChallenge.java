package org.example.Basics.VariablesAndDataTypes.Characters;

import java.util.Arrays;

/**
 * ============================================================
 *              STRING CHALLENGES  — LeetCode Style
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
public class StringChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]
    // =========================================================
    // Reverse a String
    //
    // Given a string s, return it reversed.
    //
    // Example:
    //   Input:  "hello"
    //   Output: "olleh"
    //
    //   Input:  "Java"
    //   Output: "avaJ"
    // =========================================================
    static String reverseString(String s) {
        // TODO: write your solution here
        return "";
    }

    // =========================================================
    // CHALLENGE 2  [EASY]
    // =========================================================
    // Is Palindrome?
    //
    // Return true if the string reads the same forwards and backwards.
    // Ignore case.
    //
    // Example:
    //   Input:  "racecar"  → true
    //   Input:  "Madam"    → true
    //   Input:  "hello"    → false
    // =========================================================
    static boolean isPalindrome(String s) {
        // TODO: write your solution here
        return true;
    }

    // =========================================================
    // CHALLENGE 3  [EASY]
    // =========================================================
    // Count Vowels
    //
    // Return the number of vowels (a, e, i, o, u) in the string.
    // Case insensitive.
    //
    // Example:
    //   Input:  "Hello World"  → 3
    //   Input:  "Java"         → 2
    //   Input:  "rhythm"       → 0
    // =========================================================
    static int countVowels(String s) {
        // TODO: write your solution here
        return -1;
    }

    // =========================================================
    // CHALLENGE 4  [EASY]
    // =========================================================
    // First Non-Repeating Character
    //
    // Return the index of the first character that does not repeat.
    // Return -1 if all characters repeat.
    //
    // Example:
    //   Input:  "leetcode"   → 0  ('l')
    //   Input:  "loveleetcode" → 2  ('v')
    //   Input:  "aabb"       → -1
    // =========================================================
    static int firstUniqueChar(String s) {
        // TODO: write your solution here
        return -1;
    }

    // =========================================================
    // CHALLENGE 5  [EASY]
    // =========================================================
    // Count Words
    //
    // Return the number of words in the sentence.
    // Words are separated by one or more spaces.
    //
    // Example:
    //   Input:  "Hello World"       → 2
    //   Input:  "  Java  is  fun  " → 3
    //   Input:  ""                  → 0
    // =========================================================
    static int countWords(String s) {
        // TODO: write your solution here
        return 0;
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]
    // =========================================================
    // Anagram Check
    //
    // Return true if s1 and s2 are anagrams of each other.
    // An anagram uses the same characters the same number of times.
    // Ignore case.
    //
    // Example:
    //   Input:  "listen", "silent"  → true
    //   Input:  "hello",  "world"   → false
    //   Input:  "Astronomer", "Moon starer" (with spaces ignored) — optional bonus
    // =========================================================
    static boolean isAnagram(String s1, String s2) {
        // HINT: Two strings are anagrams if they contain the same characters
        //       the same number of times.
        //
        // APPROACH — Sort and compare:
        //   Step 1: lowercase both strings
        //   Step 2: convert each to a char[] with .toCharArray()
        //   Step 3: sort both arrays with Arrays.sort(charArray)
        //   Step 4: compare with Arrays.equals(arr1, arr2)
        //   → if lengths differ first, return false immediately.
        //
        // import java.util.Arrays;  ← add this at the top if needed.


        return true;



        // TODO: write your solution here



    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]
    // =========================================================
    // Longest Word
    //
    // Return the longest word in the sentence.
    // If there is a tie, return the first one.
    //
    // Example:
    //   Input:  "I love programming"   → "programming"
    //   Input:  "cat bat sat"          → "cat"
    //   Input:  "Java"                 → "Java"
    // =========================================================
    static String longestWord(String sentence) {
        // HINT: Split the sentence into words, then loop through them.
        //
        // APPROACH:
        //   Step 1: split by spaces → String[] words = sentence.split("\\s+")
        //           (\\s+ handles multiple spaces at once)
        //   Step 2: keep track of the longest word seen so far
        //   Step 3: loop — if current word is LONGER than the tracked one, update it
        //   Step 4: return the tracked word
        //
        // Key: use word.length() > longest.length() (strictly greater → keeps first on tie)

        // TODO: write your solution here

        return "";
    }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]
    // =========================================================
    // Compress String
    //
    // Run-length encode a string:
    // Replace consecutive repeated characters with char + count.
    // If the compressed string is not shorter, return the original.
    //
    // Example:
    //   Input:  "aabcccdddd"   → "a2bc3d4"
    //   Input:  "abc"          → "abc"  (no compression benefit)
    //   Input:  "aaaa"         → "a4"
    // =========================================================
    static String compressString(String s) {
        // TODO: write your solution here


        return "";
    }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]
    // =========================================================
    // Valid Parentheses
    //
    // Given a string containing only '(' and ')',
    // return true if the parentheses are balanced.
    //
    // Example:
    //   Input:  "(())"     → true
    //   Input:  "()()"     → true
    //   Input:  "(())("    → false
    //   Input:  ")("       → false
    // =========================================================
    static boolean isBalanced(String s) {
        // HINT: Use a counter — treat '(' as +1 and ')' as -1.
        //
        // APPROACH:
        //   Step 1: int count = 0
        //   Step 2: loop through each char:
        //           - if '(' → count++
        //           - if ')' → count--
        //           - if count goes NEGATIVE at any point → return false immediately
        //             (a ')' appeared before a matching '(')
        //   Step 3: after the loop → return count == 0
        //             (all opened ones were closed)
        //
        // Example trace ")(":
        //   ')' → count = -1 → return false immediately ✔

        // TODO: write your solution here

        return false;
    }

    // =========================================================
    // CHALLENGE 10  [HARD]
    // =========================================================
    // Longest Substring Without Repeating Characters
    //
    // Return the length of the longest substring
    // that contains no duplicate characters.
    //
    // Example:
    //   Input:  "abcabcbb"   → 3  ("abc")
    //   Input:  "bbbbb"      → 1  ("b")
    //   Input:  "pwwkew"     → 3  ("wke")
    //   Input:  "dvdf"       → 3  ("vdf")
    // =========================================================
    static int lengthOfLongestSubstring(String s) {
        // HINT: Use the "sliding window" technique with two pointers.
        //
        // APPROACH:
        //   - left pointer marks the start of the current window
        //   - right pointer expands the window one char at a time
        //   - a String (or Set) tracks what's currently in the window
        //
        //   Step 1: int left = 0, maxLen = 0
        //   Step 2: loop right from 0 to s.length()-1:
        //       a) get current char: char c = s.charAt(right)
        //       b) while the window already contains c:
        //             remove s.charAt(left) from window
        //             left++
        //       c) add c to the window
        //       d) maxLen = Math.max(maxLen, right - left + 1)
        //   Step 3: return maxLen
        //
        // Example trace "abcabcbb":
        //   right=0 'a' → window="a",   max=1
        //   right=1 'b' → window="ab",  max=2
        //   right=2 'c' → window="abc", max=3
        //   right=3 'a' → 'a' already in window → remove 'a', left=1
        //              → window="bca",  max=3
        //   ...
        //
        // Use a HashSet<Character> for O(1) contains/add/remove.
        // import java.util.HashSet;

        // TODO: write your solution here

        return 0;
    }


    // ============================================================
    //  TEST RUNNER — do not modify
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // Challenge 1
        pass += check("Challenge 1a", reverseString("hello"),     "olleh")   ? 1 : 0;
        fail += check("Challenge 1a", reverseString("hello"),     "olleh")   ? 0 : 1;
        pass += check("Challenge 1b", reverseString("Java"),      "avaJ")    ? 1 : 0;
        fail += check("Challenge 1b", reverseString("Java"),      "avaJ")    ? 0 : 1;

        // Challenge 2
        pass += check("Challenge 2a", isPalindrome("racecar"),    true)  ? 1 : 0;
        fail += check("Challenge 2a", isPalindrome("racecar"),    true)  ? 0 : 1;
        pass += check("Challenge 2b", isPalindrome("Madam"),      true)  ? 1 : 0;
        fail += check("Challenge 2b", isPalindrome("Madam"),      true)  ? 0 : 1;
        pass += check("Challenge 2c", isPalindrome("hello"),      false) ? 1 : 0;
        fail += check("Challenge 2c", isPalindrome("hello"),      false) ? 0 : 1;

        // Challenge 3
        pass += check("Challenge 3a", countVowels("Hello World"), 3) ? 1 : 0;
        fail += check("Challenge 3a", countVowels("Hello World"), 3) ? 0 : 1;
        pass += check("Challenge 3b", countVowels("rhythm"),      0) ? 1 : 0;
        fail += check("Challenge 3b", countVowels("rhythm"),      0) ? 0 : 1;

        // Challenge 4
        pass += check("Challenge 4a", firstUniqueChar("leetcode"),     0)  ? 1 : 0;
        fail += check("Challenge 4a", firstUniqueChar("leetcode"),     0)  ? 0 : 1;
        pass += check("Challenge 4b", firstUniqueChar("loveleetcode"), 2)  ? 1 : 0;
        fail += check("Challenge 4b", firstUniqueChar("loveleetcode"), 2)  ? 0 : 1;
        pass += check("Challenge 4c", firstUniqueChar("aabb"),        -1)  ? 1 : 0;
        fail += check("Challenge 4c", firstUniqueChar("aabb"),        -1)  ? 0 : 1;

        // Challenge 5
        pass += check("Challenge 5a", countWords("Hello World"),        2) ? 1 : 0;
        fail += check("Challenge 5a", countWords("Hello World"),        2) ? 0 : 1;
        pass += check("Challenge 5b", countWords("  Java  is  fun  "), 3) ? 1 : 0;
        fail += check("Challenge 5b", countWords("  Java  is  fun  "), 3) ? 0 : 1;
        pass += check("Challenge 5c", countWords(""),                   0) ? 1 : 0;
        fail += check("Challenge 5c", countWords(""),                   0) ? 0 : 1;

        // Challenge 6
        pass += check("Challenge 6a", isAnagram("listen", "silent"), true)  ? 1 : 0;
        fail += check("Challenge 6a", isAnagram("listen", "silent"), true)  ? 0 : 1;
        pass += check("Challenge 6b", isAnagram("hello",  "world"),  false) ? 1 : 0;
        fail += check("Challenge 6b", isAnagram("hello",  "world"),  false) ? 0 : 1;

        // Challenge 7
        pass += check("Challenge 7a", longestWord("I love programming"), "programming") ? 1 : 0;
        fail += check("Challenge 7a", longestWord("I love programming"), "programming") ? 0 : 1;
        pass += check("Challenge 7b", longestWord("cat bat sat"),        "cat")         ? 1 : 0;
        fail += check("Challenge 7b", longestWord("cat bat sat"),        "cat")         ? 0 : 1;

        // Challenge 8
        pass += check("Challenge 8a", compressString("aabcccdddd"), "a2bc3d4") ? 1 : 0;
        fail += check("Challenge 8a", compressString("aabcccdddd"), "a2bc3d4") ? 0 : 1;
        pass += check("Challenge 8b", compressString("abc"),        "abc")     ? 1 : 0;
        fail += check("Challenge 8b", compressString("abc"),        "abc")     ? 0 : 1;

        // Challenge 9
        pass += check("Challenge 9a", isBalanced("(())"),  true)  ? 1 : 0;
        fail += check("Challenge 9a", isBalanced("(())"),  true)  ? 0 : 1;
        pass += check("Challenge 9b", isBalanced("()()" ), true)  ? 1 : 0;
        fail += check("Challenge 9b", isBalanced("()()" ), true)  ? 0 : 1;
        pass += check("Challenge 9c", isBalanced("(())(" ), false) ? 1 : 0;
        fail += check("Challenge 9c", isBalanced("(())(" ), false) ? 0 : 1;
        pass += check("Challenge 9d", isBalanced(")(" ),   false) ? 1 : 0;
        fail += check("Challenge 9d", isBalanced(")(" ),   false) ? 0 : 1;

        // Challenge 10
        pass += check("Challenge 10a", lengthOfLongestSubstring("abcabcbb"), 3) ? 1 : 0;
        fail += check("Challenge 10a", lengthOfLongestSubstring("abcabcbb"), 3) ? 0 : 1;
        pass += check("Challenge 10b", lengthOfLongestSubstring("bbbbb"),    1) ? 1 : 0;
        fail += check("Challenge 10b", lengthOfLongestSubstring("bbbbb"),    1) ? 0 : 1;
        pass += check("Challenge 10c", lengthOfLongestSubstring("pwwkew"),   3) ? 1 : 0;
        fail += check("Challenge 10c", lengthOfLongestSubstring("pwwkew"),   3) ? 0 : 1;

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
