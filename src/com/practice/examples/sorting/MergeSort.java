package com.practice.examples.sorting;
/*
Given an array of positive integers, sort the given array
Input:  {1, 4, 7, 9, 3, 2, 5}
Output:  {1, 2, 3, 4, 5, 7, 9}

Time Complexity: O(N logN)
*/

public class MergeSort {

    public void mergeSort(int[] arr) {
        int[] tempArray = new int[arr.length];
        mergeSortUtil(arr, tempArray, 0, arr.length-1);
    }

    private void mergeSortUtil(int[] arr, int[] tempArray, int left, int right) {
        if(left < right) {
            int mid = (left + right)/2;
            // sort left half of the array
            mergeSortUtil(arr, tempArray, left, mid);
            // sort right half of the array
            mergeSortUtil(arr, tempArray, mid+1, right);
            //merge both half
            mergeUtil(arr, tempArray, left, mid, right);
        }
    }

    private void mergeUtil(int[] arr, int[] tempArray, int left, int mid, int right) {
        //copy the values to tempArray
        for(int i=left;i<=right;i++) {
            tempArray[i] = arr[i];
        }

        //start comparing two array from start position
        int array1Start = left;
        int array2Start = mid + 1;
        int currentPos = left;

        while(array1Start <= mid  && array2Start <= right) {
            //compare left half and right and add the values back to the target array in sorted form.
            if(tempArray[array1Start] <= tempArray[array2Start]) {
                arr[currentPos] = tempArray[array1Start];
                array1Start ++; currentPos++;
            } else {
                arr[currentPos] = tempArray[array2Start];
                array2Start++; currentPos++;
            }
        }

        //if there are any elements remaining in left half of temp add it to the array.
        //We need not add right halsf as they will be already available.

        int remaining = mid - array1Start;
        for(int i=0; i<= remaining;i++) {
            arr[currentPos + i] = tempArray[array1Start + i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3, 2, 9};
        MergeSort mSort = new MergeSort();
        mSort.mergeSort(arr);

        for(int i=0; i< arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
