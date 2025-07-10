public class leetcode115 {
    // link - https://leetcode.com/problems/distinct-subsequences/description/
}

class Solution {
    public int numDistinct(String s, String t) {
        return count(s, t, s.length(), t.length());
    }
    private int count(String s, String t, int i, int j) {
        if(j == 0) {
            return 1;
        } 
        if(i == 0) return 0;
        int c = count(s, t, i-1, j);
        if(s.charAt(i-1) == t.charAt(j-1)) c += count(s, t, i-1, j-1);
        return c;
    }
}

class Solution {
    Integer dp[][];
    public int numDistinct(String s, String t) {
        dp = new Integer[s.length()+1][t.length()+1];
        return count(s, t, s.length(), t.length());
    }
    private int count(String s, String t, int i, int j) {
        if(j == 0) {
            return 1;
        } 
        if(i == 0) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int c = count(s, t, i-1, j);
        if(s.charAt(i-1) == t.charAt(j-1)) c += count(s, t, i-1, j-1);
        return dp[i][j] = c;
    }
}

class Solution {
    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length()+1][t.length()+1];

        for(int i = 0; i<dp.length; i++) dp[i][0] = 1;
        
        for(int i = 1; i<=s.length(); i++) {
            for(int j = 1; j<=t.length(); j++) {
                dp[i][j] = dp[i-1][j];
                if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] += dp[i-1][j-1];
            }
        }
        return dp[s.length()][t.length()];
    }
}

class Solution {
    public int numDistinct(String s, String t) {
        int prev[] = new int[t.length()+1];
        prev[0] = 1;
        
        for(int i = 1; i<=s.length(); i++) {
            int curr[] = new int[t.length()+1];
            curr[0] = 1;
            for(int j = 1; j<=t.length(); j++) {
                curr[j] = prev[j];
                if(s.charAt(i-1) == t.charAt(j-1)) curr[j] += prev[j-1];
            }
            prev = curr;
        }
        return prev[t.length()];
    }
}