class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adj= new HashMap<>();
        Set<Integer> visited= new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]); 
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited, adj)) {
                return false;
            }
        }
        return true;

    }
    private boolean dfs(int crs,Set<Integer> visited,Map<Integer,List<Integer>> adj)
    {
        if(visited.contains(crs)) return false;
        if(adj.get(crs).isEmpty()) return true;
        visited.add(crs);
        for(int pre:adj.get(crs))
        {
            if(dfs(pre,visited,adj)==false) return false;
        }
        visited.remove(crs);
        adj.get(crs).clear();
        return true;
    }
}
