class Solution:
    def mySqrt(self, x: int) -> int:
        l, r, res = 0, x, 0
        while l <= r:
            mid = (l + r) // 2
            sq = mid ** 2
            if x == sq:
                return mid
            elif x < sq:
                r = mid - 1
            else:
                l = mid + 1
                res = mid
        return res
