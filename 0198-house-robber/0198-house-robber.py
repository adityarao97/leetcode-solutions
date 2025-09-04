class Solution(object):
    def rob(self, nums):
        #space optimization
        prev = nums[0]
        prev2 = 0
        for i in range(1, len(nums)):
            pick = nums[i]
            if(i>1): pick+=prev2
            notPick = prev
            cur = max(pick, notPick)
            prev2 = prev
            prev = cur
        return prev
        #tabulation + memoization
        # dp = [0] * len(nums)
        # dp[0] = nums[0]
        # for i in range(1, len(nums)):
        #     pick = nums[i]
        #     if i>1: pick+=dp[i-2]
        #     notPick = dp[i-1]
        #     dp[i] = max(pick, notPick)
        # return dp[-1]
        #recursive solution
        # def recursiveMax(idx, nums, dp):
        #     if idx < 0: return 0
        #     if idx == 0: return nums[idx]
        #     if dp[idx]!=-1: return dp[idx]
        #     pick = nums[idx] + recursiveMax(idx-2, nums, dp)
        #     notPick = recursiveMax(idx-1, nums, dp)
        #     dp[idx] = max(pick,notPick)
        #     return dp[idx]
        # return recursiveMax(len(nums)-1, nums, dp)
        