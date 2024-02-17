package arrays;

public class MaxProductSubarray {
    public static int subarrayWithMaxProduct(int []arr){
        int n = arr.length;
        int maxProd= Integer.MIN_VALUE;
        int prefix=1,suffix=1;
        for(int i=0;i<arr.length;i++){
            if(prefix==0){
                prefix=1;
            }
            if(suffix==0){
                suffix=1;
            }
            prefix*=arr[i];
            suffix*=arr[n-i-1];
            maxProd= Math.max(maxProd, Math.max(prefix,suffix));
        }
        return maxProd;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 3, -4, 0};
        int maxProduct = subarrayWithMaxProduct(arr);
        System.out.println(maxProduct);
    }
}
