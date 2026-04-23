class Solution:
    def calPoints(self, operations: List[str]) -> int:
        stack = []
        for c in operations:
            print(stack)
            if c == '+':
                result = stack[-1] + stack[-2]
                stack.append(result)
            elif c == 'D':
                result = stack[-1]  * 2
                stack.append(result)
            elif c == 'C':
                stack.pop(-1)
            else:
                stack.append(int(c))

        result = 0
        for num in stack:
            result += num
        
        return result