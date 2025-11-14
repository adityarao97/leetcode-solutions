class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        #intuition : at every step we have 3 choices to make - add, delete or replace, we use a 2d array to store the min number of steps used to convert a character at that index from word1 to word2 (word1 is column and word2 is row), initialize the border rows and columns bottom right most cell will be 0 - 0 operations needed for making any change as all characters from either side is exhausted, if we go bottom right cell to top cell we will keep increasing by 1 as we need to just delete 1 character, if we go from left to right in bottom column we should decrease by 1 as we need to add a single character
        
        cache = [[float("inf")] * (len(word2) + 1) for _ in range(len(word1) + 1)]
        for j in range(len(word2) + 1):
            cache[len(word1)][j] = len(word2) - j
        for i in range(len(word1) + 1):
            cache[i][len(word2)] = len(word1) - i
        for i in range(len(word1) - 1, -1 , -1):
            for j in range(len(word2) - 1, -1, -1):
                if word1[i] == word2[j]:
                    cache[i][j] = cache[i + 1][j + 1]
                else:
                    cache[i][j] = 1 + min(cache[i + 1][j], cache[i][j + 1], cache[i + 1][j + 1])
        return cache[0][0]