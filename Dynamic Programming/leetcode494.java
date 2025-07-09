public class leetcode494 {
    // link - https://leetcode.com/problems/target-sum/description/
}

class Solution {
    Integer dp[][];
    public int findTargetSumWays(int[] nums, int target) {
        dp = new Integer[nums.length][3000];
        return findWays(nums, 0, target);
    }
    private int findWays(int nums[], int ind, int target) {
        if(target == 0 && ind == nums.length) return 1;
        if(ind >= nums.length) return 0;
        if(dp[ind][target+1000] != null) return dp[ind][target+1000];
        return dp[ind][target+1000] = findWays(nums, ind+1, target-nums[ind]) + findWays(nums, ind+1, target+nums[ind]);
    }
}
