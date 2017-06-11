package com.practice.examples.arrays;

/*
Given an array and an element k , rotate the given array k times
Input:  {1, 2, 3, 4, 5, 6, 7} Key: 3
Output:  4 5 6 7 1 2 3

Time Complexity: O(N^2)
*/

public class RotateArrayKTimes {

   /*
    Algorithm explanation: (1, 2, 3, 4, 5, 6, 7) k = 3
    1. Rotate the array from 0 to Kth index. -> (3, 2, 1, 4, 5, 6, 7)
    2. Rotate array from k+1 to arr.length -> (3, 2, 1, 7, 6, 5, 4)
    3. Rotate the entire array. -> (4, 5, 6, 7, 1, 2, 3)
     */

    public int[] rotateArray(int[] arr, int k) {
        if (k == 0)
            return arr;
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length-1);
        reverse(arr, 0, arr.length-1);

        return arr;
    }

    private void reverse(int[] arr, int startIndex, int endIndex) {
        while (startIndex <= endIndex) {
            int temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        RotateArrayKTimes rArray = new RotateArrayKTimes();
        rArray.rotateArray(arr, 3);

        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
