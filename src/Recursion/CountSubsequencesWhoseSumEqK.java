package Recursion;

public class CountSubsequencesWhoseSumEqK {
    private static int countSubsequenceSumEqualK(int[] arr,int index, int k, int sum) {
        if(index>=arr.length){
            if(sum == k){
                return 1;
            }
            return 0;
        }
//        sum+=arr[index];
//        int l = countSubsequenceSumEqualK(arr,index+1,k,sum);
//        sum-=arr[index];
//        int r = countSubsequenceSumEqualK(arr,index+1,k,sum);
//        return l+r;

        return countSubsequenceSumEqualK(arr,index+1,k,sum+arr[index]) + countSubsequenceSumEqualK(arr,index+1,k,sum);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,3};
        int k = 4;
        int count = countSubsequenceSumEqualK(arr,0,k,0);
        System.out.println("Count : "+count);

    }
}
