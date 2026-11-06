class Solution {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        boolean[][] visited = new boolean[n][m];

        for(int row = 0; row < n; row++){
            //first column
            if(board[row][0] == 'O' && !visited[row][0]){
                dfs(row, 0, board, visited, dx, dy);
            }
            //last column
            if(board[row][m - 1] == 'O' && !visited[row][m - 1]){
                dfs(row, m - 1, board, visited, dx, dy);
            }
        }

        for(int col = 0; col < m; col++){
            //first row
            if(board[0][col] == 'O' && !visited[0][col]){
                dfs(0, col, board, visited, dx, dy);
            }
            //last row
            if(board[n - 1][col] == 'O' && !visited[n - 1][col]){
                dfs(n - 1, col, board, visited, dx, dy);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    //dfs function
    public void dfs(int row, int col, char[][] board, boolean[][] visited, int[] dx, int[] dy){
        visited[row][col] = true;
        for(int index = 0; index < 4; index++){
            int nRow = row + dx[index];
            int nCol = col + dy[index];
            if(nRow >= 0 && nRow < board.length && nCol >= 0 && nCol < board[0].length && board[nRow][nCol] == 'O' && !visited[nRow][nCol]){
                dfs(nRow, nCol, board, visited, dx, dy);
            }
        }
    }
}