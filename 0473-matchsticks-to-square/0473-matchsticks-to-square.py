class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        sumLength = sum(matchsticks)
        if sumLength % 4 != 0:
            return False
        sideLength = sumLength // 4
        sides = [0] * 4
        matchsticks.sort(reverse = True)
        def dfs(i):
            if i == len(matchsticks):
                return True
            for j in range(4):
                if sides[j] + matchsticks[i] <= sideLength:
                    sides[j] += matchsticks[i]
                    if dfs(i + 1): return True
                    sides[j] -= matchsticks[i]
                if sides[j] == 0:
                    break
            return False
        return dfs(0)
