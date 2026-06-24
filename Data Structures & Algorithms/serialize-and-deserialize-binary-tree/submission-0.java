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

public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder s=new StringBuilder("");
        serializeHelper(root,s);
        return s.toString();
    }
    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N,");
            return;
        }
        
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes= data.split(",");
        int[] index = new int[]{0};
        return deserializeHelper(nodes,index);
        
    }
    private TreeNode deserializeHelper(String[] data,int[] index)
    {
        String curr=data[index[0]++];
        if(curr.equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left=deserializeHelper(data,index);
        root.right=deserializeHelper(data,index);
        return root;
    }
}
