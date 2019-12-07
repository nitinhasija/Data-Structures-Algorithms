/*
Given an array of integers, A of length N, find the length of longest subsequence which is first increasing then decreasing.

Input Format:
The first and the only argument contains an integer array, A.

Output Format:

Return an integer representing the answer as described in the problem statement.
*/

// Time Complexity - O(N)
// Space Complexity - O(N)

import java.util.Arrays;

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int longestSubsequenceLength(final int[] arr) {
        int inc[] = new int[arr.length];
        int dec[] = new int[arr.length];

        Arrays.fill(inc, 1);
        Arrays.fill(dec, 1);

        for (int i = 1; i < arr.length; i++)
            for (int j = 0; j < i; j++)
                if (arr[i] > arr[j] && inc[i] < inc[j] + 1)
                    inc[i] = inc[j] + 1;

        for (int i = arr.length - 2; i >= 0; i--)
            for (int j = arr.length - 1; j > i; j--)
                if (arr[i] < arr[j] && dec[i] < dec[j] + 1)
                    dec[i] = dec[j] + 1;

        int max = 0;

        for (int i = 0; i < inc.length; i++)
            max = Math.max(max, inc[i] + dec[i] - 1);

        return max;
    }
}
