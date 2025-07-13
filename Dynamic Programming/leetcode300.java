public class leetcode300 {
    // link - https://leetcode.com/problems/longest-increasing-subsequence/description/
}

class Solution {
    Integer dp[];
    public int lengthOfLIS(int[] nums) {
        dp = new Integer[nums.length];
        int max = 1;
        for(int i = 0; i<nums.length; i++) {
            max = Math.max(max, lis(nums, i));
        }
        return max;
    }
    private int lis(int nums[], int curr) {
        if(curr >= nums.length) return 0;
        if(dp[curr] != null) return dp[curr];
        int max = 1;
        for(int i = curr+1; i<nums.length; i++)
            if(nums[curr] < nums[i]) max = Math.max(max, lis(nums, i)+1);
        return dp[curr] = max;
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 0; i<nums.length; i++) {
            for(int j = i+1; j<nums.length; j++) {
                if(nums[i] < nums[j]) dp[j] = Math.max(dp[j], dp[i]+1);
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }
}