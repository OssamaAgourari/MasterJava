package org.example.Collections.Comparators;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================
 *        JAVA COMPARATORS & COMPARABLE — COMPLETE GUIDE
 * ============================================================
 *
 * TWO WAYS TO COMPARE OBJECTS:
 * ----------------------------
 *   1. Comparable<T>  → object compares itself (natural order)
 *      Implement: int compareTo(T other)
 *      Used by: Arrays.sort, Collections.sort (no comparator)
 *
 *   2. Comparator<T>  → external comparison logic
 *      Implement: int compare(T a, T b)
 *      Used by: sort with custom order, TreeSet, TreeMap
 *
 * RETURN VALUE OF compareTo / compare:
 * -------------------------------------
 *   Negative → a < b (a comes first)
 *   Zero     → a == b (equal)
 *   Positive → a > b (b comes first)
 *
 * COMPARATOR CHAINING (Java 8+):
 * --------------------------------
 *   Comparator.comparing(keyExtractor)
 *   .thenComparing(secondKey)
 *   .reversed()
 *   .thenComparingInt(...)
 *
 * ============================================================
 */
public class Comparators {

    // ── 1. Comparable — natural order ─────────────────────────
    static class Student implements Comparable<Student> {
        String name;
        double gpa;
        int age;

        Student(String name, double gpa, int age) {
            this.name = name; this.gpa = gpa; this.age = age;
        }

        // Natural order: by GPA descending
        @Override
        public int compareTo(Student other) {
            return Double.compare(other.gpa, this.gpa); // descending
        }

        @Override
        public String toString() {
            return String.format("%s(%.1f,%d)", name, gpa, age);
        }
    }

    // ── 2. Custom Comparator approaches ──────────────────────
    static void comparatorDemo() {
        List<Student> students = Arrays.asList(
            new Student("Alice", 3.9, 20),
            new Student("Bob",   3.5, 22),
            new Student("Carol", 3.9, 19),
            new Student("Dave",  3.7, 21)
        );

        // a) Natural order (Comparable)
        List<Student> sorted1 = new ArrayList<>(students);
        Collections.sort(sorted1);
        System.out.println("Natural (GPA desc): " + sorted1);

        // b) Anonymous Comparator
        students.sort(new Comparator<Student>() {
            @Override public int compare(Student a, Student b) {
                return a.name.compareTo(b.name);
            }
        });
        System.out.println("By name: " + students);

        // c) Lambda
        students.sort((a, b) -> Integer.compare(a.age, b.age));
        System.out.println("By age: " + students);

        // d) Method reference
        students.sort(Comparator.comparing(s -> s.name));
        System.out.println("By name (method ref): " + students);

        // e) Comparator.comparing chain
        students.sort(
            Comparator.comparingDouble((Student s) -> s.gpa)
                      .reversed()
                      .thenComparing(s -> s.name)
        );
        System.out.println("By GPA desc then name: " + students);
    }

    // ── 3. Comparator with nulls ──────────────────────────────
    static void nullSafeDemo() {
        List<String> withNulls = new ArrayList<>(Arrays.asList("banana", null, "apple", null, "cherry"));

        // nullsFirst, nullsLast
        withNulls.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println("nullsFirst: " + withNulls);

        withNulls.sort(Comparator.nullsLast(Comparator.naturalOrder()));
        System.out.println("nullsLast:  " + withNulls);
    }

    // ── 4. TreeMap/TreeSet with Comparator ────────────────────
    static void treeCollectionDemo() {
        // Case-insensitive TreeMap
        TreeMap<String, Integer> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        map.put("Banana", 2);
        map.put("apple", 5);
        map.put("CHERRY", 1);
        System.out.println("Case-insensitive map: " + map);

        // TreeSet with custom order (length then alpha)
        TreeSet<String> set = new TreeSet<>(
            Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder())
        );
        set.addAll(Arrays.asList("fig", "apple", "banana", "kiwi", "pear"));
        System.out.println("By length then alpha: " + set);
    }

    // ── 5. Sorting array with Comparator ─────────────────────
    static void arraySort() {
        // int[] → can't use Comparator directly
        // Integer[] → can use Comparator
        Integer[] nums = {5, -2, 3, -8, 1, -4};

        // Sort by absolute value
        Arrays.sort(nums, Comparator.comparingInt(Math::abs));
        System.out.println("By abs value: " + Arrays.toString(nums));

        // Sort descending
        Arrays.sort(nums, Comparator.reverseOrder());
        System.out.println("Descending: " + Arrays.toString(nums));
    }

    // ── 6. Multi-level sort (real-world example) ──────────────
    static class Employee {
        String department;
        String name;
        double salary;

        Employee(String dept, String name, double salary) {
            this.department = dept; this.name = name; this.salary = salary;
        }

        @Override public String toString() {
            return String.format("[%s|%s|%.0f]", department, name, salary);
        }
    }

    static void multiLevelSort() {
        List<Employee> employees = Arrays.asList(
            new Employee("Engineering", "Charlie", 90000),
            new Employee("Marketing",   "Alice",   75000),
            new Employee("Engineering", "Alice",   85000),
            new Employee("Marketing",   "Bob",     80000),
            new Employee("Engineering", "Bob",     95000)
        );

        // Sort: dept asc, then name asc, then salary desc
        employees.sort(
            Comparator.comparing((Employee e) -> e.department)
                      .thenComparing(e -> e.name)
                      .thenComparingDouble((Employee e) -> e.salary)
                      .reversed()
        );
        // Note: reversed() applies to entire chain — careful with multi-key
        // Safer:
        employees.sort((a, b) -> {
            int deptCmp = a.department.compareTo(b.department);
            if (deptCmp != 0) return deptCmp;
            int nameCmp = a.name.compareTo(b.name);
            if (nameCmp != 0) return nameCmp;
            return Double.compare(b.salary, a.salary); // desc
        });
        System.out.println("Multi-level sorted:");
        employees.forEach(e -> System.out.println("  " + e));
    }

    public static void main(String[] args) {
        System.out.println("=== Comparable ===");
        Student[] students = {
            new Student("Alice", 3.9, 20),
            new Student("Bob", 3.5, 22),
            new Student("Carol", 3.8, 19)
        };
        Arrays.sort(students); // uses compareTo
        System.out.println(Arrays.toString(students));

        System.out.println("\n=== Comparator Demo ===");
        comparatorDemo();

        System.out.println("\n=== Null-safe ===");
        nullSafeDemo();

        System.out.println("\n=== Tree Collections ===");
        treeCollectionDemo();

        System.out.println("\n=== Array Sort ===");
        arraySort();

        System.out.println("\n=== Multi-level Sort ===");
        multiLevelSort();

        System.out.println("\n=== Quick Reference ===");
        System.out.println("Comparable  → implement in class, natural order");
        System.out.println("Comparator  → external, pass to sort()");
        System.out.println("comparing() → extract key, chain with thenComparing");
        System.out.println("reversed()  → reverses the whole comparator chain");
        System.out.println("Return: negative=a<b, 0=equal, positive=a>b");
    }
}
