class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        stack = []
        def backtrack(openN, closedN):
            #base case - append to result if opencount == closedcount == n
            if openN == closedN == n:
                res.append("".join(stack.copy()))
                return
            #create combinations where open braces can be added -> if and only if openCount is less than n
            if openN < n:
                stack.append("(")
                backtrack(openN + 1, closedN)
                stack.pop()
            #create combinations where closed braces can be added -> if and only if closedCount is less than openCount 
            if closedN < openN:
                stack.append(")")
                backtrack(openN, closedN + 1)
                stack.pop()
        backtrack(0, 0)
        return res