package Graph;

public class NumberOfIslandsDFS {
    public int countIslands(char[][] grid) {
        // Code here
        int count=0;
        int row=grid.length;
        int col=grid[0].length;
        boolean[][] visited=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='L' && visited[i][j]==false){
                    dfs(grid,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(char[][] grid,boolean[][] visited,int r,int c){
        int row=r;
        int col=c;
        visited[row][col]=true;
        for(int i=-1;i<=1;i++){//populating all 8 indexes
            for(int j=-1;j<=1;j++){//populating all 8 indexes
                int newRow=row+i;
                int newCol=col+j;
                if(newRow>=0&&newRow<grid.length&&newCol>=0&&newCol<grid[0].length&&
                        visited[newRow][newCol]==false&&grid[newRow][newCol]=='L'){
                    dfs(grid,visited,newRow,newCol);
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'L', 'L', 'W', 'W', 'W'},
                {'W', 'L', 'W', 'W', 'L'},
                {'L', 'W', 'W', 'L', 'L'},
                {'W', 'W', 'W', 'W', 'W'},
                {'L', 'W', 'L', 'L', 'W'}};

        NumberOfIslandsDFS numberOfIslandsDFS = new NumberOfIslandsDFS();
        System.out.println("Number of islands : "+numberOfIslandsDFS.countIslands(grid));
    }
}
