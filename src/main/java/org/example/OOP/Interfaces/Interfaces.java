package org.example.OOP.Interfaces;

import java.util.*;

/**
 * ============================================================
 *          JAVA INTERFACES — COMPLETE GUIDE
 * ============================================================
 *
 * INTERFACE: A pure contract — defines WHAT, not HOW.
 * All methods are implicitly public abstract (pre-Java 8).
 *
 * INTERFACE EVOLUTION:
 * --------------------
 *   Java 7:  abstract methods, constants
 *   Java 8:  default methods (with body), static methods
 *   Java 9:  private methods (code sharing within interface)
 *   Java 14: sealed interfaces (preview)
 *
 * KEY RULES:
 * ----------
 *   - Cannot be instantiated directly
 *   - No constructors, no instance fields
 *   - Can have: constants (public static final), abstract methods,
 *               default methods, static methods, private methods (J9+)
 *   - A class implements multiple interfaces (solves diamond problem)
 *   - An interface can extend multiple interfaces
 *
 * FUNCTIONAL INTERFACE:
 * ---------------------
 *   Exactly ONE abstract method → usable as lambda target
 *   @FunctionalInterface annotation (optional but recommended)
 *
 * INTERFACE vs ABSTRACT CLASS:
 * ----------------------------
 *   Interface     → capability/contract, no state, multiple allowed
 *   Abstract class→ partial implementation, has state, single parent
 *
 * ============================================================
 */
public class Interfaces {

    // ── 1. Basic interface ────────────────────────────────────
    interface Flyable {
        int MAX_ALTITUDE = 10000; // implicitly public static final

        void fly();
        void land();

        default String getStatus() { return "In the sky"; } // default method
        static String description() { return "Can fly"; }   // static method
    }

    interface Swimmable {
        void swim();
        default String getStatus() { return "In the water"; }
    }

    // ── 2. Implementing multiple interfaces ───────────────────
    static class Duck implements Flyable, Swimmable {
        private String name;
        Duck(String name) { this.name = name; }

        @Override public void fly()  { System.out.println(name + " is flying!"); }
        @Override public void land() { System.out.println(name + " landed."); }
        @Override public void swim() { System.out.println(name + " is swimming!"); }

        // Must override conflicting default method
        @Override public String getStatus() { return name + ": " + Flyable.super.getStatus(); }
    }

    // ── 3. Interface extending interfaces ─────────────────────
    interface Printable {
        void print();
    }

    interface Exportable extends Printable {
        void export(String format);
        default void exportPDF() { export("PDF"); }
        default void exportCSV() { export("CSV"); }
    }

    static class Report implements Exportable {
        private String title;
        Report(String title) { this.title = title; }

        @Override public void print()               { System.out.println("Printing: " + title); }
        @Override public void export(String format) { System.out.println("Exporting " + title + " as " + format); }
    }

    // ── 4. Functional interfaces ─────────────────────────────
    @FunctionalInterface
    interface Transformer<T> {
        T transform(T input);
        // default methods don't count toward the 1 abstract limit
        default Transformer<T> andThen(Transformer<T> after) {
            return x -> after.transform(this.transform(x));
        }
    }

    // ── 5. Interface with constants ───────────────────────────
    interface HttpStatus {
        int OK          = 200;
        int CREATED     = 201;
        int BAD_REQUEST = 400;
        int NOT_FOUND   = 404;
        int SERVER_ERROR= 500;

        static String getMessage(int code) {
            return switch (code) {
                case 200 -> "OK";
                case 201 -> "Created";
                case 400 -> "Bad Request";
                case 404 -> "Not Found";
                case 500 -> "Internal Server Error";
                default  -> "Unknown";
            };
        }
    }

    // ── 6. Comparator (interface in Java standard library) ────
    static class Student {
        String name;
        double gpa;
        int age;

        Student(String name, double gpa, int age) {
            this.name = name; this.gpa = gpa; this.age = age;
        }

        @Override public String toString() {
            return String.format("%s(gpa=%.1f,age=%d)", name, gpa, age);
        }
    }

    // ── 7. Marker interface (no methods) ─────────────────────
    interface Serializable { } // marks class as serializable

    static class Config implements Serializable {
        String host = "localhost";
        int port = 8080;
    }

    // ── 8. Interface with private helper ─────────────────────
    interface Validator<T> {
        boolean isValid(T value);

        default boolean isInvalid(T value) {
            return !isValid(value); // uses the abstract method
        }

        default void validate(T value) {
            if (isInvalid(value))
                throw new IllegalArgumentException("Invalid: " + value);
        }
    }

    public static void main(String[] args) {
        // 1. Basic interface
        System.out.println(Flyable.description()); // "Can fly"
        System.out.println("MAX_ALTITUDE: " + Flyable.MAX_ALTITUDE);

        // 2. Multiple interface implementation
        Duck duck = new Duck("Donald");
        duck.fly();
        duck.swim();
        duck.land();
        System.out.println(duck.getStatus());

        // 3. Interface extending interface
        Report report = new Report("Annual Sales");
        report.print();
        report.exportPDF();
        report.exportCSV();

        // 4. Functional interface with lambda
        Transformer<String> upper = s -> s.toUpperCase();
        Transformer<String> exclaim = s -> s + "!";
        Transformer<String> shout = upper.andThen(exclaim);
        System.out.println(shout.transform("hello")); // HELLO!

        // 5. Interface constants
        System.out.println(HttpStatus.getMessage(HttpStatus.NOT_FOUND)); // Not Found

        // 6. Comparator interface
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 3.9, 20));
        students.add(new Student("Bob",   3.5, 22));
        students.add(new Student("Carol", 3.9, 19));

        // Sort by GPA desc, then name asc
        students.sort(Comparator.comparingDouble((Student s) -> s.gpa)
                                .reversed()
                                .thenComparing(s -> s.name));
        // Simpler way:
        students.sort((a, b) -> {
            if (b.gpa != a.gpa) return Double.compare(b.gpa, a.gpa);
            return a.name.compareTo(b.name);
        });
        System.out.println("Sorted students: " + students);

        // 7. Marker interface
        Config cfg = new Config();
        System.out.println("Is Serializable: " + (cfg instanceof Serializable));

        // 8. Validator lambda
        Validator<Integer> positive = n -> n > 0;
        System.out.println("5 valid: " + positive.isValid(5));   // true
        System.out.println("-1 valid: " + positive.isValid(-1)); // false

        System.out.println("\n=== Interface Quick Reference ===");
        System.out.println("interface  → contract, no state");
        System.out.println("implements → a class can implement multiple");
        System.out.println("default    → concrete method in interface (Java 8+)");
        System.out.println("static     → utility method on interface (Java 8+)");
        System.out.println ("@FunctionalInterface → one abstract method, usable as lambda");
        System.out.println("Prefer interfaces for API design — decouples code");
    }
}
