class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        ROWS, COLS = len(matrix), len(matrix[0])
        dp = {}
        visited = set()
        def dfs(r, c, prev):
            if r not in range(ROWS) or c not in range(COLS) or matrix[r][c] <= prev:
                return 0
            res = 0
            if (r, c) in dp:
                return dp[(r, c)]
            for dr, dc in [[0, 1], [1, 0], [-1, 0], [0, -1]]:
                nr, nc = dr + r, dc + c
                res = max(res, 1 + dfs(nr, nc, matrix[r][c]))
            dp[r, c] = res
            return res 
        maxLen = 0
        for r in range(ROWS):
            for c in range(COLS):
                maxLen = max(maxLen, dfs(r, c, -1))
        return maxLen