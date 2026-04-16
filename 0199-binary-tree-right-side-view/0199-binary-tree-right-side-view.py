# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        if not root: return res
        q = deque()
        q.append((0, root))
        while q:
            count, node = q.popleft()
            if len(res) <= count:
                res.append([])
            res[count].append(node.val)
            if node.left:
                q.append((count + 1, node.left))
            if node.right:
                q.append((count + 1, node.right))
        res = [ i[-1] for i in res]
        return res 