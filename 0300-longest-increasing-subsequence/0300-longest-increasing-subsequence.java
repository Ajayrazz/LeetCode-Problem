class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for(int index = n - 1; index >= 0; index--){
            for(int prevIdx = -1; prevIdx < index; prevIdx++){
                int notTake = dp[index + 1][prevIdx + 1];
                int take = 0;
                if(prevIdx == -1 || nums[index] > nums[prevIdx]){
                    take = 1 + dp[index + 1][index + 1];
                }
                //update dp
                dp[index][prevIdx + 1] = Math.max(take, notTake);
            }
        }

        return dp[0][0];
    }
}