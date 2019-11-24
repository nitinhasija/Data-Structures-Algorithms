/*
Say you have an array, A, for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Return the maximum possible profit.

Input Format:
The first and the only argument is an array of integers, A.

Output Format:
Return an integer, representing the maximum possible profit.
*/

// Time Complexity - O(N)
// Space Complexity - O(N)

import java.util.List;

class Solution {
    public int maxProfit(final List<Integer> A) {
        if (A.isEmpty())
            return 0;

        int[] minValue = new int[A.size()];
        minValue[0] = A.get(0);

        for (int i = 1; i < A.size(); i++)
            minValue[i] = Math.min(minValue[i - 1], A.get(i));

        int maxProfit = 0;
        for (int i = 0; i < A.size(); i++) {
            maxProfit = Math.max(maxProfit, A.get(i) - minValue[i]);
        }
        return maxProfit;
    }
}
