class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        ROWS, COLS = len(board), len(board[0])
        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        def dfs(r, c):
            if r not in range(ROWS) or c not in range(COLS) or board[r][c]!='O':
                return
            board[r][c] = 'T'
            for dr, dc in directions:
                nr, nc = dr + r, dc + c
                dfs(nr, nc)
        #capture all Os which are on borders and do a dfs for each of them, mark them temporarily as 'T'
        for r in range(ROWS):
            dfs(r, 0)
            dfs(r, COLS - 1)
        for c in range(COLS):
            dfs(0, c)
            dfs(ROWS - 1, c)
        #convert all remaining 'O's which will all be surrounded by 'X's to 'X' and 'T' back to 'O'
        for r in range(ROWS):
            for c in range(COLS):
                if board[r][c] == 'O':
                    board[r][c] = 'X'
                if board[r][c] == 'T':
                    board[r][c] = 'O'
            