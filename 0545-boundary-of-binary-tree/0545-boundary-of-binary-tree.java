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

    public void addLeftBoundaryNodes(TreeNode root, List<Integer> list){
        TreeNode node = root.left;
        if(node==null) return;
        while(!isLeafNode(node)){
            list.add(node.val);
            //keep getting all left nodes
            if(node.left!=null) node = node.left;
            //if no left node exist start checking for right node
            else node = node.right;
        }
    }

    public void addRightBoundaryNodes(TreeNode root, List<Integer> list){
        TreeNode node = root.right;
        List<Integer> reverseList = new ArrayList<>();
        if(node==null) return;
        while(!isLeafNode(node)){
            reverseList.add(node.val);
            //keep getting all right nodes
            if(node.right!=null) node = node.right;
            //if there's no right node check for left node
            else node = node.left;
        }
        //reverse the order of right nodes
        for(int i=reverseList.size()-1; i>=0 ;i--){
            list.add(reverseList.get(i));
        }
    }

    public void addLeafNodes(TreeNode root, List<Integer> list){
        //pre-order traversal where we only pick leaf nodes from left to right
        if(isLeafNode(root)){
            list.add(root.val);
            return;   
        }
        if(root.left!=null) addLeafNodes(root.left, list);
        if(root.right!=null) addLeafNodes(root.right, list);
    }

    public boolean isLeafNode(TreeNode root){
        return (root.left==null && root.right==null);
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        //check if root is not a leaf node and then add it because we are going to add all leaf nodes using addLeafNodes
        if(isLeafNode(root)==false) list.add(root.val);
        //first add all left nodes
        addLeftBoundaryNodes(root, list);
        //then add leaf nodes
        addLeafNodes(root, list);
        //then add right boundary nodes
        addRightBoundaryNodes(root, list);
        return list;
    }
}