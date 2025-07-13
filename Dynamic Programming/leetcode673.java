public class leetcode673 {
    // link - https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
}

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][2];
        for(int i[] : dp) {
            i[0] = 1;
            i[1] = 1;
        }
        int max = 1;
        for(int i = 0; i<nums.length; i++) {
            for(int j = i+1; j<nums.length; j++) {
                if(nums[i] < nums[j]) {
                    if(dp[i][0]+1 > dp[j][0]) {
                        dp[j][0] = dp[i][0]+1;
                        dp[j][1] = dp[i][1];
                    } else if(dp[i][0]+1 == dp[j][0]) {
                        dp[j][1] += dp[i][1];
                    }
                }
            }
            max = Math.max(dp[i][0], max);
        }
        int count = 0;
        for(int i[] : dp) {
            count += i[0] == max ? i[1] : 0;
        }
        return count;
    }
}