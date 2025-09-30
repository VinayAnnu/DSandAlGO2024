package DP;

import java.util.Arrays;

public class SubsetSumProblemGFG {
    //memoization-top-down
    static Boolean subsetSum(int i, int target,int[] arr, Boolean[][] dp){
        //base cases
        if(target==0) return true;
        if(i==0) return target == arr[0];
        if(dp[i][target]!=null){
            return dp[i][target];
        }
        //explore all the path
        boolean take = false;
        if(arr[i]<=target){
            take=subsetSum(i-1,target-arr[i],arr,dp);
        }
        boolean notTake = subsetSum(i-1,target,arr,dp);

        return dp[i][target] = take || notTake;
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum+1];
        for(Boolean[] b:dp){
            Arrays.fill(b,null);
        }
        return subsetSum(n-1,sum,arr,dp);
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
//        int[] arr = {3, 34, 4, 12, 5, 2};
//        int sum = 30;
        System.out.println("Is subset sum possible : "+isSubsetSum(arr,sum));
    }

    //Tabulation:Time: O(n * sum), Space: O(n * sum)→ can be optimized to O(sum) using two 1D arrays (prev & curr).
//    static Boolean isSubsetSum(int arr[], int sum) {
//        // code here
//        int n = arr.length;
//        boolean[][] dp = new boolean[n][sum+1];
//        for(boolean[] b:dp){
//            b[0]=true;
//        }
//
//        if(arr[0]<=sum){
//            dp[0][arr[0]]=true;
//        }
//
//        for(int i=1;i<n;i++){
//            for(int target=1;target<=sum;target++){
//                boolean take = false;
//                if(arr[i]<=target){
//                    take=dp[i-1][target-arr[i]];
//                }
//                boolean notTake = dp[i-1][target];
//                dp[i][target]=take||notTake;
//            }
//        }
//        return dp[n-1][sum];
//    }

//    //Space: O(sum), using two 1D arrays (prev & curr).
//    static Boolean isSubsetSum(int arr[], int sum) {
//        // code here
//        int n = arr.length;
//        boolean[] prev = new boolean[sum+1];
//        prev[0]=true;
//
//        if(arr[0]<=sum){
//            prev[arr[0]]=true;
//        }
//
//        for(int i=1;i<n;i++){
//            boolean[] curr = new boolean[sum+1];
//            curr[0]=true;
//            for(int target=1;target<=sum;target++){
//                boolean take = false;
//                if(arr[i]<=target){
//                    take=prev[target-arr[i]];
//                }
//                boolean notTake = prev[target];
//                curr[target]=take||notTake;
//            }
//            prev=curr;
//        }
//        return prev[sum];
//    }
}
