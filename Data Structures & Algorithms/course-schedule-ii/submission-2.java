class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adj= new HashMap<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.put(i,new ArrayList<>());
        }
        for(int [] pre: prerequisites)
        {
            adj.get(pre[0]).add(pre[1]);
        }
        List<Integer> order = new ArrayList<>();
        int[] state = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
        {
            if (!dfs(i, adj, state, order)) {
                return new int[0];
            }
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }
        return result;
    }
    private boolean dfs(int crs, Map<Integer, List<Integer>> adj, int[] state, List<Integer> order) {
        if(state[crs]==1) return false;
        if(state[crs]==2) return true;
        state[crs]=1;
        for(int pre:adj.get(crs))
        {
            if(!dfs(pre, adj, state, order)) return false;
        }
        state[crs]=2;
        order.add(crs);
        return true;
    }
}
