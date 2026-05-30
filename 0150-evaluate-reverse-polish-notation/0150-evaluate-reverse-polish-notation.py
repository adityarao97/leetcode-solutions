class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for i in range(len(tokens)):
            ch = tokens[i]
            if ch == '+' or ch == '-' or ch == '*' or ch == '/':
                a = stack.pop()
                b = stack.pop()
                if ch == '+':
                    stack.append(b + a)
                elif ch == '-':
                    stack.append(b - a)
                elif ch == '*':
                    stack.append(b * a)
                else:
                    stack.append(math.trunc(b / a))
            else:
                val = int(ch)
                stack.append(val)
        return stack.pop()