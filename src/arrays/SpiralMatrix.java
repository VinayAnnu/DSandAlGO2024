package arrays;

public class SpiralMatrix {
    public static int[] spiralMatrix(int [][]MATRIX) {
        // Write your code here.
        int n= MATRIX.length, m= MATRIX[0].length,index=0;
        int[] result= new int[n*m];
        int top=0,bottom=MATRIX.length-1,left=0,right=MATRIX[0].length-1;
        while (top<=bottom && left<=right){
            for(int i=left; i<=right;i++){
                result[index]=MATRIX[top][i];
                index++;
            }
            top++;
            for(int i=top;i<=bottom;i++){
                result[index]=MATRIX[i][right];
                index++;
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    result[index]=MATRIX[bottom][i];
                    index++;
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    result[index]=MATRIX[i][left];
                    index++;
                }
                left++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        int[] res = spiralMatrix(arr);
        for(int x:res){
            System.out.print(x+ " ");
        }
    }
}
