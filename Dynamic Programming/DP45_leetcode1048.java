public class leetcode1048 {
    // link - https://leetcode.com/problems/longest-string-chain/description/
}

class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int dp[] = new int[words.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 0; i<words.length; i++) {
            for(int j = i+1; j<words.length; j++) {
                if(checkStr(words[i], words[j])) {
                    if(dp[i]+1 > dp[j]) {
                        dp[j] = dp[i]+1;
                    } 
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
    private boolean checkStr(String s1, String s2) {
        if(s1.length()+1 != s2.length()) return false;
        boolean flag = false;
        int i = 0, j = 0;
        while(i<s1.length() && j<s2.length()) {
            if(s1.charAt(i) != s2.charAt(j)) {
                if(flag) return false;
                flag = true;
                j++;
            } else {
                i++; j++;
            }
        }
        if(!flag && j<s2.length()) flag = true;
        return flag;
    }
} 
