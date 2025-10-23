class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        adj = [[] for _ in range(n + 1)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
        visited = [False] * (n + 1)
        cyclestart = -1
        cycle = set()

        def dfs(node, parent):
            nonlocal cyclestart
            if visited[node]:
                cyclestart = node
                return True
            visited[node] = True
            for nei in adj[node]:
                if nei == parent:
                    continue
                if dfs(nei, node):
                    if cyclestart != -1:
                        cycle.add(node)
                    if cyclestart == node:
                        cyclestart = -1
                    return True
            return False
        
        dfs(1, -1)
        for u, v in reversed(edges):
            if u in cycle and v in cycle:
                return [u, v]
        return []