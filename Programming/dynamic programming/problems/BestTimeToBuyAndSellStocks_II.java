/*
Say you have an array,A,for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit.

You may complete as many transactions as you like(i.e.,buy one and sell one share of the stock multiple times).

However,you may not engage in multiple transactions at the same time(ie,you must sell the stock before you buy again).

Input Format:
The first and the only argument is an array of integer,A.

Output Format:
Return an integer,representing the maximum possible profit.
*/

// Time Complexity - O(N)
// Space Complexity - O(1)

import java.util.List;

class Solution {
    public int maxProfit(final List<Integer> A) {
        int sum = 0;
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) < A.get(i + 1))
                sum += A.get(i + 1) - A.get(i);
        }

        return sum;
    }
}
