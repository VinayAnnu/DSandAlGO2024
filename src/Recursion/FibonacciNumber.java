package Recursion;

public class FibonacciNumber {
    public static int NthFibonacciNumber(int n){  //TC-2^n
        if(n==0)return 0;
        if(n==1)return 1;
        return NthFibonacciNumber(n-1)+NthFibonacciNumber(n-2);//2
    }

    public static void main(String[] args) {
        int nthFibNo = NthFibonacciNumber(10); //0 1 1 2 3 5 8 13 21 34 55 //10th fib no will be 55
        System.out.println("nthFibNo "+nthFibNo);
    }
}
