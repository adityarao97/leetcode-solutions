class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        unique = set(nums)
        res = []
        for i in range(1, len(nums) + 1):
            if i not in unique:
                res.append(i)
        return res