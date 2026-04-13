package org.example.DesignPatterns.Creational.Builder;

import java.util.*;

/**
 * ============================================================
 *           BUILDER PATTERN — COMPLETE GUIDE
 * ============================================================
 *
 * INTENT: Separate construction of a complex object from its
 * representation so the same process can create different representations.
 *
 * USE WHEN:
 * ---------
 *   - Object has many optional parameters (telescoping constructors)
 *   - Need to construct objects step-by-step
 *   - Want to create different representations with same process
 *
 * BENEFITS:
 * ---------
 *   - Readable (named "set" calls vs positional constructor args)
 *   - Validates at build() time
 *   - Immutable objects (all fields set before handing out)
 *   - Fluent API
 *
 * ============================================================
 */
public class Builder {

    // ── 1. Classic Builder (Effective Java Item 2) ────────────
    static class HttpRequest {
        // Required fields
        private final String method;
        private final String url;
        // Optional fields
        private final Map<String, String> headers;
        private final String body;
        private final int timeoutMs;
        private final boolean followRedirects;
        private final int maxRetries;

        private HttpRequest(BuilderClass b) {
            this.method          = b.method;
            this.url             = b.url;
            this.headers         = Collections.unmodifiableMap(new HashMap<>(b.headers));
            this.body            = b.body;
            this.timeoutMs       = b.timeoutMs;
            this.followRedirects = b.followRedirects;
            this.maxRetries      = b.maxRetries;
        }

        static class BuilderClass {
            // Required
            private final String method;
            private final String url;
            // Optional with defaults
            private Map<String, String> headers = new HashMap<>();
            private String body;
            private int    timeoutMs = 30_000;
            private boolean followRedirects = true;
            private int    maxRetries = 0;

            BuilderClass(String method, String url) {
                if (method == null || url == null) throw new IllegalArgumentException("method/url required");
                this.method = method;
                this.url    = url;
            }

            BuilderClass header(String key, String value) { headers.put(key, value); return this; }
            BuilderClass body(String body)                 { this.body = body;        return this; }
            BuilderClass timeout(int ms)                   { timeoutMs = ms;          return this; }
            BuilderClass followRedirects(boolean follow)   { followRedirects = follow; return this; }
            BuilderClass maxRetries(int n)                 { maxRetries = n;           return this; }

            HttpRequest build() {
                // Validate
                if (body != null && method.equals("GET"))
                    throw new IllegalStateException("GET requests cannot have a body");
                return new HttpRequest(this);
            }
        }

        @Override
        public String toString() {
            return String.format("HttpRequest[%s %s, timeout=%dms, retries=%d, headers=%s%s]",
                method, url, timeoutMs, maxRetries, headers.keySet(),
                body != null ? ", body=" + body.substring(0, Math.min(20, body.length())) : "");
        }
    }

    // ── 2. Generic Builder with inheritance ───────────────────
    static abstract class AbstractPizza {
        final String name;
        final int size;           // inches
        final boolean extraCheese;
        final List<String> toppings;

        protected AbstractPizza(PizzaBuilder<?> builder) {
            this.name        = builder.name;
            this.size        = builder.size;
            this.extraCheese = builder.extraCheese;
            this.toppings    = List.copyOf(builder.toppings);
        }

        abstract static class PizzaBuilder<T extends PizzaBuilder<T>> {
            String name;
            int size = 12;
            boolean extraCheese = false;
            List<String> toppings = new ArrayList<>();

            PizzaBuilder(String name) { this.name = name; }

            @SuppressWarnings("unchecked")
            T size(int s) { size = s; return (T) this; }

            @SuppressWarnings("unchecked")
            T extraCheese() { extraCheese = true; return (T) this; }

            @SuppressWarnings("unchecked")
            T topping(String t) { toppings.add(t); return (T) this; }

            abstract AbstractPizza build();
        }
    }

    static class NyPizza extends AbstractPizza {
        enum Crust { THIN, THICK }
        private final Crust crust;

        private NyPizza(NyBuilder b) { super(b); this.crust = b.crust; }

        static class NyBuilder extends PizzaBuilder<NyBuilder> {
            Crust crust;
            NyBuilder(String name, Crust crust) { super(name); this.crust = crust; }

            @Override public NyPizza build() { return new NyPizza(this); }
        }

        @Override public String toString() {
            return "NyPizza[" + name + ", size=" + size + ", crust=" + crust +
                   ", toppings=" + toppings + (extraCheese ? ", EXTRA CHEESE" : "") + "]";
        }
    }

    // ── 3. Builder with validation ────────────────────────────
    static class EmailMessage {
        private final String from;
        private final List<String> to;
        private final String subject;
        private final String body;
        private final List<String> cc;
        private final boolean isHtml;

        private EmailMessage(EmailBuilder b) {
            this.from    = b.from;
            this.to      = List.copyOf(b.to);
            this.subject = b.subject;
            this.body    = b.body;
            this.cc      = List.copyOf(b.cc);
            this.isHtml  = b.isHtml;
        }

        static class EmailBuilder {
            private String from;
            private List<String> to = new ArrayList<>();
            private String subject = "";
            private String body    = "";
            private List<String> cc = new ArrayList<>();
            private boolean isHtml = false;

            EmailBuilder from(String f)    { from = f;          return this; }
            EmailBuilder to(String... r)   { to.addAll(Arrays.asList(r)); return this; }
            EmailBuilder subject(String s) { subject = s;       return this; }
            EmailBuilder body(String b)    { body = b;          return this; }
            EmailBuilder cc(String... r)   { cc.addAll(Arrays.asList(r)); return this; }
            EmailBuilder html(boolean h)   { isHtml = h;        return this; }

            EmailMessage build() {
                if (from == null || from.isBlank()) throw new IllegalStateException("'from' required");
                if (to.isEmpty())                   throw new IllegalStateException("At least one 'to' required");
                if (subject.isBlank())              throw new IllegalStateException("Subject required");
                return new EmailMessage(this);
            }
        }

        @Override public String toString() {
            return String.format("Email[from=%s, to=%s, subject='%s', html=%s]",
                from, to, subject, isHtml);
        }
    }

    public static void main(String[] args) {
        // 1. HTTP Request
        System.out.println("=== HTTP Request Builder ===");
        HttpRequest get = new HttpRequest.BuilderClass("GET", "https://api.example.com/users")
            .header("Authorization", "Bearer token123")
            .header("Accept", "application/json")
            .timeout(5000)
            .maxRetries(3)
            .build();
        System.out.println(get);

        HttpRequest post = new HttpRequest.BuilderClass("POST", "https://api.example.com/users")
            .header("Content-Type", "application/json")
            .body("{\"name\":\"Alice\"}")
            .timeout(10000)
            .build();
        System.out.println(post);

        // Validation
        try {
            new HttpRequest.BuilderClass("GET", "url").body("invalid").build();
        } catch (IllegalStateException e) {
            System.out.println("Validation caught: " + e.getMessage());
        }

        // 2. Pizza (hierarchical builder)
        System.out.println("\n=== Pizza Builder ===");
        NyPizza pizza = new NyPizza.NyBuilder("Margherita", NyPizza.Crust.THIN)
            .size(16)
            .topping("mozzarella")
            .topping("basil")
            .extraCheese()
            .build();
        System.out.println(pizza);

        // 3. Email
        System.out.println("\n=== Email Builder ===");
        EmailMessage email = new EmailMessage.EmailBuilder()
            .from("alice@example.com")
            .to("bob@example.com", "carol@example.com")
            .cc("dave@example.com")
            .subject("Meeting Tomorrow")
            .body("Please join at 10am")
            .html(false)
            .build();
        System.out.println(email);

        System.out.println("\n=== Builder Summary ===");
        System.out.println("Use when: many optional params, telescoping constructors");
        System.out.println("Benefits: readable, validates on build(), immutable result");
        System.out.println("Fluent:   each method returns 'this' (or self type T)");
        System.out.println("Validate: in build() method, not setters");
    }
}
