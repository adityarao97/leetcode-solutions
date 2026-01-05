class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        #reverse the list completely and then reverse first k elements and remaining separately to achieve final result
        n = len(nums)
        k = k % n
        l, r = 0, n - 1
        def reverse(l, r):
            while l < r:
                nums[l], nums[r] = nums[r], nums[l]
                l, r = l + 1, r - 1
        reverse(l, r)
        reverse(l, k - 1)
        reverse(k, r)