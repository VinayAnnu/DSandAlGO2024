package BinarySearch;

public class BinarySearch {
    public static int search(int []nums, int target) {
        int start = 0,end=nums.length-1;
        return binarySearch(nums,start,end,target);
    }

    //iterative approach
    public static int binarySearch(int []nums, int start, int end, int target){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target){
                return mid;
            } else if(nums[mid]<target){
                start=mid+1;
            } else{
                end=mid-1;
            }
        }
        return -1;
    }

    //recursive approach
//    public static int binarySearch(int []nums, int start, int end, int target){
//        if(start<=end){
//            int mid = start + (end-start)/2;
//            if(nums[mid]==target){
//                return mid;
//            } else if(nums[mid]<target){
//                return binarySearch(nums,mid+1,end,target);
//            } else {
//                return binarySearch(nums,start,mid-1,target);
//            }
//        }
//        return -1;
//    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 7, 9, 11, 12, 45};
        int index = search(arr,3);
        if(index==-1){
            System.out.println("target does not exist in array");
        }
        else {
            System.out.println("Element found at index "+ index);
        }
    }
}
