package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ThreeSum {
    public static List<List< Integer >> triplet(int n, int []arr) {
        List<List< Integer >> al = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum = arr[i]+arr[j]+arr[k];
                if(sum>0){
                    k--;
                } else if (sum<0){
                    j++;
                } else{
                    List< Integer > tempAl = new ArrayList<>();
                    tempAl.add(arr[i]);tempAl.add(arr[j]);tempAl.add(arr[k]);
                    al.add(tempAl);
                    j++;
                    k--;
                    while(j<k && arr[j]==arr[j-1]) j++;
                    while(j<k && arr[k]==arr[k+1]) k--;
                }
            }
        }
        return al;
    }
    public static void main(String[] args) {
        List<List< Integer >> res = triplet(5,new int[]{-1, -1, 2, 0, 1});
        System.out.println(res);
    }
}
