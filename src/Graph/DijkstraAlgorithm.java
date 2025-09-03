package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

class PairDA {
    int node;
    int distance;
    PairDA(int node, int distance){
        this.node=node;
        this.distance=distance;
    }
}
public class DijkstraAlgorithm {

    public int[] dijkstra(int V, int[][] edges, int src) {// apply BFS, use PQ for storing node
        // Build adjacency list (undirected graph → add both directions)
        Map<Integer, List<PairDA>> hm =new HashMap<>();
        for(int[] x: edges){
            hm.putIfAbsent(x[0], new ArrayList<>());
            hm.putIfAbsent(x[1], new ArrayList<>());
            hm.get(x[0]).add(new PairDA(x[1],x[2]));
            hm.get(x[1]).add(new PairDA(x[0],x[2]));
        }

        int[] arr = new int[V];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[src]=0;//src and destination same so it will be zero.
        PriorityQueue<PairDA> pq = new PriorityQueue<>((x, y)->Integer.compare(x.distance, y.distance));
        pq.offer(new PairDA(src,0));

        while(!pq.isEmpty()){
            PairDA p = pq.poll();
            int n=p.node;
            int d=p.distance;
            for(PairDA neighbour:hm.getOrDefault(n,new ArrayList<>())){
                if(arr[neighbour.node]>d+neighbour.distance){
                    arr[neighbour.node]=d+neighbour.distance;
                    pq.offer(new PairDA(neighbour.node,d+neighbour.distance));
                }
            }
        }
        return arr;
    }


    //this is using TreeSet. you can remove the old pair and insert the updated one. problem with PriorityQueue is it contains stale data
    //which is of no use b/c we already got lesser weight path.
//    public int[] dijkstra(int V, int[][] edges, int src) {
//        Map<Integer, List<PairDA>> hm = new HashMap<>();
//        for (int[] x : edges) {
//            hm.putIfAbsent(x[0], new ArrayList<>());
//            hm.putIfAbsent(x[1], new ArrayList<>());
//            hm.get(x[0]).add(new PairDA(x[1], x[2]));
//            hm.get(x[1]).add(new PairDA(x[0], x[2]));
//        }
//
//        int[] dist = new int[V];
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        dist[src] = 0;
//
//        // (distance, node) ordered set
//        TreeSet<int[]> set = new TreeSet<>(
//                (a, b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
//        );
//        set.add(new int[]{0, src});
//
//        while (!set.isEmpty()) {
//            int[] top = set.pollFirst(); // smallest distance
//            int d = top[0], u = top[1];
//
//            for (PairDA nei : hm.getOrDefault(u, new ArrayList<>())) {
//                if (dist[nei.node] > d + nei.distance) {
//                    // remove old entry if it exists
//                    set.remove(new int[]{dist[nei.node], nei.node});
//
//                    dist[nei.node] = d + nei.distance;
//                    set.add(new int[]{dist[nei.node], nei.node});
//                }
//            }
//        }
//
//        return dist;
//    }

    public static void main(String[] args) {
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
        int[][] edges = {
                {0, 1, 4},
                {0, 2, 8},
                {1, 4, 6},
                {2, 3, 2},
                {3, 4, 10}
        };
        int V=5, src=0;
//        int[][] edges = {
//                {0, 1, 1},
//                {1, 2, 3},
//                {0, 2, 6}
//        };
//        int V=3, src=2;

        int[] result = dijkstraAlgorithm.dijkstra(V, edges, src);
        Arrays.stream(result).forEach(x -> System.out.print(x+" "));
    }
}
