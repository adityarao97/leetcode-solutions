class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        #intuition : we compare each character in s (i index) with each character in p (j index) there's a match 
        #if s[i] == p[j] or if p[j] == '.'
        #if we encounter a '*' we have two choices either to match (recursive call with i+1, j) or not to match(recursive call with i, j+1)
        def dfs(i, j):
            #if we exceed both s and p length we have matched successfully
            if i >= len(s) and j >= len(p):
                return True
            #if we exceeded p before s we didn't match s successfully
            if j >= len(p):
                return False
            #store match as a boolean for current indices
            match = (i < len(s)) and (s[i] == p[j] or p[j] == '.')
            #check for '*' case
            if (j + 1 < len(p) and p[j + 1] == '*'):
                return (match and dfs(i + 1, j)) or dfs(i, j + 2)
            if match:
                return dfs(i + 1, j + 1)
            return False
        return dfs(0, 0)
