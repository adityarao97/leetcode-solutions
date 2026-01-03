class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res, curSum = 0, 0
        prefixSums = {0 : 1}
        for n in nums:
            curSum += n
            diff = curSum - k
            if diff in prefixSums:
                res += prefixSums[diff]    
            prefixSums[curSum] = 1 + prefixSums.get(curSum, 0)
        return res