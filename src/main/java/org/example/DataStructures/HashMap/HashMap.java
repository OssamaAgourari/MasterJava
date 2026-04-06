package org.example.DataStructures.HashMap;

import java.util.*;

/**
 * ============================================================
 *               HASH MAP — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS A HASH MAP?
 * --------------------
 * A data structure that maps KEYS to VALUES using a HASH FUNCTION.
 * The hash function converts a key to an array index.
 *
 * INTERNALS:
 * -----------
 *   1. Array of "buckets" (slots)
 *   2. hash(key) % capacity → bucket index
 *   3. Collision handling:
 *      - Chaining     : each bucket holds a linked list
 *      - Open Addressing: probe to next empty slot
 *
 *   Java's HashMap uses CHAINING (each bucket = linked list / tree).
 *   When bucket length > 8: linked list converts to Red-Black Tree.
 *
 * TIME COMPLEXITY:
 * -----------------
 *   Operation | Avg  | Worst (all keys collide)
 *   ----------|------|-------------------------
 *   get(key)  | O(1) | O(n)
 *   put(key)  | O(1) | O(n)
 *   remove    | O(1) | O(n)
 *   contains  | O(1) | O(n)
 *   iterate   | O(n) | O(n)
 *
 * SPACE: O(n)
 *
 * LOAD FACTOR:
 * -------------
 *   Java default: 0.75 (75% full → resize/rehash)
 *   Resize doubles the capacity and rehashes all keys.
 *
 * JAVA IMPLEMENTATIONS:
 * ----------------------
 *   HashMap<K,V>        — unordered, allows null key/value, NOT thread-safe
 *   LinkedHashMap<K,V>  — insertion-order maintained
 *   TreeMap<K,V>        — sorted by key, O(log n) ops
 *   Hashtable<K,V>      — legacy, synchronized, no null
 *   ConcurrentHashMap   — thread-safe HashMap
 *
 * COMMON PATTERNS:
 * -----------------
 *   Frequency count     — map.getOrDefault(k, 0) + 1
 *   Two-sum             — store seen values
 *   Grouping            — map.computeIfAbsent(k, v->new ArrayList<>())
 *   Sliding window      — map of char counts
 *   Memoization         — cache recursive results
 *
 * ============================================================
 */
public class HashMap {

    // ─── Custom HashMap (chaining) ────────────────────────────
    static class CustomHashMap<K, V> {
        private static final int CAPACITY = 16;
        private LinkedList<Entry<K,V>>[] table;
        private int size;

        @SuppressWarnings("unchecked")
        CustomHashMap() { table = new LinkedList[CAPACITY]; }

        static class Entry<K,V> {
            K key; V val;
            Entry(K k, V v) { key=k; val=v; }
        }

        private int hash(K key) { return (key.hashCode() & 0x7FFFFFFF) % CAPACITY; }

        void put(K key, V value) {
            int idx = hash(key);
            if (table[idx] == null) table[idx] = new LinkedList<>();
            for (Entry<K,V> e : table[idx]) {
                if (e.key.equals(key)) { e.val = value; return; }
            }
            table[idx].add(new Entry<>(key, value));
            size++;
        }

        V get(K key) {
            for (Entry<K,V> e : getOrEmpty(hash(key)))
                if (e.key.equals(key)) return e.val;
            return null;
        }

        boolean containsKey(K key) { return get(key) != null; }

        void remove(K key) {
            int idx = hash(key);
            if (table[idx] == null) return;
            table[idx].removeIf(e -> e.key.equals(key));
            size--;
        }

        private LinkedList<Entry<K,V>> getOrEmpty(int idx) {
            return table[idx] != null ? table[idx] : new LinkedList<>();
        }

        int size() { return size; }
    }

    public static void main(String[] args) {

        // EXERCISE 1: Java HashMap basics
        java.util.HashMap<String, Integer> map = new java.util.HashMap<>();
        map.put("apple",  3);
        map.put("banana", 1);
        map.put("cherry", 5);
        System.out.println("Map: " + map);
        System.out.println("get(apple): "  + map.get("apple"));    // 3
        System.out.println("get(grape): "  + map.get("grape"));    // null
        System.out.println("contains(banana): " + map.containsKey("banana")); // true
        map.remove("banana");
        System.out.println("After remove(banana): " + map);

        // EXERCISE 2: getOrDefault — avoid null checks
        java.util.HashMap<String,Integer> freq = new java.util.HashMap<>();
        for (String word : "the cat sat on the mat the cat".split(" ")) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        System.out.println("Word frequency: " + freq);
        // {the=3, cat=2, sat=1, on=1, mat=1}

        // EXERCISE 3: putIfAbsent, computeIfAbsent
        java.util.HashMap<String, List<Integer>> groups = new java.util.HashMap<>();
        String[] words = {"eat","tea","tan","ate","nat","bat"};
        for (String w : words) {
            char[] chars = w.toCharArray(); Arrays.sort(chars);
            String key = new String(chars);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(Integer.valueOf(w));
        }
        System.out.println("Anagram groups: " + groups);

        // EXERCISE 4: Iterate entries, keys, values
        System.out.println("Iterating entries:");
        for (Map.Entry<String,Integer> e : freq.entrySet())
            System.out.println("  " + e.getKey() + " → " + e.getValue());

        // EXERCISE 5: Merge (add counts)
        freq.merge("cat", 10, Integer::sum); // cat = 2+10 = 12
        System.out.println("After merge cat+10: " + freq.get("cat")); // 12

        // EXERCISE 6: Two Sum using HashMap — O(n)
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum(nums, 9);
        System.out.println("Two sum [0,1]: " + Arrays.toString(result)); // [0, 1]

        // EXERCISE 7: LinkedHashMap — insertion order
        java.util.LinkedHashMap<String,Integer> linked = new java.util.LinkedHashMap<>();
        linked.put("c", 3); linked.put("a", 1); linked.put("b", 2);
        System.out.println("LinkedHashMap (insertion order): " + linked);
        // {c=3, a=1, b=2}

        // EXERCISE 8: LinkedHashMap as LRU (access-order mode)
        java.util.LinkedHashMap<Integer,Integer> lru =
                new java.util.LinkedHashMap<>(16, 0.75f, true) {
                    @Override
                    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> e) {
                        return size() > 3;  // capacity 3
                    }
                };
        lru.put(1,1); lru.put(2,2); lru.put(3,3);
        lru.get(1);   // access 1 → moves to end
        lru.put(4,4); // evicts 2 (least recently used)
        System.out.println("LRU after access(1) then put(4): " + lru.keySet()); // [3, 1, 4]

        // EXERCISE 9: TreeMap — sorted keys
        TreeMap<String,Integer> sorted = new TreeMap<>();
        sorted.put("banana",2); sorted.put("apple",1); sorted.put("cherry",3);
        System.out.println("TreeMap (sorted): " + sorted);
        System.out.println("firstKey: " + sorted.firstKey()); // apple
        System.out.println("lastKey:  " + sorted.lastKey());  // cherry

        // EXERCISE 10: Custom HashMap test
        CustomHashMap<String,Integer> custom = new CustomHashMap<>();
        custom.put("x", 10); custom.put("y", 20); custom.put("x", 99);
        System.out.println("custom get(x): " + custom.get("x")); // 99 (overwritten)
        System.out.println("custom get(y): " + custom.get("y")); // 20
        System.out.println("custom size:   " + custom.size());   // 2

        // SUMMARY
        System.out.println("\n=== HashMap Complexity ===");
        System.out.println("get/put/remove  O(1) avg, O(n) worst");
        System.out.println("Iteration       O(n)");
        System.out.println("HashMap vs LinkedHashMap vs TreeMap:");
        System.out.println("  HashMap      O(1)     unordered");
        System.out.println("  LinkedHashMap O(1)    insertion-order");
        System.out.println("  TreeMap      O(log n) sorted keys");
    }

    static int[] twoSum(int[] nums, int target) {
        java.util.HashMap<Integer,Integer> seen = new java.util.HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (seen.containsKey(comp)) return new int[]{seen.get(comp), i};
            seen.put(nums[i], i);
        }
        return new int[]{};
    }
}
