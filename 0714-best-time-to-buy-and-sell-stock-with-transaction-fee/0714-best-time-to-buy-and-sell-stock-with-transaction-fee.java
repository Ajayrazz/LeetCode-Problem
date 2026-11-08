class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for(int index = n - 1; index >= 0; index--){
            for(int buy = 0; buy <= 1; buy++){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max(dp[index + 1][1], -prices[index] + dp[index + 1][0]);
                }
                else {
                    profit = Math.max(dp[index + 1][0], prices[index] - fee + dp[index + 1][1]);
                }
                //update dp
                dp[index][buy] = profit;
            }
        }

        return dp[0][1];
    }
}