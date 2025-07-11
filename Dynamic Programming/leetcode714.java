public class leetcode714 {
    // link - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
}

class Solution {
    Integer dp[][];
    int fee;
    public int maxProfit(int[] prices, int fee) {
        dp = new Integer[prices.length][2];
        this.fee = fee;
        return maxProfit(prices, 0, 0);
    }
    private int maxProfit(int prices[], int ind, int buy) {
        if(ind >= prices.length) return 0;
        if(dp[ind][buy] != null) return dp[ind][buy];
        if(buy == 0) {
            return dp[ind][buy] = Math.max(maxProfit(prices, ind+1, 0), -prices[ind] + maxProfit(prices, ind+1, 1));
        } else {
            return dp[ind][buy] = Math.max(maxProfit(prices, ind+1, 1), prices[ind] - this.fee + maxProfit(prices, ind+1, 0));
        }
    }
}

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length+1][2];
        for(int i = prices.length-1; i>=0; i--) {
            for(int j = 0; j<2; j++) {
                if(j == 0) {
                    dp[i][j] = Math.max(dp[i+1][0], -prices[i] + dp[i+1][1]);
                } else {
                    dp[i][j] = Math.max(dp[i+1][1], prices[i] + dp[i+1][0] - fee);
                }
            }
        }
        return dp[0][0];
    }
}