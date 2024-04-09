package BinarySearch;

public class FindPeakElementIn2DArray {
    public static int[] findPeakGrid(int [][]G){
        int n = G.length;//row
        int m = G[0].length;//col
        int low = 0, high = m-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int rowIdx = findMaxElementIndex(G, mid);
            int l = mid-1>=0?G[rowIdx][mid-1]:-1;
            int r = mid+1<m?G[rowIdx][mid+1]:-1;
            if(G[rowIdx][mid] > l && G[rowIdx][mid] > r){
                return new int[]{rowIdx,mid};
            } else if(G[rowIdx][mid] > l){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return new int[]{-1,-1};
    }

    private static int findMaxElementIndex(int[][] ints,int mid) {
        int max = Integer.MIN_VALUE;
        int rowIdx = -1;
        for(int i=0;i<ints.length;i++){
            if(max<ints[i][mid]){
                max = ints[i][mid];
                rowIdx = i;
            }
        }
        return rowIdx;
    }

    public static void main(String[] args) {
        //int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}}; //n*m
        int[][] arr = new int[][]{{8,6},{10,1}};
        int[] res = findPeakGrid(arr);
        System.out.println("Peak element found on indices "+res[0]+" ,"+res[1]);
    }
}
