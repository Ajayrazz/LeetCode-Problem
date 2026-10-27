class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        int count = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X' && !visited[i][j]){
                    count += 1;
                    dfs(i, j, board, visited, dx, dy);
                }
            }
        }
        return count;
    }

    //dfs function
    public void dfs(int row, int col, char[][] board, boolean[][] visited, int[] dx, int[] dy){
        visited[row][col] = true;
        for(int index = 0; index < 4; index++){
            int nRow = row + dx[index];
            int nCol = col + dy[index];
            if(nRow >= 0 && nCol >= 0 && nRow < board.length && nCol < board[0].length && board[row][col] == 'X' && !visited[nRow][nCol]){
                dfs(nRow, nCol, board, visited, dx, dy);
            }
        }
    }
}