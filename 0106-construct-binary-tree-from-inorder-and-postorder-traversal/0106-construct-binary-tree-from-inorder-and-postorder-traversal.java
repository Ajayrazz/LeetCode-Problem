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
    public Map<Integer, Integer> map = new HashMap<>();
    public int postorderIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIdx = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return Helper(postorder, 0, postorder.length - 1);
    }

    //Helper Function
    public TreeNode Helper(int[] postorder, int left, int right){
        if(left > right) return null;
        int rootVal = postorder[postorderIdx--];
        TreeNode root = new TreeNode(rootVal);
        int inorderIdx = map.get(rootVal);
        //recursion
        root.right = Helper(postorder, inorderIdx + 1, right);
        root.left = Helper(postorder, left, inorderIdx - 1);

        return root;
    }
}