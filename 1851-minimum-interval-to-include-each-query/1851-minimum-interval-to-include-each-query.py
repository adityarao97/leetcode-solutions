class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        #intuition : sort the intervals, create a copy of sorted queries and for each query add size(difference r - l + 1) and last element(r) to minheap until all intervals first element is less than query as they will fall inside those intervals, then we check if any incorrect interval exist for our query by ensuring r value is always greater than q, if not we pop them from heap, if we have element in heap that is our result for that query, we store that in a map and return as a result 
        intervals.sort()
        minH = []
        res, i = {}, 0
        for q in sorted(queries):
            while i < len(intervals) and intervals[i][0] <= q:
                l, r = intervals[i]
                heapq.heappush(minH, (r - l + 1, r))
                i += 1
            while minH and minH[0][1] < q:
                heapq.heappop(minH)
            res[q] = minH[0][0] if minH else -1
        return [ res[q] for q in queries]