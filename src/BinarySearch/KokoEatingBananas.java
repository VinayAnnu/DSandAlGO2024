package BinarySearch;

public class KokoEatingBananas {
    public static int findMaxElement(int[] arr){
        int x= Integer.MIN_VALUE;
        for(int i:arr){
            if(x<i){
                x=i;
            }
        }
        return x;
    }

    public static int checkMinimumBananaToEatperHour(int[] arr, int x){
        int totalHour = 0;
        for(int i:arr){
            double result = Math.ceil((double) i / x);
            totalHour+=result;
        }
        return totalHour;
    }
    public static int minimumRateToEatBananas(int []v, int h) {
        int maxElement = findMaxElement(v);
        int low = 1, high = maxElement;
        int ans=-1;
        while(low<=high){
            int noOfBanana = low + (high-low)/2;
            int totalHourToEatGivenBanana = checkMinimumBananaToEatperHour(v,noOfBanana);
            if(totalHourToEatGivenBanana<=h){
                ans = noOfBanana;
                high = noOfBanana - 1;
            } else{
                low = noOfBanana+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,6,2,8};
        int h = 7;
        int minimumBananaToEatPerHour = minimumRateToEatBananas(arr,h);
        System.out.println("Minimum Banana To Eat Per Hour : "+minimumBananaToEatPerHour);
    }
}
