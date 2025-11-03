class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        #adjacency list for mapping course against a list of prerequisites
        preMap = {i:[] for i in range(numCourses)}
        for crs, pre in prerequisites:
            preMap[crs].append(pre)
        visitSet = set()
        def dfs(crs):
            #false base case where we detect a loop
            if crs in visitSet:
                return False
            #if not pre requisite exist for a course we return True as its possible
            if preMap[crs] == []:
                return True
            visitSet.add(crs)
            for pre in preMap[crs]:
                if not dfs(pre):
                    return False
            visitSet.remove(crs)
            #mark the course as empty prereq so as to avoid repetition
            preMap[crs] = []
            return True
        for crs in range(numCourses):
            if not dfs(crs):
                return False
        return True