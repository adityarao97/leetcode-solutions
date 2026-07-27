class Solution:
    def minEdgeReversals(self, n: int, edges: List[List[int]]) -> List[int]:
        graph = [[] for _ in range(n)]
        for node, nei in edges:
            graph[node].append((nei, 0))
            graph[nei].append((node, 1))
        res = [0] * n
        parent = [-1] * n
        order = []
        stack = [0]
        while stack:
            node = stack.pop()
            order.append(node)
            for nei, cost in graph[node]:
                if nei == parent[node]:
                    continue
                parent[nei] = node
                res[0] += cost
                stack.append(nei)
        for node in order:
            for nei, cost in graph[node]:
                if parent[nei] != node:
                    continue
                if cost == 0:
                    res[nei] = res[node] + 1
                else:
                    res[nei] = res[node] - 1
        return res