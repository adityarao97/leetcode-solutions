class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        #intuition : We use dynamic programming to count how many unique combinations of coins can make each amount up to the target.
        #Each dp[a] accumulates ways by adding the number of ways to make a - coin for every coin.
        dp = [0] * (amount + 1)
        dp[0] = 1
        for coin in coins:
            for a in range(1, amount + 1):
                dp[a] += dp[a - coin] if a >= coin else 0
        return dp[amount]