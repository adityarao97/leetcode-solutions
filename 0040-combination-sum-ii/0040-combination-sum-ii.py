class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()
        def dfs(i, cur, total):
            if target == total:
                res.append(cur.copy())
                return
            if i >= len(candidates) or total > target:
                return
            #include elements in cur
            cur.append(candidates[i])
            dfs(i+1, cur, total + candidates[i])
            #don't include elements in cur
            cur.pop()
            while i + 1 < len(candidates) and candidates[i]==candidates[i+1]:
                i += 1
            dfs(i+1, cur, total)
        dfs(0, [], 0)
        return res