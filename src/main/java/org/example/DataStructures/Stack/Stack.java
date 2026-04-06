package org.example.DataStructures.Stack;

import java.util.EmptyStackException;

/**
 * ============================================================
 *                  STACK — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS A STACK?
 * -----------------
 * A LIFO (Last In, First Out) data structure. The last element
 * pushed is the first one popped. Think of a stack of plates.
 *
 *   push(1) push(2) push(3)
 *   stack: [1, 2, 3] ← top
 *   pop()  → 3
 *   peek() → 2 (no removal)
 *
 * TIME COMPLEXITY:
 * -----------------
 *   Operation | Time | Notes
 *   ----------|------|---------------------------
 *   push      | O(1) | add to top
 *   pop       | O(1) | remove from top
 *   peek/top  | O(1) | read top without removing
 *   isEmpty   | O(1) | check if empty
 *   size      | O(1) | number of elements
 *   search    | O(n) | linear scan
 *
 * SPACE: O(n)
 *
 * IMPLEMENTATIONS:
 * -----------------
 *   1. Array-based  — O(1) all ops, cache-friendly, fixed/resizable
 *   2. Linked-list  — O(1) all ops, dynamic, extra pointer overhead
 *
 * JAVA BUILT-INS:
 * ----------------
 *   java.util.Stack<E>     → legacy, extends Vector (synchronized)
 *   java.util.Deque<E>     → preferred: ArrayDeque as stack
 *     Deque<Integer> stack = new ArrayDeque<>();
 *     stack.push(x)   ↔ addFirst(x)
 *     stack.pop()     ↔ removeFirst()
 *     stack.peek()    ↔ peekFirst()
 *
 * CLASSIC USE CASES:
 * -------------------
 *   ✔ Function call stack (recursion)
 *   ✔ Balanced parentheses / bracket matching
 *   ✔ Undo/Redo operations
 *   ✔ DFS (Depth-First Search)
 *   ✔ Infix → Postfix expression conversion
 *   ✔ Next Greater Element problems
 *   ✔ Monotonic stack patterns
 *
 * ============================================================
 */
public class Stack {

    // ─── Array-based Stack ────────────────────────────────────
    static class ArrayStack {
        private int[] data;
        private int   top = -1;

        ArrayStack(int capacity) { data = new int[capacity]; }

        void push(int val) {
            if (top == data.length - 1) throw new RuntimeException("Stack overflow");
            data[++top] = val;
        }

        int pop() {
            if (isEmpty()) throw new EmptyStackException();
            return data[top--];
        }

        int peek() {
            if (isEmpty()) throw new EmptyStackException();
            return data[top];
        }

        boolean isEmpty() { return top == -1; }
        int     size()    { return top + 1; }

        @Override public String toString() {
            if (isEmpty()) return "[]";
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i <= top; i++) sb.append(data[i]).append(i < top ? ", " : "");
            return sb.append("] ← top(" + data[top] + ")").toString();
        }
    }

    // ─── Linked-list-based Stack ──────────────────────────────
    static class Node { int val; Node next; Node(int v, Node n){val=v;next=n;} }

    static class LinkedStack {
        private Node top;
        private int  size;

        void push(int val) { top = new Node(val, top); size++; }

        int pop() {
            if (top == null) throw new EmptyStackException();
            int val = top.val; top = top.next; size--; return val;
        }

        int  peek()    { if (top==null) throw new EmptyStackException(); return top.val; }
        boolean isEmpty() { return top == null; }
        int     size()    { return size; }
    }

    public static void main(String[] args) {

        // EXERCISE 1: Basic push/pop/peek
        ArrayStack stack = new ArrayStack(10);
        stack.push(10); stack.push(20); stack.push(30);
        System.out.println("Stack:   " + stack);        // [10, 20, 30] ← top(30)
        System.out.println("peek():  " + stack.peek()); // 30
        System.out.println("pop():   " + stack.pop());  // 30
        System.out.println("After:   " + stack);        // [10, 20] ← top(20)
        System.out.println("size:    " + stack.size()); // 2

        // EXERCISE 2: Balanced parentheses — classic stack problem
        String[] tests = {"(())", "([{}])", "(]", "(()", "{[()]}"};
        for (String s : tests)
            System.out.println("\"" + s + "\" balanced: " + isBalanced(s));

        // EXERCISE 3: Reverse a string using stack
        String original = "Hello";
        ArrayStack charStack = new ArrayStack(original.length());
        for (char ch : original.toCharArray()) charStack.push(ch);
        StringBuilder reversed = new StringBuilder();
        while (!charStack.isEmpty()) reversed.append((char)charStack.pop());
        System.out.println("Reversed: " + reversed); // olleH

        // EXERCISE 4: Evaluate postfix expression (RPN)
        // "3 4 + 2 * 7 /"  → (3+4)*2/7 = 2
        System.out.println("Postfix '3 4 + 2 * 7 /': " + evalPostfix("3 4 + 2 * 7 /"));

        // EXERCISE 5: Next Greater Element
        int[] arr = {4, 5, 2, 10, 8};
        int[] nge = nextGreaterElement(arr);
        System.out.println("NGE of [4,5,2,10,8]: " + java.util.Arrays.toString(nge));
        // [5, 10, 10, -1, -1]

        // EXERCISE 6: Min Stack — O(1) getMin
        MinStack minStack = new MinStack();
        minStack.push(5); minStack.push(3); minStack.push(7); minStack.push(2);
        System.out.println("Min: " + minStack.getMin()); // 2
        minStack.pop();
        System.out.println("Min after pop: " + minStack.getMin()); // 3

        // EXERCISE 7: Decode string "3[a2[c]]" → "accaccacc"
        System.out.println("Decode '3[a2[c]]': " + decodeString("3[a2[c]]"));
        System.out.println("Decode '2[abc]3[cd]ef': " + decodeString("2[abc]3[cd]ef"));

        // EXERCISE 8: Java built-in Deque as stack
        java.util.Deque<Integer> dequeStack = new java.util.ArrayDeque<>();
        dequeStack.push(1); dequeStack.push(2); dequeStack.push(3);
        System.out.println("Deque stack peek: " + dequeStack.peek()); // 3
        System.out.println("Deque stack pop:  " + dequeStack.pop());  // 3

        // SUMMARY
        System.out.println("\n=== Stack Time Complexity ===");
        System.out.println("push   O(1)");
        System.out.println("pop    O(1)");
        System.out.println("peek   O(1)");
        System.out.println("search O(n)");
        System.out.println("Use ArrayDeque (not Stack class) in Java!");
    }

    // ── Helper algorithms ─────────────────────────────────────

    static boolean isBalanced(String s) {
        java.util.Deque<Character> st = new java.util.ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c=='(' || c=='[' || c=='{') st.push(c);
            else if (c==')') { if (st.isEmpty()||st.pop()!='(') return false; }
            else if (c==']') { if (st.isEmpty()||st.pop()!='[') return false; }
            else if (c=='}') { if (st.isEmpty()||st.pop()!='{') return false; }
        }
        return st.isEmpty();
    }

    static int evalPostfix(String expr) {
        java.util.Deque<Integer> st = new java.util.ArrayDeque<>();
        for (String token : expr.split(" ")) {
            switch (token) {
                case "+" -> { int b=st.pop(),a=st.pop(); st.push(a+b); }
                case "-" -> { int b=st.pop(),a=st.pop(); st.push(a-b); }
                case "*" -> { int b=st.pop(),a=st.pop(); st.push(a*b); }
                case "/" -> { int b=st.pop(),a=st.pop(); st.push(a/b); }
                default  -> st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }

    static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        java.util.Arrays.fill(result, -1);
        java.util.Deque<Integer> stack = new java.util.ArrayDeque<>(); // stores indices
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()])
                result[stack.pop()] = arr[i];
            stack.push(i);
        }
        return result;
    }

    static String decodeString(String s) {
        java.util.Deque<Integer> counts = new java.util.ArrayDeque<>();
        java.util.Deque<StringBuilder> strings = new java.util.ArrayDeque<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) { k = k*10 + (c-'0'); }
            else if (c == '[') { counts.push(k); strings.push(cur); cur = new StringBuilder(); k = 0; }
            else if (c == ']') { StringBuilder tmp = cur; cur = strings.pop(); int rep = counts.pop(); while (rep-- > 0) cur.append(tmp); }
            else cur.append(c);
        }
        return cur.toString();
    }

    // Min Stack: O(1) getMin using auxiliary stack
    static class MinStack {
        java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();
        java.util.Deque<Integer> minSt = new java.util.ArrayDeque<>();
        void push(int v) { stack.push(v); minSt.push(minSt.isEmpty() ? v : Math.min(v, minSt.peek())); }
        void pop()       { stack.pop(); minSt.pop(); }
        int peek()       { return stack.peek(); }
        int getMin()     { return minSt.peek(); }
    }
}
