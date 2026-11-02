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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        return dfs(root, targetSum, 0L) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    //dfs function
    public int dfs(TreeNode root, int targetSum, long currentSum){
        if(root == null) return 0;
        int count = 0;
        currentSum += root.val;
        if(currentSum == targetSum) count += 1;
        count += dfs(root.left, targetSum, currentSum);
        count += dfs(root.right, targetSum, currentSum);
        return count;
    }
}