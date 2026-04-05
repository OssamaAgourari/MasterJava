package org.example.Basics.InputOutput.Formatted;

/**
 * ============================================================
 *         JAVA FORMATTED OUTPUT - COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS FORMATTED OUTPUT?
 * --------------------------
 * Java provides powerful tools to produce nicely formatted text:
 * fixed-width columns, decimal precision, padding, and more.
 *
 * THREE WAYS TO FORMAT:
 * ----------------------
 *   1. System.out.printf(format, args...)  → prints directly
 *   2. String.format(format, args...)      → returns a String
 *   3. String.formatted(args...) [Java 15+]→ instance method on string
 *
 * FORMAT STRING SYNTAX:
 * ----------------------
 *   %[flags][width][.precision]conversion
 *
 * CONVERSION CHARACTERS:
 * -----------------------
 *   %d  → decimal integer (int, long)
 *   %f  → floating-point (float, double)
 *   %e  → scientific notation (1.23e+04)
 *   %g  → shorter of %f or %e
 *   %s  → string (any object, calls toString())
 *   %S  → string UPPERCASE
 *   %c  → char
 *   %C  → char UPPERCASE
 *   %b  → boolean
 *   %B  → boolean UPPERCASE
 *   %x  → integer as hexadecimal (lowercase)
 *   %X  → integer as hexadecimal (uppercase)
 *   %o  → integer as octal
 *   %n  → platform newline (preferred over \n in printf)
 *   %%  → literal percent sign
 *   %t  → date/time (see below)
 *
 * FLAGS:
 * -------
 *   -   → left-justify (default is right-justify)
 *   +   → always include sign (+42 or -42)
 *   0   → pad with leading zeros (042)
 *   ,   → use grouping separator (1,000,000)
 *   (   → enclose negative numbers in parentheses (-42 → (42))
 *   space → add a space before positive numbers
 *
 * WIDTH:
 * -------
 *   Minimum number of characters. Padded with spaces if shorter.
 *   %10d → right-aligned in 10 chars
 *   %-10d → left-aligned in 10 chars
 *
 * PRECISION:
 * -----------
 *   For %f: number of digits after decimal point.  %.2f → 3.14
 *   For %s: maximum number of characters to print. %.5s → first 5 chars
 *   For %e: digits after decimal in scientific notation.
 *
 * DATE/TIME FORMATTING (%t):
 * ---------------------------
 *   %tY → 4-digit year          %tH → hour (00-23)
 *   %tm → month (01-12)         %tM → minutes (00-59)
 *   %td → day (01-31)           %tS → seconds (00-59)
 *   %tA → full day name         %tB → full month name
 *   %tF → "YYYY-MM-DD" (ISO)    %tT → "HH:MM:SS"
 *
 * USEFUL String METHODS:
 * -----------------------
 *   String.format(fmt, ...)      → format to string
 *   str.formatted(...)           → format using str as template (Java 15+)
 *   "%s".repeat(n)               → repeat format n times
 *
 * ============================================================
 */
public class Formatted {
    public static void main(String[] args) {

        // --------------------------------------------------------
        // EXERCISE 1: printf vs String.format
        // --------------------------------------------------------
        System.out.printf("Hello, %s! You are %d years old.%n", "Alice", 30);
        String msg = String.format("Hello, %s! You are %d years old.", "Bob", 25);
        System.out.println(msg);

        // --------------------------------------------------------
        // EXERCISE 2: Integer formatting
        // --------------------------------------------------------
        int n = 42;
        System.out.printf("[%d]%n",    n);  // default: [42]
        System.out.printf("[%8d]%n",   n);  // width 8, right: [      42]
        System.out.printf("[%-8d]%n",  n);  // width 8, left:  [42      ]
        System.out.printf("[%08d]%n",  n);  // zero-pad:       [00000042]
        System.out.printf("[%+d]%n",   n);  // force sign:     [+42]
        System.out.printf("[%(d]%n",  -n);  // negative paren: [(42)]
        System.out.printf("[%,d]%n",   1000000); // grouping:  [1,000,000]

        // --------------------------------------------------------
        // EXERCISE 3: Floating-point formatting
        // --------------------------------------------------------
        double pi = Math.PI;
        System.out.printf("%.0f%n",  pi);   // 3           (0 decimals)
        System.out.printf("%.2f%n",  pi);   // 3.14        (2 decimals)
        System.out.printf("%.5f%n",  pi);   // 3.14159     (5 decimals)
        System.out.printf("%10.3f%n",pi);   //      3.142  (width 10)
        System.out.printf("%-10.3f|%n",pi); // 3.142      |(left-align)
        System.out.printf("%e%n",    pi);   // 3.141593e+00
        System.out.printf("%.2e%n",  pi);   // 3.14e+00

        // --------------------------------------------------------
        // EXERCISE 4: String formatting
        // --------------------------------------------------------
        String word = "Java";
        System.out.printf("[%s]%n",    word);   // [Java]
        System.out.printf("[%10s]%n",  word);   // [      Java]
        System.out.printf("[%-10s]%n", word);   // [Java      ]
        System.out.printf("[%.3s]%n",  word);   // [Jav]  (truncate to 3)
        System.out.printf("[%S]%n",    word);   // [JAVA]  (uppercase)

        // --------------------------------------------------------
        // EXERCISE 5: Multiple arguments and mixing types
        // --------------------------------------------------------
        System.out.printf("%-15s %5d  %8.2f%n", "Alice",   30,  75000.50);
        System.out.printf("%-15s %5d  %8.2f%n", "Bob",     25,  55000.00);
        System.out.printf("%-15s %5d  %8.2f%n", "Charlie", 35, 120000.75);

        // --------------------------------------------------------
        // EXERCISE 6: Boolean and char formatting
        // --------------------------------------------------------
        System.out.printf("%b%n",  true);   // true
        System.out.printf("%B%n",  false);  // FALSE
        System.out.printf("%c%n",  'A');    // A
        System.out.printf("%C%n",  'a');    // A  (uppercase)
        System.out.printf("%b%n",  null);   // false  (null → false)
        System.out.printf("%b%n",  "hi");   // true   (any non-null object)

        // --------------------------------------------------------
        // EXERCISE 7: Hex and octal formatting
        // --------------------------------------------------------
        System.out.printf("%d in hex:   %x%n",  255, 255);  // ff
        System.out.printf("%d in HEX:   %X%n",  255, 255);  // FF
        System.out.printf("%d with 0x:  %#x%n", 255, 255);  // 0xff
        System.out.printf("%d in octal: %o%n",  8,   8);    // 10

        // --------------------------------------------------------
        // EXERCISE 8: Formatted table
        // --------------------------------------------------------
        System.out.println("\n--- Product Table ---");
        System.out.printf("%-20s %6s %10s%n", "Product", "Qty", "Price");
        System.out.printf("%-20s %6d %10.2f%n", "Apple",     100,   0.99);
        System.out.printf("%-20s %6d %10.2f%n", "Banana",     50,   0.49);
        System.out.printf("%-20s %6d %10.2f%n", "Cherry",    200,   2.99);

        // --------------------------------------------------------
        // EXERCISE 9: Percentage formatting
        // --------------------------------------------------------
        double ratio = 0.87654;
        System.out.printf("Ratio: %.1f%%%n", ratio * 100);  // 87.7%
        System.out.printf("Ratio: %5.2f%%%n", ratio * 100); //  87.65%

        // --------------------------------------------------------
        // EXERCISE 10: Building strings with String.format
        // --------------------------------------------------------
        String formatted = String.format("%-10s: %5.2f", "Score", 9.75);
        System.out.println(formatted);   // Score     :  9.75

        String padded = String.format("%05d", 42);
        System.out.println(padded);      // 00042

        // --------------------------------------------------------
        // EXERCISE 11: Repeating separators
        // --------------------------------------------------------
        String separator = "-".repeat(40);
        System.out.println(separator);

        // --------------------------------------------------------
        // EXERCISE 12: Date/time formatting (using System.currentTimeMillis)
        // --------------------------------------------------------
        long now = System.currentTimeMillis();
        System.out.printf("Timestamp: %d%n", now);
        // Using java.util.Date for format specifiers:
        java.util.Date date = new java.util.Date();
        System.out.printf("Date: %tF%n",  date);  // YYYY-MM-DD
        System.out.printf("Time: %tT%n",  date);  // HH:MM:SS

        // --------------------------------------------------------
        // EXERCISE 13: Currency-style output
        // --------------------------------------------------------
        double price = 1234.5;
        System.out.printf("Price: $%,.2f%n", price);  // $1,234.50

        // --------------------------------------------------------
        // EXERCISE 14: Literal % with %%
        // --------------------------------------------------------
        double tax = 0.21;
        System.out.printf("Tax rate: %.0f%%%n", tax * 100); // Tax rate: 21%

        // --------------------------------------------------------
        // EXERCISE 15: String.formatted() — Java 15+
        // --------------------------------------------------------
        String template = "(%s, %d)";
        String point = template.formatted("x", 5);
        System.out.println(point); // (x, 5)

        // --------------------------------------------------------
        // SUMMARY
        // --------------------------------------------------------
        System.out.println("\n=== Formatted Output Quick Reference ===");
        System.out.printf("%%d  → %d%n",   42);
        System.out.printf("%%.2f→ %.2f%n", 3.14159);
        System.out.printf("%%s  → %s%n",   "text");
        System.out.printf("%%8d → [%8d]%n",  42);
        System.out.printf("%%-8d→ [%-8d]%n", 42);
        System.out.printf("%%08d→ [%08d]%n", 42);
        System.out.printf("%%,d → %,d%n",  1234567);
    }
}
