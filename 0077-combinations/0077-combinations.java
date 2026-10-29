class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Helper(1, n, k, result, new ArrayList<>());
        return result;
    }

    //Helper Function
    public void Helper(int index, int n, int k, List<List<Integer>> result, List<Integer> current){
        if(current.size() == k){
            result.add(new ArrayList<>(current));
            return;
        }

        if(index > n && current.size() > k) return;

        for(int i = index; i <= n; i++){
            current.add((Integer) i);
            Helper(i + 1, n, k, result, current);
            current.remove((Integer) i);
        }
    }
}