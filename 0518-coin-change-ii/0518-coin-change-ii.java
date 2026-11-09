class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        
        for(int target = 0; target <= amount; target++){
            if(target % coins[0] == 0){
                dp[0][target] = 1;
            }
            else {
                dp[0][target] = 0;
            }
        }

        for(int index = 1; index < n; index++){
            for(int target = 0; target <= amount; target++){
                int notTake = dp[index - 1][target];
                int take = 0;
                if(coins[index] <= target){
                    take = dp[index][target - coins[index]];
                }
                //update dp
                dp[index][target] = take + notTake;
            }
        }

        return dp[n - 1][amount];
    }
}