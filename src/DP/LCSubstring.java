package DP;

public class LCSubstring {
    //using LCSubsequence code
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int m=s1.length();
        int n=s2.length();
        int[][] dp = new int[m+1][n+1];
        int maxLength = Integer.MIN_VALUE;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLength=Math.max(maxLength,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        if(maxLength==Integer.MIN_VALUE){
            return 0;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LCSubstring lcSubstring = new LCSubstring();
        String text1 = "ABCDGH";
        String text2 = "ACDGHR";
        System.out.println("length of their longest common substring : "+lcSubstring.longestCommonSubstr(text1,text2));
    }

    //we can apply recurisve +memoization but it will require 3-D dp. below is the code so pls avoid and use LCSubsequence Tabulation bottom
    // up approach to populate length of substring
//    int[][][] dp;
//    public int lcsSubstring(int i, int j, int count, String s1, String s2) {
//        // Base case
//        if (i < 0 || j < 0) {
//            return count;
//        }
//
//        if (dp[i][j][count] != -1) {
//            return dp[i][j][count];
//        }
//
//        int same = count;
//
//        // If chars match, continue current substring
//        if (s1.charAt(i) == s2.charAt(j)) {
//            same = lcsSubstring(i - 1, j - 1, count + 1, s1, s2);
//        }
//
//        // Otherwise, reset count and try skipping one char
//        int diff1 = lcsSubstring(i - 1, j, 0, s1, s2);
//        int diff2 = lcsSubstring(i, j - 1, 0, s1, s2);
//
//        // Take max of all possibilities
//        return dp[i][j][count] = Math.max(same, Math.max(diff1, diff2));
//    }
//
//    public int longestCommonSubstring(String s1, String s2) {
//        int m = s1.length();
//        int n = s2.length();
//
//        // 3D DP: dp[i][j][count] (for memoization)
//        dp = new int[m][n][Math.min(m, n) + 1];
//        for (int[][] arr2d : dp) {
//            for (int[] arr1d : arr2d) {
//                Arrays.fill(arr1d, -1);
//            }
//        }
//
//        return lcsSubstring(m - 1, n - 1, 0, s1, s2);
//    }
}
