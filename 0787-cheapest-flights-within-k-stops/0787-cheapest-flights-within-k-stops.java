class Pair {
    int first, second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Tuple {
    int first, second, third;
    public Tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : flights){
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, src, 0));

        while(!queue.isEmpty()){
            int step = queue.peek().first;
            int node = queue.peek().second;
            int cost = queue.peek().third;
            queue.poll();

            if(step > k) continue;

            for(Pair current : adj.get(node)){
                int adjnode = current.first;
                int edW = current.second;

                if(edW + cost < dist[adjnode]){
                    dist[adjnode] = edW + cost;
                    queue.add(new Tuple(step + 1, adjnode, dist[adjnode]));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}