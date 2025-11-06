class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        #we use dfs to traverse the grid wherever the water is present i.e grid[r][c] == 1 and if the dfs traversal goes out of bounds add 1 to parameter as only then the parameter increases, if it is surrounded by water we return 0
        ROWS, COLS = len(grid), len(grid[0])
        visited = set()
        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        def dfs(r, c):
            if r not in range(ROWS) or c not in range(COLS) or grid[r][c] == 0:
                return 1
            if (r, c) in visited:
                return 0
            visited.add((r, c))
            perimeter = 0
            for dr, dc in directions:
                perimeter += dfs(dr + r, dc + c)
            return perimeter

        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == 1:
                    return dfs(r, c)