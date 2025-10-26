class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        N = len(grid)
        #initialise a min heap with height of 1st cell, r and c
        minHeap = [[grid[0][0], 0, 0]]
        #visited set to keep track of visited cells initialized with 1st cell
        visited = set((0, 0))
        #directions array for traversal across each direction
        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        while minHeap:
            t, r, c = heapq.heappop(minHeap)
            #base case will be when we reach the last cell and return the time t
            if r == N - 1 and c == N - 1:
                return t
            for dr, dc in directions:
                nr, nc = dr + r, dc + c
                if nr < 0 or nc < 0 or nr == N or nc == N or (nr, nc) in visited:
                    continue
                visited.add((nr, nc))
                #we only want the max height in the current traversal so we compare from the popped height of parent cell and current height and take the max value  
                heapq.heappush(minHeap, [max(t, grid[nr][nc]), nr, nc])