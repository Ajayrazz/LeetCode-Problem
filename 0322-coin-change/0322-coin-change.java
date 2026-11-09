class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for(int target = 0; target <= amount; target++){
            if(target % coins[0] == 0){
                dp[0][target] = target / coins[0];
            }
            else {
                dp[0][target] = (int) Math.pow(10, 9);
            }
        }

        for(int index = 1; index < n; index++){
            for(int target = 1; target <= amount; target++){
                int notTake = dp[index - 1][target];
                int take = (int) Math.pow(10, 9);
                if(coins[index] <= target){
                    take = 1 + dp[index][target - coins[index]];
                }
                //update dp
                dp[index][target] = Math.min(take, notTake);
            }
        }

        return dp[n - 1][amount] >= (int) Math.pow(10, 9) ? -1 : dp[n - 1][amount];
    }
}