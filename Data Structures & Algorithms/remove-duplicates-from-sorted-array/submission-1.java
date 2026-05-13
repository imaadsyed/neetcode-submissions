class Solution {
    public int removeDuplicates(int[] nums) {
        int write = 0;
        int dupCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[write]) {
                dupCount++;
                continue;
            }
            nums[++write] = nums[i];
        }

        return nums.length - dupCount + 1;
    }
}

// time complexity: O(n)
// space complexity: O(1)