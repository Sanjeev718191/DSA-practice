public class leetcode198 {
    // link - https://leetcode.com/problems/house-robber/description/
}

class Solution {
    public int rob(int[] nums) {
        return rob(nums, 0);
    }
    private int rob(int nums[], int ind) {
        if(ind >= nums.length) return 0;
        return Math.max(rob(nums, ind+1), rob(nums, ind+2)+nums[ind]);
    }
}

class Solution {
    Integer dp[];
    public int rob(int[] nums) {
        dp = new Integer[nums.length];
        return rob(nums, 0);
    }
    private int rob(int nums[], int ind) {
        if(ind >= nums.length) return 0;
        if(dp[ind] != null) return dp[ind];
        return dp[ind] = Math.max(rob(nums, ind+1), rob(nums, ind+2)+nums[ind]);
    }
}

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for(int i = 2; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int p1 = nums[0], p2 = Math.max(nums[0], nums[1]);
        int curr = p2;
        for(int i = 2; i<nums.length; i++) {
            curr = Math.max(p2, p1+nums[i]);
            p1 = p2;
            p2 = curr;
        }
        return curr;
    }
}
