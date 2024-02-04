package arrays;

public class CountSubarraySumEqualsK {
    public static int findAllSubarraysWithGivenSum(int arr[], int k) {

        return -1;
    }
    public static void main(String[] args) {
        int arr[] = { 10, 2, -2, -20, 10 };
        int k = -10;
        int countSubarray = findAllSubarraysWithGivenSum(arr,k);
        System.out.println(countSubarray);
    }
}
