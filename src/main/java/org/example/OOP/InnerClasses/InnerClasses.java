package org.example.OOP.InnerClasses;

import java.util.*;

/**
 * ============================================================
 *        JAVA INNER CLASSES — COMPLETE GUIDE
 * ============================================================
 *
 * FOUR TYPES:
 * -----------
 *   1. Member Inner Class      — non-static, has access to outer fields
 *   2. Static Nested Class     — static, no access to outer instance
 *   3. Local Class             — defined inside a method
 *   4. Anonymous Class         — one-time use, no name
 *
 * WHEN TO USE:
 * ------------
 *   Member inner    → helper class tightly coupled to outer state
 *   Static nested   → logically grouped, but independent (most common)
 *   Local class     → complex helper within a method
 *   Anonymous class → one-time interface/abstract implementation
 *
 * ACCESS RULES:
 * -------------
 *   Member inner    → can access private members of outer class
 *   Static nested   → cannot access outer instance (only static)
 *   Anonymous class → can capture final/effectively-final local vars
 *
 * KEY SYNTAX:
 * -----------
 *   Outer.Inner obj = outer.new Inner();   // member inner
 *   Outer.Nested obj = new Outer.Nested(); // static nested
 *
 * ============================================================
 */
public class InnerClasses {

    // ── 1. Member inner class ─────────────────────────────────
    static class LinkedList {
        private Node head;
        private int size;

        // Member inner class — has access to LinkedList's private members
        class Node {          // non-static inner class
            int data;
            Node next;
            Node(int data) { this.data = data; }
            // Can access outer: LinkedList.this.size
        }

        void add(int data) {
            Node n = new Node(data); // inner class instantiation
            if (head == null) { head = n; }
            else {
                Node cur = head;
                while (cur.next != null) cur = cur.next;
                cur.next = n;
            }
            size++;
        }

        int getSize() { return size; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            Node cur = head;
            while (cur != null) { sb.append(cur.data).append(cur.next!=null?",":""); cur=cur.next; }
            return sb.append("]").toString();
        }
    }

    // ── 2. Static nested class ────────────────────────────────
    static class Graph {
        private int vertices;
        private List<Edge> edges = new ArrayList<>();

        Graph(int v) { this.vertices = v; }

        // Static nested — doesn't need Graph instance to create
        static class Edge {
            final int from, to, weight;
            Edge(int from, int to, int weight) {
                this.from = from; this.to = to; this.weight = weight;
            }
            @Override public String toString() {
                return from + "->" + to + "(" + weight + ")";
            }
        }

        void addEdge(int from, int to, int weight) {
            edges.add(new Edge(from, to, weight)); // or Graph.Edge
        }

        List<Edge> getEdges() { return Collections.unmodifiableList(edges); }
    }

    // ── 3. Builder pattern — most common static nested use ────
    static class HttpRequest {
        private final String method;
        private final String url;
        private final Map<String, String> headers;
        private final String body;
        private final int timeout;

        private HttpRequest(Builder b) {
            method  = b.method;
            url     = b.url;
            headers = Collections.unmodifiableMap(new HashMap<>(b.headers));
            body    = b.body;
            timeout = b.timeout;
        }

        static class Builder {
            private String method = "GET";
            private String url;
            private Map<String, String> headers = new HashMap<>();
            private String body;
            private int timeout = 30;

            Builder(String url) { this.url = url; }
            Builder method(String m)              { method = m; return this; }
            Builder header(String k, String v)    { headers.put(k,v); return this; }
            Builder body(String b)                { body = b; return this; }
            Builder timeout(int t)                { timeout = t; return this; }
            HttpRequest build()                   { return new HttpRequest(this); }
        }

        @Override public String toString() {
            return method + " " + url + " headers=" + headers + " timeout=" + timeout;
        }
    }

    // ── 4. Local class ────────────────────────────────────────
    static List<Integer> filterAndTransform(List<Integer> nums, int threshold) {
        // Local class — defined inside method
        class Processor {
            boolean accept(int n) { return n > threshold; }
            int transform(int n)  { return n * 2; }
        }

        Processor p = new Processor();
        List<Integer> result = new ArrayList<>();
        for (int n : nums)
            if (p.accept(n)) result.add(p.transform(n));
        return result;
    }

    // ── 5. Anonymous class ────────────────────────────────────
    interface Greeting {
        String greet(String name);
    }

    static Greeting getGreeting(String language) {
        switch (language) {
            case "English":
                return new Greeting() {          // anonymous class
                    @Override
                    public String greet(String n) { return "Hello, " + n + "!"; }
                };
            case "Spanish":
                return name -> "¡Hola, " + name + "!"; // lambda (shorthand)
            case "French":
                return name -> "Bonjour, " + name + "!";
            default:
                return name -> "Hi, " + name + "!";
        }
    }

    // ── 6. Comparator via anonymous class (pre-lambda style) ──
    static <T extends Comparable<T>> void sortDescending(List<T> list) {
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T a, T b) { return b.compareTo(a); } // reversed
        });
    }

    public static void main(String[] args) {
        // 1. Member inner class
        LinkedList list = new LinkedList();
        list.add(1); list.add(2); list.add(3);
        System.out.println("Linked list: " + list + " size=" + list.getSize());

        // 2. Static nested
        Graph g = new Graph(4);
        g.addEdge(0, 1, 5);
        g.addEdge(1, 2, 3);
        g.addEdge(2, 3, 7);
        System.out.println("Edges: " + g.getEdges());

        // Static nested can be used independently:
        Graph.Edge e = new Graph.Edge(0, 3, 10); // no Graph instance needed
        System.out.println("Direct edge: " + e);

        // 3. Builder (static nested)
        HttpRequest req = new HttpRequest.Builder("https://api.example.com/data")
                .method("POST")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer token123")
                .body("{\"key\":\"value\"}")
                .timeout(60)
                .build();
        System.out.println("Request: " + req);

        // 4. Local class
        List<Integer> nums = Arrays.asList(1, 5, 2, 8, 3, 9, 4);
        List<Integer> result = filterAndTransform(nums, 4);
        System.out.println("Filtered & doubled (>4): " + result);

        // 5. Anonymous class
        String[] langs = {"English", "Spanish", "French"};
        for (String lang : langs) {
            Greeting g2 = getGreeting(lang);
            System.out.println(g2.greet("Alice"));
        }

        // 6. Sort descending with anonymous Comparator
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6));
        sortDescending(numbers);
        System.out.println("Sorted desc: " + numbers);

        System.out.println("\n=== Inner Classes Summary ===");
        System.out.println("Member inner   → outer.new Inner(), accesses outer state");
        System.out.println("Static nested  → new Outer.Nested(), no outer instance needed");
        System.out.println("Local class    → inside method, captures effectively-final vars");
        System.out.println("Anonymous class→ implements interface/extends class inline");
        System.out.println("Lambda         → shorthand for single-method anonymous class");
        System.out.println("Builder pattern→ most common use of static nested class");
    }
}
