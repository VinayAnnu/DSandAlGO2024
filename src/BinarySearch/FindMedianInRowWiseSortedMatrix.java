package BinarySearch;

public class FindMedianInRowWiseSortedMatrix {
    public static int findMedian(int matrix[][], int m, int n) {
        int low = findMinInFirstCol(matrix,m,n);
        int high = findMaxInLastCol(matrix,m,n);

        int noOfElementsLessThanEqualRequired = (m*n)/2;


        while(low<=high){
            int mid = low + (high-low)/2;
            int noOfElementsLessThanEqualMidVal = upperBound(matrix,m,n, mid);
            if(noOfElementsLessThanEqualMidVal <= noOfElementsLessThanEqualRequired){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return low;
    }

    private static int findMaxInLastCol(int[][] matrix, int m, int n) {
        int max =Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            if(matrix[i][n-1]>max){
                max = matrix[i][n-1];
            }
        }
        return max;
    }

    private static int findMinInFirstCol(int[][] matrix, int m, int n) {
        int min =Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            if(matrix[i][0]<min){
                min = matrix[i][0];
            }
        }
        return min;
    }

    private static int upperBound(int[][] matrix, int m, int n, int target){
        int count=0;
        for(int i=0;i<m;i++){
            int[] arr = matrix[i];
            int low = 0,high = n-1;
            while(low<=high){
                int mid = low+(high-low)/2;
                if(arr[mid] > target){
                    high = mid-1;
                } else{
                    low = mid+1;
                }
            }
            count+=low;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 5, 7, 9, 11},{2, 3, 4, 8, 9 },{4, 11, 14, 19, 20},{ 6, 10, 22, 99, 100},{7, 15, 17, 24, 28}};
        int m=5;//row
        int n=5;//col
        int res = findMedian(matrix, m,n);
        System.out.println("Median of matrix : "+res);
    }
}
