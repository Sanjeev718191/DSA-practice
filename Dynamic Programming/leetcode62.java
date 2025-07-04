public class leetcode62 {
    // link - https://leetcode.com/problems/unique-paths/description/
}

class Solution {
    public int uniquePaths(int m, int n) {
        return uniquePaths(0,0,m,n);
    }
    private int uniquePaths(int i, int j, int m, int n) {
        if(i<0 || j<0 || i>=m || j>=n) return 0;
        if(i == m-1 || j == n-1) return 1;
        return uniquePaths(i+1, j, m, n) + uniquePaths(i, j+1, m, n);
    }
}

class Solution {
    Integer dp[][];
    public int uniquePaths(int m, int n) {
        dp = new Integer[m][n];
        return uniquePaths(0,0,m,n);
    }
    private int uniquePaths(int i, int j, int m, int n) {
        if(i<0 || j<0 || i>=m || j>=n) return 0;
        if(i == m-1 || j == n-1) return 1;
        if(dp[i][j] != null) return dp[i][j];
        return dp[i][j] = uniquePaths(i+1, j, m, n) + uniquePaths(i, j+1, m, n);
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        int grid[][] = new int[m][n];
        for(int i = 0; i<m; i++) {
            grid[i][0] = 1;
        }
        for(int i = 0; i<n; i++) {
            grid[0][i] = 1;
        }
        for(int i = 1; i<m; i++) {
            for(int j = 1; j<n; j++) {
                grid[i][j] += grid[i-1][j] + grid[i][j-1];
            }
        }
        return grid[m-1][n-1];
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        int prev[] = new int[n];
        for(int i = 0; i<m; i++) {
            int temp[] = new int[n];
            for(int j = 0; j<n; j++) {
                if(i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }
                int up = 0, left = 0;
                if(i>0) up = prev[j];
                if(j>0) left = temp[j-1];
                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[n-1];
    }
}
