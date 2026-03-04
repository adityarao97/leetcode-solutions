class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        output = [0] * len(nums)
        prod = 1
        zero_count = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                prod *= nums[i]
            else:
                zero_count += 1
                if zero_count > 1:
                    return output
        for i in range(len(nums)):
            if nums[i] == 0:
                output = [0] * len(nums)
                output[i] = prod
                return output
            else:
                output[i] = prod // nums[i]
        return output
