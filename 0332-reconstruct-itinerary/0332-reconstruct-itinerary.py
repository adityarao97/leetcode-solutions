class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        #create a new adjacency list to store src and dest tickets in reverse alphabetical order
        adj = defaultdict(list)
        for src, dst in sorted(tickets)[::-1]:
            adj[src].append(dst)
        res = []
        def dfs(src):
            while adj[src]:
                #we get lexicographically first value first as it is appended to the end of the list
                dst = adj[src].pop()
                dfs(dst)
            #when we reach the end of all the neighbours we start appending the lexicographically least value to the list
            res.append(src)
        dfs('JFK')
        return res[::-1]
