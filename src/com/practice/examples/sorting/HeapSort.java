package com.practice.examples.sorting;


public class HeapSort {

    private int heapSize;
    private int currentSize;

    public void sort(int[] num) {
        this.heapSize = num.length;
        this.currentSize = heapSize;
        buildHeap(num);
        printHeap(num);
    }

    private void buildHeap(int[] num) {
        int n = num.length;
        for(int i = n/2-1; i >= 0; i--)
            heapify(i, num);
    }

    int getLeftChild(int i) {
        return 2*i + 1;
    }

    int getRightChild(int i) {
        return 2*i + 2;
    }

    private void heapify(int index, int[] num) {

        int l = getLeftChild(index);
        int r = getRightChild(index);
        int largest = index;

        if(l < currentSize && num[l] > num[largest])
            largest = l;
        if(r < currentSize && num[r] > num[largest])
            largest = r;

        if(largest != index) {
            int temp = num[index];
            num[index] = num[largest];
            num[largest] = temp;
            heapify(largest, num);
        }
    }

    private void printHeap(int[] num) {
        System.out.println("Max heap that is built:");
        for(int i=0;i<currentSize;i++)
            System.out.print(num[i] + " ");
        System.out.println();
    }

    private int extractMax(int[] num) {
        if(currentSize <= 0) {
            System.out.println("Heap is empty");
            return Integer.MIN_VALUE;
        }
        if(currentSize == 1) {
            currentSize--;
            return num[0];
        }

        int root = num[0];
        num[0] = num[currentSize-1];
        currentSize--;
        heapify(0, num);

        return root;
    }


    public static void main(String[] args) {
        int[] arr= {10, 5, 2, 20, 15, 6};

        HeapSort hs = new HeapSort();
        hs.sort(arr);

        System.out.println("Printing the Top 3 elements in array:");
        System.out.println(hs.extractMax(arr));
        System.out.println(hs.extractMax(arr));
        System.out.println(hs.extractMax(arr));

    }
}
