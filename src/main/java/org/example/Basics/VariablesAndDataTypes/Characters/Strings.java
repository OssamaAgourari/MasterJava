package org.example.Basics.VariablesAndDataTypes.Characters;

/**
 * ============================================================
 *                    JAVA STRINGS - COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS A STRING?
 * -----------------
 * - A String is a sequence of characters.
 * - In Java, String is an OBJECT (not a primitive type), defined in java.lang.String.
 * - Strings are IMMUTABLE: once created, their value cannot be changed.
 *   Any modification creates a NEW String object.
 *
 *            String s = "hello";
 *            s = s + " world"; // creates a NEW object, doesn't modify "hello"
 *
 * - String literals are stored in the "String Pool" (heap memory optimization).
 *
 *      String a = "hello";
 *      Java checks:
 *              ➡️ “Do I already have "hello" in the pool?”
 *          ✅ If YES → reuse it
 *          ❌ If NO → create it and store it
 *
 * DECLARATION WAYS:
 * -----------------
 *   String s1 = "Hello";               // String literal (uses String Pool)
 *   String s2 = new String("Hello");   // New object (bypasses pool - avoid this)
 *   char[] ch = {'H','i'};
 *   String s3 = new String(ch);        // From char array
 *
 * STRING POOL:
 * ------------
 * - Java maintains a pool of String literals to save memory.
 * - "Hello" == "Hello" → true  (same reference in pool)
 * - new String("Hello") == new String("Hello") → false (different objects)
 * - Always use .equals() to compare String content, never ==.
 *
 * IMMUTABILITY:
 * -------------
 * - String objects cannot be changed after creation.
 * - s = s + " World" does NOT change s — it creates a NEW String and reassigns s.
 * - For frequent modifications, use StringBuilder (mutable, not thread-safe)
 *   or StringBuffer (mutable, thread-safe).
 *
 * ============================================================
 *                  STRING METHODS REFERENCE
 * ============================================================
 *
 * LENGTH & EMPTINESS:
 *   .length()           → number of characters
 *   .isEmpty()          → true if length == 0
 *   .isBlank()          → true if empty or only whitespace (Java 11+)
 *
 * CHARACTER ACCESS:
 *   .charAt(i)          → char at index i
 *   .codePointAt(i)     → Unicode code point at index i
 *   .toCharArray()      → converts to char[]
 *
 * SEARCHING:
 *   .indexOf(str)       → first index of str, or -1
 *   .indexOf(str, from) → first index starting from 'from'
 *   .lastIndexOf(str)   → last index of str
 *   .contains(seq)      → true if contains the sequence
 *   .startsWith(prefix) → true if starts with prefix
 *   .endsWith(suffix)   → true if ends with suffix
 *   .matches(regex)     → true if matches the regex
 *
 * COMPARISON:
 *   .equals(other)           → content equality (case-sensitive)
 *   .equalsIgnoreCase(other) → content equality (case-insensitive)
 *   .compareTo(other)        → lexicographic comparison (returns int)
 *   .compareToIgnoreCase(other)
 *
 * EXTRACTION / SLICING:
 *   .substring(start)        → from start to end
 *   .substring(start, end)   → from start (inclusive) to end (exclusive)
 *
 * TRANSFORMATION:
 *   .toLowerCase()           → all lowercase
 *   .toUpperCase()           → all uppercase
 *   .trim()                  → removes leading/trailing whitespace (ASCII)
 *   .strip()                 → removes leading/trailing whitespace (Unicode, Java 11+)
 *   .stripLeading()          → removes leading whitespace (Java 11+)
 *   .stripTrailing()         → removes trailing whitespace (Java 11+)
 *   .replace(old, new)       → replaces all occurrences of char/sequence
 *   .replaceAll(regex, rep)  → replaces using regex
 *   .replaceFirst(regex, rep)→ replaces first match of regex
 *   .concat(str)             → appends str (same as +)
 *   .intern()                → returns the pooled version of the String
 *   .repeat(n)               → repeats string n times (Java 11+)
 *   .reversed()              → NOT available on String; use StringBuilder.reverse()
 *
 * SPLITTING & JOINING:
 *   .split(regex)            → splits into String[]
 *   .split(regex, limit)     → splits with a max number of parts
 *   String.join(delim, ...)  → joins strings with a delimiter (static)
 *   String.format(fmt, ...)  → formats a string like printf (static)
 *
 * TYPE CONVERSION:
 *   String.valueOf(x)        → converts any type to String (static)
 *   Integer.parseInt(s)      → String to int
 *   Double.parseDouble(s)    → String to double
 *   .toCharArray()           → String to char[]
 *
 * CHECKING CONTENT:
 *   Character.isDigit(c)     → checks if a char is a digit
 *   Character.isLetter(c)    → checks if a char is a letter
 *   Character.isWhitespace(c)→ checks if a char is whitespace
 *
 * ============================================================
 *               STRING vs StringBuilder vs StringBuffer
 * ============================================================
 *
 *  Feature        | String        | StringBuilder  | StringBuffer
 *  ---------------|---------------|----------------|-------------
 *  Mutable        | No            | Yes            | Yes
 *  Thread-safe    | Yes           | No             | Yes
 *  Performance    | Slow (concat) | Fast           | Slower than SB
 *  Use when       | Fixed text    | Single-thread  | Multi-thread
 *
 * ============================================================
 */
public class Strings {
    public static void main(String[] args) {

        String myName = "Agourari Ossama";

        // --------------------------------------------------------
        // BASIC DECLARATION
        // --------------------------------------------------------
        String name = "John Doe";
        String greeting = "Hello, " + name + "!";
        System.out.println(greeting); // Hello, John Doe!

        // --------------------------------------------------------
        // EXERCISE 1: length()
        // Get the number of characters in a string.
        // --------------------------------------------------------
        String word = "MasterJava";
        System.out.println("Length: " + word.length()); // 10

        // --------------------------------------------------------
        // EXERCISE 2: charAt()
        // Get a character at a specific index (0-based).
        // --------------------------------------------------------
        System.out.println("Char at index 0: " + word.charAt(0)); // M
        System.out.println("Char at index 6: " + word.charAt(6)); // J

        // --------------------------------------------------------
        // EXERCISE 3: indexOf() and lastIndexOf()
        // Find position of a character or substring.
        // --------------------------------------------------------
        String sentence = "Java is great, Java is fun!";
        System.out.println("First 'Java': " + sentence.indexOf("Java"));     // 0
        System.out.println("Last 'Java':  " + sentence.lastIndexOf("Java")); // 15
        System.out.println("indexOf 'x':  " + sentence.indexOf("x"));        // -1 (not found)

        // --------------------------------------------------------
        // EXERCISE 4: substring()
        // Extract part of a string.
        // --------------------------------------------------------
        String text = "Hello, World!";
        System.out.println(text.substring(7));     // World!
        System.out.println(text.substring(7, 12)); // World

        // --------------------------------------------------------
        // EXERCISE 5: toUpperCase() and toLowerCase()
        // --------------------------------------------------------
        String mixed = "Java Programming";
        System.out.println(mixed.toUpperCase()); // JAVA PROGRAMMING
        System.out.println(mixed.toLowerCase()); // java programming

        // --------------------------------------------------------
        // EXERCISE 6: trim() and strip()
        // Remove leading and trailing whitespace.
        // --------------------------------------------------------
        String padded = "   Hello World   ";
        System.out.println("[" + padded.trim() + "]");  // [Hello World]
        System.out.println("[" + padded.strip() + "]"); // [Hello World]

        // --------------------------------------------------------
        // EXERCISE 7: replace() and replaceAll()
        // Replace characters or substrings.
        // --------------------------------------------------------
        String original = "banana";
        System.out.println(original.replace('a', 'o'));          // bonono
        System.out.println(original.replace("an", "UN"));        // bUNUNa
        System.out.println(original.replaceAll("[aeiou]", "*")); // b*n*n* (regex)

        // --------------------------------------------------------
        // EXERCISE 8: contains(), startsWith(), endsWith()
        // Check if a string contains or starts/ends with something.
        // --------------------------------------------------------
        String url = "https://www.example.com";
        System.out.println(url.contains("example")); // true
        System.out.println(url.startsWith("https")); // true
        System.out.println(url.endsWith(".com"));     // true

        // --------------------------------------------------------
        // EXERCISE 9: equals() vs equalsIgnoreCase()
        // Compare string content (NEVER use == for content comparison).
        // --------------------------------------------------------
        String s1 = "hello";
        String s2 = "HELLO";
        System.out.println(s1.equals(s2));             // false
        System.out.println(s1.equalsIgnoreCase(s2));   // true

        // --------------------------------------------------------
        // EXERCISE 10: compareTo()
        // Lexicographic comparison. Returns 0 if equal,
        // negative if s1 < s2, positive if s1 > s2.
        // --------------------------------------------------------
        System.out.println("apple".compareTo("banana")); // negative (a < b)
        System.out.println("java".compareTo("java"));    // 0
        System.out.println("z".compareTo("a"));          // positive

        // --------------------------------------------------------
        // EXERCISE 11: split()
        // Split a string into an array.
        // --------------------------------------------------------
        String csv = "Alice,Bob,Charlie,Diana";
        String[] names = csv.split(",");
        for (String n : names) {
            System.out.println(n); // Alice / Bob / Charlie / Diana
        }

        // --------------------------------------------------------
        // EXERCISE 12: String.join()
        // Join multiple strings with a delimiter.
        // --------------------------------------------------------
        String joined = String.join(" - ", "Java", "Python", "C++");
        System.out.println(joined); // Java - Python - C++

        // --------------------------------------------------------
        // EXERCISE 13: String.format()
        // Build formatted strings.
        // --------------------------------------------------------
        String formatted = String.format("Name: %s, Age: %d, Score: %.2f", "Alice", 30, 98.567);
        System.out.println(formatted); // Name: Alice, Age: 30, Score: 98.57

        // --------------------------------------------------------
        // EXERCISE 14: isEmpty() and isBlank()
        // Check for empty or whitespace-only strings.
        // --------------------------------------------------------
        System.out.println("".isEmpty());     // true
        System.out.println("  ".isEmpty());   // false
        System.out.println("  ".isBlank());   // true  (Java 11+)
        System.out.println("hi".isBlank());   // false

        // --------------------------------------------------------
        // EXERCISE 15: repeat()  (Java 11+)
        // Repeat a string n times.
        // --------------------------------------------------------
        System.out.println("ha".repeat(3));  // hahaha
        System.out.println("-".repeat(20));  // --------------------

        // --------------------------------------------------------
        // EXERCISE 16: toCharArray()
        // Convert a string to an array of characters.
        // --------------------------------------------------------
        char[] chars = "Hello".toCharArray();
        for (char c : chars) {
            System.out.print(c + " "); // H e l l o
        }
        System.out.println();

        // --------------------------------------------------------
        // EXERCISE 17: String.valueOf()
        // Convert other types to String.
        // --------------------------------------------------------
        int num = 42;
        double pi = 3.14159;
        boolean flag = true;
        System.out.println(String.valueOf(num));  // "42"
        System.out.println(String.valueOf(pi));   // "3.14159"
        System.out.println(String.valueOf(flag)); // "true"

        // --------------------------------------------------------
        // EXERCISE 18: Parsing Strings back to primitives.
        // --------------------------------------------------------
        String strNum = "123";
        int parsedInt = Integer.parseInt(strNum);
        double parsedDouble = Double.parseDouble("3.14");
        System.out.println(parsedInt + 10);    // 133
        System.out.println(parsedDouble * 2);  // 6.28

        // --------------------------------------------------------
        // EXERCISE 19: String Pool vs new String()
        // Understanding reference vs content equality.
        // --------------------------------------------------------
        String poolA = "Java";
        String poolB = "Java";
        String heapA = new String("Java");
        System.out.println(poolA == poolB);           // true  (same pool reference)
        System.out.println(poolA == heapA);           // false (different objects)
        System.out.println(poolA.equals(heapA));      // true  (same content)
        System.out.println(heapA.intern() == poolA);  // true  (intern() returns pool ref)

        // --------------------------------------------------------
        // EXERCISE 20: StringBuilder (mutable, efficient for loops)
        // --------------------------------------------------------
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            sb.append("item").append(i);
            if (i < 5) sb.append(", ");
        }
        System.out.println(sb.toString()); // item1, item2, item3, item4, item5
        sb.reverse();
        System.out.println(sb.toString()); // reversed version
        sb.insert(0, "[").append("]");
        System.out.println(sb.toString()); // wrapped in brackets

        // --------------------------------------------------------
        // EXERCISE 21: Count vowels in a string
        // Practical use of charAt() and loop.
        // --------------------------------------------------------
        String testStr = "Programming in Java";
        int vowelCount = 0;
        for (char c : testStr.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) vowelCount++;
        }
        System.out.println("Vowels in \"" + testStr + "\": " + vowelCount); // 7

        // --------------------------------------------------------
        // EXERCISE 22: Reverse a string manually
        // --------------------------------------------------------
        String toReverse = "MasterJava";
        StringBuilder reversed = new StringBuilder(toReverse).reverse();
        System.out.println("Reversed: " + reversed); // avaJretsaM

        // --------------------------------------------------------
        // EXERCISE 23: Check if a string is a palindrome
        // --------------------------------------------------------
        String palindrome = "racecar";
        String rev = new StringBuilder(palindrome).reverse().toString();
        System.out.println(palindrome + " is palindrome: " + palindrome.equals(rev)); // true

        // --------------------------------------------------------
        // EXERCISE 24: Count word frequency using split()
        // --------------------------------------------------------
        String paragraph = "the cat sat on the mat and the cat sat";
        String[] words = paragraph.split(" ");
        int countThe = 0;
        for (String w : words) {
            if (w.equals("the")) countThe++;
        }
        System.out.println("'the' appears: " + countThe + " times"); // 3

        // --------------------------------------------------------
        // EXERCISE 25: matches() with regex
        // Check if a string matches a pattern.
        // --------------------------------------------------------
        String email = "test@example.com";
        String phone = "123-456-7890";
        System.out.println(email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")); // true
        System.out.println(phone.matches("\\d{3}-\\d{3}-\\d{4}"));                             // true

        // --------------------------------------------------------
        // SUMMARY OUTPUT
        // --------------------------------------------------------
        System.out.println("\n=== String Quick Reference ===");
        String demo = "  Hello, Java World!  ";
        System.out.println("Original  : [" + demo + "]");
        System.out.println("stripped  : [" + demo.strip() + "]");
        System.out.println("length    : " + demo.strip().length());
        System.out.println("upper     : " + demo.strip().toUpperCase());
        System.out.println("contains  : " + demo.contains("Java"));
        System.out.println("replace   : " + demo.strip().replace("Java", "Python"));
        System.out.println("substring : " + demo.strip().substring(7, 11));
        System.out.println("split[1]  : " + demo.strip().split(" ")[1]);
    }
}