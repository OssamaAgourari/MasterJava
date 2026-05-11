package org.example.OOP.Classes;

import java.util.*;

/**
 * ============================================================
 *       CLASSES CHALLENGES — Design & LeetCode Style
 * ============================================================
 */
public class ClassesChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Design Parking System
    // Parking lot with fixed slots (big=1, medium=2, small=3).
    // addCar returns true if space available, false otherwise.
    // =========================================================
    static class ParkingSystem {
        /* TODO */
        ParkingSystem(int big, int medium, int small) {}
        boolean addCar(int carType) { return false; }
    }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Design Counter
    // Counter that increments, decrements, and resets.
    // =========================================================
    static class Counter {
        /* TODO */
        Counter(int initialValue) {}
        void increment() {}
        void decrement() {}
        void reset()     {}
        int  getValue()  { return 0; }
    }

    // =========================================================
    // CHALLENGE 3  [MEDIUM]  — Design HashMap
    // Implement HashMap without built-in hash table libraries.
    // put(key,val), get(key)→val or -1, remove(key)
    // =========================================================
    static class MyHashMap {
        /* TODO: array of linked lists (chaining) */
        MyHashMap() {}
        void put(int key, int value) {}
        int  get(int key)   { return -1; }
        void remove(int key) {}
    }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Min Stack
    // Stack that supports push, pop, top, and getMin in O(1).
    // =========================================================
    static class MinStack {
        /* TODO: two stacks */
        MinStack() {}
        void push(int val) {}
        void pop() {}
        int  top()    { return 0; }
        int  getMin() { return 0; }
    }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — LRU Cache
    // Least Recently Used cache with capacity.
    // get(key)→val or -1, put(key,val) — evict LRU if full.
    // =========================================================
    static class LRUCache {
        /* TODO: LinkedHashMap or doubly-linked list + hashmap */
        LRUCache(int capacity) {}
        int  get(int key)             { return -1; }
        void put(int key, int value)  {}
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Design Twitter
    // postTweet, getNewsFeed (10 most recent), follow, unfollow
    // =========================================================
    static class Twitter {
        /* TODO: HashMap<userId, list of tweets> + PriorityQueue */
        Twitter() {}
        void postTweet(int userId, int tweetId) {}
        List<Integer> getNewsFeed(int userId) { return new ArrayList<>(); }
        void follow(int followerId, int followeeId) {}
        void unfollow(int followerId, int followeeId) {}
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Design Circular Queue (review)
    // Fixed-capacity circular queue.
    // =========================================================
    static class MyCircularQueue {
        /* TODO */
        MyCircularQueue(int k) {}
        boolean enQueue(int value) { return false; }
        boolean deQueue()          { return false; }
        int Front() { return -1; }
        int Rear()  { return -1; }
        boolean isEmpty() { return true; }
        boolean isFull()  { return false; }
    }

    // =========================================================
    // CHALLENGE 8  [HARD]  — Design Skiplist
    // Implement a skiplist supporting add, erase, search.
    // =========================================================
    static class Skiplist {
        /* TODO: multi-level linked list for O(log n) ops */
        Skiplist() {}
        boolean search(int target) { return false; }
        void    add(int num)       {}
        boolean erase(int num)     { return false; }
    }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Design In-Memory File System
    // mkdir, addContentToFile, ls, readContentFromFile
    // =========================================================
    static class FileSystem {
        /* TODO: trie of directories */
        FileSystem() {}
        List<String> ls(String path)                    { return new ArrayList<>(); }
        void mkdir(String path)                         {}
        void addContentToFile(String path, String content) {}
        String readContentFromFile(String path)         { return ""; }
    }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Design Snake Game
    // Grid with food. Snake eats food, grows, dies if hits wall/itself.
    // move("U"/"D"/"L"/"R") returns score or -1 if dead.
    // =========================================================
    static class SnakeGame {
        /* TODO: deque for body, set for occupied cells */
        SnakeGame(int width, int height, int[][] food) {}
        int move(String direction) { return -1; }
    }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // C1: Parking System
        ParkingSystem ps = new ParkingSystem(1, 1, 0);
        pass += check("C1a", ps.addCar(1), true)  ? 1:0; fail += check("C1a", ps.addCar(1), true)  ? 0:1;
        pass += check("C1b", ps.addCar(2), true)  ? 1:0; fail += check("C1b", ps.addCar(2), true)  ? 0:1;
        pass += check("C1c", ps.addCar(3), false) ? 1:0; fail += check("C1c", ps.addCar(3), false) ? 0:1;
        pass += check("C1d", ps.addCar(1), false) ? 1:0; fail += check("C1d", ps.addCar(1), false) ? 0:1;

        // C2: Counter
        Counter c = new Counter(5);
        c.increment(); c.increment();
        pass += check("C2a", c.getValue(), 7) ? 1:0; fail += check("C2a", c.getValue(), 7) ? 0:1;
        c.decrement();
        pass += check("C2b", c.getValue(), 6) ? 1:0; fail += check("C2b", c.getValue(), 6) ? 0:1;
        c.reset();
        pass += check("C2c", c.getValue(), 5) ? 1:0; fail += check("C2c", c.getValue(), 5) ? 0:1;

        // C3: MyHashMap
        MyHashMap map = new MyHashMap();
        map.put(1, 1); map.put(2, 2);
        pass += check("C3a", map.get(1), 1)  ? 1:0; fail += check("C3a", map.get(1), 1)  ? 0:1;
        pass += check("C3b", map.get(3), -1) ? 1:0; fail += check("C3b", map.get(3), -1) ? 0:1;
        map.put(2, 1);
        pass += check("C3c", map.get(2), 1) ? 1:0; fail += check("C3c", map.get(2), 1) ? 0:1;
        map.remove(2);
        pass += check("C3d", map.get(2), -1) ? 1:0; fail += check("C3d", map.get(2), -1) ? 0:1;

        // C4: MinStack
        MinStack ms = new MinStack();
        ms.push(-2); ms.push(0); ms.push(-3);
        pass += check("C4a", ms.getMin(), -3) ? 1:0; fail += check("C4a", ms.getMin(), -3) ? 0:1;
        ms.pop();
        pass += check("C4b", ms.top(),    0)  ? 1:0; fail += check("C4b", ms.top(),    0)  ? 0:1;
        pass += check("C4c", ms.getMin(), -2) ? 1:0; fail += check("C4c", ms.getMin(), -2) ? 0:1;

        // C5: LRU Cache
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1); lru.put(2, 2);
        pass += check("C5a", lru.get(1),  1) ? 1:0; fail += check("C5a", lru.get(1),  1) ? 0:1;
        lru.put(3, 3); // evict key 2
        pass += check("C5b", lru.get(2), -1) ? 1:0; fail += check("C5b", lru.get(2), -1) ? 0:1;
        lru.put(4, 4); // evict key 1
        pass += check("C5c", lru.get(1), -1) ? 1:0; fail += check("C5c", lru.get(1), -1) ? 0:1;
        pass += check("C5d", lru.get(3),  3) ? 1:0; fail += check("C5d", lru.get(3),  3) ? 0:1;
        pass += check("C5e", lru.get(4),  4) ? 1:0; fail += check("C5e", lru.get(4),  4) ? 0:1;

        // C7: Circular Queue
        MyCircularQueue cq = new MyCircularQueue(3);
        pass += check("C7a", cq.enQueue(1), true)  ? 1:0; fail += check("C7a", cq.enQueue(1), true)  ? 0:1;
        pass += check("C7b", cq.enQueue(2), true)  ? 1:0; fail += check("C7b", cq.enQueue(2), true)  ? 0:1;
        pass += check("C7c", cq.enQueue(3), true)  ? 1:0; fail += check("C7c", cq.enQueue(3), true)  ? 0:1;
        pass += check("C7d", cq.enQueue(4), false) ? 1:0; fail += check("C7d", cq.enQueue(4), false) ? 0:1;
        pass += check("C7e", cq.Rear(),     3)     ? 1:0; fail += check("C7e", cq.Rear(),     3)     ? 0:1;

        System.out.println("\n==============================");
        System.out.println("  RESULTS: " + pass + " passed, " + fail + " failed");
        System.out.println("==============================");
    }

    private static boolean check(String n, Object got, Object exp) {
        boolean ok = String.valueOf(got).equals(String.valueOf(exp));
        System.out.printf("%-6s %s  (exp:%s | got:%s)%n", n, ok?"✔":"✘", exp, got);
        return ok;
    }
}
