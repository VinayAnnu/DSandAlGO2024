package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSort {//Graph should be Directed acyclic graph otherwise it gives wrong since it is not possible of topo sorting in cyclic
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, List<Integer>> hm = new HashMap<>();//make adjacency list
        for(int[] arr:edges){
            hm.putIfAbsent(arr[0],new ArrayList<>());
            hm.get(arr[0]).add(arr[1]);
        }

        boolean[] visited = new boolean[V];
        // Run DFS on all components
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                dfs(visited,i,hm,stack);
            }
        }

        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }

    void dfs(boolean[] visited,int start,Map<Integer, List<Integer>> hm,Deque<Integer> stack){
        visited[start]=true;
        for(int neighbour : hm.getOrDefault(start, new ArrayList<>())){
            if(visited[neighbour]==false){
                dfs(visited,neighbour,hm,stack);
            }
        }
        stack.push(start); //Topo sort- whenever dfs completed, push the node into stack. that's it.
    }

    public static void main(String[] args) {
        int vertex = 6;
        int[][] edges = {{1, 3}, {2, 3}, {4, 1}, {4, 0}, {5, 0}, {5,2}};
//        int vertex = 4;
//        int[][] edges = {{3,0},{1,0},{2,0}};
        TopologicalSort topologicalSort = new TopologicalSort();
        ArrayList<Integer> res = topologicalSort.topoSort(vertex, edges);
        System.out.println("Topological sort : "+res);
    }
}
