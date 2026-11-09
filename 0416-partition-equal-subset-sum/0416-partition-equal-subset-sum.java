class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 == 1) return false;
        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return canPartitionUtil(nums.length - 1, target, nums, dp);
    }

    //canPartitionUtil function
    public boolean canPartitionUtil(int index, int target, int[] nums, int[][] dp){
        if(target == 0) return true;
        if(index == 0) return nums[index] == target;
        if(dp[index][target] != -1) return dp[index][target] == 0 ? false : true;
        boolean notTake = canPartitionUtil(index - 1, target, nums, dp);
        boolean take = false;
        if(nums[index] <= target){
            take = canPartitionUtil(index - 1, target - nums[index], nums, dp);
        }
        dp[index][target] = take || notTake ? 1 : 0;
        return take || notTake;
    }
}