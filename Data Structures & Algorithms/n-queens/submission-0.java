class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        int[] queens = new int[n];
        boolean[] cols = new boolean[n];
        boolean[] posDiag = new boolean[2 * n];
        boolean[] negDiag = new boolean[2 * n];
        backtrack(0, n, queens, cols, posDiag, negDiag, res);
        return res;
    }
    private void backtrack(int r, int n, int[] queens, boolean[] cols, 
                           boolean[] posDiag, boolean[] negDiag, List<List<String>> res)
    {
        if (r == n) {
            res.add(buildBoard(queens, n));
            return;
        }
        for (int c = 0; c < n; c++) {
            int pDiag = r + c;
            int nDiag = r - c + n - 1;
            if (cols[c] || posDiag[pDiag] || negDiag[nDiag]) continue;
            queens[r] = c;
            cols[c] = posDiag[pDiag] = negDiag[nDiag] = true;
            backtrack(r + 1, n, queens, cols, posDiag, negDiag, res);
            cols[c] = posDiag[pDiag] = negDiag[nDiag] = false;

        }
    }
    private List<String> buildBoard(int[] queens, int n) {
    List<String> board = new ArrayList<>();
    for (int r = 0; r < n; r++) {
        char[] row = new char[n];
        Arrays.fill(row, '.');
        row[queens[r]] = 'Q';
        board.add(new String(row));
    }
    return board;
}
}
