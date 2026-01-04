public class Bitonic {
    // link - https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
}

class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for(int i = 0; i<nums.length; i++) {
            for(int j = i+1; j<nums.length; j++) {
                if(nums[i] < nums[j]) {
                    dp1[j] = Math.max(dp1[i]+1, dp1[j]);
                }
            }
        }
        if(dp1[n-1] == n) return 0;
        
        for(int i = nums.length-1; i>=0; i--) {
            for(int j = nums.length-1; j>i; j--) {
                if(nums[i] > nums[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j]+1);
                }
            }
        }
        if(dp2[0] == n) return 0;
        
        int max = 0;
        for(int i = 0; i<n; i++) {
            if(dp1[i] == 1 || dp2[i] == 1) continue;
            max = Math.max(max, dp1[i]+dp2[i]-1);
        }
        return max;
    }
}
