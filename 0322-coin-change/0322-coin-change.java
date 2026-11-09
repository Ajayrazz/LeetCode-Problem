class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        int ans = solve(n - 1, amount, coins, dp);
        if(ans >= (int) Math.pow(10, 9)) return -1;
        return ans;
    }

    //solve function
    public int solve(int index, int amount, int[] coins, int[][] dp){
        if(index == 0){
            if(amount % coins[index] == 0) return amount / coins[index];
            return (int) Math.pow(10, 9);
        }

        if(dp[index][amount] != -1) return dp[index][amount];

        int notTake = solve(index - 1, amount, coins, dp);
        int take = (int) Math.pow(10, 9);
        if(coins[index] <= amount){
            take = 1 + solve(index, amount - coins[index], coins, dp);
        }

        //update dp
        return dp[index][amount] = Math.min(take, notTake);
    }
}