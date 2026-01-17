class RangeModule:

    def __init__(self):
        self.intervals = []

    def addRange(self, left: int, right: int) -> None:
        bisect.insort(self.intervals,[left, right])
        res = [self.intervals[0]]
        for left, right in self.intervals:
            if res[-1][1] >= left:
                res[-1][1] = max(res[-1][1], right)
            else:
                res.append([left, right])
        self.intervals = res 

    def queryRange(self, left: int, right: int) -> bool:
        idx = bisect.bisect(self.intervals, [left, int(1e9)])
        if not self.intervals or idx == 0:
            return False
        return self.intervals[idx - 1][1] >= right

    def removeRange(self, left: int, right: int) -> None:
        res = []
        for interval in self.intervals:
            #if range to be removed is bigger than interval
            if left <= interval[0] and right >= interval[1]:
                continue
            #no overlap
            elif left >= interval[1] or right <= interval[0]:
                res.append(interval)
            #left partial overlap
            elif left < interval[0]:
                res.append([right, interval[1]])
            #right partial overlap
            elif right > interval[1]:
                res.append([interval[0], left])
            else:
                #Interval to be removed falls between the interval
                res.append([interval[0], left])
                res.append([right, interval[1]])
        self.intervals = res

# Your RangeModule object will be instantiated and called as such:
# obj = RangeModule()
# obj.addRange(left,right)
# param_2 = obj.queryRange(left,right)
# obj.removeRange(left,right)