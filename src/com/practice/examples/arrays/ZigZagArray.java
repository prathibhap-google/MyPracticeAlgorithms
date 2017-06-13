package com.practice.examples.arrays;

/*
Given an array, rearrange the array in zigzag fashion (a < b > c < d > e < f)
Input:  {1, 2, 3, 4, 5, 6, 7}
Output:  1 3 2 5 4 7 6

Time Complexity: O(N)
*/

public class ZigZagArray {

    public int[] formZigZagArray(int[] arr) {
        if(arr ==null || arr.length ==0)
            return arr;
        int i=0;
        boolean inverseFlag = true;

        while(i < arr.length - 1) {
            if(inverseFlag) {
                if(arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            } else {
                if(arr[i] < arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            inverseFlag = !inverseFlag;
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ZigZagArray zArray = new ZigZagArray();
        int[] resultArray = zArray.formZigZagArray(arr);
        for(int res=0; res< resultArray.length; res++) {
            System.out.print(resultArray[res] + " ");
        }
    }
}
