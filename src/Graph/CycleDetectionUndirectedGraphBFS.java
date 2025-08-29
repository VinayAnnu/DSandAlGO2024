package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Pair {
    int node;
    int parent;
    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

class CycleDetectionUndirectedGraphBFS {
    public boolean isCycle(int V, int[][] edges) {
        boolean[] visited = new boolean[V];

        // Build adjacency list (undirected graph → add both directions)
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.putIfAbsent(edge[0], new ArrayList<>());
            adj.putIfAbsent(edge[1], new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Run BFS on all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycle(adj, visited, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean detectCycle(Map<Integer, List<Integer>> adj, boolean[] visited, int start) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(start, -1));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int node = p.node;
            int parent = p.parent;

            for (int neighbour : adj.getOrDefault(node, new ArrayList<>())) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(new Pair(neighbour, node));
                } else if (neighbour != parent) {
                    return true; // found cycle
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CycleDetectionUndirectedGraphBFS cycleDetectionUndirectedGraph = new CycleDetectionUndirectedGraphBFS();
        int vertex = 4;
        int[][] edges = {{0,1},{0,2},{1,2},{2,3}};
//        int vertex = 4;
//        int[][] edges = {{0,1},{1,2},{2,3}};
        boolean result = cycleDetectionUndirectedGraph.isCycle(vertex,edges);
        System.out.println("is cycle found : "+result);
    }
}
