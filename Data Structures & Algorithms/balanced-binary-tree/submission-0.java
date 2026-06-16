/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        int heightdiff=height(root);
        if(heightdiff==-1) return false;
        return true;
    }
    public int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left =height(root.left);
        int right=height(root.right);
        if(right==-1||left==-1) return -1;
        else if(Math.abs(right-left)>1) return -1;
        else return 1+Math.max(left,right);
    }
}
