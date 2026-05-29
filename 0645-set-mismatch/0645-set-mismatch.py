class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        unique = set()
        res = []
        for i in range(len(nums)):
            if nums[i] in unique:
                res.append(nums[i])
            else:
                unique.add(nums[i])
        for i in range(len(unique)):
            if i + 1 not in unique:
                res.append(i + 1)
        if len(res) != 2:
            res.append(len(nums))
        return res
        