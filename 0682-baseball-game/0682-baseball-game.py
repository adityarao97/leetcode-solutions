class Solution:
    def calPoints(self, operations: List[str]) -> int:
        stack, res = [], 0
        for operation in operations:
            if operation == "+":
                stack.append(stack[-1] + stack[-2])
                res += stack[-1]    
            elif operation == "D":
                stack.append(stack[-1] * 2)
                res += stack[-1]
            elif operation == "C":
                res -= stack[-1]
                stack.pop()
            else:
                stack.append(int(operation))
                res += stack[-1]
        return res