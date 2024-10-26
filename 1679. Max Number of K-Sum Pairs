class Solution {
    public int maxOperations(int[] nums, int k) {
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] >= k) nums[i] = 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int res = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                res += 1;
                left += 1;
                right -= 1;
            }
            else if (sum > k) right -= 1;
            else left += 1;
        }
        return res;
    }
}
