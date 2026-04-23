class Solution:
    def getFirstOccurenceOfVal(self, nums, val):
        lPtr = 0
        # Get rPtr to the first index that is pointing to val.
        while(lPtr < len(nums)):
            if nums[lPtr] == val:
                break

            lPtr = lPtr + 1
        
        print(nums ,lPtr)
        return lPtr

    def removeElement(self, nums: List[int], val: int) -> int:
        lPtr = 0
        cur = 0

        if len(nums) == 0:
            return 0
        
        for num in nums:
            lPtr = self.getFirstOccurenceOfVal(nums, val)
            # print(num, lPtr, cur)
            if cur > lPtr and nums[lPtr] == val:
                # SWAP
                print("num=", num, "lPtr=", lPtr, "cur=", cur)
                tmp = nums[lPtr]
                nums[lPtr] = nums[cur]
                nums[cur] = tmp
            
            cur = cur + 1
            if cur == len(nums):
                break

        return self.getFirstOccurenceOfVal(nums, val)

    