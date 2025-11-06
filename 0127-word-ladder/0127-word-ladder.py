class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        #intuition : turn all words into a wild card ex: dog -> *og, d*g, do* -> then map them to the list of all words in wordlist
        #do a bfs traversal using a queue and visited set to start from begin word and try to reach end word -> you'll get the min path
        if endWord not in wordList:
            return 0
        wordPattern = defaultdict(list)
        for word in wordList:
            for j in range(len(word)):
                pattern = word[:j] + "*" + word[j+1:]
                wordPattern[pattern].append(word)
        q = deque([beginWord])
        visited = set([beginWord])
        result = 1
        while q:
            for _ in range(len(q)):
                word = q.popleft()
                if word == endWord:
                    return result
                for j in range(len(word)):
                    pattern = word[:j] + "*" + word[j+1:]
                    for nextWord in wordPattern[pattern]:
                        if nextWord not in visited:
                            visited.add(nextWord)
                            q.append(nextWord)
            result += 1
        return 0