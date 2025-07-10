public class leetcode583 {
    // link - https://leetcode.com/problems/delete-operation-for-two-strings/description/
}

class Solution {
    public int minDistance(String word1, String word2) {
        int len = longestCommonSubsequence(word1, word2);
        return word1.length() + word2.length() - (2*len);
    }
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