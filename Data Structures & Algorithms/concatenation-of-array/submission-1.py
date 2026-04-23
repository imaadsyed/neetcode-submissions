class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        arr = []

        for i in range(0, 2*len(nums)):
            num = nums[i % len(nums)]
            arr.append(num)


        return arr