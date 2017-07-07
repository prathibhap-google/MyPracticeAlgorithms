package com.practice.examples.arrays;

/*
Given a sorted array and a value n, find the missing number form 1 to n.

Input: {1, 2, 5, 6, 3, 7, 8} , n : 8
Output: 4

Time Complexity: O(N)
*/

public class FindMissingNumber {

    /*
   Algorithm explanation:
   1. XOR all values from 1 to n -> save as res
   2. XOR all values in given array with res.
   3. Return res
   */
    public int findNumberUsingXOR(int[] arr, int n) {
        if(arr == null || arr.length == 0) {
            return -1;
        } else {
            int res = 0;
            for(int i=0;i< arr.length;i++) {
                res = res ^ arr[i];
            }
            for(int i=1;i<=n;i++) {
                res = res ^ i;
            }
            return res;
        }
    }

    /*
   Algorithm explanation:
   1. To find the sum of number from 1 to n apply formula n(n+1)/2 -> save as res
   2. Find sum of all values in array -> save as sum
   3. Return res - sum
   */
    public int findNumber(int[] arr, int n) {
        if(arr == null || arr.length == 0)
            return -1;
        int res = n*(n+1)/2;
        int sum = 0;
        for(int i=0;i<n-1;i++) {
            sum += arr[i];
        }
        return res-sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 3, 7, 8};
        FindMissingNumber fm = new FindMissingNumber();
        int res1 = fm.findNumber(arr, 8);
        System.out.println("Missing MNumber: " + res1);

        int res2 = fm.findNumberUsingXOR(arr, 8);
        System.out.println("Missing MNumber using xor: " + res2);
    }
}
