class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key = lambda i : i[0])
        res = [[intervals[0][0], intervals[0][1]]]
        for i in range(1, len(intervals)):
            prevEnd = res[-1][1]
            curStart = intervals[i][0]
            if prevEnd >= curStart:
                res.pop()
                res.append([intervals[i - 1][0], max(intervals[i - 1][1], intervals[i][1])])
            else:
                res.append([intervals[i][0], intervals[i][1]])
        return res