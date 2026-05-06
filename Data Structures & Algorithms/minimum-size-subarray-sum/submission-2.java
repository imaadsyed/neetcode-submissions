class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int minWindow = 100001;
        int windowSum = 0;
        for (int r = 0; r < nums.length; r++) {
            windowSum += nums[r];
            while (windowSum >= target) {
                minWindow = Math.min(minWindow, r - l + 1);
                windowSum -= nums[l];
                l++;
            }
        }

        return minWindow == 100001 ? 0 : minWindow;
    }
}