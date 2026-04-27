class Solution {
    public void sortColors(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int j = i - 1;

            while (j >= 0 && cur < nums[j]) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = cur;
        }
    }
}