class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        carry = 1
        for i in range(len(digits) - 1, -1, -1):
            if digits[i] == 9 and carry == 1:
                carry = 1
                digits[i] = 0
                continue
            if digits[i] != 9 and carry == 1:
                digits[i] += 1
                return digits
        if carry == 1:
            digits = [1] + digits
        return digits