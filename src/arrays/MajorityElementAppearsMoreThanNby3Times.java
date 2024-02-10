package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MajorityElementAppearsMoreThanNby3Times {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int num1=Integer.MIN_VALUE,num2=Integer.MIN_VALUE,count1=0,count2=0;
        for(int i=0;i<nums.length;i++){
            if(count1==0 && nums[i] != num2){
                num1=nums[i];
                count1=1;
            }
            else if(count2==0 && nums[i] != num1){
                num2=nums[i];
                count2=1;
            }
            else if(num1==nums[i]){
                count1++;
            }
            else if(num2==nums[i]){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0;count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==num1){
                count1++;
            }
            if(nums[i]==num2){
                count2++;
            }
        }
        int mini = (int)nums.length/3;
        if(count1>mini){
            res.add(num1);
        }
        if(count2>mini){
            res.add(num2);
        }
        Collections.sort(res);
        return res;
    }
    public static void main(String[] args) {
        List<Integer> res = majorityElement(new int[]{2, 2, 1, 3, 1, 1, 3, 1, 1,2,3,2,2,2});
        System.out.println(res);
    }
}
