public class PerfectSumProblem {
    // link - https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
}

class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        return count(nums, target, 0);
    }
    private int count(int nums[], int target, int ind) {
        if(target == 0 && ind == nums.length) return 1;
        if(ind >= nums.length || target < 0) return 0;
        return count(nums, target, ind+1) + count(nums, target-nums[ind], ind+1);
    }
}

class Solution {
    // Function to calculate the number of subsets with a given sum
    Integer dp[][];
    public int perfectSum(int[] nums, int target) {
        // code here
        dp = new Integer[nums.length][target+1];
        return count(nums, target, 0);
    }
    private int count(int nums[], int target, int ind) {
        if(target == 0 && ind == nums.length) return 1;
        if(ind >= nums.length || target < 0) return 0;
        if(dp[ind][target] != null) return dp[ind][target];
        return dp[ind][target] = count(nums, target, ind+1) + count(nums, target-nums[ind], ind+1);
    }
}

class Solution {
    public int perfectSum(int[] nums, int target) {
        // code here
        int dp[][] = new int[nums.length][target+1];
        for(int i = 0; i<nums.length; i++) {
            dp[i][0] = 1;
        }
        if(nums[0] <= target) dp[0][nums[0]] = 1;
        for(int i = 1; i<nums.length; i++) {
            for(int j = 1; j<=target; j++) {
                dp[i][j] = dp[i-1][j];
                if(nums[i] <= j) dp[i][j] += dp[i-1][j-nums[i]];
            }
        }
        return dp[nums.length-1][target];
    }
}