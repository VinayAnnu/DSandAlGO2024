package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static java.util.Collections.swap;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int index=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        if(index==-1){
            reverseArr(nums, 0, n-1);
        } else{
            for(int j=n-1;j>index;j--){
                if(nums[j]>nums[index]){
                    int temp=nums[j];
                    nums[j]=nums[index];
                    nums[index]=temp;
                    break;
                }
            }
            reverseArr(nums,index+1,n-1);
        }
    }

    private static void reverseArr(int[] nums, int start, int end) {
        while(start<end){
            int t=nums[start];
            nums[start]=nums[end];
            nums[end]=t;
            start++;end--;
        }
    }

    public static void main(String[] args) {
        int[] a=new int[]{3,2,1};
        System.out.println("before permutation");
        for (int i : a) {
            System.out.println(i);
        }
        nextPermutation(a);
        System.out.println("After permutation");
        for (int i : a) {
            System.out.println(i);
        }
    }
}
