package BinarySearch;

public class FindNthRootOfM {
    //return 1 if power == m
    //return 2 if power > m
    //return 0 if power < m
    public static int powerOfNumber(int mid, int n, int m) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= mid;
            if(res>m){
                return 2;
            }
        }
        if(res==m){
            return 1;
        }
        return 0;
    }

    public static int NthRoot(int n, int m) {
        int low = 0, high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int p = powerOfNumber(mid, n, m);
            if (p == 1) {
                return mid;
            } else if (p == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3, m = 27;
        int ans = NthRoot(n, m);
        System.out.println("Nth root of M " + ans);
    }
}
