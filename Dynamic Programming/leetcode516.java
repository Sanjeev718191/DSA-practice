public class leetcode516 {
    // link - https://leetcode.com/problems/longest-palindromic-subsequence/description/
}

class Solution {
    public int longestPalindromeSubseq(String s) {
        return longestPal(s, "", 0);
    }
    private int longestPal(String s, String curr, int ind) {
        if(ind >= s.length()) {
            if(isPalindrom(curr)) return curr.length();
            return 0;
        }
        return Math.max(longestPal(s, curr+s.charAt(ind), ind+1), longestPal(s, curr, ind+1));
    }
    private boolean isPalindrom(String s) {
        if(s.length() < 2) return true;
        int l = 0, r = s.length()-1;
        while(l<r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev = "";
        for(char i : s.toCharArray()) rev = i+rev;
        return longestCommonSubsequence(s, rev);
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