public class matrixChainMultiplication {
    // link - https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
}

class Solution {
    static int matrixMultiplication(int arr[]) {
        return mcm(arr, 1, arr.length-1);
    }
    static int mcm(int arr[], int s, int e) {
        if(s == e) return 0;
        int steps = Integer.MAX_VALUE;
        for(int i = s; i<e; i++) {
            steps = Math.min(steps, arr[s-1]*arr[i]*arr[e] + mcm(arr, s, i) + mcm(arr, i+1, e));
        }
        return steps;
    }
}

class Solution {
    static Integer dp[][];
    static int matrixMultiplication(int arr[]) {
        // code here
        dp = new Integer[arr.length][arr.length];
        return mcm(arr, 1, arr.length-1);
    }
    static int mcm(int arr[], int s, int e) {
        if(s == e) return 0;
        if(dp[s][e] != null) return dp[s][e];
        int steps = Integer.MAX_VALUE;
        for(int i = s; i<e; i++) {
            steps = Math.min(steps, arr[s-1]*arr[i]*arr[e] + mcm(arr, s, i) + mcm(arr, i+1, e));
        }
        return dp[s][e] = steps;
    }
}

class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here
        int dp[][] = new int[arr.length][arr.length];
        for(int a[] : dp) Arrays.fill(a, Integer.MAX_VALUE);
        for(int i = 1; i<arr.length; i++) {
            dp[i][i] = 0;
        }
        for(int i = arr.length-1; i>=1; i--) {
            for(int j = i+1; j<arr.length; j++) {
                for(int k = i; k<j; k++) {
                    dp[i][j] = Math.min(dp[i][j], arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j]);
                }
            }
        }
        return dp[1][arr.length-1];
    }
}