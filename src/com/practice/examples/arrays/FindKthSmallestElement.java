package com.practice.examples.arrays;

public class FindKthSmallestElement {

    public int getKthSmallestElement(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k >= arr.length)
            return -1;
        return getSortedArray(arr, k);
    }

    public int getSortedArray(int[] arr, int k) {

        int start = 0, end = arr.length - 1, index = k;
        while (start < end) {
            int pivot = getPivotedArray(arr, start, end);
            if (pivot < index) start = pivot + 1;
            else if (pivot > index) end = pivot - 1;
            else return arr[pivot];
        }
        return arr[start];
    }

    private int getPivotedArray(int[] arr, int left, int right) {
        int pivot = left;
        int temp;

        while (left <= right) {

            while(left <= right && arr[left] <= arr[pivot])
                left++;

            while(left <= right && arr[right] > arr[pivot])
                right--;

            if(left < right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        temp = arr[right];
        arr[right] = arr[pivot];
        arr[pivot] = temp;

        return right;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 2, 5, 7, 3};
        FindKthSmallestElement fElement = new FindKthSmallestElement();
        int result = fElement.getKthSmallestElement(arr, 6);
        System.out.println("Smallest element: "+ result);
    }
}
