package DP;

import java.util.Arrays;

public class UnboundedKnapsack {
    static int maxProfit(int i,int W,int[] wt,int[] val,int[][] dp){
        //base case
        if(i==0){
            return (int)((W/wt[0])*val[0]);
        }
        if(dp[i][W]!=-1){
            return dp[i][W];
        }
        //explore alll the paths
        int notTake = 0 + maxProfit(i-1,W,wt,val,dp);
        int take = Integer.MIN_VALUE;
        if(wt[i]<=W){
            take = val[i] + maxProfit(i,W-wt[i],wt,val,dp);
        }
        return dp[i][W] = Math.max(take,notTake);
    }
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        int[][] dp = new int[n][capacity+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return maxProfit(n-1,capacity,wt,val,dp);
    }

    public static void main(String[] args) {
        int W = 5;
        int[] val = {10, 40, 30, 50};
        int[] wt = {5, 4, 2, 3};
        System.out.println("maximized value : "+knapSack(val,wt,W));
    }
}
