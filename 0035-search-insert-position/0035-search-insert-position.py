class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        l, r, mid = 0, len(nums) - 1, 0
        while l <= r:
            mid = (l + r) // 2
            if nums[mid] == target:
                return mid
            elif target < nums[mid]:
                r = mid - 1
            else:
                l = mid + 1
        return l
