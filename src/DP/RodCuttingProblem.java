package DP;

import java.util.Arrays;

public class RodCuttingProblem {
    //kind of unbounded knapsack-treat 1 to n as wt[], and price[] as val[], W = n
    public int maxValue(int i, int W,int[] val,int[][] dp){
        //base case
        if(i==0){
            return W*val[0];
        }

        if(dp[i][W]!=-1){
            return dp[i][W];
        }
        //explore all the paths
        int notTake = 0 + maxValue(i-1,W,val,dp);
        int take = Integer.MIN_VALUE;
        if(i+1<=W){
            take = val[i] + maxValue(i,W-(i+1),val,dp);
        }
        return dp[i][W] = Math.max(take,notTake);
    }
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int[][] dp = new int[n][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return maxValue(n-1,n,price,dp);
    }

    public static void main(String[] args) {
        RodCuttingProblem rodCuttingProblem = new RodCuttingProblem();
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};//22
        //int[] price = {3, 5, 8, 9, 10, 17, 17, 20};//24
        System.out.println("maximum value obtainable by cutting up the rod and selling the pieces : "+rodCuttingProblem.cutRod(price));
    }

    //using Tabulation-S(c)-O(n*n)
    // public int cutRod(int[] price) {
    //     // code here
    //     int n = price.length;
    //     int[][] dp = new int[n][n+1];
    //     for(int j=0;j<=n;j++){
    //         dp[0][j] = j*price[0];
    //     }

    //     for(int i=1;i<n;i++){
    //         for(int j=0;j<=n;j++){
    //             int notTake = 0 + dp[i-1][j];
    //             int take = Integer.MIN_VALUE;
    //             if(i+1<=j){
    //                 take =price[i] + dp[i][j-(i+1)];
    //             }
    //             dp[i][j] = Math.max(take,notTake);
    //         }
    //     }
    //     return dp[n-1][n];
    // }

    //using Tabulation-S(c)-O(n)
    // public int cutRod(int[] price) {
    //     // code here
    //     int n = price.length;
    //     int[] prev = new int[n+1];
    //     for(int j=0;j<=n;j++){
    //         prev[j] = j*price[0];
    //     }

    //     for(int i=1;i<n;i++){
    //         int[] curr = new int[n+1];
    //         for(int j=0;j<=n;j++){
    //             int notTake = 0 + prev[j];
    //             int take = Integer.MIN_VALUE;
    //             if(i+1<=j){
    //                 take =price[i] + curr[j-(i+1)];
    //             }
    //             curr[j] = Math.max(take,notTake);
    //         }
    //         prev=curr;
    //     }
    //     return prev[n];
    // }
}
