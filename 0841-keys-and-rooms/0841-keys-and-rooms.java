class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()){
            int node = queue.poll();
            visited[node] = true;
            for(int adjnode : rooms.get(node)){
                if(!visited[adjnode]){
                    queue.add(adjnode);
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]) return false;
        }

        return true;
    }
}