class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        #create an adjacency list mapping src to all dst in lexicographically reverse order
        adj = defaultdict(list)
        for src, dst in sorted(tickets)[::-1]:
            adj[src].append(dst)
        res = []
        def dfs(src):
            while adj[src]:
                #we will pop the last value from the list(one ticket should only be used) which will be in lexicographically increasing order
                dst = adj[src].pop()
                #recursively call with the dst node
                dfs(dst)
            #when the while loop stops we have reached the end of the last dst which we want to append
            res.append(src)
        #call dfs with source node of 'jfk'
        dfs('JFK')
        #return res in reverse order as we append last node encountered first
        return res[::-1]