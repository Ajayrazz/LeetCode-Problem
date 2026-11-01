class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long value = (long) m * k;
        if(bloomDay.length < value) return -1;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for(int bd : bloomDay){
            low = Math.min(low, bd);
            high = Math.max(high, bd);
        }

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(bloomDay, mid, m, k)){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    //isPossible function
    public boolean isPossible(int[] bloomDay, int day, int m, int k){
        int count = 0, noOfBucket = 0;
        for(int bd : bloomDay){
            if(bd <= day){
                count += 1;
            }
            else {
                noOfBucket += (count / k);
                count = 0;
            }
        }

        noOfBucket += (count / k);
        return noOfBucket >= m;
    }
}