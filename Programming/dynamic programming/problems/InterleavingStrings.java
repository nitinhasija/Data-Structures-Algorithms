/*
Given A, B, C, find whether C is formed by the interleaving of A and B.

Input Format:

The first argument of input contains a string, A.
The second argument of input contains a string, B.
The third argument of input contains a string, C.

Output Format:

Return an integer, 0 or 1:
    => 0 : False
    => 1 : True

Constraints:
1 <= length(A), length(B), length(C) <= 150

Examples:
Input 1:
    A = "aabcc"
    B = "dbbca"
    C = "aadbbcbcac"

Output 1:
    1

Explanation 1:
    "aa" (from A) + "dbbc" (from B) + "bc" (from A) + "a" (from B) + "c" (from A)

Input 2:
    A = "aabcc"
    B = "dbbca"
    C = "aadbbbaccc"

Output 2:
    0

Explanation 2:
    It is not possible to get C by interleaving A and B.
*/

// Time Complexity - O(N*M)
// Space Complexity - O(1)

public class Solution {
    public boolean isInterleave(String A, String B, String C) {
        if (C.length() != A.length() + B.length())
            return false;

        return isInterleave(A, B, C, 0, 0, 0);
    }

    private boolean isInterleave(String a, String b, String c, int i, int j, int k) {
        if (k == c.length())
            return true;

        else if (i < a.length() && j < b.length() && a.charAt(i) != c.charAt(k) && b.charAt(j) != c.charAt(k))
            return false;

        else if ((i < a.length() && a.charAt(i) == c.charAt(k)) && (j == b.length() || b.charAt(j) != c.charAt(k)))
            return isInterleave(a, b, c, i + 1, j, k + 1);

        else if ((i == a.length() || a.charAt(i) != c.charAt(k)) && (j < b.length() && b.charAt(j) == c.charAt(k)))
            return isInterleave(a, b, c, i, j + 1, k + 1);

        else if (i < a.length() && j < b.length()) {
            return isInterleave(a, b, c, i + 1, j, k + 1) || isInterleave(a, b, c, i, j + 1, k + 1);
        }
        return false;
    }
}