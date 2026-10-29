class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        Helper(nums, result, new ArrayList<>(), visited);
        return result;
    }

    //Helper Function
    public void Helper(int[] nums, List<List<Integer>> result, List<Integer> current, boolean[] visited){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue;
            current.add(nums[i]);
            visited[i] = true;
            Helper(nums, result, current, visited);
            visited[i] = false;
            current.remove(current.size() - 1);
        }
    }
}