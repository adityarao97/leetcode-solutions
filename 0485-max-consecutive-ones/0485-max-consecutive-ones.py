class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        maxCount, count = 0, 0
        for i in range(len(nums)):
            if nums[i] == 1:
                count += 1
                maxCount = max(count, maxCount)
            if nums[i] == 0:
                count = 0
        return maxCount