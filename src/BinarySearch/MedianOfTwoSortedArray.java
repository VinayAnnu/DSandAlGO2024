package BinarySearch;

public class MedianOfTwoSortedArray {
//    public static double median(int[] a, int[] b) {  //without taking extra third array to find median-- space optimization
//        int n1 = a.length;
//        int n2 = b.length;
//        int rIndex = (n1 + n2) / 2;  //1,2,3,4,5,6 here rIndex will be on element 4 and lIndex will be on element 3
//        int lIndex = rIndex - 1;
//        int ele1 = -1, ele2 = -1;
//        int i = 0, j = 0, count = 0;
//        while (i < n1 && j < n2) {
//            if (a[i] <= b[j]) {
//                if (count == lIndex) ele1 = a[i];
//                if (count == rIndex) ele2 = a[i];
//                i++;
//            } else {
//                if (count == lIndex) ele1 = b[j];
//                if (count == rIndex) ele2 = b[j];
//                j++;
//            }
//            count++;
//        }
//
//        while (i < n1) {
//            if (count == lIndex) ele1 = a[i];
//            if (count == rIndex) ele2 = a[i];
//            count++;
//            i++;
//        }
//
//        while (j < n2) {
//            if (count == lIndex) ele1 = b[j];
//            if (count == rIndex) ele2 = b[j];
//            count++;
//            j++;
//        }
//        System.out.println("element1 " + ele1 + " element2 " + ele2);
//        if ((n1 + n2) % 2 == 0) {
//            return (double) (ele1 + ele2) / 2;
//        }
//        return (double) ele2;
//    }

    public static double median(int[] a, int[] b) {  //using binary search only
        int n1 = a.length;
        int n2 = b.length;
        int n = n1+n2;
        if(n1>n2){
            return median(b, a);// always choosing shorter array to minimize TC. no of elemets from other array will get with help of shorter array only
        }
        int low = 0; //number of elements choosing before index 0 that is none from first array
        int high = n1; // number of elements choosing before index n1 that is all from first array

        int left = (n1+n2+1)/2; //no of elements kept in left side.
        while(low<=high){
            int mid1 = low + (high-low)/2; //mid1 index in 1st array
            int mid2 = left - mid1; //mid2 index in 2nd array
            int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
            if(mid1<n1) {
                r1 = a[mid1];
            }
            if(mid2<n2) {
                r2 = b[mid2];
            }
            if(mid1-1>=0) l1 = a[mid1-1];
            if(mid2-1>=0) l2 = b[mid2-1];
            if(l1<=r2 && l2<=r1){
                if(n%2==1){
                    return Math.max(l1,l2);
                }
                return (double) (Math.max(l1,l2)+Math.min(r1,r2))/2;
            }
            else if(l1>r2){
                high = mid1-1;
            } else{
                low = mid1+1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 4, 6};
        int[] b = new int[]{1, 3, 5};
        //1,2,3,4,5,6--median=3.5
        double medianVal = median(a, b);
        System.out.println("median val : " + medianVal);
    }
}
