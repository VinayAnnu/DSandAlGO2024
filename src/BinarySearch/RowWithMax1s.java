package BinarySearch;

import java.util.ArrayList;

public class RowWithMax1s {
    public static int lowerBound(ArrayList<Integer> al, int k){
        int low = 0,high=al.size()-1,ans=-1;
        while (low<=high){
            int mid = low + (high-low)/2;
            if(al.get(mid) >= k){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m)
    {
        int maxCountOne=-1,index=-1;
        for(int i=0;i<matrix.size();i++){
            int startOfElementOneIdx = lowerBound(matrix.get(i), 1);
            if (startOfElementOneIdx>=0) {
                int totalOne = m - startOfElementOneIdx;
                if(maxCountOne < totalOne){
                    maxCountOne =totalOne;
                    index = i;
                }
            }
        }
        return index;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);row1.add(1);row1.add(1);
        matrix.add(row1);
        // Create the second row and add it to matrix
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(0);row2.add(0);row2.add(1);
        matrix.add(row2);
        // Create the third row and add it to matrix
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(0);row3.add(0);row3.add(0);
        matrix.add(row3);
        System.out.println("index of the first row with the maximum number of 1's "+ maximumOnesRow(matrix, 3, 3));
    }
}
