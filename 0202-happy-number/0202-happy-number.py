class Solution:
    def isHappy(self, n: int) -> bool:
        visit = set()
        def sumOfSquares(num):
            output = 0
            while num:
                digit = num % 10
                digit = digit ** 2
                output += digit
                num = num // 10
            return output
        while n not in visit:
            visit.add(n)
            if n == 1:
                return True
            n = sumOfSquares(n)
        return False