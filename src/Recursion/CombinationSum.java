package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
//    public static void combSum(int index, int []ARR, int B, int sum, List<Integer> al, List<List< Integer >> res) {
//        if(index==ARR.length){
//            if(sum == B){
//                res.add(new ArrayList<>(al));
//            }
//            return;
//        }
//        if(sum>B)return;
//        if(sum==B){
//            res.add(new ArrayList<>(al));
//            return;
//        }
//
//        sum+=ARR[index];
//        al.add(ARR[index]);
//        combSum(index,ARR,B,sum,al,res);
//
//        sum-=ARR[index];
//        al.remove(al.size()-1);
//        combSum(index+1,ARR,B,sum,al,res);
//
//    }
//    public static List<List< Integer >> combSum(int []ARR, int B) {
//        Arrays.sort(ARR);
//        List<List< Integer >> res =new ArrayList<>();
//        List<Integer> al =new ArrayList<>();
//        combSum(0,ARR,B,0,al,res);
//        return res;
//    }
//    public static void main(String[] args) {
//        int[] arr = new int[]{13,3,2,17};
//        int k =14;
//        List<List< Integer >> combinationSum = combSum(arr,k);
//        System.out.println("All comibations : "+combinationSum);
//    }

    public static void main(String[] args) {
        int[] arr = new int[]{13,3,2,17};
        int k =13;
        List< Integer > al = new ArrayList<>();
        List<List< Integer >> res = new ArrayList<>();
        combSum1(0,arr,k,al,res);
        System.out.println("All comibations : "+res);
    }

    private static void combSum1(int index, int[] arr, int k, List<Integer> al, List<List<Integer>> res) {
        if(index>=arr.length){
            if(k==0){
                res.add(new ArrayList<>(al));
            }
            return;
        }
        if(k<0){
            return;
        }
        al.add(arr[index]);
        combSum1(index, arr, k-arr[index], al, res);
        al.remove(al.size()-1);
        combSum1(index+1, arr, k, al, res);
    }
}
