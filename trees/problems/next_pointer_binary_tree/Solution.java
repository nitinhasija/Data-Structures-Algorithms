/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList();
        queue.add(root);
        queue.add(null);
        while(queue.size() > 0){
           while(queue.peek() != null){
               TreeLinkNode temp = queue.poll();
               temp.next = queue.peek();
               
               if(temp.left != null)
                queue.add(temp.left);
            
               if(temp.right != null)
                queue.add(temp.right);
           }
           queue.poll();
           
           if(queue.size() > 0)
            queue.add(null);
        }
    }
}