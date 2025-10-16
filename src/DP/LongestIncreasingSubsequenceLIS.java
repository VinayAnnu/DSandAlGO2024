package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class LongestIncreasingSubsequenceLIS {
    //plain recursive code
    public int lengthOfLIS(int currentIndex, int prevIndex, int[] nums) {
        //base case
        if (currentIndex == nums.length) {
            return 0;
        }

        //explore all possible paths.
        int notTake = 0 + lengthOfLIS(currentIndex + 1, prevIndex, nums);
        //take case
        int take = 0;
        if (prevIndex == -1 || nums[prevIndex] < nums[currentIndex]) {
            take = 1 + lengthOfLIS(currentIndex + 1, currentIndex, nums);
        }
        return Math.max(take, notTake);
    }

    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(0, -1, nums);
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequenceLIS longestIncreasingSubsequenceLIS = new LongestIncreasingSubsequenceLIS();
        int[] nums = {10,9,2,5,3,7,101,18};
        //int[] nums = {0,1,0,3,2,3};
        //int[] nums = {7,7,7,7,7,7,7};
        System.out.println("Length of LIS : "+longestIncreasingSubsequenceLIS.lengthOfLIS(nums));
        //longestIncreasingSubsequenceLIS.printLIS(nums);
        System.out.println("length of LIS using BS : "+longestIncreasingSubsequenceLIS.lengthOfLISUsingBinarySearch(nums));
    }

    //recursive + memoized
    // public int lengthOfLIS(int currentIndex, int prevIndex, int[] nums, int[][] dp) {
    //     //base case
    //     if (currentIndex == nums.length) {
    //         return 0;
    //     }
    //     if (dp[currentIndex][prevIndex + 1] != -1) {
    //         return dp[currentIndex][prevIndex + 1];
    //     }
    //     //explore all possible paths.
    //     int notTake = 0 + lengthOfLIS(currentIndex + 1, prevIndex, nums, dp);
    //     //take case
    //     int take = 0;
    //     if (prevIndex == -1 || nums[prevIndex] < nums[currentIndex]) {
    //         take = 1 + lengthOfLIS(currentIndex + 1, currentIndex, nums, dp);
    //     }
    //     return dp[currentIndex][prevIndex + 1] = Math.max(take, notTake);
    // }

    // public int lengthOfLIS(int[] nums) {
    //     int m = nums.length;
    //     int[][] dp = new int[m][m + 1];
    //     for (int[] arr : dp) {
    //         Arrays.fill(arr, -1);
    //     }
    //     return lengthOfLIS(0, -1, nums, dp);
    // }

    //Tabulation
    // public int lengthOfLIS(int[] nums) {
    //     int m = nums.length;
    //     int[][] dp = new int[m + 1][m + 1];// dp[currentIndex][prevIndex+1]
    //     //here base case intitialized to 0 by default. so no need to initialize
    //     for (int i = m - 1; i >= 0; i--) {
    //         for (int j =-1; j < m; j++) {
    //             //explore all possible paths.
    //             int notTake = 0 + dp[i + 1][j+1];// skip nums[i]
    //             //take case
    //             int take = 0;
    //             if (j == -1 || nums[j] < nums[i]) {
    //                 take = 1 + dp[i + 1][i+1];// careful: prevIndex = i → column = i+1
    //             }
    //             dp[i][j + 1] = Math.max(take, notTake);
    //         }
    //     }
    //     return dp[0][0];// prevIndex = -1 → column = 0
    // }

    //Tabulation-space optimized
    // public int lengthOfLIS(int[] nums) {
    //     int m = nums.length;
    //     int[] after = new int[m + 1];
    //     int[] curr = new int[m + 1];
    //     //here base case intitialized to 0 by default. so no need to initialize
    //     for (int i = m - 1; i >= 0; i--) {
    //         for (int j =-1; j < m; j++) {
    //             //explore all possible paths.
    //             int notTake = 0 + after[j+1];
    //             //take case
    //             int take = 0;
    //             if (j == -1 || nums[j] < nums[i]) {
    //                 take = 1 + after[i+1];
    //             }
    //             curr[j + 1] = Math.max(take, notTake);
    //         }
    //         after = curr;
    //     }
    //     return curr[0];// prevIndex = -1 → column = 0
    // }

    //try below approach in interview
    //T(c)-O(n^2), S(C)-O(n)-> we can optimize using Binary Search -lower bound. then T(c):nlogn, S(c):n
//    public void printLIS(int[] nums) {
//        int m = nums.length;
//        int[] dp = new int[m];// dp[i] = length of LIS ending at i
//        Arrays.fill(dp,1);
//        int[] parent = new int[m];// parent[i] = index of previous element in LIS
//        Arrays.fill(parent, -1);
//        int maxLength = 1;//it will denote length of LIS
//        int indexMaxLength = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i] && dp[i] < dp[j]+1) {
//                    dp[i] = dp[j]+1;
//                    parent[i] = j;
//                }
//            }
//            if (maxLength < dp[i]) {
//                maxLength = dp[i];
//                indexMaxLength = i;
//            }
//        }
//
//        List<Integer> list = new ArrayList<>();
//        while (indexMaxLength != -1) {
//            list.add(nums[indexMaxLength]);
//            indexMaxLength = parent[indexMaxLength];
//        }
//
//        Collections.reverse(list);
//        for(int x:list){
//            System.out.print(x + " ");
//        }
//        System.out.println();
//    }

    //length of LIS using Binary search-lowerbound technique-T-nlogn,S-n
    //this approach is only for finding length of LIS. we can not print lIS with this code.
     public int lengthOfLISUsingBinarySearch(int[] nums) {
         int m = nums.length;
         List<Integer> sub = new ArrayList<>();
         for(int x:nums){
             int i = lowerBound(sub,x);
             if(i==sub.size()){
                 sub.add(x);// new largest element → extend subsequence
             }else{
                 sub.set(i,x);// replace → maintain minimal elements
             }
         }
         return sub.size();
     }

     public int lowerBound(List<Integer> list,int x){
        int l=0,r=list.size();
        while(l<r){
            int mid = l+(r-l)/2;
            if(list.get(mid) >= x){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
     }
}
