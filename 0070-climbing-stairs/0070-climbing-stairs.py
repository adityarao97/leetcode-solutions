class Solution(object):
    def climbStairs(self, n):
        dp = [-1] * (n+1)        
        def recursive(idx, dp):
            if idx==0: return 1
            if idx<0: return 0
            if dp[idx]!=-1: return dp[idx]
            dp[idx] = recursive(idx-1, dp) + recursive(idx-2, dp)
            return dp[idx]
        return recursive(n, dp)
        
        