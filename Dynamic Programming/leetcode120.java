public class leetcode120 {
    // link - https://leetcode.com/problems/triangle/description/
}

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return minTotal(triangle, 0, 0);
    }
    private int minTotal(List<List<Integer>> triangle, int r, int c) {
        // System.out.println(r + " - " + c);
        if(r >= triangle.size() || c >= triangle.get(r).size()) return Integer.MAX_VALUE;
        if(r == triangle.size()-1) return triangle.get(r).get(c);
        int min = Math.min(minTotal(triangle, r+1, c), minTotal(triangle, r+1, c+1));
        return triangle.get(r).get(c)+min;
    }
}

class Solution {
    Integer dp[][];
    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new Integer[triangle.size()][triangle.size()];
        return minTotal(triangle, 0, 0);
    }
    private int minTotal(List<List<Integer>> triangle, int r, int c) {
        if(r >= triangle.size() || c >= triangle.get(r).size()) return Integer.MAX_VALUE;
        if(r == triangle.size()-1) return triangle.get(r).get(c);
        if(dp[r][c] != null) return dp[r][c];
        int min = Math.min(minTotal(triangle, r+1, c), minTotal(triangle, r+1, c+1));
        return dp[r][c] = triangle.get(r).get(c)+min;
    }
}

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][] = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i<triangle.size(); i++) {
            for(int j = 0; j<=i; j++) {
                if(j == 0) dp[i][j] = triangle.get(i).get(j) + dp[i-1][j];
                else if(j < i) dp[i][j] = Math.min(triangle.get(i).get(j) + dp[i-1][j], triangle.get(i).get(j) + dp[i-1][j-1]);
                else dp[i][j] = triangle.get(i).get(j) + dp[i-1][j-1];
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        int min = Integer.MAX_VALUE;
        for(int curr : dp[triangle.size()-1]) min = Math.min(min, curr);
        return min;
    }
}