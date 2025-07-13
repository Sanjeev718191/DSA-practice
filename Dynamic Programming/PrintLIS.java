public class PrintLIS {
    // link - 
}

class Solution {
    public List<Integer> printLIS(int[] nums) {
        int dp[][] = new int[nums.length][2];
        for(int i = 0; i<nums.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = -1;
        }
        int max = 1;
        int maxInd = 0;
        for(int i = 0; i<nums.length; i++) {
            for(int j = i+1; j<nums.length; j++) {
                if(nums[i] < nums[j]) {
                    if(dp[j][0] < dp[i][0]+1) {
                        dp[j][0] = dp[i][0]+1;
                        dp[j][1] = i;
                    }
                }
            }
            if(max < dp[i][0]) {
                max = dp[i][0];
                maxInd = i;
            }
        }
        List<Integer> ls = new ArrayList<>();
        while(maxInd != -1) {
            ls.add(nums[maxInd]);
            maxInd = dp[maxInd][1];
        }
        Collections.reverse(ls);
        return ls;
    }
}
