class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        freq = defaultdict(int)
        for i in range(len(nums)):
            freq[nums[i]] += 1
        for i in range(len(nums)):
            if freq[nums[i]] == 1:
                return nums[i]
        return 0