package DP;

import java.util.Arrays;

public class LCSubsequence {
    //recursive+memoization
    public int LCS(int indx1, int indx2, String text1, String text2, int[][] dp) {
        //base case
        if (indx1 < 0 || indx2 < 0) {
            return 0;
        }
        if (dp[indx1][indx2] != -1) {
            return dp[indx1][indx2];
        }
        //explore paths
        if (text1.charAt(indx1) == text2.charAt(indx2)) {
            return dp[indx1][indx2] = 1 + LCS(indx1 - 1, indx2 - 1, text1, text2, dp);
        } else {
            return dp[indx1][indx2] = 0
                    + Math.max(LCS(indx1 - 1, indx2, text1, text2, dp), LCS(indx1, indx2 - 1, text1, text2, dp));
        }

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return LCS(m - 1, n - 1, text1, text2, dp);
    }

    public static void main(String[] args) {
        LCSubsequence lcs = new LCSubsequence();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("length of their longest common subsequence : "+lcs.longestCommonSubsequence(text1,text2));
    }

    //Tabulation : bottom up
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int m = text1.length();
    //     int n = text2.length();
    //     //not possible to write indx1<0||indx2<0 in tabulation form. so we will apply shifting technique to overcome it. that is we will treat text as 1-based indexing
    //     int[][] dp = new int[m + 1][n + 1];
    //     for (int i = 1; i <= m; i++) {
    //         for (int j = 1; j <= n; j++) {
    //             if (text1.charAt(i-1) == text2.charAt(j-1)) {
    //                 dp[i][j] = 1 + dp[i - 1][j - 1];
    //             } else {
    //                 dp[i][j] = 0 + Math.max(dp[i - 1][j],dp[i][j - 1]);
    //             }
    //         }
    //     }
    //     return dp[m][n];
    // }

    //Tabulation: space optimization
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int m = text1.length();
    //     int n = text2.length();
    //     //not possible to write indx1<0||indx2<0 in tabulation form. so we will apply shifting technique to overcome it. that is we will treat text as 1-based indexing
    //     int[] prev = new int[n + 1];
    //     for (int i = 1; i <= m; i++) {
    //         int[] curr = new int[n + 1];
    //         for (int j = 1; j <= n; j++) {
    //             if (text1.charAt(i-1) == text2.charAt(j-1)) {
    //                 curr[j] = 1 + prev[j - 1];
    //             } else {
    //                 curr[j] = 0 + Math.max(prev[j],curr[j - 1]);
    //             }
    //         }
    //         prev= curr;
    //     }
    //     return prev[n];
    // }
}
