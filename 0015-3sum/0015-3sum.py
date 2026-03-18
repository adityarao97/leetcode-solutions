class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        res = []
        nums.sort()
        for i in range(len(nums) - 2):
            a = nums[i]
            if a > 0:
                break
            if i > 0 and a == nums[i - 1]:
                continue
            l, r = i + 1, len(nums) - 1
            while l < r:
                b, c = nums[l], nums[r]
                sum = a + b + c
                if sum == 0:
                    res.append([a, b, c])
                    l += 1
                    r -= 1
                    while nums[l] == nums[l - 1] and l < r:
                        l += 1
                elif sum < 0:
                    l += 1
                else:
                    r -= 1
        return res