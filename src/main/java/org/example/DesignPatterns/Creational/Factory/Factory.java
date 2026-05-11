package org.example.DesignPatterns.Creational.Factory;

import java.util.*;

/**
 * ============================================================
 *       FACTORY & ABSTRACT FACTORY PATTERNS
 * ============================================================
 *
 * FACTORY METHOD:
 * ---------------
 *   Define an interface for creating an object, but let subclasses
 *   decide which class to instantiate. "Virtual constructor."
 *
 * ABSTRACT FACTORY:
 * -----------------
 *   Create families of related objects without specifying
 *   their concrete classes.
 *
 * BENEFITS:
 * ---------
 *   - Decouple object creation from usage
 *   - Easy to add new product types (Open/Closed Principle)
 *   - Centralize creation logic
 *
 * VARIANTS:
 * ---------
 *   1. Simple Factory (not a pattern, just a method)
 *   2. Factory Method (subclass decides what to create)
 *   3. Abstract Factory (create families of products)
 *   4. Static Factory Method (Item 1 of Effective Java)
 *
 * ============================================================
 */
public class Factory {

    // ── Product hierarchy ──────────────────────────────────
    interface Button {
        void render();
        void onClick();
    }

    interface Checkbox {
        void render();
        void toggle();
    }

    // ── Concrete products (Windows) ───────────────────────
    static class WindowsButton implements Button {
        @Override public void render()  { System.out.println("[Windows Button]"); }
        @Override public void onClick() { System.out.println("Windows button clicked"); }
    }

    static class WindowsCheckbox implements Checkbox {
        @Override public void render()  { System.out.println("[Windows Checkbox]"); }
        @Override public void toggle()  { System.out.println("Windows checkbox toggled"); }
    }

    // ── Concrete products (macOS) ─────────────────────────
    static class MacButton implements Button {
        @Override public void render()  { System.out.println("(Mac Button)"); }
        @Override public void onClick() { System.out.println("Mac button clicked"); }
    }

    static class MacCheckbox implements Checkbox {
        @Override public void render()  { System.out.println("(Mac Checkbox)"); }
        @Override public void toggle()  { System.out.println("Mac checkbox toggled"); }
    }

    // ── Abstract Factory ───────────────────────────────────
    interface GUIFactory {
        Button   createButton();
        Checkbox createCheckbox();
    }

    static class WindowsFactory implements GUIFactory {
        @Override public Button   createButton()   { return new WindowsButton(); }
        @Override public Checkbox createCheckbox() { return new WindowsCheckbox(); }
    }

    static class MacFactory implements GUIFactory {
        @Override public Button   createButton()   { return new MacButton(); }
        @Override public Checkbox createCheckbox() { return new MacCheckbox(); }
    }

    // ── Client code (uses factory, doesn't know concrete type) ──
    static class Application {
        private Button   button;
        private Checkbox checkbox;

        Application(GUIFactory factory) {
            button   = factory.createButton();
            checkbox = factory.createCheckbox();
        }

        void render() {
            button.render();
            checkbox.render();
        }

        void interact() {
            button.onClick();
            checkbox.toggle();
        }
    }

    // ── Factory Method pattern ─────────────────────────────
    interface Logger {
        void log(String message);
        String getType();
    }

    static class ConsoleLogger implements Logger {
        @Override public void log(String msg) { System.out.println("[CONSOLE] " + msg); }
        @Override public String getType()      { return "Console"; }
    }

    static class FileLogger implements Logger {
        @Override public void log(String msg) { System.out.println("[FILE] " + msg); }
        @Override public String getType()      { return "File"; }
    }

    static class DatabaseLogger implements Logger {
        @Override public void log(String msg) { System.out.println("[DB] " + msg); }
        @Override public String getType()      { return "Database"; }
    }

    // Factory Method
    static abstract class LoggerFactory {
        abstract Logger createLogger();  // factory method

        void writeLog(String message) {
            Logger logger = createLogger();
            logger.log(message);
        }
    }

    static class ConsoleLoggerFactory extends LoggerFactory {
        @Override Logger createLogger() { return new ConsoleLogger(); }
    }

    static class FileLoggerFactory extends LoggerFactory {
        @Override Logger createLogger() { return new FileLogger(); }
    }

    // ── Simple Factory / Registry ─────────────────────────
    static class LoggerRegistry {
        private static final Map<String, java.util.function.Supplier<Logger>> registry = new HashMap<>();

        static {
            registry.put("console",  ConsoleLogger::new);
            registry.put("file",     FileLogger::new);
            registry.put("database", DatabaseLogger::new);
        }

        static Logger getLogger(String type) {
            java.util.function.Supplier<Logger> supplier = registry.get(type.toLowerCase());
            if (supplier == null) throw new IllegalArgumentException("Unknown logger: " + type);
            return supplier.get();
        }
    }

    // ── Static Factory Method (Effective Java style) ───────
    static class Money {
        private final long cents;
        private final String currency;

        private Money(long cents, String currency) {
            this.cents = cents;
            this.currency = currency;
        }

        // Static factories with meaningful names
        static Money ofDollars(double dollars)   { return new Money(Math.round(dollars * 100), "USD"); }
        static Money ofCents(long cents)          { return new Money(cents, "USD"); }
        static Money ofEuros(double euros)        { return new Money(Math.round(euros * 100), "EUR"); }
        static Money zero(String currency)        { return new Money(0, currency); }

        Money add(Money other) {
            if (!currency.equals(other.currency)) throw new IllegalArgumentException("Currency mismatch");
            return new Money(cents + other.cents, currency);
        }

        @Override public String toString() { return String.format("%.2f %s", cents/100.0, currency); }
    }

    public static void main(String[] args) {
        System.out.println("=== Abstract Factory — OS Theme ===");
        String os = System.getProperty("os.name", "").toLowerCase().contains("mac") ? "mac" : "windows";
        GUIFactory factory = os.equals("mac") ? new MacFactory() : new WindowsFactory();

        Application winApp = new Application(new WindowsFactory());
        Application macApp = new Application(new MacFactory());

        System.out.println("Windows app:");
        winApp.render();
        System.out.println("Mac app:");
        macApp.render();

        System.out.println("\n=== Factory Method ===");
        LoggerFactory consoleFactory = new ConsoleLoggerFactory();
        LoggerFactory fileFactory    = new FileLoggerFactory();
        consoleFactory.writeLog("Application started");
        fileFactory.writeLog("Application started");

        System.out.println("\n=== Registry / Simple Factory ===");
        Logger l1 = LoggerRegistry.getLogger("console");
        Logger l2 = LoggerRegistry.getLogger("database");
        l1.log("Hello from registry");
        l2.log("Hello from registry");

        System.out.println("\n=== Static Factory Methods ===");
        Money price  = Money.ofDollars(19.99);
        Money tax    = Money.ofCents(200);
        Money total  = price.add(tax);
        System.out.println("Price: " + price);  // 19.99 USD
        System.out.println("Tax:   " + tax);    // 2.00 USD
        System.out.println("Total: " + total);  // 21.99 USD

        System.out.println("\n=== Factory Pattern Summary ===");
        System.out.println("Simple Factory   → static method, no subclass");
        System.out.println("Factory Method   → subclass overrides to create product");
        System.out.println("Abstract Factory → families of related objects");
        System.out.println("Static Factory   → meaningful names, caching possible");
    }
}
