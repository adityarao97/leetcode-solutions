class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        #intuition : the subproblem is to assume each value is popped last and maximize with remaining elements in array
        nums = [1] + nums + [1]
        dp = {}
        def dfs(l, r):
            if l > r: 
                return 0
            if (l, r) in dp:
                return dp[(l, r)]
            dp[(l, r)] = 0
            for i in range(l, r + 1):
                #assume this i is the last value to be popped so we calculate value based on it's adjacent nodes
                coins = nums[l - 1] * nums[i] * nums[r + 1]
                coins += dfs(l, i - 1) + dfs(i + 1, r)
                dp[(l, r)] = max(dp[(l, r)], coins)
            return dp[(l, r)]
        return dfs(1, len(nums) - 2)