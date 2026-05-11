package org.example.Algorithms.Greedy;

import java.util.*;

/**
 * ============================================================
 *         GREEDY CHALLENGES — LeetCode Style
 * ============================================================
 */
public class GreedyChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Assign Cookies
    // Maximize content children.
    // Example: g=[1,2,3], s=[1,1] → 1
    // =========================================================
    static int assignCookies(int[] g, int[] s) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 2  [MEDIUM]  — Jump Game
    // Can you reach the last index?
    // Example: [2,3,1,1,4]→true, [3,2,1,0,4]→false
    // =========================================================
    static boolean canJump(int[] nums) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [MEDIUM]  — Jump Game II
    // Minimum jumps to reach last index.
    // Example: [2,3,1,1,4] → 2
    // =========================================================
    static int jump(int[] nums) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Gas Station
    // Find starting index to complete circuit, or -1.
    // Example: gas=[1,2,3,4,5], cost=[3,4,5,1,2] → 3
    // =========================================================
    static int canCompleteCircuit(int[] gas, int[] cost) { return -1; /* TODO */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Non-overlapping Intervals
    // Min intervals to remove to make rest non-overlapping.
    // Example: [[1,2],[2,3],[3,4],[1,3]] → 1
    // =========================================================
    static int eraseOverlapIntervals(int[][] intervals) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Minimum Number of Arrows
    // Burst all balloons (intervals) with min arrows.
    // Example: [[10,16],[2,8],[1,6],[7,12]] → 2
    // =========================================================
    static int findMinArrowShots(int[][] points) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Task Scheduler
    // Min intervals with cooldown n between same tasks.
    // Example: ['A','A','A','B','B','B'], n=2 → 8
    // =========================================================
    static int leastInterval(char[] tasks, int n) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Partition Labels
    // Partition so each letter appears in at most one part.
    // Maximize number of parts. Return part sizes.
    // Example: "ababcbacadefegdehijhklij" → [9,7,8]
    // =========================================================
    static List<Integer> partitionLabels(String s) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 9  [MEDIUM]  — Boats to Save People
    // Each boat carries at most 2 people with weight ≤ limit.
    // Min boats needed.
    // Example: [1,2], limit=3 → 1
    //          [3,2,2,1], limit=3 → 3
    // =========================================================
    static int numRescueBoats(int[] people, int limit) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — IPO (Maximize Capital)
    // Pick at most k projects to maximize capital.
    // w=initial capital, profits/capital arrays.
    // Example: k=2, w=0, profits=[1,2,3], capital=[0,1,1] → 4
    // =========================================================
    static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) { return w; /* TODO */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        pass += check("C1a", assignCookies(new int[]{1,2,3}, new int[]{1,1}), 1) ? 1:0;
        fail += check("C1a", assignCookies(new int[]{1,2,3}, new int[]{1,1}), 1) ? 0:1;
        pass += check("C1b", assignCookies(new int[]{1,2}, new int[]{1,2,3}), 2) ? 1:0;
        fail += check("C1b", assignCookies(new int[]{1,2}, new int[]{1,2,3}), 2) ? 0:1;

        pass += check("C2a", canJump(new int[]{2,3,1,1,4}), true)  ? 1:0;
        fail += check("C2a", canJump(new int[]{2,3,1,1,4}), true)  ? 0:1;
        pass += check("C2b", canJump(new int[]{3,2,1,0,4}), false) ? 1:0;
        fail += check("C2b", canJump(new int[]{3,2,1,0,4}), false) ? 0:1;

        pass += check("C3a", jump(new int[]{2,3,1,1,4}), 2) ? 1:0;
        fail += check("C3a", jump(new int[]{2,3,1,1,4}), 2) ? 0:1;
        pass += check("C3b", jump(new int[]{2,3,0,1,4}), 2) ? 1:0;
        fail += check("C3b", jump(new int[]{2,3,0,1,4}), 2) ? 0:1;

        pass += check("C4a", canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}), 3) ? 1:0;
        fail += check("C4a", canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}), 3) ? 0:1;
        pass += check("C4b", canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}), -1) ? 1:0;
        fail += check("C4b", canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}), -1) ? 0:1;

        pass += check("C5a", eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}), 1) ? 1:0;
        fail += check("C5a", eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}), 1) ? 0:1;
        pass += check("C5b", eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}), 2) ? 1:0;
        fail += check("C5b", eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}), 2) ? 0:1;

        pass += check("C6a", findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}), 2) ? 1:0;
        fail += check("C6a", findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}), 2) ? 0:1;

        pass += check("C7a", leastInterval(new char[]{'A','A','A','B','B','B'}, 2), 8) ? 1:0;
        fail += check("C7a", leastInterval(new char[]{'A','A','A','B','B','B'}, 2), 8) ? 0:1;

        pass += check("C8a", partitionLabels("ababcbacadefegdehijhklij").toString(), "[9, 7, 8]") ? 1:0;
        fail += check("C8a", partitionLabels("ababcbacadefegdehijhklij").toString(), "[9, 7, 8]") ? 0:1;

        pass += check("C9a", numRescueBoats(new int[]{1,2}, 3), 1) ? 1:0;
        fail += check("C9a", numRescueBoats(new int[]{1,2}, 3), 1) ? 0:1;
        pass += check("C9b", numRescueBoats(new int[]{3,2,2,1}, 3), 3) ? 1:0;
        fail += check("C9b", numRescueBoats(new int[]{3,2,2,1}, 3), 3) ? 0:1;

        pass += check("C10a", findMaximizedCapital(2, 0, new int[]{1,2,3}, new int[]{0,1,1}), 4) ? 1:0;
        fail += check("C10a", findMaximizedCapital(2, 0, new int[]{1,2,3}, new int[]{0,1,1}), 4) ? 0:1;

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
