import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class TwoSumProblem {
//    public static String read(int n, int []book, int target){
//        // Write your code here.
//        HashMap<Integer,Integer> hm =new HashMap<>();
//        for(int i=0;i<book.length;i++){
//            if(hm.containsKey(target-book[i])){
//                return "YES";
//            }
//            hm.put(book[i],i);
//        }
//        return "NO";
//    }

    public static String read(int n, int []book, int target){
        // Write your code here.
        Arrays.sort(book);
        int start=0,end=n-1;
        while(start<end){
            if(book[start]+book[end]==target){
                return "YES";
            }
            else if(book[start]+book[end]>target){
                end--;
            }
            else {
                start++;
            }
        }
        return "NO";
    }
    public static void main(String[] args) {
        String res = read(5,new int[]{4, 1, 2, 3, 1},5);
        System.out.println(res);
    }
}
