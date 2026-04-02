package org.example.Basics.VariablesAndDataTypes.Numbers;

/**
 * ============================================================
 *           JAVA FLOATING-POINT NUMBERS - COMPLETE GUIDE
 * ============================================================
 *
 * WHAT ARE FLOATING-POINT NUMBERS?
 * ---------------------------------
 * - Numbers with a decimal point (fractional part).
 * - Java has two primitive types: float and double.
 * - Both follow the IEEE 754 standard for floating-point arithmetic.
 * - They can represent very large and very small values using scientific notation.
 *
 * TYPES & RANGES:
 * ---------------
 *   Type   | Size   | Precision        | Range (approx)
 *   -------|--------|------------------|--------------------------
 *   float  | 32-bit | ~7 decimal digits | ±3.4 × 10^38
 *   double | 64-bit | ~15 decimal digits| ±1.8 × 10^308
 *
 * - double is the DEFAULT and PREFERRED type for decimals in Java.
 * - float saves memory but sacrifices precision — use it rarely.
 *
 * DECLARATION:
 * ------------
 *   double d = 3.14;           // default decimal literal is double
 *   float  f = 3.14f;          // f or F suffix REQUIRED for float
 *   double sci = 1.5e10;       // scientific notation (1.5 × 10^10)
 *   Double obj = 3.14;         // autoboxing: double → Double wrapper
 *
 * SPECIAL VALUES:
 * ---------------
 *   Double.POSITIVE_INFINITY   → 1.0 / 0.0
 *   Double.NEGATIVE_INFINITY   → -1.0 / 0.0
 *   Double.NaN                 → Not a Number (e.g. 0.0 / 0.0, Math.sqrt(-1))
 *   Double.MAX_VALUE           → largest positive double
 *   Double.MIN_VALUE           → smallest positive double > 0
 *
 * PRECISION WARNING:
 * ------------------
 * - Floating-point numbers are APPROXIMATE due to binary representation.
 *   0.1 + 0.2 ≠ 0.3 exactly!
 * - NEVER use == to compare doubles. Instead check:
 *   Math.abs(a - b) < 1e-9
 * - For exact decimal arithmetic (money, taxes), use java.math.BigDecimal.
 *
 * ============================================================
 *           Double WRAPPER CLASS METHODS
 * ============================================================
 *
 * CONSTANTS:
 *   Double.MAX_VALUE            → largest finite double
 *   Double.MIN_VALUE            → smallest positive nonzero double
 *   Double.NaN                  → Not a Number
 *   Double.POSITIVE_INFINITY
 *   Double.NEGATIVE_INFINITY
 *   Double.SIZE                 → 64 (bits)
 *   Double.BYTES                → 8 (bytes)
 *
 * PARSING & CONVERSION:
 *   Double.parseDouble(str)     → String to double
 *   Double.valueOf(str)         → String to Double object
 *   Double.toString(d)          → double to String
 *   Double.isNaN(d)             → true if NaN
 *   Double.isInfinite(d)        → true if ±Infinity
 *   Double.isFinite(d)          → true if normal number (Java 8+)
 *   Double.compare(a, b)        → compare two doubles
 *
 * Math CLASS (commonly used with doubles):
 *   Math.abs(d)                 → absolute value
 *   Math.sqrt(d)                → square root
 *   Math.cbrt(d)                → cube root
 *   Math.pow(base, exp)         → power
 *   Math.exp(d)                 → e^d
 *   Math.log(d)                 → natural log (base e)
 *   Math.log10(d)               → log base 10
 *   Math.floor(d)               → round toward negative infinity
 *   Math.ceil(d)                → round toward positive infinity
 *   Math.round(d)               → round to nearest long
 *   Math.rint(d)                → round to nearest double
 *   Math.sin(d)                 → sine (radians)
 *   Math.cos(d)                 → cosine (radians)
 *   Math.tan(d)                 → tangent (radians)
 *   Math.toRadians(degrees)     → degrees → radians
 *   Math.toDegrees(radians)     → radians → degrees
 *   Math.PI                     → 3.141592653589793
 *   Math.E                      → 2.718281828459045
 *
 * Formatting:
 *   String.format("%.2f", d)    → 2 decimal places
 *   "%.4f".formatted(d)         → 4 decimal places (Java 15+)
 *
 * ============================================================
 *             double vs float vs BigDecimal
 * ============================================================
 *
 *  Type        | Precision  | Use when
 *  ------------|------------|-----------------------------------
 *  double      | ~15 digits | scientific, general calculations
 *  float       | ~7 digits  | memory-constrained, graphics
 *  BigDecimal  | exact      | money, finance, exact arithmetic
 *
 * ============================================================
 */
public class Doubles {
    public static void main(String[] args) {

        // --------------------------------------------------------
        // EXERCISE 1: float vs double declaration
        // --------------------------------------------------------
        float  f = 3.14f;       // f suffix required
        double d = 3.14159265358979;
        System.out.println("float:  " + f);   // 3.14
        System.out.println("double: " + d);   // 3.14159265358979

        // --------------------------------------------------------
        // EXERCISE 2: Double constants
        // --------------------------------------------------------
        System.out.println("MAX_VALUE: " + Double.MAX_VALUE);
        System.out.println("MIN_VALUE: " + Double.MIN_VALUE);
        System.out.println("SIZE:      " + Double.SIZE);   // 64
        System.out.println("BYTES:     " + Double.BYTES);  // 8
        System.out.println("PI:        " + Math.PI);

        // --------------------------------------------------------
        // EXERCISE 3: Special values — Infinity and NaN
        // --------------------------------------------------------
        double posInf = 1.0 / 0.0;
        double negInf = -1.0 / 0.0;
        double nan    = 0.0 / 0.0;
        System.out.println(posInf);              // Infinity
        System.out.println(negInf);              // -Infinity
        System.out.println(nan);                 // NaN
        System.out.println(Double.isNaN(nan));         // true
        System.out.println(Double.isInfinite(posInf)); // true
        System.out.println(Double.isFinite(3.14));     // true

        // --------------------------------------------------------
        // EXERCISE 4: Precision problem (the classic 0.1 + 0.2 bug)
        // --------------------------------------------------------
        double a = 0.1 + 0.2;
        System.out.println(a);              // 0.30000000000000004 (not 0.3!)
        System.out.println(a == 0.3);       // false!
        System.out.println(Math.abs(a - 0.3) < 1e-9); // true (correct way)

        // --------------------------------------------------------
        // EXERCISE 5: Arithmetic with doubles
        // --------------------------------------------------------
        double x = 10.5, y = 3.2;
        System.out.println(x + y);  // 13.7
        System.out.println(x - y);  // 7.3
        System.out.println(x * y);  // 33.6
        System.out.println(x / y);  // 3.28125
        System.out.println(x % y);  // 0.9 (remainder works on doubles too)

        // --------------------------------------------------------
        // EXERCISE 6: Casting between int and double
        // --------------------------------------------------------
        int intVal = 7;
        double fromInt = intVal;           // widening: int → double (automatic)
        int backToInt  = (int) fromInt;    // narrowing: double → int (explicit cast, truncates)
        double precise = (double) intVal / 2;  // force double division
        System.out.println(fromInt);    // 7.0
        System.out.println(backToInt);  // 7
        System.out.println(precise);    // 3.5

        // --------------------------------------------------------
        // EXERCISE 7: Rounding methods
        // --------------------------------------------------------
        double val = 3.75;
        System.out.println(Math.floor(val));   // 3.0 (round down)
        System.out.println(Math.ceil(val));    // 4.0 (round up)
        System.out.println(Math.round(val));   // 4   (nearest, returns long)
        System.out.println(Math.rint(val));    // 4.0 (nearest, returns double)

        // --------------------------------------------------------
        // EXERCISE 8: Math.abs(), sqrt(), cbrt(), pow()
        // --------------------------------------------------------
        System.out.println(Math.abs(-9.5));    // 9.5
        System.out.println(Math.sqrt(144.0));  // 12.0
        System.out.println(Math.cbrt(27.0));   // 3.0
        System.out.println(Math.pow(2, 8));    // 256.0

        // --------------------------------------------------------
        // EXERCISE 9: Logarithms and exponential
        // --------------------------------------------------------
        System.out.println(Math.exp(1));          // 2.718... (e^1)
        System.out.println(Math.log(Math.E));     // 1.0 (ln(e))
        System.out.println(Math.log10(1000));     // 3.0 (log10(1000))

        // --------------------------------------------------------
        // EXERCISE 10: Trigonometry
        // --------------------------------------------------------
        double angle = 45;
        double radians = Math.toRadians(angle);
        System.out.println("sin(45°): " + Math.sin(radians));  // 0.7071...
        System.out.println("cos(45°): " + Math.cos(radians));  // 0.7071...
        System.out.println("tan(45°): " + Math.tan(radians));  // 1.0
        System.out.println(Math.toDegrees(Math.PI));            // 180.0

        // --------------------------------------------------------
        // EXERCISE 11: Formatting doubles
        // --------------------------------------------------------
        double price = 1234.5678;
        System.out.println(String.format("%.2f", price));   // 1234.57
        System.out.println(String.format("%.4f", price));   // 1234.5678
        System.out.println(String.format("%10.2f", price)); // right-aligned in 10 chars
        System.out.println(String.format("%e", price));     // scientific notation: 1.234568e+03

        // --------------------------------------------------------
        // EXERCISE 12: parseDouble() and valueOf()
        // --------------------------------------------------------
        double parsed = Double.parseDouble("3.14");
        Double obj    = Double.valueOf("2.71");
        System.out.println(parsed);         // 3.14
        System.out.println(obj);            // 2.71
        System.out.println(obj.intValue()); // 2 (truncates)

        // --------------------------------------------------------
        // EXERCISE 13: Double.compare() (safe comparison)
        // --------------------------------------------------------
        System.out.println(Double.compare(3.14, 2.71)); // positive (3.14 > 2.71)
        System.out.println(Double.compare(1.0, 1.0));   // 0
        System.out.println(Double.compare(1.0, 2.0));   // negative

        // --------------------------------------------------------
        // EXERCISE 14: Scientific notation literals
        // --------------------------------------------------------
        double avogadro   = 6.022e23;   // 6.022 × 10^23
        double electron   = 9.109e-31;  // 9.109 × 10^-31
        System.out.println(avogadro);
        System.out.println(electron);

        // --------------------------------------------------------
        // EXERCISE 15: Hypotenuse (Pythagorean theorem)
        // --------------------------------------------------------
        double sideA = 3.0, sideB = 4.0;
        double hypotenuse = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
        System.out.println("Hypotenuse: " + hypotenuse); // 5.0

        // --------------------------------------------------------
        // EXERCISE 16: Circle area and circumference
        // --------------------------------------------------------
        double radius = 7.0;
        double area          = Math.PI * Math.pow(radius, 2);
        double circumference = 2 * Math.PI * radius;
        System.out.printf("Area:          %.4f%n", area);
        System.out.printf("Circumference: %.4f%n", circumference);

        // --------------------------------------------------------
        // EXERCISE 17: Compound interest formula
        // A = P * (1 + r/n)^(n*t)
        // --------------------------------------------------------
        double principal = 1000.0;
        double rate = 0.05;      // 5%
        int    times = 12;       // compounded monthly
        int    years = 3;
        double amount = principal * Math.pow(1 + rate / times, times * years);
        System.out.printf("Compound interest result: $%.2f%n", amount);

        // --------------------------------------------------------
        // EXERCISE 18: Celsius to Fahrenheit conversion
        // --------------------------------------------------------
        double[] celsius = {0, 20, 37, 100};
        for (double c : celsius) {
            double fahrenheit = c * 9.0 / 5.0 + 32;
            System.out.printf("%.1f°C = %.1f°F%n", c, fahrenheit);
        }

        // --------------------------------------------------------
        // SUMMARY
        // --------------------------------------------------------
        System.out.println("\n=== Double Quick Reference ===");
        double demo = -98.6;
        System.out.println("Value:    " + demo);
        System.out.println("Abs:      " + Math.abs(demo));
        System.out.println("Floor:    " + Math.floor(demo));
        System.out.println("Ceil:     " + Math.ceil(demo));
        System.out.println("Rounded:  " + Math.round(demo));
        System.out.println("isNaN:    " + Double.isNaN(demo));
        System.out.printf("Format:   %.2f%n", demo);
    }
}
