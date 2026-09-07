class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }
        int rows=heights.length;
        int cols=heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        for (int c = 0; c < cols; c++) {
            dfs(heights, pacific, 0, c, heights[0][c]);                  
            dfs(heights, atlantic, rows - 1, c, heights[rows - 1][c]);    
        }
        for(int r=0;r<rows;r++){
            dfs(heights,pacific,r,0,heights[r][0]);
            dfs(heights,atlantic,r,cols-1,heights[r][cols-1]);
        }
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols;c++)
            {
                if(pacific[r][c] && atlantic[r][c])
                {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;

    }
    private void dfs(int[][] heights, boolean[][] visited, int r, int c, int prevHeight) {
        int rows = heights.length;
        int cols = heights[0].length;

        // Base cases: out of bounds, already visited, or water cannot flow upward
        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            dfs(heights, visited, r + dir[0], c + dir[1], heights[r][c]);
        }
    }
}
