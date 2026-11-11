class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Helper(0, candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    //Helper Function
    public void Helper(int index, int[] candidates, int target, List<List<Integer>> result, List<Integer> current, int currentSum){
        if(currentSum == target){
            result.add(new ArrayList<>(current));
            return;
        }

        if(index >= candidates.length || currentSum > target) return;

        current.add(candidates[index]);
        Helper(index, candidates, target, result, current, currentSum + candidates[index]);

        current.remove(current.size() - 1);
        Helper(index + 1, candidates, target, result, current, currentSum);
    }
}