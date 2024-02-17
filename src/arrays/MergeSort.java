package arrays;

public class MergeSort {
    public static void merge(int[] arr, int start, int mid, int end){
        int[] tempArr = new int[end-start+1];
        int index=0;
        int i=start,j=mid+1;
        while(i<=mid && j<=end){
            if(arr[i]>arr[j]){
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
    }
    public static void mergeSort(int[] arr, int start, int end){
        if(start<end){
            int mid = start + (end-start)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{9,3,6,2,0};
        mergeSort(arr,0,4);
        for(int x:arr){
            System.out.println(x);
        }
    }
}
