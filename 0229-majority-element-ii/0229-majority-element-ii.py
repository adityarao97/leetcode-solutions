class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        count = Counter(nums)
        byThree = len(nums)//3
        res = []
        for key in count:
            if count[key] > byThree:
                res.append(key)
        return res