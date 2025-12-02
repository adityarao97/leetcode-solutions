class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        #we will use xor operation: 1^1 = 0 and 0^0 = 0 all the same numbers will be 0 and the single element will be left
        res = nums[0]
        for i in range(1, len(nums)):
            res = res ^ nums[i]
        return res