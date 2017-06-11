package com.practice.examples.arrays;

/*
Given a positive sorted array and an element, search an element in the given array.
Input:  {1, 4, 6, 8, 10, 15, 22, 30} Key: 22
Output:  6

Input: {1, 4, 6, 8, 10, 15, 22, 30} Key: 24
Output:  -1

Time Complexity: O(logN)
Space complexity : O(1)

Solution: Using Binary Search
*/

public class SearchInSortedArray {

      /*
        Algorithm explanation: (Use Binary Search to solve this problem)
        1. Since the array is sorted, find the middle element.
        2. If the middle element is the key return the mid index.
        3. If the middle element is greater than the key search in the left half of the array
        4. Else search in the right half of the array.
        5. Do the same steps until the element is found or the search is complete.
         */

    public int findElement(int[] arr, int key) {
        if (arr == null || arr.length == 0)
            return -1;

        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {
            int mid = (i + j)/2;
            if(arr[mid] == key) {
                return mid;
            } else if(arr[mid] > key) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 10, 15, 22, 30};
        SearchInSortedArray searchElement = new SearchInSortedArray();
        int resultIndex = searchElement.findElement(arr, 22);
        if (resultIndex != -1)
            System.out.println("The element is found at index: " + resultIndex);
        else
            System.out.println("The element is not available in the array.");
    }
}
