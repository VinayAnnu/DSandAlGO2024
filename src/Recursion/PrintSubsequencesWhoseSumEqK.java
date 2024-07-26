package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequencesWhoseSumEqK {

    private static void printSubsequenceSumEqualK(int[] arr, int index, int k, int sum, List<Integer> al, List<List<Integer>> listOfSubsequence) {
        if(index>=arr.length){
            if(sum==k){
                listOfSubsequence.add(new ArrayList<>(al));
            }
            return;
        }

        sum+=arr[index];
        al.add(arr[index]);
        printSubsequenceSumEqualK(arr, index+1, k, sum, al, listOfSubsequence);
        al.remove(al.size()-1);
        sum-=arr[index];
        printSubsequenceSumEqualK(arr, index+1, k, sum, al, listOfSubsequence);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,3,4};
        int k = 4;
        List<List<Integer>> listOfSubsequence = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        printSubsequenceSumEqualK(arr,0,k,0,al,listOfSubsequence);
        System.out.println("listOfSubsequence : "+listOfSubsequence);

    }
}
