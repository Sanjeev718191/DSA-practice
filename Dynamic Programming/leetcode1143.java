public class leetcode1143 {
    // link - https://leetcode.com/problems/longest-common-subsequence/description/
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return longestSubsequence(text1, text2, 0, 0);
    }
    private int longestSubsequence(String t1, String t2, int i1, int i2) {
        if(i1 >= t1.length() || i2 >= t2.length()) return 0;
        int max = 0;
        if(t1.charAt(i1) == t2.charAt(i2)) max = longestSubsequence(t1, t2, i1+1, i2+1)+1;
        max = Math.max(max, Math.max(longestSubsequence(t1, t2, i1+1, i2), longestSubsequence(t1, t2, i1, i2+1)));
        return max;
    }
}

class Solution {
    Integer dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new Integer[text1.length()][text2.length()];
        return longestSubsequence(text1, text2, 0, 0);
    }
    private int longestSubsequence(String t1, String t2, int i1, int i2) {
        if(i1 >= t1.length() || i2 >= t2.length()) return 0;
        if(dp[i1][i2] != null) return dp[i1][i2];
        int max = 0;
        if(t1.charAt(i1) == t2.charAt(i2)) max = longestSubsequence(t1, t2, i1+1, i2+1)+1;
        else max = Math.max(longestSubsequence(t1, t2, i1+1, i2), longestSubsequence(t1, t2, i1, i2+1));
        return dp[i1][i2] = max;
    }
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];

        for(int i = 1; i<=text1.length(); i++) {
            for(int j = 1; j<=text2.length(); j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[text1.length()][text2.length()];
    }
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int prev[] = new int[text2.length()+1];
        int curr[] = new int[text2.length()+1];

        for(int i = 1; i<=text1.length(); i++) {
            for(int j = 1; j<=text2.length(); j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) curr[j] = prev[j-1]+1;
                else curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = (int[]) curr.clone();
        }
        return prev[text2.length()];
    }
}