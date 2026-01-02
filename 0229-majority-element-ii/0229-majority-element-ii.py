class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        count = Counter(nums)
        byThree = len(nums)//3
        res = []
        for key, value in count.items():
            if value > byThree:
                res.append(key)
        return res