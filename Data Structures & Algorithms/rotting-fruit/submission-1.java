class Solution {
    public int orangesRotting(int[][] grid) {

        int row=grid.length;
        int col=grid[0].length;
        Queue<int[]> queue= new LinkedList<>();
        int fresh=0;
        for(int r=0;r<row;r++)
        {
            for(int c=0;c<col;c++)
            {
                if(grid[r][c]==2)
                {
                    queue.offer(new int[]{r,c});
                }
                else if(grid[r][c]==1)fresh++;
            }
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int min=0;
        while(!queue.isEmpty() && fresh>0)
        {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;       
                        queue.offer(new int[]{nr, nc}); 
                        fresh--;           
                    }
                }
            }
            min++;
        }
        return fresh == 0 ? min : -1;
    }
}
