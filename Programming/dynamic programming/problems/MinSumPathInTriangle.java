/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */

// Time Complexity - O(N)       N is the number of elements
// Space Complexity - O(N)      N is the number of elements

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> A) {
        return getSum(A, 0, 0, new HashMap());
    }

    private int getSum(ArrayList<ArrayList<Integer>> A, int index, int row, HashMap<String, Integer> hm) {
        if (row == A.size() - 1)
            return A.get(row).get(index);

        int min = Integer.MAX_VALUE, x = 0, y = 0;

        if (hm.containsKey((row + 1) + "|" + index))
            x = hm.get((row + 1) + "|" + index);
        else
            x = getSum(A, index, row + 1, hm);

        if (hm.containsKey((row + 1) + "|" + (index + 1)))
            y = hm.get((row + 1) + "|" + (index + 1));
        else
            y = getSum(A, index + 1, row + 1, hm);

        min = Math.min(x, y) + A.get(row).get(index);
        hm.put((row) + "|" + index, min);
        return min;
    }
}
