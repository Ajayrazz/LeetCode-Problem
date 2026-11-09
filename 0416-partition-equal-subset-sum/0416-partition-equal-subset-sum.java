class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 == 1) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        
        for(int i = 0; i < nums.length; i++){
            dp[i][0] = true;
        }

        if(nums[0] <= target) dp[0][nums[0]] = true;

        for(int index = 1; index < nums.length; index++){
            for(int tar = 1; tar <= target; tar++){
                boolean notTake = dp[index - 1][tar];
                boolean take = false;
                if(nums[index] <= tar){
                    take = dp[index - 1][tar - nums[index]];
                }
                //update dp
                dp[index][tar] = take || notTake;
            }
        }

        return dp[nums.length - 1][target];
    }
}