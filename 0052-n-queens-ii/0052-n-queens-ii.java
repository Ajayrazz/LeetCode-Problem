class Solution {
    public int totalNQueens(int n) {
        if(n == 0 || n == 1) return n;
        int[] leftRow = new int[n];
        int[] lowerDiag = new int[2 * n - 1];
        int[] upperDiag = new int[2 * n - 1];
        return solve(0, n, leftRow, lowerDiag, upperDiag);
    }

    //solve function
    public int solve(int col, int n, int[] leftRow, int[] lowerDiag, int[] upperDiag){
        if(col == n) return 1;
        int count = 0;
        for(int row = 0; row < n; row++){
            if(leftRow[row] == 0 && lowerDiag[row + col] == 0 && upperDiag[n - 1 + col - row] == 0){
                leftRow[row] = 1;
                lowerDiag[row + col] = 1;
                upperDiag[n - 1 + col - row] = 1;
                count += solve(col + 1, n, leftRow, lowerDiag, upperDiag);
                leftRow[row] = 0;
                lowerDiag[row + col] = 0;
                upperDiag[n - 1 + col - row] = 0;
            }
        }
        return count;
    }
}