package arrays;

public class FindMissingAndRepeatingNumbers {
    public static int[] findMissingRepeatingNumbers(int []a) {
        int n = a.length;
        long sum =0, squareSum = 0;
        int sn = (n*(n+1))/2;
        int sn2 = (n*(n+1)*(2*n+1))/6;
        for(int i=0;i<n;i++){
            sum+=a[i];
            squareSum+=a[i]*a[i];
        }
        long xMinusY = sum-sn;
        long xSquareMinusYsquare = squareSum-sn2;
        long xPlusY = xSquareMinusYsquare/xMinusY;
        long x = (xMinusY+xPlusY)/2;  //repeating number
        long y = x - xMinusY; //missing number
        return new int[]{(int)x,(int)y};
    }

    public static void main(String[] args) {
        int[] missingAndRepeating = findMissingRepeatingNumbers(new int[]{1, 2, 3, 2});
        System.out.println("Missing number "+ missingAndRepeating[1]);
        System.out.println("Repeating number "+ missingAndRepeating[0]);
    }
}
