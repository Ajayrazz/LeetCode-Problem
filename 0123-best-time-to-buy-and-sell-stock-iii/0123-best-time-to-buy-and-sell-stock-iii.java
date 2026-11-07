class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for(int index = n - 1; index >= 0; index--){
            for(int buy = 0; buy <= 1; buy++){
                for(int capacity = 1; capacity <= 2; capacity++){
                    int profit = 0;
                    if(buy == 1){
                        profit = Math.max(dp[index + 1][1][capacity], -prices[index] + dp[index + 1][0][capacity]);
                    }
                    else {
                        profit = Math.max(dp[index + 1][0][capacity], prices[index] + dp[index + 1][1][capacity - 1]);
                    }
                    //update dp
                    dp[index][buy][capacity] = profit;
                }
            }
        }

        return dp[0][1][2];
    }
}