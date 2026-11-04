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
class Pair {
    TreeNode node;
    int index;
    public Pair(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int maxWidth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int first = 0, last = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.peek().node;
                int index = queue.peek().index;
                queue.poll();

                if(i == 0) first = index;
                if(i == size - 1) last = index;
                //add children
                if(node.left != null){
                    queue.add(new Pair(node.left, 2 * index + 1));
                }
                if(node.right != null){
                    queue.add(new Pair(node.right, 2 * index + 2));
                }
            }
            //update maxWidth
            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}