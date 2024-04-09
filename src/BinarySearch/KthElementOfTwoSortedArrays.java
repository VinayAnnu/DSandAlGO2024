package BinarySearch;

import java.util.ArrayList;

public class KthElementOfTwoSortedArrays{
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        int n1 = n;
        int n2 = m;
        int index = k-1;  //2,3,4,6,7,8,45 here rIndex will be on element 7 and lIndex will be on element 6
        int ele = -1;
        int i = 0, j = 0, count = 0;
        while (i < n1 && j < n2) {
            if (arr1.get(i) <= arr2.get(j)) {
                if (count == index) ele = arr1.get(i);
                i++;
            } else {
                if (count == index) ele = arr2.get(j);
                j++;
            }
            count++;
        }

        while (i < n1) {
            if (count == index) ele = arr1.get(i);
            count++;
            i++;
        }

        while (j < n2) {
            if (count == index) ele = arr2.get(j);
            count++;
            j++;
        }

        System.out.println("element " + ele);
        return ele;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(2);arr1.add(3);arr1.add(45);
        arr2.add(4);arr2.add(6);arr2.add(7);arr2.add(8);
        int k = 4;
        int kthElement = kthElement(arr1,arr2,3,4,k);
        System.out.println("Kth element : "+kthElement);
    }
}
