public class leetcode64 {
    // link - https://leetcode.com/problems/minimum-path-sum/description/
}

class Solution {
    public int minPathSum(int[][] grid) {
        return minPathSum(grid, grid.length-1, grid[0].length-1);
    }
    private int minPathSum(int[][] grid, int n, int m){
        if(n == 0 && m == 0) return grid[n][m];
        if(n < 0 || m < 0) return Integer.MAX_VALUE;
        return grid[n][m] + Math.min(minPathSum(grid, n-1, m), minPathSum(grid, n, m-1));
    }
}

class Solution {
    Integer dp[][];
    public int minPathSum(int[][] grid) {
        dp = new Integer[grid.length][grid[0].length];
        return minPathSum(grid, grid.length-1, grid[0].length-1);
    }
    private int minPathSum(int[][] grid, int n, int m){
        if(n == 0 && m == 0) return grid[n][m];
        if(n < 0 || m < 0) return Integer.MAX_VALUE;
        if(dp[n][m] != null) return dp[n][m];
        return dp[n][m] = grid[n][m] + Math.min(minPathSum(grid, n-1, m), minPathSum(grid, n, m-1));
    }
}

class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for(int i = 0; i<dp.length; i++) {
            for(int j = 0; j<dp[i].length; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                if(i > 0) up = dp[i-1][j]+grid[i][j];
                if(j > 0) left = dp[i][j-1]+grid[i][j];
                dp[i][j] = Math.min(up, left);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}

class Solution {
    public int minPathSum(int[][] grid) {
        int prev[] = new int[grid[0].length];
        for(int i = 0; i<grid.length; i++) {
            int temp[] = new int[grid[0].length];
            for(int j = 0; j<grid[i].length; j++) {
                if(i == 0 && j == 0) {
                    temp[j] = grid[i][j];
                    continue;
                }
                int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                if(i > 0) up = prev[j]+grid[i][j];
                if(j > 0) left = temp[j-1]+grid[i][j];
                temp[j] = Math.min(up, left);
            }
            prev = temp;
        }
        return prev[grid[0].length-1];
    }
}
