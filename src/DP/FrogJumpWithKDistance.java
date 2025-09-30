package DP;

import java.util.Arrays;

public class FrogJumpWithKDistance {
    public int frogJumpWithKdistance(int i, int[] dp, int[] heights, int k){
        //base case
        if(i==0){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int minEnergy = Integer.MAX_VALUE;
        for(int j=1;j<=k;j++){
            int idx = i - j;
            if(idx>=0) {
                int e = frogJumpWithKdistance(idx, dp, heights, k) + Math.abs(heights[i]-heights[idx]);
                minEnergy = Math.min(minEnergy, e);
            }
        }
        dp[i]=minEnergy;
        return dp[i];
    }
    public int frogJump(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return frogJumpWithKdistance(n-1, dp, heights, k);
    }

    public static void main(String[] args) {
        FrogJumpWithKDistance frogJump = new FrogJumpWithKDistance();
        int[] heights = {15, 4, 1, 14, 15};
        int k = 3;
        System.out.println("minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step : "+frogJump.frogJump(heights,k));
    }
}
