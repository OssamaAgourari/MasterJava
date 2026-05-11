package org.example.Functional.Optional;

import java.util.*;
import java.util.function.*;

/**
 * ============================================================
 *          JAVA OPTIONAL — COMPLETE GUIDE
 * ============================================================
 *
 * Optional<T>: A container that may or may not contain a value.
 * The antidote to NullPointerException.
 *
 * PURPOSE:
 * --------
 *   - Express "might not have a value" in the type system
 *   - Force callers to handle the absence case
 *   - Fluent API for null-safe operations
 *
 * CREATION:
 * ---------
 *   Optional.of(value)          → wraps non-null (throws NPE if null)
 *   Optional.ofNullable(value)  → wraps null or non-null
 *   Optional.empty()            → empty Optional
 *
 * KEY METHODS:
 * ------------
 *   isPresent()          → boolean
 *   isEmpty()            → boolean (Java 11+)
 *   get()                → T (throws NoSuchElementException if empty)
 *   orElse(default)      → T (always evaluates default!)
 *   orElseGet(supplier)  → T (lazy — only calls supplier if empty)
 *   orElseThrow(supplier)→ T or throw
 *   ifPresent(consumer)  → run consumer if present
 *   ifPresentOrElse()    → Java 9+
 *   map(function)        → Optional<R>
 *   flatMap(function)    → Optional<R> (when function returns Optional)
 *   filter(predicate)    → Optional<T>
 *   or(supplier)         → Optional<T> if empty, use supplier's Optional (Java 9+)
 *   stream()             → Stream<T> (Java 9+)
 *
 * ANTI-PATTERNS:
 * --------------
 *   optional.get() without isPresent() check
 *   Optional as method parameter (use overloading instead)
 *   Optional in fields (just use null for fields)
 *   Returning Optional<T>[] or List<Optional<T>>
 *
 * ============================================================
 */
public class Optional {

    // ── 1. Creating and checking Optional ────────────────────
    static void basicDemo() {
        java.util.Optional<String> present = java.util.Optional.of("hello");
        java.util.Optional<String> empty   = java.util.Optional.empty();
        java.util.Optional<String> maybe   = java.util.Optional.ofNullable(null);

        System.out.println("present.isPresent(): " + present.isPresent()); // true
        System.out.println("empty.isEmpty():     " + empty.isEmpty());     // true
        System.out.println("maybe.isPresent():   " + maybe.isPresent());   // false

        // Safe extraction
        System.out.println("orElse: " + empty.orElse("default"));          // default
        System.out.println("orElseGet: " + empty.orElseGet(() -> "computed")); // computed
        System.out.println("present get: " + present.get()); // hello
    }

    // ── 2. orElse vs orElseGet ────────────────────────────────
    static void orElseVsOrElseGet() {
        // orElse ALWAYS evaluates the default (even if value present)
        // orElseGet is LAZY — only calls supplier if empty
        java.util.Optional<String> full = java.util.Optional.of("value");

        String r1 = full.orElse(expensiveOperation());        // expensiveOperation() called!
        String r2 = full.orElseGet(() -> expensiveOperation()); // NOT called

        System.out.println("Prefer orElseGet for expensive defaults");
    }

    static String expensiveOperation() {
        System.out.print("[expensive] ");
        return "computed";
    }

    // ── 3. map and flatMap ────────────────────────────────────
    static void mapFlatMapDemo() {
        java.util.Optional<String> name = java.util.Optional.of("  Alice  ");

        // map transforms value
        java.util.Optional<String> trimmed = name.map(String::trim);
        java.util.Optional<Integer> length = name.map(String::trim).map(String::length);
        System.out.println("trimmed: " + trimmed.get()); // Alice
        System.out.println("length: " + length.get());   // 5

        // flatMap when function returns Optional
        java.util.Optional<String> upper = name
            .map(String::trim)
            .flatMap(s -> s.isEmpty() ? java.util.Optional.empty() : java.util.Optional.of(s.toUpperCase()));
        System.out.println("upper: " + upper.get()); // ALICE

        // Chaining on empty
        java.util.Optional<String> empty = java.util.Optional.<String>empty()
            .map(s -> s + "!")
            .filter(s -> s.length() > 3);
        System.out.println("empty chain: " + empty.isPresent()); // false
    }

    // ── 4. filter ─────────────────────────────────────────────
    static void filterDemo() {
        java.util.Optional<Integer> opt = java.util.Optional.of(42);

        java.util.Optional<Integer> positive = opt.filter(n -> n > 0);
        java.util.Optional<Integer> even     = opt.filter(n -> n % 2 == 0);
        java.util.Optional<Integer> huge     = opt.filter(n -> n > 1000);

        System.out.println("positive: " + positive.isPresent()); // true
        System.out.println("even: "     + even.isPresent());     // true
        System.out.println("huge: "     + huge.isPresent());     // false
    }

    // ── 5. Real-world: null-safe chaining ────────────────────
    static class User {
        String name;
        Address address;
        User(String name, Address address) { this.name=name; this.address=address; }
    }

    static class Address {
        String city;
        String zipCode;
        Address(String city, String zip) { this.city=city; this.zipCode=zip; }
    }

    // Without Optional (NPE-prone):
    static String getCityOld(User user) {
        if (user != null && user.address != null && user.address.city != null)
            return user.address.city;
        return "Unknown";
    }

    // With Optional (null-safe, fluent):
    static String getCityNew(User user) {
        return java.util.Optional.ofNullable(user)
            .map(u -> u.address)
            .map(a -> a.city)
            .orElse("Unknown");
    }

    // ── 6. orElseThrow ────────────────────────────────────────
    static String findUser(Map<String, String> db, String id) {
        return java.util.Optional.ofNullable(db.get(id))
            .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    // ── 7. ifPresent and ifPresentOrElse ─────────────────────
    static void ifPresentDemo() {
        java.util.Optional<String> opt = java.util.Optional.of("hello");

        opt.ifPresent(s -> System.out.println("Found: " + s)); // Found: hello

        // Java 9+
        opt.ifPresentOrElse(
            s -> System.out.println("Value: " + s),
            ()  -> System.out.println("No value")
        );

        java.util.Optional.<String>empty().ifPresentOrElse(
            s -> System.out.println("Value: " + s),
            ()  -> System.out.println("No value") // this runs
        );
    }

    public static void main(String[] args) {
        System.out.println("=== Basic Optional ===");
        basicDemo();

        System.out.println("\n=== orElse vs orElseGet ===");
        orElseVsOrElseGet();

        System.out.println("\n=== map and flatMap ===");
        mapFlatMapDemo();

        System.out.println("\n=== filter ===");
        filterDemo();

        System.out.println("\n=== Real-world null-safe chaining ===");
        User u1 = new User("Alice", new Address("NYC", "10001"));
        User u2 = new User("Bob", null);
        User u3 = null;

        System.out.println(getCityNew(u1)); // NYC
        System.out.println(getCityNew(u2)); // Unknown
        System.out.println(getCityNew(u3)); // Unknown

        System.out.println("\n=== orElseThrow ===");
        Map<String, String> db = Map.of("1", "Alice", "2", "Bob");
        System.out.println(findUser(db, "1")); // Alice
        try { findUser(db, "99"); }
        catch (RuntimeException e) { System.out.println(e.getMessage()); }

        System.out.println("\n=== ifPresent ===");
        ifPresentDemo();

        System.out.println("\n=== Optional Quick Reference ===");
        System.out.println("Optional.of(x)         → non-null value");
        System.out.println("Optional.ofNullable(x) → nullable");
        System.out.println("Optional.empty()       → empty");
        System.out.println("orElse(d)              → eager default");
        System.out.println("orElseGet(supplier)    → lazy default (prefer)");
        System.out.println("orElseThrow(supplier)  → throw if empty");
        System.out.println("map/flatMap/filter     → transform safely");
        System.out.println("Don't: optional.get() without check, Optional in fields");
    }
}
