public class KnapsackWithDuplicates {
    // link - https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
}

class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        return fill(val, wt, capacity, 0);
    }
    static int fill(int val[], int wt[], int cap, int ind) {
        if(ind >= val.length || cap == 0) return 0;
        if(cap < 0) return Integer.MIN_VALUE;
        return Math.max(fill(val, wt, cap, ind+1), fill(val, wt, cap-wt[ind], ind)+val[ind]);
    }
}

class Solution {
    static Integer dp[][];
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        dp = new Integer[val.length][capacity+1];
        return fill(val, wt, capacity, 0);
    }
    static int fill(int val[], int wt[], int cap, int ind) {
        if(ind >= val.length || cap == 0) return 0;
        if(cap < 0) return Integer.MIN_VALUE;
        if(dp[ind][cap] != null) return dp[ind][cap];
        return dp[ind][cap] = Math.max(fill(val, wt, cap, ind+1), fill(val, wt, cap-wt[ind], ind)+val[ind]);
    }
}

class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int dp[][] = new int[val.length][capacity+1];
        // dp[0][wt[0]] = val[0];
        for(int i = 0; i<val.length; i++) {
            for(int j = 1; j<=capacity; j++) {
                if(i != 0) dp[i][j] = dp[i-1][j];
                if(wt[i] <= j) dp[i][j] = Math.max(dp[i][j], dp[i][j-wt[i]]+val[i]);
            }
        }
        return dp[val.length-1][capacity];
    }
}
