package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

class PairT{
    int node;
    int distance;
    PairT(int node, int distance){
        this.node=node;
        this.distance=distance;
    }
}
public class ShortestPathinUGwithUnitWeight {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) { //apply BFS
        // code here
        int[] res = new int[adj.size()];
        Arrays.fill(res, Integer.MAX_VALUE);
        Queue<PairT> queue = new ArrayDeque<>();
        queue.offer(new PairT(src,0));//src will be at 0 distance from src
        res[src]=0;
        while(!queue.isEmpty()){
            PairT p = queue.poll();
            int n = p.node;
            int d = p.distance;
            for(int neighbour : adj.get(n)){
                if(res[neighbour]>d+1){
                    res[neighbour]=d+1;
                    queue.offer(new PairT(neighbour,d+1));
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ShortestPathinUGwithUnitWeight shortestPathinUGwithUnitWeight = new ShortestPathinUGwithUnitWeight();
        // Input adjacency list in array form
        int[][] adjArray = {
                {1, 3},
                {0, 2},
                {1, 6},
                {0, 4},
                {3, 5},
                {4, 6},
                {2, 5, 7, 8},
                {6, 8},
                {7, 6}
        };

        // Convert to ArrayList of ArrayList
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < adjArray.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int val : adjArray[i]) {
                list.add(val);
            }
            adj.add(list);
        }
        int[] result = shortestPathinUGwithUnitWeight.shortestPath(adj,0);
        Arrays.stream(result).forEach(x -> System.out.print(x+" "));
    }
}
