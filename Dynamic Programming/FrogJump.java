public class FrogJump {
    // link - https://www.geeksforgeeks.org/problems/geek-jump/1
}

class Solution {
    int minCost(int[] height) {
        // code here
        return minCost(height, 0);
    }
    int minCost(int height[], int ind) {
        if(height.length-1 <= ind) return 0;
        int v = minCost(height, ind+1) + Math.abs(height[ind]-height[ind+1]);
        if(ind < height.length-2) 
            v = Math.min(v, minCost(height, ind+2) + Math.abs(height[ind]-height[ind+2]));
        return v;
    }
}

class Solution {
    Integer dp[];
    int minCost(int[] height) {
        // code here
        dp = new Integer[height.length];
        return minCost(height, 0);
    }
    int minCost(int height[], int ind) {
        if(height.length-1 <= ind) return 0;
        if(dp[ind] != null) return dp[ind];
        int v = minCost(height, ind+1) + Math.abs(height[ind]-height[ind+1]);
        if(ind < height.length-2) 
            v = Math.min(v, minCost(height, ind+2) + Math.abs(height[ind]-height[ind+2]));
        return dp[ind] = v;
    }
}

class Solution {
    int minCost(int[] height) {
        if(height.length == 1) return 0;
        int dp[] = new int[height.length];
        dp[1] = Math.abs(height[0]-height[1]);
        for(int i = 2; i<height.length; i++) {
            dp[i] = Math.min(dp[i-1]+Math.abs(height[i]-height[i-1]), dp[i-2]+Math.abs(height[i]-height[i-2]));
        }
        return dp[height.length-1];
    }
}

class Solution {
    int minCost(int[] height) {
        if(height.length == 1) return 0;
        int v1 = 0, v2 = Math.abs(height[0]-height[1]);
        for(int i = 2; i<height.length; i++) {
            int curr = Math.min(v2+Math.abs(height[i]-height[i-1]), v1+Math.abs(height[i]-height[i-2]));
            v1 = v2;
            v2 = curr;
        }
        return v2;
    }
}