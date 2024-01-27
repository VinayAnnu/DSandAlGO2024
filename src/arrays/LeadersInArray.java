package arrays;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    public static List< Integer > superiorElements(int []a) {
        // Write your code here.
        List<Integer> al =new ArrayList<>();
        int n=a.length;
        int max=a[n-1];
        al.add(max);
        for(int i=n-2;i>=0;i--){
            if(a[i]>max){
                al.add(a[i]);
                max=a[i];
            }
        }
        return al;
    }
    public static void main(String[] args) {
        List<Integer> al = superiorElements(new int[]{1, 2, 3, 2});
        al.stream().forEach(System.out::println);
    }
}
