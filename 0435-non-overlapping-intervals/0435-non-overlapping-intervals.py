class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda i:i[0])
        prevEnd = intervals[0][1]
        res = 0
        for start, end in intervals[1:]:
            #no overlap, just update the prevEnd to new end
            if start >= prevEnd:
                prevEnd = end
            else:
            #overlap case, update prevEnd to min of the to end values
                res += 1
                prevEnd = min(prevEnd, end)
        return res