class Solution:
    def secondsToRemoveOccurrences(self, s: str) -> int:
        zeros = 0
        seconds = 0
        for char in s:
            if char == '0':
                zeros += 1
            elif zeros > 0:
                seconds = max(seconds + 1, zeros)
        return seconds