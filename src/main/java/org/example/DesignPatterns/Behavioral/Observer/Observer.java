package org.example.DesignPatterns.Behavioral.Observer;

import java.util.*;
import java.util.function.*;

/**
 * ============================================================
 *           OBSERVER PATTERN — COMPLETE GUIDE
 * ============================================================
 *
 * INTENT: Define a one-to-many dependency so when one object
 * (subject/publisher) changes state, all dependents (observers)
 * are notified automatically.
 *
 * ALSO KNOWN AS: Event-Listener, Publish-Subscribe
 *
 * USE WHEN:
 * ---------
 *   - Change in one object requires changing others
 *   - You don't know how many objects need to change
 *   - Objects should notify other objects without making assumptions
 *
 * IN JAVA:
 * --------
 *   java.util.Observer/Observable (deprecated Java 9)
 *   java.beans.PropertyChangeListener
 *   Reactor, RxJava (reactive streams)
 *   Event systems (Swing, JavaFX)
 *
 * ============================================================
 */
public class Observer {

    // ── 1. Classic Observer (type-safe, generic) ──────────────
    interface EventListener<T> {
        void onEvent(T event);
    }

    static class EventEmitter<T> {
        private final List<EventListener<T>> listeners = new ArrayList<>();

        void subscribe(EventListener<T> listener)   { listeners.add(listener); }
        void unsubscribe(EventListener<T> listener) { listeners.remove(listener); }

        void emit(T event) {
            for (EventListener<T> listener : new ArrayList<>(listeners)) { // copy to avoid CME
                listener.onEvent(event);
            }
        }
    }

    // ── 2. Stock price observer ───────────────────────────────
    record StockEvent(String symbol, double price, double change) {}

    interface StockObserver {
        void onPriceChange(StockEvent event);
    }

    static class StockMarket {
        private final Map<String, Double> prices = new HashMap<>();
        private final List<StockObserver> observers = new ArrayList<>();

        void addObserver(StockObserver o)    { observers.add(o); }
        void removeObserver(StockObserver o) { observers.remove(o); }

        void updatePrice(String symbol, double newPrice) {
            double oldPrice = prices.getOrDefault(symbol, newPrice);
            prices.put(symbol, newPrice);

            double change = newPrice - oldPrice;
            StockEvent event = new StockEvent(symbol, newPrice, change);
            notifyObservers(event);
        }

        private void notifyObservers(StockEvent event) {
            observers.forEach(o -> o.onPriceChange(event));
        }
    }

    static class PortfolioTracker implements StockObserver {
        private final String name;
        private final Map<String, Integer> holdings;
        private double totalValue = 0;

        PortfolioTracker(String name, Map<String, Integer> holdings) {
            this.name = name;
            this.holdings = holdings;
        }

        @Override
        public void onPriceChange(StockEvent e) {
            if (holdings.containsKey(e.symbol())) {
                int shares = holdings.get(e.symbol());
                double impact = e.change() * shares;
                totalValue += impact;
                System.out.printf("  [%s] %s: $%.2f (%+.2f) — portfolio impact: %+.2f%n",
                    name, e.symbol(), e.price(), e.change(), impact);
            }
        }
    }

    static class AlertSystem implements StockObserver {
        private final double threshold;

        AlertSystem(double threshold) { this.threshold = threshold; }

        @Override
        public void onPriceChange(StockEvent e) {
            if (Math.abs(e.change()) >= threshold) {
                System.out.printf("  ⚠ ALERT: %s changed by %+.2f (threshold: %.2f)%n",
                    e.symbol(), e.change(), threshold);
            }
        }
    }

    // ── 3. Property change observer (JavaBeans style) ─────────
    static class UserProfile {
        private String name;
        private String email;
        private final List<Consumer<String>> nameListeners = new ArrayList<>();
        private final List<Consumer<String>> emailListeners = new ArrayList<>();

        void onNameChange(Consumer<String> listener)  { nameListeners.add(listener); }
        void onEmailChange(Consumer<String> listener) { emailListeners.add(listener); }

        void setName(String name) {
            this.name = name;
            nameListeners.forEach(l -> l.accept(name));
        }

        void setEmail(String email) {
            this.email = email;
            emailListeners.forEach(l -> l.accept(email));
        }
    }

    // ── 4. Typed event bus ────────────────────────────────────
    static class TypedEventBus {
        private final Map<Class<?>, List<Consumer<Object>>> handlers = new HashMap<>();

        @SuppressWarnings("unchecked")
        <T> void subscribe(Class<T> eventType, Consumer<T> handler) {
            handlers.computeIfAbsent(eventType, k -> new ArrayList<>())
                    .add(e -> handler.accept((T) e));
        }

        <T> void publish(T event) {
            List<Consumer<Object>> list = handlers.getOrDefault(event.getClass(), Collections.emptyList());
            list.forEach(h -> h.accept(event));
        }
    }

    record UserCreatedEvent(String userId, String name) {}
    record OrderPlacedEvent(String orderId, double amount) {}

    public static void main(String[] args) {
        // 1. Generic EventEmitter
        System.out.println("=== Generic EventEmitter ===");
        EventEmitter<String> emitter = new EventEmitter<>();
        EventListener<String> listener1 = msg -> System.out.println("L1: " + msg);
        EventListener<String> listener2 = msg -> System.out.println("L2: " + msg.toUpperCase());
        emitter.subscribe(listener1);
        emitter.subscribe(listener2);
        emitter.emit("Hello World!");
        emitter.unsubscribe(listener2);
        emitter.emit("Only one listener now");

        // 2. Stock market
        System.out.println("\n=== Stock Market ===");
        StockMarket market = new StockMarket();

        PortfolioTracker alice = new PortfolioTracker("Alice",
            Map.of("AAPL", 10, "GOOGL", 5));
        PortfolioTracker bob = new PortfolioTracker("Bob",
            Map.of("AAPL", 20, "TSLA", 15));
        AlertSystem alertSystem = new AlertSystem(5.0);

        market.addObserver(alice);
        market.addObserver(bob);
        market.addObserver(alertSystem);

        market.updatePrice("AAPL", 150.0);
        market.updatePrice("AAPL", 157.0); // +7 → alert!
        market.updatePrice("TSLA", 200.0);
        market.updatePrice("GOOGL", 2800.0);

        // 3. Property change
        System.out.println("\n=== Property Change Observer ===");
        UserProfile profile = new UserProfile();
        profile.onNameChange(n  -> System.out.println("Name updated: " + n));
        profile.onEmailChange(e -> System.out.println("Email updated: " + e));
        profile.setName("Alice");
        profile.setEmail("alice@example.com");

        // 4. Typed event bus
        System.out.println("\n=== Typed Event Bus ===");
        TypedEventBus bus = new TypedEventBus();
        bus.subscribe(UserCreatedEvent.class, e ->
            System.out.println("Welcome email sent to: " + e.name()));
        bus.subscribe(UserCreatedEvent.class, e ->
            System.out.println("Audit log: user created " + e.userId()));
        bus.subscribe(OrderPlacedEvent.class, e ->
            System.out.printf("Order %s: processing payment $%.2f%n", e.orderId(), e.amount()));

        bus.publish(new UserCreatedEvent("U001", "Alice"));
        bus.publish(new OrderPlacedEvent("O001", 99.99));

        System.out.println("\n=== Observer Summary ===");
        System.out.println("Subject (Publisher) → notifies registered Observers");
        System.out.println("Loose coupling: subject doesn't know concrete observers");
        System.out.println("Use: event systems, MVC (Model notifies View), reactive");
        System.out.println("Java: PropertyChangeListener, Listeners, Reactive Streams");
    }
}
