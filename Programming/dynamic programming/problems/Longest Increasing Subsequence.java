/*
Find the longest increasing subsequence of a given array of integers, A.
In other words, find a subsequence of array in which the subsequence’s elements are in strictly increasing order, and in which the subsequence is as long as possible.
This subsequence is not necessarily contiguous, or unique.
In this case, we only care about the length of the longest increasing subsequence.


Input Format:
The first and the only argument is an integer array A.

Output Format:
Return an integer representing the length of the longest increasing subsequence.
 */

// Time Complexity - O(N^2)
// Space Complexity - O(N^2)

import java.util.List;

public class Solution {
    public int lis(final List<Integer> A) {
        int[][] memo = new int[A.size()][A.size()];

        return getLIS(A, -1, 0, memo);
    }

    private int getLIS(List<Integer> a, int prevIndex, int curIndex, int[][] memo) {
        if (curIndex == a.size())
            return 0;

        if (memo[prevIndex + 1][curIndex] != 0)
            return memo[prevIndex + 1][curIndex];

        int include = 0, exclude = 0;

        if (prevIndex < 0 || a.get(prevIndex) < a.get(curIndex))
            include = 1 + getLIS(a, curIndex, curIndex + 1, memo);

        exclude = getLIS(a, prevIndex, curIndex + 1, memo);

        memo[prevIndex + 1][curIndex] = Math.max(include, exclude);

        return memo[prevIndex + 1][curIndex];
    }
}
