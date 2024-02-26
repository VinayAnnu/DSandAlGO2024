package BinarySearch;

public class SearchElementInRotatedSortedArrayHavingDuplicateElement {
    public static boolean searchInARotatedSortedArrayII(int []A, int key) {
        int low = 0,high=A.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == key) {
                return true;
            }
            if(A[low] == A[mid] && A[mid] == A[high]){ //shrink the search space
                low=low+1;
                high = high-1;
                continue;
            }
            //left half sorted
            if (A[low] <= A[mid]) {
                if (A[low] <= key && key <= A[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { ///right half sorted
                if (A[mid] <= key && key <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,0,0,1,2};
        int x = 4;
        boolean res = searchInARotatedSortedArrayII(arr,x);
        System.out.println("Is element found : "+res);
    }
}
