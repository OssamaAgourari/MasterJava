package org.example.DataStructures.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ============================================================
 *            STACK CHALLENGES — LeetCode Style
 * ============================================================
 */
public class StackChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Valid Parentheses
    // Return true if brackets are balanced.
    // Example: "(())" → true,  "(]" → false,  "([)]" → false
    // =========================================================
    static boolean isValid(String s) {
        // TODO
        return false;
    }

    // =========================================================
    // CHALLENGE 2  [EASY]  — Implement Queue Using Two Stacks
    // push(x), pop(), peek(), empty()  — all amortized O(1)
    // =========================================================
    static class MyQueue {
        // TODO: declare two stacks

        void push(int x) { /* TODO */ }
        int  pop()       { /* TODO */ return -1; }
        int  peek()      { /* TODO */ return -1; }
        boolean empty()  { /* TODO */ return true; }
    }

    // =========================================================
    // CHALLENGE 3  [EASY]  — Min Stack
    // push, pop, top, getMin — all O(1)
    // =========================================================
    static class MinStack {
        // TODO

        void push(int val) { /* TODO */ }
        void pop()         { /* TODO */ }
        int  top()         { /* TODO */ return -1; }
        int  getMin()      { /* TODO */ return -1; }
    }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Daily Temperatures
    // Given temperatures array, return array where answer[i] =
    // number of days to wait for a warmer temperature (0 if none).
    // Example: [73,74,75,71,69,72,76,73] → [1,1,4,2,1,1,0,0]
    // Hint: monotonic decreasing stack
    // =========================================================
    static int[] dailyTemperatures(int[] temperatures) {
        // TODO
        return new int[0];
    }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Evaluate Reverse Polish Notation
    // Valid operators: + - * /   (integer division truncates to 0)
    // Example: ["2","1","+","3","*"] → 9
    //          ["4","13","5","/","+"] → 6
    // =========================================================
    static int evalRPN(String[] tokens) {
        // TODO
        return 0;
    }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Largest Rectangle in Histogram
    // Given array of bar heights, find the largest rectangle area.
    // Example: [2,1,5,6,2,3] → 10
    // Hint: monotonic increasing stack
    // =========================================================
    static int largestRectangleArea(int[] heights) {
        // TODO
        return 0;
    }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Decode String
    // k[encoded_string] → repeat encoded_string k times
    // Example: "3[a]2[bc]" → "aaabcbc"
    //          "3[a2[c]]"  → "accaccacc"
    // =========================================================
    static String decodeString(String s) {
        // TODO
        return "";
    }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Remove K Digits
    // Remove k digits from number string to make the smallest number.
    // Example: "1432219", k=3 → "1219"
    //          "10200",   k=1 → "200"
    // Hint: monotonic increasing stack
    // =========================================================
    static String removeKdigits(String num, int k) {
        // TODO
        return "";
    }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Trapping Rain Water
    // Given elevation map, compute how much water can be trapped.
    // Example: [0,1,0,2,1,0,1,3,2,1,2,1] → 6
    // Hint: monotonic stack or two-pointer
    // =========================================================
    static int trap(int[] height) {
        // TODO
        return 0;
    }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Basic Calculator II
    // Evaluate expression string with +, -, *, / and spaces.
    // No parentheses. Integer division truncates toward zero.
    // Example: "3+2*2" → 7,  " 3/2 " → 1,  " 3+5 / 2" → 5
    // =========================================================
    static int calculate(String s) {
        // TODO
        return 0;
    }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", isValid("(())"),   true)  ? 1:0; fail += check("C1a", isValid("(())"),   true)  ? 0:1;
        pass += check("C1b", isValid("(]"),     false) ? 1:0; fail += check("C1b", isValid("(]"),     false) ? 0:1;
        pass += check("C1c", isValid("([{}])"), true)  ? 1:0; fail += check("C1c", isValid("([{}])"), true)  ? 0:1;

        MyQueue q = new MyQueue();
        q.push(1); q.push(2); q.push(3);
        pass += check("C2a", q.peek(), 1) ? 1:0; fail += check("C2a", q.peek(), 1) ? 0:1;
        pass += check("C2b", q.pop(),  1) ? 1:0; fail += check("C2b", q.pop(),  1) ? 0:1;
        pass += check("C2c", q.peek(), 2) ? 1:0; fail += check("C2c", q.peek(), 2) ? 0:1;

        MinStack ms = new MinStack();
        ms.push(5); ms.push(3); ms.push(7); ms.push(2);
        pass += check("C3a", ms.getMin(), 2) ? 1:0; fail += check("C3a", ms.getMin(), 2) ? 0:1;
        ms.pop();
        pass += check("C3b", ms.getMin(), 3) ? 1:0; fail += check("C3b", ms.getMin(), 3) ? 0:1;

        pass += checkArr("C4a", dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}), new int[]{1,1,4,2,1,1,0,0}) ? 1:0;
        fail += checkArr("C4a", dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}), new int[]{1,1,4,2,1,1,0,0}) ? 0:1;

        pass += check("C5a", evalRPN(new String[]{"2","1","+","3","*"}),  9) ? 1:0;
        fail += check("C5a", evalRPN(new String[]{"2","1","+","3","*"}),  9) ? 0:1;
        pass += check("C5b", evalRPN(new String[]{"4","13","5","/","+"}), 6) ? 1:0;
        fail += check("C5b", evalRPN(new String[]{"4","13","5","/","+"}), 6) ? 0:1;

        pass += check("C6a", largestRectangleArea(new int[]{2,1,5,6,2,3}), 10) ? 1:0;
        fail += check("C6a", largestRectangleArea(new int[]{2,1,5,6,2,3}), 10) ? 0:1;

        pass += check("C7a", decodeString("3[a]2[bc]"),  "aaabcbc")  ? 1:0; fail += check("C7a", decodeString("3[a]2[bc]"),  "aaabcbc")  ? 0:1;
        pass += check("C7b", decodeString("3[a2[c]]"),   "accaccacc")? 1:0; fail += check("C7b", decodeString("3[a2[c]]"),   "accaccacc")? 0:1;

        pass += check("C8a", removeKdigits("1432219", 3), "1219") ? 1:0; fail += check("C8a", removeKdigits("1432219", 3), "1219") ? 0:1;
        pass += check("C8b", removeKdigits("10200",   1), "200")  ? 1:0; fail += check("C8b", removeKdigits("10200",   1), "200")  ? 0:1;

        pass += check("C9a", trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}), 6) ? 1:0;
        fail += check("C9a", trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}), 6) ? 0:1;

        pass += check("C10a", calculate("3+2*2"),    7) ? 1:0; fail += check("C10a", calculate("3+2*2"),    7) ? 0:1;
        pass += check("C10b", calculate(" 3/2 "),    1) ? 1:0; fail += check("C10b", calculate(" 3/2 "),    1) ? 0:1;
        pass += check("C10c", calculate(" 3+5 / 2"), 5) ? 1:0; fail += check("C10c", calculate(" 3+5 / 2"), 5) ? 0:1;

        System.out.println("\n==============================");
        System.out.println("  RESULTS: " + pass + " passed, " + fail + " failed");
        System.out.println("==============================");
    }

    private static boolean check(String n, Object got, Object exp) {
        boolean ok = String.valueOf(got).equals(String.valueOf(exp));
        System.out.printf("%-6s %s  (exp:%s | got:%s)%n", n, ok?"✔":"✘", exp, got);
        return ok;
    }
    private static boolean checkArr(String n, int[] got, int[] exp) {
        boolean ok = java.util.Arrays.equals(got, exp);
        System.out.printf("%-6s %s  (exp:%s | got:%s)%n", n, ok?"✔":"✘",
                java.util.Arrays.toString(exp), java.util.Arrays.toString(got));
        return ok;
    }
}
