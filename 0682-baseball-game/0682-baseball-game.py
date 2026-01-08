class Solution:
    def calPoints(self, operations: List[str]) -> int:
        stack = []
        for operation in operations:
            if operation == "C":
                stack.pop()
            elif operation == "D":
                stack.append(stack[-1] * 2)
            elif operation == "+":
                first = stack.pop()
                second = stack.pop()
                stack.append(second)
                stack.append(first)
                stack.append(first + second)
            else:
                stack.append(int(operation))
        res = 0
        while len(stack) > 0:
            res += stack.pop()
        return res