package BinarySearch;

public class SplitArrayLargestSum {  //this problem is exact similar to AllocateBooks problem

    public static int[] findMaxElementAndTotalSumValue(int[] arr){
        int x= Integer.MIN_VALUE;
        int sum=0;
        for(int i:arr){
            if(x<i){
                x=i;
            }
            sum+=i;
        }
        return new int[]{x,sum};
    }
    public static int largestSubarraySumMinimized(int []a, int k) {
        int[] values = findMaxElementAndTotalSumValue(a);
        int low = values[0], high = values[1];
        while(low<=high){
            int mid = low + (high-low)/2;
            if(checkNumberOfSubarrayPossibility(a,mid)>k){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return low;
    }
    private static int checkNumberOfSubarrayPossibility(int[] arr, int mid) {
        int countSubarray =1;
        int CountSubarraySumAllocation = arr[0];
        for(int i=1;i<arr.length;i++){
            int x =arr[i];
            if(CountSubarraySumAllocation+x<=mid){
                CountSubarraySumAllocation+=x;
            } else{
                CountSubarraySumAllocation=x;
                countSubarray++;
            }
        }
        return countSubarray;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 4, 5, 10, 9, 10};
        int k = 4;
        System.out.println(" the minimized largest sum of the split : "+largestSubarraySumMinimized(arr,k));
    }
}
