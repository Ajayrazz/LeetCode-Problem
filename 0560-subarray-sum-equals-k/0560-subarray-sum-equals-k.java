class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int left = 0, right = 0, sum = 0, count = 0;
        while(right < nums.length){
            sum += nums[right];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            right++;
        }
        return count;
    }
}