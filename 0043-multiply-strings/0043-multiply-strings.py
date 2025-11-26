class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        #if a single digit is 0 return 0
        if "0" in [num1, num2]:
            return "0"
        #we store multiplication of each value in a num1 + num2 length array, initialize it all with 0
        res = [0] * (len(num1) + len(num2))
        #reverse the two arrays as that's how we want to multiply
        num1, num2 = num1[::-1], num2[::-1]
        #we take the multiplication of indices at i1(from num1) + i2(from n2) to be the 1st digit which will be modded by 10 like 2*9=18 we want to store 8 at i1 + i2 and 2nd digit will be the carry from previous so it'll be 18//10 = 1 there may be carry from previous or current multiplication so we add it 
        for i1 in range(len(num1)):
            for i2 in range(len(num2)):
                digit = int(num1[i1]) * int(num2[i2])
                res[i1 + i2] += digit
                res[i1 + i2 + 1] += res[i1 + i2] // 10
                res[i1 + i2] = res[i1 + i2] % 10
        #reverse res and remove trailing zeroes
        res, beg = res[::-1], 0
        while beg < len(res) and res[beg] == 0:
            beg += 1
        res = map(str, res[beg:])
        return "".join(res)