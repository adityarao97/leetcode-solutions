class Solution:
    def longestPalindrome(self, s: str) -> str:
        resIdx, resLen = 0, 0
        for i in range(len(s)):
            resLen, resIdx = self.checkPalindrome(s, i, i, resIdx, resLen)
            resLen, resIdx = self.checkPalindrome(s, i, i + 1, resIdx, resLen)
        return s[resIdx:resIdx + resLen]

    def checkPalindrome(self, s, l, r , resIdx, resLen):
        while l >= 0 and r < len(s) and s[l] == s[r]:
                if resLen < r - l + 1:
                    resLen = r - l + 1
                    resIdx = l
                l-=1
                r+=1
        return resLen, resIdx