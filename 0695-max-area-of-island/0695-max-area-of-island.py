class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        def dfs(r, c):
            if r not in range(ROWS) or c not in range(COLS) or grid[r][c] == 0:
                return 0
            res = 1
            grid[r][c] = 0
            for dr, dc in [[0, 1], [1, 0], [-1, 0], [0, -1]]:
                nr, nc = dr + r, dc + c
                res += dfs(nr, nc)
            return res
        maxArea = 0
        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == 1:
                    area = dfs(r, c)
                    maxArea = max(area, maxArea)
        return maxArea