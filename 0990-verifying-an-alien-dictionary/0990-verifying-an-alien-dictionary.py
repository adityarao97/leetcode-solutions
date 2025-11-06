class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        map = { ch : i for i, ch in enumerate(order) }
        for i in range(len(words) - 1):
            w1, w2 = words[i], words[i + 1]
            for j in range(len(w1)):
                #if we reach the end of w2 without finding a difference in character between w1 and w2 we return false ex: w1 = app w2 = apple
                if j == len(w2):
                    return False
                #compare the characters if they're not the same
                if w1[j] != w2[j]:
                    #if w1 is lexicographically greater than w2 return False ex: w1 = app w2 = abb (p comes after b) 
                    if map[w1[j]] > map[w2[j]]:
                        return False
                    #if the above condition fails we have a valid word so we break to check the other adjacent words ex: w1 = abb w2 = app (valid)
                    break
        return True