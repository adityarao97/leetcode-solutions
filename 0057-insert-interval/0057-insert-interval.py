class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res = []

        for i in range(len(intervals)):
            #if new interval is strictly before current interval append to list and return remaining items
            if newInterval[1] < intervals[i][0]:
                res.append(newInterval)
                return res + intervals[i:]
            #if new interval is strictly after current interval append current interval
            elif newInterval[0] > intervals[i][1]:
                res.append(intervals[i])
            #if the intervals are overlapping merge them and update the newInterval
            else:
                newInterval = [min(newInterval[0], intervals[i][0]), max(newInterval[1], intervals[i][1])]

        res.append(newInterval)
        return res