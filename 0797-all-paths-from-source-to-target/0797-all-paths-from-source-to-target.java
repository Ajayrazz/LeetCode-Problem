class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        Helper(0, graph.length - 1, graph, result, new ArrayList<>());
        return result;
    }

    //Helper Function
    public void Helper(int src, int dest, int[][] graph, List<List<Integer>> result, List<Integer> current){
        current.add(src);
        if(src == dest){
            result.add(new ArrayList<>(current));
        }
        else {
            for(int adjnode : graph[src]){
                Helper(adjnode, dest, graph, result, current);
            }
        }
        current.remove(current.size() - 1);
    }
}