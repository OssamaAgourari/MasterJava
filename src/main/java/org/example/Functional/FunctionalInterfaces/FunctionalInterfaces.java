package org.example.Functional.FunctionalInterfaces;

import java.util.*;
import java.util.function.*;

/**
 * ============================================================
 *     JAVA FUNCTIONAL INTERFACES — COMPLETE GUIDE
 * ============================================================
 *
 * FUNCTIONAL INTERFACE: An interface with EXACTLY ONE abstract method.
 * Used as lambda targets and method reference targets.
 *
 * @FunctionalInterface annotation:
 *   - Optional but RECOMMENDED
 *   - Causes compile error if not functional (0 or 2+ abstract methods)
 *   - Documents intent
 *
 * BUILT-IN FUNCTIONAL INTERFACES (java.util.function):
 * ─────────────────────────────────────────────────────
 *  Category       Interface              Signature
 *  ───────────────────────────────────────────────────────────
 *  Transform      Function<T,R>          R apply(T t)
 *                 BiFunction<T,U,R>      R apply(T t, U u)
 *                 UnaryOperator<T>       T apply(T t)
 *                 BinaryOperator<T>      T apply(T t1, T t2)
 *  ───────────────────────────────────────────────────────────
 *  Test           Predicate<T>           boolean test(T t)
 *                 BiPredicate<T,U>       boolean test(T t, U u)
 *  ───────────────────────────────────────────────────────────
 *  Consume        Consumer<T>            void accept(T t)
 *                 BiConsumer<T,U>        void accept(T t, U u)
 *  ───────────────────────────────────────────────────────────
 *  Supply         Supplier<T>            T get()
 *  ───────────────────────────────────────────────────────────
 *  Primitives     IntFunction<R>, LongFunction<R>, DoubleFunction<R>
 *                 ToIntFunction<T>, ToLongFunction<T>, ToDoubleFunction<T>
 *                 IntUnaryOperator, LongUnaryOperator, DoubleUnaryOperator
 *                 IntBinaryOperator, IntConsumer, IntSupplier, IntPredicate
 *  ───────────────────────────────────────────────────────────
 *  Other          Runnable               void run()
 *                 Callable<V>            V call() throws Exception
 *                 Comparator<T>          int compare(T o1, T o2)
 *
 * ============================================================
 */
public class FunctionalInterfaces {

    // ── 1. Custom functional interface ────────────────────────
    @FunctionalInterface
    interface Transformer<T, R> {
        R transform(T input);

        // Default method — doesn't count toward abstract count
        default Transformer<T, R> withLogging() {
            return input -> {
                System.out.println("Input: " + input);
                R result = this.transform(input);
                System.out.println("Output: " + result);
                return result;
            };
        }

        // Static factory — doesn't count
        static <T> Transformer<T, T> identity() {
            return t -> t;
        }
    }

    // ── 2. Functional interface with generics ─────────────────
    @FunctionalInterface
    interface Validator<T> {
        ValidationResult validate(T value);

        record ValidationResult(boolean valid, String message) {
            static ValidationResult ok()           { return new ValidationResult(true, "OK"); }
            static ValidationResult fail(String m) { return new ValidationResult(false, m); }
        }

        default Validator<T> and(Validator<T> other) {
            return value -> {
                ValidationResult r = this.validate(value);
                return r.valid() ? other.validate(value) : r;
            };
        }
    }

    // ── 3. Higher-order functions ─────────────────────────────
    // Functions that take or return functions

    static <T, R> Function<T, R> memoize(Function<T, R> fn) {
        Map<T, R> cache = new HashMap<>();
        return input -> cache.computeIfAbsent(input, fn);
    }

    static <T> Predicate<T> not(Predicate<T> predicate) {
        return predicate.negate();
    }

    // Compose multiple functions into a pipeline
    @SafeVarargs
    static <T> Function<T, T> pipeline(UnaryOperator<T>... fns) {
        Function<T, T> identity = Function.identity();
        return Arrays.stream(fns)
                     .<Function<T, T>>map(f -> f)
                     .reduce(identity, Function::andThen);
    }

    // ── 4. Currying ───────────────────────────────────────────
    static <A, B, C> Function<A, Function<B, C>> curry(BiFunction<A, B, C> fn) {
        return a -> b -> fn.apply(a, b);
    }

    // ── 5. Retry logic with Supplier ──────────────────────────
    static <T> T retry(Supplier<T> supplier, int maxAttempts) {
        int attempt = 0;
        while (attempt < maxAttempts) {
            try {
                return supplier.get();
            } catch (Exception e) {
                attempt++;
                if (attempt >= maxAttempts) throw new RuntimeException("Failed after " + maxAttempts, e);
                System.out.println("Attempt " + attempt + " failed, retrying...");
            }
        }
        throw new RuntimeException("Unreachable");
    }

    // ── 6. Event system using functional interfaces ───────────
    static class EventBus {
        private Map<String, List<Consumer<Object>>> handlers = new HashMap<>();

        <T> void on(String event, Consumer<T> handler) {
            handlers.computeIfAbsent(event, k -> new ArrayList<>())
                    .add(e -> handler.accept((T) e));
        }

        void emit(String event, Object data) {
            List<Consumer<Object>> list = handlers.getOrDefault(event, Collections.emptyList());
            list.forEach(h -> h.accept(data));
        }
    }

    public static void main(String[] args) {
        // 1. Custom functional interface
        Transformer<String, Integer> length = String::length;
        Transformer<String, Integer> withLog = length.withLogging();
        System.out.println("Length of 'hello': " + length.transform("hello")); // 5
        withLog.transform("world");

        Transformer<String, String> identity = Transformer.identity();
        System.out.println("Identity: " + identity.transform("test")); // test

        // 2. Validator with composition
        Validator<String> notEmpty = s ->
            s != null && !s.isEmpty()
                ? Validator.ValidationResult.ok()
                : Validator.ValidationResult.fail("Must not be empty");

        Validator<String> minLength = s ->
            s != null && s.length() >= 3
                ? Validator.ValidationResult.ok()
                : Validator.ValidationResult.fail("Must be at least 3 chars");

        Validator<String> combined = notEmpty.and(minLength);

        System.out.println("\n=== Validator ===");
        System.out.println(combined.validate("hi"));      // fail (too short)
        System.out.println(combined.validate("hello"));   // ok
        System.out.println(combined.validate(""));        // fail (empty)

        // 3. Higher-order functions
        System.out.println("\n=== Memoized Fibonacci ===");
        Map<Integer, Long> fibCache = new HashMap<>();
        Function<Integer, Long> fib = memoize(n -> {
            if (n <= 1) return (long) n;
            return fibCache.computeIfAbsent(n-1, k -> 0L) + fibCache.computeIfAbsent(n-2, k -> 0L);
        });
        System.out.println("fib(10) = " + fib.apply(10));

        // 4. Currying
        System.out.println("\n=== Currying ===");
        BiFunction<Integer, Integer, Integer> add = Integer::sum;
        Function<Integer, Function<Integer, Integer>> curriedAdd = curry(add);
        Function<Integer, Integer> add5 = curriedAdd.apply(5);
        System.out.println("add5(3) = " + add5.apply(3)); // 8
        System.out.println("add5(7) = " + add5.apply(7)); // 12

        // 5. Pipeline
        System.out.println("\n=== Pipeline ===");
        Function<String, String> process = pipeline(
            String::trim,
            String::toLowerCase,
            s -> s.replace(" ", "_")
        );
        System.out.println(process.apply("  Hello World  ")); // hello_world

        // 6. Event bus
        System.out.println("\n=== Event Bus ===");
        EventBus bus = new EventBus();
        bus.on("login", (String user) -> System.out.println("User logged in: " + user));
        bus.on("login", (String user) -> System.out.println("Audit: " + user + " at " + System.currentTimeMillis()));
        bus.emit("login", "alice");

        System.out.println("\n=== Functional Interface Summary ===");
        System.out.println("@FunctionalInterface → one abstract method, lambda target");
        System.out.println("Default methods → added utility without breaking lambda use");
        System.out.println("Compose: andThen, compose, and, or, negate");
        System.out.println("Higher-order: functions as parameters and return values");
        System.out.println("Primitives: IntFunction etc. avoid boxing overhead");
    }
}
