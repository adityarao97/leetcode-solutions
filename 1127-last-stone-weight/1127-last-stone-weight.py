class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        stones = [-s for s in stones]
        heapq.heapify(stones)
        while len(stones) > 1:
            first = abs(heapq.heappop(stones))
            second = abs(heapq.heappop(stones))
            if first > second:
                heapq.heappush(stones, second - first)
        return 0 if len(stones) == 0 else abs(stones[0])