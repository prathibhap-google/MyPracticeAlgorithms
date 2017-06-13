package com.practice.examples.arrays;

public class FindKthSmallestElement {

    public int getKthSmallestElement(int[] arr, int k) {
        if (arr == null || arr.length ==0 || arr.length < k-1)
            return -1;
        return getSortedArray(arr, k-1, 0, arr.length-1);
    }

    public int getSortedArray(int[] arr, int k, int start, int end) {
        int index = getPivotedArray(arr, start, end);
        if (index == k)
            return arr[k];
        else if(k < index)
            return getSortedArray(arr, k, start, index);
        else if(k > index)
            return getSortedArray(arr, k, index+1, end);

        return -1;
    }

    private int getPivotedArray(int[] arr, int left, int right) {
        int pivot = (left + right) / 2;

        while (left <= right) {

            while(arr[left] <= arr[pivot])
                left++;

            while(arr[right] > arr[pivot])
                right--;

            if(left < right) {
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
        int[] arr = {1, 5, 8, 2, 6, 9, 3};
        FindKthSmallestElement fElement = new FindKthSmallestElement();
        int result = fElement.getKthSmallestElement(arr, 3);
        System.out.println("Smallest element: "+ result);
    }
}
