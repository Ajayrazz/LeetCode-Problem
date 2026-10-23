class Solution {
    public List<List<String>> solveNQueens(int n) {
        if(n == 0) return new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row, '.');
        }

        int[] leftRow = new int[n];
        int[] lowerDiag = new int[2 * n - 1];
        int[] upperDiag = new int[2 * n - 1];
        Helper(0, n, board, result, leftRow, lowerDiag, upperDiag);
        return result;
    }

    //Helper Function
    public void Helper(int col, int n, char[][] board, List<List<String>> result, int[] leftRow, int[] lowerDiag, int[] upperDiag){
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
                Helper(col + 1, n, board, result, leftRow, lowerDiag, upperDiag);
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