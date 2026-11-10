class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        boolean result = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0)){
                    result = Helper(0, i, j, board, word, visited);
                    if(result) return true;
                }
            }
        }
        return false;
    }

    //Helper Function
    public boolean Helper(int index, int row, int col, char[][] board, String word, boolean[][] visited){
        if(index == word.length()) return true;

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index) || visited[row][col]){
            return false;
        }

        visited[row][col] = true;

        if(Helper(index + 1, row + 1, col, board, word, visited) || 
           Helper(index + 1, row - 1, col, board, word, visited) ||
           Helper(index + 1, row, col + 1, board, word, visited) ||
           Helper(index + 1, row, col - 1, board, word, visited)){
            return true;
        }

        visited[row][col] = false;
        return false;
    }
}