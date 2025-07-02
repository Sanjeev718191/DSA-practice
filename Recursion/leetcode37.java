public class leetcode37 {
    // link - https://leetcode.com/problems/sudoku-solver/description/
}

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char board[][]) {
        for(int i = 0; i<9; i++) {
            for(int j = 0; j<9; j++) {
                if(board[i][j] != '.') continue;
                for(char ch = '1'; ch<='9'; ch++) {
                    if(check(board, i, j, ch)) {
                        board[i][j] = ch;
                        if(solve(board)) return true;
                        else board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    private boolean check(char board[][], int r, int c, char ch) {
        for(int i = 0; i<9; i++) {
            if(i != r && board[i][c] == ch) return false;
            if(i != c && board[r][i] == ch) return false;
        }
        int sr = 3*(r/3), sc = 3*(c/3);
        // System.out.println(r+" "+c+" "+sr+" "+sc);
        for(int i = sr; i<sr+3; i++) {
            for(int j = sc; j<sc+3; j++) {
                if(i==r && j==c) continue;
                if(board[i][j] == ch) return false;
            }
        }
        return true;
    }

    // private boolean check(char[][] board, int row, int col, char num){
    //     int nRow = 3 * (row/3);
    //     int nCol = 3 * (col/3);
    //     for(int i = 0; i<9; i++){
    //         if(board[i][col] == num) return false;
    //         if(board[row][i] == num) return false;
    //         if(board[nRow + i/3][nCol + i%3] == num) return false;
    //     }
    //     return true;
    // }
}
