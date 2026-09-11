class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;
        Map<Integer,List<Integer>> adj= new HashMap<>();
        for(int i=0;i<n;i++)
        {
            adj.put(i,new ArrayList<>());
        }
        for(int[] e:edges)
        {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        Set<Integer> visited = new HashSet<>();
        if(!dfs(0,-1,adj,visited)) return false;
        return visited.size()==n;
    }
    private boolean dfs(int node, int parent,Map<Integer,List<Integer>> adj,Set<Integer> visited)
    {
        if(visited.contains(node)) return false;
        visited.add(node);
        for(int c:adj.get(node))
        {
            if(c==parent) continue;
            if(!dfs(c,node,adj,visited)) return false;
        }
        return true;
    }
}
