public class leecode1277 {
    // link - https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
}

class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int dp[][] = new int[n][m];
        for(int i = 0; i<n; i++) dp[i][0] = matrix[i][0];
        for(int i = 0; i<m; i++) dp[0][i] = matrix[0][i];
        for(int i = 1; i<n; i++) {
            for(int j = 1; j<m; j++) {
                if(matrix[i][j] == 0) continue;
                dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
            }
        }
        int count = 0;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                count += dp[i][j];
            }
        }
        return count;
    }
}

// Other approach 
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int col[] = new int[n];
        int count = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(matrix[i][j] == 0) col[j] = 0;
                else col[j] = col[j]+1;
            }
            count += countSquares(col);
        }
        return count;
    }
    private int countSquares(int nums[]) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i<n; i++) {
            int h = nums[i];
            int min = h;
            if(h != 0) count++;
            else continue;
            for(int j = i+1; j<n && j-i+1<=h && min >= j-i+1; j++) {
                min = Math.min(min, nums[j]);
                if(min >= j-i+1) count++;
            }
        }
        return count;
    }
}
