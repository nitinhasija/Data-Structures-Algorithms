/*
Given a binary matrix, find out the maximum size square sub-matrix with all 1s.

Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is n and m,n is the number of rows and m is the number of columns.
The second line of each test case contains array C[n][m] in row major form.

Output:
Print maximum size square sub-matrix.
*/

// Time Cpmplexity - O(N*M)
// Space Complexity - O(N*M)

import java.util.Arrays;
import java.util.Scanner;

class GFG {
    private static int memoization(int[][] arr, int i, int j, int[][] memo) {
        if (i == arr.length || j == arr[0].length || arr[i][j] == 0)
            return 0;
        else if (memo[i][j] != -1)
            return memo[i][j];

        memo[i][j] = 1 + Math.min(Math.min(memoization(arr, i + 1, j, memo),
                memoization(arr, i, j + 1, memo)),
                memoization(arr, i + 1, j + 1, memo));

        return memo[i][j];
    }

    private static int getSize(int[][] arr, int rows, int cols) {
        int size = 0;
        int memo[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(memo[i], -1);
        }

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (arr[i][j] == 1)
                    size = Math.max(size, memoization(arr, i, j, memo));

        return size;

//        return iterative(arr, rows, cols);
    }

    private static int iterative(int[][] arr, int rows, int cols) {
        int size = 0;
        int cache[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0)
                    cache[i][j] = arr[i][j];

                else if (arr[i][j] == 1)
                    cache[i][j] = 1 + Math.min(Math.min(cache[i - 1][j], cache[i][j - 1]), cache[i - 1][j - 1]);

                size = Math.max(size, cache[i][j]);
            }
        }
        return size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            int arr[][] = new int[n][m];

            for (int j = 0; j < n; j++)
                for (int i = 0; i < m; i++)
                    arr[j][i] = sc.nextInt();

            System.out.println(getSize(arr, n, m));
        }
    }
}