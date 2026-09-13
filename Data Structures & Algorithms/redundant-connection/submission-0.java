class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n =edges.length;
        DSU dsu= new DSU(n);
        for(int[] edge:edges)
        {
            if(!dsu.union(edge[0],edge[1]))
            {
                return edge;
            }

        }
        return new int[0];
    }
}

private class DSU{
    private int[] parent;
    private int[] rank;

        
    public DSU(int n)
    {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i+1;
            rank[i]=i+1;
        }
    }
    private int find(int node)
    {
        int res=node;
        while(res!=parent[node-1])
        {
            parent[res-1]=parent[parent[res-1]-1];
            res = parent[res-1];
        }
        return res;
    }
    public boolean union(int u, int v)
    {
        int pu=find(u);
        int pv=find(v);
        if(pv==pu) return false;

        if(rank[pv-1]>rank[pu-1])
        {
            int temp=pv;
            pv=pu;
            pu=temp;
        }

        parent[pv-1]=pu;
        rank[pu-1]++;
        return true;
    }
}