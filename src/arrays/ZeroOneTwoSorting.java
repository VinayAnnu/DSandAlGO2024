package arrays;

import java.util.ArrayList;
import java.util.List;

public class ZeroOneTwoSorting {
    public static void sortArray(ArrayList<Integer> arr, int n) {
        // TRICK.
        //index 0 to low-1 --only 0's element
        //index low to mid-1 --only 1's element
        //index mid to high --only unsorted element
        //index high+1 to n-1 --only 2's element
        int low=0,mid=0,high=n-1;
        while(mid<=high){
            if(arr.get(mid)==0){
                int x = arr.get(low);
                arr.set(low,0);
                arr.set(mid,x);
                mid++;low++;
            }
            else if(arr.get(mid)==1){
                mid++;
            }
            else if(arr.get(mid)==2){
                int y = arr.get(high);
                arr.set(high,2);
                arr.set(mid,y);
                high--;
            }
        }
        System.out.println(arr);
    }
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(List.of(2, 2, 2, 2, 0, 0, 1, 0));
        sortArray(al,8);
    }
}
