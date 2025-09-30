package Graph;

public class DisjointSetUnion_Union_Find {
    //this is Union by rank
    private final int[] parent;
    private final int[] rank;

    public DisjointSetUnion_Union_Find(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;// each node is its own parent
            rank[i] = 0;// all ranks start at 0
        }

    }

    public int findUltimateRoot(int node) {
        if (parent[node] != node) {
            parent[node] = findUltimateRoot(parent[node]);// path compression
        }
        return parent[node];
    }

    public boolean union(int u, int v) {
        int ultimateRootU = findUltimateRoot(u);
        int ultimateRootV = findUltimateRoot(v);
        if (ultimateRootU == ultimateRootV) {
            return false;//already in same set
        }
        int rankU = rank[ultimateRootU];
        int rankV = rank[ultimateRootV];
        if (rankU < rankV) {
            parent[ultimateRootU] = ultimateRootV;
        } else if (rankU > rankV) {
            parent[ultimateRootV] = ultimateRootU;
        } else {
            parent[ultimateRootV] = ultimateRootU;
            rank[ultimateRootU]++;// only when ranks are equal
        }
        return true;
    }

    void printState() {
        System.out.print("Parent: ");
        for (int p : parent) System.out.print(p + " ");
        System.out.print("  Rank: ");
        for (int r : rank) System.out.print(r + " ");
        System.out.println();
    }

    //----------------------------------------------------------
    //this is union by size
//    private final int[] parent;
//    private final int[] size;
//
//    public DisjointSetUnion_Union_Find(int n) {
//        this.parent = new int[n];
//        this.size = new int[n];
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;// each node is its own parent
//            size[i] = 1;// each set initially of size 1
//        }
//    }
//
//    public int findUltimateRoot(int node) {
//        if (parent[node] != node) {
//            parent[node] = findUltimateRoot(parent[node]);// path compression
//        }
//        return parent[node];
//    }
//
//    public boolean union(int u, int v) {
//        int ultimateRootU = findUltimateRoot(u);
//        int ultimateRootV = findUltimateRoot(v);
//        if (ultimateRootU == ultimateRootV) {
//            return false;//already in same set
//        }
//        int sizeU = size[ultimateRootU];
//        int sizeV = size[ultimateRootV];
//        // attach smaller tree under larger tree
//        if (sizeU < sizeV) {
//            parent[ultimateRootU] = ultimateRootV;
//            size[ultimateRootV]+=sizeU;
//        } else {
//            parent[ultimateRootV] = ultimateRootU;
//            size[ultimateRootU]+=sizeV;
//        }
//        return true;
//    }
//
//    void printState() {
//        System.out.print("Parent: ");
//        for (int p : parent) System.out.print(p + " ");
//        System.out.print("  Size: ");
//        for (int s : size) System.out.print(s + " ");
//        System.out.println();
//    }
//
}

class UnionFindDemo {
    public static void main(String[] args) {
        DisjointSetUnion_Union_Find dsu = new DisjointSetUnion_Union_Find(7); // elements 0..6

        System.out.println("Initial:");
        dsu.printState();

        System.out.println("\nUnion(1,2):");
        dsu.union(1, 2);
        dsu.printState();

        System.out.println("\nUnion(2,3):");
        dsu.union(2, 3);
        dsu.printState();

        System.out.println("\nUnion(4,5):");
        dsu.union(4, 5);
        dsu.printState();

        System.out.println("\nUnion(6,5):");
        dsu.union(6, 5);
        dsu.printState();

        System.out.println("\nUnion(3,5):");
        dsu.union(3, 5);
        dsu.printState();

        System.out.println("\nFinal find(6): " + dsu.findUltimateRoot(6));
        dsu.printState();
    }
}
