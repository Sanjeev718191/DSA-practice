public class leetcode123 {
    // link - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
}

class Solution {
    Integer dp[][][];
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2][3];
        return maxProfit(prices, 0, 0, 2);
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
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length+1][2][3];
        for(int i = prices.length-1; i>=0; i--) {
            for(int buy = 0; buy<2; buy++) {
                for(int t = 1; t<3; t++) {
                    if(buy == 0) {
                        dp[i][buy][t] = Math.max(dp[i+1][0][t], -prices[i]+dp[i+1][1][t]);
                    } else {
                        dp[i][buy][t] = Math.max(dp[i+1][1][t], prices[i]+dp[i+1][0][t-1]);
                    }
                }
            }
        }
        return dp[0][0][2];
    }
}