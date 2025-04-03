/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private Map<Integer, TreeNode> markParents(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left!=null){
                map.put(current.left.val, current);
                queue.offer(current.left);
            } 
            if(current.right!=null){
                map.put(current.right.val, current);
                queue.offer(current.right);
            }
        }
        return map;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, TreeNode> childToParentMap = markParents(root);
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        queue.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(curr_level == k) break;
            curr_level++;
            for(int i=0; i < size; i++){
                TreeNode current = queue.poll();
                if(current.left!=null && visited.get(current.left) == null){
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right!=null && visited.get(current.right) == null){
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                TreeNode parent = childToParentMap.get(current.val);
                if(parent!=null && visited.get(parent) == null){
                    queue.offer(parent);
                    visited.put(parent, true);
                }
            }
        }
        while(!queue.isEmpty()){
            result.add(queue.poll().val);
        }
        return result;
    }
}