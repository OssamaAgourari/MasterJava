package org.example.OOP.Enums;

import java.util.*;

/**
 * ============================================================
 *            JAVA ENUMS — COMPLETE GUIDE
 * ============================================================
 *
 * ENUM: A special class with a fixed set of named constants.
 * Much more powerful than C-style enums.
 *
 * KEY FEATURES:
 * -------------
 *   - Type-safe (no invalid values)
 *   - Can have fields, constructors, methods
 *   - Can implement interfaces
 *   - Cannot extend other classes (implicitly extends Enum)
 *   - Singleton instances per JVM
 *
 * BUILT-IN METHODS:
 * -----------------
 *   .name()        → "CONSTANT_NAME" (String)
 *   .ordinal()     → 0-based position
 *   .toString()    → same as name() by default
 *   Enum.valueOf() → get enum by name
 *   Enum.values()  → array of all constants
 *
 * ENUM IN SWITCH:
 * ---------------
 *   Perfect for switch statements — exhaustive check in Java 21+
 *
 * EnumSet / EnumMap:
 * ------------------
 *   EnumSet  → bit vector implementation, very fast
 *   EnumMap  → array-backed, very fast
 *
 * ============================================================
 */
public class Enums {

    // ── 1. Basic enum ─────────────────────────────────────────
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

        boolean isWeekend() {
            return this == SATURDAY || this == SUNDAY;
        }

        Day next() {
            Day[] days = values();
            return days[(ordinal() + 1) % days.length];
        }
    }

    // ── 2. Enum with fields and constructor ───────────────────
    enum Planet {
        MERCURY(3.303e+23, 2.4397e6),
        VENUS  (4.869e+24, 6.0518e6),
        EARTH  (5.976e+24, 6.37814e6),
        MARS   (6.421e+23, 3.3972e6);

        private final double mass;    // kg
        private final double radius;  // meters
        static final double G = 6.67300E-11;

        Planet(double mass, double radius) {
            this.mass   = mass;
            this.radius = radius;
        }

        double surfaceGravity() {
            return G * mass / (radius * radius);
        }

        double surfaceWeight(double otherMass) {
            return otherMass * surfaceGravity();
        }
    }

    // ── 3. Enum with abstract method ──────────────────────────
    enum Operation {
        PLUS("+") {
            @Override double apply(double x, double y) { return x + y; }
        },
        MINUS("-") {
            @Override double apply(double x, double y) { return x - y; }
        },
        TIMES("*") {
            @Override double apply(double x, double y) { return x * y; }
        },
        DIVIDE("/") {
            @Override double apply(double x, double y) { return x / y; }
        };

        private final String symbol;
        Operation(String symbol) { this.symbol = symbol; }
        abstract double apply(double x, double y);

        @Override
        public String toString() { return symbol; }
    }

    // ── 4. Enum implementing interface ────────────────────────
    interface Describable { String describe(); }

    enum Season implements Describable {
        SPRING { @Override public String describe() { return "Warm and rainy"; } },
        SUMMER { @Override public String describe() { return "Hot and sunny"; } },
        AUTUMN { @Override public String describe() { return "Cool and windy"; } },
        WINTER { @Override public String describe() { return "Cold and snowy"; } };

        Season previous() {
            Season[] s = values();
            return s[(ordinal() + s.length - 1) % s.length];
        }
        Season next() {
            Season[] s = values();
            return s[(ordinal() + 1) % s.length];
        }
    }

    // ── 5. Enum with lookup map ────────────────────────────────
    enum HttpMethod {
        GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS;

        private static final Map<String, HttpMethod> LOOKUP = new HashMap<>();
        static {
            for (HttpMethod m : values()) LOOKUP.put(m.name(), m);
        }

        static HttpMethod of(String name) {
            HttpMethod m = LOOKUP.get(name.toUpperCase());
            if (m == null) throw new IllegalArgumentException("Unknown method: " + name);
            return m;
        }

        boolean isIdempotent() {
            return this == GET || this == PUT || this == DELETE || this == HEAD;
        }
    }

    // ── 6. State machine with enum ────────────────────────────
    enum TrafficLight {
        RED {
            @Override TrafficLight next() { return GREEN; }
            @Override String action()     { return "STOP"; }
        },
        YELLOW {
            @Override TrafficLight next() { return RED; }
            @Override String action()     { return "SLOW DOWN"; }
        },
        GREEN {
            @Override TrafficLight next() { return YELLOW; }
            @Override String action()     { return "GO"; }
        };

        abstract TrafficLight next();
        abstract String action();
    }

    public static void main(String[] args) {
        // 1. Basic enum
        System.out.println("Day.MONDAY.name():    " + Day.MONDAY.name());
        System.out.println("Day.MONDAY.ordinal(): " + Day.MONDAY.ordinal());
        System.out.println("SATURDAY weekend: " + Day.SATURDAY.isWeekend()); // true
        System.out.println("MONDAY.next(): " + Day.MONDAY.next()); // TUESDAY

        for (Day d : Day.values())
            System.out.print(d.isWeekend() ? d + "(W) " : d + " ");
        System.out.println();

        // 2. Planet weights
        double earthWeight = 75.0;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values())
            System.out.printf("Weight on %s: %.2f N%n", p, p.surfaceWeight(mass));

        // 3. Enum with abstract methods
        double x = 6, y = 2;
        for (Operation op : Operation.values())
            System.out.printf("%.0f %s %.0f = %.1f%n", x, op, y, op.apply(x, y));

        // 4. Season with interface
        System.out.println("\nSeasons:");
        for (Season s : Season.values())
            System.out.println("  " + s + ": " + s.describe() + " | next: " + s.next());

        // 5. HttpMethod lookup
        HttpMethod m = HttpMethod.of("get");
        System.out.println("\nGET idempotent: " + m.isIdempotent()); // true
        System.out.println("POST idempotent: " + HttpMethod.POST.isIdempotent()); // false

        // 6. Traffic light state machine
        System.out.println("\nTraffic light sequence:");
        TrafficLight light = TrafficLight.RED;
        for (int i = 0; i < 6; i++) {
            System.out.println("  " + light + " → " + light.action());
            light = light.next();
        }

        // 7. Enum in switch
        Day today = Day.WEDNESDAY;
        String plan = switch (today) {
            case MONDAY    -> "Start the week strong";
            case WEDNESDAY -> "Hump day!";
            case FRIDAY    -> "TGIF!";
            case SATURDAY, SUNDAY -> "Rest";
            default        -> "Regular workday";
        };
        System.out.println("\n" + today + ": " + plan);

        // 8. valueOf
        Day friday = Day.valueOf("FRIDAY");
        System.out.println("valueOf FRIDAY: " + friday);

        System.out.println("\n=== Enum Quick Reference ===");
        System.out.println("enum E { A,B,C }         → basic enum");
        System.out.println("enum E { A(x) { method }}→ enum with body");
        System.out.println("E.values()               → array of all constants");
        System.out.println("E.valueOf(\"A\")          → E.A");
        System.out.println("e.ordinal()              → 0-based index");
        System.out.println("e.name()                 → \"A\"");
        System.out.println("EnumSet/EnumMap          → fast enum collections");
    }
}
