class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums) sum += num;
        if((sum - target) < 0) return 0;
        if((sum - target) % 2 == 1) return 0;
        int newTarget = (sum - target) / 2;
        int[][] dp = new int[n][newTarget + 1];
        
        for(int tar = 0; tar <= newTarget; tar++){
            if(tar == 0 && nums[0] == tar){
                dp[0][tar] = 2;
            }
            else if(tar == 0 || nums[0] == tar){
                dp[0][tar] = 1;
            }
            else {
                dp[0][tar] = 0;
            }
        }

        for(int index = 1; index < nums.length; index++){
            for(int tar = 0; tar <= newTarget; tar++){
                int notTake = dp[index - 1][tar];
                int take = 0;
                if(nums[index] <= tar){
                    take = dp[index - 1][tar - nums[index]];
                }
                //update dp
                dp[index][tar] = take + notTake;
            }
        }

        return dp[n - 1][newTarget];
    }
}