class Solution {
    public int removeDuplicates(int[] nums) {
        int write = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[write]) {
                count++;
                continue;
            }
            nums[++write] = nums[i];
        }

        return nums.length - count + 1;
    }
}