class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda i : (i[0], i[1]))
        lastEnd = intervals[0][1]
        res = 0
        for i in range(1, len(intervals)):
            start, end = intervals[i][0], intervals[i][1]
            if start >= lastEnd:
                lastEnd = end
            else:
                res += 1
                lastEnd = min(end, lastEnd)
        return res 