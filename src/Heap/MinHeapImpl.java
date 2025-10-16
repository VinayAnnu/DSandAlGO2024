package Heap;

import java.util.Arrays;

public class MinHeapImpl {
    int[] heap;
    int size;

    public void initializeHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void siftUp(int idx) {
        while (idx > 0) {
            int parentIndex = (idx - 1) / 2;
            if (heap[parentIndex] <= heap[idx]) break;
            swap(idx, parentIndex);
            idx = parentIndex;
        }
    }

    public void siftDown(int idx) {
        int left = idx * 2 + 1;
        int right = left + 1;
        int smallest = idx;
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest != idx) {
            swap(idx, smallest);
            siftDown(smallest);
        }
    }

    public void insert(int key) {
        if (size == heap.length) throw new RuntimeException("full");
        heap[size] = key;
        size++;
        siftUp(size - 1);
    }

    public void changeKey(int index, int newVal) {
        int oldVal = heap[index];
        heap[index] = newVal;
        if (newVal < oldVal) {
            siftUp(index);
        } else {
            siftDown(index);
        }
    }

    public int extractMin() {
        if (size == 0) throw new RuntimeException("empty");
        int root = heap[0];
        heap[0] = heap[--size];
        siftDown(0);
        return root;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getMin() {
        if (size == 0) throw new RuntimeException("empty");
        return heap[0];
    }

    public int heapSize() {
        return size;
    }

    public static void main(String[] args) {
        MinHeapImpl heap = new MinHeapImpl();
        heap.initializeHeap(10);

        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);

        System.out.println(heap.getMin()); // 1
        System.out.println(heap.heapSize());//4
        System.out.println(heap.extractMin()); // 1
        System.out.println(heap.heapSize());//3
        System.out.println(heap.getMin()); // 3
        System.out.println("----");
        for(int i=0;i<heap.heapSize();i++){
            System.out.print(heap.heap[i]+" ");
        }
        System.out.println();
        System.out.println("----");
        heap.changeKey(1, 0);
        System.out.println("after key change----");
        for(int i=0;i<heap.heapSize();i++){
            System.out.print(heap.heap[i]+" ");
        }
        System.out.println();
        System.out.println(heap.getMin()); // 0
    }
}
