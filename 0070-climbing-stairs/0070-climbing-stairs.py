class Solution(object):
    def climbStairs(self, n):
        
        # Space Optimized
        if n<=2: return n
        prev2, prev = 1, 2
        for i in range(2, n):
            cur = prev + prev2
            prev2 = prev
            prev = cur
        return prev

        # Tabulation
        # if n<=2: return n
        # dp = [0] * (n)
        # dp[0], dp[1] = 1, 2
        # for i in range(2, n):
        #     dp[i] = dp[i-1]+dp[i-2]
        # return dp[n-1]

        # Recursive
        # dp = [-1] * (n+1)        
        # def recursive(idx, dp):
        #     if idx==0: return 1
        #     if idx<0: return 0
        #     if dp[idx]!=-1: return dp[idx]
        #     dp[idx] = recursive(idx-1, dp) + recursive(idx-2, dp)
        #     return dp[idx]
        # return recursive(n, dp)
        
        