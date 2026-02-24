class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        ROWS, COLS = len(board), len(board[0])
        def dfs(r, c):
            if board[r][c] == 'O':
                board[r][c] = 'T'
                for dr, dc in [[0, 1], [1, 0], [-1, 0], [0, -1]]:
                    nr, nc = dr + r, dc + c
                    if nr in range(ROWS) and nc in range(COLS) and board[nr][nc] == 'O':
                        dfs(nr, nc)
        for r in range(ROWS):
            dfs(r, 0)
            dfs(r, COLS - 1)
        for c in range(COLS):
            dfs(0, c)
            dfs(ROWS - 1, c)
        for r in range(ROWS):
            for c in range(COLS):
                if board[r][c] == 'T':
                    board[r][c] = 'O'
                elif board[r][c] == 'O':
                    board[r][c] = 'X'