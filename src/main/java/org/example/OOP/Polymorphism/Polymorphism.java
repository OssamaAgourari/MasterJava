package org.example.OOP.Polymorphism;

import java.util.*;

/**
 * ============================================================
 *        JAVA POLYMORPHISM — COMPLETE GUIDE
 * ============================================================
 *
 * POLYMORPHISM: "many forms" — one interface, multiple behaviors.
 *
 * TWO TYPES:
 * ----------
 *   1. Compile-time (Static) — Method Overloading
 *      Same method name, different parameters.
 *      Resolved at COMPILE time.
 *
 *   2. Runtime (Dynamic) — Method Overriding
 *      Child overrides parent method.
 *      Resolved at RUNTIME via virtual dispatch.
 *
 * DYNAMIC DISPATCH (Runtime Polymorphism):
 * -----------------------------------------
 *   Animal a = new Dog();   // reference type = Animal
 *   a.speak();              // calls Dog.speak() — actual type wins
 *
 *   The JVM checks the actual object type, not the reference type.
 *
 * COVARIANT RETURN TYPES:
 * -----------------------
 *   Overriding method can return a more specific type.
 *   Animal → Dog (valid override return type)
 *
 * ============================================================
 */
public class Polymorphism {

    // ── 1. Compile-time polymorphism — Overloading ────────────
    static class Calculator {
        // Same name, different param types → overloaded
        int    add(int a, int b)          { return a + b; }
        double add(double a, double b)    { return a + b; }
        int    add(int a, int b, int c)   { return a + b + c; }
        String add(String a, String b)    { return a + b; }

        // Overloading with autoboxing — be careful!
        void print(int x)    { System.out.println("int: " + x); }
        void print(long x)   { System.out.println("long: " + x); }
        void print(Integer x){ System.out.println("Integer: " + x); }
    }

    // ── 2. Runtime polymorphism — Overriding ──────────────────
    static abstract class Shape {
        abstract double area();
        abstract double perimeter();

        void describe() {
            System.out.printf("%s: area=%.2f, perimeter=%.2f%n",
                getClass().getSimpleName(), area(), perimeter());
        }
    }

    static class Circle extends Shape {
        double r;
        Circle(double r) { this.r = r; }
        @Override double area()      { return Math.PI * r * r; }
        @Override double perimeter() { return 2 * Math.PI * r; }
    }

    static class Rectangle extends Shape {
        double w, h;
        Rectangle(double w, double h) { this.w = w; this.h = h; }
        @Override double area()      { return w * h; }
        @Override double perimeter() { return 2 * (w + h); }
    }

    static class Triangle extends Shape {
        double a, b, c;
        Triangle(double a, double b, double c) { this.a=a; this.b=b; this.c=c; }
        @Override double area() {
            double s = (a+b+c)/2;
            return Math.sqrt(s*(s-a)*(s-b)*(s-c));
        }
        @Override double perimeter() { return a + b + c; }
    }

    // ── 3. Polymorphic collections ────────────────────────────
    static double totalArea(List<Shape> shapes) {
        double total = 0;
        for (Shape s : shapes) total += s.area(); // each calls its own area()
        return total;
    }

    // ── 4. Polymorphism via interface ─────────────────────────
    interface Drawable {
        void draw();
        default String getType() { return "Drawable"; }
    }

    interface Resizable {
        void resize(double factor);
    }

    static class Canvas implements Drawable, Resizable {
        private double size;
        Canvas(double size) { this.size = size; }

        @Override public void draw()   { System.out.println("Drawing canvas size=" + size); }
        @Override public void resize(double f) { size *= f; }
        @Override public String getType() { return "Canvas"; }
    }

    // ── 5. Covariant return type ──────────────────────────────
    static class AnimalFactory {
        Animal create() { return new Animal("Generic"); }
    }

    static class DogFactory extends AnimalFactory {
        @Override
        Dog create() { return new Dog("Rex"); } // covariant — more specific return
    }

    static class Animal {
        String name;
        Animal(String name) { this.name = name; }
        String speak() { return "..."; }
    }

    static class Dog extends Animal {
        Dog(String name) { super(name); }
        @Override String speak() { return "Woof!"; }
        void fetch() { System.out.println(name + " fetches!"); }
    }

    // ── 6. Overloading vs Overriding ──────────────────────────
    static class Parent {
        String greet(String name) { return "Hello, " + name; }
    }
    static class Child extends Parent {
        @Override
        String greet(String name) { return "Hi there, " + name + "!"; } // override

        String greet(String firstName, String lastName) { // overload
            return greet(firstName + " " + lastName);
        }
    }

    public static void main(String[] args) {
        // 1. Overloading
        Calculator calc = new Calculator();
        System.out.println("add(2,3):     " + calc.add(2, 3));     // int: 5
        System.out.println("add(2.0,3.0): " + calc.add(2.0, 3.0));// double: 5.0
        System.out.println("add('a','b'): " + calc.add("a", "b")); // String: ab
        calc.print(42);  // int: 42 (int preferred over long/Integer for literal)

        // 2. Runtime polymorphism
        Shape[] shapes = {new Circle(5), new Rectangle(4,6), new Triangle(3,4,5)};
        for (Shape s : shapes) s.describe(); // calls overridden methods

        // 3. Polymorphic collection
        List<Shape> list = Arrays.asList(new Circle(3), new Rectangle(2,5));
        System.out.printf("Total area: %.2f%n", totalArea(list));

        // 4. Interface polymorphism
        Drawable d = new Canvas(100);
        d.draw();
        System.out.println("Type: " + d.getType()); // "Canvas" (not "Drawable")

        // 5. Covariant return
        AnimalFactory factory = new DogFactory();
        Animal a = factory.create();
        System.out.println(a.speak()); // Woof! — runtime dispatch
        // Can cast if you know the type:
        if (a instanceof Dog dog) dog.fetch();

        // 6. Overloading vs Overriding
        Parent p = new Child(); // reference is Parent, object is Child
        System.out.println(p.greet("Alice"));       // "Hi there, Alice!" — override
        Child ch = new Child();
        System.out.println(ch.greet("Bob","Smith")); // overload

        System.out.println("\n=== Polymorphism Summary ===");
        System.out.println("Overloading: same name, different params → compile-time");
        System.out.println("Overriding:  child replaces parent method → runtime");
        System.out.println("Dynamic dispatch: actual object type determines method");
        System.out.println("Key: reference type for compile check, object type for runtime");
    }
}
