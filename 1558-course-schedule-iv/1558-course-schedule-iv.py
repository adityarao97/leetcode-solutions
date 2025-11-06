class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        #adj list for mapping each course to all its prerequisites
        adj = defaultdict(list)
        for pre, crs in prerequisites:
            adj[crs].append(pre) # [0, 1] 0 is prerequisite and 1 is the course
        
        def dfs(crs):
            if crs not in prereqMap:
                #if crs is not in prereqMap we initialize a set
                prereqMap[crs] = set()
                #we traverse to all its neighbouring nodes and add them to the set
                for nei in adj[crs]:
                    prereqMap[crs] |= dfs(nei) #union of existing and neighbouring nodes
                prereqMap[crs].add(crs) #add the crs itself before returning to parent node
            return prereqMap[crs]

        #prereqMap will store all direct and indirect edges for each course crs -> set()
        prereqMap = {}
        for crs in range(numCourses):
            dfs(crs)    #this dfs call will populate all direct + indirect prereq courses for each course
        
        res = []
        #we will return true if for a course v we have a course u in the prereqMap
        for u, v in queries:
            res.append(u in prereqMap[v])
        return res
         