class Solution:
    def validPalindrome(self, s: str) -> bool:
        l, r = 0, len(s) - 1
        def isPali(s, l, r):
            while l <= r:
                if s[l] != s[r]:
                    return False
                l += 1
                r -= 1
            return True
        while l <= r:
            if s[l] != s[r]:
                return isPali(s, l + 1, r) or isPali(s, l, r - 1)
            l += 1
            r -= 1
        return True