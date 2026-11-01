class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE, high = 0;
        for(int w : weights){
            low = Math.max(low, w);
            high += w;
        }

        while(low <= high){
            int mid = low + (high - low) / 2;
            int noOfDays = findDay(weights, mid);
            if(noOfDays <= days){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    //findDay function
    public int findDay(int[] weights, int capacity){
        int days = 1, load = 0;
        for(int w : weights){
            if(load + w > capacity){
                days += 1;
                load = w;
            }
            else {
                load += w;
            }
        }

        return days;
    }
}