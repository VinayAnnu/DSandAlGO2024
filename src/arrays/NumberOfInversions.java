package arrays;

public class NumberOfInversions {
    public static int numberOfInversions(int []a, int n) {
        //5, 3, 2, 1, 4
        return mergeSort(a,0,n-1);
    }
    public static int merge(int[] arr, int start, int mid, int end){
        int[] tempArr = new int[end-start+1];
        int count=0;
        int index=0;
        int i=start,j=mid+1;
        while(i<=mid && j<=end){
            if(arr[i]>arr[j]){
                count+=(mid-i+1);
                tempArr[index]=arr[j];
                j++;index++;
            } else {
                tempArr[index]=arr[i];
                i++;index++;
            }
        }

        while(i<=mid){
            tempArr[index]=arr[i];
            i++;index++;
        }
        while(j<=end){
            tempArr[index]=arr[j];
            j++;index++;
        }
        for(int k=0;k<index;k++){
            arr[start]=tempArr[k];
            start++;
        }
        return count;
    }
    public static int mergeSort(int[] arr, int start, int end){
        if(start<end){
            int mid = start + (end-start)/2;
            return mergeSort(arr, start, mid)+mergeSort(arr,mid+1,end)+merge(arr,start,mid,end);
        } else{
            return 0;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 1, 4};
        int count = numberOfInversions(arr,5);
        for(int x:arr){
            System.out.println(x);
        }
        System.out.println("count "+count);
    }
}
