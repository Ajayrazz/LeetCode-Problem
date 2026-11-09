class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return maxProfitUtil(0, 1, prices, dp);
    }

    //maxProfitUtil function
    public int maxProfitUtil(int index, int buy, int[] prices, int[][] dp){
        if(index >= prices.length) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        if(buy == 1){
            profit = Math.max(maxProfitUtil(index + 1, 1, prices, dp), -prices[index] + maxProfitUtil(index + 1, 0, prices, dp));
        }
        else {
            profit = Math.max(maxProfitUtil(index + 1, 0, prices, dp), prices[index] + maxProfitUtil(index + 2, 1, prices, dp));
        }
        //update dp
        return dp[index][buy] = profit;
    }
}