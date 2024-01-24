public class MaxSubarraySumKadaneAlgo {
    public static long maxSubarraySum(int[] arr, int n) {
        // write your code here//kadane algorithm
        long sum=0;long max=Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum>max){
                max=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }

    public static int[] findMaxSubarraySum(int[] arr, int n) {
        int startIndex=-1,endIndex=-1;
        // write your code here
        long sum=0;long max=Long.MIN_VALUE;
        int start=-1;
        for(int i=0;i<n;i++){
            if(sum==0){
                start=i;
            }
            sum+=arr[i];
            if(sum>max){
                max=sum;
                startIndex=start;
                endIndex=i;
            }
            if(sum<0){
                sum=0;
            }
        }
        return new int[]{startIndex,endIndex};
    }
    public static void main(String[] args) {
        long sum = maxSubarraySum(new int[]{1, 2, 7, -4, 3, 2, -10, 9, 1},9);
        System.out.println(sum);
        int[] arr = findMaxSubarraySum(new int[]{1, 2, 7, -4, 3, 2, -10, 9, 1},9);
        System.out.println(arr[0]+" "+arr[1]);
    }
}
