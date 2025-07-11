public class leetcode121 {
    // link - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
}

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for(int num : prices) {
            if(min >= num) min = num;
            else profit = Math.max(profit, num - min); 
        }
        return profit;
    }
}