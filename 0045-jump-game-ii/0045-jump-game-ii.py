class Solution:
    def jump(self, nums: List[int]) -> int:
        #intuition : we keep l and r pointers which contains the max step we can reach from previous boundaries
        #initialize l and r to 0, obtain the farthest you can go with each element between l and r until you reach the end
        #calculate l = r + 1 and r = farthest for every boundary, total steps will be equal to each such calculation
        l = r = 0
        steps = 0
        while r < len(nums) - 1:
            farthest = 0
            for i in range(l, r + 1):
                farthest = max(farthest, i + nums[i]) #you can reach from current value is i + nums[i]
            l = r + 1
            r = farthest
            steps += 1
        return steps