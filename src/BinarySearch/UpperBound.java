package BinarySearch;

public class UpperBound {
    //return smallest index idx, which has arr[idx] > target
    public static int upperBound(int []arr, int x, int n){
        return binarySearch(arr,0,n-1,x);
    }
    public static int binarySearch(int[] nums, int start, int end, int target) {
        int ans = nums.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                ans=mid;
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,6,7};
        int n = 4, x = 5;
        int ubIndex = upperBound(arr, n, x);
        System.out.println("UpperBound index : " + ubIndex);
    }
}
