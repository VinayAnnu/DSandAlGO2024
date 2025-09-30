package DP;

import java.util.Arrays;
//T(c):O(n) (since each state n is solved once due to memoization).
//S(C):O(n) (memoization array + recursion stack)
public class FrogJump {
    int minC(int[] dp, int[] height, int i){
        if(i==0){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int leftRec = minC(dp,height,i-1) + Math.abs(height[i]-height[i-1]);
        int rightRec = Integer.MAX_VALUE;
        if(i>1){
            rightRec = minC(dp,height,i-2) + Math.abs(height[i]-height[i-2]);
        }
        dp[i]=Math.min(leftRec, rightRec);
        return dp[i];
    }
    int minCost(int[] height) {
        int[] dp = new int[height.length];
        int n=dp.length;
        Arrays.fill(dp,-1);
        return minC(dp, height, n-1);
    }

    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();
        int[] heights = {30, 20, 50, 10, 40};
        System.out.println("minimum total cost required for the frog to reach the top: "+frogJump.minCost(heights));
    }
}

//using tabulation (bottom-up DP)
//Time: O(n) (single loop)
//Space: O(n) (array dp), can be optimized to O(1) using two variables.
// class Solution {
//     int minCost(int[] height) {
//         int[] dp = new int[height.length];
//         dp[0]=0;
//         for(int i=1;i<dp.length;i++){
//             int x =dp[i-1]+Math.abs(height[i]-height[i-1]);
//             int y=Integer.MAX_VALUE;
//             if(i>1){
//                 y =dp[i-2]+Math.abs(height[i]-height[i-2]);
//             }
//             dp[i]=Math.min(x,y);
//         }
//         return dp[height.length-1];
//     }
// }


//Using space-optimized tabulation → O(n) time, O(1) space (just two variables).
// class Solution {
//     int minCost(int[] height) {
//         int[] dp = new int[height.length];
//         int prev1=0,prev2=0;
//         for(int i=1;i<dp.length;i++){
//             int x =prev1 + Math.abs(height[i]-height[i-1]);
//             int y=Integer.MAX_VALUE;
//             if(i>1){
//                 y =prev2 + Math.abs(height[i]-height[i-2]);
//             }

//             int curr = Math.min(x,y);
//             prev2=prev1;
//             prev1=curr;
//         }
//         return prev1;
//     }
// }
