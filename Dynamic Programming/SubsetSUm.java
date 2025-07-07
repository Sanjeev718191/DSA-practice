public class SubsetSUm {
    // link - https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
}

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        return isSubsetSum(arr, sum, 0);
    }
    static boolean isSubsetSum(int arr[], int sum, int ind) {
        if(sum == 0) return true;
        if(ind == arr.length) return false;
        boolean notTake = isSubsetSum(arr, sum, ind+1);
        boolean take = false;
        if(sum >= arr[ind]) take = isSubsetSum(arr, sum-arr[ind], ind+1);
        return notTake || take;
    }
}

class Solution {
    static Boolean dp[][];
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        dp = new Boolean[arr.length][sum+1];
        return isSubsetSum(arr, sum, 0);
    }
    static boolean isSubsetSum(int arr[], int sum, int ind) {
        if(sum == 0) return true;
        if(ind == arr.length) return false;
        if(dp[ind][sum] != null) return dp[ind][sum];
        boolean notTake = isSubsetSum(arr, sum, ind+1);
        boolean take = false;
        if(sum >= arr[ind]) take = isSubsetSum(arr, sum-arr[ind], ind+1);
        return dp[ind][sum] = notTake || take;
    }
}

class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        if(sum == 0) return true;
        boolean dp[][] = new boolean[arr.length][sum+1];
        for(int i = 0; i<arr.length; i++) dp[i][0] = true;
        if(arr[0] <= sum) dp[0][arr[0]] = true;
        for(int i = 1; i<arr.length; i++) {
            for(int j = 1; j<=sum; j++) {
                dp[i][j] = dp[i-1][j];
                if(arr[i] > j) continue;
                dp[i][j] = dp[i][j] || dp[i-1][j-arr[i]];
            }
        }
        return dp[arr.length-1][sum];
    }
}
