class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return Helper(0, -1, nums, dp);
    }

    //Helper Function
    public int Helper(int index, int prevIdx, int[] nums, int[][] dp){
        if(index == nums.length) return 0;
        if(dp[index][prevIdx + 1] != -1) return dp[index][prevIdx + 1];
        int notTake = Helper(index + 1, prevIdx, nums, dp);
        int take = 0;
        if(prevIdx == -1 || nums[index] > nums[prevIdx]){
            take = 1 + Helper(index + 1, index, nums, dp);
        }
        //update dp
        return dp[index][prevIdx + 1] = Math.max(take, notTake);
    }
}