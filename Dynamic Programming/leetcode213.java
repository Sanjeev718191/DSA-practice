public class leetcode213 {
    // link - https://leetcode.com/problems/house-robber-ii/description/
}

class Solution {
    Integer dp[];
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        dp = new Integer[nums.length];
        int r1 = rob(nums, 0, nums.length-1);
        dp = new Integer[nums.length];
        int r2 = rob(nums, 1, nums.length);
        return Math.max(r1, r2);
    }
    private int rob(int nums[], int ind, int n) {
        if(ind >= n) return 0;
        if(dp[ind] != null) return dp[ind];
        return dp[ind] = Math.max(rob(nums, ind+1, n), rob(nums, ind+2, n)+nums[ind]);
    }
}
