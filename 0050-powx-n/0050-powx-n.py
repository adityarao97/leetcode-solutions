class Solution:
    def myPow(self, x: float, n: int) -> float:
        #intuition : divide and conquer to calculate the power, if we want to calculate n^10 we can do n^5*n^5 (do this recursively and handle for odd powers) if the power is negative just return 1/res
        def helper(x, n):
            if x == 0: return 0
            if n == 0: return 1
            res = helper(x, n // 2)
            res = res * res
            return x * res if n % 2 == 1 else res
        res = helper(x, abs(n))
        return res if n >= 0 else 1/res