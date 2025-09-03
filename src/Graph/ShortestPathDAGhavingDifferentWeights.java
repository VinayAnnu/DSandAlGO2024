package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// User function Template for Java
class PairDS {
    int node;
    int distance;
    PairDS(int node, int distance){
        this.node=node;
        this.distance=distance;
    }
}
//BFS with weights: needs multiple relaxations, becomes inefficient, correctness is not guaranteed without repeated passes.
// For larger graphs, this can lead to lots of redundant work, making it closer to Bellman-Ford (O(V·E)). It will give TLE.
//So, do not use BFS. use Topological sort + relaxation
public class ShortestPathDAGhavingDifferentWeights {

    public int[] shortestPath(int V, int E, int[][] edges) {
        //1. do Topo sort from given src node only b/c if some node which can not be reached from
        //src then no point of having in topo sort and doing dfs
        //2. relax the edges.
        Map<Integer, List<PairDS>> hm =new HashMap<>();
        for(int[] x: edges){
            hm.putIfAbsent(x[0], new ArrayList<>());
            hm.get(x[0]).add(new PairDS(x[1],x[2]));
        }
        int[] arr = new int[V];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0]=0;//src and destination same so it will be zero.
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[V];
        topoSortDFS(hm,stack,0,visited);//given src node is 0

        //2.start relaxing the node while popping stack.
        while(!stack.isEmpty()){
            int e = stack.pop();
            for(PairDS p : hm.getOrDefault(e, new ArrayList<>())){
                int n = p.node;
                int d = p.distance;
                if(arr[n]>d+arr[e]){
                    arr[n]=d+arr[e];
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (arr[i] == Integer.MAX_VALUE) {
                arr[i] = -1;
            }
        }
        return arr;
    }

    void topoSortDFS(Map<Integer, List<PairDS>> hm, Deque<Integer> stack, int start, boolean[] visited){
        visited[start]=true;
        for(PairDS p : hm.getOrDefault(start, new ArrayList<>())){
            int n=p.node;
            if(visited[n]==false){
                topoSortDFS(hm,stack,n,visited);
            }
        }
        stack.push(start);//Topo sort- whenever dfs completed, push the node into stack.
    }

    public static void main(String[] args) {
        ShortestPathDAGhavingDifferentWeights sol = new ShortestPathDAGhavingDifferentWeights();
        // Input adjacency list in array form
//        int[][] edges = {
//                {0, 1, 2},
//                {0, 2, 1}
//        };
//        int V =4, E=2;

        int[][] edges = {
                {0, 1, 2},
                {0, 4, 1},
                {4, 5, 4},
                {4, 2, 2},
                {1, 2, 3},
                {2, 3, 6},
                {5, 3, 1}
        };
        int V =6, E=7;

        int[] result = sol.shortestPath(V, E, edges);
        Arrays.stream(result).forEach(x -> System.out.print(x+" "));
    }
}
