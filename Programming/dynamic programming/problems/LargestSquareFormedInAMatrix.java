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

public class Solution {
    private static int topDownDp(int[] weights, int[] values, int maxWeight, int index, int[][] memo) {
        if (index == weights.length)
            return 0;

        if (memo[maxWeight][index] == -1) {
            int include = 0;

            int exclude = topDownDp(weights, values, maxWeight, index + 1, memo);

            if (weights[index] <= maxWeight)
                include = topDownDp(weights, values, maxWeight - weights[index], index + 1, memo) + values[index];

            memo[maxWeight][index] = Math.max(include, exclude);
        }
        return memo[maxWeight][index];
    }


    private static int bottumUpDp(int[] values, int[] weights, int maxWeight) {
        int[][] table = new int[values.length + 1][maxWeight + 1];

        for (int i = 0; i <= values.length; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                if (i == 0 || j == 0)
                    table[i][j] = 0;

                else if (j - weights[i - 1] >= 0)
                    table[i][j] = Math.max(table[i - 1][j], table[i - 1][j - weights[i - 1]] + values[i - 1]);

                else
                    table[i][j] = table[i - 1][j];
            }
        }
        return table[values.length][maxWeight];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int size = sc.nextInt();
            int maxWeight = sc.nextInt();

            int[] weight = new int[size];
            int[] value = new int[size];

            for (int i = 0; i < size; i++)
                value[i] = sc.nextInt();

            for (int i = 0; i < size; i++)
                weight[i] = sc.nextInt();

            int[][] memo = new int[maxWeight + 1][size + 1];

            for (int i = 0; i < maxWeight + 1; i++)
                Arrays.fill(memo[i], -1);

//            System.out.println(topDownDp(weight, value, maxWeight, 0, memo));
            
            System.out.println(bottumUpDp(weight, value, maxWeight));
        }
    }
}