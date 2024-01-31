package arrays;
import java.util.Arrays;
import java.util.HashSet;

public class LongestSuccessiveElements {
//    public static int longestSuccessiveElements(int []a) {
//        // Better solution with sorting--nlogn
//        int longest=1;
//        int count=0;int lastSmaller=Integer.MIN_VALUE;
//        Arrays.sort(a);
//        for(int i=0;i<a.length;i++){
//            if(a[i]-1==lastSmaller){
//                lastSmaller=a[i];
//                count++;
//            }
//            else if(a[i]!=lastSmaller){
//                lastSmaller=a[i];
//                count=1;
//            }
//            longest = Math.max(count,longest);
//        }
//        return longest;
//    }
    public static int longestSuccessiveElements(int []a) {
        // optimal solution with hashset, tc- o(n)
        int longest=1;
        int count=0;
        HashSet<Integer> hs = new HashSet<>();
        for(int x:a){
            hs.add(x);
        }
        for(int t:hs){
            if(!hs.contains(t-1)){
                count=1;
                int v = t+1;
                while (hs.contains(v)){
                    count++;
                    v=v+1;
                }
                longest = Math.max(count,longest);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] a=new int[]{1,2,2,1};
        int longest = longestSuccessiveElements(a);
        System.out.println("Longest Successive "+longest);

    }
}
