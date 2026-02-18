class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        row_cnt = [0] * ROWS
        col_cnt = [0] * COLS
        res = 0
        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == 1:
                    row_cnt[r] += 1
                    col_cnt[c] += 1
        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == 1 and (row_cnt[r] > 1 or col_cnt[c] > 1):
                    res += 1
        return res

