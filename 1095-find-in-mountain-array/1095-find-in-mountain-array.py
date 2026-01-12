# """
# This is MountainArray's API interface.
# You should not implement it, or speculate about its implementation
# """
#class MountainArray:
#    def get(self, index: int) -> int:
#    def length(self) -> int:

class Solution:
    def findInMountainArray(self, target: int, mountainArr: 'MountainArray') -> int:
        length = mountainArr.length()
        l, r = 1, length - 2
        #binary search to find peak element
        while l <= r:
            m = (l + r) // 2
            left = mountainArr.get(m - 1)
            mid = mountainArr.get(m)
            right = mountainArr.get(m + 1)
            #condition to find the peak element
            if left < mid > right:
                break
            elif left < mid < right:
                l = m + 1
            else:
                r = m - 1
        peak = m
        l, r = 0 , peak
        #binary search in first half of the array which is in increasing order till peak
        while l <= r:
            m = (l + r) // 2
            mid = mountainArr.get(m)
            if target == mid:
                return m
            if target < mid:
                r = m - 1
            else:
                l = m + 1
        l, r = peak + 1, length - 1
        #binary search in second hald of the array which is in decreasing order
        while l <= r:
            m = (l + r) // 2
            mid = mountainArr.get(m)
            if target == mid:
                return m
            elif target < mid:
                l = m + 1
            else:
                r = m - 1
        return -1