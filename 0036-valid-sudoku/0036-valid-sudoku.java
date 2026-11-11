class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char num = board[i][j];
                if(num != '.'){
                    if(!set.add(num + " in row " + i)) return false;
                    if(!set.add(num + " in col " + j)) return false;
                    if(!set.add(num + " in box " + (i / 3) + " - " + (j / 3))) return false;
                }
            }
        }
        return true;
    }
}