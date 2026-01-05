class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        copy = nums.copy()
        for i in range(len(nums)):
            newIdx = (i + k) % len(nums)
            nums[newIdx] = copy[i]