/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Map<Node,Node> nodemap= new HashMap<>();
        return dfs(node,nodemap);
    }
    private Node dfs(Node node,Map<Node,Node> nodemap)
    {
        if(nodemap.containsKey(node)) return nodemap.get(node);
        Node clone=new Node(node.val);
        nodemap.put(node, clone);
        for(Node n:node.neighbors)
        {
            clone.neighbors.add(dfs(n,nodemap));
             
        }
        return clone;
    }
}