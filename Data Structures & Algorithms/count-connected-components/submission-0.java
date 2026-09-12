class DSU {
    private int[] parent;
    private int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int node) {
        int res = node;
        while (res != parent[res]) {
            parent[res] = parent[parent[res]]; // Path compression
            res = parent[res];
        }
        return res;
    }

    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) {
            return false;
        }

        // Union by rank
        if (rank[pv] > rank[pu]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        parent[pv] = pu;
        rank[pu] += rank[pv];
        return true;
    }
}

public class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int components = n;

        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) {
                components--;
            }
        }

        return components;
    }
}