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
    private int maxdia;
    public int diameterOfBinaryTree(TreeNode root) {
        maxdia=0;
        heightOfBinaryTree(root);
        return maxdia;


    }
    public int heightOfBinaryTree(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=heightOfBinaryTree(root.left);
        int right=heightOfBinaryTree(root.right);
        maxdia=maxdia>right+left?maxdia:left+right;
        return 1 + Math.max(left, right);
    }
}
