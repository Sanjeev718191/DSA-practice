public class leetcode1312 {
    // link - https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
}

class Solution {
    public int minInsertions(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return s.length() - longestCommonSubsequence(s, rev);
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
