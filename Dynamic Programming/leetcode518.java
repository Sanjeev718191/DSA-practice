public class leetcode518 {
    // https://leetcode.com/problems/coin-change-ii/description/
}

class Solution {
    public int change(int amount, int[] coins) {
        return countWays(coins, 0, amount);
    }
    private int countWays(int coins[], int ind, int amount) {
        if(amount == 0) return 1;
        if(ind >= coins.length || amount < 0) return 0;
        int notTake = countWays(coins, ind+1, amount);
        int take = countWays(coins, ind, amount-coins[ind]);
        return take + notTake;
    }
}

class Solution {
    Integer dp[][];
    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length][amount+1];
        return countWays(coins, 0, amount);
    }
    private int countWays(int coins[], int ind, int amount) {
        if(amount == 0) return 1;
        if(ind >= coins.length || amount < 0) return 0;
        if(dp[ind][amount] != null) return dp[ind][amount];
        int notTake = countWays(coins, ind+1, amount);
        int take = 0;
        if(coins[ind] <= amount) take = countWays(coins, ind, amount-coins[ind]);
        return dp[ind][amount] = take + notTake;
    }
}

class Solution {
    Integer dp[][];
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];
        for(int i = 0; i<coins.length; i++) dp[i][0] = 1;
        for(int i = 1; i<=amount; i++) {
            for(int j = 0; j<coins.length; j++) {
                if(j != 0) dp[j][i] = dp[j-1][i];
                if(i >= coins[j]) dp[j][i] += dp[j][i-coins[j]];
            }
        }
        return dp[coins.length-1][amount];
    }
    private int countWays(int coins[], int ind, int amount) {
        if(amount == 0) return 1;
        if(ind >= coins.length || amount < 0) return 0;
        if(dp[ind][amount] != null) return dp[ind][amount];
        int notTake = countWays(coins, ind+1, amount);
        int take = 0;
        if(coins[ind] <= amount) take = countWays(coins, ind, amount-coins[ind]);
        return dp[ind][amount] = take + notTake;
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        int dp[] = new int[amount+1];
        dp[0] = 1;
        for(int i = 0; i<coins.length; i++) {
            for(int j = coins[i]; j<=amount; j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
