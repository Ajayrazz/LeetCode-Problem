class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        Helper(0, candidates, target, result, new ArrayList<>());
        return result;
    }

    //Helper Function
    public void Helper(int index, int[] candidates, int target, List<List<Integer>> result, List<Integer> current){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        if(index >= candidates.length || target < 0) return;

        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i - 1]) continue;
            current.add(candidates[i]);
            Helper(i + 1, candidates, target - candidates[i], result, current);
            current.remove(current.size() - 1);
        }
    }
}