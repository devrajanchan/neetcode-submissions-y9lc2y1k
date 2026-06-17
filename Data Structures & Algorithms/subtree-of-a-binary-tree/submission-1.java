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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if(subRoot==null) return true;
        if(isSametree(root,subRoot)==true||isSubtree(root.left,subRoot)==true||isSubtree(root.right,subRoot)==true) return true;
        return false;
    }
    public boolean isSametree(TreeNode p,TreeNode q)
    {
        if(p==null && q==null) return true;
        if((p==null && q!=null)||(p!=null && q==null)) return false;
        if(p.val!=q.val) return false;
        boolean left=true,right=true;
        left=isSametree(p.left,q.left);
        right=isSametree(p.right,q.right);
        return left&&right;
    }
    
}
