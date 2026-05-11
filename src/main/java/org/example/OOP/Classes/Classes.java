package org.example.OOP.Classes;

/**
 * ============================================================
 *          JAVA CLASSES — COMPLETE GUIDE
 * ============================================================
 *
 * A CLASS is a blueprint for objects. An OBJECT is an instance.
 *
 * CLASS ANATOMY:
 * --------------
 *   Fields (instance variables)  — state
 *   Constructors                 — initialize objects
 *   Methods                      — behavior
 *   Static members               — belong to class, not instance
 *   Nested/Inner classes
 *
 * ACCESS MODIFIERS:
 * -----------------
 *   public    → accessible everywhere
 *   protected → same package + subclasses
 *   (default) → same package only
 *   private   → same class only
 *
 * KEY CONCEPTS:
 * -------------
 *   this         → current instance reference
 *   static       → class-level (shared), no 'this'
 *   final field  → immutable after assignment
 *   final method → cannot be overridden
 *   final class  → cannot be extended (e.g. String)
 *
 * CONSTRUCTOR RULES:
 * ------------------
 *   - Same name as class, no return type
 *   - Default constructor provided if none defined
 *   - this() → call another constructor (must be first line)
 *   - super() → call parent constructor (must be first line)
 *
 * ============================================================
 */
public class Classes {

    // ── 1. Simple class with fields, constructors, methods ────
    static class BankAccount {
        // Fields
        private String owner;
        private double balance;
        private static int totalAccounts = 0; // static = shared

        // Default constructor
        BankAccount() {
            this("Unknown", 0.0);
        }

        // Parameterized constructor
        BankAccount(String owner, double initialBalance) {
            this.owner = owner;
            this.balance = initialBalance;
            totalAccounts++;
        }

        // Methods
        void deposit(double amount) {
            if (amount > 0) balance += amount;
        }

        boolean withdraw(double amount) {
            if (amount > 0 && balance >= amount) {
                balance -= amount;
                return true;
            }
            return false;
        }

        double getBalance() { return balance; }
        String getOwner()   { return owner; }

        static int getTotalAccounts() { return totalAccounts; } // static method

        @Override
        public String toString() {
            return String.format("BankAccount[owner=%s, balance=%.2f]", owner, balance);
        }
    }

    // ── 2. Class with builder pattern (nested static) ─────────
    static class Person {
        private final String name;   // final = must be set in constructor
        private final int age;
        private final String email;

        // Private constructor — force use of Builder
        private Person(Builder b) {
            this.name  = b.name;
            this.age   = b.age;
            this.email = b.email;
        }

        static class Builder {
            private String name;
            private int age;
            private String email = "";

            Builder(String name, int age) {
                this.name = name;
                this.age  = age;
            }
            Builder email(String email) { this.email = email; return this; }
            Person build() { return new Person(this); }
        }

        @Override
        public String toString() {
            return "Person[name=" + name + ", age=" + age + ", email=" + email + "]";
        }
    }

    // ── 3. Static utility class ───────────────────────────────
    static class MathUtils {
        private MathUtils() {} // prevent instantiation

        static int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        static int lcm(int a, int b) {
            return a / gcd(a, b) * b;
        }

        static boolean isPrime(int n) {
            if (n < 2) return false;
            for (int i = 2; i * i <= n; i++)
                if (n % i == 0) return false;
            return true;
        }
    }

    // ── 4. Immutable class ────────────────────────────────────
    static final class ImmutablePoint {
        private final int x, y;

        ImmutablePoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() { return x; }
        int getY() { return y; }

        // Methods return NEW objects — never mutate
        ImmutablePoint translate(int dx, int dy) {
            return new ImmutablePoint(x + dx, y + dy);
        }

        double distanceTo(ImmutablePoint other) {
            int dx = x - other.x, dy = y - other.y;
            return Math.sqrt(dx*dx + dy*dy);
        }

        @Override
        public String toString() { return "(" + x + "," + y + ")"; }
    }

    // ── 5. Class with equals and hashCode ─────────────────────
    static class Card {
        private final String suit;
        private final int rank;

        Card(String suit, int rank) {
            this.suit = suit;
            this.rank = rank;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Card)) return false;
            Card c = (Card) o;
            return rank == c.rank && suit.equals(c.suit);
        }

        @Override
        public int hashCode() {
            return 31 * suit.hashCode() + rank;
        }

        @Override
        public String toString() { return rank + " of " + suit; }
    }

    public static void main(String[] args) {
        // 1. BankAccount
        BankAccount acc1 = new BankAccount("Alice", 1000.0);
        BankAccount acc2 = new BankAccount("Bob", 500.0);
        acc1.deposit(200);
        acc1.withdraw(100);
        System.out.println(acc1);                          // balance=1100.00
        System.out.println("Withdrew 2000: " + acc1.withdraw(2000)); // false
        System.out.println("Total accounts: " + BankAccount.getTotalAccounts()); // 2

        // 2. Builder pattern
        Person p = new Person.Builder("Alice", 30)
                        .email("alice@example.com")
                        .build();
        System.out.println(p);

        // 3. Static utility
        System.out.println("GCD(12,8)=" + MathUtils.gcd(12, 8));   // 4
        System.out.println("LCM(4,6)="  + MathUtils.lcm(4, 6));    // 12
        System.out.println("isPrime(17)=" + MathUtils.isPrime(17)); // true

        // 4. Immutable point
        ImmutablePoint pt = new ImmutablePoint(3, 4);
        ImmutablePoint moved = pt.translate(1, 1);
        System.out.println("Point: " + pt + " → " + moved);
        System.out.printf("Distance: %.2f%n", pt.distanceTo(new ImmutablePoint(0,0))); // 5.00

        // 5. equals and hashCode
        Card c1 = new Card("Hearts", 10);
        Card c2 = new Card("Hearts", 10);
        Card c3 = new Card("Spades", 10);
        System.out.println("c1.equals(c2): " + c1.equals(c2)); // true
        System.out.println("c1.equals(c3): " + c1.equals(c3)); // false

        System.out.println("\n=== Class Quick Reference ===");
        System.out.println("this      → current object");
        System.out.println("static    → class-level, shared across instances");
        System.out.println("final     → field: immutable, class: can't extend");
        System.out.println("Always override equals() AND hashCode() together");
        System.out.println("Builder   → flexible object construction");
        System.out.println("Immutable → thread-safe, safe to share");
    }
}
