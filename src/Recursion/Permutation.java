package Recursion;

import java.util.ArrayList;

public class Permutation {
    private static void computePermutaion(ArrayList<Integer> arr, ArrayList<Integer> al, ArrayList<ArrayList<Integer>> res, boolean[] flag) {
        if(al.size()==arr.size()){
            res.add(new ArrayList<>(al));
            return;
        }

        for(int i=0;i<arr.size();i++){
            if(!flag[i]){
                al.add(arr.get(i));
                flag[i] = true;
                computePermutaion(arr,al,res,flag);
                al.remove(al.size()-1);
                flag[i] = false;
            }
        }
    }
    private static ArrayList<ArrayList<Integer>> permutation(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        boolean[] flag = new boolean[arr.size()];
        computePermutaion(arr,al,res,flag);
        return res;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(2);arr.add(3);
        ArrayList<ArrayList<Integer>> permutations = permutation(arr);
        System.out.println("All permutations : "+permutations+" Size "+permutations.size());
    }
}
