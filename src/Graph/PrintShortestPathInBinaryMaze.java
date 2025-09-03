package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class PrintShortestPathInBinaryMaze {
    List<List<Integer>> getShortesPathBinaryMaze(int[][] grid, int[] source, int[] destination) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] distanceMatrix = new int[row][col];
        Arrays.stream(distanceMatrix).forEach(r -> Arrays.fill(r, Integer.MAX_VALUE));
        distanceMatrix[source[0]][source[1]] = 0; //initialize src distance=0 in distanceMatrix to start.
        Queue<PairBM> queue = new ArrayDeque<>();
        queue.offer(new PairBM(0, source[0], source[1]));//start node as distance 0.
        int[][][] parentMatrix = new int[row][col][2];//initialize parent matrix to -1
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                parentMatrix[i][j][0] = -1;
                parentMatrix[i][j][1] = -1;
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            PairBM p = queue.poll();
            int d = p.distance;
            int r = p.row;
            int c = p.col;
            if (r == destination[0] && c == destination[1]) {
                return buildPath(parentMatrix, source, destination);
            }
            for (int i = 0; i < 4; i++) {
                int newrow = r + drow[i];
                int newcol = c + dcol[i];
                if (newrow >= 0 && newrow < row && newcol >= 0 && newcol < col &&
                        grid[newrow][newcol] == 1 && distanceMatrix[newrow][newcol] > d + 1) {
                    distanceMatrix[newrow][newcol] = d + 1;
                    queue.offer(new PairBM(d + 1, newrow, newcol));
                    parentMatrix[newrow][newcol][0] = r;
                    parentMatrix[newrow][newcol][1] = c;
                }
            }
        }
        return new ArrayList<>();
    }

    List<List<Integer>> buildPath(int[][][] parentMatrix,int[] source, int[] destination) {
        List<List<Integer>> res = new ArrayList<>();
        int r = destination[0];
        int c = destination[1];
        while (r != -1 && c != -1) {
            res.add(Arrays.asList(r, c));
            if (r == source[0] && c == source[1]) break; // don’t step past source
            int pr = parentMatrix[r][c][0], pc = parentMatrix[r][c][1];
            r = pr; c = pc;
        }

        Collections.reverse(res); // since we built it backward
        return res;
    }

    public static void main(String[] args) {
        PrintShortestPathInBinaryMaze printShortestPathInBinaryMaze = new PrintShortestPathInBinaryMaze();
        int grid[][] =
                        {{1, 1, 1, 1},
                        {1, 1, 0, 1},
                        {1, 1, 1, 1},
                        {1, 1, 0, 0},
                        {1, 0, 0, 1}};
        int source[] = {0, 1};
        int destination[] = {2, 2};

        List<List<Integer>> res = printShortestPathInBinaryMaze.getShortesPathBinaryMaze(grid,source,destination);
        res.forEach(x->{
            System.out.println(x.get(0)+","+x.get(1));
        });
        int totalDistance=res.size()-1;
        System.out.println("Shortes distance b/w binary maze : "+ totalDistance);

    }
}
