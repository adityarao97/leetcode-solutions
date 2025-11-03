class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        #create an adjacency list by mapping each course to the list of prerequisites
        preMap = { i : [] for i in range(numCourses) }
        for crs, pre in prerequisites:
            preMap[crs].append(pre)
        #cycle set is to check if there's a cycle detected in current path of dfs
        cycle = set()
        #visited set is to mark a node if it can be successfully added to result 
        visited = set()
        #result array is to add nodes which can be visited
        res = []
        def dfs(crs):
            if crs in cycle:
                return False
            if crs in visited:
                return True
            #add the current course in path to cycle set
            cycle.add(crs)
            #do dfs recursively for its prereqs.
            for pre in preMap[crs]:
                #if there's a cycle in current path return False
                if dfs(pre) == False:
                    return False
            #no cycle was detected in the current path of crs we can remove it from cycle and it to visited and res
            cycle.remove(crs)
            visited.add(crs)
            res.append(crs)
            return True
        for crs in range(numCourses):
            if dfs(crs) == False:
                return []
        return res
        
