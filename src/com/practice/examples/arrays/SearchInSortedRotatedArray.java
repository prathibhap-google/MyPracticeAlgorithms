package com.practice.examples.arrays;

/*
Given a rotated array and an element k , search the element in the given array
Input:  {4, 5, 6, 7, 1, 2, 3} Key: 2
Output:  5

Time Complexity: O(N)
*/

public class SearchInSortedRotatedArray {

   /*
    Algorithm explanation: (Use Binary Search to solve this problem)
    1. Since the array is sorted, find the middle element.
    2. If the middle element is the key return the mid index.
    3. Check for the portion of the array which is sorted.
    4. If the key falls in between the start and mid element. search in the left half else search in the right half.
    5. Do the same steps until the element is found or the entire array is iterated.
     */
    public int findElementInRotatedArray(int[] arr, int key, int startIndex, int endIndex) {
        if(startIndex > endIndex)
            return -1;

        int mid = (startIndex + endIndex) / 2;
        if(arr[mid] == key)
            return mid;
        if(arr[mid] >= arr[0]) { // left half is sorted
            if (arr[mid] >= key  && arr[startIndex] <= key) {
                return findElementInRotatedArray(arr, key, startIndex, mid - 1);
            }
            return findElementInRotatedArray(arr, key, mid + 1, endIndex);

        } else { //right half is sorted
            if (arr[mid] <=  key && arr[endIndex] >= key) {
                return findElementInRotatedArray(arr, key, mid + 1, endIndex);
            }
            return findElementInRotatedArray(arr, key, startIndex, mid - 1);
        }
    }

    public static void main(String[] args) {
         int[] arr = {4, 5, 6, 7, 1, 2, 3};
         SearchInSortedRotatedArray sArray =  new SearchInSortedRotatedArray();
         int resultIndex = sArray.findElementInRotatedArray(arr, 2, 0, arr.length-1);
         System.out.println("The value is available at index: " + resultIndex);
    }
}
