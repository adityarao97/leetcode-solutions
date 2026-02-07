class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        ROWS, COLS = len(board), len(board[0])
        visited = set()
        def dfs(row, col, i):
            if len(word) == i:
                return True
            if row not in range(ROWS) or col not in range(COLS) or (row, col) in visited or board[row][col] != word[i]:
                return False
            visited.add((row, col))
            res = dfs(row + 1, col, i + 1) or dfs(row - 1, col, i + 1) or dfs(row, col + 1, i + 1) or dfs(row, col - 1, i + 1)
            visited.remove((row, col))
            if res: return True
        for r in range(ROWS):
            for c in range(COLS):
                if dfs(r, c, 0): return True
        return False