class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        numToFind = 1
        counter = 0
        currMax = 0
        
        for num in nums:
            if num == numToFind:
                counter = counter + 1
                if counter > currMax:
                    currMax = counter
            else:
                # Reset counter
                counter = 0
            
        
        return currMax