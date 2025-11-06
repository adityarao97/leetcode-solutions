class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        perimeter = 0
        visited = set()
        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        def dfs(r, c):
            if r not in range(ROWS) or c not in range(COLS) or (r, c) in visited or grid[r][c] == 0:
                return
            visited.add((r, c))
            nonlocal perimeter
            if r == 0:
                perimeter += 1
            if r == ROWS - 1:
                perimeter += 1
            if c == 0:
                perimeter += 1
            if c == COLS - 1:
                perimeter += 1
            if r - 1 in range(ROWS) and grid[r - 1][c] == 0:
                perimeter += 1
            if r + 1 in range(ROWS) and grid[r + 1][c] == 0:
                perimeter += 1
            if c - 1 in range(COLS) and grid[r][c - 1] == 0:
                perimeter += 1
            if c + 1 in range(COLS) and grid[r][c + 1] == 0:
                perimeter += 1
            for dr, dc in directions:
                dfs(dr + r, dc + c)            

        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == 1:
                    dfs(r, c)
        return perimeter