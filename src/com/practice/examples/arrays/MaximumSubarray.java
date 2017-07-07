package com.practice.examples.arrays;

/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

Time Complexity: O(N)

Solution: kadanes-algorithm
 */

public class MaximumSubarray {
     /*
    Algorithm explanation:
    While iterating the array, keep a note of the maximum sum.
    If the sum goes below O update the current sum to 0
    If the currentSum value is greater that the maxSum value found so foar update the value.
    Return the maximum value once the iteration is complete.
     */

    public int findMaximumSum(int[] arr) {
        if(arr == null || arr.length == 0)
            return 0;
        int maxCurrentSum = 0;
        int maxSoFar = 0;

        for(int i=0;i<arr.length;i++) {
            maxCurrentSum += arr[i];
            if(maxCurrentSum < 0)
                maxCurrentSum = 0;
            if(maxCurrentSum > maxSoFar)
                maxSoFar = maxCurrentSum;
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr ={-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int res= maximumSubarray.findMaximumSum(arr);
        System.out.println(res);
    }

}
