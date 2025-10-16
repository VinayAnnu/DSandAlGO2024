package DP;

import java.util.Arrays;

public class MatrixChainMultiplication {
    //recursive+memoized
    static int func(int i,int j,int[] arr,int[][] dp) {
        if(i==j){//single matrix. so no operation required
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int minOp = (int)1e9;
        for(int k=i;k<=j-1;k++){
            int steps = arr[i-1]*arr[k]*arr[j] + func(i,k,arr,dp) + func(k+1,j,arr,dp);
            minOp = Math.min(minOp, steps);
        }
        return dp[i][j] = minOp;
    }

    static int matrixMultiplication(int arr[]) {
        // code here
        int n=arr.length;
        int[][] dp = new int[n][n];
        for(int[] x:dp) {
            Arrays.fill(x,-1);
        }
        return func(1,n-1,arr,dp);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        System.out.println("Min operations required in multipplication by recursive+memoization : "+matrixMultiplication(arr));
        System.out.println("Min operations required in multipplication by Tabulation approach : "+matrixMultiplicationByTabulation(arr));
    }

    //Tabulation
    static int matrixMultiplicationByTabulation(int arr[]) {
        int n=arr.length;
        int[][] dp = new int[n][n];
        for(int i=1;i<n;i++){
            dp[i][i] = 0;//ideally all row by default initialized to 0 only
        }
        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<n;j++){
                int minOp = (int)1e9;
                for(int k=i;k<=j-1;k++){
                    int steps = arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j];
                    minOp = Math.min(minOp, steps);
                }
                dp[i][j] = minOp;
            }
        }
        return dp[1][n-1];
    }
}
