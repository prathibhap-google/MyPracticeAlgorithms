package com.practice.examples.arrays;

/*
Given an array of stocks, if you were only permitted to complete at most one transaction
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Input:  {7, 1, 5, 3, 6, 4}
Output:  5

Input:  {7, 6, 4, 3, 1}
Output:  0

Time Complexity: O(N)
*/

public class BuyAndSellStock {

    /*
    Algorithm explanation:(Note that you are allowed to do only one transaction)
    1. Keep a note of the minimum element in an array.c
    2. If you find an element lesser then the minimum soFar element update the minValue.
    3. Else check whether the maxprofit can be formed by subtracting the current element and the minimum element.
    */
    public int getMaximumProfit(int[] stocks) {
        if (stocks == null || stocks.length == 0)
            return 0;
        int maxProfit = 0;
        int minSoFar = stocks[0];

        for(int i=1;i<stocks.length;i++) {
            if(stocks[i] > minSoFar) {
                maxProfit = Math.max(maxProfit, stocks[i] - minSoFar);
            } else {
                minSoFar = stocks[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stocks = {7, 1, 5, 3, 6, 4};
        BuyAndSellStock buyStock = new BuyAndSellStock();
        int maxProfit = buyStock.getMaximumProfit(stocks);
        System.out.println("The maximum profit that can be made is: " + maxProfit);
    }
}
