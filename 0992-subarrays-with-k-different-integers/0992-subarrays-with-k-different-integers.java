class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return Helper(nums, k) - Helper(nums, k - 1);
    }

    //Helper Function
    public int Helper(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, count = 0;
        while(right < nums.length){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.size() > k){
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            count += right - left + 1;
            right++;
        }

        return count;
    }
}