public class PartitionWithDIff {
    // link - https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
}

class Solution {
    int countPartitions(int[] arr, int d) {
        // code here
        int sum = 0;
        for(int i : arr) sum += i;
        if(sum-d < 0 || (sum-d)%2 == 1) return 0;
        return count(arr, 0, (sum-d)/2);
    }
    int count(int arr[], int ind, int target) {
        if(ind == arr.length) {
            if(target == 0) return 1;
            return 0;
        }
        return count(arr, ind+1, target) + count(arr, ind+1, target-arr[ind]);
    }
}

class Solution {
    Integer dp[][];
    int countPartitions(int[] arr, int d) {
        // code here
        int sum = 0;
        for(int i : arr) sum += i;
        if(sum-d < 0 || (sum-d)%2 == 1) return 0;
        dp = new Integer[arr.length][(sum-d)/2 + 1];
        return count(arr, 0, (sum-d)/2);
    }
    int count(int arr[], int ind, int target) {
        if(ind == arr.length) {
            if(target == 0) return 1;
            return 0;
        } 
        if(target < 0) return 0;
        if(dp[ind][target] != null) return dp[ind][target];
        return dp[ind][target] = count(arr, ind+1, target) + count(arr, ind+1, target-arr[ind]);
    }
}

class Solution {
    int countPartitions(int[] arr, int d) {
        // code here
        int sum = 0;
        for(int i : arr) sum += i;
        if(sum-d < 0 || (sum-d)%2 == 1) return 0;
        int dp[][] = new int[arr.length][(sum-d)/2 + 1];
        
        if(arr[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;
        if(arr[0] != 0 && arr[0] < dp[0].length) dp[0][arr[0]] = 1;
        
        for(int i = 1; i<arr.length; i++) {
            for(int j = 0; j<dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= arr[i])  dp[i][j] += dp[i][j-arr[i]];
            }
        }
        return dp[arr.length-1][(sum-d)/2];
    }
}