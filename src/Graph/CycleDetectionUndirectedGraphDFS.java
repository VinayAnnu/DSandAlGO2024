package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CycleDetectionUndirectedGraphDFS {
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

        // Run DFS on all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycleDfs(adj, visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean detectCycleDfs(Map<Integer, List<Integer>> adj, boolean[] visited, int node, int parent){
        visited[node]=true;
        for(int neighbour : adj.getOrDefault(node, new ArrayList<>())){
            if(visited[neighbour]==false){
                boolean res = detectCycleDfs(adj,visited,neighbour, node);
                if(res==true){
                    return true;
                }
            } else if(parent!=neighbour){
                return true;
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
