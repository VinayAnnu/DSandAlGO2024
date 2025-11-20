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
//    int n = arr.length;
//    Map<Integer,Integer> sumVsIndex = new HashMap<>();
//    int res=0,prefSum=0;
//        for(int i=0;i<n;i++) {
//        prefSum=prefSum+arr[i];
//        sumVsIndex.putIfAbsent(prefSum,i);
    // Check if the entire prefix sums to k
//        if(prefSum==k){
//            res=i+1;
//        }else if(sumVsIndex.containsKey(prefSum-k)){
//            res = Math.max(res, i-sumVsIndex.get(prefSum-k));
//        }
//    }
//        return res;
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
