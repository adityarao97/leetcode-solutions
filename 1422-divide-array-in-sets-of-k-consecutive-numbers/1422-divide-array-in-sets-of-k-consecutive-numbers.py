class Solution:
    def isPossibleDivide(self, nums: List[int], k: int) -> bool:
        if len(nums) % k != 0:
            return False
        freq = defaultdict(int)
        for n in nums:
            freq[n] = 1 + freq.get(n, 0)
        minH = list(freq.keys())
        heapq.heapify(minH)
        while(minH):
            first = minH[0]
            for i in range(first, first + k):
                if i not in freq:
                    return False
                freq[i] -= 1
                if freq[i] == 0:
                    if minH[0] != i:
                        return False
                    heapq.heappop(minH)
        return True