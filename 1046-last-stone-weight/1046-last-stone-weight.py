class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        if len(stones) == 1:
            return stones[0]
        maxHeap = stones
        heapq.heapify_max(maxHeap)
        while len(maxHeap) > 1:
            y = heapq.heappop_max(maxHeap)
            x = heapq.heappop_max(maxHeap)
            if y > x:
                heapq.heappush_max(maxHeap, y - x)
        return 0 if not maxHeap else maxHeap[0]