package org.example.Generics.GenericClasses;

import java.util.*;
import java.util.function.*;

/**
 * ============================================================
 *         JAVA GENERICS — COMPLETE GUIDE
 * ============================================================
 *
 * GENERICS: Write code that works with ANY type while maintaining
 * compile-time type safety. "Parameterized types."
 *
 * WHY GENERICS?
 * -------------
 *   Without: Object container → runtime ClassCastException
 *   With:    Type-safe container → compile-time error
 *
 * SYNTAX:
 * -------
 *   class Box<T>         → generic class
 *   <T> void method(T t) → generic method
 *   Box<Integer>         → parameterized type
 *   Box<?>               → wildcard (unknown type)
 *
 * TYPE PARAMETERS (convention):
 * ------------------------------
 *   T — Type
 *   E — Element
 *   K — Key
 *   V — Value
 *   N — Number
 *   R — Result/Return
 *
 * TYPE ERASURE:
 * -------------
 *   Generics are compile-time only!
 *   At runtime, Box<Integer> and Box<String> are just Box.
 *   Cannot: new T(), instanceof T, T.class, T[] (directly)
 *
 * BOUNDED TYPE PARAMETERS:
 * ------------------------
 *   <T extends Number>    → T must be Number or subclass
 *   <T extends Comparable<T>> → T must implement Comparable
 *   <T extends A & B & C> → multiple bounds
 *
 * WILDCARDS:
 * ----------
 *   <?>           → unknown type
 *   <? extends T> → upper bound (read-only typically)
 *   <? super T>   → lower bound (write-only typically)
 *   PECS: Producer extends, Consumer super
 *
 * ============================================================
 */
public class GenericClasses {

    // ── 1. Simple generic class ───────────────────────────────
    static class Box<T> {
        private T value;

        Box(T value)  { this.value = value; }
        T get()       { return value; }
        void set(T v) { value = v; }

        boolean isEmpty()  { return value == null; }

        // Generic method within generic class
        <R> Box<R> map(Function<T, R> fn) {
            return new Box<>(fn.apply(value));
        }

        @Override
        public String toString() { return "Box[" + value + "]"; }
    }

    // ── 2. Generic class with multiple type params ─────────────
    static class Pair<A, B> {
        private final A first;
        private final B second;

        Pair(A first, B second) { this.first = first; this.second = second; }

        A getFirst()  { return first; }
        B getSecond() { return second; }

        Pair<B, A> swap() { return new Pair<>(second, first); }

        @Override
        public String toString() { return "(" + first + ", " + second + ")"; }

        static <X, Y> Pair<X, Y> of(X x, Y y) { return new Pair<>(x, y); }
    }

    // ── 3. Bounded type parameter ─────────────────────────────
    static class NumberBox<N extends Number> {
        private N value;

        NumberBox(N value) { this.value = value; }

        double doubleValue() { return value.doubleValue(); } // Number method
        N getValue() { return value; }

        // Can compare since N extends Number
        boolean isGreaterThan(N other) {
            return value.doubleValue() > other.doubleValue();
        }
    }

    // ── 4. Generic stack ─────────────────────────────────────
    static class Stack<E> {
        private final Object[] elements;
        private int size;

        @SuppressWarnings("unchecked")
        Stack(int capacity) { elements = new Object[capacity]; }

        void push(E element) {
            if (size == elements.length) throw new RuntimeException("Stack full");
            elements[size++] = element;
        }

        @SuppressWarnings("unchecked")
        E pop() {
            if (size == 0) throw new RuntimeException("Stack empty");
            E result = (E) elements[--size];
            elements[size] = null; // prevent memory leak
            return result;
        }

        @SuppressWarnings("unchecked")
        E peek() {
            if (size == 0) throw new RuntimeException("Stack empty");
            return (E) elements[size - 1];
        }

        boolean isEmpty() { return size == 0; }
        int size()        { return size; }
    }

    // ── 5. Generic interface ───────────────────────────────────
    interface Repository<T, ID> {
        void save(T entity);
        Optional<T> findById(ID id);
        List<T> findAll();
        void delete(ID id);
    }

    static class InMemoryRepository<T> implements Repository<T, Integer> {
        private Map<Integer, T> store = new HashMap<>();
        private int nextId = 1;

        @Override public void save(T entity) { store.put(nextId++, entity); }
        @Override public Optional<T> findById(Integer id) { return Optional.ofNullable(store.get(id)); }
        @Override public List<T> findAll() { return new ArrayList<>(store.values()); }
        @Override public void delete(Integer id) { store.remove(id); }
    }

    // ── 6. Generic method (standalone) ────────────────────────
    static <T extends Comparable<T>> T max(T a, T b, T c) {
        T m = a.compareTo(b) >= 0 ? a : b;
        return m.compareTo(c) >= 0 ? m : c;
    }

    static <T> List<T> repeat(T element, int times) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < times; i++) result.add(element);
        return result;
    }

    static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }

    public static void main(String[] args) {
        // 1. Box
        Box<String> strBox = new Box<>("hello");
        Box<Integer> intBox = new Box<>(42);
        System.out.println("String box: " + strBox);
        System.out.println("Int box: " + intBox);

        Box<Integer> lenBox = strBox.map(String::length);
        System.out.println("Mapped to length: " + lenBox); // Box[5]

        // 2. Pair
        Pair<String, Integer> pair = Pair.of("Alice", 30);
        System.out.println("Pair: " + pair);
        System.out.println("Swapped: " + pair.swap()); // (30, Alice)

        // 3. NumberBox
        NumberBox<Integer> intNum = new NumberBox<>(42);
        NumberBox<Double>  dblNum = new NumberBox<>(3.14);
        System.out.println("double value: " + intNum.doubleValue()); // 42.0
        System.out.println("isGreater(40): " + intNum.isGreaterThan(40)); // true

        // 4. Generic Stack
        Stack<String> stack = new Stack<>(10);
        stack.push("first"); stack.push("second"); stack.push("third");
        System.out.println("Stack peek: " + stack.peek()); // third
        while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
        System.out.println();

        // 5. Generic Repository
        InMemoryRepository<String> repo = new InMemoryRepository<>();
        repo.save("Alice"); repo.save("Bob"); repo.save("Carol");
        System.out.println("All: " + repo.findAll());
        System.out.println("ID 2: " + repo.findById(2));
        repo.delete(2);
        System.out.println("After delete: " + repo.findAll());

        // 6. Generic methods
        System.out.println("max(3,7,5): " + max(3, 7, 5));         // 7
        System.out.println("max('a','c','b'): " + max("a","c","b")); // c
        System.out.println("repeat('x',4): " + repeat("x", 4));    // [x,x,x,x]
        Integer[] arr = {1, 2, 3, 4};
        swap(arr, 0, 3);
        System.out.println("After swap: " + Arrays.toString(arr)); // [4,2,3,1]

        System.out.println("\n=== Generics Quick Reference ===");
        System.out.println("class Box<T>          → parameterize the class");
        System.out.println("<T> R method(T t)     → generic method");
        System.out.println("<T extends Number>    → upper bound");
        System.out.println("List<? extends T>     → wildcard upper bound (read)");
        System.out.println("List<? super T>       → wildcard lower bound (write)");
        System.out.println("Type erasure: generics removed at runtime");
        System.out.println("Cannot: new T(), T.class, instanceof Box<String>");
    }
}
