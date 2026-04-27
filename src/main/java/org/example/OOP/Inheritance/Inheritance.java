package org.example.OOP.Inheritance;

/**
 * ============================================================
 *          JAVA INHERITANCE — COMPLETE GUIDE
 * ============================================================
 *
 * INHERITANCE: A class (child/subclass) inherits fields and
 * methods from another class (parent/superclass).
 *
 *   class Child extends Parent { ... }
 *
 * KEY KEYWORDS:
 * -------------
 *   extends    → inherit from one parent (single inheritance)
 *   super      → reference to parent class
 *   super()    → call parent constructor
 *   super.m()  → call parent method
 *   @Override  → annotation to override parent method
 *   final      → prevent overriding / extending
 *   abstract   → cannot be instantiated directly
 *
 * WHAT IS INHERITED:
 * ------------------
 *   public/protected fields and methods
 *   NOT: private fields, constructors, static members
 *
 * IS-A vs HAS-A:
 * --------------
 *   Inheritance = IS-A (Dog IS-A Animal)
 *   Composition = HAS-A (Car HAS-A Engine) — often preferred
 *
 * JAVA SINGLE INHERITANCE:
 * ------------------------
 *   Java only allows ONE parent class (no multiple inheritance)
 *   But can implement MULTIPLE interfaces
 *
 * METHOD RESOLUTION ORDER (MRO):
 * --------------------------------
 *   1. Check the actual class type
 *   2. Check parent, grandparent, ... up to Object
 *
 * ============================================================
 */
public class Inheritance {

    // ── 1. Base class ────────────────────────────────────────
    static abstract class Animal {
        protected String name;
        protected int age;

        Animal(String name, int age) {
            this.name = name;
            this.age  = age;
        }

        // Can be overridden
        String speak() { return "..."; }

        // Final — cannot be overridden
        final String describe() {
            return name + " (age " + age + ") says: " + speak();
        }

        // Abstract — MUST be overridden
        abstract String category();

        @Override
        public String toString() { return getClass().getSimpleName() + "[" + name + "]"; }
    }

    // ── 2. Subclass ───────────────────────────────────────────
    static class Dog extends Animal {
        private String breed;

        Dog(String name, int age, String breed) {
            super(name, age); // must call super first
            this.breed = breed;
        }

        @Override
        String speak() { return "Woof!"; }

        @Override
        String category() { return "Mammal"; }

        String getBreed() { return breed; }

        void fetch() { System.out.println(name + " fetches the ball!"); }
    }

    static class Cat extends Animal {
        private boolean isIndoor;

        Cat(String name, int age, boolean isIndoor) {
            super(name, age);
            this.isIndoor = isIndoor;
        }

        @Override
        String speak() { return "Meow!"; }

        @Override
        String category() { return "Mammal"; }

        boolean isIndoor() { return isIndoor; }
    }

    // ── 3. Multi-level inheritance ────────────────────────────
    static class Vehicle {
        protected int speed;
        Vehicle(int speed) { this.speed = speed; }
        String move() { return "Moving at " + speed + " km/h"; }
    }

    static class Car extends Vehicle {
        protected int doors;
        Car(int speed, int doors) {
            super(speed);
            this.doors = doors;
        }
        @Override
        String move() { return "Car driving: " + super.move(); }
    }

    static class ElectricCar extends Car {
        private int batteryPercent;
        ElectricCar(int speed, int doors, int battery) {
            super(speed, doors);
            this.batteryPercent = battery;
        }
        @Override
        String move() { return super.move() + " | Battery: " + batteryPercent + "%"; }
        boolean isElectric() { return true; }
    }

    // ── 4. super usage ────────────────────────────────────────
    static class Shape {
        protected String color;
        Shape(String color) { this.color = color; }
        double area() { return 0; }
        String info() { return "Shape[color=" + color + "]"; }
    }

    static class Rectangle extends Shape {
        protected double width, height;

        Rectangle(String color, double width, double height) {
            super(color); // calls Shape(color)
            this.width = width;
            this.height = height;
        }

        @Override
        double area() { return width * height; }

        @Override
        String info() { return super.info() + " Rectangle[" + width + "x" + height + "]"; }
    }

    static class Square extends Rectangle {
        Square(String color, double side) {
            super(color, side, side); // reuse Rectangle
        }

        @Override
        String info() { return "Square[side=" + width + ", color=" + color + "]"; }
    }

    // ── 5. instanceof and casting ─────────────────────────────
    static void checkType(Animal a) {
        System.out.print(a.name + " is: Animal");
        if (a instanceof Dog d) {
            System.out.print(", Dog (breed=" + d.getBreed() + ")"); // Java 16+ pattern
        } else if (a instanceof Cat) {
            System.out.print(", Cat");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 1. Polymorphism via base reference
        Animal[] animals = {
            new Dog("Rex", 3, "Labrador"),
            new Cat("Whiskers", 5, true),
            new Dog("Buddy", 2, "Poodle")
        };

        for (Animal a : animals) {
            System.out.println(a.describe()); // calls overridden speak()
            System.out.println("  Category: " + a.category());
        }

        // 2. Subclass-specific method
        Dog dog = new Dog("Rex", 3, "Labrador");
        dog.fetch(); // only available on Dog

        // 3. Multi-level
        ElectricCar tesla = new ElectricCar(200, 4, 85);
        System.out.println(tesla.move());
        System.out.println("Is electric: " + tesla.isElectric());

        // 4. super
        Square sq = new Square("blue", 5.0);
        System.out.printf("Square area: %.1f%n", sq.area()); // 25.0
        System.out.println(sq.info());

        // 5. instanceof
        for (Animal a : animals) checkType(a);

        // 6. All classes extend Object
        System.out.println("Dog class: " + dog.getClass().getName());
        System.out.println("Superclass: " + dog.getClass().getSuperclass().getName());

        System.out.println("\n=== Inheritance Rules ===");
        System.out.println("extends      → single inheritance only");
        System.out.println("super()      → call parent constructor (first line)");
        System.out.println("@Override    → always use to catch mistakes");
        System.out.println("final method → cannot be overridden");
        System.out.println("final class  → cannot be extended");
        System.out.println("abstract     → class/method cannot be instantiated/must override");
        System.out.println("instanceof   → check type at runtime");
        System.out.println("IS-A test    → if Dog extends Animal: Dog IS-A Animal");
    }
}
