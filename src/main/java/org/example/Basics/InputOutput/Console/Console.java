package org.example.Basics.InputOutput.Console;

import java.util.Scanner;

/**
 * ============================================================
 *           JAVA CONSOLE INPUT/OUTPUT - COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS CONSOLE I/O?
 * ---------------------
 * Console I/O lets your program communicate with the user through
 * the terminal: printing output and reading keyboard input.
 *
 * OUTPUT METHODS (System.out):
 * -----------------------------
 *   Method                  | Behavior
 *   ------------------------|------------------------------------------
 *   System.out.print(x)     | Prints x, NO newline at the end
 *   System.out.println(x)   | Prints x, ADDS a newline at the end
 *   System.out.printf(fmt)  | Prints formatted text (like C printf)
 *   System.out.flush()      | Forces buffered output to appear
 *   System.err.println(x)   | Prints to error stream (stderr)
 *
 * READING INPUT — Scanner class:
 * --------------------------------
 *   Create:   Scanner sc = new Scanner(System.in);
 *   Close:    sc.close();  ← always close when done
 *
 *   Method           | Reads
 *   -----------------|-------------------------------------------
 *   sc.nextInt()     | next int token
 *   sc.nextLong()    | next long token
 *   sc.nextDouble()  | next double token
 *   sc.nextBoolean() | next boolean token ("true"/"false")
 *   sc.next()        | next whitespace-delimited token (String)
 *   sc.nextLine()    | entire remaining line (including spaces)
 *   sc.hasNext()     | true if another token exists
 *   sc.hasNextInt()  | true if next token is a valid int
 *
 * IMPORTANT — nextLine() after nextInt() GOTCHA:
 * ------------------------------------------------
 * After sc.nextInt(), the newline character '\n' is left in the buffer.
 * The next sc.nextLine() call will consume ONLY that leftover newline
 * and return "", not the next full line.
 * FIX: call sc.nextLine() once to consume the leftover newline:
 *
 *   int age = sc.nextInt();
 *   sc.nextLine();          // consume leftover '\n'
 *   String name = sc.nextLine(); // now reads correctly
 *
 * DELIMITER CHANGE:
 * ------------------
 *   sc.useDelimiter(",")   → splits tokens by comma instead of whitespace
 *   sc.useDelimiter("\\s+") → split on any whitespace (default)
 *
 * PARSING STRINGS WITHOUT Scanner:
 * ----------------------------------
 *   Integer.parseInt("42")        → 42
 *   Double.parseDouble("3.14")    → 3.14
 *   Boolean.parseBoolean("true")  → true
 *   String.valueOf(42)            → "42"
 *
 * SYSTEM STREAMS:
 * ----------------
 *   System.in   → InputStream (keyboard input)
 *   System.out  → PrintStream (normal output)
 *   System.err  → PrintStream (error output, usually red in IDEs)
 *
 * ============================================================
 */
public class Console {
    public static void main(String[] args) {

        // --------------------------------------------------------
        // EXERCISE 1: print vs println
        // --------------------------------------------------------
        System.out.print("Hello");    // no newline
        System.out.print(", ");       // still on same line
        System.out.println("World!"); // adds newline
        System.out.println();         // blank line

        // --------------------------------------------------------
        // EXERCISE 2: Printing different types
        // --------------------------------------------------------
        System.out.println(42);          // int
        System.out.println(3.14);        // double
        System.out.println(true);        // boolean
        System.out.println('A');         // char
        System.out.println((Object)null);// null  → prints "null"

        // --------------------------------------------------------
        // EXERCISE 3: String concatenation in output
        // --------------------------------------------------------
        String name = "Alice";
        int age = 30;
        System.out.println("Name: " + name + ", Age: " + age);
        // Preferred: use printf instead of +
        System.out.printf("Name: %s, Age: %d%n", name, age);

        // --------------------------------------------------------
        // EXERCISE 4: printf format specifiers
        // --------------------------------------------------------
        System.out.printf("Integer:  %d%n",   42);
        System.out.printf("Float:    %.2f%n", 3.14159);
        System.out.printf("String:   %s%n",   "Java");
        System.out.printf("Boolean:  %b%n",   true);
        System.out.printf("Char:     %c%n",   'Z');
        System.out.printf("Hex:      %x%n",   255);     // ff
        System.out.printf("Octal:    %o%n",   8);       // 10
        System.out.printf("Sci:      %e%n",   123456.789); // 1.234568e+05
        System.out.printf("Percent:  100%%%n");           // literal %

        // --------------------------------------------------------
        // EXERCISE 5: Width and alignment with printf
        // --------------------------------------------------------
        System.out.printf("[%10d]%n",   42);    // right-align in 10 chars
        System.out.printf("[%-10d]%n",  42);    // left-align
        System.out.printf("[%010d]%n",  42);    // zero-padded
        System.out.printf("[%+d]%n",    42);    // force sign: +42
        System.out.printf("[%10.2f]%n", 3.14);  // width 10, 2 decimal places

        // --------------------------------------------------------
        // EXERCISE 6: System.err for error messages
        // --------------------------------------------------------
        System.out.println("This is normal output");
        System.err.println("This is an error message"); // goes to stderr

        // --------------------------------------------------------
        // EXERCISE 7: Scanner reading from a String (simulating keyboard)
        // In real programs: new Scanner(System.in)
        // --------------------------------------------------------
        Scanner sc = new Scanner("42 3.14 true hello");
        int    i = sc.nextInt();
        double d = sc.nextDouble();
        boolean b = sc.nextBoolean();
        String s = sc.next();
        System.out.println("int=" + i + ", double=" + d + ", bool=" + b + ", str=" + s);
        sc.close();

        // --------------------------------------------------------
        // EXERCISE 8: Scanner nextLine — reading full lines
        // --------------------------------------------------------
        Scanner lineScanner = new Scanner("first line\nsecond line\nthird line");
        while (lineScanner.hasNextLine()) {
            System.out.println("Line: " + lineScanner.nextLine());
        }
        lineScanner.close();

        // --------------------------------------------------------
        // EXERCISE 9: Scanner with delimiter (CSV parsing)
        // --------------------------------------------------------
        Scanner csv = new Scanner("Alice,30,Engineer");
        csv.useDelimiter(",");
        String csvName = csv.next();
        int    csvAge  = csv.nextInt();
        String csvJob  = csv.next();
        System.out.println("Name=" + csvName + ", Age=" + csvAge + ", Job=" + csvJob);
        csv.close();

        // --------------------------------------------------------
        // EXERCISE 10: hasNextInt() for safe input validation
        // --------------------------------------------------------
        Scanner safe = new Scanner("42 notANumber 99");
        while (safe.hasNext()) {
            if (safe.hasNextInt()) {
                System.out.println("Found int: " + safe.nextInt());
            } else {
                System.out.println("Skipping non-int: " + safe.next());
            }
        }
        safe.close();

        // --------------------------------------------------------
        // EXERCISE 11: Parsing primitives from Strings
        // --------------------------------------------------------
        int    parsedInt    = Integer.parseInt("123");
        long   parsedLong   = Long.parseLong("9876543210");
        double parsedDouble = Double.parseDouble("3.1415");
        boolean parsedBool  = Boolean.parseBoolean("true");
        System.out.println(parsedInt + ", " + parsedLong + ", " + parsedDouble + ", " + parsedBool);

        // --------------------------------------------------------
        // EXERCISE 12: NumberFormatException when parsing fails
        // --------------------------------------------------------
        try {
            int bad = Integer.parseInt("abc"); // throws NumberFormatException
        } catch (NumberFormatException e) {
            System.out.println("Parse error: " + e.getMessage());
        }

        // --------------------------------------------------------
        // EXERCISE 13: Reading multiple values on one line
        // --------------------------------------------------------
        Scanner multi = new Scanner("10 20 30 40 50");
        int sum = 0;
        while (multi.hasNextInt()) {
            sum += multi.nextInt();
        }
        System.out.println("Sum: " + sum); // 150
        multi.close();

        // --------------------------------------------------------
        // EXERCISE 14: Counting tokens
        // --------------------------------------------------------
        Scanner tokenCounter = new Scanner("the quick brown fox");
        int count = 0;
        while (tokenCounter.hasNext()) {
            tokenCounter.next();
            count++;
        }
        System.out.println("Token count: " + count); // 4
        tokenCounter.close();

        // --------------------------------------------------------
        // EXERCISE 15: Converting between String and primitives
        // --------------------------------------------------------
        // Primitive → String
        String fromInt    = String.valueOf(42);         // "42"
        String fromDouble = String.valueOf(3.14);       // "3.14"
        String fromBool   = String.valueOf(false);      // "false"
        String fromChar   = String.valueOf('X');        // "X"
        // String → Primitive
        int    toInt    = Integer.parseInt("42");
        double toDouble = Double.parseDouble("3.14");
        System.out.println(fromInt + " | " + fromDouble + " | " + toInt + " | " + toDouble);

        // --------------------------------------------------------
        // SUMMARY
        // --------------------------------------------------------
        System.out.println("\n=== Console I/O Quick Reference ===");
        System.out.println("Output: print (no newline), println (newline), printf (formatted)");
        System.out.println("Input:  new Scanner(System.in) → nextInt/nextDouble/next/nextLine");
        System.out.println("Parse:  Integer.parseInt / Double.parseDouble / Boolean.parseBoolean");
        System.out.println("Always close Scanner when done: sc.close()");
    }
}
