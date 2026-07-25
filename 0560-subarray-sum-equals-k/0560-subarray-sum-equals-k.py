class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res, curSum = 0, 0
        prefixSum = { 0 : 1 }
        for n in nums:
            curSum += n
            diff = curSum - k
            if diff in prefixSum:
                res += prefixSum[diff]
            prefixSum[curSum] = 1 + prefixSum.get(curSum, 0)
        return res