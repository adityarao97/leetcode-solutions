class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        l, r, res = max(weights), sum(weights), 0
        def checkCapacity(capacity):
            countDays = 1
            curCapacity = capacity
            for weight in weights:
                if curCapacity - weight < 0:
                    countDays += 1
                    curCapacity = capacity
                curCapacity -= weight
            return countDays <= days

        while l <= r:
            mid = (l + r) // 2
            if checkCapacity(mid):
                res = mid
                r = mid - 1
            else:
                l = mid + 1
        return res