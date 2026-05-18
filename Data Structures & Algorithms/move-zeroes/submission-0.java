class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int j = i + 1;
                while(j < nums.length && nums[j] == 0) {
                    // find first occurrence of non-zero value
                    j++;
                }
                if (j == nums.length) {
                    // all zeroes to end already
                    break;
                }
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
    }
}