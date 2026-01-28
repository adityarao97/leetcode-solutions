class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        def calculateDistance(x, y):
            return abs(x*x) + abs(y*y)
        res, minHeap = [], []
        for x, y in points:
            heapq.heappush(minHeap, [calculateDistance(x, y), x, y])
        for _ in range(k):
            distance, x, y = heapq.heappop(minHeap)
            res.append([x, y])
        return res