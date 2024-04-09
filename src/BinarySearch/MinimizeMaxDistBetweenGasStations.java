package BinarySearch;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimizeMaxDistBetweenGasStations {

    //brute force approach
//    public static double MinimiseMaxDistance(int []arr, int K){
//        // Write your code here.
//        int n = arr.length;
//        int[] numberOfGasStationsPlacedBetweenxistingGasStation = new int[n-1]; // 6 section exist in arr to place new gas station
//
//        for(int i=1; i<=K; i++){ //traverse one by one gas station to place in arr
//            double maxSectionLength = -1d;
//            int maxSectionIndex = -1;
//            for(int j=0;j<n-1;j++){  //traverse all sections
//                double sectionDifference = arr[j+1]-arr[j];
//                double sectionLength = (double)sectionDifference/(1 + numberOfGasStationsPlacedBetweenxistingGasStation[j]);
//
//                if(maxSectionLength < sectionLength){
//                    maxSectionLength = sectionLength;
//                    maxSectionIndex = j;
//                }
//            }
//            numberOfGasStationsPlacedBetweenxistingGasStation[maxSectionIndex]++;
//        }
//        double res = -1.0d;
//        for(int l=0; l<n-1; l++){
//            double sectionLength = (double)(arr[l+1]-arr[l])/(1 + numberOfGasStationsPlacedBetweenxistingGasStation[l]);
//            if(res < sectionLength){
//                res = sectionLength;
//            }
//        }
//
//        return res;
//    }


    //using priorityQueue

    public static class Pair{
        double sectionLength;
        int sectionIndex;
        Pair(double sectionLength, int sectionIndex){
            this.sectionLength=sectionLength;
            this.sectionIndex=sectionIndex;
        }
    }
    public static double MinimiseMaxDistance(int []arr, int K){
        // Write your code here.
        int n = arr.length;
        int[] numberOfGasStationsPlacedBetweenxistingGasStation = new int[n-1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Double.compare(b.sectionLength,a.sectionLength));
        for(int i=0;i<n-1;i++){
            pq.add(new Pair(arr[i+1]-arr[i],i));
        }

        for(int i=1; i<=K; i++){ //traverse one by one gas station to place in arr
            Pair p = pq.poll();
            int sectionInd = p.sectionIndex;
            numberOfGasStationsPlacedBetweenxistingGasStation[sectionInd]++;
            double newMaxSectionLength = (double)(arr[sectionInd+1]-arr[sectionInd])/(numberOfGasStationsPlacedBetweenxistingGasStation[sectionInd]+1);
            pq.add(new Pair(newMaxSectionLength,sectionInd));
        }
//        Pair ans = pq.poll();
        return pq.peek().sectionLength;
    }
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
//        int k = 6; //'k' new gas stations to be added

        int[] arr = new int[]{4, 6, 10};
        int k = 4;

        double ans = MinimiseMaxDistance(arr, k);
        System.out.println("minimum value of dist "+ans);
    }
}
