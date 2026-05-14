class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        ROWS, COLS = len(heights), len(heights[0])
        minHeap = [[0, 0, 0]] #[maxDiff, row, col]
        visited = set()
        while minHeap:
            diff, r, c = heapq.heappop(minHeap)
            if (r, c) in visited:
                continue
            visited.add((r, c))
            if (r, c) == (ROWS - 1, COLS - 1):
                return diff
            for dr, dc in [[0, 1], [1, 0], [-1, 0], [0, -1]]:
                nr, nc = dr + r, dc + c
                if nr not in range(ROWS) or nc not in range(COLS) or (nr, nc) in visited:
                    continue
                newDiff = max(diff, abs(heights[nr][nc] - heights[r][c]))
                heapq.heappush(minHeap, [newDiff, nr, nc])