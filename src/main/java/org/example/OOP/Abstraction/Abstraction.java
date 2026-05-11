package org.example.OOP.Abstraction;

import java.util.*;

/**
 * ============================================================
 *         JAVA ABSTRACTION — COMPLETE GUIDE
 * ============================================================
 *
 * ABSTRACTION: Hide implementation details, expose only what
 * is necessary. Focus on WHAT, not HOW.
 *
 * TWO MECHANISMS:
 * ---------------
 *   1. Abstract Classes  — partial abstraction
 *   2. Interfaces        — full abstraction (contract)
 *
 * ABSTRACT CLASS:
 * ---------------
 *   - Declared with 'abstract' keyword
 *   - Cannot be instantiated directly
 *   - Can have abstract AND concrete methods
 *   - Can have constructors, fields, static members
 *   - Subclass MUST implement all abstract methods (or be abstract)
 *
 * WHEN TO USE ABSTRACT CLASS vs INTERFACE:
 * -----------------------------------------
 *   Abstract class → shared state/code + is-a relationship
 *   Interface      → contract/capability, multiple implementations
 *
 *   "Prefer composition over inheritance"
 *   "Program to an interface, not an implementation"
 *
 * ============================================================
 */
public class Abstraction {

    // ── 1. Abstract class — Game template method pattern ──────
    static abstract class Game {
        // Template method — defines algorithm skeleton
        final void play() {
            initialize();
            while (!isDone()) {
                makeMove();
            }
            printResult();
        }

        abstract void initialize();
        abstract boolean isDone();
        abstract void makeMove();
        abstract void printResult();
    }

    static class NumberGuessGame extends Game {
        private int secret = 7;
        private int guess  = -1;
        private int tries  = 0;

        @Override void initialize() { System.out.println("Guess a number 1-10"); }
        @Override boolean isDone()  { return guess == secret; }
        @Override void makeMove() {
            guess = ++tries * 3; // simulate guesses: 3,6,9...
            System.out.println("  Trying: " + guess + (guess == secret ? " ✔" : " ✘"));
        }
        @Override void printResult() { System.out.println("Found in " + tries + " tries!"); }
    }

    // ── 2. Abstract class with shared state ───────────────────
    static abstract class Employee {
        protected String name;
        protected double baseSalary;

        Employee(String name, double baseSalary) {
            this.name = name;
            this.baseSalary = baseSalary;
        }

        abstract double calculateBonus();

        double totalPay() { return baseSalary + calculateBonus(); }

        @Override
        public String toString() {
            return String.format("%s[%s, base=%.0f, bonus=%.0f, total=%.0f]",
                getClass().getSimpleName(), name, baseSalary, calculateBonus(), totalPay());
        }
    }

    static class SalesEmployee extends Employee {
        private double salesAmount;
        SalesEmployee(String name, double base, double sales) {
            super(name, base);
            this.salesAmount = sales;
        }
        @Override double calculateBonus() { return salesAmount * 0.05; } // 5% commission
    }

    static class Manager extends Employee {
        private int teamSize;
        Manager(String name, double base, int teamSize) {
            super(name, base);
            this.teamSize = teamSize;
        }
        @Override double calculateBonus() { return baseSalary * 0.2 + teamSize * 500; }
    }

    static class Contractor extends Employee {
        Contractor(String name, double rate) { super(name, rate); }
        @Override double calculateBonus() { return 0; } // no bonus
    }

    // ── 3. Abstract + interface combination ───────────────────
    interface Sortable {
        int compareTo(Object other);
    }

    interface Printable {
        void print();
    }

    static abstract class DataItem implements Sortable, Printable {
        protected String id;
        DataItem(String id) { this.id = id; }
        abstract double getValue();
    }

    static class Product extends DataItem {
        private String name;
        private double price;

        Product(String id, String name, double price) {
            super(id);
            this.name = name;
            this.price = price;
        }

        @Override public double getValue() { return price; }

        @Override
        public int compareTo(Object other) {
            if (other instanceof Product p)
                return Double.compare(price, p.price);
            return 0;
        }

        @Override
        public void print() {
            System.out.printf("Product[%s]: %s = $%.2f%n", id, name, price);
        }
    }

    // ── 4. Abstract class preventing instantiation ────────────
    static abstract class MathHelper {
        // All static — no instances needed, but abstract prevents direct new
        static int factorial(int n) {
            if (n <= 1) return 1;
            return n * factorial(n - 1);
        }

        static double power(double base, int exp) {
            if (exp == 0) return 1;
            double half = power(base, exp / 2);
            return exp % 2 == 0 ? half*half : base*half*half;
        }
    }

    public static void main(String[] args) {
        // 1. Template method
        Game game = new NumberGuessGame();
        game.play();

        // 2. Polymorphic employees
        Employee[] employees = {
            new SalesEmployee("Alice", 40000, 100000),
            new Manager("Bob", 60000, 8),
            new Contractor("Carol", 50000)
        };
        System.out.println("\nPayroll:");
        double totalPayroll = 0;
        for (Employee e : employees) {
            System.out.println("  " + e);
            totalPayroll += e.totalPay();
        }
        System.out.printf("Total payroll: %.0f%n", totalPayroll);

        // 3. Interface + abstract
        Product[] products = {
            new Product("P1", "Laptop", 999.99),
            new Product("P2", "Phone", 699.99),
            new Product("P3", "Tablet", 449.99)
        };
        System.out.println("\nProducts:");
        for (Product p : products) p.print();
        // Sort by price
        Arrays.sort(products, (a,b) -> a.compareTo(b));
        System.out.println("Cheapest: ");
        products[0].print();

        // 4. Static utility via abstract
        System.out.println("\n5! = " + MathHelper.factorial(5));    // 120
        System.out.printf("2^10 = %.0f%n", MathHelper.power(2, 10)); // 1024

        System.out.println("\n=== Abstraction Summary ===");
        System.out.println("Abstract class → partial impl, can have state/constructors");
        System.out.println("Interface      → pure contract, multiple implementations");
        System.out.println("abstract method→ subclass MUST implement");
        System.out.println("Template method→ define algorithm in parent, steps in child");
        System.out.println("Cannot: new AbstractClass() — must use concrete subclass");
    }
}
