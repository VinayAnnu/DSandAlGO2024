package Graph;

public class FloydWarshall {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        int INF = (int) 1e9; // large value representing infinity

        // Floyd–Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Detect negative cycle
        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0) {
                System.out.println("Negative weight cycle detected!");
                return;
            }
        }

        // Print final shortest path matrix
        System.out.println("All-pairs shortest path matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int INF = (int) 1e9;

        // Example graph (Adjacency matrix)
        int[][] graph = {
                {0,   3,   INF, 5},
                {2,   0,   INF, 4},
                {INF, 1,   0,   INF},
                {INF, INF, 2,   0}
        };

        FloydWarshall sol = new FloydWarshall();
        sol.floydWarshall(graph);
    }
}
