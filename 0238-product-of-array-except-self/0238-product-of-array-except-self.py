class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        #we create a prefix and suffix arrays to store all multiplication values of array except the current value
        #output array will be multiplication of the current indexes prefix and suffix value respectively
        prefix = [0] * len(nums)
        suffix = [0] * len(nums)
        output = [1] * len(nums)
        prefix[0] = suffix[len(nums) - 1] = 1
        for i in range(1, len(nums)):
            prefix[i] = prefix[i - 1] * nums[i - 1]
        for i in range(len(nums) - 2, -1, -1):
            suffix[i] = suffix[i + 1] * nums[i + 1]
        for i in range(len(nums)):
            output[i] = prefix[i] * suffix[i]
        return output