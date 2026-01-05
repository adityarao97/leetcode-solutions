class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        copy = nums.copy()
        for i in range(len(nums)):
            newIdx = 0
            if i + 1 + k > len(nums):
                newIdx = (i + k) % len(nums)
            else:
                newIdx = i + k
            nums[newIdx] = copy[i]