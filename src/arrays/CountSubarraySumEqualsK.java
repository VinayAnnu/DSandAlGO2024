package arrays;

import java.util.HashMap;

public class CountSubarraySumEqualsK {
    public static int findAllSubarraysWithGivenSum(int arr[], int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum=0;int count=0;
        hm.put(0,1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(hm.containsKey(sum-k)){
                int x= hm.get(sum-k);
                count+=x;
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = { 10, 2, -2, -20, 10 };
        int k = -10;
        int countSubarray = findAllSubarraysWithGivenSum(arr,k);
        System.out.println(countSubarray);
    }
}
