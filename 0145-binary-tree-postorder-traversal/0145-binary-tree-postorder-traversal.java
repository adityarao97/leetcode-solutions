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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root!=null || !stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }
            else{
                TreeNode peekNode = stack.peek();
                // If the right child is not null and hasn't been processed, move to the right
                if (peekNode.right != null && prev != peekNode.right) {
                    root = peekNode.right;
                } else {
                    // If no children to process or the children are already processed, visit the node
                    list.add(peekNode.val);
                    prev = stack.pop();  // Mark this node as visited
                }
            }
        }
        return list;
    }
}