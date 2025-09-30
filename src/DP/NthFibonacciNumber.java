package DP;
//1. using recursion only.
//Time Complexity: O(2^n) (Exponential)
//Space Complexity: O(n) (Recursion stack)
// class Solution {
//
//     public int nthFibonacci(int n) {
//         if(n<=1){
//             return n;
//         }
//         return nthFibonacci(n-1) + nthFibonacci(n-2);
//     }
// }

//2.Using memoization-Top-down approach
//O(n) time, O(n) space.
// class Solution {
//     public int nthFibonacci(int n, int[] arr){
//         if(n<=1){
//             return n;
//         }
//         if(arr[n]!=-1){
//             return arr[n];
//         }
//         return arr[n]=nthFibonacci(n-1,arr)+nthFibonacci(n-2,arr);
//     }
//     public int nthFibonacci(int n) {
//         int[] arr = new int[n+1];
//         Arrays.fill(arr,-1);
//         return nthFibonacci(n, arr);
//     }
// }

//3.tabulation (bottom-up DP) → O(n) time, O(n) space.
// class Solution {
//     public int nthFibonacci(int n) {
//         if(n==0)return 0;
//         int[] arr = new int[n+1];
//         arr[0]=0;
//         arr[1]=1;
//         for(int i=2;i<=n;i++){
//             arr[i]=arr[i-1]+arr[i-2];
//         }
//         return arr[n];
//     }
// }

//4.Use space-optimized tabulation → O(n) time, O(1) space (just two variables).
public class NthFibonacciNumber {
    public int nthFibonacci(int n) {
        if(n==0)return 0;
        int prev2=0,prev1=1;
        for(int i=2;i<=n;i++){
            int curr = prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        NthFibonacciNumber nthFibonacciNumber = new NthFibonacciNumber();
        System.out.println("nth fibonacci number : "+nthFibonacciNumber.nthFibonacci(6));
    }
}
