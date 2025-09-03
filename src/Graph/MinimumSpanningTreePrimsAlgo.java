package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
class Tuple{
    int weight;
    int node;
    int parent;
    Tuple(int weight,int node, int parent){
        this.weight=weight;
        this.node=node;
        this.parent=parent;
    }
}
public class MinimumSpanningTreePrimsAlgo {
    public int spanningTree(int V, int[][] edges) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] x:edges){
            adj.putIfAbsent(x[0], new ArrayList<>());
            adj.putIfAbsent(x[1], new ArrayList<>());
            adj.get(x[0]).add(new int[]{x[1],x[2]}); //u,v,w
            adj.get(x[1]).add(new int[]{x[0],x[2]}); //v,u,w
        }

        boolean[] visited = new boolean[V];
        List<int[]> mstPath = new ArrayList<>();
        int sum=0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)->Integer.compare(x.weight,y.weight));
        pq.offer(new Tuple(0,0,-1));//let's explore path from node 0 as source. we can take any node to start this algo
        while(!pq.isEmpty()){
            Tuple tp = pq.poll();
            int weight=tp.weight;
            int node=tp.node;
            int parent=tp.parent;
            if(!visited[node]){
                visited[node]=true;
                sum+=weight;
                if(parent!=-1) {
                    mstPath.add(new int[]{parent,node, weight});
                }
                for(int[] neighbour: adj.getOrDefault(node, new ArrayList<>())){
                    if(!visited[neighbour[0]]){
                        pq.offer(new Tuple(neighbour[1],neighbour[0],node));
                    }
                }
            }
        }
        mstPath.forEach(x-> System.out.println("u : "+x[0]+", v : "+x[1]+", w: "+x[2]));
        return sum;
    }

    public static void main(String[] args) {
        MinimumSpanningTreePrimsAlgo minimumSpanningTree = new MinimumSpanningTreePrimsAlgo();
        int V = 3, E = 3;
        int[][] Edges = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};
        System.out.println("MST weight "+minimumSpanningTree.spanningTree(V,Edges));
    }
}
