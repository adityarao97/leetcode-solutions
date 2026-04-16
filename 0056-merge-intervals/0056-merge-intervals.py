class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key = lambda i:i[0])
        res = [[intervals[0][0], intervals[0][1]]]
        for start, end in intervals[1:]:
            lastEnd = res[-1][1]
            if lastEnd >= start:
                lastEnd = max(lastEnd, end)
                res[-1][1] = lastEnd
            else:
                res.append([start, end])
        return res