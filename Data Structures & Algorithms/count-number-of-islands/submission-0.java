class Solution {
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col= grid[0].length;
        int island_count=0;
        for(int r=0;r<row;r++)
        {
            for(int c=0;c<col;c++)
            {
                if(grid[r][c]=='1')
                {
                    island_count++;
                    dfs(r,c,grid,row,col);
                }
            }
        }
        return island_count;

    }
    private void dfs(int r,int c,char[][] grid,int row,int col)
    {
        if(r<0||r>=row||c<0||c>=col||grid[r][c]=='0') return;
        grid[r][c]='0';
        dfs(r+1,c,grid,row,col);
        dfs(r-1,c,grid,row,col);
        dfs(r,c+1,grid,row,col);
        dfs(r,c-1,grid,row,col);
    }
}
