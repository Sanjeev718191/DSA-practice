public class leetcode322 {
    // link - https://leetcode.com/problems/coin-change/description/
}

class Solution {
    Integer dp[][];
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[coins.length][amount+1];
        int res = minCoins(coins, 0, amount);
        return res != Integer.MAX_VALUE? res : -1;
    }
    private int minCoins(int coins[], int ind, int amount) {
        if(amount == 0) return 0;
        if(ind >= coins.length) return Integer.MAX_VALUE;
        if(dp[ind][amount] != null) return dp[ind][amount];
        int notTake = minCoins(coins, ind+1, amount);
        int take = Integer.MAX_VALUE;
        if(amount >= coins[ind]) take = minCoins(coins, ind, amount-coins[ind]);
        if(take != Integer.MAX_VALUE) take += 1;
        return dp[ind][amount] = Math.min(take, notTake);
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[amount+1][coins.length];
        for(int arr[] : dp) Arrays.fill(arr, Integer.MAX_VALUE);
        for(int i = 0; i<coins.length; i++) dp[0][i] = 0;
        if(amount >= coins[0]) dp[coins[0]][0] = 1;
        for(int i = 1; i<=amount; i++) {
            for(int j = 0; j<coins.length; j++) {
                if(j != 0) dp[i][j] = dp[i][j-1];
                if(i >= coins[j]) dp[i][j] = Math.min(dp[i][j], dp[i-coins[j]][j] != Integer.MAX_VALUE? dp[i-coins[j]][j]+1 : Integer.MAX_VALUE);
            }
        }
        return dp[amount][coins.length-1] != Integer.MAX_VALUE ? dp[amount][coins.length-1] : -1;
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        dp[0] = 0;
        for(int i = 1; i<=amount; i++) {
            dp[i] = amount+1;
            for(int j = 0; j<coins.length; j++) {
                if(i >= coins[j]) 
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
            }
        }
        return dp[amount] <= amount ? dp[amount] : -1;
    }
}
