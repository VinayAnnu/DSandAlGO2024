package BinarySearch;

public class LowerBound {
    //return smallest index idx, which has arr[idx] >= target
    public static int lowerBound(int[] arr, int n, int x) {
        return binarySearch(arr,0,n-1,x);
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
        int ans = nums.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                ans=mid;
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 3, 5};
        int n = 7, x = 2;
        int lbIndex = lowerBound(arr, n, x);
        System.out.println("LowerBound index : " + lbIndex);
    }
}
