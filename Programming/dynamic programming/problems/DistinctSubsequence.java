/*
Given two sequences A, B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.

Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
of the characters without disturbing the relative positions of the remaining characters. (ie, “ACE” is a subsequence of “ABCDE” while “AEC” is not).

Input Format:
The first argument of input contains a string, A.
The second argument of input contains a string, B.

Output Format:
Return an integer representing the answer as described in the problem statement.

Constraints:

1 <= length(A), length(B) <= 700
Example :

Input 1:
    A = "abc"
    B = "abc"

Output 1:
    1

Explanation 1:
    Both the strings are equal.

Input 2:
    A = "rabbbit"
    B = "rabbit"

Output 2:
    3

Explanation 2:
    These are the possible removals of characters:
        => A = "ra_bbit"
        => A = "rab_bit"
        => A = "rabb_it"

    Note: "_" marks the removed character.
*/

// Time Complexity - O(n^2)
// Space Complexity - O(n^2)

public class Solution {
    public int numDistinct(String A, String B) {
        if (A.length() < B.length())
            return 0;

        if (A.equals(B))
            return 1;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(0)) {
                A = A.substring(i);
                break;
            }
        }

        for (int i = A.length() - 1; i >= 0; i--) {
            if (A.charAt(i) == B.charAt(B.length() - 1)) {
                A = A.substring(0, i + 1);
                break;
            }
        }

        int max = 0;
        int[][] arr = new int[B.length()][A.length()];

        if (A.charAt(0) == B.charAt(0))
            arr[0][0] = 1;

        for (int i = 1; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(0))
                arr[0][i] = arr[0][i - 1] + 1;
            else
                arr[0][i] = arr[0][i - 1];
        }

        for (int i = 1; i < B.length(); i++) {
            for (int j = i; j < A.length(); j++) {
                if (A.charAt(j) == B.charAt(i))
                    arr[i][j] = arr[i - 1][j - 1] + arr[i][j - 1];
                else
                    arr[i][j] = arr[i][j - 1];
            }
        }
        return arr[B.length() - 1][A.length() - 1];
    }
}