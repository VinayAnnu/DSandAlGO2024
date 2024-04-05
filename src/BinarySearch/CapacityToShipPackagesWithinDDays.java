package BinarySearch;

public class CapacityToShipPackagesWithinDDays {
    public static int[] findMaxElementAndTotalSumValue(int[] arr){
        int x= Integer.MIN_VALUE;
        int sum=0;
        for(int i:arr){
            if(x<i){
                x=i;
            }
            sum+=i;
        }
        return new int[]{x,sum};
    }

    public static int checkCapacity(int[] weights, int capacity){
        int noOfDays=1,load=0;
        for (int i=0;i<weights.length;i++){
            if(weights[i]+load>capacity){
                load=weights[i];
                noOfDays+=1;
            } else{
                load+=weights[i];
            }
        }
        return noOfDays;
    }
    public static int leastWeightCapacity(int[] weights, int d) {
        int[] values= findMaxElementAndTotalSumValue(weights);
        int low=values[0];
        int high = values[1];
        int ans=-1;
        while(low<=high){
            int capacity = low+(high-low)/2;
            if(checkCapacity(weights, capacity)<=d){
                ans=capacity;
                high=capacity-1;
            } else{
                low=capacity+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 5, 2,3,4,5,6};
        int daysThreshold = 5;
        int leastWeightCapacity = leastWeightCapacity(arr,daysThreshold);
        System.out.println("least-weight capacity so that you can ship all the packages within 'd' days : "+leastWeightCapacity);
    }
}
