class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        #intuition : at every step either we decide to do a addition or a subtraction, store results in dp and return 
        dp = {}
        def dfs(i, a):
            if (i, a) in dp:
                return dp[(i, a)]
            if i == len(nums) and a == target:
                return 1
            if i >= len(nums):
                return 0
            dp[(i, a)] = dfs(i + 1, a + nums[i]) + dfs(i + 1, a - nums[i])
            return dp[(i, a)]
        return dfs(0, 0)