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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        levelorderlist(res,0,root);
        return res;
    }
    public void levelorderlist(List<List<Integer>> arr,int level,TreeNode root)
    {
        if(root==null) return;
        if(arr.size()<=level) arr.add(new ArrayList<>());
        arr.get(level).add(root.val);

        levelorderlist(arr,level+1,root.left);
        levelorderlist(arr,level+1,root.right);
    }
}
