public class leetcode63 {
    // link - https://leetcode.com/problems/unique-paths-ii/description/
}

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1) return 0;
        return uniquePaths(0,0,obstacleGrid);
    }
    private int uniquePaths(int i, int j, int[][] grid) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 1) return 0;
        if(i == grid.length-1 && j == grid[0].length-1) return 1;
        return uniquePaths(i+1, j, grid) + uniquePaths(i, j+1, grid);
    }
}

class Solution {
    Integer dp[][];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1) return 0;
        dp = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return uniquePaths(0,0,obstacleGrid);
    }
    private int uniquePaths(int i, int j, int[][] grid) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 1) return 0;
        if(i == grid.length-1 && j == grid[0].length-1) return 1;
        if(dp[i][j] != null) return dp[i][j];
        return dp[i][j] = uniquePaths(i+1, j, grid) + uniquePaths(i, j+1, grid);
    }
}

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1 || obstacleGrid[0][0] == 1) return 0;
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i<dp.length; i++) {
            for(int j = 0; j<dp[0].length; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if(obstacleGrid[i][j] == 1) continue;
                int up = 0, left = 0;
                if(i>0) up = dp[i-1][j];
                if(j>0) left = dp[i][j-1];
                dp[i][j] = up+left;
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1 || obstacleGrid[0][0] == 1) return 0;
        int prev[] = new int[obstacleGrid[0].length];
        for(int i = 0; i<obstacleGrid.length; i++) {
            int temp[] = new int[obstacleGrid[0].length];
            for(int j = 0; j<obstacleGrid[0].length; j++) {
                if(i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }
                if(obstacleGrid[i][j] == 1) continue;
                int up = 0, left = 0;
                if(i>0) up = prev[j];
                if(j>0) left = temp[j-1];
                temp[j] = up+left;
            }
            prev = temp;
        }
        return prev[obstacleGrid[0].length-1];
    }
}
