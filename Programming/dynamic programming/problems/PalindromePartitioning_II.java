/*
Given a string A, partition A such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of A.

Input Format:
The first and the only argument contains the string A.

Output Format:
Return an integer, representing the answer as described in the problem statement.
*/

// Time Complexity - O(N^2)
// Space Complexity - O(N^2)

import java.util.Arrays;

public class Solution {
    boolean[][] allPalindromes;

    public int minCut(String A) {
        allPalindromes = new boolean[A.length()][A.length()];
        findAllPalindromes(A);
        int memo[][] = new int[A.length()][A.length()];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return minCuts(0, A.length(), A, memo);
    }

    private int minCuts(int i, int j, String a, int memo[][]) {
        if (isPalindrome(i, j - 1))
            return 0;

        if (memo[i][j - 1] == -1) {
            int min = Integer.MAX_VALUE;
            for (int k = i + 1; k < j; k++) {
                min = Math.min(min, minCuts(i, k, a, memo) + 1 + minCuts(k, j, a, memo));
            }
            memo[i][j - 1] = min;
        }
        return memo[i][j - 1];
    }

    private boolean isPalindrome(int i, int j) {
        return allPalindromes[i][j];
    }

    public void findAllPalindromes(String X) {
        for (int i = X.length() - 1; i >= 0; i--) {
            for (int j = i; j < X.length(); j++) {
                if (i == j) {
                    allPalindromes[i][j] = true;
                } else if (X.charAt(i) == X.charAt(j)) {
                    allPalindromes[i][j] = ((j - i == 1) ? true : allPalindromes[i + 1][j - 1]);
                } else {
                    allPalindromes[i][j] = false;
                }
            }
        }
    }
}
