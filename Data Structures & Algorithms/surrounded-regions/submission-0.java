class Solution {
    public void solve(char[][] board) {
        int rows=board.length;
        int cols=board[0].length;
        for(int r=0;r<rows;r++)
        {
            dfs(board,r,0);
            dfs(board,r,cols-1);
        }
        for(int c=0;c<cols;c++)
        {
            dfs(board,0,c);
            dfs(board,rows-1,c);
        }
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols;c++)
            {
                if(board[r][c]=='#') board[r][c]='O';
                else board[r][c]='X';
            }
        }

    }
    private void dfs(char[][] board,int r,int c)
    {
        int rows = board.length;
        int cols = board[0].length;

         if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c]!='O') {
            return;
        }
        if(board[r][c]=='O') board[r][c]='#';
        int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] dir:directions)
        {
            dfs(board,r+dir[0],c+dir[1]);
        }
    }
}
