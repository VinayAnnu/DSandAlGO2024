package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PrintShortestPathWeightedUGDjikstra {
    public List<Integer> shortestPath(int V, int src, int edges[][]) {
        // Build adjacency list (undirected graph → add both directions)
        Map<Integer, List<PairDA>> hm =new HashMap<>();
        for(int[] x: edges){
            hm.putIfAbsent(x[0], new ArrayList<>());
            hm.putIfAbsent(x[1], new ArrayList<>());
            hm.get(x[0]).add(new PairDA(x[1],x[2]));
            hm.get(x[1]).add(new PairDA(x[0],x[2]));
        }

        int srcNode=1, destinationNode=V; //given in problem. need to find path b/w 1 & V
        int[] arr = new int[V+1];//1-based indexing
        int[] parent = new int[V+1];
        for(int i=1;i<=V;i++){
            parent[i]=-1;//parent initialization
        }
        Arrays.fill(arr, Integer.MAX_VALUE);//storing distances of each node from src
        arr[srcNode]=0;//src and destination same so it will be zero.
        PriorityQueue<PairDA> pq = new PriorityQueue<>((x, y)->Integer.compare(x.distance, y.distance));
        pq.offer(new PairDA(srcNode,0));

        while(!pq.isEmpty()){
            PairDA p = pq.poll();
            int n=p.node;
            int d=p.distance;
            for(PairDA neighbour:hm.getOrDefault(n,new ArrayList<>())){
                if(arr[neighbour.node]>d+neighbour.distance){
                    arr[neighbour.node]=d+neighbour.distance;
                    pq.offer(new PairDA(neighbour.node,d+neighbour.distance));
                    parent[neighbour.node]=n;
                }
            }
        }

        if(arr[destinationNode]==Integer.MAX_VALUE){
            return new ArrayList<>(Arrays.asList(-1));
        }
        int dnode = destinationNode;
        List<Integer> al = new ArrayList<>();

        while (true) {
            al.add(dnode);
            if (dnode == srcNode) break;  // stop once we reach the source
            dnode = parent[dnode];
        }
        Collections.reverse(al);
        return al;
    }

    public static void main(String[] args) {
        PrintShortestPathWeightedUGDjikstra shortestPathWeightedUGDjikstra = new PrintShortestPathWeightedUGDjikstra();
        int[][] edges = {
                {1, 2, 2},
                {2, 5, 5},
                {2, 3, 4},
                {1, 4, 1},
                {4, 3, 3},
                {3, 5, 1}
        };
        int V=5, src=0;
        List<Integer> result = shortestPathWeightedUGDjikstra.shortestPath(V, src, edges);
        result.forEach(x -> System.out.print(x+" "));
    }
}
