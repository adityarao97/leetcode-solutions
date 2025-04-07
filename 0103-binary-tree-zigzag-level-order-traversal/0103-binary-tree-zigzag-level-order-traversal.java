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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        //leftToRight boolean variable to alternatively read from left to right or right to left in a bfs traversal
        boolean leftToRight = true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null) return list;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            //Linked list is used as a sublist as it allows to insert elements from front and back
            LinkedList<Integer> subList = new LinkedList<>();
            for(int i=0; i<size; i++){
                TreeNode temp = queue.poll();
                if(leftToRight){
                    subList.add(temp.val);
                }
                else{
                    subList.addFirst(temp.val);
                }
                if(temp.left!=null) queue.offer(temp.left);
                if(temp.right!=null) queue.offer(temp.right);
            }
            list.add(subList);
            leftToRight = !leftToRight;
        }
        return list;
    }
}