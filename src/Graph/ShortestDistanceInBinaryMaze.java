package Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class PairBM {
    int distance;
    int row;
    int col;

    PairBM(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

public class ShortestDistanceInBinaryMaze {

    int shortestPath(int[][] grid, int[] source, int[] destination) {//apply Dijsktra but take simple queue only, b/c distance b/w 2 adjacent cell is contant 1 only
        int row = grid.length;
        int col = grid[0].length;
        int[][] distanceMatrix = new int[row][col];
        Arrays.stream(distanceMatrix).forEach(r -> Arrays.fill(r, Integer.MAX_VALUE));
        distanceMatrix[source[0]][source[1]] = 0; //initialize src distance=0 in distanceMatrix to start.
        Queue<PairBM> queue = new ArrayDeque<>();
        queue.offer(new PairBM(0, source[0], source[1]));
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            PairBM p = queue.poll();
            int d = p.distance;
            int r = p.row;
            int c = p.col;
            if (r == destination[0] && c == destination[1]) {
                return d;
            }
            for (int i = 0; i < 4; i++) {
                int newrow = r + drow[i];
                int newcol = c + dcol[i];
                if (newrow >= 0 && newrow < row && newcol >= 0 && newcol < col &&
                        grid[newrow][newcol] == 1 && distanceMatrix[newrow][newcol] > d + 1) {
                    distanceMatrix[newrow][newcol] = d + 1;
                    queue.offer(new PairBM(d + 1, newrow, newcol));
                }
            }
        }
        if (distanceMatrix[destination[0]][destination[1]] == 0) return 0;
        return -1;
    }

    public static void main(String[] args) {
        ShortestDistanceInBinaryMaze shortestDistanceInBinaryMaze = new ShortestDistanceInBinaryMaze();
        int grid[][] =
                {{1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}};
        int source[] = {0, 1};
        int destination[] = {2, 2};
        System.out.println("Shortes distance b/w binary maze : " + shortestDistanceInBinaryMaze.shortestPath(grid, source, destination));
    }
}
