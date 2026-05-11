package org.example.Collections.Sets;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================
 *            JAVA SETS — COMPLETE GUIDE
 * ============================================================
 *
 * Set: Collection of UNIQUE elements. No duplicates.
 *
 * MAIN IMPLEMENTATIONS:
 * ┌─────────────────┬──────────────────────────────────────────┐
 * │  HashSet        │ Hash table — O(1) avg add/remove/contains │
 * │                 │ Unordered, allows one null               │
 * │  LinkedHashSet  │ HashSet + insertion order               │
 * │  TreeSet        │ Red-black BST — O(log n) — sorted       │
 * │  EnumSet        │ Bit vector for enums — very fast        │
 * └─────────────────┴──────────────────────────────────────────┘
 *
 * PERFORMANCE:
 * ------------
 *              HashSet    TreeSet     LinkedHashSet
 *   add        O(1) avg   O(log n)    O(1) avg
 *   remove     O(1) avg   O(log n)    O(1) avg
 *   contains   O(1) avg   O(log n)    O(1) avg
 *   order      random     sorted      insertion
 *
 * KEY SET OPERATIONS:
 * -------------------
 *   union        → setA.addAll(setB)
 *   intersection → setA.retainAll(setB)
 *   difference   → setA.removeAll(setB)
 *   subset?      → setA.containsAll(setB)
 *
 * ============================================================
 */
public class Sets {

    // ── 1. HashSet basics ─────────────────────────────────────
    static void hashSetBasics() {
        Set<String> fruits = new HashSet<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");
        fruits.add("apple"); // duplicate — ignored

        System.out.println("Size: " + fruits.size());        // 3
        System.out.println("Has apple: " + fruits.contains("apple")); // true
        fruits.remove("banana");
        System.out.println("After remove: " + fruits);        // [cherry,apple] (unordered)

        // Iterate
        for (String f : fruits) System.out.print(f + " ");
        System.out.println();
    }

    // ── 2. Set operations ─────────────────────────────────────
    static void setOperations() {
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> b = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7));

        // Union
        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        System.out.println("Union: " + new TreeSet<>(union)); // sorted for display

        // Intersection
        Set<Integer> inter = new HashSet<>(a);
        inter.retainAll(b);
        System.out.println("Intersection: " + new TreeSet<>(inter));

        // Difference A - B
        Set<Integer> diff = new HashSet<>(a);
        diff.removeAll(b);
        System.out.println("A - B: " + new TreeSet<>(diff));

        // Symmetric difference
        Set<Integer> symDiff = new HashSet<>(union);
        symDiff.removeAll(inter);
        System.out.println("Symmetric diff: " + new TreeSet<>(symDiff));

        // Subset
        Set<Integer> sub = new HashSet<>(Arrays.asList(3, 4));
        System.out.println("sub of a: " + a.containsAll(sub)); // true
    }

    // ── 3. LinkedHashSet — preserve insertion order ───────────
    static void linkedHashSetDemo() {
        Set<String> ordered = new LinkedHashSet<>();
        ordered.add("cherry");
        ordered.add("apple");
        ordered.add("banana");
        ordered.add("apple"); // ignored
        System.out.println("Insertion order: " + ordered); // [cherry, apple, banana]
    }

    // ── 4. TreeSet — sorted + navigable ───────────────────────
    static void treeSetDemo() {
        TreeSet<Integer> sorted = new TreeSet<>(Arrays.asList(5, 2, 8, 1, 9, 3));
        System.out.println("Sorted: " + sorted);         // [1,2,3,5,8,9]
        System.out.println("first: " + sorted.first());  // 1
        System.out.println("last:  " + sorted.last());   // 9
        System.out.println("floor(4):   " + sorted.floor(4));   // 3 (largest <= 4)
        System.out.println("ceiling(4): " + sorted.ceiling(4)); // 5 (smallest >= 4)
        System.out.println("lower(5):   " + sorted.lower(5));   // 3 (strictly <)
        System.out.println("higher(5):  " + sorted.higher(5));  // 8 (strictly >)
        System.out.println("headSet(5): " + sorted.headSet(5)); // [1,2,3]
        System.out.println("tailSet(5): " + sorted.tailSet(5)); // [5,8,9]
        System.out.println("subSet(2,8):" + sorted.subSet(2,8));// [2,3,5]
    }

    // ── 5. Remove duplicates from array ─────────────────────
    static int[] removeDuplicates(int[] arr) {
        Set<Integer> seen = new LinkedHashSet<>();
        for (int x : arr) seen.add(x);
        return seen.stream().mapToInt(Integer::intValue).toArray();
    }

    // ── 6. Find common elements in two arrays ─────────────────
    static List<Integer> commonElements(int[] a, int[] b) {
        Set<Integer> setA = new HashSet<>();
        for (int x : a) setA.add(x);
        List<Integer> common = new ArrayList<>();
        for (int x : b)
            if (setA.contains(x)) common.add(x);
        return common;
    }

    // ── 7. EnumSet — fastest for enum collections ─────────────
    enum Day { MON, TUE, WED, THU, FRI, SAT, SUN }

    static Set<Day> weekdays() {
        return EnumSet.range(Day.MON, Day.FRI); // [MON, TUE, WED, THU, FRI]
    }

    static Set<Day> weekend() {
        return EnumSet.of(Day.SAT, Day.SUN);
    }

    public static void main(String[] args) {
        System.out.println("=== HashSet Basics ===");
        hashSetBasics();

        System.out.println("\n=== Set Operations ===");
        setOperations();

        System.out.println("\n=== LinkedHashSet ===");
        linkedHashSetDemo();

        System.out.println("\n=== TreeSet ===");
        treeSetDemo();

        System.out.println("\n=== Remove Duplicates ===");
        System.out.println(Arrays.toString(removeDuplicates(new int[]{3,1,4,1,5,9,2,6,5,3})));
        // [3,1,4,5,9,2,6]

        System.out.println("\n=== Common Elements ===");
        System.out.println(commonElements(new int[]{1,2,3,4}, new int[]{3,4,5,6})); // [3,4]

        System.out.println("\n=== EnumSet ===");
        System.out.println("Weekdays: " + weekdays());
        System.out.println("Weekend:  " + weekend());

        System.out.println("\n=== When to Use ===");
        System.out.println("HashSet        → fast contains(), no order needed");
        System.out.println("LinkedHashSet  → fast + need insertion order");
        System.out.println("TreeSet        → sorted iteration, range queries");
        System.out.println("EnumSet        → enum constants, bit-vector fast");
    }
}
