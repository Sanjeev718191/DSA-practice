public class leetcode1092 {
    // link - https://leetcode.com/problems/shortest-common-supersequence/description/
}

class Solution {
    public String shortestCommonSupersequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];

        for(int i = 1; i<=text1.length(); i++) {
            for(int j = 1; j<=text2.length(); j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        int i = text1.length();
        int j = text2.length();

        String s = "";
        while(i>0 && j>0) {
            if(text1.charAt(i-1) == text2.charAt(j-1)) {
                s = text1.charAt(i-1)+s;
                i--;
                j--;
            } else if(dp[i-1][j] > dp[i][j-1]) {
                s = text1.charAt(i-1)+s;
                i--;
            } else {
                s = text2.charAt(j-1)+s;
                j--;
            }
        }
        while(i>0) {
            s = text1.charAt(i-1)+s;
            i--;
        }
        while(j>0) {
            s = text2.charAt(j-1)+s;
            j--;
        }
        return s;
    }
}