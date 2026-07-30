class Solution:
    def isValid(self, s: str) -> bool:
        bracketMap = { '(': ')', '[': ']', '{': '}' }
        stack = []
        for ch in s:
            if ch in bracketMap:
                stack.append(ch)
            else:
                if stack and ch == bracketMap[stack[-1]]:
                    stack.pop()
                else:
                    return False
        return True if not stack else False 