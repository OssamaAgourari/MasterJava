package org.example.OOP.Encapsulation;

/**
 * ============================================================
 *         JAVA ENCAPSULATION — COMPLETE GUIDE
 * ============================================================
 *
 * ENCAPSULATION: Bundling data (fields) and methods together,
 * and HIDING internal state from outside.
 *
 * KEY PRINCIPLE: "Information Hiding"
 *   - Fields → private
 *   - Access via public getters/setters with validation
 *   - Internal representation can change without breaking callers
 *
 * BENEFITS:
 * ---------
 *   1. Control over data (validate in setters)
 *   2. Flexibility to change internals
 *   3. Prevent invalid state
 *   4. Thread safety (combined with synchronization)
 *
 * GETTER/SETTER NAMING:
 * ---------------------
 *   getFieldName()  → return field value
 *   setFieldName(v) → set field value (with validation)
 *   isFieldName()   → for booleans
 *
 * ACCESS LEVELS (most → least restrictive):
 *   private   → class only
 *   (default) → package only
 *   protected → package + subclasses
 *   public    → everywhere
 *
 * ============================================================
 */
public class Encapsulation {

    // ── 1. Classic encapsulation — Employee ───────────────────
    static class Employee {
        private String name;
        private int age;
        private double salary;
        private String department;

        Employee(String name, int age, double salary, String department) {
            setName(name);
            setAge(age);
            setSalary(salary);
            this.department = department;
        }

        // Getters
        String getName()       { return name; }
        int    getAge()        { return age; }
        double getSalary()     { return salary; }
        String getDepartment() { return department; }

        // Setters with validation
        void setName(String name) {
            if (name == null || name.isBlank())
                throw new IllegalArgumentException("Name cannot be blank");
            this.name = name.trim();
        }

        void setAge(int age) {
            if (age < 18 || age > 70)
                throw new IllegalArgumentException("Age must be 18-70, got: " + age);
            this.age = age;
        }

        void setSalary(double salary) {
            if (salary < 0)
                throw new IllegalArgumentException("Salary cannot be negative");
            this.salary = salary;
        }

        void raiseSalary(double percent) {
            if (percent < 0 || percent > 100)
                throw new IllegalArgumentException("Invalid raise percent");
            this.salary *= (1 + percent / 100);
        }

        @Override
        public String toString() {
            return String.format("Employee[%s, age=%d, salary=%.2f, dept=%s]",
                name, age, salary, department);
        }
    }

    // ── 2. Encapsulation with computed property ────────────────
    static class Circle {
        private double radius;

        Circle(double radius) { setRadius(radius); }

        void setRadius(double r) {
            if (r <= 0) throw new IllegalArgumentException("Radius must be positive");
            this.radius = r;
        }

        double getRadius() { return radius; }

        // Computed — no field needed
        double getArea()        { return Math.PI * radius * radius; }
        double getCircumference() { return 2 * Math.PI * radius; }

        @Override
        public String toString() {
            return String.format("Circle[r=%.2f, area=%.2f]", radius, getArea());
        }
    }

    // ── 3. Encapsulation with defensive copy ──────────────────
    // Prevent external mutation of internal array
    static class Grades {
        private final int[] scores;

        Grades(int[] scores) {
            this.scores = scores.clone(); // defensive copy on input
        }

        int[] getScores() {
            return scores.clone(); // defensive copy on output
        }

        double getAverage() {
            int sum = 0;
            for (int s : scores) sum += s;
            return (double) sum / scores.length;
        }

        int getHighest() {
            int max = scores[0];
            for (int s : scores) if (s > max) max = s;
            return max;
        }
    }

    // ── 4. Package-private encapsulation ──────────────────────
    // (default access — visible within package)
    static class Config {
        String host = "localhost"; // package-visible
        int    port = 8080;        // package-visible
        private String password;   // truly private

        Config(String password) { this.password = password; }

        boolean authenticate(String input) {
            return password.equals(input);
        }
    }

    // ── 5. Read-only property (getter only) ───────────────────
    static class UUID {
        private final String id;

        UUID() {
            // Generate a simple pseudo-UUID
            this.id = Long.toHexString(System.nanoTime()) + "-" +
                      Integer.toHexString((int)(Math.random() * 0xFFFF));
        }

        String getId() { return id; } // No setter — truly read-only
    }

    // ── 6. Encapsulated counter — thread-safe style ───────────
    static class SafeCounter {
        private int count = 0;
        private final int max;

        SafeCounter(int max) { this.max = max; }

        boolean increment() {
            if (count >= max) return false;
            count++;
            return true;
        }

        void reset() { count = 0; }
        int  getCount() { return count; }
        boolean isFull()  { return count >= max; }
    }

    public static void main(String[] args) {
        // 1. Employee
        Employee emp = new Employee("Alice", 30, 50000, "Engineering");
        System.out.println(emp);
        emp.raiseSalary(10);
        System.out.println("After raise: " + emp.getSalary()); // 55000

        try {
            emp.setAge(200); // should throw
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage()); // Age must be 18-70
        }

        // 2. Circle
        Circle circle = new Circle(5.0);
        System.out.printf("Circle area=%.2f, circumference=%.2f%n",
            circle.getArea(), circle.getCircumference());

        // 3. Defensive copy
        int[] original = {85, 92, 78, 95, 88};
        Grades grades = new Grades(original);
        original[0] = 0; // should NOT affect internal state
        System.out.printf("Average=%.1f, Highest=%d%n",
            grades.getAverage(), grades.getHighest()); // not affected

        // 4. Config
        Config cfg = new Config("secret123");
        System.out.println("Auth result: " + cfg.authenticate("secret123")); // true
        System.out.println("Host: " + cfg.host); // package-visible

        // 5. UUID (read-only)
        UUID uuid = new UUID();
        System.out.println("UUID: " + uuid.getId());

        // 6. SafeCounter
        SafeCounter counter = new SafeCounter(3);
        System.out.println(counter.increment()); // true
        System.out.println(counter.increment()); // true
        System.out.println(counter.increment()); // true
        System.out.println(counter.increment()); // false (max reached)
        System.out.println("Count: " + counter.getCount()); // 3

        System.out.println("\n=== Encapsulation Principles ===");
        System.out.println("1. Fields → private");
        System.out.println("2. Access via getters/setters with validation");
        System.out.println("3. Defensive copies for mutable objects");
        System.out.println("4. Computed properties > stored redundant data");
        System.out.println("5. Minimize what you expose (principle of least privilege)");
    }
}
