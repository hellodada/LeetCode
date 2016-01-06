public class Solution {
    public void solveSudoku(char[][] board) {
        if( board == null || board.length == 0)
            return;
        helper(board);
    }
    public boolean helper(char[][] board){
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '.'){
                    for(char value = '1'; value <= '9'; value++){
                       // System.out.println(value);
                        if(isValid(board, i, j, value)){
                            board[i][j] = value;
                            if(helper(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board, int row, int col, char value){
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == value)
                return false;
        }
        for(int j = 0; j < board[0].length; j++){
            if(board[row][j] == value)
                return false;
        }
        for(int i = row/3*3; i < row/3*3+3; i++){
            for(int j = col/3*3; j < col/3*3+3; j++){
                if(board[i][j] == value)
                    return false;
            }
        }
        return true;
    }
}