class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                nums[i] = 0;
            }
            else {
                nums[i] = 1;
            }
        }
        return Helper(nums, k) - Helper(nums, k - 1);
    }

    //Helper Function
    public int Helper(int[] nums, int k){
        if(k < 0) return 0;
        int left = 0, right = 0, sum = 0, count = 0;
        while(right < nums.length){
            sum += nums[right];
            while(sum > k){
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}