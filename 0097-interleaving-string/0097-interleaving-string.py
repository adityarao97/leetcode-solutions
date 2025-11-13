class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        #intuition : at each step we have two choices either to pick from 1st string or 2nd string, we do this until we reach the end of 3rd string and we return true, else we return False, we store each value of i, j in dp 
        dp = {}
        def dfs(i, j, k):
            if (i, j) in dp:
                return dp[(i, j)]
            if k == len(s3):
                if i == len(s1) and j == len(s2):
                    return True
                else:
                    return False
            res = False
            if i < len(s1) and s1[i] == s3[k]:
                res = dfs(i + 1, j, k + 1)
            if not res and j < len(s2) and s2[j] == s3[k]:
                res = dfs(i, j + 1, k + 1)
            dp[(i, j)] = res
            return res
        return dfs(0, 0, 0)