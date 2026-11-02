/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        Helper(root, targetSum, result, new ArrayList<>(), 0);
        return result;
    }

    //Helper Function
    public void Helper(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> current, int currentSum){
        if(root == null) return;
        currentSum += root.val;
        current.add(root.val);
        if(root.left == null && root.right == null && currentSum == targetSum){
            result.add(new ArrayList<>(current));
        }
        else {
            Helper(root.left, targetSum, result, current, currentSum);
            Helper(root.right, targetSum, result, current, currentSum);
        }
        current.remove(current.size() - 1);
    }
}