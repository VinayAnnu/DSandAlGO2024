package Graph;

import java.util.ArrayList;
import java.util.List;

public class NoOfIsland2 {
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        int numberOfNodes = rows*cols;
        DisjointSetUnion_Union_Find dsu = new DisjointSetUnion_Union_Find(numberOfNodes);
        int currentNoOfIslands=0;
        int[][] visited = new int[rows][cols];
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<operators.length;i++){
            int r=operators[i][0];
            int c=operators[i][1];
            if(visited[r][c]==0){
                currentNoOfIslands++;
                visited[r][c]=1;
                int nodeNumberU = r*cols + c;
                //now check connection.
                for(int j=0;j<4;j++){
                    int newRow=r+drow[j];
                    int newCol=c+dcol[j];
                    if(newRow>=0&&newRow<rows&&newCol>=0&&newCol<cols&&visited[newRow][newCol]==1){
                        //make connections//union
                        int nodeNumberV=newRow*cols + newCol;
                        if(dsu.union(nodeNumberU, nodeNumberV)){
                            currentNoOfIslands--;
                        }
                    }
                }
            }
            result.add(currentNoOfIslands);
        }
        return result;
    }

    public static void main(String[] args) {
        NoOfIsland2 noOfIsland = new NoOfIsland2();
        int rows = 4, cols=5;
        int[][] operators = {{1,1},{0,1},{3,3},{3,4}};
        List<Integer> result = noOfIsland.numOfIslands(rows,cols,operators);
        result.forEach(x-> System.out.print(x+" "));
    }
}
