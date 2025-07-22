public class leetcode312 {
    // link - https://leetcode.com/problems/burst-balloons/description/
}

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i = 1; i<=n; i++) arr[i] = nums[i-1];
        return maxCoins(arr, 1, n);
    }
    private int maxCoins(int nums[], int s, int e) {
        if(s > e) return 0;
        int coins = 0;
        for(int i = s; i<=e; i++) {
            int l = nums[s-1];
            int r = nums[e+1];
            coins = Math.max(coins, l*nums[i]*r + maxCoins(nums, s, i-1) + maxCoins(nums, i+1, e));
        }
        return coins;
    }
}

class Solution {
    Integer dp[][];
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i = 1; i<=n; i++) arr[i] = nums[i-1];
        dp = new Integer[n+2][n+2];
        return maxCoins(arr, 1, n);
    }
    private int maxCoins(int nums[], int s, int e) {
        if(s > e) return 0;
        if(dp[s][e] != null) return dp[s][e];
        int coins = 0;
        for(int i = s; i<=e; i++) {
            int l = nums[s-1];
            int r = nums[e+1];
            coins = Math.max(coins, l*nums[i]*r + maxCoins(nums, s, i-1) + maxCoins(nums, i+1, e));
        }
        return dp[s][e] = coins;
    }
}

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i = 1; i<=n; i++) arr[i] = nums[i-1];
        int dp[][] = new int[n+2][n+2];

        for(int s = n; s>=1; s--) {
            for(int e = s; e<=n; e++) {
                int coins = 0;
                for(int i = s; i<=e; i++) {
                    coins = Math.max(coins, arr[s-1]*arr[i]*arr[e+1] + dp[s][i-1] + dp[i+1][e]);
                }
                dp[s][e] = coins;
            }
        }

        return dp[1][n];
    }
}