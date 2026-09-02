class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int area=0;
        for(int r=0;r<row;r++)
        {
            for(int c=0;c<col;c++)
            {
                if(grid[r][c]==1)
                {
                    int max =dfs(grid,r,c,row,col);
                    area=(area<max)?max:area;
                }

            }
        }
        return area;
    }
    private int dfs(int[][] grid,int r,int c,int row,int col)
    {
        if(r<0||r>=row||c<0||c>=col||grid[r][c]==0) return 0;
        grid[r][c]=0;
        return 1+dfs(grid,r+1,c,row,col)+dfs(grid,r-1,c,row,col)+dfs(grid,r,c+1,row,col)+dfs(grid,r,c-1,row,col);
         
        
    }
}

