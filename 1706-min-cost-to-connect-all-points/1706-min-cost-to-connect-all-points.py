class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        N = len(points)
        #point : [cost, point]
        adj = [[] for _ in range(N)]
        for i in range(N):
            x1, y1 = points[i]
            for j in range(i+1, N):
                x2, y2 = points[j]
                cost = abs(x1 - x2) + abs(y1 - y2)
                adj[i].append([cost, j])
                adj[j].append([cost, i])
        #initial min heap(cost, node) contains first node, adding it incurs cost as 0 
        minHeap = [[0, 0]]
        visited = set()
        totalCost = 0
        while N > len(visited):
            cost, point = heapq.heappop(minHeap)
            if point not in visited:
                visited.add(point)
                totalCost += cost
                for neighbourCost, neighbour in adj[point]:
                    if neighbour not in visited:
                        heapq.heappush(minHeap, [neighbourCost, neighbour])
        return totalCost