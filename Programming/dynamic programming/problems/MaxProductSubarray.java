/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.
Return an integer corresponding to the maximum product possible.
*/

// Time Complexity - O(N)
// Space Complexity - O(1)

import java.util.List;

public class Solution {
    public int maxProduct(final List<Integer> A) {
        int curMax = 1, curMin = 1, prevMax = 1, prevMin = 1, ans = A.get(0);
        for (int i : A) {
            curMax = Math.max(prevMax * i, Math.max(prevMin * i, i));
            curMin = Math.min(prevMax * i, Math.min(prevMin * i, i));
            prevMax = curMax;
            prevMin = curMin;

            ans = Math.max(curMax, ans);
        }
        return ans;
    }
}