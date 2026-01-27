public class leetcode1547 {
    // link - https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
}

class Solution {
    Integer dp[][];
    public int minCost(int n, int[] cuts) {
        int l = cuts.length;
        int arr[] = new int[l+2];
        arr[l] = 0;
        arr[l+1] = n;
        for(int i = 0; i<l; i++) arr[i] = cuts[i];
        Arrays.sort(arr);
        dp = new Integer[l+2][l+2];
        return minCost(arr, 0, l+1);
    }
    private int minCost(int cuts[], int i, int j) {
        if(i == j) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int len = Integer.MAX_VALUE;
        for(int k = i+1; k<=j-1; k++) {
            len = Math.min(len, cuts[j]-cuts[i] + minCost(cuts, i, k) + minCost(cuts, k, j));
        }
        if(len == Integer.MAX_VALUE) len = 0;
        return dp[i][j] = len;
        // return len;
    }
}

class Solution {
    public int minCost(int n, int[] cuts) {
        int l = cuts.length;
        int arr[] = new int[l+2];
        arr[l] = 0;
        arr[l+1] = n;
        for(int i = 0; i<l; i++) arr[i] = cuts[i];
        Arrays.sort(arr);
        int dp[][] = new int[l+2][l+2];
        for(int i = 0; i<=l+1; i++) dp[i][i] = 0;
        for(int i = l+1; i>=0; i--) {
            for(int j = i+1; j<=l+1; j++) {
                int cost = Integer.MAX_VALUE;
                for(int k = i+1; k<=j-1; k++) {
                    cost = Math.min(cost, arr[j]-arr[i] + dp[i][k] + dp[k][j]);
                }
                if(cost == Integer.MAX_VALUE) cost = 0;
                dp[i][j] = cost;
            }
        }
        return dp[0][l+1];
    }
}
