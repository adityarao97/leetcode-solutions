class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        trips.sort(key = lambda t : t[1])
        minHeap = [] # [to, numPassengers]
        curCapacity = 0
        for numPass, start, end in trips:
            while minHeap and minHeap[0][0] <= start:
                curCapacity -= minHeap[0][1]
                heapq.heappop(minHeap)
            curCapacity += numPass
            if curCapacity > capacity:
                return False
            heapq.heappush(minHeap, [end, numPass]) 
        return True