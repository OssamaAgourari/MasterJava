package org.example.Algorithms.Greedy;

import java.util.*;

/**
 * ============================================================
 *               GREEDY ALGORITHMS — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS GREEDY?
 * ----------------
 * Make the locally optimal choice at each step, hoping it
 * leads to a globally optimal solution.
 *
 * NO backtracking — each decision is final.
 *
 * WHEN DOES GREEDY WORK?
 * -----------------------
 *   1. GREEDY CHOICE PROPERTY:
 *      A globally optimal solution can be built by making
 *      locally optimal choices.
 *   2. OPTIMAL SUBSTRUCTURE:
 *      Optimal solution contains optimal solutions to sub-problems.
 *
 * GREEDY vs DP:
 * --------------
 *   Greedy: one decision, move forward — O(n log n) or O(n)
 *   DP:     explores all choices, remembers results — O(n²) or O(n·k)
 *   Use Greedy when you can prove the greedy choice is safe.
 *   Use DP when Greedy gives wrong answers (e.g., 0/1 knapsack).
 *
 * CLASSIC PROBLEMS:
 * ------------------
 *   Activity selection, Interval scheduling
 *   Huffman coding, Fractional knapsack
 *   Jump game, Gas station
 *   Minimum spanning tree (Kruskal, Prim)
 *   Dijkstra's shortest path
 *   Task scheduling (minimize lateness)
 *
 * ============================================================
 */
public class Greedy {

    // ── 1. Activity Selection (Interval Scheduling) ──────────
    // Select max non-overlapping intervals. Sort by END time.
    // Time O(n log n)
    static int activitySelection(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]); // sort by end time
        int count = 1, end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) { count++; end = intervals[i][1]; }
        }
        return count;
    }

    // ── 2. Merge Intervals ────────────────────────────────────
    static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0].clone());
        for (int i = 1; i < intervals.length; i++) {
            int[] last = result.get(result.size() - 1);
            if (intervals[i][0] <= last[1]) last[1] = Math.max(last[1], intervals[i][1]);
            else result.add(intervals[i].clone());
        }
        return result.toArray(new int[0][]);
    }

    // ── 3. Jump Game I — Can reach end? ──────────────────────
    // Greedy: track max reachable index
    // Time O(n)
    static boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }

    // ── 4. Jump Game II — Min jumps to reach end ─────────────
    // Greedy: at each step, jump as far as possible
    // Time O(n)
    static int jumpMinSteps(int[] nums) {
        int jumps = 0, curEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == curEnd) { jumps++; curEnd = farthest; }
        }
        return jumps;
    }

    // ── 5. Gas Station ───────────────────────────────────────
    // Find starting gas station to complete circuit. -1 if none.
    // Time O(n)
    static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, tank = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            tank     += gas[i] - cost[i];
            if (tank < 0) { start = i + 1; tank = 0; } // can't start here or before
        }
        return totalGas < 0 ? -1 : start;
    }

    // ── 6. Assign Cookies ────────────────────────────────────
    // Maximize content children. g[i]=greed, s[j]=cookie size.
    // Time O(n log n)
    static int assignCookies(int[] g, int[] s) {
        Arrays.sort(g); Arrays.sort(s);
        int child = 0, cookie = 0;
        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) child++;
            cookie++;
        }
        return child;
    }

    // ── 7. Fractional Knapsack ────────────────────────────────
    // Items with weight+value. Maximize value in capacity W.
    // Sort by value/weight ratio descending. O(n log n)
    static double fractionalKnapsack(int W, int[][] items) {
        // items[i] = {weight, value}
        Arrays.sort(items, (a, b) -> Double.compare((double)b[1]/b[0], (double)a[1]/a[0]));
        double total = 0;
        for (int[] item : items) {
            if (W >= item[0]) { total += item[1]; W -= item[0]; }
            else              { total += (double) item[1] * W / item[0]; break; }
        }
        return total;
    }

    // ── 8. Minimum Platforms / Meeting Rooms ─────────────────
    // Min rooms needed so no two meetings overlap.
    // Time O(n log n)
    static int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n], ends = new int[n];
        for (int i = 0; i < n; i++) { starts[i] = intervals[i][0]; ends[i] = intervals[i][1]; }
        Arrays.sort(starts); Arrays.sort(ends);
        int rooms = 0, maxRooms = 0, e = 0;
        for (int s = 0; s < n; s++) {
            if (starts[s] < ends[e]) rooms++;
            else e++;
            maxRooms = Math.max(maxRooms, rooms);
        }
        return maxRooms;
    }

    // ── 9. Task Scheduler ─────────────────────────────────────
    // Min intervals to finish all tasks with cooldown n.
    // Time O(n)
    static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) freq[t - 'A']++;
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int idleSlots = (maxFreq - 1) * n;
        for (int i = 24; i >= 0 && freq[i] > 0; i--) idleSlots -= Math.min(freq[i], maxFreq - 1);
        return tasks.length + Math.max(0, idleSlots);
    }

    // ── 10. Two City Scheduling ───────────────────────────────
    // Send n people to city A, n to city B. Minimize total cost.
    // costs[i] = [costA, costB]. Sort by diff(costA - costB).
    // Time O(n log n)
    static int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        int total = 0, n = costs.length / 2;
        for (int i = 0;     i < n;            i++) total += costs[i][0];
        for (int i = n; i < costs.length;     i++) total += costs[i][1];
        return total;
    }

    public static void main(String[] args) {

        // EXERCISE 1: Activity Selection
        int[][] intervals = {{1,3},{2,4},{3,5},{0,6},{5,7},{3,8},{5,9},{6,10},{8,11},{8,12},{2,13},{12,14}};
        System.out.println("Max activities: " + activitySelection(intervals)); // 4

        // EXERCISE 2: Merge intervals
        int[][] merged = mergeIntervals(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        System.out.println("Merged intervals: " + Arrays.deepToString(merged)); // [[1,6],[8,10],[15,18]]

        // EXERCISE 3: Jump game
        System.out.println("Can jump [2,3,1,1,4]: " + canJump(new int[]{2,3,1,1,4})); // true
        System.out.println("Can jump [3,2,1,0,4]: " + canJump(new int[]{3,2,1,0,4})); // false

        // EXERCISE 4: Min jumps
        System.out.println("Min jumps [2,3,1,1,4]: " + jumpMinSteps(new int[]{2,3,1,1,4})); // 2

        // EXERCISE 5: Gas station
        System.out.println("Gas station: " + canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2})); // 3

        // EXERCISE 6: Assign cookies
        System.out.println("Cookies: " + assignCookies(new int[]{1,2,3}, new int[]{1,1})); // 1

        // EXERCISE 7: Fractional knapsack
        int[][] items = {{10, 60}, {20, 100}, {30, 120}};
        System.out.printf("Knapsack (W=50): %.1f%n", fractionalKnapsack(50, items)); // 240.0

        // EXERCISE 8: Meeting rooms
        System.out.println("Meeting rooms: " + minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}})); // 2

        // EXERCISE 9: Task scheduler
        System.out.println("Least interval: " + leastInterval(new char[]{'A','A','A','B','B','B'}, 2)); // 8

        // EXERCISE 10: Two city scheduling
        System.out.println("Two city cost: " + twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20}})); // 110

        // SUMMARY
        System.out.println("\n=== Greedy ===");
        System.out.println("Make locally optimal choice at each step");
        System.out.println("Works when: greedy choice property + optimal substructure");
        System.out.println("Faster than DP: O(n log n) vs O(n²) typically");
        System.out.println("Common trick: sort by end time / ratio / difference");
    }
}
