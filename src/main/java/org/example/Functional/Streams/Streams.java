package org.example.Functional.Streams;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

/**
 * ============================================================
 *          JAVA STREAMS — COMPLETE GUIDE
 * ============================================================
 *
 * STREAM: A sequence of elements supporting sequential/parallel
 * aggregate operations. LAZY — computed only when terminal op runs.
 *
 * STREAM PIPELINE:
 * ----------------
 *   source → intermediate ops → terminal op
 *
 * SOURCE:           Collection.stream(), Arrays.stream(), Stream.of()
 * INTERMEDIATE OPS: filter, map, flatMap, distinct, sorted, peek,
 *                   limit, skip, mapToInt/Long/Double
 * TERMINAL OPS:     collect, forEach, reduce, count, min, max,
 *                   findFirst, findAny, anyMatch, allMatch, noneMatch
 *
 * KEY CHARACTERISTICS:
 * --------------------
 *   - LAZY: intermediate ops don't run until terminal
 *   - SINGLE USE: once consumed, can't be reused
 *   - NON-MUTATING: doesn't modify source collection
 *   - Optional parallelism: .parallel()
 *
 * COLLECTORS (Collectors.*):
 * --------------------------
 *   toList(), toSet(), toMap()
 *   groupingBy(), partitioningBy()
 *   counting(), summingInt(), averagingInt()
 *   joining(delimiter)
 *   toUnmodifiableList()
 *
 * ============================================================
 */
public class Streams {

    record Person(String name, int age, String city) {}

    // ── 1. Creating streams ───────────────────────────────────
    static void creationDemo() {
        // From collection
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> s1 = list.stream();

        // From array
        Stream<String> s2 = Arrays.stream(new String[]{"x","y","z"});

        // Stream.of
        Stream<Integer> s3 = Stream.of(1, 2, 3, 4, 5);

        // IntStream (primitive)
        IntStream range = IntStream.range(1, 6);  // 1,2,3,4 (exclusive end)
        IntStream rangeClosed = IntStream.rangeClosed(1, 5); // 1,2,3,4,5

        System.out.println("Stream.of sum: " + Stream.of(1,2,3,4,5).mapToInt(i->i).sum());
        System.out.println("range sum: " + IntStream.rangeClosed(1,5).sum()); // 15

        // Infinite stream
        Stream<Integer> evens = Stream.iterate(0, n -> n + 2).limit(5);
        System.out.println("Evens: " + evens.collect(Collectors.toList())); // [0,2,4,6,8]

        // Generate
        Stream<Double> randoms = Stream.generate(Math::random).limit(3);
        System.out.println("Random count: " + randoms.count()); // 3
    }

    // ── 2. filter and map ─────────────────────────────────────
    static void filterMapDemo(List<Person> people) {
        // Filter: age > 25, map: name, collect
        List<String> result = people.stream()
            .filter(p -> p.age() > 25)
            .map(Person::name)
            .sorted()
            .collect(Collectors.toList());
        System.out.println("People over 25: " + result);

        // mapToInt, average
        OptionalDouble avgAge = people.stream()
            .mapToInt(Person::age)
            .average();
        System.out.printf("Average age: %.1f%n", avgAge.orElse(0));
    }

    // ── 3. flatMap ────────────────────────────────────────────
    static void flatMapDemo() {
        List<List<Integer>> nested = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(6, 7, 8, 9)
        );

        List<Integer> flat = nested.stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
        System.out.println("Flat: " + flat);

        // Split sentences into words
        List<String> sentences = Arrays.asList("hello world", "java streams", "functional programming");
        long uniqueWords = sentences.stream()
            .flatMap(s -> Arrays.stream(s.split(" ")))
            .distinct()
            .count();
        System.out.println("Unique words: " + uniqueWords);
    }

    // ── 4. Collectors ────────────────────────────────────────
    static void collectorsDemo(List<Person> people) {
        // groupingBy
        Map<String, List<Person>> byCity = people.stream()
            .collect(Collectors.groupingBy(Person::city));
        System.out.println("By city: " + byCity.keySet());

        // groupingBy + counting
        Map<String, Long> countByCity = people.stream()
            .collect(Collectors.groupingBy(Person::city, Collectors.counting()));
        System.out.println("Count by city: " + countByCity);

        // partitioningBy
        Map<Boolean, List<Person>> adults = people.stream()
            .collect(Collectors.partitioningBy(p -> p.age() >= 18));
        System.out.println("Adults: " + adults.get(true).stream().map(Person::name).collect(Collectors.toList()));

        // toMap
        Map<String, Integer> nameToAge = people.stream()
            .collect(Collectors.toMap(Person::name, Person::age));
        System.out.println("Name to age: " + new TreeMap<>(nameToAge));

        // joining
        String names = people.stream()
            .map(Person::name)
            .sorted()
            .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Names: " + names);

        // statistics
        IntSummaryStatistics stats = people.stream()
            .mapToInt(Person::age)
            .summaryStatistics();
        System.out.printf("Age stats: min=%d, max=%d, avg=%.1f%n",
            stats.getMin(), stats.getMax(), stats.getAverage());
    }

    // ── 5. reduce ────────────────────────────────────────────
    static void reduceDemo() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        // Sum with reduce
        int sum = nums.stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sum); // 15

        // Product
        int product = nums.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product); // 120

        // Max without Optional
        Optional<Integer> max = nums.stream().reduce(Integer::max);
        System.out.println("Max: " + max.orElse(-1)); // 5

        // String concatenation
        String concat = Stream.of("a","b","c","d").reduce("", String::concat);
        System.out.println("Concat: " + concat); // abcd
    }

    // ── 6. Terminal operations ────────────────────────────────
    static void terminalOpsDemo(List<Person> people) {
        System.out.println("count: " + people.stream().count());

        System.out.println("anyMatch(age>30): " + people.stream().anyMatch(p -> p.age() > 30));
        System.out.println("allMatch(age>0):  " + people.stream().allMatch(p -> p.age() > 0));
        System.out.println("noneMatch(age<0): " + people.stream().noneMatch(p -> p.age() < 0));

        Optional<Person> youngest = people.stream().min(Comparator.comparingInt(Person::age));
        youngest.ifPresent(p -> System.out.println("Youngest: " + p.name()));

        Optional<Person> first = people.stream()
            .filter(p -> p.city().equals("NYC"))
            .findFirst();
        System.out.println("First in NYC: " + first.map(Person::name).orElse("none"));
    }

    // ── 7. Parallel streams ───────────────────────────────────
    static void parallelDemo() {
        long start = System.nanoTime();
        long sumSeq = LongStream.rangeClosed(1, 10_000_000).sum();
        long seqTime = System.nanoTime() - start;

        start = System.nanoTime();
        long sumPar = LongStream.rangeClosed(1, 10_000_000).parallel().sum();
        long parTime = System.nanoTime() - start;

        System.out.println("Sequential sum: " + sumSeq + " (" + seqTime/1_000_000 + "ms)");
        System.out.println("Parallel sum:   " + sumPar + " (" + parTime/1_000_000 + "ms)");
        System.out.println("Equal: " + (sumSeq == sumPar));
    }

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30, "NYC"),
            new Person("Bob",   25, "LA"),
            new Person("Carol", 35, "NYC"),
            new Person("Dave",  22, "Chicago"),
            new Person("Eve",   28, "LA")
        );

        System.out.println("=== Stream Creation ===");
        creationDemo();

        System.out.println("\n=== Filter & Map ===");
        filterMapDemo(people);

        System.out.println("\n=== FlatMap ===");
        flatMapDemo();

        System.out.println("\n=== Collectors ===");
        collectorsDemo(people);

        System.out.println("\n=== Reduce ===");
        reduceDemo();

        System.out.println("\n=== Terminal Ops ===");
        terminalOpsDemo(people);

        System.out.println("\n=== Parallel Streams ===");
        parallelDemo();

        System.out.println("\n=== Stream Quick Reference ===");
        System.out.println("filter(pred)     → keep matching elements");
        System.out.println("map(fn)          → transform each element");
        System.out.println("flatMap(fn)      → map + flatten nested streams");
        System.out.println("distinct()       → remove duplicates");
        System.out.println("sorted()         → natural order");
        System.out.println("limit(n)/skip(n) → slice");
        System.out.println("collect()        → terminal: gather results");
        System.out.println("reduce()         → terminal: aggregate");
        System.out.println("Use method references: Class::method or obj::method");
    }
}
