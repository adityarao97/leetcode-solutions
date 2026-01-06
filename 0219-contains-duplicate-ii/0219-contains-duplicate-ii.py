class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        counter = Counter(nums)
        for i in range(len(nums) - 1):
            if counter[nums[i]] > 1:
                for j in range(i + 1, len(nums)):
                    if nums[i] == nums[j]:
                        if abs(i - j) <= k:
                            return True
                        else:
                            break
        return False