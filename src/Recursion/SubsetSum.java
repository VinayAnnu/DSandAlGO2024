package Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSum {
    private static void subsetSum(int index,int sum, ArrayList<Integer> al, int[] num) {
        if(index==num.length){
            al.add(sum);
            return;
        }

        sum+=num[index];
        subsetSum(index+1,sum,al,num);
        sum-=num[index];
        subsetSum(index+1,sum,al,num);
    }
    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> al =new ArrayList<>();
        subsetSum(0,0,al,num);
        Collections.sort(al);
        return al;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        ArrayList<Integer> res = subsetSum(arr);
        System.out.println("ALl Subset Sum : "+res);
    }
}
