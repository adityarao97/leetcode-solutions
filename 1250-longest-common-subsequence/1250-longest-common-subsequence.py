class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        #initialise a 2d array of size mxn with 0
        dp = [[0 for j in range(len(text2) + 1)] for i in range(len(text1) + 1)]

        #loop across each character from bottom to up
        for i in range(len(text1) - 1, -1, -1):
            for j in range(len(text2) - 1, -1, -1):
#if characters are same we take 1(because it is a match) and add the bottom diagonal value
                if text1[i] == text2[j]:
                    dp[i][j] = 1 + dp[i+1][j+1]
                else:
#if characters are not same we take the max of right and left cell values as we want to check the LCS of other part of both the string
                    dp[i][j] = max(dp[i+1][j], dp[i][j+1])
        return dp[0][0]