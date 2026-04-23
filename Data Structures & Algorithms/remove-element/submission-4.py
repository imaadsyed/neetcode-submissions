class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        cur = 0
        for i in range(len(nums)):
            if nums[i] != val:
                # swap
                nums[cur] = nums[i]

                cur = cur + 1
        return cur
