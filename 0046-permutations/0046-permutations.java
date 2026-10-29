class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Helper(nums, result, new ArrayList<>());
        return result;
    }

    //Helper Function
    public void Helper(int[] nums, List<List<Integer>> result, List<Integer> current){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int num : nums){
            if(current.contains(num)) continue;
            current.add(num);
            Helper(nums, result, current);
            current.remove(current.size() - 1);
        }
    }
}