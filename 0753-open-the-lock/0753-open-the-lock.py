class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        #intuition : bfs to find minimum path, we start with 0000 and for each digit we increase 1 or decrease 1, we add these to q and do a bfs until we find target
        #deadends are added in visited and checked for negative cases
        if "0000" in deadends:
            return -1

        def children(lock):
            res = []
            for i in range(4):
                #add a digit, we do a modulo operation to handle 9 -> 0 cases
                digit = str((int(lock[i]) + 1) % 10)
                res.append(lock[:i] + digit + lock[i+1:])
                #subtract a digit, we do a modulo opertation after adding 10 to handle negative cases 0 -> 9 ((0 - 1 + 10) % 10 = 9)
                digit = str((int(lock[i]) - 1 + 10) % 10)
                res.append(lock[:i] + digit + lock[i+1:])
            return res

        q = deque()
        q.append(["0000", 0]) # q contains the lock value and the total number of turns it takes to reach this lock
        visited = set(deadends) # visited set to store the deadends value so that they can be ignored in single check of visited
        while q:
            lock, turns = q.popleft()
            if lock == target:
                return turns
            for child in children(lock):
                if child not in visited:
                    visited.add(child)
                    q.append([child, turns + 1])
        return -1