class Solution:
    def findMaximizedCapital(self, k: int, w: int, profits: List[int], capital: List[int]) -> int:
        maxProfit = [] # maxheap to store profit which can be made
        minCapital = [(c, p) for (c, p) in zip(capital, profits)] # minheap(c, p) to store min capital required to make that profit
        heapq.heapify(minCapital)
        for _ in range(k):
            while minCapital and minCapital[0][0] <= w:
                c, p = heapq.heappop(minCapital)
                heapq.heappush_max(maxProfit, p)
            if not maxProfit:
                break
            w += heapq.heappop_max(maxProfit)
        return w