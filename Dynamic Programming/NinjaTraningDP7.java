public class NinjaTraningDP7 {
    // link - https://www.naukri.com/code360/problems/ninja-s-training_3621003?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=PROBLEM
}

// Memoization 
public class Solution {
    static Integer dp[][];
    public static int ninjaTraining(int n, int points[][]) {
        dp = new Integer[n][4];
        return dp(points, 0, 0);
    }
    private static int dp(int points[][], int prev, int ind) {
        if(ind >= points.length) return 0;
        if(dp[ind][prev] != null) return dp[ind][prev];
        int max = 0;
        for(int i = 1; i<=points[ind].length; i++) {
            if(i == prev) continue;
            max = Math.max(max, points[ind][i-1] + dp(points, i, ind+1));
        }
        return dp[ind][prev] = max;
    }
}

// Tabulation 
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        int dp[][] = new int[n][3];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][1], points[0][0]);
        for(int i = 1; i<n; i++) {
            for(int prev = 0; prev < 3; prev++) {
                int max = 0;
                for(int j = 0; j<3; j++) {
                    if(j == prev) continue;
                    max = Math.max(max, points[i][j] + dp[i-1][j]);
                }
                dp[i][prev] = max;
            }
        }
        return Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
    }
}