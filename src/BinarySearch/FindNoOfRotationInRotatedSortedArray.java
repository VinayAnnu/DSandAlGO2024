package BinarySearch;

public class FindNoOfRotationInRotatedSortedArray {
    //this is similar to the finding min element in rotated sorted array. Just we have to return the index of
    //min element of sorted array.
    public static int findKRotation(int []arr){
        int low=0,high=arr.length-1;
        int ans = Integer.MAX_VALUE;
        int index=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[low]==arr[mid] && arr[mid]==arr[high]){//shrik the search space
                if(ans>=arr[mid]){
                    ans=arr[mid];
                    index = mid;
                }
                low++;high--;
                continue;
            }
            //left half sorted-- take min element and Element the sorted part
            if(arr[low]<=arr[mid]){
                if(ans>=arr[low]){
                    ans=arr[low];
                    index = low;
                }
                low = mid+1;
            } else{
                if(ans>=arr[mid]){
                    ans=arr[mid];
                    index = mid;
                }
                high = mid-1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,1};
        int noOfRotation = findKRotation(arr);
        System.out.println("Total rotation : "+noOfRotation);
    }
}
