class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        subset = []
        def dfs(i):
            if i == len(nums):
                res.append(subset.copy())
                return
            #include all values with nums[i]
            subset.append(nums[i])
            dfs(i+1)
            #include all values without nums[i]
            subset.pop()
            #skip same values
            while i + 1 < len(nums) and nums[i] == nums[i+1]:
                i += 1
            dfs(i+1)
        dfs(0)
        return res