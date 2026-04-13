package org.example.Collections.Maps;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================
 *          JAVA MAPS — COMPLETE GUIDE
 * ============================================================
 *
 * Map: Key-value pairs. Keys are unique.
 *
 * MAIN IMPLEMENTATIONS:
 * ┌─────────────────┬─────────────────────────────────────────────────┐
 * │  HashMap        │ Hash table — O(1) avg get/put — unordered        │
 * │  LinkedHashMap  │ HashMap + insertion order — O(1) avg             │
 * │  TreeMap        │ Red-black BST — O(log n) — sorted by key         │
 * │  EnumMap        │ Array-backed for enum keys — very fast           │
 * │  Hashtable      │ Legacy synchronized (avoid)                      │
 * │  ConcurrentHashMap │ Thread-safe HashMap                           │
 * └─────────────────┴─────────────────────────────────────────────────┘
 *
 * PERFORMANCE:
 * ------------
 *              HashMap    TreeMap     LinkedHashMap
 *   get/put    O(1) avg   O(log n)    O(1) avg
 *   iteration  random     sorted      insertion order
 *   null key   1 allowed  NO          1 allowed
 *
 * COMMON METHODS:
 * ---------------
 *   put(k,v)           → add/overwrite
 *   get(k)             → value or null
 *   getOrDefault(k,d)  → value or default (Java 8+)
 *   putIfAbsent(k,v)   → put only if key absent
 *   containsKey(k)     → boolean
 *   containsValue(v)   → boolean O(n)
 *   remove(k)          → remove entry
 *   keySet()           → Set<K>
 *   values()           → Collection<V>
 *   entrySet()         → Set<Map.Entry<K,V>>
 *   merge(k,v,fn)      → merge with existing value
 *   compute(k,fn)      → compute new value
 *   forEach((k,v)->{}) → iterate
 *
 * ============================================================
 */
public class Maps {

    // ── 1. HashMap basics ─────────────────────────────────────
    static void hashMapBasics() {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob", 87);
        scores.put("Carol", 92);
        scores.put("Alice", 98); // overwrite

        System.out.println("Alice: " + scores.get("Alice")); // 98
        System.out.println("Dave: " + scores.get("Dave"));   // null
        System.out.println("Dave default: " + scores.getOrDefault("Dave", 0)); // 0
        System.out.println("Has Bob: " + scores.containsKey("Bob")); // true
        System.out.println("Size: " + scores.size()); // 3

        // Iterate entrySet (most efficient)
        for (Map.Entry<String, Integer> e : scores.entrySet())
            System.out.println("  " + e.getKey() + " → " + e.getValue());
    }

    // ── 2. Frequency count — most common use ─────────────────
    static Map<Character, Integer> charFrequency(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray())
            freq.merge(c, 1, Integer::sum); // elegant Java 8 way
        return freq;
    }

    // ── 3. LinkedHashMap — maintain insertion order ───────────
    static void linkedHashMapDemo() {
        Map<String, Integer> ordered = new LinkedHashMap<>();
        ordered.put("banana", 2);
        ordered.put("apple", 5);
        ordered.put("cherry", 1);

        System.out.println("Insertion order: " + ordered.keySet()); // banana, apple, cherry

        // LRU Cache via LinkedHashMap
        Map<Integer, Integer> lruCache = new LinkedHashMap<>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
                return size() > 3; // max 3 entries
            }
        };
        lruCache.put(1, 10); lruCache.put(2, 20); lruCache.put(3, 30);
        lruCache.get(1); // access 1 (now most recently used)
        lruCache.put(4, 40); // evicts key 2 (LRU)
        System.out.println("LRU cache: " + lruCache.keySet()); // [3, 1, 4]
    }

    // ── 4. TreeMap — sorted by key ────────────────────────────
    static void treeMapDemo() {
        TreeMap<String, Integer> sorted = new TreeMap<>();
        sorted.put("banana", 2);
        sorted.put("apple", 5);
        sorted.put("cherry", 1);
        sorted.put("date", 8);

        System.out.println("Sorted keys: " + sorted.keySet()); // alpha sorted
        System.out.println("firstKey: " + sorted.firstKey());  // apple
        System.out.println("lastKey:  " + sorted.lastKey());   // date
        System.out.println("floorKey(c): " + sorted.floorKey("c"));  // cherry
        System.out.println("ceilingKey(b): " + sorted.ceilingKey("b")); // banana
        System.out.println("headMap(c): " + sorted.headMap("c").keySet()); // [apple, banana]
        System.out.println("tailMap(c): " + sorted.tailMap("c").keySet()); // [cherry, date]
    }

    // ── 5. Compute, merge, computeIfAbsent ────────────────────
    static void advancedOps() {
        Map<String, List<Integer>> groups = new HashMap<>();

        // computeIfAbsent — perfect for grouping
        String[] words = {"cat", "act", "apple", "ant", "tac"};
        for (String w : words) {
            String key = sortChars(w);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(w.length());
        }
        System.out.println("Groups: " + groups);

        // compute — update based on existing value
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("apples", 10);
        inventory.compute("apples", (k, v) -> v == null ? 1 : v + 5);
        inventory.compute("bananas", (k, v) -> v == null ? 1 : v + 5);
        System.out.println("Inventory: " + inventory);

        // merge
        Map<String, Integer> votes = new HashMap<>();
        String[] ballots = {"Alice", "Bob", "Alice", "Carol", "Bob", "Alice"};
        for (String name : ballots)
            votes.merge(name, 1, Integer::sum);
        System.out.println("Votes: " + votes);
    }

    static String sortChars(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    // ── 6. Map with stream operations ─────────────────────────
    static Map<String, Long> wordCount(String text) {
        return Arrays.stream(text.toLowerCase().split("\\s+"))
                     .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
    }

    // ── 7. Invert a map ───────────────────────────────────────
    static <K, V> Map<V, K> invertMap(Map<K, V> original) {
        Map<V, K> inverted = new HashMap<>();
        original.forEach((k, v) -> inverted.put(v, k));
        return inverted;
    }

    public static void main(String[] args) {
        System.out.println("=== HashMap Basics ===");
        hashMapBasics();

        System.out.println("\n=== Char Frequency ===");
        System.out.println(charFrequency("abracadabra"));

        System.out.println("\n=== LinkedHashMap ===");
        linkedHashMapDemo();

        System.out.println("\n=== TreeMap ===");
        treeMapDemo();

        System.out.println("\n=== Advanced Ops ===");
        advancedOps();

        System.out.println("\n=== Word Count ===");
        Map<String, Long> wc = wordCount("the cat sat on the mat the cat");
        System.out.println(new TreeMap<>(wc)); // sorted for display

        System.out.println("\n=== Invert Map ===");
        Map<String, Integer> original = Map.of("a", 1, "b", 2, "c", 3);
        System.out.println("Inverted: " + invertMap(original));

        System.out.println("\n=== Complexity Summary ===");
        System.out.println("HashMap:        get/put O(1) avg, O(n) worst");
        System.out.println("LinkedHashMap:  get/put O(1), keeps insertion order");
        System.out.println("TreeMap:        get/put O(log n), sorted keys");
        System.out.println("Use HashMap for performance, TreeMap when sorted needed");
    }
}
