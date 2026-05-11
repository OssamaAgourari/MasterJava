package org.example.DesignPatterns.Structural.Decorator;

import java.util.function.*;

/**
 * ============================================================
 *           DECORATOR PATTERN — COMPLETE GUIDE
 * ============================================================
 *
 * INTENT: Attach additional responsibilities to an object
 * dynamically. Provide flexible alternative to subclassing.
 *
 * STRUCTURE:
 * ----------
 *   Component      → interface
 *   ConcreteComponent → base implementation
 *   Decorator      → wraps a component, delegates + adds behavior
 *   ConcreteDecorator → specific decorator
 *
 * KEY INSIGHT: Decorators have the SAME interface as what they decorate.
 * They wrap and delegate, adding behavior before/after delegation.
 *
 * REAL-WORLD JAVA:
 * ----------------
 *   BufferedReader(new FileReader(...))
 *   Collections.unmodifiableList(list)
 *   Collections.synchronizedList(list)
 *   Stream decorates source
 *
 * ============================================================
 */
public class Decorator {

    // ── 1. Coffee decorator ───────────────────────────────────
    interface Coffee {
        String getDescription();
        double getCost();
    }

    // Base component
    static class SimpleCoffee implements Coffee {
        @Override public String getDescription() { return "Simple coffee"; }
        @Override public double getCost()         { return 1.00; }
    }

    // Abstract decorator
    static abstract class CoffeeDecorator implements Coffee {
        protected final Coffee coffee;
        CoffeeDecorator(Coffee c) { this.coffee = c; }
    }

    static class MilkDecorator extends CoffeeDecorator {
        MilkDecorator(Coffee c) { super(c); }
        @Override public String getDescription() { return coffee.getDescription() + ", milk"; }
        @Override public double getCost()         { return coffee.getCost() + 0.50; }
    }

    static class SugarDecorator extends CoffeeDecorator {
        SugarDecorator(Coffee c) { super(c); }
        @Override public String getDescription() { return coffee.getDescription() + ", sugar"; }
        @Override public double getCost()         { return coffee.getCost() + 0.25; }
    }

    static class WhipDecorator extends CoffeeDecorator {
        WhipDecorator(Coffee c) { super(c); }
        @Override public String getDescription() { return coffee.getDescription() + ", whip"; }
        @Override public double getCost()         { return coffee.getCost() + 0.75; }
    }

    static class SyrupDecorator extends CoffeeDecorator {
        private final String flavor;
        SyrupDecorator(Coffee c, String flavor) { super(c); this.flavor = flavor; }
        @Override public String getDescription() { return coffee.getDescription() + ", " + flavor + " syrup"; }
        @Override public double getCost()         { return coffee.getCost() + 0.60; }
    }

    // ── 2. Text transformation decorator ──────────────────────
    interface TextTransformer {
        String transform(String text);
    }

    static class IdentityTransformer implements TextTransformer {
        @Override public String transform(String t) { return t; }
    }

    static class TrimDecorator implements TextTransformer {
        private final TextTransformer inner;
        TrimDecorator(TextTransformer t) { inner = t; }
        @Override public String transform(String text) { return inner.transform(text).trim(); }
    }

    static class UpperCaseDecorator implements TextTransformer {
        private final TextTransformer inner;
        UpperCaseDecorator(TextTransformer t) { inner = t; }
        @Override public String transform(String text) { return inner.transform(text).toUpperCase(); }
    }

    static class LoggingDecorator implements TextTransformer {
        private final TextTransformer inner;
        private int calls = 0;
        LoggingDecorator(TextTransformer t) { inner = t; }
        @Override public String transform(String text) {
            calls++;
            System.out.println("  [log #" + calls + "] input: '" + text + "'");
            String result = inner.transform(text);
            System.out.println("  [log #" + calls + "] output: '" + result + "'");
            return result;
        }
    }

    // ── 3. Function decorator (lambda version) ─────────────────
    static <T, R> Function<T, R> withLogging(Function<T, R> fn, String name) {
        return input -> {
            System.out.println("[" + name + "] called with: " + input);
            R result = fn.apply(input);
            System.out.println("[" + name + "] returned: " + result);
            return result;
        };
    }

    static <T, R> Function<T, R> withTiming(Function<T, R> fn) {
        return input -> {
            long start = System.nanoTime();
            R result = fn.apply(input);
            System.out.printf("  Took %.3f ms%n", (System.nanoTime()-start)/1_000_000.0);
            return result;
        };
    }

    // ── 4. I/O style decorator ─────────────────────────────────
    interface DataSource {
        void writeData(String data);
        String readData();
    }

    static class FileDataSource implements DataSource {
        private String stored = "";
        @Override public void writeData(String d) { stored = d; System.out.println("  File write: " + d); }
        @Override public String readData()          { return stored; }
    }

    static class EncryptionDecorator implements DataSource {
        private final DataSource wrapped;
        EncryptionDecorator(DataSource ds) { wrapped = ds; }
        @Override public void writeData(String d) {
            // Simple Caesar cipher (+3)
            StringBuilder enc = new StringBuilder();
            for (char c : d.toCharArray()) enc.append((char)(c + 3));
            System.out.println("  Encrypting: " + d + " → " + enc);
            wrapped.writeData(enc.toString());
        }
        @Override public String readData() {
            String enc = wrapped.readData();
            StringBuilder dec = new StringBuilder();
            for (char c : enc.toCharArray()) dec.append((char)(c - 3));
            System.out.println("  Decrypting: " + enc + " → " + dec);
            return dec.toString();
        }
    }

    static class CompressionDecorator implements DataSource {
        private final DataSource wrapped;
        CompressionDecorator(DataSource ds) { wrapped = ds; }
        @Override public void writeData(String d) {
            System.out.println("  Compressing: " + d.length() + " chars");
            wrapped.writeData(d + "[compressed]");
        }
        @Override public String readData() {
            String data = wrapped.readData();
            return data.replace("[compressed]", "");
        }
    }

    public static void main(String[] args) {
        // 1. Coffee decorator
        System.out.println("=== Coffee Decorator ===");
        Coffee coffee = new SimpleCoffee();
        System.out.printf("%-40s $%.2f%n", coffee.getDescription(), coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.printf("%-40s $%.2f%n", coffee.getDescription(), coffee.getCost());

        coffee = new SugarDecorator(coffee);
        coffee = new WhipDecorator(coffee);
        coffee = new SyrupDecorator(coffee, "vanilla");
        System.out.printf("%-40s $%.2f%n", coffee.getDescription(), coffee.getCost());

        // 2. Text transformer
        System.out.println("\n=== Text Transformer ===");
        TextTransformer transformer = new LoggingDecorator(
            new UpperCaseDecorator(
                new TrimDecorator(
                    new IdentityTransformer()
                )
            )
        );
        String result = transformer.transform("  hello world  ");
        System.out.println("Final: " + result);

        // 3. Function decorator
        System.out.println("\n=== Function Decorator ===");
        Function<Integer, Integer> compute = n -> n * n + 2 * n + 1;
        Function<Integer, Integer> logged = withLogging(compute, "compute");
        Function<Integer, Integer> timed  = withTiming(logged);
        System.out.println("Result: " + timed.apply(5));

        // 4. I/O decorator
        System.out.println("\n=== I/O Decorator ===");
        DataSource source = new CompressionDecorator(
            new EncryptionDecorator(
                new FileDataSource()
            )
        );
        source.writeData("Hello, World!");
        String read = source.readData();
        System.out.println("Read back: " + read);

        System.out.println("\n=== Decorator Summary ===");
        System.out.println("Same interface as component — transparent wrapping");
        System.out.println("Chain decorators dynamically at runtime");
        System.out.println("Alternative to subclassing (no class explosion)");
        System.out.println("Java example: BufferedInputStream wraps InputStream");
    }
}
