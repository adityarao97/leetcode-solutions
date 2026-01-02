class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        #from each point in the array we want to see if we can reach a larger value from a smaller value - we will sell stock from smaller point to the larger point to maximize profitability
        i, profit = 0, 0
        while i + 1 < len(prices):
            #ignore cases when consecutive stock prices are decreasing
            if prices[i + 1] <= prices[i]:
                i += 1
            else:
                j = i
                #obtain the monotonically largest increasing value and sell it on that day
                while j + 1 < len(prices) and prices[j] < prices[j + 1]:
                    j += 1
                if j > i and j < len(prices):
                    profit += prices[j] - prices[i]
                i = j
        return profit