class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        total = len(nums1) + len(nums2)
        half = total // 2
        #A will have less elements and we want to run binary search on it
        A, B = nums1, nums2
        if len(B) < len(A):
            A, B = B, A
        l, r = 0, len(A) - 1
        while True:
            #mid of A
            i = (l + r) // 2
            #mid of B
            j = half - i - 2
            Aleft = A[i] if i >= 0 else float("-inf")
            Aright = A[i + 1] if (i + 1) < len(A) else float("inf")
            Bleft = B[j] if j >= 0 else float("-inf")
            Bright = B[j + 1] if (j + 1) < len(B) else float("inf")
            #correct partition case
            if Aleft <= Bright and Bleft <= Aright:
                #odd case
                if total % 2 != 0:
                    return min(Aright, Bright)
                #even case
                return (max(Aleft, Bleft) + min(Aright, Bright))/2
            elif Aleft > Bright:
                r = i - 1
            else:
                l = i + 1