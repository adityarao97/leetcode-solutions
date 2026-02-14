class Trie:
    def __init__(self):
        self.children = {}
        self.isWord = False

class TrieNode:
    def __init__(self, words):
        self.root = Trie()
        for w in words:
            curr = self.root
            for c in w:
                if c not in curr.children:
                    curr.children[c] = Trie()
                curr = curr.children[c]
            curr.isWord = True

class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        dp = {}
        dp[len(s)] = 0
        trie = TrieNode(dictionary)
        def dfs(i):
            if i in dp:
                return dp[i]
            dp[i] = 1 + dfs(i + 1) # skip current character
            curr = trie.root
            for j in range(i, len(s)):
                if s[j] not in curr.children:
                    break
                curr = curr.children[s[j]]
                if curr.isWord:
                    dp[i] = min(dp[i], dfs(j + 1))
            return dp[i]
        return dfs(0)