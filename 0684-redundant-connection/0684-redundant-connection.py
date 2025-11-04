#intuition : run a dfs with first node, try to find the cycle, note where the cycle starts and start adding it to cycle set in reverse, then reverse the edges list and check which node exists in the cycle set and return it
class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        #create adjacency list of n + 1 edges as we want to include the n'th node
        adj = { i : [] for i in range(n + 1) }
        for n1, n2 in edges:
            adj[n1].append(n2)
            adj[n2].append(n1)
        visited = set()
        #cycle set will include all nodes encountered in the cycle
        cycle = set()
        cyclestart = -1
        def dfs(node, parent):
            #nonlocal keyword is used to pick variable value from out of the function
            nonlocal cyclestart
            #if we encounter the same node we've detected a cycle and we return true
            if node in visited:
                cyclestart = node
                return True
            visited.add(node)
            #check recursively for neighbouring nodes
            for nei in adj[node]:
                if nei != parent:
                    if dfs(nei, node):
                        #dfs is true this element is part of cycle so we add it to the cycle node 
                        if cyclestart != -1:
                            cycle.add(node)
                        #we've reached the first node in the cycle so we set it to -1
                        if cyclestart == node:
                            cyclestart = -1
                        return True
            return False
        
        dfs(1, -1)
        for n1, n2 in reversed(edges):
            if n1 in cycle and n2 in cycle:
                return [n1, n2]
        return []