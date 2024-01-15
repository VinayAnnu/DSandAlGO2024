public class QuickSort {
    public static int partioning(int[] input,int startIndex, int endIndex){
        int pivot=input[endIndex];
        int i=startIndex-1;
        for(int j=startIndex;j<endIndex;j++){
            if(input[j]<=pivot){
                i=i+1;
                int temp=input[i];
                input[i]=input[j];
                input[j]=temp;
            }
        }
        int x= input[i+1];
        input[i+1]=pivot;
        input[endIndex]=x;
        return i+1;
    }
    public static void quickSort(int[] input,int startIndex, int endIndex) {

        if(startIndex<endIndex){
            int partition = partioning(input,startIndex,endIndex);
            quickSort(input,startIndex, partition-1);
            quickSort(input,partition+1, endIndex);
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{9,3,6,2,0};
        quickSort(arr,0,4);
        //insertionSort(arr,5);
        for(int x:arr){
            System.out.println(x);
        }

    }
}
