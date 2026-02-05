class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()
        def dfs(i, curSum, subset):
            if curSum == target:
                res.append(subset.copy())
                return
            if i >= len(candidates) or curSum > target:
                return
            subset.append(candidates[i])
            dfs(i + 1, curSum + candidates[i], subset)
            subset.pop()
            while i + 1 < len(candidates) and candidates[i] == candidates[i + 1]:
                i += 1
            dfs(i + 1, curSum, subset)
        dfs(0, 0, [])
        return res
