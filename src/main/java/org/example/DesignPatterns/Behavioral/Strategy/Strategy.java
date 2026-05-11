package org.example.DesignPatterns.Behavioral.Strategy;

import java.util.*;
import java.util.function.*;

/**
 * ============================================================
 *           STRATEGY PATTERN — COMPLETE GUIDE
 * ============================================================
 *
 * INTENT: Define a family of algorithms, encapsulate each one,
 * and make them interchangeable. Strategy lets the algorithm
 * vary independently from clients that use it.
 *
 * COMPONENTS:
 * -----------
 *   Context   → uses a strategy, delegates behavior to it
 *   Strategy  → interface for algorithms
 *   ConcreteStrategy → specific implementation
 *
 * IN MODERN JAVA:
 * ---------------
 *   With lambdas, Strategy is often just a Function/Comparator.
 *   Still useful for complex strategies with multiple methods.
 *
 * USE WHEN:
 * ---------
 *   - Multiple related classes differ only in behavior
 *   - Need different variants of an algorithm
 *   - Want to avoid conditional logic (switch/if-else)
 *
 * ============================================================
 */
public class Strategy {

    // ── 1. Classic Strategy — Sort Algorithm ──────────────────
    interface SortStrategy {
        void sort(int[] arr);
        String name();
    }

    static class BubbleSort implements SortStrategy {
        @Override
        public void sort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n-1; i++)
                for (int j = 0; j < n-i-1; j++)
                    if (arr[j] > arr[j+1]) { int t=arr[j]; arr[j]=arr[j+1]; arr[j+1]=t; }
        }
        @Override public String name() { return "BubbleSort"; }
    }

    static class QuickSort implements SortStrategy {
        @Override
        public void sort(int[] arr) { quickSort(arr, 0, arr.length-1); }
        private void quickSort(int[] a, int lo, int hi) {
            if (lo >= hi) return;
            int p = partition(a, lo, hi);
            quickSort(a, lo, p-1);
            quickSort(a, p+1, hi);
        }
        private int partition(int[] a, int lo, int hi) {
            int pivot = a[hi], i = lo-1;
            for (int j = lo; j < hi; j++) if (a[j] <= pivot) { i++; int t=a[i];a[i]=a[j];a[j]=t; }
            int t=a[i+1]; a[i+1]=a[hi]; a[hi]=t;
            return i+1;
        }
        @Override public String name() { return "QuickSort"; }
    }

    static class Sorter {
        private SortStrategy strategy;

        Sorter(SortStrategy strategy) { this.strategy = strategy; }
        void setStrategy(SortStrategy s) { this.strategy = s; }

        int[] sort(int[] arr) {
            int[] copy = arr.clone();
            long start = System.nanoTime();
            strategy.sort(copy);
            long time = System.nanoTime() - start;
            System.out.printf("  %s: %d ns%n", strategy.name(), time);
            return copy;
        }
    }

    // ── 2. Payment Strategy ───────────────────────────────────
    interface PaymentStrategy {
        boolean pay(double amount);
        String getMethodName();
    }

    static class CreditCard implements PaymentStrategy {
        private final String cardNumber;
        private double balance;

        CreditCard(String number, double balance) { this.cardNumber=number; this.balance=balance; }

        @Override
        public boolean pay(double amount) {
            if (balance >= amount) { balance -= amount; return true; }
            System.out.println("Credit card declined: insufficient limit");
            return false;
        }
        @Override public String getMethodName() { return "Credit Card ***" + cardNumber.substring(cardNumber.length()-4); }
    }

    static class PayPal implements PaymentStrategy {
        private final String email;

        PayPal(String email) { this.email = email; }

        @Override
        public boolean pay(double amount) {
            System.out.println("Charging PayPal account: " + email);
            return true; // simplified
        }
        @Override public String getMethodName() { return "PayPal: " + email; }
    }

    static class Crypto implements PaymentStrategy {
        private final String wallet;

        Crypto(String wallet) { this.wallet = wallet; }

        @Override
        public boolean pay(double amount) {
            System.out.println("Sending crypto to wallet: " + wallet);
            return true;
        }
        @Override public String getMethodName() { return "Crypto: " + wallet; }
    }

    static class ShoppingCart {
        private final List<double[]> items = new ArrayList<>(); // [price, qty]
        private PaymentStrategy paymentMethod;

        void addItem(double price, int qty) { items.add(new double[]{price, qty}); }
        void setPaymentMethod(PaymentStrategy s) { this.paymentMethod = s; }

        boolean checkout() {
            double total = items.stream().mapToDouble(i -> i[0] * i[1]).sum();
            System.out.printf("Total: $%.2f — Paying via %s%n", total, paymentMethod.getMethodName());
            return paymentMethod.pay(total);
        }
    }

    // ── 3. Lambda-based strategy (modern Java) ─────────────────
    static class DataProcessor {
        private final Function<List<Integer>, List<Integer>> filterStrategy;
        private final Function<List<Integer>, List<Integer>> sortStrategy;
        private final Function<List<Integer>, String> formatStrategy;

        DataProcessor(
            Function<List<Integer>, List<Integer>> filter,
            Function<List<Integer>, List<Integer>> sort,
            Function<List<Integer>, String> format
        ) {
            this.filterStrategy = filter;
            this.sortStrategy   = sort;
            this.formatStrategy = format;
        }

        String process(List<Integer> data) {
            return filterStrategy.andThen(sortStrategy).andThen(formatStrategy).apply(data);
        }
    }

    public static void main(String[] args) {
        // 1. Sort strategy
        System.out.println("=== Sort Strategy ===");
        int[] data = {64, 25, 12, 22, 11, 90, 45};
        Sorter sorter = new Sorter(new BubbleSort());
        System.out.println("Data: " + Arrays.toString(data));
        int[] r1 = sorter.sort(data);
        System.out.println("Sorted: " + Arrays.toString(r1));

        sorter.setStrategy(new QuickSort()); // switch strategy at runtime
        int[] r2 = sorter.sort(data);
        System.out.println("Sorted: " + Arrays.toString(r2));

        // 2. Payment strategy
        System.out.println("\n=== Payment Strategy ===");
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(29.99, 2);
        cart.addItem(9.99, 1);

        cart.setPaymentMethod(new CreditCard("1234567890123456", 100));
        cart.checkout();

        cart.setPaymentMethod(new PayPal("alice@example.com"));
        cart.checkout();

        cart.setPaymentMethod(new Crypto("0xABC123"));
        cart.checkout();

        // 3. Lambda strategies
        System.out.println("\n=== Lambda Strategy ===");
        List<Integer> nums = Arrays.asList(5, -2, 8, -1, 3, -7, 4);

        DataProcessor positivesSorted = new DataProcessor(
            list -> list.stream().filter(n -> n > 0).collect(java.util.stream.Collectors.toList()),
            list -> { List<Integer> sorted = new ArrayList<>(list); Collections.sort(sorted); return sorted; },
            list -> "Positives sorted: " + list
        );
        System.out.println(positivesSorted.process(nums));

        DataProcessor negativesReversed = new DataProcessor(
            list -> list.stream().filter(n -> n < 0).collect(java.util.stream.Collectors.toList()),
            list -> { List<Integer> sorted = new ArrayList<>(list); sorted.sort(Comparator.reverseOrder()); return sorted; },
            list -> "Negatives reversed: " + list
        );
        System.out.println(negativesReversed.process(nums));

        System.out.println("\n=== Strategy Summary ===");
        System.out.println("Strategy interface → algorithm contract");
        System.out.println("Context uses strategy → delegates behavior");
        System.out.println("Swap strategies at runtime");
        System.out.println("Modern Java: lambdas replace simple strategies");
        System.out.println("Replaces if-else/switch for algorithm selection");
    }
}
