/*
Say you have an array, A, for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most 2 transactions.

Return the maximum possible profit.

Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


Input Format:
The first and the only argument is an integer array, A.

Output Format:
Return an integer, representing the maximum possible profit.
*/

// Time Complexity - O(N)
// Space Complexity - O(N)

import java.util.List;

public class Solution {
    public int maxProfit(final List<Integer> A) {
        if (A.isEmpty() || A.size() == 1)
            return 0;

        int[] arr = new int[A.size()];
        int maxValue = A.get(A.size() - 1);

        for (int i = A.size() - 2; i >= 0; i--) {
            maxValue = Math.max(maxValue, A.get(i));
            arr[i] = Math.max(arr[i + 1], maxValue - A.get(i));
        }

        int minValue = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            minValue = Math.min(minValue, A.get(i));
            arr[i] = Math.max(arr[i - 1], arr[i] + A.get(i) - minValue);
        }
        return arr[arr.length - 1];
    }
}