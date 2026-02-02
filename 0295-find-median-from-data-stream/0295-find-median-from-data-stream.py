class MedianFinder:

    def __init__(self):
        self.small, self.large = [], []

    def addNum(self, num: int) -> None:
        heapq.heappush_max(self.small, num)
        #make sure every num in small <= every num in large
        if (self.small and self.large and (self.small[0] > self.large[0])):
            val = heapq.heappop_max(self.small)
            heapq.heappush(self.large, val)
        #make sure the size difference is not greater than 2
        if (len(self.small) - len(self.large)) >= 2:
            val = heapq.heappop_max(self.small)
            heapq.heappush(self.large, val)
        if (len(self.large) - len(self.small) >= 2):
            val = heapq.heappop(self.large)
            heapq.heappush_max(self.small, val)

    def findMedian(self) -> float:
        if len(self.small) == len(self.large):
            return (self.small[0] + self.large[0]) / 2
        elif len(self.small) > len(self.large):
            return self.small[0]
        else:  
            return self.large[0]


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()