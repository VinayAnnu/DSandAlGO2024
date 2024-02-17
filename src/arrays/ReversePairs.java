package arrays;

public class ReversePairs {
    public static int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
    public static int merge(int[] arr, int start, int mid, int end){
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
        return 0;
    }
    public static int countPairs(int[] arr, int start, int mid, int end){
        int j=mid+1; int count=0;
        for(int i=start; i<=mid; i++){
            while ( j<=end && arr[i] > 2*arr[j]){
                j++;
            }
            count+=j-(mid+1);
        }
        return count;
    }
    public static int mergeSort(int[] arr, int start, int end){
        if(start<end){
            int mid = start + (end-start)/2;
            return mergeSort(arr, start, mid) + mergeSort(arr,mid+1,end)+countPairs(arr,start,mid,end)+merge(arr,start,mid,end);
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 3, 1};
        int count = reversePairs(arr);
        for(int x:arr){
            System.out.println(x);
        }
        System.out.println("count "+count);
    }
}
