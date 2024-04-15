package Recursion;

public class PrintNto1UsingBacktracking {
    public static void printNto1UsingBacktracking(int i, int n){
        if(i>n)return;
        printNto1UsingBacktracking(i+1,n);
        System.out.println(i);
    }

    public static void main(String[] args) {
        printNto1UsingBacktracking(1,5); // op should be -  5,4,3,2,1
    }
}
