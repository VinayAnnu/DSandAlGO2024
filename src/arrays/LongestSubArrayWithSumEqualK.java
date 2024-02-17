package arrays;

public class LongestSubArrayWithSumEqualK {
    //brute force
    // public static int longestSubarrayWithSumK(int []a, long k) {//o(n^2)
    //     // Write your code here
    //     int legthLongestSubArray=0;
    //     for(int i=0;i<a.length;i++){
    //         long sum=0;
    //         for(int j=i;j<a.length;j++){
    //             sum+=a[j];
    //             if(sum==k){
    //                 legthLongestSubArray=Math.max(legthLongestSubArray,j-i+1);
    //             }
    //         }
    //     }
    //     return legthLongestSubArray;
    // }

    // public static int longestSubarrayWithSumK(int []a, long k) {//this is optimal sol for +ve,-ve,0 values in array
    //     // TC-O(N*1) in best and average case using unordered map that is HashMap
    //     //TC-O(N*N) in worst case using unordered map that is HashMap due to collision
    //     //TC- O(NlogN) in best,avg,worst case suing ordered map taht is TreeMap
    //     int legthLongestSubArray=0; long sum=0;
    //     HashMap<Long,Integer> hm = new HashMap<>();
    //     for(int i=0;i<a.length;i++){
    //         sum+=a[i];
    //         if(sum==k){
    //             legthLongestSubArray=Math.max(legthLongestSubArray,i+1);
    //         }
    //         long rem = sum-k;
    //         if(hm.containsKey(rem)){
    //             legthLongestSubArray=Math.max(legthLongestSubArray,i-hm.get(rem));
    //         }
    //         if(!hm.containsKey(sum)){
    //             hm.put(sum,i);
    //         }
    //     }
    //     return legthLongestSubArray;
    // }


    public static int longestSubarrayWithSumK(int []a, long k) {//this is optimal sol for only +ve and 0 values in array
        //T(c)-O(2n)
        int legthLongestSubArray=0; long sum=a[0];
        int fwdPtr=0,bwdPtr=0;
        while(fwdPtr<a.length){
            while(sum>k && bwdPtr<=fwdPtr){
                sum-=a[bwdPtr];
                bwdPtr++;
            }
            if(sum==k){
                legthLongestSubArray=Math.max(legthLongestSubArray,fwdPtr-bwdPtr+1);
            }

            fwdPtr++;
            if(fwdPtr<a.length){
                sum+=a[fwdPtr];
            }
        }
        return legthLongestSubArray;
    }
    public static void main(String[] args) {
        int[] a=new int[]{1, 2, 3, 1, 1, 1, 1};
        int k=3;
        int res=longestSubarrayWithSumK(a,k);
        System.out.println(res);
    }
}
