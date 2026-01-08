class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l , r = 0, len(arr) - 1
        while l < r:
            mid = (l + r) // 2
            if x < arr[mid]:
                r = mid
            else:
                l = mid + 1
        
        l, r = l - 1, l
        while r - l - 1 < k:
            if l < 0:
                r += 1
            elif r >= len(arr):
                l -= 1
            else:
                left_dist = abs(arr[l] - x)
                right_dist = abs(arr[r] - x)
                if left_dist <= right_dist:
                    l -= 1
                else:
                    r += 1
        return arr[l + 1:r]
