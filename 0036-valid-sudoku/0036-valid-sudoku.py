class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rowSet, colSet, gridSet = defaultdict(set), defaultdict(set), defaultdict(set)
        for r in range(9):
            for c in range(9):
                value = board[r][c]
                if value == ".":
                    continue
                if value in rowSet[r] or value in colSet[c] or value in gridSet[(r//3, c//3)]:
                    return False
                else:
                    rowSet[r].add(value)
                    colSet[c].add(value)
                    gridSet[(r//3, c//3)].add(value)
        return True 