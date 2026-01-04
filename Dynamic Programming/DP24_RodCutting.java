public class RodCutting {
    // link - https://www.geeksforgeeks.org/problems/rod-cutting0840/1
}

class Solution {
    public int cutRod(int[] price) {
        // code here
        return cutRod(price, price.length);
    }
    public int cutRod(int price[], int target) {
        if(target == 0) return 0;
        int max = 0;
        for(int i = 1; i<=target; i++) {
            max = Math.max(max, cutRod(price, target-i)+price[i-1]);
        }
        return max;
    }    
}

class Solution {
    Integer dp[];
    public int cutRod(int[] price) {
        // code here
        dp = new Integer[price.length+1];
        return cutRod(price, price.length);
    }
    public int cutRod(int price[], int target) {
        if(target == 0) return 0;
        if(dp[target] != null) return dp[target];
        int max = 0;
        for(int i = 1; i<=target; i++) {
            max = Math.max(max, cutRod(price, target-i)+price[i-1]);
        }
        return dp[target] = max;
    }    
}

class Solution {
    public int cutRod(int[] price) {
        // code here
        int dp[] = new int[price.length+1];
        for(int i = 1; i<=price.length; i++) {
            for(int j = 0; j<i; j++) {
                dp[i] = Math.max(dp[i], dp[i-(j+1)]+price[j]);
            }
        }
        return dp[price.length];
    }
}
