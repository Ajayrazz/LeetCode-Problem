class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Helper(0, nums, result, new ArrayList<>());
        return result;
    }

    //Helper Function
    public void Helper(int index, int[] nums, List<List<Integer>> result, List<Integer> current){
        if(index == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        Helper(index + 1, nums, result, current);

        current.remove(current.size() - 1);
        Helper(index + 1, nums, result, current);
    }
}