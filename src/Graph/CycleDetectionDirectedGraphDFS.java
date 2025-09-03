package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CycleDetectionDirectedGraphDFS {// we can use Toplological sort also to check cyclic since A topological ordering of a directed graph
    // is possible only if the graph is a Directed Acyclic Graph (DAG). check TopologicalSortKahnsAlgoBFS class for the same
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        Map<Integer, List<Integer>> hm = new HashMap<>();//make adjacency list
        for(int[] arr:edges){
            hm.putIfAbsent(arr[0],new ArrayList<>());
            hm.get(arr[0]).add(arr[1]);
        }

        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        // Run DFS on all components
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(dfs(visited,pathVisited,i,hm)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(int[] visited,int[] pathVisited,int start, Map<Integer,List<Integer>> hm){
        visited[start]=1;
        pathVisited[start]=1;

        for(int neighbour : hm.getOrDefault(start, new ArrayList<>())){
            if(visited[neighbour]==0){
                boolean x = dfs(visited,pathVisited,neighbour,hm);
                if(x==true) return true;
            } else if(pathVisited[neighbour]==1){
                return true;
            }
        }
        pathVisited[start]=0;//while going back. make the pathVisited to 0
        return false;
    }

    public static void main(String[] args) {
        int vertex = 4;
        int[][] edges = {{0,1},{0,2},{1,2},{2,0},{2,3}};
//        int vertex = 4;
//        int[][] edges = {{0,1},{0,2},{1,2},{2,3}};
        CycleDetectionDirectedGraphDFS cycleDetectionDirectedGraphDFS = new CycleDetectionDirectedGraphDFS();
        boolean result = cycleDetectionDirectedGraphDFS.isCyclic(vertex,edges);
        System.out.println("is cycle found in directed graph: "+result);
    }
}
