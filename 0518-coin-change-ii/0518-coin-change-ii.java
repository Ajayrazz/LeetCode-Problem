class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(n - 1, amount, coins, dp);
    }

    //solve function
    public int solve(int index, int amount, int[] coins, int[][] dp){
        if(index == 0){
            if(amount % coins[index] == 0) return 1;
            return 0;
        }

        if(dp[index][amount] != -1) return dp[index][amount];

        int notTake = solve(index - 1, amount, coins, dp);
        int take = 0;
        if(coins[index] <= amount){
            take = solve(index, amount - coins[index], coins, dp);
        }

        //update dp
        return dp[index][amount] = take + notTake;
    }
}