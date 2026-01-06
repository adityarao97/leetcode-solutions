class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        #intuition: we try to pair the heaviest people with the lightest people so as to minimize the number of boats req.
        #for this we first sort the array and keep a pointer at the end and one at the start 
        people.sort()
        res = 0
        l, r = 0, len(people) - 1
        while l <= r:
            remain = limit - people[r]
            r -= 1
            res += 1
            if l <= r and remain >= people[l]:
                l += 1
        return res