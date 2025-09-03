package Graph;

import java.util.Arrays;

public class BellmanFord_GeeksForGeeks {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] distance = new int[V];
        Arrays.fill(distance,(int)1e8);
        distance[src]=0;
        //n-1 times relaxation
        for(int i=0;i<V-1;i++){
            for(int[] arr:edges){
                int u=arr[0];
                int v=arr[1];
                int w=arr[2];
                if(distance[u]!=(int)1e8 && distance[v]>distance[u]+w){
                    distance[v]=distance[u]+w;
                }
            }
        }

        //nth relaxation to check negative cycle.if it gets relaxed then -ve cycle found;
        for(int[] arr:edges){
            int u=arr[0];
            int v=arr[1];
            int w=arr[2];
            if(distance[u]!=(int)1e8 && distance[v]>distance[u]+w){
                return new int[]{-1};
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        BellmanFord_GeeksForGeeks sol=new BellmanFord_GeeksForGeeks();
        int[][] edges = {
                {1, 3, 2}, {4, 3, -1}, {2, 4, 1}, {1, 2, 1}, {0, 1, 5}
        };
        int V=5, src=0;
        int[] res=sol.bellmanFord(V,edges,src);
        System.out.println("shortest distances from the source to all other vertices");
        Arrays.stream(res).forEach(x-> System.out.print(x+" "));

    }
}
