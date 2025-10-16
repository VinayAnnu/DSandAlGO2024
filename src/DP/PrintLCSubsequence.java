package DP;

public class PrintLCSubsequence {
    //Tabulation : bottom up--code taken from LCS.we need 2-D table to find the String of LCS
     public String longestCommonSubsequence(String text1, String text2) {
         int m = text1.length();
         int n = text2.length();
         //not possible to write indx1<0||indx2<0 in tabulation form. so we will apply shifting technique to overcome it. that is we will treat text as 1-based indexing
         int[][] dp = new int[m + 1][n + 1];
         for (int i = 1; i <= m; i++) {
             for (int j = 1; j <= n; j++) {
                 if (text1.charAt(i-1) == text2.charAt(j-1)) {
                     dp[i][j] = 1 + dp[i - 1][j - 1];
                 } else {
                     dp[i][j] = 0 + Math.max(dp[i - 1][j],dp[i][j - 1]);
                 }
             }
         }
         // Reconstruct LCS string
         StringBuilder sb = new StringBuilder();
         int i=m,j=n;
         while(i>0 && j>0){
             if (text1.charAt(i-1) == text2.charAt(j-1)) {
                 sb.insert(0,text1.charAt(i-1));
                 i--;
                 j--;
             } else if(dp[i - 1][j]>=dp[i][j - 1]){
                 i--;
             } else{
                 j--;
             }
         }
         return sb.toString();
     }

    public static void main(String[] args) {
        PrintLCSubsequence printLCS = new PrintLCSubsequence();
        String text1 = "AGGTAB";
        String text2 = "GXTXAYB";
        System.out.println("length of their longest common subsequence : "+printLCS.longestCommonSubsequence(text1,text2));
    }
}
