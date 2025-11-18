class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        #intuition : we will use a frequency map to store all entries from hand, we will put this in a min heap, we want to start from the lowest value and create groups of group size in increments, if any value doesn't exist in freqmap return false as sequence is broken, if the total value in map is 0, we check if that matches with minHeap latest value (return false if it doesn't exist) and we pop it   
        #if hand is not divisible by group size return False
        if len(hand) % groupSize != 0:
            return False
        freq = defaultdict(int)
        for n in hand:
            freq[n] = freq.get(n, 0) + 1
        minH = list(freq.keys())
        heapq.heapify(minH)
        while minH:
            first = minH[0]
            #dividing in group sizes and incrementing each value
            for i in range(first, first + groupSize):
                if i not in freq:
                    return False
                freq[i] -= 1
                if freq[i] == 0:
                    if minH[0] != i:
                        return False
                    heapq.heappop(minH)
        return True