package org.example.Functional.MethodReferences;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * ============================================================
 *       JAVA METHOD REFERENCES — COMPLETE GUIDE
 * ============================================================
 *
 * Method references are a shorthand for lambdas that call a single method.
 *
 * FOUR TYPES:
 * -----------
 *   1. Static method:       Class::staticMethod
 *      Lambda: (args) -> Class.staticMethod(args)
 *
 *   2. Instance method (bound):   instance::method
 *      Lambda: (args) -> instance.method(args)
 *
 *   3. Instance method (unbound): Class::instanceMethod
 *      Lambda: (obj, args) -> obj.method(args)
 *
 *   4. Constructor:         Class::new
 *      Lambda: (args) -> new Class(args)
 *
 * WHEN TO USE:
 * ------------
 *   Use method references when the lambda just calls ONE method.
 *   Use lambdas when you need logic or multiple operations.
 *
 * ============================================================
 */
public class MethodReferences {

    static class Person {
        String name;
        int age;
        Person(String name, int age) { this.name=name; this.age=age; }
        Person(String name) { this(name, 0); }

        String getName() { return name; }
        int getAge()     { return age; }
        boolean isAdult(){ return age >= 18; }
        void print()     { System.out.println("Person: " + name + "(" + age + ")"); }

        static int compareByAge(Person a, Person b) { return Integer.compare(a.age, b.age); }
        static boolean isOldEnough(Person p)         { return p.age >= 18; }

        @Override public String toString() { return name + "(" + age + ")"; }
    }

    // ── 1. Static method reference ────────────────────────────
    static void staticMethodRef() {
        // Lambda:          (s) -> Integer.parseInt(s)
        // Method ref:      Integer::parseInt
        Function<String, Integer> parse = Integer::parseInt;
        System.out.println("parseInt: " + parse.apply("42")); // 42

        // Lambda:          (a, b) -> Integer.compare(a, b)
        Comparator<Integer> cmp = Integer::compare;

        // Lambda:          (a, b) -> Person.compareByAge(a, b)
        List<Person> people = Arrays.asList(
            new Person("Alice", 30), new Person("Bob", 25), new Person("Carol", 35)
        );
        people.sort(Person::compareByAge);
        System.out.println("Sorted by age: " + people);

        // Filter using static method ref
        List<Person> adults = people.stream()
            .filter(Person::isOldEnough)
            .collect(Collectors.toList());
        System.out.println("Adults: " + adults);
    }

    // ── 2. Bound instance method reference ────────────────────
    static void boundInstanceRef() {
        String prefix = "Hello, ";
        // Lambda:    (s) -> prefix.concat(s)
        Function<String, String> greet = prefix::concat;
        System.out.println(greet.apply("World!")); // Hello, World!

        // Lambda:    (s) -> System.out.println(s)
        Consumer<String> printer = System.out::println;
        printer.accept("Bound instance ref"); // Bound instance ref

        // Lambda:    () -> list.size()
        List<Integer> nums = Arrays.asList(1, 2, 3);
        Supplier<Integer> size = nums::size;
        System.out.println("Size: " + size.get()); // 3
    }

    // ── 3. Unbound instance method reference ──────────────────
    static void unboundInstanceRef() {
        // Lambda:    (person) -> person.getName()
        Function<Person, String> getName = Person::getName;
        // Lambda:    (person) -> person.getAge()
        Function<Person, Integer> getAge = Person::getAge;

        List<Person> people = Arrays.asList(
            new Person("Alice", 30), new Person("Bob", 25)
        );

        List<String> names = people.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println("Names: " + names);

        // Lambda:    (person) -> person.isAdult()
        Predicate<Person> isAdult = Person::isAdult;
        System.out.println("Alice adult: " + isAdult.test(new Person("Alice", 30))); // true

        // Lambda:    (person) -> person.print()
        Consumer<Person> print = Person::print;
        people.forEach(print);

        // String instance methods
        Function<String, String> toUpper = String::toUpperCase;
        Function<String, String> trim    = String::trim;
        Predicate<String> isEmpty        = String::isEmpty;

        List<String> words = Arrays.asList("  hello  ", "  world  ", "  java  ");
        List<String> cleaned = words.stream().map(String::trim).map(String::toUpperCase)
                                    .collect(Collectors.toList());
        System.out.println("Cleaned: " + cleaned);
    }

    // ── 4. Constructor reference ──────────────────────────────
    static void constructorRef() {
        // Lambda:    (name, age) -> new Person(name, age)
        BiFunction<String, Integer, Person> make = Person::new;
        Person p = make.apply("Dave", 28);
        System.out.println("Created: " + p);

        // Lambda:    (name) -> new Person(name)
        Function<String, Person> makeName = Person::new;
        System.out.println("Name only: " + makeName.apply("Eve"));

        // Lambda:    () -> new ArrayList<>()
        Supplier<List<String>> listFactory = ArrayList::new;
        List<String> list = listFactory.get();
        list.add("hello");
        System.out.println("Factory: " + list);

        // Create multiple people
        List<String> names = Arrays.asList("Alice", "Bob", "Carol");
        List<Person> people = names.stream()
            .map(Person::new) // uses Person(String) constructor
            .collect(Collectors.toList());
        System.out.println("People: " + people);
    }

    // ── 5. Method references in sorting ───────────────────────
    static void sortingWithRefs() {
        List<String> words = Arrays.asList("banana", "Apple", "cherry", "date");

        // Various sort approaches
        words.sort(String::compareTo);                          // natural
        System.out.println("Natural: " + words);
        words.sort(String::compareToIgnoreCase);                // case-insensitive
        System.out.println("Case-insensitive: " + words);
        words.sort(Comparator.comparingInt(String::length));    // by length
        System.out.println("By length: " + words);
    }

    public static void main(String[] args) {
        System.out.println("=== Static Method Ref ===");
        staticMethodRef();

        System.out.println("\n=== Bound Instance Ref ===");
        boundInstanceRef();

        System.out.println("\n=== Unbound Instance Ref ===");
        unboundInstanceRef();

        System.out.println("\n=== Constructor Ref ===");
        constructorRef();

        System.out.println("\n=== Sorting with Refs ===");
        sortingWithRefs();

        System.out.println("\n=== Method Reference Quick Reference ===");
        System.out.println("Static:       Class::staticMethod     → (args) -> Class.m(args)");
        System.out.println("Bound:        obj::method             → (args) -> obj.m(args)");
        System.out.println("Unbound:      Class::instanceMethod   → (obj,args) -> obj.m(args)");
        System.out.println("Constructor:  Class::new              → (args) -> new Class(args)");
    }
}
