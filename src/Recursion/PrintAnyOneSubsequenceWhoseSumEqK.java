package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAnyOneSubsequenceWhoseSumEqK {

    private static boolean printAnyOneSubsequenceSumEqualK(int[] arr, int index, int k, int sum, List<Integer> al) {
        if(index>=arr.length){
            if(sum==k){
                return true;
            }
            return false;
        }

        sum+=arr[index];
        al.add(arr[index]);
        if(printAnyOneSubsequenceSumEqualK(arr, index+1, k, sum, al)){
            return true;
        }

        al.remove(al.size()-1);
        sum-=arr[index];
        if(printAnyOneSubsequenceSumEqualK(arr, index+1, k, sum, al)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,3,4};
        int k = 5;
        List<Integer> al = new ArrayList<>();
        if(printAnyOneSubsequenceSumEqualK(arr,0,k,0,al)){
            System.out.println("Subsequence : "+al);
        } else{
            System.out.println("No Subsequence found: ");
        }
    }

}
