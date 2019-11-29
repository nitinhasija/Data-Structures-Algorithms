/*
Given a binary tree T, find the maximum path sum.
The path may start and end at any node in the tree.

Input Format:
The first and the only argument contains a pointer to the root of T, A.

Output Format:
Return an integer representing the maximum sum path.
*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
 
// Time Complexity - O(N)
// Space Complexity - O(1)
// Inmemory stack- O(N)

public class Solution {
    int max = Integer.MIN_VALUE;

    private int getSum(TreeNode A) {
        if (A == null)
            return 0;

        int left = Math.max(0, getSum(A.left));   // To ignore negative valued node
        int right = Math.max(0, getSum(A.right)); 

        max = Math.max(max, left + right + A.val);

        int leftRightMax = Math.max(left, right) + A.val;
        return leftRightMax;                     // max node from either side of root to be included to parent.
    }

    public int maxPathSum(TreeNode A) {
        getSum(A);
        return max;
    }
}