package BinarySearch;

import java.util.Arrays;

public class AggresiveCows {
    public static int aggressiveCows(int []stalls, int k) {
        int n =stalls.length;
        Arrays.sort(stalls);
        int low = 1, high = stalls[n-1] - stalls[0];
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(checkCanWePlaceCow(stalls,mid,k)){
                ans = mid;
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return ans;
    }

    private static boolean checkCanWePlaceCow(int[] stalls, int mid, int k) {
        int countCow = 1, lastCow = stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-lastCow>=mid){
                countCow++;
                lastCow=stalls[i];
            }
            if(countCow==k){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,3,4,7,10,9};
        int k = 4;
        int maxPossibleMinDistance = aggressiveCows(arr,k);
        System.out.println("maximum possible minimum distance "+ maxPossibleMinDistance);
    }
}
