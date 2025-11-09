class Solution:
    def maxProfit(self, prices: List[int]) -> int:
    #state = buying or selling, if buying i = i + 1 if selling i = i + 2(mandatory cooldown)
    #key -> (i, buying) -> val = max_profit
        dp = {}
        n = len(prices)
        def dfs(i, buying):
            #return profit as 0 if we go out of bounds
            if i >= n:
                return 0
            if (i, buying) in dp:
                return dp[(i, buying)]
            cooldown = dfs(i + 1, buying)
            if buying:
                #if we are buying we will calc. new profit = current profit - current price
                buy = dfs(i + 1, not buying) - prices[i]
                #store the max decision in dp either buying or cooldown
                dp[(i, buying)] = max(cooldown, buy)
            else:
                #if we are selling we will calc. new profit = current profit + current price
                sell = dfs(i + 2, not buying) + prices[i]
                dp[(i, buying)] = max(cooldown, sell)
            return dp[(i, buying)]
        return dfs(0, True)