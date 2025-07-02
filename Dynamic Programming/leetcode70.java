public class leetcode70 {
    // link - https://leetcode.com/problems/climbing-stairs/description/
}

// recursion
class Solution {
    public int climbStairs(int n) {
        return countWays(n);
    }
    private int countWays(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        return countWays(n-1) + countWays(n-2);
    }
}

// memoization 
class Solution {
    int dp[];
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return countWays(n);
    }
    private int countWays(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(dp[n] != -1) return dp[n];
        return dp[n] = countWays(n-1) + countWays(n-2);
    }
}

// tabulation
class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<=n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}

// space optimization
class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int prev = 1, prev2 = 2;
        int curr = 0;
        for(int i = 3; i<=n; i++) {
            curr = prev+prev2;
            prev = prev2;
            prev2 = curr;
        }
        return curr;
    }
}