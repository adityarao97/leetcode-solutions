# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        #store the diameter obtained at each node and maximize it
        self.res = 0
        #returns height at curr
        def dfs(curr):
            if not curr:
                return 0
            left = dfs(curr.left)
            right = dfs(curr.right)
            #diameter value at each node is left + right
            self.res = max(self.res, left + right)
            #height at curr = max(left, right) + 1
            return 1 + max(left, right)
        dfs(root)
        return self.res