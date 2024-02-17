package arrays;

import java.util.HashMap;

public class CountSubarrayXorEqualsK {
    public static int subarraysWithXorK(int []a, int k) {
        HashMap<Integer,Integer> hm =new HashMap<>();
        hm.put(0,1);
        int count = 0, prefXor = 0;
        for(int i=0;i<a.length;i++){
            prefXor = prefXor ^ a[i];
            if(hm.containsKey(prefXor^k)){
                count+=hm.get(prefXor^k);
            }
            hm.put(prefXor, hm.getOrDefault(prefXor, 0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2};
        int k = 2;
        int countSubarray = subarraysWithXorK(arr,k);
        System.out.println(countSubarray);
    }
}
