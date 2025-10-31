package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MColoringProblem {
    boolean graphColoring(int v, int[][] edges, int m) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] edge:edges){
            adj.putIfAbsent(edge[0], new ArrayList<>());
            adj.putIfAbsent(edge[1], new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] color = new int[v];
        return isGraphColoringPossible(0,v,adj,color,m);
    }

    public boolean isGraphColoringPossible (int node,int n,Map<Integer, List<Integer>> adj,int[] color,int m){
        if(node==n){
            return true;
        }

        for(int col=1;col<=m;col++){
            if(isSafe(col,node,adj,color)){
                color[node] = col;
                if(isGraphColoringPossible(node+1,n,adj,color,m)){
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }

    public boolean isSafe(int col,int node,Map<Integer, List<Integer>> adj,int[] color){
        for(int neighbour : adj.getOrDefault(node, new ArrayList<>())){
            if(color[neighbour]==col){// neighbor already has same color
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MColoringProblem mColoringProblem = new MColoringProblem();
        int v=4;
        int[][] edges={{0,1},{1,3},{2,3},{3,0},{0,2}};
        int m=3;

//        int v=3;
//        int[][] edges={{0,1},{1,2},{0,2}};
//        int m=2;

        System.out.println(mColoringProblem.graphColoring(v,edges,m));
    }
}
