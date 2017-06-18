package com.practice.examples.sorting;
/*
Given an array of positive integers, sort the given array
Input:  {1, 4, 7, 9, 3, 2, 5}
Output:  {1, 2, 3, 4, 5, 7, 9}

Time Complexity: O(N logN) average case, worst case O(N^2)
*/

public class QuickSort {
    
    public void quickSort(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        quickSortUtil(arr, left, right);
    }

    private void quickSortUtil(int[] arr, int left, int right) {
            int index = partition(arr, left, right);
            //sort left half
            if (left < index - 1)
                quickSortUtil(arr, left, index - 1);
            //sort right half
            if (index < right)
                quickSortUtil(arr, index, right);

    }

    private int partition(int[] arr, int left, int right) {

        //Pick middle element as pivot
        int pivot = arr[left + (right - left) / 2];

        //Find element in left that is greater than pivot
        //Find element in right that is less than pivot
        //Swap these two elements.
        while(left <= right) {
            while(arr[left] < pivot)
                left++;

            while(arr[right] > pivot)
                right--;

            if(left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 3, 8, 2};
        QuickSort qSort = new QuickSort();
        qSort.quickSort(arr);

        for(int i=0; i< arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}
