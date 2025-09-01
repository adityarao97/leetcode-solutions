class Solution:
    def isValid(self, s: str) -> bool:
        dict_br = { 
            '}': '{', 
            ']': '[', 
            ')': '('
        }
        l_set = {'.', '}', ']', ')'}

        l = -1

        for r in range(0, len(s), 1):
            if s[r] in dict_br:
                if l != -1 and dict_br[s[r]] == s[l]:
                    s = s[:l] + "." + s[l+1:]
                    while l >= 0 and s[l] in l_set:
                        l -= 1
                else:
                    return False
            else:
                l = r

        return True if l == -1 else False