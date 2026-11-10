class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row : board) Arrays.fill(row, '.');
        List<List<String>> result = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] lowerDiag = new int[2 * n - 1];
        int[] upperDiag = new int[2 * n - 1];
        solve(0, n, board, result, leftRow, lowerDiag, upperDiag);
        return result;
    }

    //solve function
    public void solve(int col, int n, char[][] board, List<List<String>> result, int[] leftRow, int[] lowerDiag, int[] upperDiag){
        if(col == n){
            result.add(construct(board));
            return;
        }

        for(int row = 0; row < n; row++){
            if(leftRow[row] == 0 && lowerDiag[row + col] == 0 && upperDiag[n - 1 + col - row] == 0){
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiag[row + col] = 1;
                upperDiag[n - 1 + col - row] = 1;
                solve(col + 1, n, board, result, leftRow, lowerDiag, upperDiag);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiag[row + col] = 0;
                upperDiag[n - 1 + col - row] = 0;
            }
        }
    }

    //construct function
    public List<String> construct(char[][] board){
        List<String> result = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            result.add(new String(board[i]));
        }
        return result;
    }
}