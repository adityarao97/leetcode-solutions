class Solution:
    def compress(self, chars: List[str]) -> int:
        n = len(chars)
        k = 0
        i = 0
        while i < n:
            chars[k] = chars[i]
            k += 1
            j = i + 1
            while j < n and chars[j] == chars[i]:
                j += 1
            count = j - i
            if count > 1:
                countString = str(count)
                for digit in countString:
                    chars[k] = digit
                    k += 1
            i = j
        return k