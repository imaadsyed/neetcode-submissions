class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        newArr = []
        for i in range(len(arr)):
            max = -1
            # find Max
            for j in range(i+1, len(arr)):
                num = arr[j]
                if num > max:
                    max = num 
            
            newArr.append(max)
            
        return newArr
