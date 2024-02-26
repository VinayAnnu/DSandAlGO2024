package BinarySearch;

public class FindSquareRootOfNumber {
    public static int sqrtN(long N) {
        long low = 0, high = N;
        long ans=-1;
        while (low<=high){
            long mid = low + (high-low)/2;
            if(mid*mid <= N){
                ans = mid;
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        long n = 17;
        int ans = sqrtN(n);
        System.out.println("Square root of Number "+n+" : "+ans);
    }
}
