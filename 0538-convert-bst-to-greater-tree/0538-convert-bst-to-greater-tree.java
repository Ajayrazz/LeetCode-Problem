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
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root;
        Helper(root, 0);
        return root;
    }

    //Helper Function
    public int Helper(TreeNode root, int current){
        if(root == null) return current;
        current = root.val + Helper(root.right, current);
        root.val = current;
        current = Helper(root.left, current);
        return current;
    }
}