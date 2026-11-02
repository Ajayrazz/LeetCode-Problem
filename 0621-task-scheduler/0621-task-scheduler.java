class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char t : tasks){
            freq[t - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int f : freq){
            if(f > 0){
                maxHeap.add(f);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int time = 0;

        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                int current = maxHeap.poll() - 1;
                if(current > 0){
                    queue.add(new int[]{current, time + n});
                }
            }
            if(!queue.isEmpty() && queue.peek()[1] == time){
                maxHeap.add(queue.poll()[0]);
            }
        }

        return time;
    }
}