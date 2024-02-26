package BinarySearch;

import java.util.ArrayList;

public class SearchElementInRotatedSortedArrayHavingUniqElement {
    public static int search(ArrayList<Integer> arr, int n, int k) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) == k) {
                return mid;
            }

            //left half sorted
            if (arr.get(low) <= arr.get(mid)) {
                if (arr.get(low) <= k && k <= arr.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { ///right half sorted
                if (arr.get(mid) <= k && k <= arr.get(high)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(8);
        list.add(1);
        list.add(3);
        list.add(5);
        int ans = search(list, 5, 1);
        System.out.println("Element dound at Index : " + ans);
    }
}
