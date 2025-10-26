class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        N = len(grid)
        #visited set with 1st cell marked
        visited = set((0, 0))
        #min heap with - maxheight in path, r, c initialized with 1st cell
        minH = [[grid[0][0], 0, 0]]
        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        while minH:
            t, r, c = heapq.heappop(minH)
            #base case to return the t value which will contain max height encountered and when last cell is reached 
            if r == N-1 and c == N-1:
                return t
            for dr, dc in directions:
                nr, nc = dr + r, dc + c
                if nr < 0 or nc < 0 or nr == N or nc == N or (nr, nc) in visited:
                    continue
                visited.add((nr, nc))
                #we take the max height value of visited neighbour after each pop from minheap
                heapq.heappush(minH,[max(t, grid[nr][nc]), nr, nc])