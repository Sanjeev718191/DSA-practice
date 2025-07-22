public class leetcode132 {
    // link - https://leetcode.com/problems/palindrome-partitioning-ii/description/
}

class Solution {
    Integer dp[];
    public int minCut(String s) {
        dp = new Integer[s.length()+1];
        return minCut(s.toCharArray(), 0, s.length())-1;
    }
    private int minCut(char s[], int l, int n) {
        if(l == n) return 0;
        if(dp[l] != null) return dp[l];
        int min = n+1;
        for(int i = l; i<n; i++) {
            if(isPal(s, l, i))
                min = Math.min(min, 1+minCut(s, i+1, n));
        }
        return dp[l] = min;
    }
    private boolean isPal(char s[], int l, int r) {
        while(l<r) {
            if(s[l] != s[r]) return false;
            l++;
            r--;
        }
        return true;
    }
}

class Solution {
    public int minCut(String s) {
        char arr[] = s.toCharArray();
        int n = arr.length;
        int dp[] = new int[n+1];
        for(int l = n-1; l>=0; l--) {
            int min = n+1;
            for(int i = l; i<n; i++) {
                if(isPal(arr, l, i))
                    min = Math.min(min, 1 + dp[i+1]);
            }
            dp[l] = min;
        }
        return dp[0]-1;
    }
    private boolean isPal(char s[], int l, int r) {
        while(l<r) {
            if(s[l] != s[r]) return false;
            l++;
            r--;
        }
        return true;
    }
}