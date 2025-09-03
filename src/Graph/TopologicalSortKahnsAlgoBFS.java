package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSortKahnsAlgoBFS {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int[] indegree = new int[V];
        Map<Integer, List<Integer>> hm = new HashMap<>();//make adjacency list
        for(int[] arr:edges){
            hm.putIfAbsent(arr[0],new ArrayList<>());
            hm.get(arr[0]).add(arr[1]);
            indegree[arr[1]]++;
        }
        // Queue to store vertices with indegree 0
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                queue.offer(i);//whoever nodes having 0 indegree should be place enqueued.make it starting point for BFS
            }
        }

        int index=0;
        while(!queue.isEmpty()){
            int x = queue.poll();
            res.add(x);
            index++;
            for(int neighbour : hm.getOrDefault(x, new ArrayList<>())){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.offer(neighbour);
                }
            }
        }

        if(index!=V){
            System.out.println("Graph contains a cycle!");
            return new ArrayList<>();
        }
        return res;
    }

    public static void main(String[] args) {
        int vertex = 6;
        int[][] edges = {{1, 3}, {2, 3}, {4, 1}, {4, 0}, {5, 0}, {5,2}};
//        int vertex = 4;
//        int[][] edges = {{3,0},{1,0},{2,0}};
//        int vertex = 4;
//        int[][] edges = {{0,1},{0,2},{1,2},{2,0},{2,3}};
        TopologicalSortKahnsAlgoBFS topologicalSortBfs = new TopologicalSortKahnsAlgoBFS();
        ArrayList<Integer> res = topologicalSortBfs.topoSort(vertex, edges);
        System.out.println("Topological sort : "+res);
    }
}
