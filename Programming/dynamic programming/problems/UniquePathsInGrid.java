/*
Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n).
At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.
*/

// Time Complexity - O(N*M)
// Space Complexity - O(N*M)

public class Solution {
    public int uniquePathsWithObstacles(int[][] A) {
        int arr[][] = new int[A.length][A[0].length];

        for (int i = 1; i < A[0].length; i++) {
            if (A[0][i] != 1)
                arr[0][i] = 1;

            else
                arr[0][i] = 0;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i][0] != 1)
                arr[i][0] = 1;

            else
                arr[i][0] = 0;
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < A[0].length; j++) {
                if (A[i][j] != 1)
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return arr[arr.length - 1][arr[0].length - 1];
    }
}
