public class leetcode72 {
    // link - https://leetcode.com/problems/edit-distance/description/
}

class Solution {
    public int minDistance(String word1, String word2) {
        return minDis(word1, word2, word1.length(), word2.length());
    }
    private int minDis(String w1, String w2, int i, int j) {
        if(i == 0) return j;
        if(j == 0) return i;
        int min = Integer.MAX_VALUE;
        if(w1.charAt(i-1) == w2.charAt(j-1)) min = Math.min(min, minDis(w1, w2, i-1, j-1));
        else min = Math.min(min, Math.min(minDis(w1, w2, i, j-1), Math.min(minDis(w1, w2, i-1, j), minDis(w1, w2, i-1, j-1)))+1);
        return min;
    }
}

class Solution {
    Integer dp[][];
    public int minDistance(String word1, String word2) {
        dp = new Integer[word1.length()+1][word2.length()+1];
        return minDis(word1, word2, word1.length(), word2.length());
    }
    private int minDis(String w1, String w2, int i, int j) {
        if(i == 0) return j;
        if(j == 0) return i;
        if(dp[i][j] != null) return dp[i][j];
        int min = Integer.MAX_VALUE;
        if(w1.charAt(i-1) == w2.charAt(j-1)) min = Math.min(min, minDis(w1, w2, i-1, j-1));
        else min = Math.min(min, Math.min(minDis(w1, w2, i, j-1), Math.min(minDis(w1, w2, i-1, j), minDis(w1, w2, i-1, j-1)))+1);
        return dp[i][j] = min;
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i<=word1.length(); i++) {
            for(int j = 0; j<=word2.length(); j++) {
                if(i == 0) dp[i][j] = j;
                else if(j == 0) dp[i][j] = i;
                else {
                    if(word1.charAt(i-1) == word2.charAt(j-1)) 
                        dp[i][j] = dp[i-1][j-1];
                    else dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}