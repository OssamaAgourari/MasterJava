package org.example.Algorithms.Searching;

import java.util.*;

/**
 * ============================================================
 *          SEARCHING ALGORITHMS — COMPARISON GUIDE
 * ============================================================
 *
 * ┌──────────────────┬──────────┬──────────┬──────────┬─────────────────────────────────┐
 * │   Algorithm      │  Best    │ Average  │  Worst   │         Notes                   │
 * ├──────────────────┼──────────┼──────────┼──────────┼─────────────────────────────────┤
 * │ Linear Search    │  O(1)    │  O(n)    │  O(n)    │ Works on unsorted, any structure│
 * │ Binary Search    │  O(1)    │ O(log n) │ O(log n) │ SORTED array required           │
 * │ Jump Search      │  O(1)    │ O(√n)    │ O(√n)    │ Sorted, better than linear      │
 * │ Interpolation    │  O(1)    │ O(log log n)│ O(n) │ Uniformly distributed, sorted   │
 * │ Exponential      │  O(1)    │ O(log n) │ O(log n) │ Unbounded/infinite arrays       │
 * │ Fibonacci        │  O(1)    │ O(log n) │ O(log n) │ Sorted, reduces comparisons     │
 * │ BFS (graph)      │  O(1)    │ O(V+E)   │ O(V+E)   │ Unweighted shortest path        │
 * │ DFS (graph)      │  O(1)    │ O(V+E)   │ O(V+E)   │ Exhaustive, backtracks          │
 * │ Ternary Search   │  O(1)    │ O(log n) │ O(log n) │ Unimodal function, find max/min │
 * └──────────────────┴──────────┴──────────┴──────────┴─────────────────────────────────┘
 *
 * WHEN TO USE EACH:
 * ------------------
 *   LINEAR   → unsorted, small arrays, linked lists, find ALL occurrences
 *   BINARY   → sorted array, O(log n), most common in interviews
 *   JUMP     → sorted array, better than linear for large sorted arrays
 *   INTERP   → sorted + uniformly distributed (phone book, uniform data)
 *   BFS      → find shortest path in unweighted graph/grid
 *   DFS      → exhaustive search, maze, tree traversal
 *
 * ============================================================
 */
public class SearchingComparison {

    // ── 1. Linear Search ─────────────────────────────────────
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target) return i;
        return -1;
    }

    // ── 2. Binary Search ──────────────────────────────────────
    static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (arr[mid] == target) return mid;
            else if (arr[mid] <  target) lo = mid + 1;
            else                         hi = mid - 1;
        }
        return -1;
    }

    // ── 3. Jump Search O(√n) ──────────────────────────────────
    static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.sqrt(n);
        int prev = 0;

        // jump forward in blocks of √n
        while (prev < n && arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) return -1;
        }
        // linear search within block
        while (prev < Math.min(step, n)) {
            if (arr[prev] == target) return prev;
            prev++;
        }
        return -1;
    }

    // ── 4. Interpolation Search ───────────────────────────────
    // Best for uniformly distributed sorted data: O(log log n) avg
    static int interpolationSearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi && target >= arr[lo] && target <= arr[hi]) {
            if (lo == hi) { return arr[lo] == target ? lo : -1; }
            // probe position formula
            int pos = lo + (int) ((long)(hi - lo) * (target - arr[lo]) / (arr[hi] - arr[lo]));
            if      (arr[pos] == target) return pos;
            else if (arr[pos] <  target) lo = pos + 1;
            else                         hi = pos - 1;
        }
        return -1;
    }

    // ── 5. Exponential Search ─────────────────────────────────
    // Good for unbounded arrays: O(log n)
    static int exponentialSearch(int[] arr, int target) {
        if (arr[0] == target) return 0;
        int i = 1;
        while (i < arr.length && arr[i] <= target) i *= 2;
        // binary search in found range
        int lo = i / 2, hi = Math.min(i, arr.length - 1);
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (arr[mid] == target) return mid;
            else if (arr[mid] <  target) lo = mid + 1;
            else                         hi = mid - 1;
        }
        return -1;
    }

    // ── 6. Ternary Search (unimodal function) ─────────────────
    // Find maximum of a unimodal function in range [lo, hi]
    static int ternarySearchMax(int[] arr, int lo, int hi) {
        while (hi - lo > 2) {
            int m1 = lo + (hi - lo) / 3;
            int m2 = hi - (hi - lo) / 3;
            if (arr[m1] < arr[m2]) lo = m1;
            else                   hi = m2;
        }
        int maxIdx = lo;
        for (int i = lo + 1; i <= hi; i++)
            if (arr[i] > arr[maxIdx]) maxIdx = i;
        return maxIdx;
    }

    // ── 7. BFS — shortest path in unweighted graph/grid ───────
    static int bfsShortestPath(int[][] grid, int[] start, int[] end) {
        int m = grid.length, n = grid[0].length;
        if (grid[start[0]][start[1]] == 1 || grid[end[0]][end[1]] == 1) return -1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        int steps = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == end[0] && cur[1] == end[1]) return steps;
                for (int[] d : dirs) {
                    int nr = cur[0] + d[0], nc = cur[1] + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && grid[nr][nc] == 0) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    // ── BENCHMARK ─────────────────────────────────────────────
    static void benchmark(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i * 2; // sorted, uniform
        int target = arr[n / 2];

        long t;
        int reps = 1000;

        t = System.nanoTime();
        for (int i = 0; i < reps; i++) linearSearch(arr, target);
        System.out.printf("Linear:        %6.3f µs%n", (System.nanoTime()-t)/1e3/reps);

        t = System.nanoTime();
        for (int i = 0; i < reps; i++) binarySearch(arr, target);
        System.out.printf("Binary:        %6.3f µs%n", (System.nanoTime()-t)/1e3/reps);

        t = System.nanoTime();
        for (int i = 0; i < reps; i++) jumpSearch(arr, target);
        System.out.printf("Jump:          %6.3f µs%n", (System.nanoTime()-t)/1e3/reps);

        t = System.nanoTime();
        for (int i = 0; i < reps; i++) interpolationSearch(arr, target);
        System.out.printf("Interpolation: %6.3f µs%n", (System.nanoTime()-t)/1e3/reps);

        t = System.nanoTime();
        for (int i = 0; i < reps; i++) exponentialSearch(arr, target);
        System.out.printf("Exponential:   %6.3f µs%n", (System.nanoTime()-t)/1e3/reps);
    }

    public static void main(String[] args) {

        int[] sorted = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};

        System.out.println("=== Correctness Check ===");
        int target = 23;
        System.out.println("Target: " + target);
        System.out.println("Linear:        " + linearSearch(sorted, target));
        System.out.println("Binary:        " + binarySearch(sorted, target));
        System.out.println("Jump:          " + jumpSearch(sorted, target));
        System.out.println("Interpolation: " + interpolationSearch(sorted, target));
        System.out.println("Exponential:   " + exponentialSearch(sorted, target));

        // Not found
        System.out.println("\nTarget: 99 (not found)");
        System.out.println("Linear:        " + linearSearch(sorted, 99));
        System.out.println("Binary:        " + binarySearch(sorted, 99));

        // Unimodal for ternary
        int[] unimodal = {1, 3, 7, 12, 9, 5, 2};
        System.out.println("\nTernary search peak in [1,3,7,12,9,5,2]: index=" + ternarySearchMax(unimodal, 0, unimodal.length-1)); // 3 (value 12)

        // BFS grid search
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println("BFS grid [0,0]→[2,2]: " + bfsShortestPath(grid, new int[]{0,0}, new int[]{2,2}) + " steps"); // 4

        // Benchmark
        System.out.println("\n=== Benchmark n=100000 (1000 reps) ===");
        benchmark(100_000);

        // Comparison table
        System.out.println("\n=== Algorithm Decision Guide ===");
        System.out.println("Unsorted array      → Linear Search   O(n)");
        System.out.println("Sorted array        → Binary Search   O(log n)");
        System.out.println("Uniform distribution→ Interpolation   O(log log n)");
        System.out.println("Unbounded array     → Exponential     O(log n)");
        System.out.println("Shortest path grid  → BFS             O(V+E)");
        System.out.println("Unimodal function   → Ternary Search  O(log n)");
        System.out.println("Java built-in       → Arrays.binarySearch() for sorted primitives");
    }
}
