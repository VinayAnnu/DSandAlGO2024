package BinarySearch;

public class FindMinElementInRotatedSortedArray {
    public static int findMin(int []arr) {
        int low=0,high=arr.length-1;
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[low]==arr[mid] && arr[mid]==arr[high]){//shrik the search space
                ans=Math.min(ans,arr[mid]);
                low++;high--;
                continue;
            }
            //left half sorted-- take min element and Element the sorted part
            if(arr[low]<=arr[mid]){
                ans=Math.min(ans,arr[low]);
                low = mid+1;
            } else{
                ans=Math.min(ans,arr[mid]);
                high = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,5,2,2,2};
        int minElement = findMin(arr);
        System.out.println("Min ELement : "+minElement);
    }
}
