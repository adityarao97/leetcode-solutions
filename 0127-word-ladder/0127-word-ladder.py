class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        #it'll contain a map of pattern and list of all words that match the pattern
        nei = collections.defaultdict(list)
        #create adj. list for all possible patterns of character, * is used to identify the wild card
        for word in wordList:
            for j in range(len(word)):
                pattern = word[:j] + "*" + word[j + 1:]
                nei[pattern].append(word)
        #do a bfs traversal to find the shortest path which is the result
        visited = set([beginWord])
        q = deque([beginWord])
        res = 1
        while q:
            for _ in range(len(q)):
                word = q.popleft()
                if word == endWord:
                    return res
                for j in range(len(word)):
                    pattern = word[:j] + "*" + word[j + 1:]
                    for neighbour in nei[pattern]:
                        if neighbour not in visited:
                            visited.add(neighbour)
                            q.append(neighbour)
            res += 1
        return 0