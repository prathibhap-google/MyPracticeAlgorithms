package com.practice.examples.search;

/*
Given a array and a target element, find the given target in the array

Input: {1, 8, 22, 3, 9, 30, 15, 5, 10} , target : 5
Output: 7

Time Complexity: O(N)
*/

public class LinearSearch {

    public int searchTarget(int[] num, int target) {
        if (num == null || num.length == 0)
            return -1;

        for(int i=0; i< num.length; i++) {
            if(num[i] == target)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] num = {1, 8, 22, 3, 9, 30, 15, 5, 10};
        LinearSearch linearSearch = new LinearSearch();
        int index = linearSearch.searchTarget(num , 5);
        if(index != -1)
            System.out.println("The element is at index " + index);
        else
            System.out.println("The element is not available in the given array");
    }
}
