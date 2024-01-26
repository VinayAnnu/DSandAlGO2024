package arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedArray {
    public static List< Integer > sortedArray(int []a, int []b) {
        // Write your code here
        List<Integer> res=new ArrayList<>();
        int i=0;int j=0;
        while(i<a.length&&j<b.length){
            if(a[i]<=b[j]){
                if(res.size()==0 || res.get(res.size()-1)!=a[i]){
                    res.add(a[i]);
                }
                i++;
            } else{
                if(res.size()==0 || res.get(res.size()-1)!=b[j]){
                    res.add(b[j]);
                }
                j++;
            }
        }
        while(i<a.length){
            if(res.size()==0 || res.get(res.size()-1)!=a[i]){
                res.add(a[i]);
            }
            i++;
        }
        while(j<b.length){
            if(res.size()==0 || res.get(res.size()-1)!=b[j]){
                res.add(b[j]);
            }
            j++;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,4,6};
        int[] b=new int[]{2,3,5};
        List<Integer> res=sortedArray(a,b);
        for(int x:res){
            System.out.println(x);
        }
    }
}
