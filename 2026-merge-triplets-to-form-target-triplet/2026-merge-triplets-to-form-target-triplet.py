class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        #intuition : for any element within the triplet if it is lesser than the target value in the index we ignore that as we can't possibly create the target triplet with them, we check for the rest values if we encounter a single match we add it to the set, if the set has 3 values we have found our target triplet
        good = set()
        for t in triplets:
            if t[0] > target[0] or t[1] > target[1] or t[2] > target[2]:
                continue
            for i, v in enumerate(t):
                if v == target[i]:
                    good.add(i)
        return len(good) == 3