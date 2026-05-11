package org.example.Basics.Strings;

import java.util.*;

/**
 * ============================================================
 *          JAVA STRINGS — COMPLETE GUIDE
 * ============================================================
 *
 * KEY FACT: Strings are IMMUTABLE in Java.
 * Every modification creates a NEW String object.
 *
 * STRING POOL: String literals share the same object.
 *   "hello" == "hello"    → true  (same pool object)
 *   new String("hello") == new String("hello") → false
 *   Always use .equals() for value comparison!
 *
 * COMPLEXITY:
 * -----------
 *   charAt(i)      : O(1)
 *   length()       : O(1)
 *   substring(i,j) : O(j-i) — creates new String
 *   indexOf        : O(n*m)
 *   equals         : O(n)
 *   +  concatenation: O(n) — creates new String each time
 *
 * IMPORTANT CLASSES:
 * ------------------
 *   String          — immutable, thread-safe
 *   StringBuilder   — mutable, NOT thread-safe, O(1) amortized append
 *   StringBuffer    — mutable, thread-safe (synchronized), slower
 *
 * USE StringBuilder for loops:
 *   String s = "";
 *   for (...) s += x;  ← O(n²) — BAD
 *   StringBuilder sb = new StringBuilder();
 *   for (...) sb.append(x);  ← O(n) — GOOD
 *
 * COMMON METHODS:
 * ---------------
 *   s.length()            → int
 *   s.charAt(i)           → char
 *   s.indexOf(c)          → int (-1 if not found)
 *   s.substring(start)    → String
 *   s.substring(s, e)     → String [start, end)
 *   s.contains(sub)       → boolean
 *   s.startsWith(prefix)  → boolean
 *   s.endsWith(suffix)    → boolean
 *   s.toLowerCase()       → String
 *   s.toUpperCase()       → String
 *   s.trim()              → remove leading/trailing whitespace
 *   s.strip()             → Unicode-aware trim (Java 11+)
 *   s.replace(old, new)   → String
 *   s.split(regex)        → String[]
 *   s.toCharArray()       → char[]
 *   String.valueOf(x)     → String from any type
 *   String.join(delim, …) → "a,b,c"
 *   s.formatted(args)     → Java 15+
 *
 * ============================================================
 */
public class Strings {

    // ── 1. String comparison ─────────────────────────────────
    static void comparisonDemo() {
        String a = "hello";
        String b = "hello";
        String c = new String("hello");

        System.out.println("a == b:         " + (a == b));           // true (pool)
        System.out.println("a == c:         " + (a == c));           // false (new obj)
        System.out.println("a.equals(c):    " + a.equals(c));        // true (value)
        System.out.println("equalsIgnoreCase: " + a.equalsIgnoreCase("HELLO")); // true
    }

    // ── 2. String methods cheat sheet ─────────────────────────
    static void methodsDemo() {
        String s = "  Hello, World!  ";
        System.out.println("length:     " + s.trim().length());   // 13
        System.out.println("upper:      " + s.trim().toUpperCase()); // HELLO, WORLD!
        System.out.println("contains:   " + s.contains("World")); // true
        System.out.println("indexOf:    " + s.indexOf('o'));       // first 'o'
        System.out.println("lastIndexOf:" + s.lastIndexOf('o'));   // last 'o'
        System.out.println("replace:    " + s.trim().replace("World", "Java"));
        System.out.println("split:      " + Arrays.toString(s.trim().split(", "))); // [Hello, World!]
        System.out.println("substring:  " + s.trim().substring(7));    // World!
        System.out.println("startsWith: " + s.trim().startsWith("Hello")); // true
    }

    // ── 3. String → char array manipulation ───────────────────
    static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int lo = 0, hi = chars.length - 1;
        while (lo < hi) {
            char t = chars[lo]; chars[lo] = chars[hi]; chars[hi] = t;
            lo++; hi--;
        }
        return new String(chars);
    }

    // ── 4. Palindrome check ───────────────────────────────────
    static boolean isPalindrome(String s) {
        // Only alphanumeric, case-insensitive
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            while (lo < hi && !Character.isLetterOrDigit(s.charAt(lo))) lo++;
            while (lo < hi && !Character.isLetterOrDigit(s.charAt(hi))) hi--;
            if (Character.toLowerCase(s.charAt(lo)) != Character.toLowerCase(s.charAt(hi)))
                return false;
            lo++; hi--;
        }
        return true;
    }

    // ── 5. Anagram check ─────────────────────────────────────
    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        for (char c : t.toCharArray()) count[c - 'a']--;
        for (int n : count) if (n != 0) return false;
        return true;
    }

    // ── 6. StringBuilder — efficient string building ──────────
    static String repeat(String s, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) sb.append(s);
        return sb.toString();
    }

    // ── 7. String formatting ──────────────────────────────────
    static void formattingDemo() {
        String name = "Alice";
        int age = 30;
        double score = 98.567;
        System.out.println(String.format("Name: %-10s Age: %3d Score: %.2f", name, age, score));
        // Name: Alice      Age:  30 Score: 98.57
    }

    // ── 8. Count character occurrences ───────────────────────
    static int countChar(String s, char target) {
        int count = 0;
        for (char c : s.toCharArray())
            if (c == target) count++;
        return count;
    }

    // ── 9. Check if string has all unique chars ───────────────
    static boolean allUnique(String s) {
        boolean[] seen = new boolean[128]; // ASCII
        for (char c : s.toCharArray()) {
            if (seen[c]) return false;
            seen[c] = true;
        }
        return true;
    }

    // ── 10. String.join and split ─────────────────────────────
    static void joinSplitDemo() {
        String[] words = {"Java", "is", "awesome"};
        String joined = String.join("-", words);
        System.out.println("Joined: " + joined); // Java-is-awesome

        String csv = "a,b,,c,d";
        String[] parts = csv.split(",", -1); // -1 keeps trailing empty strings
        System.out.println("Split: " + Arrays.toString(parts)); // [a, b, , c, d]
        System.out.println("Count: " + parts.length); // 5
    }

    // ── 11. Convert between String and numbers ────────────────
    static void conversionDemo() {
        // String to number
        int i = Integer.parseInt("42");
        double d = Double.parseDouble("3.14");
        // Number to String
        String si = String.valueOf(i);
        String sd = Integer.toString(42, 2); // binary: "101010"
        System.out.println("parseInt: " + i + ", parseDouble: " + d);
        System.out.println("valueOf: " + si + ", toBinary: " + sd);
    }

    // ── 12. Longest common prefix ─────────────────────────────
    static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix))
                prefix = prefix.substring(0, prefix.length() - 1);
        }
        return prefix;
    }

    public static void main(String[] args) {
        // 1. Comparison
        comparisonDemo();

        // 2. Methods
        methodsDemo();

        // 3. Reverse
        System.out.println("Reverse 'hello': " + reverseString("hello")); // olleh

        // 4. Palindrome
        System.out.println("'A man a plan a canal Panama': " +
            isPalindrome("A man, a plan, a canal: Panama")); // true

        // 5. Anagram
        System.out.println("anagram('anagram','nagaram'): " + isAnagram("anagram","nagaram")); // true
        System.out.println("anagram('rat','car'): " + isAnagram("rat","car")); // false

        // 6. Repeat
        System.out.println("Repeat 'ab' 3x: " + repeat("ab", 3)); // ababab

        // 7. Formatting
        formattingDemo();

        // 8. Count char
        System.out.println("Count 'l' in 'hello world': " + countChar("hello world", 'l')); // 3

        // 9. All unique
        System.out.println("'abcde' all unique: " + allUnique("abcde"));  // true
        System.out.println("'hello' all unique: " + allUnique("hello"));  // false

        // 10. Join/split
        joinSplitDemo();

        // 11. Conversion
        conversionDemo();

        // 12. Longest common prefix
        System.out.println("LCP: " + longestCommonPrefix(new String[]{"flower","flow","flight"})); // fl

        System.out.println("\n=== String Quick Reference ===");
        System.out.println("Immutable    → every change = new object");
        System.out.println("==         → reference equality (avoid)");
        System.out.println(".equals()  → value equality (use this)");
        System.out.println("StringBuilder → mutable, use in loops");
        System.out.println("charAt(i)  → O(1), substring(i,j) → O(n)");
    }
}
