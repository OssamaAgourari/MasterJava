package org.example.Collections.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================
 *          JAVA LISTS — COMPLETE GUIDE
 * ============================================================
 *
 * List: Ordered collection, allows duplicates, index-based access.
 *
 * MAIN IMPLEMENTATIONS:
 * ┌──────────────┬──────────────────────────────────────────────┐
 * │  ArrayList   │ Dynamic array — O(1) get, O(n) insert/remove  │
 * │              │ Best for: random access, iteration             │
 * │  LinkedList  │ Doubly-linked — O(1) add/remove at ends        │
 * │              │ Best for: queue/deque, frequent insertions      │
 * │  Vector      │ Synchronized ArrayList (legacy, avoid)         │
 * │  Stack       │ Extends Vector (legacy, use Deque instead)     │
 * └──────────────┴──────────────────────────────────────────────┘
 *
 * PERFORMANCE COMPARISON:
 * -----------------------
 *              ArrayList    LinkedList
 *   get(i)     O(1)         O(n)
 *   add(end)   O(1) amort   O(1)
 *   add(i)     O(n)         O(n) find + O(1) link
 *   remove(i)  O(n)         O(n) find + O(1) unlink
 *   contains   O(n)         O(n)
 *   memory     low          high (node overhead)
 *
 * CREATION:
 * ---------
 *   new ArrayList<>()
 *   new ArrayList<>(collection)
 *   List.of(1,2,3)           → immutable (Java 9+)
 *   Arrays.asList(1,2,3)     → fixed-size, modifiable
 *   Collections.emptyList()  → immutable empty
 *
 * ============================================================
 */
public class Lists {

    // ── 1. ArrayList basics ───────────────────────────────────
    static void arrayListBasics() {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Carol");
        names.add(1, "Dave"); // insert at index

        System.out.println("List:   " + names);       // [Alice,Dave,Bob,Carol]
        System.out.println("Get(2): " + names.get(2)); // Bob
        System.out.println("Size:   " + names.size()); // 4

        names.remove("Bob");
        names.remove(0); // remove by index
        System.out.println("After removes: " + names); // [Dave,Carol]

        // subList (backed view)
        List<String> sub = new ArrayList<>(names.subList(0, 1));
        System.out.println("Sublist: " + sub);

        names.set(0, "Eve"); // replace
        System.out.println("After set: " + names);
    }

    // ── 2. LinkedList as Deque ────────────────────────────────
    static void linkedListDeque() {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        System.out.println("Deque: " + deque); // [0,1,2]
        System.out.println("peekFirst: " + deque.peekFirst()); // 0
        System.out.println("peekLast:  " + deque.peekLast());  // 2
        deque.pollFirst();
        System.out.println("After pollFirst: " + deque); // [1,2]
    }

    // ── 3. Sorting with Comparator ────────────────────────────
    static void sortingDemo() {
        List<String> words = new ArrayList<>(Arrays.asList("banana", "apple", "cherry", "fig", "date"));

        // Natural order
        Collections.sort(words);
        System.out.println("Alphabetical: " + words);

        // Custom: by length, then alphabetical
        words.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println("By length: " + words);

        // Reverse
        words.sort(Comparator.reverseOrder());
        System.out.println("Reverse:   " + words);
    }

    // ── 4. Searching and bulk operations ─────────────────────
    static void bulkOps() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 2, 4, 6, 8));

        // Binary search (requires sorted)
        Collections.sort(nums);
        int idx = Collections.binarySearch(nums, 5);
        System.out.println("binarySearch(5): " + idx); // 4

        System.out.println("min: " + Collections.min(nums));
        System.out.println("max: " + Collections.max(nums));
        System.out.println("frequency(5): " + Collections.frequency(nums, 5)); // 1

        // Shuffle and rotate
        List<Integer> copy = new ArrayList<>(nums);
        Collections.rotate(copy, 2);
        System.out.println("Rotated 2: " + copy);

        // nCopies
        List<String> repeated = Collections.nCopies(4, "hello");
        System.out.println("nCopies: " + repeated); // [hello, hello, hello, hello]
    }

    // ── 5. Immutable lists ────────────────────────────────────
    static void immutableLists() {
        // Java 9+
        List<String> fixed = List.of("a", "b", "c");
        System.out.println("List.of: " + fixed);
        // fixed.add("d"); // throws UnsupportedOperationException

        // Java 8 style
        List<String> empty = Collections.emptyList();
        List<String> single = Collections.singletonList("only");

        // Make modifiable copy
        List<String> mutable = new ArrayList<>(fixed);
        mutable.add("d");
        System.out.println("Mutable copy: " + mutable);
    }

    // ── 6. Iterating safely (avoid ConcurrentModificationException) ──
    static List<Integer> removeEvens(List<Integer> list) {
        // Method 1: removeIf (Java 8+)
        List<Integer> copy = new ArrayList<>(list);
        copy.removeIf(n -> n % 2 == 0);
        return copy;
    }

    static List<Integer> removeEvensIterator(List<Integer> list) {
        // Method 2: Iterator (safe removal during iteration)
        List<Integer> copy = new ArrayList<>(list);
        Iterator<Integer> it = copy.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 0) it.remove();
        }
        return copy;
    }

    // ── 7. List operations with Streams ───────────────────────
    static List<Integer> streamOps(List<Integer> nums) {
        return nums.stream()
                   .filter(n -> n > 2)
                   .map(n -> n * n)
                   .sorted()
                   .collect(Collectors.toList());
    }

    // ── 8. 2D list (list of lists) ────────────────────────────
    static List<List<Integer>> transpose(List<List<Integer>> matrix) {
        int rows = matrix.size(), cols = matrix.get(0).size();
        List<List<Integer>> result = new ArrayList<>();
        for (int j = 0; j < cols; j++) {
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < rows; i++) row.add(matrix.get(i).get(j));
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== ArrayList Basics ===");
        arrayListBasics();

        System.out.println("\n=== LinkedList as Deque ===");
        linkedListDeque();

        System.out.println("\n=== Sorting ===");
        sortingDemo();

        System.out.println("\n=== Bulk Operations ===");
        bulkOps();

        System.out.println("\n=== Immutable Lists ===");
        immutableLists();

        System.out.println("\n=== Remove Evens ===");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("removeIf:  " + removeEvens(nums));
        System.out.println("iterator:  " + removeEvensIterator(nums));

        System.out.println("\n=== Streams ===");
        System.out.println(streamOps(Arrays.asList(1, 2, 3, 4, 5))); // [9, 16, 25]

        System.out.println("\n=== Transpose ===");
        List<List<Integer>> matrix = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6)
        );
        System.out.println(transpose(matrix)); // [[1,4],[2,5],[3,6]]

        System.out.println("\n=== Complexity Summary ===");
        System.out.println("ArrayList get(i):    O(1)");
        System.out.println("ArrayList add(end):  O(1) amortized");
        System.out.println("ArrayList add(i):    O(n) — shift");
        System.out.println("LinkedList add(end): O(1)");
        System.out.println("LinkedList get(i):   O(n) — traverse");
        System.out.println("Use ArrayList by default unless frequent insertions at head/middle");
    }
}
