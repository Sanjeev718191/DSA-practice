public class leetcode188 {
    // link - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/submissions/1694533322/
}

class Solution {
    Integer dp[][][];
    public int maxProfit(int k, int[] prices) {
        dp = new Integer[prices.length+1][2][k+1];
        return maxProfit(prices, 0, 0, k);
    }
    private int maxProfit(int prices[], int ind, int buy, int t) {
        if(ind >= prices.length || t == 0) return 0;
        if(dp[ind][buy][t] != null) return dp[ind][buy][t];
        if(buy == 0) {
            return dp[ind][buy][t] = 
                Math.max(maxProfit(prices, ind+1, 0, t), -prices[ind] + maxProfit(prices, ind+1, 1, t));
        } else {
            return dp[ind][buy][t] = 
                Math.max(maxProfit(prices, ind+1, 1, t), prices[ind] + maxProfit(prices, ind+1, 0, t-1));
        }
    }
}

class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[prices.length+1][2][k+1];
        for(int ind = prices.length-1; ind>=0; ind--) {
            for(int buy = 0; buy<=1; buy++) {
                for(int t = 1; t<=k; t++) {
                    if(buy == 0) {
                        dp[ind][buy][t] = Math.max(dp[ind+1][0][t], -prices[ind]+dp[ind+1][1][t]);
                    } else {
                        dp[ind][buy][t] = Math.max(dp[ind+1][1][t], prices[ind]+dp[ind+1][0][t-1]);
                    }
                }
            }
        }
        return dp[0][0][k];
    }
}
