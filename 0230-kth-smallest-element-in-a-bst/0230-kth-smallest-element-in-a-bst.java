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
    //loop through all elements in pre-order traversal(pre-order stores nodes in increasing order) and store it in list
    private void dfs(TreeNode root, List<Integer> list){
        if(root.left!=null) dfs(root.left, list);
        if(root!=null) list.add(root.val);
        if(root.right!=null) dfs(root.right, list);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list.get(k-1);
    }
}