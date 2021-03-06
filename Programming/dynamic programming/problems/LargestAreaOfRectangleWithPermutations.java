/*
Given a binary grid i.e. a 2D grid only consisting of 0’s and 1’s, find the area of the largest rectangle inside the grid such that all the cells inside the chosen rectangle should have 1 in them.
You are allowed to permutate the columns matrix i.e. you can arrange each of the column in any order in the final grid. Please follow the below example for more clarity.

Lets say we are given a binary grid of 3 * 3 size.
1 0 1

0 1 0

1 0 0

At present we can see that max rectangle satisfying the criteria mentioned in the problem is of 1 * 1 = 1 area i.e either of the 4 cells which contain 1 in it.
Now since we are allowed to permutate the columns of the given matrix, we can take column 1 and column 3 and make them neighbours. One of the possible configuration of the grid can be:
1 1 0

0 0 1

1 0 0

Now In this grid, first column is column 1, second column is column 3 and third column is column 2 from the original given grid. Now, we can see that if we calculate the max area rectangle,
we get max area as 1 * 2 = 2 which is bigger than the earlier case. Hence 2 will be the answer in this case.
*/

// Time Complexity - O(N*M*log(M))
// Space Complexity - O(N*M)

import java.util.Arrays;

public class Solution {
    public int solve(int[][] A) {
        int[][] arr = new int[A.length][A[0].length];
        for (int i = 0; i < A[0].length; i++)
            arr[0][i] = A[0][i];

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    arr[i][j] = arr[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            Arrays.sort(arr[i]);
        }
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                int area = arr[i][j] * (A[0].length - j);
                if (area > maxArea)
                    maxArea = area;
            }
        }
        return maxArea;
    }
}