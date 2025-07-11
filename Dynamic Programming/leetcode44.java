public class leetcode44 {
    // link - https://leetcode.com/problems/wildcard-matching/description/
}

class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, s.length(), p.length());
    }
    private boolean isMatch(String s, String p, int n, int m) {
        if(n == 0 && m == 0) return true;
        if(m == 0) return false;
        // System.out.println(n+" "+m);
        if(p.charAt(m-1) == '*') {
            if(n == 0) return isMatch(s, p, n, m-1);
            return isMatch(s, p, n-1, m) || isMatch(s, p, n-1, m-1) || isMatch(s, p, n, m-1);
        } else if(n != 0 && (p.charAt(m-1) == '?' || s.charAt(n-1) == p.charAt(m-1))) {
            return isMatch(s, p, n-1, m-1);
        } 
        return false;
    }
}

class Solution {
    Boolean dp[][];
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()+1][p.length()+1];
        return isMatch(s, p, s.length(), p.length());
    }
    private boolean isMatch(String s, String p, int n, int m) {
        if(n == 0 && m == 0) return true;
        if(m == 0) return false;
        if(dp[n][m] != null) return dp[n][m];
        
        if(p.charAt(m-1) == '*') {
            if(n == 0) return dp[n][m] = isMatch(s, p, n, m-1);
            return dp[n][m] = isMatch(s, p, n-1, m) || isMatch(s, p, n-1, m-1) || isMatch(s, p, n, m-1);
        } else if(n != 0 && (p.charAt(m-1) == '?' || s.charAt(n-1) == p.charAt(m-1))) {
            return dp[n][m] = isMatch(s, p, n-1, m-1);
        } 
        return dp[n][m] = false;
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i = 0; i<p.length(); i++) {
            if(p.charAt(i) == '*') dp[0][i+1] = dp[0][i]&&true;
            else break;
        }
        for(int i = 1; i<=s.length(); i++) {
            for(int j = 1; j<=p.length(); j++) {
                if(p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i-1][j-1];
                } else if(p.charAt(j-1) == '?' || s.charAt(i-1) == p.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}