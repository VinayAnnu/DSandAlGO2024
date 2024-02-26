package BinarySearch;

public class RoseGarden {
    public static int findMaxElement(int[] arr){
        int x= Integer.MIN_VALUE;
        for(int i:arr){
            if(x<i){
                x=i;
            }
        }
        return x;
    }

    public static int findMinElement(int[] arr){
        int x= Integer.MAX_VALUE;
        for(int i:arr){
            if(x>i){
                x=i;
            }
        }
        return x;
    }

    public static boolean checkPossibility(int[] arr, int noOfAdjacentRoses, int noOfBouquet, int val){
        int noOfBouquetAttained = 0 , count =0;
        for(int i :arr){
            if(i<=val){
                count++;
            }else {
                noOfBouquetAttained += count/noOfAdjacentRoses;
                count=0;
            }
        }
        noOfBouquetAttained += count/noOfAdjacentRoses;
        if(noOfBouquetAttained>=noOfBouquet){
            return true;
        }
        return false;
    }
    public static int roseGarden(int[] arr, int noOfAdjacentRoses, int noOfBouquet) {
        int low = findMinElement(arr);
        int high = findMaxElement(arr);
        int ans = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(checkPossibility(arr, noOfAdjacentRoses, noOfBouquet, mid)){
                ans = mid;
                high = mid-1;
            } else{
                low = mid +1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 2, 7, 2, 2, 3, 1};
        int k = 3,m=2;
        int ans = roseGarden(arr,k,m);
        System.out.println("minimum number of days required to make at least 'm' bouquets each containing 'k' roses "+ans);
    }
}
