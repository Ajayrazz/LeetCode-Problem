class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);
        while(low <= high){
            int mid = low + (high - low) / 2;
            int totalH = calculateHour(piles, mid);
            if(totalH <= h){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    //calculateHour function
    public int calculateHour(int[] piles, int hour){
        int result = 0;
        for(int i = 0; i < piles.length; i++){
            result += Math.ceil((double) piles[i] / (double) hour);
        }
        return result;
    }

    //findMax function
    public int findMax(int[] piles){
        int maxVal = piles[0];
        for(int i = 1; i < piles.length; i++){
            maxVal = Math.max(maxVal, piles[i]);
        }
        return maxVal;
    }
}