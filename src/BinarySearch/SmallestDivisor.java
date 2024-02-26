package BinarySearch;

public class SmallestDivisor {
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

    public static int checkDivisor(int[] arr, int mid){
        int sum=0;
        for(int i:arr){
            sum+=Math.ceil((double)i/mid);
        }
        return sum;
    }
    public static int smallestDivisor(int arr[], int limit) {
        int low = findMinElement(arr);
        int high = findMaxElement(arr);
        int ans = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(checkDivisor(arr, mid)<=limit){
                ans = mid;
                high = mid-1;
            } else{
                low = mid +1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{8, 4, 2, 3};
        int limit = 10;
        int smallestDivisor = smallestDivisor(arr,limit);
        System.out.println("Smallest Divisor : "+smallestDivisor);
    }
}
