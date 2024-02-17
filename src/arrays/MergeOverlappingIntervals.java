package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MergeOverlappingIntervals {
    //brute force
//    public static List<List< Integer >> mergeOverlappingIntervals(int [][]arr){
//        List<List< Integer >> al =new ArrayList<>();
//        Arrays.sort(arr, (a,b)->{
//            if(a[0]==b[0]){
//                return Integer.compare(a[1],b[1]);
//            } else {
//                return Integer.compare(a[0],b[0]);
//            }
//        });
//        for(int i=0;i<arr.length;i++){
//            int start = arr[i][0];
//            int end = arr[i][1];
//            if(!al.isEmpty() && al.get(al.size()-1).get(1) >= end){
//                continue;
//            }
//            for(int j=i+1;j<arr.length;j++){
//                if(arr[j][0] <= end){
//                    end = Math.max(end, arr[j][1]);
//                }
//                else {
//                    break;
//                }
//            }
//            al.add(Arrays.asList(start,end));
//        }
//        return al;
//    }

    //optimal solution in single iteration
    public static List<List< Integer >> mergeOverlappingIntervals(int [][]arr){
        List<List< Integer >> al =new ArrayList<>();
        Arrays.sort(arr, (a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(a[1],b[1]);
            } else {
                return Integer.compare(a[0],b[0]);
            }
        });
        for(int i=0;i<arr.length;i++){
            int start = arr[i][0];
            int end = arr[i][1];
            if(al.isEmpty()){
                al.add(Arrays.asList(start,end));
            } else {
                if(al.get(al.size()-1).get(1) >= start){
                    end = Math.max(end, al.get(al.size()-1).get(1));
                    start = al.get(al.size()-1).get(0);
                    al.remove(al.size()-1);
                }
                al.add(Arrays.asList(start,end));
            }
        }
        return al;
    }
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3}, {2, 4}, {3, 5}, {6, 7},{2,6},{2,3},{1,7},{1,2}};
        List<List< Integer >> res = mergeOverlappingIntervals(arr);
        System.out.println(res);
    }
}
