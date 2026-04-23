class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        
        matcher = {
            ')' : '(',
            '}' : '{',
            ']' : '['
        }
        closingBrackets = matcher.keys()
        for i in range(len(s)):
            c = s[i]
            if c in closingBrackets:
                if len(stack) == 0:
                    # No matching open bracket and stack is empty.
                    return False
                o = stack.pop(-1)
                print(o, c)
                if o != matcher[c]:
                    return False
            else:
                # opening brackets
                stack.append(c)

        if len(stack) != 0:
            return False

        return True