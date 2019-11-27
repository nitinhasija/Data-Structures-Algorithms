/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.
*/

// Time Complexity - O(N^2)
// Space Complexity - O(N^2)

public class Solution {
    public int minPathSum(int[][] A) {
        int[][] arr = new int[A.length][A[0].length];
        arr[0][0] = A[0][0];

        for (int i = 1; i < A.length; i++)
            arr[i][0] = arr[i - 1][0] + A[i][0];

        for (int i = 1; i < A[0].length; i++)
            arr[0][i] = arr[0][i - 1] + A[0][i];

        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < A[0].length; j++) {
                arr[i][j] = A[i][j] + Math.min(arr[i - 1][j], arr[i][j - 1]);
            }
        }
        return arr[A.length - 1][A[0].length - 1];
    }
}