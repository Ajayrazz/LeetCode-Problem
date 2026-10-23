class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int index = queue.poll();
                if(arr[index] == 0) return true;
                int left = index - arr[index];
                int right = index + arr[index];
                if(left >= 0 && !visited[left]){
                    visited[left] = true;
                    queue.add(left);
                }
                if(right < n && !visited[right]){
                    visited[right] = true;
                    queue.add(right);
                }
            }
        }

        return false;
    }
}