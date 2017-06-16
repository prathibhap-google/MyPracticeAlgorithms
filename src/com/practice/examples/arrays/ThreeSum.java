package com.practice.examples.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of positive integers S and a target sum,
 there are elements a, b, c in S such that a + b + c = target?
 Find all unique triplets in the array which gives the sum of target.

Input:  {1, 2, 5 ,7, 4 , 3}, target: 8
Output:  [1,2,5] and [1, 3, 4]

Time Complexity: O(N^2)
*/

public class ThreeSum {

    public List<List<Integer>> findTripleSum(int[] arr, int key) {
        if(arr == null || arr.length == 0)
            return null;
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int j =0;
        int k=0;

        for(int i=0;i < arr.length-2;i++) {
            //handles duplicate sets
            if (i >0 && arr[i] == arr[i-1]) continue;
            int target = key-arr[i];
            j = i + 1;
            k = arr.length -1;

            while( j < k ) {
                if (arr[j] + arr[k] == target) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(arr[i]);
                    tempList.add(arr[j]);
                    tempList.add(arr[k]);
                    result.add(tempList);
                    j++;
                    k--;
                    //handles duplicate sets
                    while (j < arr.length && arr[j] == arr[j - 1])
                        j++;
                    while (k < arr.length && arr[k] == arr[k + 1])
                        k--;
                } else if (arr[j] + arr[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr ={ 1, 2, 5 ,7, 4 , 3};
        ThreeSum tSum = new ThreeSum();
        List<List<Integer>> resultArray = tSum.findTripleSum(arr, 8);
        if(resultArray != null) {
            for(List<Integer> res: resultArray){
                for(int val: res) {
                    System.out.print(val + " ");
                }
                System.out.println("");
            }
        }
    }
}
