class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        #intuition : we want to calculate the dp[amount] min count of coins to sum up to amount, we initialize each value of dp with amount + 1 as that will be the max value for each amount   
        #we start from dp[0] = 0 => min number of coins it takes to sum upto 0 
        dp = (amount + 1) * [amount + 1]
        dp[0] = 0
        for a in range(1, amount + 1):
            for coin in coins:
                #only proceed if amount - coin is greater than 0(eg. a = 7 coin = 4, we want to check first if 7-4 >= 0)
                if a - coin >= 0:
                    #dp[7] = dp[7] {if it is already calculated} or 1 + dp[3] whichever is minimum
                    dp[a] = min(dp[a], 1 + dp[a-coin])
        return dp[amount] if dp[amount] != amount + 1 else - 1