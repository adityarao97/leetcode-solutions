class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        #town judge trusts nobody -> incoming edge = 0
        #everybody except the town judge trusts the town judge -> outgoing edge = n - 1
        # if both these conditions are true for such a case town judge exists and we return the value of n
        # we maintain a map of incoming and outgoing edges for each person and traverse it to find if there's a node for which both the conditions are true
        incoming, outgoing  = defaultdict(int), defaultdict(int)
        for t1, t2 in trust:
            incoming[t2] += 1
            outgoing[t1] += 1
        for i in range(1, n + 1):
            if incoming[i] == n - 1 and outgoing[i] == 0:
                return i
        return -1