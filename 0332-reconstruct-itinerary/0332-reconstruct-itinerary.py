class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        #create an adjacency list
        adj = defaultdict(list)
        #store src, dst in adjacaency list in reverse order, we'll later pop it and append it to result so we get results in incremented order
        for src, dst in sorted(tickets)[::-1]:
            adj[src].append(dst)
        res = []
        def dfs(src):
            while adj[src]:
                #pop the last element and call dfs from it
                dst = adj[src].pop()
                dfs(dst)
            #add the src when we reach a failure from while block
            res.append(src)
        dfs('JFK')
        return res[::-1]