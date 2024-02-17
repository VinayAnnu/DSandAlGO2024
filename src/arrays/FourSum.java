package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List< Integer >> al = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int k=j+1;
                int l=n-1;
                while(k<l){
                    int sum = nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum>target){
                        l--;
                    } else if (sum<target) {
                        k++;
                    } else {
                        List< Integer > tempAl = new ArrayList<>();
                        tempAl.add(nums[i]);tempAl.add(nums[j]);tempAl.add(nums[k]);tempAl.add(nums[l]);
                        al.add(tempAl);
                        k++;
                        l--;
                        while (k<l && nums[k]==nums[k-1]) k++;
                        while (k<l && nums[l]==nums[l+1]) l--;
                    }
                }
            }
        }
        return al;
    }
    public static void main(String[] args) {
        List<List< Integer >> res = fourSum(new int[]{2, 2, 2, 2, 1, 3}, 8);
        System.out.println(res);
    }
}
