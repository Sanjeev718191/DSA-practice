public class leecode1020 {
    // link - https://leetcode.com/problems/number-of-enclaves/description/
}

class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if((i == 0 || j == 0 || i == m-1 || j == n-1) && grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        int count = 0;
        for(int col[] : grid) {
            for(int val : col) count += val;
        }
        return count;
    }
    private void dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                dfs(grid, x, y);
            }
        }
    }
}