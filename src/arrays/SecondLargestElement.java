package arrays;

public class SecondLargestElement {
    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.
        int small=a[0];
        int secondSmall=Integer.MAX_VALUE;
        int large=a[0];
        int secondLarge=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            if(a[i]>large){
                secondLarge=large;
                large=a[i];
            } else if (a[i]>secondLarge) {
                secondLarge=a[i];
            }
            if(a[i]<small){
                secondSmall=small;
                small=a[i];
            } else if(a[i]<secondSmall){
                secondSmall=a[i];
            }
        }

        return new int[]{secondLarge,secondSmall};


    }

    public static void main(String[] args) {
        int n=10;
        int[] a= new int[]{1,2,3,4,5,6,7,8,9,10};

        int[] arr = getSecondOrderElements(n,a);
        System.out.println(arr[0]+" "+arr[1]);
    }
}
