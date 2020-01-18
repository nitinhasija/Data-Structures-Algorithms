/*
Given an integer A, how many structurally unique BST’s (binary search trees) exist that can store values 1…A?

Input Format:
The first and the only argument of input contains the integer, A.

Output Format:
Return an integer, representing the answer asked in problem statement.

Constraints:
1 <= A <= 18

Example:
Input : A = 3
Output : 5

Explanation 1:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

// Time Complexity - O(N^2)
// Space Complexity - O(N)

public class Solution {
    public int numTrees(int A) {
        int[] catalan = new int[A + 1];
        catalan[0] = catalan[1] = 1;

//       return bottomUp(A, catalan);

        return topDown(A, catalan);
    }

    private int topDown(int A, int[] catalan) {
        for (int i = 2; i <= A; i++) {
            for (int j = 0; j < i; j++) {
                catalan[i] += (catalan[j] * catalan[i - j - 1]);
            }
        }
        return catalan[A];
    }

    private int bottomUp(int A, int[] catalan) {
        if (A <= 1)
            return 1;

        if (catalan[A] == 0) {
            int sum = 0;
            for (int i = 0; i < A; i++) {
                sum += bottomUp(i, catalan) * bottomUp(A - i - 1, catalan);
            }
            catalan[A] = sum;
        }
        return catalan[A];
    }
}