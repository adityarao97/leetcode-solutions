class Solution:
    def checkValidString(self, s: str) -> bool:
        #keep a single counter variable 'open' to track the number of open paranthesis, on encountering an open paranthesis increment else decrement, call recursively by increasing index, if at any time open falls below 0 we can't recover from it and return 0, for wild card we try all possibilities
        dp = {}
        def dfs(i, open):
            if (i, open) in dp:
                return dp[(i, open)]
            if open < 0:
                return False
            if i == len(s):
                return open == 0
            if s[i] == '(':
                dp[(i, open)] = dfs(i + 1, open + 1)
            if s[i] == ')':
                dp[(i, open)] = dfs(i + 1, open - 1)
            if s[i] == '*':
                dp[(i, open)] = dfs(i + 1, open) or dfs(i + 1, open - 1) or dfs(i + 1, open + 1)
            return dp[(i, open)]
        return dfs(0, 0)