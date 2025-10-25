class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        #initialise a prices array for all cities with infinity cost to reach
        prices = [float("inf")] * n
        #cost to reach source city will be 0
        prices[src] = 0
        #loop for k+1 times(let's say k = 1 for 1st iteration we will be going for 1st bfs but since here k means that there can be 1 stop in between src,dst we would want to do another iteration hence k+1 loops)
        for _ in range(k + 1):
            #tmp prices will contain the price of reaching each dst for the current loop
            tmpPrices = prices.copy()
            for s, d, p in flights:
                if prices[s] != float("inf"):
                    #compare cost to reach dest in tmpPrices with current cost and update if it is less
                    if prices[s] + p < tmpPrices[d]:
                        tmpPrices[d] = prices[s] + p
            prices = tmpPrices
        return -1 if prices[dst] == float("inf") else prices[dst]