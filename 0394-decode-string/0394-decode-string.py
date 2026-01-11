class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        #loop for each character
        for i in range(len(s)):
            #append all characters until you reach closing brackets
            if s[i] != "]":
                stack.append(s[i])
            else:
                substr = ""
                #append the substring that comes within closing brackets by popping 
                while stack[-1] != "[":
                    #preserving order while creating substring
                    substr = stack.pop() + substr
                #pop the opening bracket [
                stack.pop()
                #keep popping the digits preceeding the [ to obtain k
                k = ""
                while stack and stack[-1].isdigit():
                    #preserve the order
                    k = stack.pop() + k
                #append the substring k times within the stack
                stack.append(int(k) * substr)

        return "".join(stack)