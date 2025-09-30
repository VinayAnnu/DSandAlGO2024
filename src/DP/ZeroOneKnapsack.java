package DP;

import java.util.Arrays;

public class ZeroOneKnapsack {
    //recursive + memoized
    static int maxValueFunc(int i,int W,int[] val,int[] wt,int[][] dp){
        //base cases
        if(i==0){
            if(wt[0]<=W){
                return val[0];
            }
            return 0;
        }
        if(dp[i][W]!=-1)return dp[i][W];

        //explore pick/nonpick
        int notPick = 0 + maxValueFunc(i-1,W,val,wt,dp);
        int pick = Integer.MIN_VALUE;
        if(wt[i]<=W){
            pick = val[i] + maxValueFunc(i-1,W-wt[i],val,wt,dp);
        }
        return dp[i][W] = Math.max(pick,notPick);
    }
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n=val.length;
        int[][] dp = new int[n][W+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return maxValueFunc(n-1,W,val,wt,dp);
    }

    public static void main(String[] args) {
        int W = 5;
        int[] val = {10, 40, 30, 50};
        int[] wt = {5, 4, 2, 3};
        System.out.println("maximized value : "+knapsack(W,val,wt));
    }

    //using Tabulation:bottom up approach
//    static int knapsack(int W, int val[], int wt[]) {
//        // code here
//        int n=val.length;
//        int[][] dp = new int[n][W+1];
//        //base case
//        for(int i=wt[0]; i<=W;i++){
//            dp[0][i] = val[0];
//        }
//        //explore pick/non-pick
//        for(int i=1;i<n;i++){
//            for(int j=1;j<=W;j++){
//                int notPick = 0 + dp[i-1][j];
//                int pick = Integer.MIN_VALUE;
//                if(wt[i]<=j){
//                    pick = val[i] + dp[i-1][j-wt[i]];
//                }
//                dp[i][j] = Math.max(pick,notPick);
//            }
//        }
//        return dp[n-1][W];
//    }

    //using Tabulation:bottom up approach-> space otimized to O(W+1)
//    static int knapsack(int W, int val[], int wt[]) {
//        // code here
//        int n=val.length;
//        int[] prev = new int[W+1];
//
//        //base case
//        for(int i=wt[0]; i<=W;i++){
//            prev[i] = val[0];
//        }
//        //explore pick/non-pick
//        for(int i=1;i<n;i++){
//            int[] curr = new int[W+1];
//            for(int j=1;j<=W;j++){
//                int notPick = 0 + prev[j];
//                int pick = Integer.MIN_VALUE;
//                if(wt[i]<=j){
//                    pick = val[i] + prev[j-wt[i]];
//                }
//                curr[j] = Math.max(pick,notPick);
//            }
//            prev = curr;
//        }
//        return prev[W];
//    }
}
