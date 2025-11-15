class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        #intuition: i is the index for characters in s and j in t, we compare character by character, if we reach end of t we found a subsequence and return 1, if we reach end of s first we didn't and so we return 0, if we have a match we can either choose to pick that index (i+1, j+1) or we can go to next index(i+1, j) else we go to next index(i+1, j) 
        dp = {}
        if len(s) < len(t):
            return 0
        def dfs(i, j):
            if j == len(t):
                return 1
            if i == len(s):
                return 0
            if (i, j) in dp:
                return dp[(i, j)]
            dp[(i, j)] = dfs(i + 1, j)
            if s[i] == t[j]:
                dp[(i, j)] += dfs(i + 1, j + 1)
            return dp[(i, j)]
        return dfs(0, 0)