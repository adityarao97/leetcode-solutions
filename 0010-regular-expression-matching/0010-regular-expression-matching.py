class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        dp = {}
        def dfs(i, j):
            if (i, j) in dp:
                return dp[(i, j)]
            #i: index for s, j: index for p, if we exceed both the length of string we have matched successfully 
            if i >= len(s) and j >= len(p):
                return True
            #if i hasn't exceeded length of s and we have j inbounds we haven't matched s completely so return False 
            if j >= len(p):
                return False
            #first we try to match either the characters at i and j or using a '.' and store it in match variable
            match = i < len(s) and (s[i] == p[j] or p[j] == '.')
            #second we want to check for '*' we have two options choose '*' -> i+1, j(match) or don't choose '*' i, j+2(no match)
            if (j + 1) < len(p) and p[j + 1] == '*':
                dp[(i, j)] = dfs(i, j + 2) or (match and dfs(i + 1, j)) 
                return dp[(i, j)]
            if match:
                dp[(i, j)] = res = dfs(i + 1, j + 1)
                return dp[(i, j)]
            dp[(i, j)] = False
            return dp[(i, j)]
        return dfs(0, 0)