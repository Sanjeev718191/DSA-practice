public class leetcode416 {
    // link - https://leetcode.com/problems/partition-equal-subset-sum/description/
}

class Solution {
    Boolean dp[][];
    int sum;
    public boolean canPartition(int[] nums) {
        sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum%2 == 1) return false;
        sum /= 2; 
        dp = new Boolean[nums.length][sum+1];
        return canPartition(nums, 0, 0);
    }
    private boolean canPartition(int nums[], int ind, int s1) {
        if(s1 == sum) return true;
        if(s1 > sum || ind >= nums.length) return false;

        if(dp[ind][s1] != null) return dp[ind][s1];
        if(canPartition(nums, ind+1, s1+nums[ind]) || canPartition(nums, ind+1, s1)) 
            return dp[ind][s1] = true;
        return dp[ind][s1] = false;
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum%2 == 1) return false;
        sum /= 2; 
        boolean dp[][] = new boolean[nums.length][sum+1];
        for(int i = 0; i<nums.length; i++) dp[i][0] = true;
        if(nums[0] <= sum) dp[0][nums[0]] = true;
        for(int i = 1; i<nums.length; i++) {
            for(int j = 1; j<=sum; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= nums[i]) dp[i][j] = dp[i][j] || dp[i-1][j-nums[i]];
            }
        }
        return dp[nums.length-1][sum];
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum%2 == 1) return false;
        sum /= 2; 
        boolean curr[] = new boolean[sum+1];
        curr[0] = true;
        if(nums[0] <= sum) curr[nums[0]] = true;
        for(int i = 1; i<nums.length; i++) {
            boolean temp[] = new boolean[sum+1];
            temp[0] = true;
            for(int j = 1; j<=sum; j++) {
                temp[j] = curr[j];
                if(j >= nums[i]) temp[j] = temp[j] || curr[j-nums[i]];
            }
            curr = temp;
        }
        return curr[sum];
    }
}
