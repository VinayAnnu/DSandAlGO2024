package arrays;

public class RotateMatrix90DegreeClockwise {
    public static void rotateMatrix(int [][]mat){
        // step-1- Transpose the matrix
        // step-2- reverse each row of the matrix
        int n= mat.length;
        int m=mat[0].length;
        //transpose
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<m;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        //reverse each row
        for(int i=0;i<n;i++){
            reverseArr(mat[i],m);
        }
    }
    public static void reverseArr(int[] arr,int m){
        int start=0,end=m-1;
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;end--;
        }
    }
    static void printMatrix(int arr[][])
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print( arr[i][j] + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        rotateMatrix(arr);
        printMatrix(arr);
    }
}
