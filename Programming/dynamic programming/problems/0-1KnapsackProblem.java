/*
You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively.
Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. 
You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of four lines.
The first line consists of N the number of items.
The second line consists of W, the maximum capacity of the knapsack.
In the next line are N space separated positive integers denoting the values of the N items,
and in the fourth line are N space separated positive integers denoting the weights of the corresponding items.

Output:
For each testcase, in a new line, print the maximum possible value you can get with the given conditions that you can obtain for each test case in a new line.
*/

// TIME COMPLEXITY - O(N*W)
// SPACE COMPLEXITY - O(N*W)

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