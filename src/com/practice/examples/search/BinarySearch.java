package com.practice.examples.search;

/*
Given a sorted array and a target element, find the given target in the array

Input: {1, 3, 5, 8, 9, 10, 15, 22, 30} , target : 5
Output: 2

Time Complexity: O(logN)
*/

public class BinarySearch {
    /*
    Algorithm explanation:
    1. Find the median of an array.i.e mid element.
    2. If the middle element is the target. return mid index.
    3. If middle element is greater than the target check left half of the array
    4. If the middle element is smaller than the target check right half of the array
    */

    public int findTargetElementInArray(int[] arr, int target) {
        if(arr == null || arr.length == 0)
            return -1;
        int start_position = 0;
        int end_position = arr.length -1;
        while( start_position <= end_position) {
            int mid = (start_position + end_position) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start_position = mid + 1;
            } else {
                end_position = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {1, 3, 5, 8, 9, 10, 15, 22, 30};
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.findTargetElementInArray(arr, 5);
        if(result == -1) {
            System.out.println("The target element is not available in the given array");
        } else {
            System.out.println("The target element is available at index:" + result);
        }

    }
}
