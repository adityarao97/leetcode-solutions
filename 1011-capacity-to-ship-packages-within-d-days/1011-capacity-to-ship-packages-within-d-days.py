class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        l, r = max(weights), sum(weights)
        res = r
        def checkCapacity(capacity):
            countDays, curCapacity = 1, capacity
            for weight in weights:
                if curCapacity - weight < 0:
                    curCapacity = capacity
                    countDays += 1
                curCapacity -= weight
            return countDays <= days
        
        while l <= r:
            mid = (l + r) // 2
            if checkCapacity(mid):
                res = min(res, mid)
                r = mid - 1
            else:
                l = mid + 1
        return res