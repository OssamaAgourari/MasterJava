package org.example.DataStructures.Graph;

import java.util.*;

/**
 * ============================================================
 *                  GRAPH — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS A GRAPH?
 * -----------------
 * A set of VERTICES (nodes) connected by EDGES.
 *
 *   Directed   — edges have direction: A → B
 *   Undirected — edges are bidirectional: A — B
 *   Weighted   — edges have a cost/weight
 *   Unweighted — all edges cost the same
 *   Cyclic     — contains at least one cycle
 *   Acyclic    — no cycles (DAG = Directed Acyclic Graph)
 *
 * REPRESENTATIONS:
 * -----------------
 *   Adjacency List   — Map<V, List<V>>  [PREFERRED for sparse graphs]
 *   Adjacency Matrix — boolean[][] or int[][]  [dense graphs, O(1) edge check]
 *   Edge List        — List of (u, v) pairs
 *
 *   V = vertices, E = edges
 *   Adjacency List:   Space O(V+E), add edge O(1), check edge O(degree)
 *   Adjacency Matrix: Space O(V²),  add edge O(1), check edge O(1)
 *
 * TIME COMPLEXITY:
 * -----------------
 *   Algorithm  | Time      | Notes
 *   -----------|-----------|----------------------------
 *   BFS        | O(V+E)    | level-order, shortest path (unweighted)
 *   DFS        | O(V+E)    | depth-first, cycle detection
 *   Dijkstra   | O((V+E)logV)| shortest path (non-negative weights)
 *   Topological| O(V+E)    | DAG ordering
 *   Detect Cycle| O(V+E)  |
 *
 * KEY ALGORITHMS:
 * ----------------
 *   BFS  — level-order traversal, shortest path in unweighted graph
 *   DFS  — path existence, cycle detection, topological sort
 *   Dijkstra — shortest path with weights
 *   Kahn's  — topological sort (BFS with in-degree)
 *   Union-Find — connected components, cycle detection
 *
 * ============================================================
 */
public class Graph {

    // ─── Adjacency List Graph ─────────────────────────────────
    static class AdjGraph {
        private final java.util.HashMap<Integer, List<Integer>> adj = new java.util.HashMap<>();
        private final boolean directed;

        AdjGraph(boolean directed) { this.directed = directed; }

        void addVertex(int v) { adj.putIfAbsent(v, new ArrayList<>()); }

        void addEdge(int u, int v) {
            addVertex(u); addVertex(v);
            adj.get(u).add(v);
            if (!directed) adj.get(v).add(u);
        }

        List<Integer> neighbors(int v) { return adj.getOrDefault(v, new ArrayList<>()); }
        Set<Integer>  vertices()       { return adj.keySet(); }

        // ── BFS — O(V+E) ──────────────────────────────────────
        List<Integer> bfs(int start) {
            List<Integer> visited = new ArrayList<>();
            Set<Integer>  seen    = new HashSet<>();
            Queue<Integer> queue  = new ArrayDeque<>();
            queue.offer(start); seen.add(start);
            while (!queue.isEmpty()) {
                int cur = queue.poll(); visited.add(cur);
                for (int nb : neighbors(cur)) {
                    if (!seen.contains(nb)) { seen.add(nb); queue.offer(nb); }
                }
            }
            return visited;
        }

        // ── DFS recursive — O(V+E) ────────────────────────────
        List<Integer> dfs(int start) {
            List<Integer> visited = new ArrayList<>();
            dfsHelper(start, new HashSet<>(), visited);
            return visited;
        }
        private void dfsHelper(int v, Set<Integer> seen, List<Integer> result) {
            seen.add(v); result.add(v);
            for (int nb : neighbors(v)) if (!seen.contains(nb)) dfsHelper(nb, seen, result);
        }

        // ── BFS shortest path (unweighted) ────────────────────
        int shortestPath(int src, int dst) {
            if (src == dst) return 0;
            Set<Integer>  seen  = new HashSet<>();
            Queue<int[]>  queue = new ArrayDeque<>(); // [node, distance]
            queue.offer(new int[]{src, 0}); seen.add(src);
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                for (int nb : neighbors(cur[0])) {
                    if (nb == dst) return cur[1] + 1;
                    if (!seen.contains(nb)) { seen.add(nb); queue.offer(new int[]{nb, cur[1]+1}); }
                }
            }
            return -1; // not reachable
        }

        // ── Cycle detection (undirected — DFS) ────────────────
        boolean hasCycle() {
            Set<Integer> visited = new HashSet<>();
            for (int v : vertices()) {
                if (!visited.contains(v) && dfsCycle(v, -1, visited)) return true;
            }
            return false;
        }
        private boolean dfsCycle(int v, int parent, Set<Integer> visited) {
            visited.add(v);
            for (int nb : neighbors(v)) {
                if (!visited.contains(nb)) { if (dfsCycle(nb, v, visited)) return true; }
                else if (nb != parent) return true;
            }
            return false;
        }

        // ── Connected components ──────────────────────────────
        int connectedComponents() {
            Set<Integer> visited = new HashSet<>();
            int count = 0;
            for (int v : vertices()) {
                if (!visited.contains(v)) { dfsHelper(v, visited, new ArrayList<>()); count++; }
            }
            return count;
        }

        // ── Topological Sort (Kahn's / BFS) for DAGs ─────────
        List<Integer> topologicalSort() {
            java.util.HashMap<Integer,Integer> inDegree = new java.util.HashMap<>();
            for (int v : vertices()) inDegree.put(v, 0);
            for (int u : vertices()) for (int nb : neighbors(u)) inDegree.merge(nb, 1, Integer::sum);

            Queue<Integer> queue = new ArrayDeque<>();
            for (int v : vertices()) if (inDegree.get(v) == 0) queue.offer(v);

            List<Integer> order = new ArrayList<>();
            while (!queue.isEmpty()) {
                int cur = queue.poll(); order.add(cur);
                for (int nb : neighbors(cur)) {
                    inDegree.merge(nb, -1, Integer::sum);
                    if (inDegree.get(nb) == 0) queue.offer(nb);
                }
            }
            return order.size() == vertices().size() ? order : new ArrayList<>(); // empty = cycle
        }
    }

    public static void main(String[] args) {

        // EXERCISE 1: Undirected graph — BFS and DFS
        AdjGraph g = new AdjGraph(false);
        g.addEdge(0,1); g.addEdge(0,2); g.addEdge(1,3);
        g.addEdge(1,4); g.addEdge(2,5); g.addEdge(2,6);
        System.out.println("BFS from 0: " + g.bfs(0)); // [0,1,2,3,4,5,6]
        System.out.println("DFS from 0: " + g.dfs(0)); // [0,1,3,4,2,5,6]

        // EXERCISE 2: Shortest path
        AdjGraph g2 = new AdjGraph(false);
        g2.addEdge(0,1); g2.addEdge(0,2); g2.addEdge(1,3); g2.addEdge(2,4); g2.addEdge(3,5);
        System.out.println("Shortest 0→5: " + g2.shortestPath(0,5)); // 3
        System.out.println("Shortest 0→4: " + g2.shortestPath(0,4)); // 2

        // EXERCISE 3: Cycle detection
        AdjGraph cyclic = new AdjGraph(false);
        cyclic.addEdge(0,1); cyclic.addEdge(1,2); cyclic.addEdge(2,0); // triangle
        AdjGraph acyclic = new AdjGraph(false);
        acyclic.addEdge(0,1); acyclic.addEdge(1,2); acyclic.addEdge(0,2);
        System.out.println("Has cycle: " + cyclic.hasCycle());  // true
        System.out.println("Has cycle: " + acyclic.hasCycle()); // true (0-1-2-0)

        AdjGraph tree = new AdjGraph(false);
        tree.addEdge(0,1); tree.addEdge(0,2); tree.addEdge(1,3);
        System.out.println("Tree has cycle: " + tree.hasCycle()); // false

        // EXERCISE 4: Connected components
        AdjGraph cc = new AdjGraph(false);
        cc.addEdge(0,1); cc.addEdge(1,2); cc.addEdge(3,4); cc.addEdge(5,5);
        cc.addVertex(5);
        System.out.println("Connected components: " + cc.connectedComponents());

        // EXERCISE 5: Directed graph — topological sort
        AdjGraph dag = new AdjGraph(true);
        dag.addEdge(5,2); dag.addEdge(5,0); dag.addEdge(4,0);
        dag.addEdge(4,1); dag.addEdge(2,3); dag.addEdge(3,1);
        System.out.println("Topological order: " + dag.topologicalSort());

        // EXERCISE 6: Adjacency matrix
        int V = 4;
        int[][] matrix = new int[V][V];
        // Add edges: 0-1, 0-2, 1-3, 2-3
        addMatrixEdge(matrix, 0, 1); addMatrixEdge(matrix, 0, 2);
        addMatrixEdge(matrix, 1, 3); addMatrixEdge(matrix, 2, 3);
        System.out.println("Adjacency matrix:");
        for (int[] row : matrix) System.out.println("  " + Arrays.toString(row));

        // EXERCISE 7: Grid as graph — BFS for islands
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println("Number of islands: " + numIslands(grid)); // 3

        // EXERCISE 8: Union-Find (for connected components / cycle detection)
        UnionFind uf = new UnionFind(5);
        uf.union(0,1); uf.union(2,3);
        System.out.println("0 and 1 connected: " + uf.connected(0,1)); // true
        System.out.println("1 and 2 connected: " + uf.connected(1,2)); // false
        uf.union(1,2);
        System.out.println("After union(1,2) — 0 and 3: " + uf.connected(0,3)); // true

        // SUMMARY
        System.out.println("\n=== Graph Complexity ===");
        System.out.println("BFS/DFS          O(V+E)");
        System.out.println("Shortest path    O(V+E) BFS unweighted");
        System.out.println("Dijkstra         O((V+E) log V)");
        System.out.println("Topological sort O(V+E)");
        System.out.println("Adjacency list   O(V+E) space");
        System.out.println("Adjacency matrix O(V²) space");
    }

    static void addMatrixEdge(int[][] m, int u, int v) { m[u][v]=1; m[v][u]=1; }

    static int numIslands(char[][] grid) {
        int count = 0;
        for (int i=0;i<grid.length;i++) for (int j=0;j<grid[0].length;j++)
            if (grid[i][j]=='1') { bfsIsland(grid,i,j); count++; }
        return count;
    }
    static void bfsIsland(char[][] g, int r, int c) {
        Queue<int[]> q = new ArrayDeque<>(); q.offer(new int[]{r,c}); g[r][c]='0';
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int nr=cur[0]+d[0], nc=cur[1]+d[1];
                if (nr>=0&&nr<g.length&&nc>=0&&nc<g[0].length&&g[nr][nc]=='1') {
                    g[nr][nc]='0'; q.offer(new int[]{nr,nc});
                }
            }
        }
    }

    static class UnionFind {
        int[] parent, rank;
        UnionFind(int n) { parent=new int[n]; rank=new int[n]; for(int i=0;i<n;i++) parent[i]=i; }
        int find(int x)  { return parent[x]==x?x:(parent[x]=find(parent[x])); }
        void union(int a, int b) {
            int ra=find(a),rb=find(b);
            if (ra==rb) return;
            if (rank[ra]<rank[rb]) parent[ra]=rb;
            else if (rank[ra]>rank[rb]) parent[rb]=ra;
            else { parent[rb]=ra; rank[ra]++; }
        }
        boolean connected(int a, int b) { return find(a)==find(b); }
    }
}
