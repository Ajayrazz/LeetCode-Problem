class Pair {
    int first;
    long second;
    public Pair(int first, long second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int MOD = (int) 1e9 + 7;
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : roads){
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.second, b.second));
        pq.add(new Pair(0, 0L));

        while(!pq.isEmpty()){
            int node = pq.peek().first;
            long distance = pq.peek().second;
            pq.poll();

            for(Pair current : adj.get(node)){
                int adjnode = current.first;
                long edW = current.second;
                
                if(distance + edW < dist[adjnode]){
                    dist[adjnode] = distance + edW;
                    ways[adjnode] = ways[node];
                    pq.add(new Pair(adjnode, dist[adjnode]));
                }
                else if(distance + edW == dist[adjnode]){
                    ways[adjnode] = (ways[adjnode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}