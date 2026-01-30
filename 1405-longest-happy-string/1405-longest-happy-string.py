class Solution:
    def longestDiverseString(self, a: int, b: int, c: int) -> str:
        maxHeap, res = [], ""
        for count, char in [(a, "a"), (b, "b"), (c, "c")]:
            if count != 0:
                heapq.heappush_max(maxHeap, (count, char))
        while maxHeap:
            count, char = heapq.heappop_max(maxHeap)
            if len(res) > 1 and res[-1] == res[-2] == char:
                if not maxHeap:
                    break
                count2, char2 = heapq.heappop_max(maxHeap)
                res += char2
                count2 -= 1
                if count2:
                    heapq.heappush_max(maxHeap, (count2, char2))
            else:
                res += char
                count -= 1
            if count:
                heapq.heappush_max(maxHeap, (count, char))
        return res