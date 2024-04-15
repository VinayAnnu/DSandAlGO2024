package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
    public static void combSum(int index, int []ARR, int B, int sum, List<Integer> al, List<List< Integer >> res) {
        if(index==ARR.length){
            if(sum == B){
                res.add(new ArrayList<>(al));
            }
            return;
        }
        if(sum>B)return;
        if(sum==B){
            res.add(new ArrayList<>(al));
            return;
        }

        sum+=ARR[index];
        al.add(ARR[index]);
        combSum(index,ARR,B,sum,al,res);

        sum-=ARR[index];
        al.remove(al.size()-1);
        combSum(index+1,ARR,B,sum,al,res);

    }
    public static List<List< Integer >> combSum(int []ARR, int B) {
        Arrays.sort(ARR);
        List<List< Integer >> res =new ArrayList<>();
        List<Integer> al =new ArrayList<>();
        combSum(0,ARR,B,0,al,res);
        return res;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{13,3,2,17};
        int k =14;
        List<List< Integer >> combinationSum = combSum(arr,k);
        System.out.println("All comibations : "+combinationSum);
    }
}
