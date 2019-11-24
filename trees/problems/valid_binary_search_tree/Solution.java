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

public class Solution {
    int checkBST(TreeNode A,int min,int max){
        if(A == null) 
         return 1;
         
        else if(A.val <= min || A.val >= max)
         return 0;
        
         int temp1 = checkBST(A.left,min,A.val);
         int temp2 = checkBST(A.right,A.val,max);
         
         if(temp1==1 && temp2==1)
          return 1;
          
         else
          return 0;
      }
    public int isValidBST(TreeNode A) {
        return checkBST(A,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}