package BinarySearch;

import java.util.ArrayList;

public class FindPeakElement {

    //'arr[i]' is the peak element, if 'arr[i - 1]' < 'arr[i]' and 'arr[i + 1]' < 'arr[i]'.
    public static int findPeakElement(ArrayList<Integer> arr) {
        int n = arr.size();
        if(n==1) return 0;
        if(arr.get(0)>arr.get(1)) return 0;
        if(arr.get(n-1)>arr.get(n-2)) return n-1;
        int low=1,high=n-2;
        while (low<=high){
            int mid = low+(high-low)/2;
            if(arr.get(mid)>arr.get(mid-1) && arr.get(mid)>arr.get(mid+1)){
                return mid;
            } else if(arr.get(mid)>arr.get(mid-1)) {
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(1);
        list.add(5);
        list.add(3);
        int ans = findPeakElement(list);
        System.out.println("Index of Peak Element : " + ans);
    }
}
