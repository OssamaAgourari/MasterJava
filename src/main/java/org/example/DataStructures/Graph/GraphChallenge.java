package org.example.DataStructures.Graph;

import java.util.*;

/**
 * ============================================================
 *            GRAPH CHALLENGES — LeetCode Style
 * ============================================================
 */
public class GraphChallenge {

    // =========================================================
    // CHALLENGE 1  [EASY]  — Find if Path Exists in Graph
    // Given n nodes, edges list, source and destination.
    // Return true if there is a valid path from source to destination.
    // =========================================================
    static boolean validPath(int n, int[][] edges, int src, int dst) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 2  [MEDIUM]  — Number of Islands
    // '1'=land, '0'=water. Count distinct islands.
    // Example: [["1","1","0"],["1","1","0"],["0","0","1"]] → 2
    // =========================================================
    static int numIslands(char[][] grid) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 3  [MEDIUM]  — Clone Graph
    // Deep copy an undirected graph. Each node has val and List<Node> neighbors.
    // =========================================================
    static class Node { int val; List<Node> neighbors; Node(int v){val=v;neighbors=new ArrayList<>();} }
    static Node cloneGraph(Node node) { return null; /* TODO */ }

    // =========================================================
    // CHALLENGE 4  [MEDIUM]  — Course Schedule
    // Return true if you can finish all courses (no cycle in DAG).
    // Example: n=2, [[1,0]] → true    [[1,0],[0,1]] → false
    // =========================================================
    static boolean canFinish(int n, int[][] prereqs) { return false; /* TODO */ }

    // =========================================================
    // CHALLENGE 5  [MEDIUM]  — Course Schedule II
    // Return the ordering to take all courses, or [] if impossible.
    // Example: n=4, [[1,0],[2,0],[3,1],[3,2]] → [0,1,2,3] or [0,2,1,3]
    // =========================================================
    static int[] findOrder(int n, int[][] prereqs) { return new int[0]; /* TODO */ }

    // =========================================================
    // CHALLENGE 6  [MEDIUM]  — Rotting Oranges
    // 0=empty, 1=fresh, 2=rotten. Each minute rotten spreads to 4-neighbors.
    // Return min minutes until no fresh, or -1.
    // Example: [[2,1,1],[1,1,0],[0,1,1]] → 4
    // =========================================================
    static int orangesRotting(int[][] grid) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 7  [MEDIUM]  — Pacific Atlantic Water Flow
    // Water can flow to adjacent cells with equal or lower height.
    // Find cells from which water can reach BOTH oceans.
    // =========================================================
    static List<List<Integer>> pacificAtlantic(int[][] heights) { return new ArrayList<>(); /* TODO */ }

    // =========================================================
    // CHALLENGE 8  [MEDIUM]  — Number of Connected Components
    // n nodes, edges list. Return number of connected components.
    // Example: n=5, [[0,1],[1,2],[3,4]] → 2
    // =========================================================
    static int countComponents(int n, int[][] edges) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 9  [HARD]  — Word Ladder
    // Transform beginWord to endWord by changing one letter at a time.
    // Each intermediate word must be in wordList.
    // Return length of shortest transformation sequence.
    // Example: beginWord="hit", endWord="cog", wordList=["hot","dot","dog","lot","log","cog"] → 5
    // =========================================================
    static int ladderLength(String beginWord, String endWord, List<String> wordList) { return 0; /* TODO */ }

    // =========================================================
    // CHALLENGE 10  [HARD]  — Shortest Path in Binary Matrix
    // 0=open, 1=blocked. Move 8-directionally. Return shortest path
    // from (0,0) to (n-1,n-1), or -1 if impossible.
    // Example: [[0,0,0],[1,1,0],[1,1,0]] → 4
    // =========================================================
    static int shortestPathBinaryMatrix(int[][] grid) { return 0; /* TODO */ }

    // ============================================================
    //  TEST RUNNER
    // ============================================================
    public static void main(String[] args) {
        int pass = 0, fail = 0;

        // C1
        pass += check("C1a", validPath(3,new int[][]{{0,1},{1,2},{2,0}},0,2), true)  ? 1:0;
        fail += check("C1a", validPath(3,new int[][]{{0,1},{1,2},{2,0}},0,2), true)  ? 0:1;
        pass += check("C1b", validPath(6,new int[][]{{0,1},{0,2},{3,5},{5,4},{2,3}},0,5), true) ? 1:0;
        fail += check("C1b", validPath(6,new int[][]{{0,1},{0,2},{3,5},{5,4},{2,3}},0,5), true) ? 0:1;

        // C2
        pass += check("C2a", numIslands(new char[][]{{'1','1','0'},{'1','1','0'},{'0','0','1'}}), 2) ? 1:0;
        fail += check("C2a", numIslands(new char[][]{{'1','1','0'},{'1','1','0'},{'0','0','1'}}), 2) ? 0:1;

        // C4
        pass += check("C4a", canFinish(2, new int[][]{{1,0}}),       true)  ? 1:0;
        fail += check("C4a", canFinish(2, new int[][]{{1,0}}),       true)  ? 0:1;
        pass += check("C4b", canFinish(2, new int[][]{{1,0},{0,1}}), false) ? 1:0;
        fail += check("C4b", canFinish(2, new int[][]{{1,0},{0,1}}), false) ? 0:1;

        // C5
        int[] order = findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
        pass += check("C5a", order.length, 4) ? 1:0;
        fail += check("C5a", order.length, 4) ? 0:1;

        // C6
        pass += check("C6a", orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}), 4) ? 1:0;
        fail += check("C6a", orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}), 4) ? 0:1;
        pass += check("C6b", orangesRotting(new int[][]{{1,2}}), 1) ? 1:0;
        fail += check("C6b", orangesRotting(new int[][]{{1,2}}), 1) ? 0:1;

        // C8
        pass += check("C8a", countComponents(5, new int[][]{{0,1},{1,2},{3,4}}), 2) ? 1:0;
        fail += check("C8a", countComponents(5, new int[][]{{0,1},{1,2},{3,4}}), 2) ? 0:1;

        // C9
        pass += check("C9a", ladderLength("hit","cog",
                Arrays.asList("hot","dot","dog","lot","log","cog")), 5) ? 1:0;
        fail += check("C9a", ladderLength("hit","cog",
                Arrays.asList("hot","dot","dog","lot","log","cog")), 5) ? 0:1;

        // C10
        pass += check("C10a", shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}), 4) ? 1:0;
        fail += check("C10a", shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}), 4) ? 0:1;

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
