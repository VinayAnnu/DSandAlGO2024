package DP;

import java.util.Arrays;

public class CountAllSubsetWhoseSumEqTarget {
    public int count(int i,int target,int[] nums,int[][] dp){
        //base cases
        if(i==0){
            if(target==0 && nums[0]==0){
                return 2;
            }
            if(target == 0 || nums[0]==target){
                return 1;
            }
            return 0;
        }
        if(dp[i][target]!=-1){
            return dp[i][target];
        }
        //explore all the path
        int take = 0;
        if(nums[i]<=target){
            take = count(i-1,target-nums[i],nums,dp);
        }
        int notTake = count(i-1,target,nums,dp);
        return dp[i][target] = take + notTake;
    }
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int[][] dp = new int[nums.length][target+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return count(nums.length-1,target,nums,dp);
    }

    public static void main(String[] args) {
        CountAllSubsetWhoseSumEqTarget countAllSubsetWhoseSumEqTarget = new CountAllSubsetWhoseSumEqTarget();
        int[] arr = {5, 2, 3, 10, 6, 8};
        int target = 10;
//        int[] arr = {5, 7, 8};
//        int target = 3;
        System.out.println("no of all subsets of the array whose sum is equal to the given target: "
                +countAllSubsetWhoseSumEqTarget.perfectSum(arr, target));
    }
}
