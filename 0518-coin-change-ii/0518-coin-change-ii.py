class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
#store calculated values in cache by index and amount, make decisions by picking current index and by not picking to generate unique combinations
        cache = {}
        def dfs(i, a):
            if a == amount:
                return 1
            #boundary condition for amount
            if a > amount:
                return 0
            #boundary condition for index
            if i == len(coins):
                return 0
            if (i, a) in cache:
                return cache[(i, a)]
            #either we pick the same coin and stay on the same index or we pick the next index for the same amount
            cache[(i, a)] = dfs(i, a + coins[i]) + dfs(i + 1, a)
            return cache[(i, a)]
        return dfs(0, 0)