class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        #if sum is not divisible return False
        if total % 2 != 0:
            return False
        #target of sum / 2 is what we want to achieve by doing sum of individual elements
        target = total // 2
        n = len(nums)
        #2d dp array initialized with -1
        memo = [[-1] * (target + 1) for _ in range(n)]
        
        def dfs(i, target):
            if target == 0:
                return True
            if i >= n or target < 0:
                return False
            if memo[i][target] != -1:
                return memo[i][target]
            memo[i][target] = dfs(i + 1, target - nums[i]) or dfs(i + 1, target)
            return memo[i][target]
        
        return dfs(0, target)