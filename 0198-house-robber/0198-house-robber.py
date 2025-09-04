class Solution(object):
    def rob(self, nums):
        dp = [-1] * len(nums)
        def recursiveMax(idx, nums, dp):
            if idx < 0: return 0
            if idx == 0: return nums[idx]
            if dp[idx]!=-1: return dp[idx]
            pick = nums[idx] + recursiveMax(idx-2, nums, dp)
            notPick = recursiveMax(idx-1, nums, dp)
            dp[idx] = max(pick,notPick)
            return dp[idx]
        return recursiveMax(len(nums)-1, nums, dp)
        