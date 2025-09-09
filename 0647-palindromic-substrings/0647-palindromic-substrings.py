class Solution:
    
    def checkPalindrome(self, s, l, r, res):
        res = 0
        while l>=0 and r<len(s) and s[l] == s[r]:
            l-=1
            r+=1
            res+=1
        return res

    def countSubstrings(self, s: str) -> int:
        res = 0
        for i in range(len(s)):
            res += self.checkPalindrome(s, i, i, res)
            res += self.checkPalindrome(s, i, i+1, res)
        return res
        