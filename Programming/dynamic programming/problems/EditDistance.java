/*
Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character

Input Format:
The first argument of input contains a string, A.
The second argument of input contains a string, B.

Output Format:
Return an integer, representing the minimum number of steps required.
*/

// Time Complexity - O(M*N)
// Space Complexity - O(M*N)

public class Solution {
    public int minDistance(String A, String B) {
//        return bottomUp(A, B, A.length() - 1, B.length() - 1, new int[A.length()][B.length()]);
        return topDown(A, B);
    }

    private int bottomUp(String A, String B, int i, int j, int memo[][]) {
        if (i < 0)
            return j + 1;

        else if (j < 0)
            return i + 1;

        if (A.charAt(i) == B.charAt(j))
            memo[i][j] = bottomUp(A, B, i - 1, j - 1, memo);

        else
            memo[i][j] = 1 + Math.min(Math.min(bottomUp(A, B, i, j - 1, memo), bottomUp(A, B, i - 1, j, memo))
                    , bottomUp(A, B, i - 1, j - 1, memo));

        return memo[i][j];
    }

    private int topDown(String A, String B) {
        int arr[][] = new int[B.length() + 1][A.length() + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = i;
        }

        for (int i = 0; i < arr[0].length; i++) {
            arr[0][i] = i;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (B.charAt(i - 1) == A.charAt(j - 1))
                    arr[i][j] = arr[i - 1][j - 1];
                else
                    arr[i][j] = 1 + Math.min(arr[i - 1][j - 1], Math.min(arr[i][j - 1], arr[i - 1][j]));
            }
        }
        return arr[B.length()][A.length()];
    }
}