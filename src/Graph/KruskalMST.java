package Graph;

import java.util.ArrayList;
import java.util.List;

class Edges{
    int u,v,w;
    Edges(int u,int v,int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }
}
public class KruskalMST {
    static int kruskalsMST(int V, int[][] edges) {
        List<Edges> edgeList = new ArrayList<>();
        DisjointSetUnion_Union_Find dsu =new DisjointSetUnion_Union_Find(V);
        for(int[] e : edges){
            edgeList.add(new Edges(e[0],e[1],e[2]));
        }

        edgeList.sort((a,b)->Integer.compare(a.w,b.w));
        int weight=0;
        List<Edges> resultList = new ArrayList<>();
        for(Edges edge : edgeList){
            int u=edge.u;
            int v=edge.v;
            int w=edge.w;
            if(dsu.union(u,v)){
                weight+=w;
                resultList.add(new Edges(u,v,w));
            }
        }
        // Print MST edges
        System.out.println("Edges in MST:");
        for (Edges e : resultList) {
            System.out.println("u: " + e.u + ", v: " + e.v + ", w: " + e.w);
        }

        return weight;
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {
                {0, 1, 10}, {0, 2, 6}, {0, 3, 5}, {1, 3, 15}, {2, 3, 4}
        };

        int mstWeight = kruskalsMST(V, edges);
        System.out.println("MST total weight = " + mstWeight);
    }
}
