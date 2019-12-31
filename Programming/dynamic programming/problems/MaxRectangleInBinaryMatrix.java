/*
Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.
*/

// Time Complexity - O(M*N)
// Space Complexity - O(M)

import java.util.Stack;

public class Solution {
    public int maximalRectangle(int[][] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1 && i > 0)
                    A[i][j] += A[i - 1][j];
            }
            max = Math.max(max, getMaxHistogramArea(A, i));
        }
        return max;
    }

    private int getMaxHistogramArea(int[][] A, int row) {
        int top = 0, maxArea = -1, area = -1, i = 0;
        Stack<Integer> stk = new Stack();
        for (i = 0; i < A[row].length; i++) {
            while (!stk.isEmpty() && A[row][i] < A[row][stk.peek()]) {
                top = stk.pop();

                if (stk.isEmpty())
                    area = A[row][top] * i;

                else
                    area = A[row][top] * (i - 1 - stk.peek());

                maxArea = Math.max(maxArea, area);
            }
            stk.push(i);
        }
        while (!stk.isEmpty()) {
            top = stk.pop();

            if (stk.isEmpty())
                area = A[row][top] * i;

            else
                area = A[row][top] * (i - 1 - stk.peek());

            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
