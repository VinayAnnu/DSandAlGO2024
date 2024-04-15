package Recursion;

public class CheckPalindrome {
    public static boolean checkPalindrome(int i, String s,int n){
        if(i>=n/2) return true;
        if(s.charAt(i) != s.charAt(n-i-1))return false;
        return checkPalindrome(i+1,s,n);
    }

    public static void main(String[] args) {
        boolean res1 = checkPalindrome(0,"MADAM",5);
        System.out.println("MADAM is palindrome : "+res1);

        boolean res2 = checkPalindrome(0,"ADAM",4);
        System.out.println("ADAM is palindrome : "+res2);
    }
}
