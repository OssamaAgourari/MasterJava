package org.example.Functional.Lambdas;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * ============================================================
 *          JAVA LAMBDAS — COMPLETE GUIDE
 * ============================================================
 *
 * LAMBDA EXPRESSION: A concise way to represent a function.
 * Shorthand for implementing a functional interface (1 abstract method).
 *
 * SYNTAX:
 * -------
 *   (params) -> expression
 *   (params) -> { statements; return value; }
 *   ()       -> expression          // no params
 *   param    -> expression          // single param, no parens
 *
 * CAPTURING VARIABLES:
 * --------------------
 *   - Can capture local variables if they are EFFECTIVELY FINAL
 *   - Can access outer class fields and static members
 *   - Cannot modify captured local variables
 *
 * BUILT-IN FUNCTIONAL INTERFACES (java.util.function):
 * -----------------------------------------------------
 *   Function<T,R>      → R apply(T t)             — transform
 *   BiFunction<T,U,R>  → R apply(T t, U u)        — two inputs
 *   Predicate<T>       → boolean test(T t)        — filter
 *   BiPredicate<T,U>   → boolean test(T t, U u)
 *   Consumer<T>        → void accept(T t)          — side effect
 *   BiConsumer<T,U>    → void accept(T t, U u)
 *   Supplier<T>        → T get()                   — no input
 *   UnaryOperator<T>   → T apply(T t)              — same type in/out
 *   BinaryOperator<T>  → T apply(T t1, T t2)
 *   Runnable           → void run()
 *
 * ============================================================
 */
public class Lambdas {

    // ── 1. Lambda basics ─────────────────────────────────────
    static void lambdaBasics() {
        // Runnable — no params, no return
        Runnable greet = () -> System.out.println("Hello from lambda!");
        greet.run();

        // Comparator — two params, int return
        Comparator<String> byLength = (a, b) -> Integer.compare(a.length(), b.length());
        List<String> words = new ArrayList<>(Arrays.asList("banana", "fig", "apple", "date"));
        words.sort(byLength);
        System.out.println("By length: " + words);

        // One-liner with type inference
        words.sort((a, b) -> a.compareTo(b));
        System.out.println("Alphabetical: " + words);
    }

    // ── 2. Function<T,R> — transform ─────────────────────────
    static void functionDemo() {
        Function<String, Integer> length = String::length;      // method ref
        Function<String, String> upper   = s -> s.toUpperCase();
        Function<Integer, Boolean> isEven = n -> n % 2 == 0;

        System.out.println("length: " + length.apply("hello")); // 5
        System.out.println("upper: " + upper.apply("hello"));   // HELLO

        // compose and andThen
        Function<String, String> trimUpper = upper.compose(String::trim); // trim THEN upper
        Function<String, Integer> upperLen = upper.andThen(length);        // upper THEN length
        System.out.println("trimUpper('  hi  '): " + trimUpper.apply("  hi  ")); // HI
        System.out.println("upperLen('hello'): " + upperLen.apply("hello"));     // 5
    }

    // ── 3. Predicate<T> — filter ─────────────────────────────
    static void predicateDemo() {
        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<Integer> isEven     = n -> n % 2 == 0;
        Predicate<String>  notEmpty   = s -> !s.isEmpty();

        // Combine predicates
        Predicate<Integer> isPositiveEven = isPositive.and(isEven);
        Predicate<Integer> isPositiveOrEven = isPositive.or(isEven);
        Predicate<Integer> isNegative = isPositive.negate();

        List<Integer> nums = Arrays.asList(-3, -2, 0, 1, 2, 3, 4, 5);
        System.out.println("Positive even: " +
            nums.stream().filter(isPositiveEven).collect(Collectors.toList())); // [2,4]
        System.out.println("Negative: " +
            nums.stream().filter(isNegative).collect(Collectors.toList()));     // [-3,-2]
    }

    // ── 4. Consumer<T> — side effect ─────────────────────────
    static void consumerDemo() {
        Consumer<String> print  = System.out::println;
        Consumer<String> upper  = s -> System.out.println(s.toUpperCase());
        Consumer<String> both   = print.andThen(upper); // chain consumers

        both.accept("hello"); // "hello" then "HELLO"

        // BiConsumer
        BiConsumer<String, Integer> printWithIndex =
            (s, i) -> System.out.println(i + ": " + s);
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        for (int i = 0; i < words.size(); i++)
            printWithIndex.accept(words.get(i), i);
    }

    // ── 5. Supplier<T> — produce value ───────────────────────
    static void supplierDemo() {
        Supplier<List<String>> listFactory = ArrayList::new;
        Supplier<Double>       random      = Math::random;
        Supplier<String>       timestamp   = () -> String.valueOf(System.currentTimeMillis());

        List<String> list = listFactory.get();
        list.add("hello");
        System.out.println("Supplier list: " + list);

        // Lazy evaluation
        System.out.println("Random: " + random.get());
    }

    // ── 6. UnaryOperator / BinaryOperator ────────────────────
    static void operatorDemo() {
        UnaryOperator<Integer> doubler  = n -> n * 2;
        UnaryOperator<String>  trimmer  = String::trim;
        BinaryOperator<Integer> adder   = Integer::sum;
        BinaryOperator<String>  concat  = (a, b) -> a + " " + b;

        System.out.println("double(5): " + doubler.apply(5));     // 10
        System.out.println("trim: " + trimmer.apply("  hi  "));   // hi
        System.out.println("add(3,4): " + adder.apply(3, 4));     // 7
        System.out.println("concat: " + concat.apply("Hello","World")); // Hello World
    }

    // ── 7. Lambda with collections ───────────────────────────
    static void collectionsDemo() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9, 3, 7));

        // forEach
        System.out.print("forEach: ");
        nums.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // removeIf
        nums.removeIf(n -> n % 2 == 0);
        System.out.println("After removeIf(even): " + nums);

        // replaceAll
        nums.replaceAll(n -> n * 10);
        System.out.println("After replaceAll(*10): " + nums);

        // Map operations
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 85);
        scores.put("Bob", 92);
        scores.put("Carol", 78);
        scores.forEach((name, score) -> System.out.println("  " + name + ": " + score));
        scores.replaceAll((name, score) -> score + 5); // bonus
        System.out.println("After bonus: " + scores);
    }

    // ── 8. Capturing variables ───────────────────────────────
    static List<Runnable> createClosures(int count) {
        List<Runnable> closures = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            final int captured = i; // effectively final
            closures.add(() -> System.out.print(captured + " "));
        }
        return closures;
    }

    public static void main(String[] args) {
        System.out.println("=== Lambda Basics ===");
        lambdaBasics();

        System.out.println("\n=== Function ===");
        functionDemo();

        System.out.println("\n=== Predicate ===");
        predicateDemo();

        System.out.println("\n=== Consumer ===");
        consumerDemo();

        System.out.println("\n=== Supplier ===");
        supplierDemo();

        System.out.println("\n=== Operators ===");
        operatorDemo();

        System.out.println("\n=== Collections with Lambdas ===");
        collectionsDemo();

        System.out.println("\n=== Closures ===");
        List<Runnable> closures = createClosures(5);
        closures.forEach(Runnable::run); // 0 1 2 3 4
        System.out.println();

        System.out.println("\n=== Lambda Quick Reference ===");
        System.out.println("()    -> expr          no params");
        System.out.println("x     -> expr          one param (no parens)");
        System.out.println("(x,y) -> expr          multiple params");
        System.out.println("(x,y) -> { stmt; return; }  block body");
        System.out.println("Captured vars must be effectively final");
    }
}
