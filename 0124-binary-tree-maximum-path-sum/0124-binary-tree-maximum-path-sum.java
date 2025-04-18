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

    private int max = Integer.MIN_VALUE;
    
    private int recursiveMaxPath(TreeNode root){
        if(root == null) return 0;
        int maxL = Math.max(0, recursiveMaxPath(root.left));
        int maxR = Math.max(0, recursiveMaxPath(root.right));
        max = Math.max(max, maxL + maxR + root.val);
        return root.val + Math.max(maxL, maxR); 
    }

    public int maxPathSum(TreeNode root) {
        recursiveMaxPath(root);
        return max;
    }
}