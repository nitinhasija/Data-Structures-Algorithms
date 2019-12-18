/*
* A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number of ways to decode it.

Input Format:
The first and the only argument is a string A.

Output Format:
Return an integer, representing the number of ways to decode the string.
*/

// Time Complexity - O(N)
// Space Complexity - O(N)

public class Solution {
    public int numDecodings(String A) {
        if (A == null || A.length() == 0 || A.charAt(0) == '0')
            return 0;

        if (A.length() == 1 && A.charAt(0) != '0')
            return 1;

        int[] memo = new int[A.length() + 1];
        memo[A.length() - 1] = A.charAt(A.length() - 1) == '0' ? 0 : 1;
        memo[A.length()] = 1;

        for (int i = A.length() - 2; i >= 0; i--) {
            if (A.charAt(i) == '0') {
                if (A.charAt(i - 1) < '1' || A.charAt(i - 1) > '2')
                    return 0;

                memo[i] = 0;
            } else {
                int num = Integer.parseInt(A.charAt(i) + "" + A.charAt(i + 1));

                if (num < 27)
                    memo[i] = memo[i + 1] + memo[i + 2];

                else
                    memo[i] = memo[i + 1];
            }
        }
        return memo[0];
    }
}