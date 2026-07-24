class Solution:
    @cache
    def minOperations(self, n: int) -> int:
        if n == pow(2, int(math.log(n, 2))):
            return 1
        low = pow(2, int(math.log(n, 2)))
        high = pow(2, int(math.log(n, 2)) + 1)

        d1 = n - low
        d2 = high - n

        return 1 + min(self.minOperations(d1), self.minOperations(d2))