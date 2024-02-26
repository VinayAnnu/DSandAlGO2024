package BinarySearch;

import java.util.ArrayList;

public class SingleElementInASortedArray {
    public static int singleNonDuplicate(ArrayList<Integer> arr) {
        //handle edge case first then apply binary search
        int n = arr.size();
        if (n == 1) {
            return arr.get(0);
        }
        if (arr.get(0) != arr.get(1)) {
            return arr.get(0);
        }
        if (arr.get(n - 1) != arr.get(n - 2)) {
            return arr.get(n - 1);
        }
        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) != arr.get(mid - 1) && arr.get(mid) != arr.get(mid + 1)) {
                return arr.get(mid);
            }
            if ((mid % 2 == 1 && arr.get(mid) == arr.get(mid - 1)) || (mid % 2 == 0 && arr.get(mid) == arr.get(mid + 1))) {
                low = mid + 1; //Element left half
            } else {
                high = mid - 1;  //Element right half
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(5);
        int ans = singleNonDuplicate(list);
        System.out.println("NonDuplicate element : " + ans);
    }
}
