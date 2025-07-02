public class leetcode51 {
    // link - https://leetcode.com/problems/n-queens/description/
}

class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char arr[][] = new char[n][n];
        for(char c[] : arr) Arrays.fill(c, '.');
        if(n == 1) {
            ArrayList<String> ls = new ArrayList<>();
            ls.add("Q");
            res.add(ls);
        } else {
            util(arr, 0);
        }
        return res;
    }
    private void util(char arr[][], int row) {
        if(row >= arr.length) {
            List<String> ls = new ArrayList<>();
            for(char ch[] : arr) ls.add(new String(ch));
            res.add(ls);
            return;
        }
        for(int i = 0; i<arr[row].length; i++) {
            if(check(arr, row, i)) {
                arr[row][i] = 'Q';
                util(arr, row+1);
                arr[row][i] = '.';
            }
        }
    }
    private boolean check(char ch[][], int i, int j) {
        // int dir[][] = {{0,1}, {1,0}, {-1,0}, {0,-1}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};
        int n = ch.length;
        // for(int d[] : dir) {
        //     int x = i+d[0], y = i+d[1];
        //     if(x < 0 || x >= n || y < 0 || y >= n) continue;
        //     if(ch[x][y] == 'Q') return false;
        // }
        for(int k = 0; k<n; k++) {
            if(i+k < n && ch[i+k][j] == 'Q') return false;
            if(i-k >= 0 && ch[i-k][j] == 'Q') return false;
            if(i+k < n && j+k < n && ch[i+k][j+k] == 'Q') return false;
            if(i-k >= 0 && j-k >= 0 && ch[i-k][j-k] == 'Q') return false;
            if(i-k >= 0 && j+k < n && ch[i-k][j+k] == 'Q') return false;
            if(i+k < n && j-k >= 0 && ch[i+k][j-k] == 'Q') return false;
        }
        return true;
    }
}
