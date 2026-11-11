class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Helper(0, nums, result, new ArrayList<>());
        return result;
    }

    //Helper Function
    public void Helper(int index, int[] nums, List<List<Integer>> result, List<Integer> current){
        result.add(new ArrayList<>(current));
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);
            Helper(i + 1, nums, result, current);
            current.remove(current.size() - 1);
        }
    }
}