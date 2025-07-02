public class leetcode79 {
    // link - https://leetcode.com/problems/word-search/description/
}

class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[i].length; j++) {
                if(board[i][j] == word.charAt(0) && checkWord(board, i, j, word, 0, new boolean[board.length][board[0].length])) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkWord(char board[][], int i, int j, String word, int ind, boolean vis[][]) {
        if(ind == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[i].length || 
            vis[i][j] || board[i][j] != word.charAt(ind)) return false;
        vis[i][j] = true;
        if(checkWord(board, i+1, j, word, ind+1, vis)) return true;
        if(checkWord(board, i-1, j, word, ind+1, vis)) return true;
        if(checkWord(board, i, j+1, word, ind+1, vis)) return true;
        if(checkWord(board, i, j-1, word, ind+1, vis)) return true;
        vis[i][j] = false;
        return false;
    }
}
