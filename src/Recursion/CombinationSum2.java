package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum2 {
//    Brute force approach
//    public static void addUniqueList(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> newList) {
//        Set<List<Integer>> set = new HashSet<>(res); // Convert to set for easy checking of uniqueness
//        if (!set.contains(newList)) {
//            res.add(newList); // Add only if the list is not already in the set
//        }
//    }
//
//    public static void combSum(int index, ArrayList<Integer> ARR, int B, int sum, ArrayList<Integer> al, ArrayList<ArrayList<Integer>> res) {
//        if(index==ARR.size()){
//            if(sum == B){
//                addUniqueList(res, new ArrayList<>(al));
//                //res.add(new ArrayList<>(al));
//            }
//            return;
//        }
//        if(sum>B)return;
//        if(sum==B){
//            addUniqueList(res, new ArrayList<>(al));
//            //res.add(new ArrayList<>(al));
//            return;
//        }
//
//        sum+=ARR.get(index);
//        al.add(ARR.get(index));
//        combSum(index+1,ARR,B,sum,al,res);
//
//        sum-=ARR.get(index);
//        al.remove(al.size()-1);
//        combSum(index+1,ARR,B,sum,al,res);
//
//    }


    public static void combSum(int index, ArrayList<Integer> ARR, int B, int sum, ArrayList<Integer> al, ArrayList<ArrayList<Integer>> res) {
        if (sum == B) {
            res.add(new ArrayList<>(al));
            return;
        }

        for (int i = index; i < ARR.size(); i++) {
            if (i > index && ARR.get(i) == ARR.get(i - 1)) {
                continue;
            }

            sum += ARR.get(i);
            al.add(ARR.get(i));
            combSum(i + 1, ARR, B, sum, al, res);
            sum -= ARR.get(i);
            al.remove(al.size() - 1);
        }
    }
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)
    {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> res =new ArrayList<>();
        ArrayList<Integer> al =new ArrayList<>();
        combSum(0,arr,target,0,al,res);
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(2);arr.add(3);arr.add(1);
        int k =5;
        ArrayList<ArrayList<Integer>> combinationSum = combinationSum2(arr,4,k);
        System.out.println("All comibations : "+combinationSum);
    }
}
