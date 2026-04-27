package org.example.Generics.Wildcards;

import java.util.*;

/**
 * ============================================================
 *          JAVA WILDCARDS — COMPLETE GUIDE
 * ============================================================
 *
 * WILDCARDS: The ? in generics. Represent an UNKNOWN type.
 *
 * THREE FORMS:
 * ------------
 *   <?>           Unbounded      — any type, read-only (only Object methods)
 *   <? extends T> Upper bounded  — T or subtype, read-only (producer)
 *   <? super T>   Lower bounded  — T or supertype, write-only (consumer)
 *
 * PECS PRINCIPLE: "Producer Extends, Consumer Super"
 * --------------------------------------------------
 *   If you READ (produce) from a structure → use extends
 *   If you WRITE (consume) into a structure → use super
 *   If you do both → no wildcard, use exact type T
 *
 * WHY WILDCARDS?
 * --------------
 *   List<Dog> is NOT a subtype of List<Animal>.
 *   List<? extends Animal> IS a supertype of List<Dog>.
 *
 *   void feed(List<Animal> animals)   → accepts ONLY List<Animal>
 *   void feed(List<? extends Animal>) → accepts List<Dog>, List<Cat>, etc.
 *
 * ============================================================
 */
public class Wildcards {

    static abstract class Shape { abstract double area(); }
    static class Circle    extends Shape { double r; Circle(double r){this.r=r;} @Override double area(){return Math.PI*r*r;} @Override public String toString(){return "Circle("+r+")";} }
    static class Rectangle extends Shape { double w,h; Rectangle(double w,double h){this.w=w;this.h=h;} @Override double area(){return w*h;} @Override public String toString(){return "Rect("+w+"x"+h+")";} }
    static class Square    extends Rectangle { Square(double s){super(s,s);} @Override public String toString(){return "Square("+w+")";} }

    // ── 1. Upper bounded wildcard (extends) — READ ────────────
    // Can read as Shape, cannot add anything except null
    static double totalArea(List<? extends Shape> shapes) {
        double total = 0;
        for (Shape s : shapes) total += s.area();
        return total;
    }

    static Shape largestShape(List<? extends Shape> shapes) {
        return shapes.stream().max(Comparator.comparingDouble(Shape::area)).orElse(null);
    }

    // ── 2. Lower bounded wildcard (super) — WRITE ────────────
    // Can add Shape and subtypes, read only as Object
    static void addShapes(List<? super Circle> list) {
        list.add(new Circle(1.0));  // OK — Circle IS-A Circle
        list.add(new Circle(2.0));
        // list.add(new Rectangle(1,1)); // NOT OK — Rectangle is not Circle
    }

    static <T> void copy(List<? extends T> src, List<? super T> dest) {
        for (T item : src) dest.add(item);
    }

    // ── 3. Unbounded wildcard — just Object methods ───────────
    static int listSize(List<?> list) {
        return list.size(); // can use Object methods and size
    }

    static void printAll(List<?> list) {
        for (Object o : list) System.out.print(o + " ");
        System.out.println();
    }

    // ── 4. Wildcard with Comparable ───────────────────────────
    // <T extends Comparable<? super T>> handles case where compareTo is in a parent
    static <T extends Comparable<? super T>> T findMax(List<T> list) {
        T max = list.get(0);
        for (T item : list) if (item.compareTo(max) > 0) max = item;
        return max;
    }

    // ── 5. PECS in practice ───────────────────────────────────
    static <T> void transfer(
            List<? extends T> source,  // extends = producer (we read from it)
            List<? super T> destination // super = consumer (we write to it)
    ) {
        for (T item : source) destination.add(item);
    }

    // ── 6. Why List<Dog> is NOT a List<Animal> ────────────────
    static class Animal { String name; Animal(String n){name=n;} }
    static class Dog extends Animal {
        Dog(String n) { super(n); }
        void bark() { System.out.println(name + ": Woof!"); }
        @Override public String toString() { return "Dog(" + name + ")"; }
    }
    static class Cat extends Animal {
        Cat(String n) { super(n); }
        @Override public String toString() { return "Cat(" + name + ")"; }
    }

    static void feedAnimals(List<? extends Animal> animals) {
        System.out.print("Feeding: ");
        for (Animal a : animals) System.out.print(a.name + " ");
        System.out.println();
        // animals.add(new Cat("Felix")); // CANNOT ADD — type unknown
    }

    // ── 7. Multiple bounds ────────────────────────────────────
    static <T extends Comparable<T> & Cloneable> T clampedMax(List<T> list, T min, T max) {
        T result = list.get(0);
        for (T t : list) {
            if (t.compareTo(result) > 0) result = t;
        }
        if (result.compareTo(min) < 0) return min;
        if (result.compareTo(max) > 0) return max;
        return result;
    }

    public static void main(String[] args) {
        // 1. Upper bounded — read shapes
        List<Circle> circles = Arrays.asList(new Circle(3), new Circle(5), new Circle(2));
        List<Square> squares = Arrays.asList(new Square(4), new Square(6));

        System.out.printf("Total circle area: %.2f%n", totalArea(circles));
        System.out.printf("Total square area: %.2f%n", totalArea(squares));
        System.out.println("Largest circle: " + largestShape(circles));

        // 2. Lower bounded — write circles
        List<Shape> shapes = new ArrayList<>();
        addShapes(shapes); // adds Circle objects to List<Shape>
        System.out.println("Shapes after addShapes: " + shapes);

        List<Object> objects = new ArrayList<>();
        addShapes(objects); // also works — Object is a super of Circle
        System.out.println("Objects: " + objects.size() + " circles");

        // 3. Unbounded
        System.out.println("Size of circles: " + listSize(circles));
        printAll(circles);

        // 4. Copy with wildcards (PECS)
        List<Circle> src  = Arrays.asList(new Circle(1), new Circle(2));
        List<Shape> dest  = new ArrayList<>();
        copy(src, dest);
        System.out.println("Copied: " + dest);

        // 5. Transfer
        List<Dog> dogs = Arrays.asList(new Dog("Rex"), new Dog("Buddy"));
        List<Animal> animals = new ArrayList<>();
        transfer(dogs, animals); // dogs = producer (extends), animals = consumer (super)
        System.out.println("Animals: " + animals);

        // 6. Why invariance matters
        List<Dog> dogList = Arrays.asList(new Dog("Fido"), new Dog("Max"));
        List<Cat> catList = Arrays.asList(new Cat("Whiskers"), new Cat("Luna"));
        feedAnimals(dogList); // OK with ? extends Animal
        feedAnimals(catList); // OK with ? extends Animal

        // 7. findMax
        System.out.println("Max of [3,1,4,1,5,9,2]: " + findMax(Arrays.asList(3,1,4,1,5,9,2)));

        System.out.println("\n=== Wildcard Quick Reference ===");
        System.out.println("<?>              unbounded — any type, Object methods only");
        System.out.println("<? extends T>    upper bound — READ (producer)");
        System.out.println("<? super T>      lower bound — WRITE (consumer)");
        System.out.println("PECS: Producer Extends, Consumer Super");
        System.out.println("List<Dog> NOT subtype of List<Animal> — use List<? extends Animal>");
    }
}
