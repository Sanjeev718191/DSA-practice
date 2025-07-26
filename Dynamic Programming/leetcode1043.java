public class leetcode1043 {
    // link = https://leetcode.com/problems/partition-array-for-maximum-sum/description/
}

class Solution {
    Integer dp[];
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length+1];
        for(int ind = arr.length-1; ind >= 0; ind--) {
            int sum = 0;
            int max = 0;
            for(int i = 0; i<k && i+ind<arr.length; i++) {
                max = Math.max(max, arr[ind+i]);
                sum = Math.max(sum, max*(i+1)+dp[ind+i+1]);
            }
            dp[ind] = sum;
        }
        return dp[0];
    }
    private int maxSum(int arr[], int ind, int k) {
        if(ind >= arr.length) return 0;
        if(dp[ind] != null) return dp[ind];
        int sum = 0;
        int max = 0;
        for(int i = 0; i<k && i+ind<arr.length; i++) {
            max = Math.max(max, arr[ind+i]);
            sum = Math.max(sum, max*(i+1)+maxSum(arr, ind+i+1, k));
        }
        return dp[ind] = sum;
    }
}

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length+1];
        for(int ind = arr.length-1; ind >= 0; ind--) {
            int sum = 0;
            int max = 0;
            for(int i = 0; i<k && i+ind<arr.length; i++) {
                max = Math.max(max, arr[ind+i]);
                sum = Math.max(sum, max*(i+1)+dp[ind+i+1]);
            }
            dp[ind] = sum;
        }
        return dp[0];
    }
}