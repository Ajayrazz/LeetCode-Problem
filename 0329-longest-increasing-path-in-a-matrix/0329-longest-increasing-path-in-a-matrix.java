class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        if(n == 0 && m == 0) return 0;
        if(n == 1 && m == 1) return 1;
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        int[][] dp = new int[n][m];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans = Math.max(ans, dfs(i, j, matrix, dp, dx, dy));
            }
        }

        return ans;
    }

    //dfs function
    public int dfs(int row, int col, int[][] matrix, int[][] dp, int[] dx, int[] dy){
        if(dp[row][col] > 0) return dp[row][col];
        int ans = 1;
        for(int index = 0; index < 4; index++){
            int nRow = row + dx[index];
            int nCol = col + dy[index];
            if(nRow >= 0 && nCol >= 0 && nRow < matrix.length && nCol < matrix[0].length && matrix[nRow][nCol] > matrix[row][col]){
                ans = Math.max(ans, dfs(nRow, nCol, matrix, dp, dx, dy) + 1);
            }
        }

        return dp[row][col] = ans;
    }
}