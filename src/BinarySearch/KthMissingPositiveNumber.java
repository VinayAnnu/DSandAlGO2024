package BinarySearch;

public class KthMissingPositiveNumber {
    // Iterative Approach
    // public static int missingK(int[] vec, int n, int k) {
    //     int missingNumber=k;
    //     for(int i:vec){
    //         if(i>k){
    //             break;
    //         }else{
    //             k++;
    //             missingNumber=k;
    //         }
    //     }
    //     return missingNumber;
    // }

    public static int missingK(int[] vec, int n, int k) {
        int low=0,high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int totalNoOfMissing=vec[mid]-(mid+1);
            if(totalNoOfMissing<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low+k;
    }
    public static void main(String[] args) {
        int[] vec = new int[]{2, 4, 5, 7};
        int kthMissingNumber = missingK(vec,4,3);
        System.out.println("kth missing number : "+kthMissingNumber);
    }
}
