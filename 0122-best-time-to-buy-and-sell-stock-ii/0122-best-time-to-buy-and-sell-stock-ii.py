class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        i, profit = 0, 0
        while i + 1 < len(prices):
            if prices[i + 1] <= prices[i]:
                i += 1
            else:
                j = i
                while j + 1 < len(prices) and prices[j] < prices[j + 1]:
                    j += 1
                if j > i and j < len(prices):
                    profit += prices[j] - prices[i]
                i = j
        return profit