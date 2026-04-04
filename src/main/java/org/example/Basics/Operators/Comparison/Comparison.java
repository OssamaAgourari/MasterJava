package org.example.Basics.Operators.Comparison;

/**
 * ============================================================
 *           JAVA COMPARISON OPERATORS - COMPLETE GUIDE
 * ============================================================
 *
 * WHAT ARE COMPARISON OPERATORS?
 * --------------------------------
 * Comparison (relational) operators compare two values and always
 * return a boolean result: true or false.
 *
 * OPERATOR TABLE:
 * ---------------
 *   Operator | Meaning                 | Example  | Result
 *   ---------|-------------------------|----------|-------
 *   ==       | Equal to                | 5 == 5   | true
 *   !=       | Not equal to            | 5 != 3   | true
 *   >        | Greater than            | 5 > 3    | true
 *   <        | Less than               | 5 < 3    | false
 *   >=       | Greater than or equal   | 5 >= 5   | true
 *   <=       | Less than or equal      | 5 <= 4   | false
 *
 * USE WITH PRIMITIVES:
 * --------------------
 * - Works directly on: int, long, double, char, byte, short, float
 * - Comparison of primitives compares VALUES.
 *   int a = 5, b = 5; → a == b is true
 *
 * USE WITH OBJECTS (IMPORTANT!):
 * --------------------------------
 * - == on objects compares REFERENCES (memory addresses), NOT content.
 *   String s1 = new String("hi");
 *   String s2 = new String("hi");
 *   s1 == s2       → false  (different objects in memory)
 *   s1.equals(s2)  → true   (same content)
 *
 * - String literals use the String Pool, so == can be true for literals:
 *   String a = "hi"; String b = "hi"; → a == b is true (same pool reference)
 *   But ALWAYS use .equals() to be safe and clear about intent.
 *
 * COMPARING WITH null:
 * ---------------------
 *   str == null    → true if str is null (safe check)
 *   str != null    → true if str is not null
 *   null == null   → true
 *   Never call a method on null — it throws NullPointerException.
 *
 * char COMPARISON:
 * ----------------
 * - chars are compared by their Unicode value.
 *   'a' < 'b'  → true  ('a' = 97, 'b' = 98)
 *   'A' < 'a'  → true  ('A' = 65, 'a' = 97)
 *
 * CHAINING COMPARISONS:
 * ----------------------
 * - Java does NOT support chained comparisons like Python's 1 < x < 10.
 * - Use logical operators: x > 1 && x < 10
 *
 * COMPARING WRAPPER OBJECTS:
 * ---------------------------
 * - Integer, Double, etc. have a cache for small values (-128 to 127).
 *   Integer a = 127; Integer b = 127; → a == b  TRUE (cached)
 *   Integer a = 128; Integer b = 128; → a == b  FALSE (new objects)
 *   Always use .equals() or Integer.compare(a, b) for wrapper types.
 *
 * Comparable INTERFACE:
 * ----------------------
 * - Classes implementing Comparable define their natural ordering via compareTo().
 *   Returns: negative if this < other, 0 if equal, positive if this > other.
 *   "apple".compareTo("banana") → negative  (a < b lexicographically)
 *
 * ============================================================
 */
public class Comparison {
    public static void main(String[] args) {

        // --------------------------------------------------------
        // EXERCISE 1: Basic comparison of primitives
        // --------------------------------------------------------
        int a = 10, b = 20;
        System.out.println(a == b);  // false
        System.out.println(a != b);  // true
        System.out.println(a >  b);  // false
        System.out.println(a <  b);  // true
        System.out.println(a >= 10); // true
        System.out.println(a <= 9);  // false

        // --------------------------------------------------------
        // EXERCISE 2: Comparison result stored in a boolean
        // --------------------------------------------------------
        boolean isAdult = a >= 18;
        boolean isEqual = a == b;
        System.out.println("isAdult: " + isAdult); // false
        System.out.println("isEqual: " + isEqual); // false

        // --------------------------------------------------------
        // EXERCISE 3: Comparison in if/else
        // --------------------------------------------------------
        int score = 75;
        if (score >= 90)      System.out.println("A");
        else if (score >= 80) System.out.println("B");
        else if (score >= 70) System.out.println("C");
        else                  System.out.println("F");
        // Output: C

        // --------------------------------------------------------
        // EXERCISE 4: char comparison (by Unicode value)
        // --------------------------------------------------------
        char c1 = 'a', c2 = 'b', c3 = 'A';
        System.out.println(c1 < c2);   // true  (97 < 98)
        System.out.println(c3 < c1);   // true  (65 < 97)
        System.out.println(c1 == 'a'); // true

        // --------------------------------------------------------
        // EXERCISE 5: == vs equals() for Strings
        // --------------------------------------------------------
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");

        System.out.println(s1 == s2);         // true  (same pool reference)
        System.out.println(s1 == s3);         // false (s3 is a new object)
        System.out.println(s1.equals(s3));    // true  (same content)
        System.out.println(s1.equalsIgnoreCase("HELLO")); // true

        // --------------------------------------------------------
        // EXERCISE 6: null checks
        // --------------------------------------------------------
        String str = null;
        System.out.println(str == null);  // true
        System.out.println(str != null);  // false
        // Safe null check before calling methods:
        if (str != null) {
            System.out.println(str.length());
        } else {
            System.out.println("str is null — cannot call methods");
        }

        // --------------------------------------------------------
        // EXERCISE 7: Integer wrapper == gotcha (cache boundary)
        // --------------------------------------------------------
        Integer x = 127, y = 127;
        Integer p = 128, q = 128;
        System.out.println(x == y);        // true  (cached -128 to 127)
        System.out.println(p == q);        // false (outside cache range)
        System.out.println(p.equals(q));   // true  (use equals!)
        System.out.println(Integer.compare(p, q)); // 0 (equal)

        // --------------------------------------------------------
        // EXERCISE 8: compareTo() — String ordering
        // --------------------------------------------------------
        System.out.println("apple".compareTo("banana")); // negative  (a < b)
        System.out.println("java".compareTo("java"));    // 0         (equal)
        System.out.println("z".compareTo("a"));          // positive  (z > a)
        System.out.println("Apple".compareTo("apple"));  // negative  (A=65 < a=97)

        // --------------------------------------------------------
        // EXERCISE 9: Comparing doubles (floating-point precision)
        // --------------------------------------------------------
        double d1 = 0.1 + 0.2;
        double d2 = 0.3;
        System.out.println(d1 == d2);                          // false! (floating-point error)
        System.out.println(d1);                                 // 0.30000000000000004
        System.out.println(Math.abs(d1 - d2) < 1e-9);         // true   (use epsilon comparison)

        // --------------------------------------------------------
        // EXERCISE 10: Range check (chained with &&)
        // --------------------------------------------------------
        int age = 25;
        boolean isWorkingAge = age >= 18 && age <= 65;
        System.out.println("Working age: " + isWorkingAge); // true

        // --------------------------------------------------------
        // EXERCISE 11: Ternary operator with comparison
        // --------------------------------------------------------
        int m = 15, n = 22;
        int max = m > n ? m : n;
        int min = m < n ? m : n;
        System.out.println("Max: " + max); // 22
        System.out.println("Min: " + min); // 15

        // --------------------------------------------------------
        // EXERCISE 12: Comparing arrays
        // == checks reference, Arrays.equals() checks content
        // --------------------------------------------------------
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = arr1;
        System.out.println(arr1 == arr2);                      // false (different objects)
        System.out.println(arr1 == arr3);                      // true  (same reference)
        System.out.println(java.util.Arrays.equals(arr1, arr2)); // true (same content)

        // --------------------------------------------------------
        // EXERCISE 13: Find the largest of three numbers
        // --------------------------------------------------------
        int x1 = 42, x2 = 17, x3 = 89;
        int largest = x1;
        if (x2 > largest) largest = x2;
        if (x3 > largest) largest = x3;
        System.out.println("Largest: " + largest); // 89

        // --------------------------------------------------------
        // EXERCISE 14: Check if a year is a leap year
        // Divisible by 4, EXCEPT centuries (divisible by 100),
        // UNLESS also divisible by 400.
        // --------------------------------------------------------
        int year = 2024;
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println(year + " is leap: " + isLeap); // true

        // --------------------------------------------------------
        // EXERCISE 15: Comparable with Integer.compare()
        // --------------------------------------------------------
        System.out.println(Integer.compare(10, 20));  // -1
        System.out.println(Integer.compare(20, 20));  //  0
        System.out.println(Integer.compare(30, 20));  //  1
        System.out.println(Double.compare(1.5, 2.5)); // -1

        // --------------------------------------------------------
        // SUMMARY
        // --------------------------------------------------------
        System.out.println("\n=== Comparison Quick Reference ===");
        int demo = 10;
        System.out.println("10 == 10: " + (demo == 10));
        System.out.println("10 != 5 : " + (demo != 5));
        System.out.println("10 >  5 : " + (demo >  5));
        System.out.println("10 <  5 : " + (demo <  5));
        System.out.println("10 >= 10: " + (demo >= 10));
        System.out.println("10 <= 9 : " + (demo <= 9));
        System.out.println("Use .equals() for objects, never == !");
    }
}
