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
    
    //function for finding the height of binary tree
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftht = height(root.left);
        int rightht = height(root.right);

        return Math.max(leftht , rightht) + 1;
    }

    //function for finding the diameter of the binary tree
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        //calling for height
        int left_height = height(root.left);
        int right_height = height(root.right);
        int selfdiam = (left_height + right_height);

        //calling for diameter
        int left_diam = diameterOfBinaryTree(root.left);
        int right_diam = diameterOfBinaryTree(root.right);

        return Math.max(selfdiam , Math.max(left_diam , right_diam));
    }
}
