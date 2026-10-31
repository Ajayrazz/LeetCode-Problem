class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for(int num : nums){
            if(num > low) low = num;
            high += num;
        }

        while(low <= high){
            int mid = low + (high - low) / 2;
            int split = calculateSplit(nums, mid);
            if(split > k){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return low;
    }

    //calculateSplit function
    public int calculateSplit(int[] nums, int k){
        int count = 1, sum = 0;
        for(int num : nums){
            if(sum + num > k){
                count += 1;
                sum = num;
            }
            else {
                sum += num;
            }
        }
        return count;
    }
}