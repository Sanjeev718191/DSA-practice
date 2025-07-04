public class leetcode931 {
    // link - https://leetcode.com/problems/minimum-falling-path-sum/description/
}

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int sum = Integer.MAX_VALUE;
        for(int i = 0; i<matrix[0].length; i++) {
            sum = Math.min(sum, minSum(matrix, 0, i));
        }
        return sum;
    }
    private int minSum(int arr[][], int r, int c) {
        if(r < 0 || c < 0 || r >= arr.length || c >= arr[r].length) return Integer.MAX_VALUE;
        if(r == arr.length-1) return arr[r][c];
        int min = Math.min(minSum(arr, r+1, c-1), Math.min(minSum(arr, r+1, c), minSum(arr, r+1, c+1)));
        return min + arr[r][c];
    }
}

class Solution {
    Integer dp[][];
    public int minFallingPathSum(int[][] matrix) {
        int sum = Integer.MAX_VALUE;
        dp = new Integer[matrix.length][matrix[0].length];
        for(int i = 0; i<matrix[0].length; i++) {
            sum = Math.min(sum, minSum(matrix, 0, i));
        }
        return sum;
    }
    private int minSum(int arr[][], int r, int c) {
        if(r < 0 || c < 0 || r >= arr.length || c >= arr[r].length) return Integer.MAX_VALUE;
        if(r == arr.length-1) return arr[r][c];
        if(dp[r][c] != null) return dp[r][c];
        int min = Math.min(minSum(arr, r+1, c-1), Math.min(minSum(arr, r+1, c), minSum(arr, r+1, c+1)));
        return dp[r][c] = min + arr[r][c];
    }
}
