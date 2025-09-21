class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        res = 0
        prevEnd = intervals[0][1]
        for start, end in intervals[1:]:
            #if there's no overlap, just update the prevEnd to end
            if start >= prevEnd:
                prevEnd = end
            #if there's an overlap we remove the interval which ends later by increasing res and setting prevEnd to the lesser of the two 
            else:
                res+=1
                prevEnd = min(prevEnd, end)
        return res
