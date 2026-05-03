package org.example.OOP.Polymorphism;

import java.util.*;

/**
 * ============================================================
 *      POLYMORPHISM CHALLENGES — LeetCode Style
 * ============================================================
 */
public class PolymorphismChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Design Animal Sound System
    // Create Animal, Dog, Cat, Bird hierarchy.
    // makeSound() returns "Woof", "Meow", "Tweet" respectively.
    // =========================================================
    static abstract class Animal { abstract String makeSound(); }
    static class Dog extends Animal { @Override String makeSound() { return ""; /* TODO */ } }
    static class Cat extends Animal { @Override String makeSound() { return ""; /* TODO */ } }
    static class Bird extends Animal { @Override String makeSound() { return ""; /* TODO */ } }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Shape Area Calculator
    // Polymorphically compute area for Circle, Square, Triangle.
    // =========================================================
    static abstract class Shape { abstract double area(); }
    static class CircleShape extends Shape {
        double r;
        CircleShape(double r) { this.r = r; }
        @Override double area() { return 0; /* TODO: PI*r*r */ }
    }
    static class SquareShape extends Shape {
        double side;
        SquareShape(double s) { this.side = s; }
        @Override double area() { return 0; /* TODO: side*side */ }
    }

    // =========================================================
    // CHALLENGE 3  [MEDIUM]  — Employee Payroll System
    // Full-time: base + bonus(10%), Part-time: hourly*hours,
    // Contractor: dailyRate*days. Return totalPay() for each.
    // =========================================================
    static abstract class Employee {
        String name;
        Employee(String name) { this.name = name; }
        abstract double totalPay();
    }
    static class FullTime extends Employee {
        double base;
        FullTime(String n, double base) { super(n); this.base = base; }
        @Override double totalPay() { return 0; /* TODO: base + 10% */ }
    }
    static class PartTime extends Employee {
        double hourlyRate; int hours;
        PartTime(String n, double rate, int hours) { super(n); hourlyRate=rate; this.hours=hours; }
        @Override double totalPay() { return 0; /* TODO: rate*hours */ }
    }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Sort by Custom Comparator (overloading)
    // Implement 3 overloaded sort methods:
    // sort(int[]), sort(String[]), sort(int[], Comparator<Integer>)
    // =========================================================
    static void sort(int[] arr) { /* TODO: bubble sort */ }
    static void sort(String[] arr) { /* TODO: lexicographic bubble sort */ }
    static void sort(Integer[] arr, Comparator<Integer> cmp) { /* TODO */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Plugin System
    // Interface Plugin with execute(String input) → String.
    // Implement: UpperCasePlugin, ReversePlugin, TrimPlugin.
    // Chain them together.
    // =========================================================
    interface Plugin { String execute(String input); }

    static class UpperCasePlugin implements Plugin {
        @Override public String execute(String input) { return ""; /* TODO */ }
    }
    static class ReversePlugin implements Plugin {
        @Override public String execute(String input) { return ""; /* TODO */ }
    }
    static class TrimPlugin implements Plugin {
        @Override public String execute(String input) { return ""; /* TODO */ }
    }

    static String applyPlugins(String input, List<Plugin> plugins) {
        String result = input;
        for (Plugin p : plugins) result = p.execute(result);
        return result;
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Command Pattern
    // Implement undo-able commands: AddCommand, SubtractCommand.
    // =========================================================
    interface Command { void execute(); void undo(); }

    static class Calculator {
        int value = 0;
        Deque<Command> history = new ArrayDeque<>();

        void execute(Command cmd) { cmd.execute(); history.push(cmd); }
        void undo() { if (!history.isEmpty()) history.pop().undo(); }
        int getValue() { return value; }
    }

    // TODO: implement AddCommand and SubtractCommand

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Observer Pattern
    // EventBus with subscribe(event, listener) and publish(event, data).
    // =========================================================
    interface EventListener { void onEvent(String data); }

    static class EventBus {
        private Map<String, List<EventListener>> listeners = new HashMap<>();

        void subscribe(String event, EventListener l) { /* TODO */ }
        void publish(String event, String data) { /* TODO: notify all listeners */ }
    }

    // =========================================================
    // CHALLENGE 8  [HARD]  — Expression Tree Evaluation
    // Build and evaluate an expression tree using polymorphism.
    // =========================================================
    static abstract class Expr {
        abstract int eval();
    }
    static class Num extends Expr {
        int val;
        Num(int val) { this.val = val; }
        @Override int eval() { return val; }
    }
    static class Add extends Expr {
        Expr left, right;
        Add(Expr l, Expr r) { left=l; right=r; }
        @Override int eval() { return 0; /* TODO */ }
    }
    static class Mul extends Expr {
        Expr left, right;
        Mul(Expr l, Expr r) { left=l; right=r; }
        @Override int eval() { return 0; /* TODO */ }
    }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Strategy Pattern — Sort Strategy
    // Context uses different sort strategies polymorphically.
    // =========================================================
    interface SortStrategy { void sort(int[] arr); }

    static class Sorter {
        private SortStrategy strategy;
        Sorter(SortStrategy s) { this.strategy = s; }
        void setStrategy(SortStrategy s) { this.strategy = s; }
        void sort(int[] arr) { strategy.sort(arr); }
    }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Visitor Pattern
    // Implement visitor that computes area/perimeter for different shapes.
    // =========================================================
    interface ShapeVisitor { double visitCircle(CircleShape c); double visitSquare(SquareShape s); }
    // TODO: add accept(ShapeVisitor) to shapes and implement AreaVisitor

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // C1
        Animal[] animals = {new Dog(), new Cat(), new Bird()};
        pass += check("C1a", animals[0].makeSound(), "Woof")  ? 1:0; fail += check("C1a", animals[0].makeSound(), "Woof")  ? 0:1;
        pass += check("C1b", animals[1].makeSound(), "Meow")  ? 1:0; fail += check("C1b", animals[1].makeSound(), "Meow")  ? 0:1;
        pass += check("C1c", animals[2].makeSound(), "Tweet") ? 1:0; fail += check("C1c", animals[2].makeSound(), "Tweet") ? 0:1;

        // C2
        pass += check("C2a", String.format("%.2f", new CircleShape(5).area()), "78.54") ? 1:0;
        fail += check("C2a", String.format("%.2f", new CircleShape(5).area()), "78.54") ? 0:1;
        pass += check("C2b", String.format("%.2f", new SquareShape(4).area()), "16.00") ? 1:0;
        fail += check("C2b", String.format("%.2f", new SquareShape(4).area()), "16.00") ? 0:1;

        // C3
        pass += check("C3a", String.format("%.1f", new FullTime("A",50000).totalPay()), "55000.0") ? 1:0;
        fail += check("C3a", String.format("%.1f", new FullTime("A",50000).totalPay()), "55000.0") ? 0:1;
        pass += check("C3b", String.format("%.1f", new PartTime("B",20,40).totalPay()), "800.0") ? 1:0;
        fail += check("C3b", String.format("%.1f", new PartTime("B",20,40).totalPay()), "800.0") ? 0:1;

        // C5: Plugin chain
        List<Plugin> plugins = Arrays.asList(new TrimPlugin(), new UpperCasePlugin(), new ReversePlugin());
        pass += check("C5a", applyPlugins("  hello  ", plugins), "OLLEH") ? 1:0;
        fail += check("C5a", applyPlugins("  hello  ", plugins), "OLLEH") ? 0:1;

        // C8: Expression tree
        // (3 + 4) * 2 = 14
        Expr expr = new Mul(new Add(new Num(3), new Num(4)), new Num(2));
        pass += check("C8a", expr.eval(), 14) ? 1:0;
        fail += check("C8a", expr.eval(), 14) ? 0:1;

        // Sorting overloads
        int[] arr = {3,1,4,1,5};
        sort(arr);
        pass += check("C4a", Arrays.toString(arr), "[1, 1, 3, 4, 5]") ? 1:0;
        fail += check("C4a", Arrays.toString(arr), "[1, 1, 3, 4, 5]") ? 0:1;

        System.out.println("\n==============================");
        System.out.println("  RESULTS: " + pass + " passed, " + fail + " failed");
        System.out.println("==============================");
    }

    private static boolean check(String n, Object got, Object exp) {
        boolean ok = String.valueOf(got).equals(String.valueOf(exp));
        System.out.printf("%-6s %s  (exp:%s | got:%s)%n", n, ok?"✔":"✘", exp, got);
        return ok;
    }
}
