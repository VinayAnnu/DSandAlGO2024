package arrays;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {
    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        int m =a.length;
        int n = b.length;
        int i= m-1;
        int j=0;
        while(i>=0 && j<=n-1){
            if(a[i]>=b[j]){
                long temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                i--;j++;
            } else{
                break;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
//        for (long l : a) {
//            System.out.println(l);
//        }
//        System.out.println("-====-");
//        for (long l : b) {
//            System.out.println(l);
//        }
    }
    public static void main(String[] args) {
        long[] a = new long[]{1, 4, 5, 7};
        long[] b = new long[]{2,3,6};
        mergeTwoSortedArraysWithoutExtraSpace(a,b);
    }
}
