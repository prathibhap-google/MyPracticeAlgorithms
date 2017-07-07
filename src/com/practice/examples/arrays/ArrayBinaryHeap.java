package com.practice.examples.arrays;

/*
Given an array, check if it satisfies Binary Max Heap property.

Input: {17, 15, 10, 6, 10, 7}
Output: true

Input: {6, 7, 12, 10, 15, 17}
Output: false

Time Complexity: O(N)
*/

public class ArrayBinaryHeap {

    /*
    Algorithm explanation:
    1. To satisfy the binary heap property the value at the root must be greater than the left and the right subtree.
    2. In the given array 2*i+1 gives the left child and 2*i+2 gives the right child. Check the position till arr.len <= (n-2)/2.
    Rest will be leaf nodes for a complete binary tree. So we can safely skip it.
   */
    public boolean isBinaryMaxHeap(int[] arr) {
        if(arr == null || arr.length == 0)
            return true;

        for(int i=0; i<= (arr.length-2)/2; i++) {
            if(arr[i] < getLeftChild(arr, i))
                return false;
            if(getRightChild(arr,i) != -1 && arr[i] < getRightChild(arr,i))
                return false;
        }
        return true;
    }

    public int getLeftChild(int[] arr, int i) {
        return arr[2*i+1];
    }

    public int getRightChild(int[] arr, int i) {
        if(arr.length <= 2*i+2)
            return -1;
        return arr[2*i+2];
    }
    public static void main(String[] args) {
        int[] arr1 = {17, 15, 10, 6, 10, 7};
        int[] arr = {6, 7, 12, 10, 15, 17};
        ArrayBinaryHeap binHeap = new ArrayBinaryHeap();
        boolean res = binHeap.isBinaryMaxHeap(arr1);
        System.out.println(" Binary Max Heap:" + res);
    }
}
