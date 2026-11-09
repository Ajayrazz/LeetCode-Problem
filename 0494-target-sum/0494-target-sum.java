class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums) sum += num;
        if((sum - target) < 0) return 0;
        if((sum - target) % 2 == 1) return 0;
        int newTarget = (sum - target) / 2;
        int[][] dp = new int[n][newTarget + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(n - 1, newTarget, nums, dp);
    }

    //solve function
    public int solve(int index, int target, int[] nums, int[][] dp){
        if(index == 0){
            if(target == 0 && nums[index] == 0) return 2;
            if(target == 0 || nums[index] == target) return 1;
            return 0;
        }

        if(dp[index][target] != -1) return dp[index][target];

        int notTake = solve(index - 1, target, nums, dp);
        int take = 0;
        if(nums[index] <= target){
            take = solve(index - 1, target - nums[index], nums, dp);
        }
        //update dp
        return dp[index][target] = take + notTake;
    }
}