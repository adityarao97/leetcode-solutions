class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        words = set(dictionary)
        dp = {}
        dp[len(s)] = 0
        def dfs(i):
            if i in dp:
                return dp[i]
            dp[i] = 1 + dfs(i + 1) # skip current character
            for j in range(i, len(s)):
                if s[i: j + 1] in words:
                    dp[i] = min(dp[i], dfs(j + 1))
            return dp[i]
        return dfs(0)