package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstAndLastPositionInSortedArray {
 //   1st way
//    public static int lowerBound(ArrayList<Integer> list, int start, int end, int k){
//        int lb=-1;
//        while(start<=end){
//            int mid = start + (end-start)/2;
//            if(list.get(mid)>=k){
//                lb = mid;
//                end = mid-1;
//            } else {
//                start = mid+1;
//            }
//        }
//        return lb;
//    }
//    public static int upperBound(ArrayList<Integer> list, int start, int end, int k){
//        int ub=end+1;
//        while(start<=end){
//            int mid = start + (end-start)/2;
//            if(list.get(mid)>k){
//                ub = mid;
//                end = mid-1;
//            } else {
//                start = mid+1;
//            }
//        }
//        return ub;
//    }
//    public static int[] firstAndLastPosition(ArrayList<Integer> list, int n, int k) {
//        int lb = lowerBound(list, 0, n-1, k);
//        int ub = upperBound(list, 0, n-1, k);
//        if(lb ==-1 || list.get(lb) != k ){
//            return new int[]{-1,-1};
//        } else{
//            return new int[]{lb,ub-1};
//        }
//    }

    //2nd way
    public static int firstOccurence(ArrayList<Integer> list, int start, int end, int k){
        int fo=-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(list.get(mid)==k){
                fo = mid;
                end = mid-1;
            } else if(list.get(mid)>k) {
                end = mid-1;
            } else{
                start = mid+1;
            }
        }
        return fo;
    }
    public static int lastOccurence(ArrayList<Integer> list, int start, int end, int k){
        int lo=-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(list.get(mid)==k){
                lo = mid;
                start = mid+1;
            } else if(list.get(mid)>k) {
                end = mid-1;
            } else{
                start = mid+1;
            }
        }
        return lo;
    }
    public static int[] firstAndLastPosition(ArrayList<Integer> list, int n, int k) {
        int fo = firstOccurence(list, 0, n-1, k);
        if(fo==-1){
            return new int[]{-1,-1};
        } else {
            int lo = lastOccurence(list, 0, n-1, k);
            return new int[]{fo,lo};
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //0 0 1 1 2 2 2 2
        list.add(0);list.add(0);list.add(1);list.add(1);list.add(2);list.add(2);list.add(2);list.add(2);
        int[] ans = firstAndLastPosition(list,8,2);
        for (int an : ans) {
            System.out.println(an);
        }
    }
}
