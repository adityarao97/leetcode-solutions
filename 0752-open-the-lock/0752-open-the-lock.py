class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        if "0000" in deadends or target in deadends: return -1
        q = deque()
        q.append(["0000", 0])
        visit = set(deadends)
        def bfs(lock):
            res = []
            for i in range(4):
                digit = (int(lock[i]) + 1) % 10
                res.append(lock[:i] + str(digit) + lock[i+1:])
                digit = (int(lock[i]) -1 + 10) % 10
                res.append(lock[:i] + str(digit) + lock[i+1:])
            return res
        while q:
            lock, turns = q.popleft()
            if lock == target:
                return turns
            for child in bfs(lock):
                if child not in visit:
                    visit.add(child)
                    q.append([child, turns + 1])
        return -1