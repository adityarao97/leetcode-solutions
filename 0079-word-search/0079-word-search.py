class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        ROWS, COLS = len(board), len(board[0])
        visited = set()
        def dfs(r, c, i):
            if len(word) == i:
                return True
            if r not in range(ROWS) or c not in range(COLS) or (r, c) in visited or word[i] != board[r][c]:
                return False
            visited.add((r, c))
            i += 1
            res = dfs(r + 1, c, i) or dfs(r - 1, c, i) or dfs(r, c + 1, i) or dfs(r, c - 1, i)
            i -= 1
            visited.remove((r, c))
            return res
        for r in range(ROWS):
            for c in range(COLS):
                if board[r][c] == word[0]:
                    if dfs(r, c, 0): return True
        return False
        