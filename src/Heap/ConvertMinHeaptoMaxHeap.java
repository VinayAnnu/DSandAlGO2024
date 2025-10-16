package Heap;

import java.util.Arrays;

public class ConvertMinHeaptoMaxHeap {
    static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    static void heapifyDown(int i,int[] nums,int n){
        int left = 2*i+1;
        int right = left+1;
        int largest = i;
        if(left<n && nums[left]>nums[largest]){
            largest=left;
        }
        if(right<n && nums[right]>nums[largest]){
            largest=right;
        }
        if(largest!=i){
            swap(i,largest,nums);
            heapifyDown(largest,nums,n);
        }
    }
    static void convertMinToMaxHeap(int N, int nums[]) {
        // Start from last internal node and heapify down
        for(int i=N/2-1;i>=0;i--){
            heapifyDown(i,nums,N);
        }
    }

    public static void main(String[] args) {
        int n=4;
        int[] nums = {1, 2, 3, 4};
        convertMinToMaxHeap(n, nums);
        System.out.println("Max heap array:-");
        Arrays.stream(nums).forEach(x-> System.out.println(x));
    }
}
