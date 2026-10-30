class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            //remove index which is out of bound
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            //remove index whose corresponding value is less than current value
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.add(i);
            if(i >= k - 1){
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        return result;
    }
}