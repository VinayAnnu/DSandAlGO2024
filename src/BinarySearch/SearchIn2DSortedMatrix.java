package BinarySearch;

import java.util.ArrayList;

public class SearchIn2DSortedMatrix {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        int m=mat.size();
        int n =mat.get(0).size();
        int low=0,high=m*n - 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int row = mid / n;
            int col = mid % n;
            if(mat.get(row).get(col).equals(target)){
                return true;
            } else if(mat.get(row).get(col) < target){
                low =mid+1;
            } else{
                high = mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);row1.add(2);row1.add(3);row1.add(4);
        matrix.add(row1);
        // Create the second row and add it to matrix
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(5);row2.add(6);row2.add(7);row2.add(8);
        matrix.add(row2);
        // Create the third row and add it to matrix
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(9);row3.add(10);row3.add(11);row3.add(12);
        matrix.add(row3);
        int m = 3;//no of rows
        int n = 4; //no of colums
        int k = 8; //element to be searched
        System.out.println("Does element exist "+ searchMatrix(matrix, k));
    }
}
