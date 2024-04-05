package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllocateBooks {
    public static int[] findMaxElementAndTotalSumValue(ArrayList<Integer> arr){
        int x= Integer.MIN_VALUE;
        int sum=0;
        for(int i:arr){
            if(x<i){
                x=i;
            }
            sum+=i;
        }
        return new int[]{x,sum};
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if(m>n) return -1;
        int[] values = findMaxElementAndTotalSumValue(arr);
        int low = values[0], high = values[1];
        while(low<=high){
            int mid = low + (high-low)/2;
            if(checkNumberOfStudentPossibility(arr,mid)>m){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return low;
    }

    private static int checkNumberOfStudentPossibility(ArrayList<Integer> arr, int mid) {
        int countStudent =1;
        int CountStudentPagesAllocation = arr.get(0);
        for(int i=1;i<arr.size();i++){
            int x =arr.get(i);
            if(CountStudentPagesAllocation+x<=mid){
                CountStudentPagesAllocation+=x;
            } else{
                CountStudentPagesAllocation=x;
                countStudent++;
            }
        }
        return countStudent;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{25, 46, 28, 49, 24};
        ArrayList<Integer> al = new ArrayList<>();
        al.add(25);al.add(46);al.add(28);al.add(49);al.add(24);
        int n = 5, m = 4;
        int ans = findPages(al,n,m);
        System.out.println("the maximum number of pages assigned to a student is minimum " +ans);
    }
}
